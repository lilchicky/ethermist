package com.gmail.thelilchicken01.ethermist.component;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMDataComponents {

    public static final DeferredRegister.DataComponents EM_DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Ethermist.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<WandHandleEntry>> WAND_HANDLE =
            EM_DATA_COMPONENTS.registerComponentType("wand_handle", builder ->
                    builder
                            .persistent(WandHandleEntry.CODEC)
                            .networkSynchronized(WandHandleEntry.STREAM_CODEC)
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<WandOrbEntry>> WAND_ORB =
            EM_DATA_COMPONENTS.registerComponentType("wand_orb", builder ->
                    builder
                            .persistent(WandOrbEntry.CODEC)
                            .networkSynchronized(WandOrbEntry.STREAM_CODEC)
            );

    public static void register (IEventBus bus) {
        EM_DATA_COMPONENTS.register(bus);
    }

}
