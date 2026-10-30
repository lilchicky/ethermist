package com.gmail.thelilchicken01.ethermist.datagen.structure;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.ArrayList;
import java.util.List;

public class EMProcessors {

    public static final ResourceKey<StructureProcessorList> FORGEMASTER_GENERAL = create("forgemaster_general");
    public static final ResourceKey<StructureProcessorList> GENERIC_RUINS = create("generic_ruins");
    public static final ResourceKey<StructureProcessorList> GLIMMERBUG_CAVE = create("glimmerbug_cave");

    public EMProcessors() {}

    private static ResourceKey<StructureProcessorList> create(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
    }

    private static void register(BootstrapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, List<StructureProcessor> processors) {
        context.register(key, new StructureProcessorList(processors));
    }

    public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

        register(context, FORGEMASTER_GENERAL, List.of(
                new BlockRotProcessor(0.95f),
                new RuleProcessor(
                        List.of(
                                replace(EMBlocks.ETHERSTONE_BRICKS.get(), EMBlocks.MOSSY_ETHERSTONE_BRICKS.get(), 0.04f)
                        )
                ),
                new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE)
        ));

        register(context, GLIMMERBUG_CAVE, List.of(
                new RuleProcessor(
                        List.of(
                                replace(EMBlocks.RICH_DIRT.get(), EMBlocks.GLIMMERBUG_HIVE.get(), 0.01f),
                                replace(EMBlocks.RICH_GRASS_BLOCK.get(), EMBlocks.RICH_DIRT.get(), 0.5f),
                                replace(EMBlocks.RICH_GRASS.get(), Blocks.AIR, 0.5f)
                        )
                ),
                defaultTreasureMound(Blocks.RAW_IRON_BLOCK, 0.1f),
                new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE)
        ));
    }

    public static ProcessorRule replace(Block fromBlock, Block toBlock, float probability) {
        return new ProcessorRule(
                new RandomBlockMatchTest(fromBlock, probability),
                AlwaysTrueTest.INSTANCE,
                toBlock.defaultBlockState()
        );
    }

    public static RuleProcessor treasureMound(Block fromBlock, List<Block> toBlocks, float chanceToUpgrade) {
        // Replaces a block with some default collection of treasure blocks.
        // Usually raw iron block, since some of the original blocks will remain. (hence why there is no raw iron block in this list)
        List<ProcessorRule> rules = new ArrayList<>();

        for (Block block : toBlocks) {
            rules.add(
                    replace(fromBlock, block, chanceToUpgrade)
            );
        }

        return new RuleProcessor(rules);
    }

    public static RuleProcessor defaultTreasureMound(Block fromBlock, float chanceToUpgrade) {
        return treasureMound(
                fromBlock,
                List.of(
                        EMBlocks.ETHERSTONE_COAL_ORE.get(),
                        EMBlocks.ETHERSTONE_COPPER_ORE.get(),
                        EMBlocks.ETHERSTONE_IRON_ORE.get(),
                        Blocks.RAW_COPPER_BLOCK,
                        EMBlocks.ETHERSTONE_GOLD_ORE.get(),
                        Blocks.RAW_GOLD_BLOCK,
                        EMBlocks.ETHERSTONE_IRON_ORE.get(),
                        EMBlocks.ETHERSTONE_DIAMOND_ORE.get(),
                        Blocks.IRON_BLOCK,
                        Blocks.GOLD_BLOCK
                ),
                chanceToUpgrade
        );
    }

}
