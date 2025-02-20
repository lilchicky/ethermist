package com.gmail.thelilchicken01.ethermist.worldgen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EMPlacedFeatures {

    public static final ResourceKey<PlacedFeature> MEGA_GLIMMERING_ANCIENT_PLACED_TREE_KEY = registerKey("mega_glimmering_ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> GLIMMERING_ANCIENT_PLACED_TREE_KEY = registerKey("glimmering_ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> MEGA_ANCIENT_PLACED_TREE_KEY = registerKey("mega_ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> ANCIENT_PLACED_TREE_KEY = registerKey("ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> SPARSE_ANCIENT_PLACED_TREE_KEY = registerKey("sparse_ancient_tree_placed");

    public static final ResourceKey<PlacedFeature> SLIMY_PLACED_TREE_KEY = registerKey("slimy_tree_placed");

    public static final ResourceKey<PlacedFeature> BLUE_PLACED_ABYSSAL_MUSHROOM = registerKey("blue_abyssal_mushroom_placed");

    public static final ResourceKey<PlacedFeature> ORANGE_PLACED_ABYSSAL_MUSHROOM = registerKey("orange_abyssal_mushroom_placed");

    public static final ResourceKey<PlacedFeature> FROSTPINE_PLACED_TREE_KEY = registerKey("frostpine_tree_placed");

    public static final ResourceKey<PlacedFeature> ETHERMIST_LAVA_LAKE_PLACED_KEY = registerKey("ethermist_lava_lake_placed");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_BOULDER_PLACED_KEY = registerKey("etherstone_boulder_placed");
    public static final ResourceKey<PlacedFeature> AMETHYST_SPIKE_PLACED_KEY = registerKey("amethyst_spike_placed");
    public static final ResourceKey<PlacedFeature> SMALL_AMETHYST_SPIKE_PLACED_KEY = registerKey("small_amethyst_spike_placed");

    public static final ResourceKey<PlacedFeature> GLIMMER_BLOSSOM_PATCH_KEY = registerKey("glimmer_blossom_patch_placed");
    public static final ResourceKey<PlacedFeature> NIGHTBELL_PATCH_KEY = registerKey("nightbell_patch_placed");
    public static final ResourceKey<PlacedFeature> WITCH_LAVENDER_PATCH_KEY = registerKey("witch_lavender_patch_placed");
    public static final ResourceKey<PlacedFeature> DENSE_SLIMY_ALLIUM_PATCH_KEY = registerKey("dense_slimy_allium_placed");

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
                        BiomeFilter.biome()
                )
        );

        register(context, SLIMY_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.SLIMY_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2),
                        EMBlocks.SLIMY_SAPLING.get()));

        register(context, FROSTPINE_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.FROSTPINE_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2),
                        EMBlocks.FROSTPINE_SAPLING.get()));

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

        register(context, ETHERMIST_LAVA_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ETHERMIST_LAVA_LAKE),
                List.of(
                        RarityFilter.onAverageOnceEvery(200),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, ETHERSTONE_BOULDER_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ETHERSTONE_BOULDER_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, AMETHYST_SPIKE_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.AMETHYST_SPIKE_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, SMALL_AMETHYST_SPIKE_PLACED_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.SMALL_AMETHYST_SPIKE_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, GLIMMER_BLOSSOM_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.GLIMMER_BLOSSOM_PATCH),
                List.of(
                        RarityFilter.onAverageOnceEvery(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, NIGHTBELL_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.NIGHTBELL_PATCH),
                List.of(
                        RarityFilter.onAverageOnceEvery(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, WITCH_LAVENDER_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.WITCH_LAVENDER_PATCH),
                List.of(
                        RarityFilter.onAverageOnceEvery(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, DENSE_SLIMY_ALLIUM_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.DENSE_SLIMY_ALLIUM_PATCH),
                List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, RICH_GRASS_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.RICH_GRASS_PATCH),
                List.of(
                        RarityFilter.onAverageOnceEvery(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        register(context, RICH_GRASS_BONEMEAL_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.BONEMEAL_RICH_GRASS_PATCH),
                List.of()
        );

        register(context, DENSE_RICH_GRASS_PATCH_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.DENSE_RICH_GRASS_PATCH),
                List.of(
                        RarityFilter.onAverageOnceEvery(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
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
