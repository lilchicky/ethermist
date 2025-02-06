package com.gmail.thelilchicken01.ethermist.worldgen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.AncientTrunkPlacer;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.IcicleDecorator;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.RandomizedBlockStateProvider;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class EMConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_GLIMMERING_ANCIENT_TREE_KEY = registerKey("mega_glimmering_ancient_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLIMMERING_ANCIENT_TREE_KEY = registerKey("glimmering_ancient_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SLIMY_TREE_KEY = registerKey("slimy_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ABYSSAL_MUSHROOM_KEY = registerKey("blue_abyssal_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_ABYSSAL_MUSHROOM_KEY = registerKey("orange_abyssal_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROSTPINE_TREE_KEY = registerKey("frostpine_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERMIST_LAVA_LAKE = registerKey("ethermist_lava_lake");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLIMMER_BLOSSOM_PATCH = registerKey("glimmer_blossom_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RICH_GRASS_PATCH = registerKey("rich_grass_patch");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, MEGA_GLIMMERING_ANCIENT_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                new RandomizedBlockStateProvider(EMBlocks.GLIMMERING_ANCIENT_LOG.get().defaultBlockState(), EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().defaultBlockState(), 0.985),
                new AncientTrunkPlacer(
                        11,
                        3,
                        1
                ),
                BlockStateProvider.simple(EMBlocks.ANCIENT_LEAVES.get()),
                new CherryFoliagePlacer(
                        ConstantInt.of(4),
                        ConstantInt.of(3),
                        ConstantInt.of(4),
                        0.25F,
                        0.5F,
                        0.16666667F,
                        0.33333334F
                ),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.RICH_DIRT.get())).build()
        );

        register(context, GLIMMERING_ANCIENT_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                new RandomizedBlockStateProvider(EMBlocks.GLIMMERING_ANCIENT_LOG.get().defaultBlockState(), EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().defaultBlockState(), 0.985),
                new CherryTrunkPlacer(
                        6,
                        1,
                        0,
                        new WeightedListInt(
                                SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()
                        ),
                        UniformInt.of(2, 4),
                        UniformInt.of(-4, -3),
                        UniformInt.of(-1, 0)
                ),
                BlockStateProvider.simple(EMBlocks.ANCIENT_LEAVES.get()),
                new CherryFoliagePlacer(
                        ConstantInt.of(4),
                        ConstantInt.of(1),
                        ConstantInt.of(4),
                        0.25F,
                        0.5F,
                        0.16666667F,
                        0.33333334F
                ),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.RICH_DIRT.get())).build()
        );

        register(context, SLIMY_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.SLIMY_LOG.get().defaultBlockState()),
                new CherryTrunkPlacer(
                        7,
                        1,
                        0,
                        new WeightedListInt(
                                SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()
                        ),
                        UniformInt.of(2, 4),
                        UniformInt.of(-4, -3),
                        UniformInt.of(-1, 0)
                ),
                BlockStateProvider.simple(EMBlocks.SLIMY_LEAVES.get()),
                new CherryFoliagePlacer(
                        ConstantInt.of(4),
                        ConstantInt.of(0),
                        ConstantInt.of(4),
                        0.25F,
                        0.5F,
                        0.16666667F,
                        0.33333334F
                ),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.RICH_DIRT.get())).build()
        );

        register(context, BLUE_ABYSSAL_MUSHROOM_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM.get().defaultBlockState()),
                new ForkingTrunkPlacer(
                        2,
                        3,
                        1
                ),
                BlockStateProvider.simple(EMBlocks.BLUE_ABYSSAL_MUSHROOM_TOP.get()),
                new AcaciaFoliagePlacer(
                        ConstantInt.of(2),
                        ConstantInt.of(0)
                ),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.SPARKLING_SAND.get())).build()
        );

        register(context, ORANGE_ABYSSAL_MUSHROOM_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM.get().defaultBlockState()),
                new ForkingTrunkPlacer(
                        2,
                        3,
                        1
                ),
                BlockStateProvider.simple(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_TOP.get()),
                new AcaciaFoliagePlacer(
                        ConstantInt.of(2),
                        ConstantInt.of(0)
                ),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.SPARKLING_SAND.get())).build()
        );

        register(context, FROSTPINE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.FROSTPINE_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(
                        8,
                        12,
                        13
                ),
                BlockStateProvider.simple(EMBlocks.FROSTPINE_LEAVES.get().defaultBlockState()),
                new MegaPineFoliagePlacer(
                        ConstantInt.of(0),
                        ConstantInt.of(2),
                        ConstantInt.of(16)
                ),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(EMBlocks.RICH_DIRT.get()))
                .decorators(ImmutableList.of(new IcicleDecorator(0.4f))).build()
        );

        register(context, ETHERMIST_LAVA_LAKE, Feature.LAKE, new LakeFeature.Configuration(
                BlockStateProvider.simple(Blocks.LAVA),
                BlockStateProvider.simple(EMBlocks.ETHERSTONE.get())
        ));

        register(context, RICH_GRASS_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EMBlocks.RICH_GRASS.get())))
        );

        register(context, GLIMMER_BLOSSOM_PATCH, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        256,
                        16,
                        8,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new WeightedStateProvider(
                                                SimpleWeightedRandomList.<BlockState>builder()
                                                        .add(EMBlocks.RICH_GRASS.get().defaultBlockState(), 6)
                                                        .add(EMBlocks.GLIMMER_BLOSSOM.get().defaultBlockState(), 1)
                                        )
                                ),
                                BlockPredicate.allOf(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL))
                                )
                        )
                )
        );

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
