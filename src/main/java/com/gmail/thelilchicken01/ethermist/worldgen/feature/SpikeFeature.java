package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class SpikeFeature extends Feature<SpikeFeature.SpikeConfiguration> {

    public record SpikeConfiguration(
            IntProvider height,
            FloatProvider baseRadius,
            IntProvider tilt,
            BlockStateProvider blockStateProvider) implements FeatureConfiguration {

        public static final Codec<SpikeConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                IntProvider.codec(1, 128).fieldOf("height").forGetter(SpikeConfiguration::height),
                FloatProvider.codec(0.5F, 16.0F).fieldOf("baseRadius").forGetter(SpikeConfiguration::baseRadius),
                IntProvider.codec(-90, 90).fieldOf("tilt").forGetter(SpikeConfiguration::tilt),
                BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(SpikeConfiguration::blockStateProvider)  // Add BlockStateProvider to codec
        ).apply(instance, SpikeConfiguration::new));
    }

    public SpikeFeature() {
        super(SpikeConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<SpikeConfiguration> context) {
        SpikeConfiguration config = context.config();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos basePos = context.origin();

        int height = config.height().sample(random);
        float baseRadius = config.baseRadius().sample(random);
        double tiltModX = Math.tan(Math.toRadians(config.tilt().sample(random)));
        double tiltModZ = Math.tan(Math.toRadians(config.tilt().sample(random)));

        for (int dir = 1; dir >= -1; dir -= 2) {
            for (int y = 0; y < height; y++) {
                float currentRadius = baseRadius - ((float) y / height) * (baseRadius - 0.5f);
                BlockPos tiltPos = basePos.offset(dir * (int) (tiltModX * y), 0, dir * (int) (tiltModZ * y));

                if (y >= height - 1) currentRadius = 0.5F;

                for (int dx = -Math.round(currentRadius); dx <= Math.round(currentRadius); dx++) {
                    for (int dz = -Math.round(currentRadius); dz <= Math.round(currentRadius); dz++) {
                        if (dx * dx + dz * dz > currentRadius * currentRadius) continue;

                        BlockPos spikePos = tiltPos.offset(dx, dir * y, dz);
                        if (!level.hasChunk(spikePos.getX() >> 4, spikePos.getZ() >> 4)) continue;

                        BlockState blockState = config.blockStateProvider().getState(random, basePos);

                        level.setBlock(spikePos, blockState, 3);

                        if (blockState.is(Blocks.BUDDING_AMETHYST)) {
                            for (Direction direction : Direction.values()) {
                                BlockPos adjacentPos = spikePos.relative(direction);
                                if (level.getBlockState(adjacentPos).isAir() && level.hasChunk(adjacentPos.getX() >> 4, adjacentPos.getZ() >> 4)) {
                                    BlockState cluster = switch (random.nextInt(3)) {
                                        case 0 -> Blocks.SMALL_AMETHYST_BUD.defaultBlockState();
                                        case 1 -> Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState();
                                        case 2 -> Blocks.LARGE_AMETHYST_BUD.defaultBlockState();
                                        default -> Blocks.AMETHYST_CLUSTER.defaultBlockState();
                                    };
                                    cluster = cluster.setValue(BlockStateProperties.FACING, direction);
                                    level.setBlock(adjacentPos, cluster, 3);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
