package com.gmail.thelilchicken01.ethermist.worldgen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class EMOreFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_COAL = registerKey("ore_coal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_COAL_BURIED = registerKey("ore_coal_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_IRON = registerKey("ore_iron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_IRON_SMALL = registerKey("ore_iron_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_GOLD = registerKey("ore_gold");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_GOLD_BURIED = registerKey("ore_gold_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_REDSTONE = registerKey("ore_redstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_DIAMOND_SMALL = registerKey("ore_diamond_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_DIAMOND_MEDIUM = registerKey("ore_diamond_medium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_DIAMOND_LARGE = registerKey("ore_diamond_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_DIAMOND_BURIED = registerKey("ore_diamond_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_LAPIS = registerKey("ore_lapis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_LAPIS_BURIED = registerKey("ore_lapis_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_EMERALD = registerKey("ore_emerald");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHERSTONE_ORE_COPPER_SMALL = registerKey("ore_copper_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RICH_DIRT_BLOB = registerKey("rich_dirt_blob");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRUMBLING_ETHERSTONE_BLOB = registerKey("crumbling_etherstone_blob");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WITCHSTONE_BLOB = registerKey("witchstone_blob");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest ethermistStones = new TagMatchTest(EMTags.Blocks.ETHERMIST_STONES);
        RuleTest etherstoneRule = new TagMatchTest(EMTags.Blocks.ETHERSTONE_ORE_REPLACEABLES);
        RuleTest ancientEtherstoneRule = new TagMatchTest(EMTags.Blocks.ANCIENT_ETHERSTONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> iron = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(ancientEtherstoneRule, EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> gold = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(ancientEtherstoneRule, EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> diamond = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_DIAMOND_ORE.get().defaultBlockState()),
                OreConfiguration.target(ancientEtherstoneRule, EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> lapis = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_LAPIS_ORE.get().defaultBlockState()),
                OreConfiguration.target(ancientEtherstoneRule, EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> copper = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(ancientEtherstoneRule, EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> coal = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(ancientEtherstoneRule, EMBlocks.ANCIENT_ETHERSTONE_COAL_ORE.get().defaultBlockState())
        );

        register(context, ETHERSTONE_ORE_COAL, Feature.ORE, new OreConfiguration(coal, 17));
        register(context, ETHERSTONE_ORE_COAL_BURIED, Feature.ORE, new OreConfiguration(coal, 17, 0.5F));
        register(context, ETHERSTONE_ORE_IRON, Feature.ORE, new OreConfiguration(iron, 9));
        register(context, ETHERSTONE_ORE_IRON_SMALL, Feature.ORE, new OreConfiguration(iron, 4));
        register(context, ETHERSTONE_ORE_GOLD, Feature.ORE, new OreConfiguration(gold, 9));
        register(context, ETHERSTONE_ORE_GOLD_BURIED, Feature.ORE, new OreConfiguration(gold, 9, 0.5F));
        register(
                context,
                ETHERSTONE_ORE_REDSTONE,
                Feature.ORE,
                new OreConfiguration(
                        List.of(
                                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_REDSTONE_ORE.get().defaultBlockState()),
                                OreConfiguration.target(ancientEtherstoneRule, EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get().defaultBlockState())
                        ),
                        8
                )
        );
        register(context, ETHERSTONE_ORE_DIAMOND_SMALL, Feature.ORE, new OreConfiguration(diamond, 4, 0.5F));
        register(context, ETHERSTONE_ORE_DIAMOND_LARGE, Feature.ORE, new OreConfiguration(diamond, 12, 0.7F));
        register(context, ETHERSTONE_ORE_DIAMOND_BURIED, Feature.ORE, new OreConfiguration(diamond, 8, 1.0F));
        register(context, ETHERSTONE_ORE_DIAMOND_MEDIUM, Feature.ORE, new OreConfiguration(diamond, 8, 0.5F));
        register(context, ETHERSTONE_ORE_LAPIS, Feature.ORE, new OreConfiguration(lapis, 7));
        register(context, ETHERSTONE_ORE_LAPIS_BURIED, Feature.ORE, new OreConfiguration(lapis, 7, 1.0F));
        register(
                context,
                ETHERSTONE_ORE_EMERALD,
                Feature.ORE,
                new OreConfiguration(
                        List.of(
                                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_EMERALD_ORE.get().defaultBlockState()),
                                OreConfiguration.target(ancientEtherstoneRule, EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get().defaultBlockState())
                        ),
                        3
                )
        );
        register(context, ETHERSTONE_ORE_COPPER_SMALL, Feature.ORE, new OreConfiguration(copper, 10));

        register(context, RICH_DIRT_BLOB, Feature.ORE, new OreConfiguration(ethermistStones, EMBlocks.RICH_DIRT.get().defaultBlockState(), 33));
        register(context, CRUMBLING_ETHERSTONE_BLOB, Feature.ORE, new OreConfiguration(ethermistStones, EMBlocks.CRUMBLING_ETHERSTONE.get().defaultBlockState(), 33));
        register(context, WITCHSTONE_BLOB, Feature.ORE, new OreConfiguration(ethermistStones, EMBlocks.WITCHSTONE.get().defaultBlockState(), 64));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
