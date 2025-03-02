package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
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
        BlockPredicate canPlace = config.canPlace();

        for (int x = 0; x < tries; x++) {

            int i = random.nextInt(spread) - random.nextInt(spread);
            int j = random.nextInt(spread) - random.nextInt(spread);
            int k = level.getHeight(Heightmap.Types.OCEAN_FLOOR, pos.getX() + i, pos.getZ() + j);
            BlockPos placementPos = new BlockPos(pos.getX() + i, k, pos.getZ() + j);
            BlockState state = config.state().getState(random, pos);

            if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.canSurvive(level, placementPos)
                    && (level.getBlockState(placementPos).isAir() || level.getBlockState(placementPos).is(Blocks.WATER))
                    && canPlace.test(level, placementPos.below())) {

                if (state.is(EMBlocks.TALL_ABYSSAL_MUSHROOM.get())) {

                    if (level.getBlockState(placementPos.above()).isAir() || level.getBlockState(placementPos.above()).is(Blocks.WATER)) {

                        BlockState top = level.getBlockState(placementPos.above()).is(Blocks.WATER) ?
                                state.setValue(BlockStateProperties.WATERLOGGED, true) :
                                state.setValue(BlockStateProperties.WATERLOGGED, false);
                        top = top.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

                        BlockState bottom = level.getBlockState(placementPos).is(Blocks.WATER) ?
                                state.setValue(BlockStateProperties.WATERLOGGED, true) :
                                state.setValue(BlockStateProperties.WATERLOGGED, false);
                        bottom = bottom.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);

                        level.setBlock(placementPos, bottom, 3);
                        level.setBlock(placementPos.above(), top, 3);

                        flag = true;

                    }

                    else {
                        flag = false;
                    }

                }
                else {

                    state = level.getBlockState(placementPos).is(Blocks.WATER) ?
                            state.setValue(BlockStateProperties.WATERLOGGED, true) :
                            state.setValue(BlockStateProperties.WATERLOGGED, false);

                    level.setBlock(placementPos, state, 3);

                    flag = true;

                }
            }

        }

        return flag;
    }

}
