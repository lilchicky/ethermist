package com.gmail.thelilchicken01.ethermist.datagen.structure.pools;

import com.gmail.thelilchicken01.ethermist.datagen.structure.EMProcessors;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class PortalPools extends EMTemplatePool {
    private static final String FOLDER = "portals/";
    
    public static final ResourceKey<StructureTemplatePool> ANCIENT_STONE_START = create(FOLDER + "ancient_stone_start");
    private static final ResourceKey<StructureTemplatePool> ANCIENT_STONE_SIDE = create(FOLDER + "ancient_stone_side");

    public static final ResourceKey<StructureTemplatePool> SPARKLING_START = create(FOLDER + "sparkling_start");
    private static final ResourceKey<StructureTemplatePool> SPARKLING_SIDE = create(FOLDER + "sparkling_side");

    public static final ResourceKey<StructureTemplatePool> STONE_START = create(FOLDER + "stone_start");
    private static final ResourceKey<StructureTemplatePool> STONE_SIDE = create(FOLDER + "stone_side");

    public static final ResourceKey<StructureTemplatePool> TIMEWORN_START = create(FOLDER + "timeworn_start");
    private static final ResourceKey<StructureTemplatePool> TIMEWORN_SIDE = create(FOLDER + "timeworn_side");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureProcessorList> glimmerbug_cave = processors.getOrThrow(EMProcessors.GLIMMERBUG_CAVE);

        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);

        // Ancient Stone Portal
        context.register(
                ANCIENT_STONE_START,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "ancient_base", EMPTY_PROCESSOR, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
        context.register(
                ANCIENT_STONE_SIDE,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "medium_ancient_frame", EMPTY_PROCESSOR, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        // Sparkling Portal
        context.register(
                SPARKLING_START,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "sparkling_base", EMPTY_PROCESSOR, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
        context.register(
                SPARKLING_SIDE,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "medium_sparkling_frame", EMPTY_PROCESSOR, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        // Stone Portal
        context.register(
                STONE_START,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "stone_base", EMPTY_PROCESSOR, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
        context.register(
                STONE_SIDE,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "medium_stone_frame", EMPTY_PROCESSOR, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        // Timeworn Portal
        context.register(
                TIMEWORN_START,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "timeworn_base", EMPTY_PROCESSOR, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
        context.register(
                TIMEWORN_SIDE,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "medium_timeworn_frame", EMPTY_PROCESSOR, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
