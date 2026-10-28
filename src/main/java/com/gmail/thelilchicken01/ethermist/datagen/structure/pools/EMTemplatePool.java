package com.gmail.thelilchicken01.ethermist.datagen.structure.pools;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.function.Function;

public class EMTemplatePool {
    public static ResourceKey<StructureTemplatePool> create(String key) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, key));
    }

    public static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> single(String folder, String path, Holder<StructureProcessorList> processor, int weight) {
        return single(folder + path, processor, weight);
    }

    public static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> single(String path, Holder<StructureProcessorList> processor, int weight) {
        return Pair.of(StructurePoolElement.single(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path).toString(), processor), weight);
    }
}
