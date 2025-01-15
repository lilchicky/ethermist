package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.holdersets.HolderSetType;

import java.util.function.Supplier;

public class EMTrunkPlacerType<P extends TrunkPlacer> {

    public static final DeferredRegister<TrunkPlacerType<?>> EM_TRUNK_PLACER = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, Ethermist.MODID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<?>> ANCIENT_TRUNK_PLACER = EM_TRUNK_PLACER.register(
            "ancient_trunk_placer",
            () -> new TrunkPlacerType<>(AncientTrunkPlacer.CODEC));

    public static void register (IEventBus bus) {
        EM_TRUNK_PLACER.register(bus);
    }

}
