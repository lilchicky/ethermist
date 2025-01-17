package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class EMParticleProvider extends ParticleDescriptionProvider {

    public EMParticleProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, helper);
    }

    @Override
    protected void addDescriptions() {

        simpleParticle(EMParticleTypes.GILMMERBUG_AIR);

    }

    private void simpleParticle(DeferredHolder<ParticleType<?>, SimpleParticleType> particle) {

        sprite(particle.get(), ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, particle.getId().getPath()));

    }
}
