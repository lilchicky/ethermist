package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMFeatures {

    public static final DeferredRegister<Feature<?>> EM_FEATURES = DeferredRegister.create(Registries.FEATURE, Ethermist.MODID);

    public static final DeferredHolder<Feature<?>, SpikeFeature> SPIKE_FEATURE = EM_FEATURES.register("ethermist_spike",
            SpikeFeature::new
    );

    public static void register (IEventBus bus) {
        EM_FEATURES.register(bus);
    }

}