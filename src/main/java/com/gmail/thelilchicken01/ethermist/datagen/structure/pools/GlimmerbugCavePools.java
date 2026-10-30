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

public class GlimmerbugCavePools extends EMTemplatePool {
    private static final String FOLDER = "glimmerbug_cave/";

    public static final ResourceKey<StructureTemplatePool> START = create(FOLDER + "start_pool");
    private static final ResourceKey<StructureTemplatePool> FALLBACK = create(FOLDER + "fallback_pool");
    private static final ResourceKey<StructureTemplatePool> HALLWAY = create(FOLDER + "hallway_pool");
    private static final ResourceKey<StructureTemplatePool> ROOM = create(FOLDER + "room_pool");

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);
        Holder<StructureProcessorList> glimmerbug_cave = processors.getOrThrow(EMProcessors.GLIMMERBUG_CAVE);

        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);
        Holder<StructureTemplatePool> fallback = pools.getOrThrow(FALLBACK);

        context.register(
                START,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "mound", glimmerbug_cave, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        context.register(
                FALLBACK,
                new StructureTemplatePool(
                        empty,
                        List.of(
                                single(FOLDER, "hallway_end", glimmerbug_cave, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        context.register(
                HALLWAY,
                new StructureTemplatePool(
                        fallback,
                        List.of(
                                single(FOLDER, "hallway_four_down", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_four_flat", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_left", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_right", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_up", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_wiggle", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_up_big", glimmerbug_cave, 2)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        context.register(
                ROOM,
                new StructureTemplatePool(
                        fallback,
                        List.of(
                                single(FOLDER, "hallway_four_down", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_four_flat", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_left", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_right", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_up", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_wiggle", glimmerbug_cave, 1),
                                single(FOLDER, "hallway_up_big", glimmerbug_cave, 2),
                                single(FOLDER, "small_room_1", glimmerbug_cave, 2),
                                single(FOLDER, "small_room_2", glimmerbug_cave, 2),
                                single(FOLDER, "small_room_3", glimmerbug_cave, 2),
                                single(FOLDER, "small_room_4", glimmerbug_cave, 2),
                                single(FOLDER, "small_room_5", glimmerbug_cave, 2),
                                single(FOLDER, "main_room", glimmerbug_cave, 2),
                                single(FOLDER, "treasure_room", glimmerbug_cave, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
