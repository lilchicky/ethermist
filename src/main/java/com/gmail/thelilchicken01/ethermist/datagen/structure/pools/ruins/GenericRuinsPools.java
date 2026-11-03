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

public class GenericRuinsPools extends EMTemplatePool {
    private static final String FOLDER = EMStructureConstants.GENERIC_RUINS.getFolder();

    public static final ResourceKey<StructureTemplatePool> START = create(FOLDER + "start_pool");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureProcessorList> forgemaster_general = processors.getOrThrow(EMProcessors.FORGEMASTER_GENERAL);

        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);

        context.register(
                START,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "ruins1", forgemaster_general, 1),
                                single(FOLDER, "ruins2", forgemaster_general, 1),
                                single(FOLDER, "ruins3", forgemaster_general, 1),
                                single(FOLDER, "ruins4", forgemaster_general, 1),
                                single(FOLDER, "ruins5", forgemaster_general, 1),
                                single(FOLDER, "ruins6", forgemaster_general, 1),
                                single(FOLDER, "ruins7", forgemaster_general, 1),
                                single(FOLDER, "ruins8", forgemaster_general, 1),
                                single(FOLDER, "ruins9", forgemaster_general, 1),
                                single(FOLDER, "ruins10", forgemaster_general, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }

}
