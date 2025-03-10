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

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest etherstoneRule = new TagMatchTest(EMTags.Blocks.ETHERSTONE_ORE_REPLACEABLES);
        RuleTest ruletest2 = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> iron = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_IRON_ORE.get().defaultBlockState()),
                OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> gold = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_GOLD_ORE.get().defaultBlockState()),
                OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> diamond = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_DIAMOND_ORE.get().defaultBlockState()),
                OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> lapis = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_LAPIS_ORE.get().defaultBlockState()),
                OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> copper = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_COPPER_ORE.get().defaultBlockState()),
                OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> coal = List.of(
                OreConfiguration.target(etherstoneRule, EMBlocks.ETHERSTONE_COAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_COAL_ORE.defaultBlockState())
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
                                OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState())
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
                                OreConfiguration.target(ruletest2, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState())
                        ),
                        3
                )
        );
        register(context, ETHERSTONE_ORE_COPPER_SMALL, Feature.ORE, new OreConfiguration(copper, 10));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
