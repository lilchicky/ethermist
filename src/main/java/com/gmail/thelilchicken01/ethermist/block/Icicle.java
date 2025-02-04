package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import com.google.common.annotations.VisibleForTesting;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Icicle extends PointedDripstoneBlock {
    public static final DirectionProperty TIP_DIRECTION;
    public static final EnumProperty<DripstoneThickness> THICKNESS;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape TIP_MERGE_SHAPE;
    private static final VoxelShape TIP_SHAPE_UP;
    private static final VoxelShape TIP_SHAPE_DOWN;
    private static final VoxelShape FRUSTUM_SHAPE;
    private static final VoxelShape MIDDLE_SHAPE;
    private static final VoxelShape BASE_SHAPE;
    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK;

    public Icicle() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.ICE)
                .forceSolidOn()
                .instrument(NoteBlockInstrument.CHIME)
                .noOcclusion()
                .sound(SoundType.GLASS)
                .randomTicks()
                .strength(1.5F, 3.0F)
                .dynamicShape()
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY));
        this.registerDefaultState(this.stateDefinition.any().setValue(TIP_DIRECTION, Direction.UP).setValue(THICKNESS, DripstoneThickness.TIP).setValue(WATERLOGGED, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
    }

    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return isValidIciclePlacement(level, pos, state.getValue(TIP_DIRECTION));
    }

    protected BlockState updateShape(BlockState state, Direction p_direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (p_direction != Direction.UP && p_direction != Direction.DOWN) {
            return state;
        } else {
            Direction direction = state.getValue(TIP_DIRECTION);
            if (direction == Direction.DOWN && level.getBlockTicks().hasScheduledTick(pos, this)) {
                return state;
            } else if (p_direction == direction.getOpposite() && !this.canSurvive(state, level, pos)) {
                if (direction == Direction.DOWN) {
                    level.scheduleTick(pos, this, 2);
                } else {
                    level.scheduleTick(pos, this, 1);
                }

                return state;
            } else {
                boolean flag = state.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
                DripstoneThickness dripstonethickness = calculateDripstoneThickness(level, pos, direction, flag);
                return (BlockState)state.setValue(THICKNESS, dripstonethickness);
            }
        }
    }

    protected void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        if (!level.isClientSide) {
            BlockPos blockpos = hit.getBlockPos();
            if (projectile.mayInteract(level, blockpos) && projectile.mayBreak(level) && projectile instanceof ThrownTrident && projectile.getDeltaMovement().length() > 0.6) {
                level.destroyBlock(blockpos, true);
            }
        }

    }

    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        DamageSource damageSource = new DamageSource(
                level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(EMDamageTypes.ICICLE), entity
        );
        if (state.getValue(TIP_DIRECTION) == Direction.UP && state.getValue(THICKNESS) == DripstoneThickness.TIP) {
            entity.causeFallDamage(fallDistance + 2.0F, 2.0F, damageSource);
        } else {
            super.fallOn(level, state, pos, entity, fallDistance);
        }

    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (canDrip(state)) {
            float f = random.nextFloat();
            if (!(f > 0.12F)) {
                getFluidAboveStalactite(level, pos, state).filter((p_221848_) -> f < 0.02F);
            }
        }

    }

    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isStalagmite(state) && !this.canSurvive(state, level, pos)) {
            level.destroyBlock(pos, true);
        } else {
            spawnFallingStalactite(state, level, pos);
        }

    }

    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        maybeTransferFluid(state, level, pos, random.nextFloat());
        if (random.nextFloat() < 0.011377778F && isStalactiteStartPos(state, level, pos)) {
            growStalactiteOrStalagmiteIfPossible(state, level, pos, random);
        }

    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor levelaccessor = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Direction direction = context.getNearestLookingVerticalDirection().getOpposite();
        Direction direction1 = calculateTipDirection(levelaccessor, blockpos, direction);
        if (direction1 == null) {
            return null;
        } else {
            boolean flag = !context.isSecondaryUseActive();
            DripstoneThickness dripstonethickness = calculateDripstoneThickness(levelaccessor, blockpos, direction1, flag);
            return dripstonethickness == null ? null : (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(TIP_DIRECTION, direction1)).setValue(THICKNESS, dripstonethickness)).setValue(WATERLOGGED, levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER);
        }
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        DripstoneThickness dripstonethickness = (DripstoneThickness)state.getValue(THICKNESS);
        VoxelShape voxelshape;
        if (dripstonethickness == DripstoneThickness.TIP_MERGE) {
            voxelshape = TIP_MERGE_SHAPE;
        } else if (dripstonethickness == DripstoneThickness.TIP) {
            if (state.getValue(TIP_DIRECTION) == Direction.DOWN) {
                voxelshape = TIP_SHAPE_DOWN;
            } else {
                voxelshape = TIP_SHAPE_UP;
            }
        } else if (dripstonethickness == DripstoneThickness.FRUSTUM) {
            voxelshape = FRUSTUM_SHAPE;
        } else if (dripstonethickness == DripstoneThickness.MIDDLE) {
            voxelshape = MIDDLE_SHAPE;
        } else {
            voxelshape = BASE_SHAPE;
        }

        Vec3 vec3 = state.getOffset(level, pos);
        return voxelshape.move(vec3.x, (double)0.0F, vec3.z);
    }

    protected boolean isCollisionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }

    protected float getMaxHorizontalOffset() {
        return 0.125F;
    }

    public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity fallingBlock) {
        if (!fallingBlock.isSilent() && level instanceof ServerLevel serverLevel) {
            level.playSound(null, pos, SoundEvents.GLASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, EMBlocks.ICICLE.get().defaultBlockState()),
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    5, 0.2, 0.2, 0.2, 0.1);
        }

    }

    public DamageSource getFallDamageSource(Entity entity) {
        return new DamageSource(
                entity.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(EMDamageTypes.ICICLE), entity
        );
    }

    private static void spawnFallingStalactite(BlockState state, ServerLevel level, BlockPos pos) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for(BlockState blockstate = state; isStalactite(blockstate); blockstate = level.getBlockState(blockpos$mutableblockpos)) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(level, blockpos$mutableblockpos, blockstate);
            if (isTip(blockstate, true)) {
                int i = Math.max(1 + pos.getY() - blockpos$mutableblockpos.getY(), 6);
                float f = 1.0F * (float)i;
                fallingblockentity.setHurtsEntities(f, 40);
                break;
            }

            blockpos$mutableblockpos.move(Direction.DOWN);
        }

    }

    @VisibleForTesting
    public static void growStalactiteOrStalagmiteIfPossible(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState blockstate = level.getBlockState(pos.above(1));
        BlockState blockstate1 = level.getBlockState(pos.above(2));
        if (canGrow(blockstate, blockstate1)) {
            BlockPos blockpos = findTip(state, level, pos, 7, false);
            if (blockpos != null) {
                BlockState blockstate2 = level.getBlockState(blockpos);
                if (canDrip(blockstate2) && canTipGrow(blockstate2, level, blockpos)) {
                    if (random.nextBoolean()) {
                        grow(level, blockpos, Direction.DOWN);
                    } else {
                        growStalagmiteBelow(level, blockpos);
                    }
                }
            }
        }

    }

    private static void growStalagmiteBelow(ServerLevel level, BlockPos pos) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for(int i = 0; i < 10; ++i) {
            blockpos$mutableblockpos.move(Direction.DOWN);
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.getFluidState().isEmpty()) {
                return;
            }

            if (isUnmergedTipWithDirection(blockstate, Direction.UP) && canTipGrow(blockstate, level, blockpos$mutableblockpos)) {
                grow(level, blockpos$mutableblockpos, Direction.UP);
                return;
            }

            if (isValidIciclePlacement(level, blockpos$mutableblockpos, Direction.UP) && !level.isWaterAt(blockpos$mutableblockpos.below())) {
                grow(level, blockpos$mutableblockpos.below(), Direction.UP);
                return;
            }

            if (!canDripThrough(level, blockpos$mutableblockpos, blockstate)) {
                return;
            }
        }

    }

    private static void grow(ServerLevel server, BlockPos pos, Direction direction) {
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = server.getBlockState(blockpos);
        if (isUnmergedTipWithDirection(blockstate, direction.getOpposite())) {
            createMergedTips(blockstate, server, blockpos);
        } else if (blockstate.isAir() || blockstate.is(Blocks.WATER)) {
            createDripstone(server, blockpos, direction, DripstoneThickness.TIP);
        }

    }

    private static void createDripstone(LevelAccessor level, BlockPos pos, Direction direction, DripstoneThickness thickness) {
        BlockState blockstate = (BlockState)((BlockState)((BlockState)EMBlocks.ICICLE.get().defaultBlockState().setValue(TIP_DIRECTION, direction)).setValue(THICKNESS, thickness)).setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);
        level.setBlock(pos, blockstate, 3);
    }

    private static void createMergedTips(BlockState state, LevelAccessor level, BlockPos pos) {
        BlockPos blockpos;
        BlockPos blockpos1;
        if (state.getValue(TIP_DIRECTION) == Direction.UP) {
            blockpos1 = pos;
            blockpos = pos.above();
        } else {
            blockpos = pos;
            blockpos1 = pos.below();
        }

        createDripstone(level, blockpos, Direction.DOWN, DripstoneThickness.TIP_MERGE);
        createDripstone(level, blockpos1, Direction.UP, DripstoneThickness.TIP_MERGE);
    }

    public static void spawnDripParticle(Level level, BlockPos pos, BlockState state) {
        getFluidAboveStalactite(level, pos, state).ifPresent((p_221856_) -> spawnDripParticle(level, pos, state, p_221856_.fluid));
    }

    private static void spawnDripParticle(Level level, BlockPos pos, BlockState state, Fluid p_fluid) {
        Vec3 vec3 = state.getOffset(level, pos);
        double d0 = (double)0.0625F;
        double d1 = (double)pos.getX() + (double)0.5F + vec3.x;
        double d2 = (double)((float)(pos.getY() + 1) - 0.6875F) - (double)0.0625F;
        double d3 = (double)pos.getZ() + (double)0.5F + vec3.z;
        Fluid fluid = getDripFluid(level, p_fluid);
        ParticleOptions particleoptions = (ParticleOptions)(fluid.getFluidType().getDripInfo() != null ? fluid.getFluidType().getDripInfo().dripParticle() : ParticleTypes.DRIPPING_DRIPSTONE_WATER);
        if (particleoptions != null) {
            level.addParticle(particleoptions, d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
        }

    }

    @Nullable
    private static BlockPos findTip(BlockState state, LevelAccessor level, BlockPos pos, int maxIterations, boolean isTipMerge) {
        if (isTip(state, isTipMerge)) {
            return pos;
        } else {
            Direction direction = (Direction)state.getValue(TIP_DIRECTION);
            BiPredicate<BlockPos, BlockState> bipredicate = (p_202023_, p_202024_) -> p_202024_.is(EMBlocks.ICICLE.get()) && p_202024_.getValue(TIP_DIRECTION) == direction;
            return (BlockPos)findBlockVertical(level, pos, direction.getAxisDirection(), bipredicate, (p_154168_) -> isTip(p_154168_, isTipMerge), maxIterations).orElse(null);
        }
    }

    @Nullable
    private static Direction calculateTipDirection(LevelReader level, BlockPos pos, Direction dir) {
        Direction direction;
        if (isValidIciclePlacement(level, pos, dir)) {
            direction = dir;
        } else {
            if (!isValidIciclePlacement(level, pos, dir.getOpposite())) {
                return null;
            }

            direction = dir.getOpposite();
        }

        return direction;
    }

    private static DripstoneThickness calculateDripstoneThickness(LevelReader level, BlockPos pos, Direction dir, boolean isTipMerge) {
        Direction direction = dir.getOpposite();
        BlockState blockstate = level.getBlockState(pos.relative(dir));
        if (!isIcicleWithDirection(blockstate, direction)) {
            if (!isIcicleWithDirection(blockstate, dir)) {
                return DripstoneThickness.TIP;
            } else {
                DripstoneThickness dripstonethickness = (DripstoneThickness)blockstate.getValue(THICKNESS);
                if (dripstonethickness != DripstoneThickness.TIP && dripstonethickness != DripstoneThickness.TIP_MERGE) {
                    BlockState blockstate1 = level.getBlockState(pos.relative(direction));
                    return !isIcicleWithDirection(blockstate1, dir) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
                } else {
                    return DripstoneThickness.FRUSTUM;
                }
            }
        } else {
            return !isTipMerge && blockstate.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
        }
    }

    public static boolean canDrip(BlockState state) {
        return isStalactite(state) && state.getValue(THICKNESS) == DripstoneThickness.TIP && !(Boolean)state.getValue(WATERLOGGED);
    }

    private static boolean canTipGrow(BlockState state, ServerLevel level, BlockPos pos) {
        Direction direction = (Direction)state.getValue(TIP_DIRECTION);
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = level.getBlockState(blockpos);
        if (!blockstate.getFluidState().isEmpty()) {
            return false;
        } else {
            return blockstate.isAir() || isUnmergedTipWithDirection(blockstate, direction.getOpposite());
        }
    }

    private static Optional<BlockPos> findRootBlock(Level level, BlockPos pos, BlockState state, int maxIterations) {
        Direction direction = (Direction)state.getValue(TIP_DIRECTION);
        BiPredicate<BlockPos, BlockState> bipredicate = (p_202015_, p_202016_) -> p_202016_.is(EMBlocks.ICICLE.get()) && p_202016_.getValue(TIP_DIRECTION) == direction;
        return findBlockVertical(level, pos, direction.getOpposite().getAxisDirection(), bipredicate, (p_154245_) -> !p_154245_.is(EMBlocks.ICICLE.get()), maxIterations);
    }

    private static boolean isValidIciclePlacement(LevelReader level, BlockPos pos, Direction dir) {
        BlockPos blockpos = pos.relative(dir.getOpposite());
        BlockState blockstate = level.getBlockState(blockpos);
        return blockstate.isFaceSturdy(level, blockpos, dir) || isIcicleWithDirection(blockstate, dir) || blockstate.is(EMBlocks.FROSTPINE_LEAVES);
    }

    private static boolean isTip(BlockState state, boolean isTipMerge) {
        if (!state.is(EMBlocks.ICICLE.get())) {
            return false;
        } else {
            DripstoneThickness dripstonethickness = (DripstoneThickness)state.getValue(THICKNESS);
            return dripstonethickness == DripstoneThickness.TIP || isTipMerge && dripstonethickness == DripstoneThickness.TIP_MERGE;
        }
    }

    private static boolean isUnmergedTipWithDirection(BlockState state, Direction dir) {
        return isTip(state, false) && state.getValue(TIP_DIRECTION) == dir;
    }

    private static boolean isStalactite(BlockState state) {
        return isIcicleWithDirection(state, Direction.DOWN);
    }

    private static boolean isStalagmite(BlockState state) {
        return isIcicleWithDirection(state, Direction.UP);
    }

    private static boolean isStalactiteStartPos(BlockState state, LevelReader level, BlockPos pos) {
        return isStalactite(state) && !level.getBlockState(pos.above()).is(EMBlocks.ICICLE.get());
    }

    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    private static boolean isIcicleWithDirection(BlockState state, Direction dir) {
        return state.is(EMBlocks.ICICLE) && state.getValue(TIP_DIRECTION) == dir;
    }

    private static Optional<Icicle.FluidInfo> getFluidAboveStalactite(Level level, BlockPos pos, BlockState state) {
        return !isStalactite(state) ? Optional.empty() : findRootBlock(level, pos, state, 11).map((p_221876_) -> {
            BlockPos blockpos = p_221876_.above();
            BlockState blockstate = level.getBlockState(blockpos);
            Fluid fluid;
            if (blockstate.is(Blocks.MUD) && !level.dimensionType().ultraWarm()) {
                fluid = Fluids.WATER;
            } else {
                fluid = level.getFluidState(blockpos).getType();
            }

            return new Icicle.FluidInfo(blockpos, fluid, blockstate);
        });
    }

    private static boolean canGrow(BlockState dripstoneState, BlockState state) {
        return dripstoneState.is(EMBlocks.ICICLE) && state.is(Blocks.WATER) && state.getFluidState().isSource();
    }

    private static Fluid getDripFluid(Level level, Fluid fluid) {
        if (fluid.isSame(Fluids.EMPTY)) {
            return Fluids.WATER;
        } else {
            return fluid;
        }
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection axis, BiPredicate<BlockPos, BlockState> positionalStatePredicate, Predicate<BlockState> statePredicate, int maxIterations) {
        Direction direction = Direction.get(axis, Direction.Axis.Y);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for(int i = 1; i < maxIterations; ++i) {
            blockpos$mutableblockpos.move(direction);
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (statePredicate.test(blockstate)) {
                return Optional.of(blockpos$mutableblockpos.immutable());
            }

            if (level.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) || !positionalStatePredicate.test(blockpos$mutableblockpos, blockstate)) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    private static boolean canDripThrough(BlockGetter level, BlockPos pos, BlockState state) {
        if (state.isAir()) {
            return true;
        } else if (state.isSolidRender(level, pos)) {
            return false;
        } else if (!state.getFluidState().isEmpty()) {
            return false;
        } else {
            VoxelShape voxelshape = state.getCollisionShape(level, pos);
            return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelshape, BooleanOp.AND);
        }
    }

    static {
        TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
        THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        TIP_MERGE_SHAPE = Block.box((double)5.0F, (double)0.0F, (double)5.0F, (double)11.0F, (double)16.0F, (double)11.0F);
        TIP_SHAPE_UP = Block.box((double)5.0F, (double)0.0F, (double)5.0F, (double)11.0F, (double)11.0F, (double)11.0F);
        TIP_SHAPE_DOWN = Block.box((double)5.0F, (double)5.0F, (double)5.0F, (double)11.0F, (double)16.0F, (double)11.0F);
        FRUSTUM_SHAPE = Block.box((double)4.0F, (double)0.0F, (double)4.0F, (double)12.0F, (double)16.0F, (double)12.0F);
        MIDDLE_SHAPE = Block.box((double)3.0F, (double)0.0F, (double)3.0F, (double)13.0F, (double)16.0F, (double)13.0F);
        BASE_SHAPE = Block.box((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)16.0F, (double)14.0F);
        REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box((double)6.0F, (double)0.0F, (double)6.0F, (double)10.0F, (double)16.0F, (double)10.0F);
    }

    static record FluidInfo(BlockPos pos, Fluid fluid, BlockState sourceState) {
        FluidInfo(BlockPos pos, Fluid fluid, BlockState sourceState) {
            this.pos = pos;
            this.fluid = fluid;
            this.sourceState = sourceState;
        }

        public BlockPos pos() {
            return this.pos;
        }

        public Fluid fluid() {
            return this.fluid;
        }

        public BlockState sourceState() {
            return this.sourceState;
        }
    }
}
