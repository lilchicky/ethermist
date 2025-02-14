package com.gmail.thelilchicken01.ethermist.particle;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMParticleTypes {

    public static final DeferredRegister<ParticleType<?>> EM_PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, Ethermist.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GLIMMERBUG_AIR = EM_PARTICLE_TYPES.register(
            "glimmerbug_air", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOLATILE_ENERGY_TETHER = EM_PARTICLE_TYPES.register(
            "volatile_energy_tether", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ETHERMIST_PORTAL = EM_PARTICLE_TYPES.register(
            "ethermist_portal", () -> new SimpleParticleType(false));

    // Wand Trail Particles
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GENERIC_TRAIL = EM_PARTICLE_TYPES.register(
            "generic_trail", () -> new SimpleParticleType(false));

    public static void register (IEventBus bus) {
        EM_PARTICLE_TYPES.register(bus);
    }

}
