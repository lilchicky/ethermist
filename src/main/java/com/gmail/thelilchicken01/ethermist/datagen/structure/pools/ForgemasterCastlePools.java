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

public class ForgemasterCastlePools extends EMTemplatePool {
    private static final String FOLDER = "forgemaster_castle/";

    public static final ResourceKey<StructureTemplatePool> START = create(FOLDER + "start_pool");
    private static final ResourceKey<StructureTemplatePool> FALLBACK = create(FOLDER + "fallback_pool");
    private static final ResourceKey<StructureTemplatePool> HALLWAY = create(FOLDER + "hallway_pool");
    private static final ResourceKey<StructureTemplatePool> ROOM = create(FOLDER + "room_pool");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureProcessorList> forgemaster_generic = processors.getOrThrow(EMProcessors.FORGEMASTER_GENERAL);

        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);
        Holder<StructureTemplatePool> fallback = pools.getOrThrow(FALLBACK);

        context.register(
                START,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "main_room", forgemaster_generic, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        context.register(
                FALLBACK,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "hallway_end", forgemaster_generic, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        context.register(
                HALLWAY,
                new StructureTemplatePool(
                        fallback,
                        List.of(
                                single(FOLDER, "hallway_basic", forgemaster_generic, 1),
                                single(FOLDER, "hallway_door", forgemaster_generic, 1),
                                single(FOLDER, "hallway_left", forgemaster_generic, 1),
                                single(FOLDER, "hallway_long", forgemaster_generic, 1),
                                single(FOLDER, "hallway_old", forgemaster_generic, 1),
                                single(FOLDER, "hallway_quadruple", forgemaster_generic, 1),
                                single(FOLDER, "hallway_quadruple_tower", forgemaster_generic, 1),
                                single(FOLDER, "hallway_right", forgemaster_generic, 1),
                                single(FOLDER, "hallway_triple", forgemaster_generic, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        context.register(
                ROOM,
                new StructureTemplatePool(
                        fallback,
                        List.of(
                            single(FOLDER, "hallway_basic", forgemaster_generic, 2),
                            single(FOLDER, "hallway_door", forgemaster_generic, 2),
                            single(FOLDER, "hallway_left", forgemaster_generic, 2),
                            single(FOLDER, "hallway_long", forgemaster_generic, 2),
                            single(FOLDER, "hallway_old", forgemaster_generic, 2),
                            single(FOLDER, "hallway_quadruple", forgemaster_generic, 1),
                            single(FOLDER, "hallway_quadruple_tower", forgemaster_generic, 1),
                            single(FOLDER, "hallway_right", forgemaster_generic, 2),
                            single(FOLDER, "hallway_triple", forgemaster_generic, 1),
                            single(FOLDER, "bedroom", forgemaster_generic, 4),
                            single(FOLDER, "forge", forgemaster_generic, 2),
                            single(FOLDER, "jail", forgemaster_generic, 4),
                            single(FOLDER, "kitchen", forgemaster_generic, 4),
                            single(FOLDER, "library", forgemaster_generic, 4),
                            single(FOLDER, "tower", forgemaster_generic, 3),
                            single(FOLDER, "treasure_room", forgemaster_generic, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
