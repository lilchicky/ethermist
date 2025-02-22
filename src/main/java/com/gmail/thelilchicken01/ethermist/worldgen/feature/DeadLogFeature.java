package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

public class DeadLogFeature extends Feature<DeadLogConfiguration> {

    public DeadLogFeature() {
        super(DeadLogConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<DeadLogConfiguration> context) {

        DeadLogConfiguration config = context.config();
        RandomSource random = context.random();

        int len = Math.round((float) config.length().sample(random) / 2);
        BlockPos origin = context.origin();
        BlockState state = config.block().getState(random, origin);

        boolean dir = random.nextBoolean();

        state = dir ? state.setValue(BlockStateProperties.AXIS, Direction.Axis.X) : state.setValue(BlockStateProperties.AXIS, Direction.Axis.Z);

        List<BlockPos> logPositions = new ArrayList<>();
        boolean top = false;
        boolean bottom = false;

        for (int x = 1; x < len; x++) {
            BlockPos pos1 = dir ? origin.east(x) : origin.north(x);
            BlockPos pos2 = dir ? origin.west(x) : origin.south(x);

            if (!top && context.level().getBlockState(pos1).isAir() && !context.level().getBlockState(pos1.below()).isAir()) {
                logPositions.add(pos1);
            }
            else {
                top = true;
            }

            if (!bottom && context.level().getBlockState(pos2).isAir() && !context.level().getBlockState(pos2.below()).isAir()) {
                logPositions.add(pos2);
            }
            else {
                bottom = true;
            }

            if (top && bottom) {
                break;
            }
        }

        if (logPositions.size() > 2) {
            context.level().setBlock(origin, state, 3);
            for (BlockPos logPosition : logPositions) {
                context.level().setBlock(logPosition, state, 3);
            }
        }

        return true;

    }

}
