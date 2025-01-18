package com.gmail.thelilchicken01.ethermist.worldgen.portal;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.block.EMPortalBlock;
import com.gmail.thelilchicken01.ethermist.datagen.EMTags;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Optional;

public class EMPortalShape {

    private static final int MIN_WIDTH = 2;
    public static final int MAX_WIDTH = 21;
    private static final int MIN_HEIGHT = 2;
    public static final int MAX_HEIGHT = 21;
    private static final BlockBehaviour.StatePredicate FRAME = (state, getter, pos) -> state.is(EMTags.Blocks.PORTAL_FRAME_BLOCKS);
    private final LevelAccessor level;
    private final Direction.Axis axis;
    private final Direction rightDir;
    private int numPortalBlocks;
    @Nullable
    private BlockPos bottomLeft;
    private int height;
    private final int width;

    public EMPortalShape(LevelAccessor level, BlockPos bottomLeft, Direction.Axis axis) {
        this.level = level;
        this.axis = axis;
        this.rightDir = axis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
        this.bottomLeft = this.calculateBottomLeft(bottomLeft);
        if (this.bottomLeft == null) {
            this.bottomLeft = bottomLeft;
            this.width = 1;
            this.height = 1;
        } else {
            this.width = this.calculateWidth();
            if (this.width > 0) {
                this.height = this.calculateHeight();
            }
        }

    }

    @Nullable
    private BlockPos calculateBottomLeft(BlockPos pos) {
        int i = Math.max(this.level.getMinBuildHeight(), pos.getY() - MAX_HEIGHT);

        while (pos.getY() > i && isEmpty(this.level.getBlockState(pos.below()))) {
            pos = pos.below();
        }

        Direction direction = this.rightDir.getOpposite();
        int j = this.getDistanceUntilEdgeAboveFrame(pos, direction) - 1;
        return j < 0 ? null : pos.relative(direction, j);
    }

    private int calculateWidth() {
        int i = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
        return i >= MIN_WIDTH && i <= MAX_WIDTH ? i : 0;
    }

    private int getDistanceUntilEdgeAboveFrame(BlockPos pos, Direction direction) {
        BlockPos.MutableBlockPos mutBlockPos = new BlockPos.MutableBlockPos();

        for(int i = 0; i <= MAX_WIDTH; ++i) {
            mutBlockPos.set(pos).move(direction, i);
            BlockState blockstate = this.level.getBlockState(mutBlockPos);
            if (!isEmpty(blockstate)) {
                if (FRAME.test(blockstate, this.level, mutBlockPos)) {
                    return i;
                }
                break;
            }

            BlockState blockstate1 = this.level.getBlockState(mutBlockPos.move(Direction.DOWN));
            if (!FRAME.test(blockstate1, this.level, mutBlockPos)) {
                break;
            }
        }

        return 0;
    }

    private int calculateHeight() {
        BlockPos.MutableBlockPos mutBlockPos = new BlockPos.MutableBlockPos();
        int i = this.getDistanceUntilTop(mutBlockPos);
        return i >= MIN_HEIGHT && i <= MAX_HEIGHT && this.hasTopFrame(mutBlockPos, i) ? i : 0;
    }

    private boolean hasTopFrame(BlockPos.MutableBlockPos pos, int distanceToTop) {
        for(int i = 0; i < this.width; ++i) {
            BlockPos.MutableBlockPos mutBlockPos = pos.set(this.bottomLeft).move(Direction.UP, distanceToTop).move(this.rightDir, i);
            if (!FRAME.test(this.level.getBlockState(mutBlockPos), this.level, mutBlockPos)) {
                return false;
            }
        }

        return true;
    }

    private int getDistanceUntilTop(BlockPos.MutableBlockPos pos) {
        for(int i = 0; i < MAX_HEIGHT; ++i) {
            pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
            if (!FRAME.test(this.level.getBlockState(pos), this.level, pos)) {
                return i;
            }

            pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
            if (!FRAME.test(this.level.getBlockState(pos), this.level, pos)) {
                return i;
            }

            for(int j = 0; j < this.width; ++j) {
                pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
                BlockState blockstate = this.level.getBlockState(pos);
                if (!isEmpty(blockstate)) {
                    return i;
                }

                if (blockstate.is(EMBlocks.ETHERMIST_PORTAL.get())) {
                    ++this.numPortalBlocks;
                }
            }
        }

        return MAX_HEIGHT;
    }

    private static boolean isEmpty(BlockState state) {
        return state.isAir() || state.is(BlockTags.FIRE) || state.is(EMBlocks.ETHERMIST_PORTAL.get());
    }

    public boolean isValid() {
        return this.bottomLeft != null && this.width >= MIN_WIDTH && this.width <= MAX_WIDTH && this.height >= MIN_HEIGHT && this.height <= MAX_HEIGHT;
    }

    public int getNumPortalBlocks() {
        return this.numPortalBlocks;
    }

    public void createPortalBlocks() {
        BlockState blockstate = EMBlocks.ETHERMIST_PORTAL.get().defaultBlockState().setValue(EMPortalBlock.AXIS, this.axis);
        BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1))
                .forEach((BlockPos pos) -> this.level.setBlock(pos, blockstate, 18));
    }

    public boolean isComplete() {
        return this.isValid() && this.numPortalBlocks == this.width * this.height;
    }

    public static Vec3 findCollisionFreePosition(Vec3 pos, ServerLevel level, Entity entity, EntityDimensions dimensions) {
        if (!(dimensions.width() > 4.0F) && !(dimensions.height() > 4.0F)) {
            double d0 = (double)dimensions.height() / (double)2.0F;
            Vec3 vec3 = pos.add(0.0F, d0, 0.0F);
            VoxelShape voxelshape = Shapes.create(AABB.ofSize(vec3, (double)dimensions.width(), (double)0.0F, (double)dimensions.width()).expandTowards((double)0.0F, (double)1.0F, (double)0.0F).inflate(1.0E-6));
            Optional<Vec3> optional = level.findFreePosition(entity, voxelshape, vec3, (double)dimensions.width(), (double)dimensions.height(), (double)dimensions.width());
            Optional<Vec3> optional1 = optional.map((p_259019_) -> p_259019_.subtract((double)0.0F, d0, (double)0.0F));
            return optional1.orElse(pos);
        } else {
            return pos;
        }
    }
    
}
