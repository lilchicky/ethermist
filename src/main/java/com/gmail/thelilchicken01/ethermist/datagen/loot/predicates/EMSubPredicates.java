package com.gmail.thelilchicken01.ethermist.datagen.loot.predicates;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.mojang.serialization.MapCodec;
import net.minecraft.advancements.critereon.EntitySubPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMSubPredicates {
    public static final DeferredRegister<MapCodec<? extends EntitySubPredicate>> EM_SUB_PREDICATES = DeferredRegister.create(BuiltInRegistries.ENTITY_SUB_PREDICATE_TYPE, Ethermist.MODID);

    public static final DeferredHolder<MapCodec<? extends EntitySubPredicate>, MapCodec<GlimmerbugPredicate>> GLIMMERBUG =
            EM_SUB_PREDICATES.register("glimmerbug", () -> GlimmerbugPredicate.CODEC);

    public static void register(IEventBus bus) {
        EM_SUB_PREDICATES.register(bus);
    }
}
