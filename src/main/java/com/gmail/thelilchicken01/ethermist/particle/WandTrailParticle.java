package com.gmail.thelilchicken01.ethermist.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class WandTrailParticle extends TextureSheetParticle {

    private final SpriteSet spriteSet;

    public WandTrailParticle(ClientLevel level, double x, double y, double z, double r, double g, double b, SpriteSet spriteSet) {
        super(level, x, y, z);

        this.spriteSet = spriteSet;
        this.friction = 0.8f;
        this.quadSize *= 1.5f * (this.random.nextFloat() * 0.6F + 0.6F); //size of particle
        this.lifetime = 40; //lifetime in ticks
        this.gravity = 0;
        this.alpha = 1.0f;

        this.xd = (random.nextDouble() - 0.5) * 0.03;
        this.yd = (random.nextDouble() - 0.5) * 0.03;
        this.zd = (random.nextDouble() - 0.5) * 0.03;

        this.setSpriteFromAge(spriteSet);

        this.setColor((float) r, (float) g, (float) b);
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
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z,
                                       double r, double g, double b) {

            return new WandTrailParticle(level, x, y, z, r, g, b, this.spriteSet);

        }

    }

}
