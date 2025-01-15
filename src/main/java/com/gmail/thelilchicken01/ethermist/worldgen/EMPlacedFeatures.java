package com.gmail.thelilchicken01.ethermist.worldgen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.VegetationPatchFeature;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EMPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ANCIENT_PLACED_TREE_KEY = registerKey("ancient_tree_placed");
    public static final ResourceKey<PlacedFeature> SLIMY_PLACED_TREE_KEY = registerKey("slimy_tree_placed");

    public static final ResourceKey<PlacedFeature> ETHERMIST_LAVA_LAKE_KEY = registerKey("ethermist_lava_lake_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ANCIENT_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        EMBlocks.ANCIENT_SAPLING.get()));

        register(context, SLIMY_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.SLIMY_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.1f, 2),
                        EMBlocks.SLIMY_SAPLING.get()));

        register(context, ETHERMIST_LAVA_LAKE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ETHERMIST_LAVA_LAKE),
                List.of(
                        RarityFilter.onAverageOnceEvery(200),
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
