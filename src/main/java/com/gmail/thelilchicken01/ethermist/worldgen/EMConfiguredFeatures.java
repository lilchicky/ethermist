package com.gmail.thelilchicken01.ethermist.worldgen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.worldgen.feature.*;
import com.gmail.thelilchicken01.ethermist.worldgen.feature.SpikeConfiguration;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.AncientTrunkPlacer;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.CharredStumpPlacer;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.IcicleDecorator;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

public class EMConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_GLIMMERING_ANCIENT_TREE_KEY = registerKey("mega_glimmering_ancient_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLIMMERING_ANCIENT_TREE_KEY = registerKey("glimmering_ancient_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_ANCIENT_TREE_KEY = registerKey("mega_ancient_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_TREE_KEY = registerKey("ancient_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SLIMY_TREE_KEY = registerKey("slimy_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ABYSSAL_MUSHROOM_KEY = registerKey("blue_abyssal_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_ABYSSAL_MUSHROOM_KEY = registerKey("orange_abyssal_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROSTPINE_TREE_KEY = registerKey("frostpine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHARRED_TREE_STUMP_KEY = registerKey("charred_tree_stump");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHARRED_TREE_KEY = registerKey("charred_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_AMBERWOOD_TREE_KEY = registerKey("red_amberwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_AMBERWOOD_TREE_KEY = registerKey("orange_amberwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_AMBERWOOD_TREE_KEY = registerKey("yellow_amberwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_AMBERWOOD_TREE_KEY = registerKey("green_amberwood_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MEGA_AMBERWOOD_TREE_KEY = registerKey("red_mega_amberwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MEGA_AMBERWOOD_TREE_KEY = registerKey("orange_mega_amberwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_MEGA_AMBERWOOD_TREE_KEY = registerKey("yellow_mega_amberwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_MEGA_AMBERWOOD_TREE_KEY = registerKey("green_mega_amberwood_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERMIST_LAVA_LAKE = registerKey("ethermist_lava_lake");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_BOULDER_KEY = registerKey("etherstone_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOLTEN_ETHERSTONE_DISK_KEY = registerKey("molten_etherstone_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_SPIKE_KEY = registerKey("amethyst_spike");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_AMETHYST_SPIKE_KEY = registerKey("small_amethyst_spike");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ICICLE_GROUND_KEY = registerKey("icicle_ground");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRAG_SPIKE_KEY = registerKey("crag_spike");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHARRED_DEAD_LOG_KEY = registerKey("charred_dead_log");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLIMMERBUD_PATCH = registerKey("glimmerbud_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTBELL_PATCH = registerKey("nightbell_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WITCH_LAVENDER_PATCH = registerKey("witch_lavender_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DAWNING_HYACINTH_PATCH = registerKey("dawning_hyacinth_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINDERBLOOM_PATCH = registerKey("cinderbloom_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_SLIMY_ALLIUM_PATCH = registerKey("dense_slimy_allium_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RICH_GRASS_PATCH = registerKey("rich_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_RICH_GRASS_PATCH = registerKey("dense_rich_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BONEMEAL_RICH_GRASS_PATCH = registerKey("bonemeal_rich_grass_patch");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, MEGA_GLIMMERING_ANCIENT_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                new WeightedStateProvider(
                        SimpleWeightedRandomList.<BlockState>builder()
                                .add(EMBlocks.GLIMMERING_ANCIENT_LOG.get().defaultBlockState(), 985)
                                .add(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().defaultBlockState(), 15)
                                .build()
                ),
                new AncientTrunkPlacer(
                        11,
                        3,
                        1
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

        register(context, GLIMMERING_ANCIENT_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                new WeightedStateProvider(
                        SimpleWeightedRandomList.<BlockState>builder()
                                .add(EMBlocks.GLIMMERING_ANCIENT_LOG.get().defaultBlockState(), 985)
                                .add(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().defaultBlockState(), 15)
                                .build()
                ),
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
                        ConstantInt.of(3),
                        ConstantInt.of(1),
                        ConstantInt.of(4),
                        0.25F,
                        0.5F,
                        0.16666667F,
                        0.33333334F
                ),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.RICH_DIRT.get())).build()
        );

        register(context, MEGA_ANCIENT_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.ANCIENT_LOG.get()),
                new AncientTrunkPlacer(
                        11,
                        3,
                        1
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

        register(context, ANCIENT_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.ANCIENT_LOG.get()),
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
                        ConstantInt.of(3),
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
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.CRUMBLING_ETHERSTONE.get())).build()
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
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.CRUMBLING_ETHERSTONE.get())).build()
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

        register(context, CHARRED_TREE_STUMP_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.CHARRED_LOG.get()),
                new CharredStumpPlacer(
                        3,
                        2,
                        4
                ),
                BlockStateProvider.simple(Blocks.VOID_AIR),
                new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.CRUMBLING_ETHERSTONE.get())).build()
        );

        register(context, CHARRED_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.CHARRED_LOG.get()),
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
                BlockStateProvider.simple(Blocks.VOID_AIR),
                new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(EMBlocks.CRUMBLING_ETHERSTONE.get())).build()
        );

        register(context, RED_AMBERWOOD_TREE_KEY, Feature.TREE, createAmberwoodTree(EMBlocks.RED_AMBERWOOD_LEAVES.get()));
        register(context, ORANGE_AMBERWOOD_TREE_KEY, Feature.TREE, createAmberwoodTree(EMBlocks.ORANGE_AMBERWOOD_LEAVES.get()));
        register(context, YELLOW_AMBERWOOD_TREE_KEY, Feature.TREE, createAmberwoodTree(EMBlocks.YELLOW_AMBERWOOD_LEAVES.get()));
        register(context, GREEN_AMBERWOOD_TREE_KEY, Feature.TREE, createAmberwoodTree(EMBlocks.GREEN_AMBERWOOD_LEAVES.get()));

        register(context, RED_MEGA_AMBERWOOD_TREE_KEY, Feature.TREE, createMegaAmberwoodTree(EMBlocks.RED_AMBERWOOD_LEAVES.get()));
        register(context, ORANGE_MEGA_AMBERWOOD_TREE_KEY, Feature.TREE, createMegaAmberwoodTree(EMBlocks.ORANGE_AMBERWOOD_LEAVES.get()));
        register(context, YELLOW_MEGA_AMBERWOOD_TREE_KEY, Feature.TREE, createMegaAmberwoodTree(EMBlocks.YELLOW_AMBERWOOD_LEAVES.get()));
        register(context, GREEN_MEGA_AMBERWOOD_TREE_KEY, Feature.TREE, createMegaAmberwoodTree(EMBlocks.GREEN_AMBERWOOD_LEAVES.get()));

        /*
        ---------- Random Features ----------
         */

        register(context, ETHERMIST_LAVA_LAKE, Feature.LAKE, new LakeFeature.Configuration(
                BlockStateProvider.simple(Blocks.LAVA),
                BlockStateProvider.simple(EMBlocks.ETHERSTONE.get())
        ));

        register(context, ETHERSTONE_BOULDER_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get().defaultBlockState()));
        register(context, MOLTEN_ETHERSTONE_DISK_KEY, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(EMBlocks.MOLTEN_ETHERSTONE.get()),
                BlockPredicate.matchesBlocks(
                        List.of(EMBlocks.ETHERSTONE.get(), EMBlocks.COBBLED_ETHERSTONE.get())
                ),
                UniformInt.of(2, 3),
                1
        ));

        register(context, AMETHYST_SPIKE_KEY, EMFeatures.SPIKE_FEATURE.get(), new SpikeConfiguration(
                UniformInt.of(12, 32),
                UniformFloat.of(4.0f, 5.0f),
                UniformInt.of(-30, 30),
                new WeightedStateProvider(
                        SimpleWeightedRandomList.<BlockState>builder()
                                .add(Blocks.AMETHYST_BLOCK.defaultBlockState(), 4)
                                .add(Blocks.BUDDING_AMETHYST.defaultBlockState(), 1)
                )
        ));

        register(context, CRAG_SPIKE_KEY, EMFeatures.SPIKE_FEATURE.get(), new SpikeConfiguration(
                UniformInt.of(32, 96),
                UniformFloat.of(4.0f, 8.0f),
                UniformInt.of(-8, 8),
                BlockStateProvider.simple(EMBlocks.COBBLED_ETHERSTONE.get().defaultBlockState())
        ));

        register(context, ICICLE_GROUND_KEY, EMFeatures.GROUND_ICICLE_FEATURE.get(), new GroundIcicleConfiguration(
                UniformInt.of(1, 6),
                UniformInt.of(2, 4)
        ));

        register(context, SMALL_AMETHYST_SPIKE_KEY, EMFeatures.SPIKE_FEATURE.get(), new SpikeConfiguration(
                UniformInt.of(2, 4),
                UniformFloat.of(0.5f, 2.0f),
                UniformInt.of(-15, 15),
                new WeightedStateProvider(
                        SimpleWeightedRandomList.<BlockState>builder()
                                .add(Blocks.AMETHYST_BLOCK.defaultBlockState(), 4)
                                .add(Blocks.BUDDING_AMETHYST.defaultBlockState(), 1)
                )
        ));

        register(context, CHARRED_DEAD_LOG_KEY, EMFeatures.DEAD_LOG_FEATURE.get(), new DeadLogConfiguration(
                UniformInt.of(4, 8),
                BlockStateProvider.simple(EMBlocks.CHARRED_LOG.get())
        ));

        /*
        ---------- Rich Grass ----------
         */

        register(context, RICH_GRASS_PATCH, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        256,
                        16,
                        8,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        BlockStateProvider.simple(EMBlocks.RICH_GRASS.get())
                                ),
                                BlockPredicate.allOf(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL))
                                )
                        )
                )
        );

        register(context, BONEMEAL_RICH_GRASS_PATCH, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        64,
                        2,
                        2,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        BlockStateProvider.simple(EMBlocks.RICH_GRASS.get())
                                ),
                                BlockPredicate.allOf(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL))
                                )
                        )
                )
        );

        register(context, DENSE_RICH_GRASS_PATCH, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        512,
                        16,
                        8,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        BlockStateProvider.simple(EMBlocks.RICH_GRASS.get())
                                ),
                                BlockPredicate.allOf(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL))
                                )
                        )
                )
        );

        /*
        ---------- Flower Patches ----------
         */

        register(context, GLIMMERBUD_PATCH, Feature.RANDOM_PATCH, createFlowerPatch(EMBlocks.GLIMMERBUD.get(), 256, 16, 6, 1));
        register(context, NIGHTBELL_PATCH, Feature.RANDOM_PATCH, createFlowerPatch(EMBlocks.NIGHTBELL.get(), 128, 8, 1, 1));
        register(context, WITCH_LAVENDER_PATCH, Feature.RANDOM_PATCH, createFlowerPatch(EMBlocks.WITCH_LAVENDER.get(), 128, 8, 1, 1));
        register(context, DAWNING_HYACINTH_PATCH, Feature.RANDOM_PATCH, createFlowerPatch(EMBlocks.DAWNING_HYACINTH.get(), 128, 8, 1, 1));
        register(context, DENSE_SLIMY_ALLIUM_PATCH, Feature.RANDOM_PATCH, createFlowerPatch(EMBlocks.SLIMY_ALLIUM.get(), 512, 16, 1, 8));

        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();

        for (int i = 1; i <= 4; i++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                builder.add(
                        EMBlocks.CINDERBLOOM.get().defaultBlockState()
                                .setValue(PinkPetalsBlock.AMOUNT, i).setValue(PinkPetalsBlock.FACING, direction), 1
                );
            }
        }

        FeatureUtils.register(
                context,
                CINDERBLOOM_PATCH,
                Feature.FLOWER,
                new RandomPatchConfiguration(
                        96, 6, 6,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(builder)))
                )
        );

    }

    private static RandomPatchConfiguration createFlowerPatch(Block block, int tries, int spread, int grassWeight, int flowerWeight) {
        return new RandomPatchConfiguration(
                tries,
                spread,
                8,
                PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                new WeightedStateProvider(
                                        SimpleWeightedRandomList.<BlockState>builder()
                                                .add(EMBlocks.RICH_GRASS.get().defaultBlockState(), grassWeight)
                                                .add(block.defaultBlockState(), flowerWeight)
                                )
                        ),
                        BlockPredicate.allOf(
                                BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL))
                        )
                )
        );
    }

    private static TreeConfiguration createAmberwoodTree(Block leaf) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.AMBERWOOD_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(
                        4,
                        2,
                        4
                ),
                BlockStateProvider.simple(leaf.defaultBlockState()),
                new CherryFoliagePlacer(
                        ConstantInt.of(4),
                        ConstantInt.of(0),
                        ConstantInt.of(4),
                        0.25F,
                        0.5F,
                        0.16666667F,
                        0.33333334F
                ),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(EMBlocks.RICH_DIRT.get()))
                .build();
    }

    private static TreeConfiguration createMegaAmberwoodTree(Block leaf) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EMBlocks.AMBERWOOD_LOG.get().defaultBlockState()),
                new MegaJungleTrunkPlacer(
                        8,
                        4,
                        8
                ),
                BlockStateProvider.simple(leaf.defaultBlockState()),
                new CherryFoliagePlacer(
                        ConstantInt.of(4),
                        ConstantInt.of(0),
                        ConstantInt.of(4),
                        0.25F,
                        0.5F,
                        0.16666667F,
                        0.33333334F
                ),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(EMBlocks.RICH_DIRT.get()))
                .build();
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
