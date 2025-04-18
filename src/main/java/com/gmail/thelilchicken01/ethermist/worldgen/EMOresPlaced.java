package com.gmail.thelilchicken01.ethermist.worldgen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EMOresPlaced {
    
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_COAL_UPPER = registerKey("etherstone_ore_coal_upper");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_COAL_LOWER = registerKey("etherstone_ore_coal_lower");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_IRON_UPPER = registerKey("etherstone_ore_iron_upper");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_IRON_MIDDLE = registerKey("etherstone_ore_iron_middle");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_IRON_SMALL = registerKey("etherstone_ore_iron_small");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_GOLD = registerKey("etherstone_ore_gold");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_GOLD_LOWER = registerKey("etherstone_ore_gold_lower");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_REDSTONE = registerKey("etherstone_ore_redstone");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_REDSTONE_LOWER = registerKey("etherstone_ore_redstone_lower");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_DIAMOND = registerKey("etherstone_ore_diamond");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_DIAMOND_MEDIUM = registerKey("etherstone_ore_diamond_medium");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_DIAMOND_LARGE = registerKey("etherstone_ore_diamond_large");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_DIAMOND_BURIED = registerKey("etherstone_ore_diamond_buried");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_LAPIS = registerKey("etherstone_ore_lapis");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_LAPIS_BURIED = registerKey("etherstone_ore_lapis_buried");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_EMERALD = registerKey("etherstone_ore_emerald");
    public static final ResourceKey<PlacedFeature> ETHERSTONE_ORE_COPPER = registerKey("etherstone_ore_copper");

    public static final ResourceKey<PlacedFeature> RICH_DIRT_BLOB_KEY = registerKey("rich_dirt_blob_placed");
    public static final ResourceKey<PlacedFeature> CRUMBLING_ETHERSTONE_BLOB_KEY = registerKey("crumbling_etherstone_blob_placed");
    public static final ResourceKey<PlacedFeature> WITCHSTONE_BLOB_UPPER_KEY = registerKey("witchstone_blob_upper_placed");
    public static final ResourceKey<PlacedFeature> WITCHSTONE_BLOB_LOWER_KEY = registerKey("witchstone_blob_lower_placed");
    public static final ResourceKey<PlacedFeature> DAWNSHALE_BLOB_UPPER_KEY = registerKey("dawnshale_blob_upper_placed");
    public static final ResourceKey<PlacedFeature> DAWNSHALE_BLOB_LOWER_KEY = registerKey("dawnshale_blob_lower_placed");

    public static final ResourceKey<PlacedFeature> BLACKSTONE_BLOB_UPPER_KEY = registerKey("blackstone_blob_upper_placed");
    public static final ResourceKey<PlacedFeature> BLACKSTONE_BLOB_LOWER_KEY = registerKey("blackstone_blob_lower_placed");
    public static final ResourceKey<PlacedFeature> CALCITE_BLOB_UPPER_KEY = registerKey("calcite_blob_upper_placed");
    public static final ResourceKey<PlacedFeature> CALCITE_BLOB_LOWER_KEY = registerKey("calcite_blob_lower_placed");
    public static final ResourceKey<PlacedFeature> BASALT_BLOB_UPPER_KEY = registerKey("basalt_blob_upper_placed");
    public static final ResourceKey<PlacedFeature> BASALT_BLOB_LOWER_KEY = registerKey("basalt_blob_lower_placed");

    private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightRange) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> coal = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_COAL);
        Holder<ConfiguredFeature<?, ?>> coal_buried = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_COAL_BURIED);
        Holder<ConfiguredFeature<?, ?>> iron = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_IRON);
        Holder<ConfiguredFeature<?, ?>> iron_small = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_IRON_SMALL);
        Holder<ConfiguredFeature<?, ?>> gold_buried = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_GOLD_BURIED);
        Holder<ConfiguredFeature<?, ?>> redstone = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_REDSTONE);
        Holder<ConfiguredFeature<?, ?>> diamond_small = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_DIAMOND_SMALL);
        Holder<ConfiguredFeature<?, ?>> diamond_medium = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_DIAMOND_MEDIUM);
        Holder<ConfiguredFeature<?, ?>> diamond_large = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_DIAMOND_LARGE);
        Holder<ConfiguredFeature<?, ?>> diamond_buried = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_DIAMOND_BURIED);
        Holder<ConfiguredFeature<?, ?>> lapis = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_LAPIS);
        Holder<ConfiguredFeature<?, ?>> lapis_buried = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_LAPIS_BURIED);
        Holder<ConfiguredFeature<?, ?>> emerald = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_EMERALD);
        Holder<ConfiguredFeature<?, ?>> copper_small = holdergetter.getOrThrow(EMOreFeatures.ETHERSTONE_ORE_COPPER_SMALL);
        Holder<ConfiguredFeature<?, ?>> rich_dirt_blob = holdergetter.getOrThrow(EMOreFeatures.RICH_DIRT_BLOB);
        Holder<ConfiguredFeature<?, ?>> crumbling_etherstone_blob = holdergetter.getOrThrow(EMOreFeatures.CRUMBLING_ETHERSTONE_BLOB);
        Holder<ConfiguredFeature<?, ?>> witchstone_blob = holdergetter.getOrThrow(EMOreFeatures.WITCHSTONE_BLOB);
        Holder<ConfiguredFeature<?, ?>> dawnshale_blob = holdergetter.getOrThrow(EMOreFeatures.DAWNSHALE_BLOB);
        Holder<ConfiguredFeature<?, ?>> blackstone_blob = holdergetter.getOrThrow(EMOreFeatures.BLACKSTONE_BLOB);
        Holder<ConfiguredFeature<?, ?>> calcite_blob = holdergetter.getOrThrow(EMOreFeatures.CALCITE_BLOB);
        Holder<ConfiguredFeature<?, ?>> basalt_blob = holdergetter.getOrThrow(EMOreFeatures.BASALT_BLOB);

        register(
                context, ETHERSTONE_ORE_COAL_UPPER, coal, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top()))
        );
        register(
                context,
                ETHERSTONE_ORE_COAL_LOWER,
                coal_buried,
                commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))
        );
        register(
                context,
                ETHERSTONE_ORE_IRON_UPPER,
                iron,
                commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)))
        );
        register(
                context,
                ETHERSTONE_ORE_IRON_MIDDLE,
                iron,
                commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))
        );
        register(
                context, ETHERSTONE_ORE_IRON_SMALL, iron_small, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72)))
        );
        register(
                context, ETHERSTONE_ORE_GOLD, gold_buried, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))
        );
        register(
                context,
                ETHERSTONE_ORE_GOLD_LOWER,
                gold_buried,
                orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))
        );
        register(
                context, ETHERSTONE_ORE_REDSTONE, redstone, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)))
        );
        register(
                context,
                ETHERSTONE_ORE_REDSTONE_LOWER,
                redstone,
                commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)))
        );
        register(
                context,
                ETHERSTONE_ORE_DIAMOND,
                diamond_small,
                commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))
        );
        register(
                context,
                ETHERSTONE_ORE_DIAMOND_MEDIUM,
                diamond_medium,
                commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4)))
        );
        register(
                context,
                ETHERSTONE_ORE_DIAMOND_LARGE,
                diamond_large,
                rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))
        );
        register(
                context,
                ETHERSTONE_ORE_DIAMOND_BURIED,
                diamond_buried,
                commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))
        );
        register(
                context, ETHERSTONE_ORE_LAPIS, lapis, commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))
        );
        register(
                context, ETHERSTONE_ORE_LAPIS_BURIED, lapis_buried, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)))
        );
        register(
                context,
                ETHERSTONE_ORE_EMERALD,
                emerald,
                commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480)))
        );
        register(
                context, ETHERSTONE_ORE_COPPER, copper_small, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))
        );

        /*
        ----------  Non Ore Placements ----------
         */

        register(
                context,
                RICH_DIRT_BLOB_KEY,
                rich_dirt_blob,
                commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160)))
        );

        register(
                context,
                CRUMBLING_ETHERSTONE_BLOB_KEY,
                crumbling_etherstone_blob,
                commonOrePlacement(14, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()))
        );

        register(
                context,
                WITCHSTONE_BLOB_UPPER_KEY,
                witchstone_blob,
                rareOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128)))
        );
        register(
                context,
                WITCHSTONE_BLOB_LOWER_KEY,
                witchstone_blob,
                commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))
        );

        register(
                context,
                DAWNSHALE_BLOB_UPPER_KEY,
                dawnshale_blob,
                rareOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128)))
        );
        register(
                context,
                DAWNSHALE_BLOB_LOWER_KEY,
                dawnshale_blob,
                commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))
        );

        register(
                context,
                BLACKSTONE_BLOB_UPPER_KEY,
                blackstone_blob,
                rareOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128)))
        );
        register(
                context,
                BLACKSTONE_BLOB_LOWER_KEY,
                blackstone_blob,
                commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))
        );

        register(
                context,
                CALCITE_BLOB_UPPER_KEY,
                calcite_blob,
                rareOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128)))
        );
        register(
                context,
                CALCITE_BLOB_LOWER_KEY,
                calcite_blob,
                commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))
        );

        register(
                context,
                BASALT_BLOB_UPPER_KEY,
                basalt_blob,
                rareOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128)))
        );
        register(
                context,
                BASALT_BLOB_LOWER_KEY,
                basalt_blob,
                commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))
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
