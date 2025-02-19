package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Iterator;

public class EMParticleProvider extends ParticleDescriptionProvider {

    public EMParticleProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, helper);
    }

    @Override
    protected void addDescriptions() {

        simpleParticle(EMParticleTypes.GLIMMERBUG_AIR);
        simpleParticle(EMParticleTypes.VOLATILE_ENERGY_TETHER);

        animatedParticle(EMParticleTypes.ETHERMIST_PORTAL, 3, true);

        // Wand Trail Particles
        animatedParticle(EMParticleTypes.WAND_TRAIL, 3, true);

    }

    private void simpleParticle(DeferredHolder<ParticleType<?>, SimpleParticleType> particle) {
        sprite(particle.get(), ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, particle.getId().getPath()));
    }

    private void animatedParticle(DeferredHolder<ParticleType<?>, SimpleParticleType> particle, int numTextures, boolean reverse) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, particle.getId().getPath());
        this.spriteSet(particle.get(), () -> new Iterator<>() {
            private int counter = 0;

            public boolean hasNext() {
                return this.counter < numTextures;
            }

            public ResourceLocation next() {
                int currentTexture = reverse ? numTextures - this.counter - 1 : this.counter;
                ResourceLocation texture = location.withSuffix("_" + currentTexture).withPrefix(particle.getId().getPath() + "/");
                ++this.counter;
                return texture;
            }
        });
    }

}
