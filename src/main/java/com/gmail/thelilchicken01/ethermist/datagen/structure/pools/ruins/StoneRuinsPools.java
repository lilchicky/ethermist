package com.gmail.thelilchicken01.ethermist.datagen.structure.pools.ruins;

import com.gmail.thelilchicken01.ethermist.datagen.structure.EMProcessors;
import com.gmail.thelilchicken01.ethermist.datagen.structure.EMStructureConstants;
import com.gmail.thelilchicken01.ethermist.datagen.structure.pools.EMTemplatePool;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class StoneRuinsPools extends EMTemplatePool {
    private static final String FOLDER = EMStructureConstants.STONE_RUINS.getNamedFolder();

    public static final ResourceKey<StructureTemplatePool> START = create(EMStructureConstants.STONE_RUINS.getFolder() + "stone_pool");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureProcessorList> stone_ruins = processors.getOrThrow(EMProcessors.STONE_RUINS);

        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);

        context.register(
                START,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "pillar_broken", stone_ruins, 1),
                                single(FOLDER, "pillar_carved", stone_ruins, 1),
                                single(FOLDER, "pillar_mossy", stone_ruins, 1),
                                single(FOLDER, "pillar_pair", stone_ruins, 1),
                                single(FOLDER, "pillar_fancy", stone_ruins, 1),
                                single(FOLDER, "arch_castle", stone_ruins, 1),
                                single(FOLDER, "arch_ruined", stone_ruins, 1),
                                single(FOLDER, "arch_mossy", stone_ruins, 1),
                                single(FOLDER, "wall_tiny", stone_ruins, 1),
                                single(FOLDER, "wall_small", stone_ruins, 1),
                                single(FOLDER, "wall_medium", stone_ruins, 1),
                                single(FOLDER, "wall_large", stone_ruins, 1),
                                single(FOLDER, "wall_small_plus", stone_ruins, 1),
                                single(FOLDER, "wall_small_t", stone_ruins, 1),
                                single(FOLDER, "wall_mossy", stone_ruins, 1),
                                single(FOLDER, "gate_stone_small", stone_ruins, 1),
                                single(FOLDER, "gate_stone_large", stone_ruins, 1),
                                single(FOLDER, "well_stone", stone_ruins, 1),
                                single(FOLDER, "well_mossy", stone_ruins, 1),
                                single(FOLDER, "well_dry", stone_ruins, 1),
                                single(FOLDER, "well_grand", stone_ruins, 1),
                                single(FOLDER, "fountain_large", stone_ruins, 1),
                                single(FOLDER, "fountain_small", stone_ruins, 1),
                                single(FOLDER, "fountain_broken", stone_ruins, 1),
                                single(FOLDER, "altar_small", stone_ruins, 1),
                                single(FOLDER, "altar_end", stone_ruins, 1),
                                single(FOLDER, "altar_mossy", stone_ruins, 1),
                                single(FOLDER, "altar_ruined", stone_ruins, 1),
                                single(FOLDER, "statue_axolotl", stone_ruins, 1),
                                single(FOLDER, "statue_frog", stone_ruins, 1),
                                single(FOLDER, "statue_gloomie", stone_ruins, 1),
                                single(FOLDER, "obelisk", stone_ruins, 1),
                                single(FOLDER, "marker_stone", stone_ruins, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
