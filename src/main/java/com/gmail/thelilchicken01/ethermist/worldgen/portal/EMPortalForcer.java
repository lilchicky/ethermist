package com.gmail.thelilchicken01.ethermist.worldgen.portal;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Comparator;
import java.util.Optional;

public class EMPortalForcer {

    private static BlockState FRAME = EMBlocks.ETHERSTONE_BRICKS.get().defaultBlockState();

    public EMPortalForcer() {
    }

    public static Optional<BlockPos> findClosestPortalPosition(ServerLevel level, BlockPos exitPos, boolean isEthermist, WorldBorder worldBorder) {
        PoiManager poimanager = level.getPoiManager();
        int i = isEthermist ? 16 : 128;
        poimanager.ensureLoadedAndValid(level, exitPos, i);

        return poimanager.getInSquare(holder -> holder.is(EMPOIs.ETHERMIST_PORTAL), exitPos, i, PoiManager.Occupancy.ANY)
                .map(PoiRecord::getPos)
                .filter(worldBorder::isWithinBounds)
                .filter(pos -> level.getBlockState(pos).hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                .min(Comparator.<BlockPos>comparingDouble(pos -> pos.distSqr(exitPos)).thenComparingInt(Vec3i::getY));
    }

    public static Optional<BlockUtil.FoundRectangle> createPortal(ServerLevel level, BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0F;
        BlockPos blockpos = null;
        double d1 = -1.0F;
        BlockPos blockpos1 = null;
        WorldBorder worldborder = level.getWorldBorder();
        int minHeight = Math.min(level.getMaxBuildHeight(), level.getMinBuildHeight() + level.getLogicalHeight()) - 1;
        BlockPos.MutableBlockPos mutBlockPos = pos.mutable();

        for(BlockPos.MutableBlockPos mutBlockPos1 : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int k = Math.min(minHeight, level.getHeight(Heightmap.Types.MOTION_BLOCKING, mutBlockPos1.getX(), mutBlockPos1.getZ()));
            if (worldborder.isWithinBounds(mutBlockPos1) && worldborder.isWithinBounds(mutBlockPos1.move(direction, 1))) {
                mutBlockPos1.move(direction.getOpposite(), 1);

                for(int placeHeight = k; placeHeight >= 0; --placeHeight) {
                    mutBlockPos1.setY(placeHeight);
                    if (canPortalReplaceBlock(level, mutBlockPos1)) {

                        int i1 = placeHeight;
                        while(placeHeight > level.getMinBuildHeight() && canPortalReplaceBlock(level, mutBlockPos1.move(Direction.DOWN))) {
                            placeHeight--;
                        }

                        if (placeHeight + 4 <= minHeight) {
                            int j1 = i1 - placeHeight;
                            if (j1 <= 0 || j1 >= 3) {
                                mutBlockPos1.setY(placeHeight);
                                if (canHostFrame(level, mutBlockPos1, mutBlockPos, direction, 0)) {
                                    double d2 = pos.distSqr(mutBlockPos1);
                                    if (canHostFrame(level, mutBlockPos1, mutBlockPos, direction, -1) &&
                                            canHostFrame(level, mutBlockPos1, mutBlockPos1, direction, 1) && (d0 == (double)-1.0F || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = mutBlockPos1.immutable();
                                    }

                                    if (d0 == (double)-1.0F && (d1 == (double)-1.0F || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = mutBlockPos1.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == (double)-1.0F && d1 != (double)-1.0F) {
            blockpos = blockpos1;
            d0 = d1;
        }

        if (d0 == (double)-1.0F) {
            int k1 = Math.max(level.getMinBuildHeight() - -1, 70);
            int i2 = minHeight - 9;
            if (i2 < k1) {
                return Optional.empty();
            }

            blockpos = new BlockPos(pos.getX() - direction.getStepX() * 1, Mth.clamp(pos.getY(), k1, i2), pos.getZ() - direction.getStepZ() * 1).immutable();
            blockpos = worldborder.clampToBounds(blockpos);
            Direction direction1 = direction.getClockWise();

            for(int i3 = -1; i3 < 2; ++i3) {
                for(int j3 = 0; j3 < 2; ++j3) {
                    for(int k3 = -1; k3 < 3; ++k3) {
                        BlockState blockstate1 = k3 < 0 ? FRAME : Blocks.AIR.defaultBlockState();
                        mutBlockPos.setWithOffset(
                                blockpos, j3 * direction.getStepX() + i3 * direction1.getStepX(), k3, j3 * direction.getStepZ() + i3 * direction1.getStepZ()
                        );
                        level.setBlockAndUpdate(mutBlockPos, blockstate1);
                    }
                }
            }
        }

        for(int l1 = -1; l1 < 3; ++l1) {
            for(int j2 = -1; j2 < 4; ++j2) {
                if (l1 == -1 || l1 == 2 || j2 == -1 || j2 == 3) {
                    mutBlockPos.setWithOffset(blockpos, l1 * direction.getStepX(), j2, l1 * direction.getStepZ());
                    level.setBlock(mutBlockPos, FRAME, 3);
                }
            }
        }

        BlockState blockstate = EMBlocks.ETHERMIST_PORTAL.get().defaultBlockState().setValue(NetherPortalBlock.AXIS, axis);

        for(int k2 = 0; k2 < 2; ++k2) {
            for(int l2 = 0; l2 < 3; ++l2) {
                mutBlockPos.setWithOffset(blockpos, k2 * direction.getStepX(), l2, k2 * direction.getStepZ());
                level.setBlock(mutBlockPos, blockstate, 18);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
    }

    private static boolean canPortalReplaceBlock(ServerLevel level, BlockPos.MutableBlockPos pos) {
        BlockState blockstate = level.getBlockState(pos);
        return blockstate.canBeReplaced() && blockstate.getFluidState().isEmpty();
    }

    private static boolean canHostFrame(ServerLevel level, BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction p_direction, int offsetScale) {
        Direction direction = p_direction.getClockWise();

        for(int i = -1; i < 3; ++i) {
            for(int j = -1; j < 4; ++j) {
                offsetPos.setWithOffset(
                        originalPos,
                        p_direction.getStepX() * i + direction.getStepX() * offsetScale,
                        j,
                        p_direction.getStepZ() * i + direction.getStepZ() * offsetScale);
                if (j < 0 && !level.getBlockState(offsetPos).isSolid()) {
                    return false;
                }

                if (j >= 0 && !canPortalReplaceBlock(level, offsetPos)) {
                    return false;
                }
            }
        }

        return true;
    }
}
