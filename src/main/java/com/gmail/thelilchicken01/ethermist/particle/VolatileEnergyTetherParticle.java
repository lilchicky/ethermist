package com.gmail.thelilchicken01.ethermist.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class VolatileEnergyTetherParticle extends TextureSheetParticle {

    private final SpriteSet spriteSet;

    public VolatileEnergyTetherParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z);

        this.spriteSet = spriteSet;
        this.friction = 0.8f;
        this.quadSize *= 1.0f; //size of particle
        this.lifetime = 5; //lifetime in ticks
        this.gravity = 0;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(spriteSet);
        fadeOut();
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }

    @Override
    public ParticleRenderType getRenderType() {

        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xd, double yd, double zd) {

            return new VolatileEnergyTetherParticle(level, x, y, z, this.spriteSet);

        }

    }

}
