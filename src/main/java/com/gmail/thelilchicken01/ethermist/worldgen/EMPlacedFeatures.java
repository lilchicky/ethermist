package com.gmail.thelilchicken01.ethermist.worldgen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EMPlacedFeatures {

    public static final ResourceKey<PlacedFeature> MEGA_GLIMMERING_ANCIENT_PLACED_TREE_KEY = registerKey("mega_glimmering_ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> GLIMMERING_ANCIENT_PLACED_TREE_KEY = registerKey("glimmering_ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> MEGA_ANCIENT_PLACED_TREE_KEY = registerKey("mega_ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> ANCIENT_PLACED_TREE_KEY = registerKey("ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> SPARSE_ANCIENT_PLACED_TREE_KEY = registerKey("sparse_ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> SPARSE_FROSTPINE_PLACED_TREE_KEY = registerKey("sparse_frostpine_tree_placed");
    public static final ResourceKey<PlacedFeature> CHARRED_TREE_STUMP_PLACED_KEY = registerKey("charred_tree_stump_placed");
    public static final ResourceKey<PlacedFeature> CHARRED_PLACED_TREE_KEY = registerKey("charred_tree_placed");

    public static final ResourceKey<PlacedFeature> RED_AMBERWOOD_PLACED_TREE_KEY = registerKey("red_amberwood_tree_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_AMBERWOOD_PLACED_TREE_KEY = registerKey("orange_amberwood_tree_placed");
    public static final ResourceKey<PlacedFeature> YELLOW_AMBERWOOD_PLACED_TREE_KEY = registerKey("yellow_amberwood_tree_placed");
    public static final ResourceKey<PlacedFeature> GREEN_AMBERWOOD_PLACED_TREE_KEY = registerKey("green_amberwood_tree_placed");

    public static final ResourceKey<PlacedFeature> SLIMY_PLACED_TREE_KEY = registerKey("slimy_tree_placed");

    public static final ResourceKey<PlacedFeature> BLUE_PLACED_ABYSSAL_MUSHROOM = registerKey("blue_abyssal_mushroom_placed");

    public static final ResourceKey<PlacedFeature> ORANGE_PLACED_ABYSSAL_MUSHROOM = registerKey("orange_abyssal_mushroom_placed");

    public static final ResourceKey<PlacedFeature> FROSTPINE_PLACED_TREE_KEY = registerKey("frostpine_tree_placed");

    public static final ResourceKey<PlacedFeature> ETHERMIST_LAVA_LAKE_PLACED_KEY = registerKey("ethermist_lava_lake_placed");
    public static final ResourceKey<PlacedFeature> DENSE_ETHERMIST_LAVA_LAKE_PLACED_KEY = registerKey("dense_ethermist_lava_lake_placed");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_BOULDER_PLACED_KEY = registerKey("etherstone_boulder_placed");
    public static final ResourceKey<PlacedFeature> MOLTEN_ETHERSTONE_DISK_PLACED_KEY = registerKey("molten_etherstone_disk_placed");
    public static final ResourceKey<PlacedFeature> AMETHYST_SPIKE_PLACED_KEY = registerKey("amethyst_spike_placed");
    public static final ResourceKey<PlacedFeature> SMALL_AMETHYST_SPIKE_PLACED_KEY = registerKey("small_amethyst_spike_placed");
    public static final ResourceKey<PlacedFeature> ICICLE_GROUND_PLACED_KEY = registerKey("icicle_ground_placed");
    public static final ResourceKey<PlacedFeature> CRAG_SPIKE_PLACED_KEY = registerKey("crag_spike_placed");
    public static final ResourceKey<PlacedFeature> CHARRED_DEAD_LOG_PLACED_KEY = registerKey("charred_dead_log_placed");

    public static final ResourceKey<PlacedFeature> GLIMMERBUD_PATCH_KEY = registerKey("glimmerbud_patch_placed");
    public static final ResourceKey<PlacedFeature> NIGHTBELL_PATCH_KEY = registerKey("nightbell_patch_placed");
    public static final ResourceKey<PlacedFeature> WITCH_LAVENDER_PATCH_KEY = registerKey("witch_lavender_patch_placed");
    public static final ResourceKey<PlacedFeature> DAWNING_HYACINTH_PATCH_KEY = registerKey("dawning_hyacinth_patch_placed");
    public static final ResourceKey<PlacedFeature> DENSE_SLIMY_ALLIUM_PATCH_KEY = registerKey("dense_slimy_allium_placed");
    public static final ResourceKey<PlacedFeature> CINDERBLOOM_PATCH_KEY = registerKey("cinderbloom_patch_placed");

    public static final ResourceKey<PlacedFeature> RICH_GRASS_PATCH_KEY = registerKey("rich_grass_patch_placed");
    public static final ResourceKey<PlacedFeature> RICH_GRASS_BONEMEAL_KEY = registerKey("rich_grass_bonemeal_placed");
    public static final ResourceKey<PlacedFeature> DENSE_RICH_GRASS_PATCH_KEY = registerKey("dense_rich_grass_patch_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MEGA_GLIMMERING_ANCIENT_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.MEGA_GLIMMERING_ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.GLIMMERING_ANCIENT_SAPLING.get()));

        register(context, GLIMMERING_ANCIENT_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.GLIMMERING_ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.5f, 2),
                        EMBlocks.GLIMMERING_ANCIENT_SAPLING.get()));

        register(context, MEGA_ANCIENT_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.MEGA_ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.ANCIENT_SAPLING.get()));

        register(context, ANCIENT_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.5f, 2),
                        EMBlocks.ANCIENT_SAPLING.get()));

        register(context, SPARSE_ANCIENT_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ANCIENT_TREE_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(48),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EMBlocks.ANCIENT_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
                )
        );

        register(context, SPARSE_FROSTPINE_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.FROSTPINE_TREE_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(24),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EMBlocks.FROSTPINE_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
                )
        );

        register(context, SLIMY_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.SLIMY_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2),
                        EMBlocks.SLIMY_SAPLING.get()));

        register(context, FROSTPINE_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.FROSTPINE_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2),
                        EMBlocks.FROSTPINE_SAPLING.get()));

        register(context, CHARRED_TREE_STUMP_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.CHARRED_TREE_STUMP_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EMBlocks.CHARRED_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
                )
        );

        register(context, CHARRED_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.CHARRED_TREE_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EMBlocks.CHARRED_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
                )
        );

        // Small Amberwood Tree
        register(context, RED_AMBERWOOD_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.RED_AMBERWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.RED_AMBERWOOD_SAPLING.get()));
        register(context, ORANGE_AMBERWOOD_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ORANGE_AMBERWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.ORANGE_AMBERWOOD_SAPLING.get()));
        register(context, YELLOW_AMBERWOOD_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.YELLOW_AMBERWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.YELLOW_AMBERWOOD_SAPLING.get()));
        register(context, GREEN_AMBERWOOD_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.GREEN_AMBERWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.GREEN_AMBERWOOD_SAPLING.get()));


        register(context, BLUE_PLACED_ABYSSAL_MUSHROOM, configuredFeatures.getOrThrow(EMConfiguredFeatures.BLUE_ABYSSAL_MUSHROOM_KEY),
                List.of(
                        NoiseBasedCountPlacement.of(10, 10.0, 0.0),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID,
                        BiomeFilter.biome()
                )
        );

        register(context, ORANGE_PLACED_ABYSSAL_MUSHROOM, configuredFeatures.getOrThrow(EMConfiguredFeatures.ORANGE_ABYSSAL_MUSHROOM_KEY),
                List.of(
                        NoiseBasedCountPlacement.of(10, 10.0, 0.0),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID,
                        BiomeFilter.biome()
                )
        );

        /*
        ---------- Biome Features ----------
         */

        register(context, ETHERMIST_LAVA_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ETHERMIST_LAVA_LAKE), simpleSpawn(200));
        register(context, DENSE_ETHERMIST_LAVA_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ETHERMIST_LAVA_LAKE), simpleSpawn(2));
        register(context, ETHERSTONE_BOULDER_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ETHERSTONE_BOULDER_KEY), simpleSpawn(2));
        register(context, MOLTEN_ETHERSTONE_DISK_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.MOLTEN_ETHERSTONE_DISK_KEY), simpleSpawn(2));
        register(context, AMETHYST_SPIKE_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.AMETHYST_SPIKE_KEY), simpleSpawn(3));
        register(context, CRAG_SPIKE_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.CRAG_SPIKE_KEY), simpleSpawn(24));
        register(context, SMALL_AMETHYST_SPIKE_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.SMALL_AMETHYST_SPIKE_KEY), simpleSpawn(1));
        register(context, ICICLE_GROUND_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ICICLE_GROUND_KEY), simpleSpawn(1));
        register(context, CHARRED_DEAD_LOG_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.CHARRED_DEAD_LOG_KEY), simpleSpawn(4));

        /*
        ---------- Flowers ----------
         */

        register(context, GLIMMERBUD_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.GLIMMERBUD_PATCH), simpleSpawn(1));
        register(context, NIGHTBELL_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.NIGHTBELL_PATCH), simpleSpawn(12));
        register(context, WITCH_LAVENDER_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.WITCH_LAVENDER_PATCH), simpleSpawn(12));
        register(context, DAWNING_HYACINTH_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.DAWNING_HYACINTH_PATCH), simpleSpawn(12));
        register(context, DENSE_SLIMY_ALLIUM_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.DENSE_SLIMY_ALLIUM_PATCH), simpleSpawn(2));
        register(context, CINDERBLOOM_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.CINDERBLOOM_PATCH), simpleSpawn(2));

        /*
        ---------- Misc Plants ----------
         */

        register(context, RICH_GRASS_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.RICH_GRASS_PATCH), simpleSpawn(1));
        register(context, RICH_GRASS_BONEMEAL_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.BONEMEAL_RICH_GRASS_PATCH), List.of());
        register(context, DENSE_RICH_GRASS_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.DENSE_RICH_GRASS_PATCH), simpleSpawn(1));

    }

    private static List<PlacementModifier> simpleSpawn(int chance) {
        return List.of(
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome()
        );
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
