package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMTrunkPlacerType {

    public static final DeferredRegister<TrunkPlacerType<?>> EM_TRUNK_PLACER = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, Ethermist.MODID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> ANCIENT_TRUNK_PLACER = EM_TRUNK_PLACER.register(
            "ancient_trunk_placer",
            () -> new TrunkPlacerType<>(AncientTrunkPlacer.CODEC));

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> CHARRED_STUMP_PLACER = EM_TRUNK_PLACER.register(
            "charred_stump_placer",
            () -> new TrunkPlacerType<>(CharredStumpPlacer.CODEC));

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> ABYSSAL_MUSHROOM_TRUNK_PLACER = EM_TRUNK_PLACER.register(
            "abyssal_mushroom_trunk_placer",
            () -> new TrunkPlacerType<>(AbyssalMushroomTrunkPlacer.CODEC));

    public static void register (IEventBus bus) {
        EM_TRUNK_PLACER.register(bus);
    }

}
