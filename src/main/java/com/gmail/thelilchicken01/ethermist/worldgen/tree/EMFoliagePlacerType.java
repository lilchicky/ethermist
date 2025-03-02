package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMFoliagePlacerType {

    public static final DeferredRegister<FoliagePlacerType<?>> EM_FOLIAGE_PLACER_TYPES = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, Ethermist.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<?>> ABYSSAL_MUSHROOM_TOP_PLACER = EM_FOLIAGE_PLACER_TYPES.register(
            "abyssal_mushroom_top_placer",
            () -> new FoliagePlacerType<>(AbyssalMushroomCapPlacer.CODEC));

    public static void register (IEventBus bus) {
        EM_FOLIAGE_PLACER_TYPES.register(bus);
    }

}
