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
import net.minecraft.world.level.levelgen.feature.VegetationPatchFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class EMPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ANCIENT_PLACED_TREE_KEY = registerKey("ancient_tree_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ANCIENT_PLACED_TREE_KEY, configuredFeatures.getOrThrow(EMConfiguredFeatures.ANCIENT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        EMBlocks.ANCIENT_SAPLING.get()));

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
