package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class EMWaterloggedFeature extends Feature<EMWaterloggedFeature.EMWaterloggedConfiguration> {

    public record EMWaterloggedConfiguration(IntProvider tries, IntProvider spread,
                                             BlockStateProvider state,
                                             BlockPredicate canPlace) implements FeatureConfiguration {

        public static final Codec<EMWaterloggedFeature.EMWaterloggedConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                IntProvider.codec(1, 128).fieldOf("spread").forGetter(EMWaterloggedConfiguration::tries),
                IntProvider.codec(1, 512).fieldOf("tries").forGetter(EMWaterloggedConfiguration::spread),
                BlockStateProvider.CODEC.fieldOf("state").forGetter(EMWaterloggedConfiguration::state),
                BlockPredicate.CODEC.fieldOf("can_place").forGetter(EMWaterloggedConfiguration::canPlace)
        ).apply(instance, EMWaterloggedFeature.EMWaterloggedConfiguration::new));
    }

    public EMWaterloggedFeature() {
        super(EMWaterloggedConfiguration.CODEC);
    }

    public boolean place(FeaturePlaceContext<EMWaterloggedFeature.EMWaterloggedConfiguration> context) {
        boolean flag = false;
        EMWaterloggedConfiguration config = context.config();
        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();

        int spread = config.spread().sample(random);
        int tries = config.tries().sample(random);
        BlockState state = config.state().getState(random, pos);
        BlockPredicate canPlace = config.canPlace();

        for (int x = 0; x < tries; x++) {

            int i = random.nextInt(spread) - random.nextInt(spread);
            int j = random.nextInt(spread) - random.nextInt(spread);
            int k = level.getHeight(Heightmap.Types.OCEAN_FLOOR, pos.getX() + i, pos.getZ() + j);
            BlockPos placementPos = new BlockPos(pos.getX() + i, k, pos.getZ() + j);

            if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.canSurvive(level, placementPos)
                    && (level.getBlockState(placementPos).isAir() || level.getBlockState(placementPos).is(Blocks.WATER))
                    && canPlace.test(level, placementPos.below())) {

                state = level.getBlockState(placementPos).is(Blocks.WATER) ?
                        state.setValue(BlockStateProperties.WATERLOGGED, true) :
                        state.setValue(BlockStateProperties.WATERLOGGED, false);

                level.setBlock(placementPos, state, 2);

                flag = true;
            }

        }

        return flag;
    }

}
