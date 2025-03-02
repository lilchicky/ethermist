package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

public class TallAbyssalMushroom extends DoublePlantBlock implements SimpleWaterloggedBlock, BonemealableBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<DoubleBlockHalf> HALF = DoublePlantBlock.HALF;

    public TallAbyssalMushroom() {
        super(Properties.ofFullCopy(Blocks.ROSE_BUSH).mapColor(MapColor.COLOR_BLUE).sound(SoundType.MUD));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || state.isFaceSturdy(level, pos, Direction.UP);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
        builder.add(HALF);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState state = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, state.getType() == Fluids.WATER);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return random.nextFloat() < 0.15f;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {

        boolean isTop = state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
        BlockPos bottomPos = isTop ? pos.below() : pos;

        if (!level.getBlockState(bottomPos).is(this)) {
            return;
        }

        TreeGrower tree = EMTreeGrowers.LARGE_ABYSSAL_MUSHROOM;

        level.removeBlock(bottomPos, false);
        level.removeBlock(bottomPos.above(), false);

        tree.growTree(level, level.getChunkSource().getGenerator(), bottomPos, state, random);

    }

}
