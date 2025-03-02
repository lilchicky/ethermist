package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.block.Icicle;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class GroundIcicleFeature extends Feature<GroundIcicleFeature.GroundIcicleConfiguration> {

    public record GroundIcicleConfiguration(IntProvider height, IntProvider spread) implements FeatureConfiguration {

        public static final Codec<GroundIcicleConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                IntProvider.codec(1, 16).fieldOf("height").forGetter(GroundIcicleConfiguration::height),
                IntProvider.codec(1, 16).fieldOf("spread").forGetter(GroundIcicleConfiguration::spread)
        ).apply(instance, GroundIcicleConfiguration::new));
    }

    public GroundIcicleFeature() {
        super(GroundIcicleConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<GroundIcicleConfiguration> context) {

        GroundIcicleConfiguration config = context.config();

        RandomSource random = context.random();

        int radius = config.spread().sample(random);

        BlockPos origin = context.origin();

        int numIcicles = random.nextInt(radius) + 3;

        for (int x = 0; x < numIcicles; x++) {
            int offX = random.nextInt(radius * 2 + 1) - radius;
            int offZ = random.nextInt(radius * 2 + 1) - radius;

            BlockPos placement = findYLoc(context.level(), origin.offset(offX, 0, offZ), 3);

            if (placement != null) {

                context.level().setBlock(placement, EMBlocks.ICICLE.get().defaultBlockState(), 3);

                BlockState baseIcicle = EMBlocks.ICICLE.get().defaultBlockState()
                        .setValue(Icicle.TIP_DIRECTION, Direction.UP)
                        .setValue(Icicle.THICKNESS, DripstoneThickness.TIP);

                int height = config.height().sample(random);

                for (int i = 0; i < height; i++) {
                    DripstoneThickness thickness = getDripstoneThickness(height, i);

                    context.level().setBlock(placement.offset(0, i, 0), baseIcicle.setValue(Icicle.THICKNESS, thickness), 3);
                }

            }
        }

        return true;

    }

    private static DripstoneThickness getDripstoneThickness(int height, int i) {
        DripstoneThickness thickness;

        if (height == 1) {
            thickness = DripstoneThickness.TIP;
        } else if (height == 2) {
            thickness = (i == 0) ? DripstoneThickness.FRUSTUM : DripstoneThickness.TIP;
        } else if (height == 3) {
            thickness = (i == 0) ? DripstoneThickness.BASE :
                    (i == 1) ? DripstoneThickness.FRUSTUM : DripstoneThickness.TIP;
        } else {
            if (i == 0) {
                thickness = DripstoneThickness.BASE;
            } else if (i == height - 1) {
                thickness = DripstoneThickness.TIP;
            } else if (i == height - 2) {
                thickness = DripstoneThickness.FRUSTUM;
            } else {
                thickness = DripstoneThickness.MIDDLE;
            }
        }
        return thickness;
    }

    private BlockPos findYLoc(WorldGenLevel level, BlockPos pos, int checkRange) {
        for (int y = -checkRange; y < checkRange * 2; y++) {
            if (isValidPlacement(level, pos.offset(0, y, 0))) {
                return pos.offset(0, y, 0);
            }
        }
        return null;
    }

    private boolean isValidPlacement(WorldGenLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos.below());
        return state.is(EMTags.Blocks.CAN_GROW_ICICLE) && level.getBlockState(pos).isAir();
    }

}
