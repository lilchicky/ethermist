package com.gmail.thelilchicken01.ethermist.datagen.structure;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.List;

public class EMProcessors {

    public static final ResourceKey<StructureProcessorList> FORGEMASTER_GENERAL = create("forgemaster_general");
    public static final ResourceKey<StructureProcessorList> GENERIC_RUINS = create("generic_ruins");

    public EMProcessors() {}

    private static ResourceKey<StructureProcessorList> create(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
    }

    private static void register(BootstrapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, List<StructureProcessor> processors) {
        context.register(key, new StructureProcessorList(processors));
    }

    public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

        register(context, GENERIC_RUINS, List.of(
                new BlockRotProcessor(0.05f),
                new RuleProcessor(
                        List.of(
                                new ProcessorRule(
                                        new RandomBlockMatchTest(EMBlocks.ETHERSTONE_BRICKS.get(), 0.04f),
                                        AlwaysTrueTest.INSTANCE,
                                        EMBlocks.MOSSY_ETHERSTONE_BRICKS.get().defaultBlockState()
                                )
                        )
                ),
                new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE)
        ));
    }

}
