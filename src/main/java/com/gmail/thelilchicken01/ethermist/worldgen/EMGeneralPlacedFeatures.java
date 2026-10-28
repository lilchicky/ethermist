package com.gmail.thelilchicken01.ethermist.worldgen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.VeryBiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class EMGeneralPlacedFeatures {

    public static final ResourceKey<PlacedFeature> MEGA_GLIMMERING_ANCIENT_TREE = registerKey("mega_glimmering_ancient_tree");
    public static final ResourceKey<PlacedFeature> GLIMMERING_ANCIENT_TREE = registerKey("glimmering_ancient_tree");
    public static final ResourceKey<PlacedFeature> MEGA_ANCIENT_TREE = registerKey("mega_ancient_tree");
    public static final ResourceKey<PlacedFeature> ANCIENT_TREE = registerKey("ancient_tree");
    public static final ResourceKey<PlacedFeature> SPARSE_ANCIENT_TREE = registerKey("sparse_ancient_tree");
    public static final ResourceKey<PlacedFeature> SPARSE_FROSTPINE_TREE = registerKey("sparse_frostpine_tree");
    public static final ResourceKey<PlacedFeature> CHARRED_TREE_STUMP = registerKey("charred_tree_stump");
    public static final ResourceKey<PlacedFeature> CHARRED_TREE = registerKey("charred_tree");

    public static final ResourceKey<PlacedFeature> RED_AMBERWOOD_TREE = registerKey("red_amberwood_tree");
    public static final ResourceKey<PlacedFeature> ORANGE_AMBERWOOD_TREE = registerKey("orange_amberwood_tree");
    public static final ResourceKey<PlacedFeature> YELLOW_AMBERWOOD_TREE = registerKey("yellow_amberwood_tree");
    public static final ResourceKey<PlacedFeature> GREEN_AMBERWOOD_TREE = registerKey("green_amberwood_tree");

    public static final ResourceKey<PlacedFeature> BUSH_TREE = registerKey("bush_tree");

    public static final ResourceKey<PlacedFeature> SLIMY_TREE = registerKey("slimy_tree");

    public static final ResourceKey<PlacedFeature> LARGE_ABYSSAL_MUSHROOM = registerKey("large_abyssal_mushroom");
    public static final ResourceKey<PlacedFeature> SPARSE_LARGE_ABYSSAL_MUSHROOM = registerKey("sparse_large_abyssal_mushroom");

    public static final ResourceKey<PlacedFeature> FROSTPINE_TREE = registerKey("frostpine_tree");

    public static final ResourceKey<PlacedFeature> ETHERMIST_LAVA_LAKE = registerKey("ethermist_lava_lake");
    public static final ResourceKey<PlacedFeature> DENSE_ETHERMIST_LAVA_LAKE_PLACED_KEY = registerKey("dense_ethermist_lava_lake");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_BOULDER = registerKey("etherstone_boulder");
    public static final ResourceKey<PlacedFeature> MOLTEN_ETHERSTONE_DISK = registerKey("molten_etherstone_disk");
    public static final ResourceKey<PlacedFeature> CRUMBLING_ETHERSTONE_DISK = registerKey("crumbling_etherstone_disk");
    public static final ResourceKey<PlacedFeature> SPARKLING_SAND_DISK = registerKey("sparkling_sand_disk");
    public static final ResourceKey<PlacedFeature> AMETHYST_SPIKE = registerKey("amethyst_spike");
    public static final ResourceKey<PlacedFeature> SMALL_AMETHYST_SPIKE = registerKey("small_amethyst_spike");
    public static final ResourceKey<PlacedFeature> ICICLE_GROUND = registerKey("icicle_ground");
    public static final ResourceKey<PlacedFeature> CRAG_SPIKE = registerKey("crag_spike");
    public static final ResourceKey<PlacedFeature> CHARRED_DEAD_LOG = registerKey("charred_dead_log");
    public static final ResourceKey<PlacedFeature> ABYSSAL_FOSSIL = registerKey("abyssal_fossil");

    public static final ResourceKey<PlacedFeature> EM_LAVA_SPRING = registerKey("lava_spring");
    public static final ResourceKey<PlacedFeature> EM_DENSE_LAVA_SPRING = registerKey("dense_lava_spring");
    public static final ResourceKey<PlacedFeature> EM_WATER_SPRING = registerKey("water_spring");

    public static final ResourceKey<PlacedFeature> GLIMMERBUD_PATCH = registerKey("glimmerbud_patch");
    public static final ResourceKey<PlacedFeature> NIGHTBELL_PATCH = registerKey("nightbell_patch");
    public static final ResourceKey<PlacedFeature> WITCH_LAVENDER_PATCH = registerKey("witch_lavender_patch");
    public static final ResourceKey<PlacedFeature> DAWNING_HYACINTH_PATCH = registerKey("dawning_hyacinth_patch");
    public static final ResourceKey<PlacedFeature> DENSE_SLIMY_ALLIUM_PATCH = registerKey("dense_slimy_allium");
    public static final ResourceKey<PlacedFeature> CHRONOTHORN_PATCH = registerKey("chronothorn_patch");
    public static final ResourceKey<PlacedFeature> CINDERBLOOM_PATCH = registerKey("cinderbloom_patch");
    public static final ResourceKey<PlacedFeature> ETHERMIST_GLOW_LICHEN = registerKey("ethermist_glow_lichen");
    public static final ResourceKey<PlacedFeature> PYRUSCIA_PATCH = registerKey("pyruscia_patch");

    public static final ResourceKey<PlacedFeature> SOURDEW_PATCH = registerKey("sourdew_patch");

    public static final ResourceKey<PlacedFeature> DENSE_NIGHTBELL_PATCH = registerKey("dense_nightbell_patch");
    public static final ResourceKey<PlacedFeature> DENSE_WITCH_LAVENDER_PATCH = registerKey("dense_witch_lavender_patch");
    public static final ResourceKey<PlacedFeature> DENSE_DAWNING_HYACINTH_PATCH = registerKey("dense_dawning_hyacinth_patch");
    public static final ResourceKey<PlacedFeature> DENSE_PYRUSCIA_PATCH = registerKey("dense_pyruscia_patch");

    public static final ResourceKey<PlacedFeature> FALLEN_AMBERWOOD_LEAVES = registerKey("fallen_amberwood_leaves");
    public static final ResourceKey<PlacedFeature> SMALL_ABYSSAL_MUSHROOM_PATCH = registerKey("small_abyssal_mushroom_patch");
    public static final ResourceKey<PlacedFeature> LARGE_ABYSSAL_MUSHROOM_PATCH = registerKey("large_abyssal_mushroom_patch");

    public static final ResourceKey<PlacedFeature> SMALL_GROUNDED_ABYSSAL_MUSHROOM_PATCH = registerKey("small_grounded_abyssal_mushroom_patch");
    public static final ResourceKey<PlacedFeature> LARGE_GROUNDED_ABYSSAL_MUSHROOM_PATCH = registerKey("large_grounded_abyssal_mushroom_patch");

    public static final ResourceKey<PlacedFeature> RICH_GRASS_PATCH = registerKey("rich_grass_patch");
    public static final ResourceKey<PlacedFeature> RICH_TALL_GRASS_PATCH = registerKey("rich_tall_grass_patch");
    public static final ResourceKey<PlacedFeature> RICH_GRASS_BONEMEAL_KEY = registerKey("rich_grass_bonemeal");
    public static final ResourceKey<PlacedFeature> DENSE_RICH_GRASS_PATCH = registerKey("dense_rich_grass_patch");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MEGA_GLIMMERING_ANCIENT_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.MEGA_GLIMMERING_ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.GLIMMERING_ANCIENT_SAPLING.get()));

        register(context, GLIMMERING_ANCIENT_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.GLIMMERING_ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.5f, 2),
                        EMBlocks.GLIMMERING_ANCIENT_SAPLING.get()));

        register(context, BUSH_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.BUSH_TREES_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.5f, 2),
                        EMBlocks.GLIMMERING_ANCIENT_SAPLING.get()));

        register(context, MEGA_ANCIENT_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.MEGA_ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.ANCIENT_SAPLING.get()));

        register(context, ANCIENT_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.5f, 2),
                        EMBlocks.ANCIENT_SAPLING.get()));

        register(context, SPARSE_ANCIENT_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.ANCIENT_TREE_KEY),
                List.of(
                        CountPlacement.of(128),
                        RarityFilter.onAverageOnceEvery(48),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EMBlocks.ANCIENT_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
                )
        );

        register(context, SPARSE_FROSTPINE_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.FROSTPINE_TREE_KEY),
                List.of(
                        CountPlacement.of(128),
                        RarityFilter.onAverageOnceEvery(24),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EMBlocks.FROSTPINE_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
                )
        );

        register(context, SLIMY_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.SLIMY_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2),
                        EMBlocks.SLIMY_SAPLING.get()));

        register(context, FROSTPINE_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.FROSTPINE_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2),
                        EMBlocks.FROSTPINE_SAPLING.get()));

        register(context, CHARRED_TREE_STUMP, configuredFeatures.getOrThrow(EMGeneralFeatures.CHARRED_TREE_STUMP_KEY),
                List.of(
                        CountPlacement.of(128),
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EMBlocks.CHARRED_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
                )
        );

        register(context, CHARRED_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.CHARRED_TREE_KEY),
                List.of(
                        CountPlacement.of(128),
                        RarityFilter.onAverageOnceEvery(2),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EMBlocks.CHARRED_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
                )
        );

        // Small Amberwood Tree
        register(context, RED_AMBERWOOD_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.RED_AMBERWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.RED_AMBERWOOD_SAPLING.get()));
        register(context, ORANGE_AMBERWOOD_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.ORANGE_AMBERWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.ORANGE_AMBERWOOD_SAPLING.get()));
        register(context, YELLOW_AMBERWOOD_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.YELLOW_AMBERWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.YELLOW_AMBERWOOD_SAPLING.get()));
        register(context, GREEN_AMBERWOOD_TREE, configuredFeatures.getOrThrow(EMGeneralFeatures.GREEN_AMBERWOOD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5f, 2),
                        EMBlocks.GREEN_AMBERWOOD_SAPLING.get()));

        register(context, LARGE_ABYSSAL_MUSHROOM, configuredFeatures.getOrThrow(EMGeneralFeatures.LARGE_ABYSSAL_MUSHROOM_KEY), ignoreWaterSpawnNoise(10));
        register(context, SPARSE_LARGE_ABYSSAL_MUSHROOM, configuredFeatures.getOrThrow(EMGeneralFeatures.LARGE_ABYSSAL_MUSHROOM_KEY), ignoreWaterSpawnNoise(4));

        /*
        ---------- Biome Features ----------
         */

        register(context, ETHERMIST_LAVA_LAKE, configuredFeatures.getOrThrow(EMGeneralFeatures.ETHERMIST_LAVA_LAKE), simpleSpawn(200));
        register(context, DENSE_ETHERMIST_LAVA_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(EMGeneralFeatures.ETHERMIST_LAVA_LAKE), simpleSpawn(2));
        register(context, ETHERSTONE_BOULDER, configuredFeatures.getOrThrow(EMGeneralFeatures.ETHERSTONE_BOULDER_KEY), simpleSpawn(2));
        register(context, MOLTEN_ETHERSTONE_DISK, configuredFeatures.getOrThrow(EMGeneralFeatures.MOLTEN_ETHERSTONE_DISK_KEY), simpleSpawn(2));
        register(
                context,
                CRUMBLING_ETHERSTONE_DISK,
                configuredFeatures.getOrThrow(EMGeneralFeatures.CRUMBLING_ETHERSTONE_DISK_KEY),
                List.of(
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID,
                        BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)),
                        BiomeFilter.biome()
                )
        );
        register(
                context,
                SPARKLING_SAND_DISK,
                configuredFeatures.getOrThrow(EMGeneralFeatures.SPARKLING_SAND_DISK_KEY),
                List.of(
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID,
                        BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)),
                        BiomeFilter.biome()
                )
        );
        register(context, AMETHYST_SPIKE, configuredFeatures.getOrThrow(EMGeneralFeatures.AMETHYST_SPIKE_KEY), simpleSpawn(3));
        register(context, CRAG_SPIKE, configuredFeatures.getOrThrow(EMGeneralFeatures.CRAG_SPIKE_KEY), simpleSpawn(24));
        register(context, SMALL_AMETHYST_SPIKE, configuredFeatures.getOrThrow(EMGeneralFeatures.SMALL_AMETHYST_SPIKE_KEY), simpleSpawn(1));
        register(context, ICICLE_GROUND, configuredFeatures.getOrThrow(EMGeneralFeatures.ICICLE_GROUND_KEY), simpleSpawn(1));
        register(context, CHARRED_DEAD_LOG, configuredFeatures.getOrThrow(EMGeneralFeatures.CHARRED_DEAD_LOG_KEY), simpleSpawn(4));
        register(context, ABYSSAL_FOSSIL, configuredFeatures.getOrThrow(EMGeneralFeatures.ABYSSAL_FOSSIL_KEY), ignoreWaterSpawn(10));

        register(
                context,
                EM_LAVA_SPRING,
                configuredFeatures.getOrThrow(EMGeneralFeatures.EM_LAVA_SPRING_KEY),
                List.of(
                        CountPlacement.of(20),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)),
                        BiomeFilter.biome()
                )
        );

        register(
                context,
                EM_DENSE_LAVA_SPRING,
                configuredFeatures.getOrThrow(EMGeneralFeatures.EM_LAVA_SPRING_KEY),
                List.of(
                        CountPlacement.of(256),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()),
                        BiomeFilter.biome()
                )
        );

        register(
                context,
                EM_WATER_SPRING,
                configuredFeatures.getOrThrow(EMGeneralFeatures.EM_WATER_SPRING_KEY),
                List.of(
                        CountPlacement.of(25),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(192)),
                        BiomeFilter.biome()
                )
        );

        /*
        ---------- Flowers ----------
         */

        register(context, GLIMMERBUD_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.GLIMMERBUD_PATCH), simpleSpawn(1));
        register(context, NIGHTBELL_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.NIGHTBELL_PATCH), simpleSpawn(12));
        register(context, WITCH_LAVENDER_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.WITCH_LAVENDER_PATCH), simpleSpawn(12));
        register(context, DAWNING_HYACINTH_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.DAWNING_HYACINTH_PATCH), simpleSpawn(12));
        register(context, DENSE_SLIMY_ALLIUM_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.DENSE_SLIMY_ALLIUM_PATCH), simpleSpawn(2));
        register(context, DENSE_NIGHTBELL_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.DENSE_NIGHTBELL_PATCH), simpleSpawn(2));
        register(context, DENSE_PYRUSCIA_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.DENSE_PYRUSCIA_PATCH), simpleSpawn(4));
        register(context, DENSE_DAWNING_HYACINTH_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.DENSE_DAWNING_HYACINTH_PATCH), simpleSpawn(2));
        register(context, DENSE_WITCH_LAVENDER_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.DENSE_WITCH_LAVENDER_PATCH), simpleSpawn(2));
        register(context, CHRONOTHORN_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.CHRONOTHORN_PATCH), simpleSpawn(3));
        register(context, PYRUSCIA_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.PYRUSCIA_PATCH), simpleSpawn(16));
        register(
                context,
                CINDERBLOOM_PATCH,
                configuredFeatures.getOrThrow(EMGeneralFeatures.CINDERBLOOM_PATCH),
                List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.wouldSurvive(EMBlocks.CINDERBLOOM.get().defaultBlockState(), BlockPos.ZERO)
                        ),
                        BiomeFilter.biome()
                )
        );
        register(context, SOURDEW_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.SOURDEW_PATCH), simpleSpawn(128));
        register(context, SMALL_ABYSSAL_MUSHROOM_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.SMALL_ABYSSAL_MUSHROOM_PATCH), ignoreWaterSpawn(2));
        register(context, LARGE_ABYSSAL_MUSHROOM_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.LARGE_ABYSSAL_MUSHROOM_PATCH), ignoreWaterSpawn(2));

        register(context, SMALL_GROUNDED_ABYSSAL_MUSHROOM_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.SMALL_ABYSSAL_MUSHROOM_PATCH), simpleSpawn(2));
        register(context, LARGE_GROUNDED_ABYSSAL_MUSHROOM_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.LARGE_ABYSSAL_MUSHROOM_PATCH), simpleSpawn(2));

        /*
        ---------- Misc Plants ----------
         */

        register(context, FALLEN_AMBERWOOD_LEAVES, configuredFeatures.getOrThrow(EMGeneralFeatures.FALLEN_AMBERWOOD_LEAVES_PATCH), simpleSpawn(1));
        register(context, RICH_GRASS_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.RICH_GRASS_PATCH), simpleSpawn(1));
        register(context, RICH_TALL_GRASS_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.RICH_TALL_GRASS_PATCH), simpleSpawn(2));
        register(context, RICH_GRASS_BONEMEAL_KEY, configuredFeatures.getOrThrow(EMGeneralFeatures.BONEMEAL_RICH_GRASS_PATCH), List.of());
        register(context, DENSE_RICH_GRASS_PATCH, configuredFeatures.getOrThrow(EMGeneralFeatures.DENSE_RICH_GRASS_PATCH), simpleSpawn(1));

        register(
                context,
                ETHERMIST_GLOW_LICHEN,
                configuredFeatures.getOrThrow(EMGeneralFeatures.ETHERMIST_GLOW_LICHEN),
                List.of(
                        CountPlacement.of(UniformInt.of(104, 157)),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        InSquarePlacement.spread(),
                        SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
                        BiomeFilter.biome()
                )
        );

    }

    private static List<PlacementModifier> simpleSpawn(int chance) {
        return List.of(
                CountPlacement.of(128),
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.matchesTag(
                                Direction.DOWN.getNormal(),
                                EMTags.Blocks.ETHERMIST_SURFACE_BLOCKS
                        )
                ),
                BiomeFilter.biome()
        );
    }

    private static List<PlacementModifier> ignoreWaterSpawn(int chance) {
        return List.of(
                RarityFilter.onAverageOnceEvery(chance),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)),
                BiomeFilter.biome()
        );
    }

    private static List<PlacementModifier> ignoreWaterSpawnNoise(int noiseCount) {
        return List.of(
                NoiseBasedCountPlacement.of(noiseCount, 10.0, -0.1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BiomeFilter.biome()
        );
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
