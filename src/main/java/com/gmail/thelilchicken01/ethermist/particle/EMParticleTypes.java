package com.gmail.thelilchicken01.ethermist.particle;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.mojang.serialization.Decoder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMParticleTypes {

    public static final DeferredRegister<ParticleType<?>> EM_PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, Ethermist.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GILMMERBUG_AIR = EM_PARTICLE_TYPES.register(
            "glimmerbug_air", () -> new SimpleParticleType(false));

    public static void register (IEventBus bus) {
        EM_PARTICLE_TYPES.register(bus);
    }

}
