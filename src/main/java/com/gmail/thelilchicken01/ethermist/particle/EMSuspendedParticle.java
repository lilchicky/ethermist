package com.gmail.thelilchicken01.ethermist.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleGroup;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Optional;

public class EMSuspendedParticle extends TextureSheetParticle {

    protected EMSuspendedParticle(ClientLevel level, SpriteSet sprites, double x, double y, double z) {
        super(level, x, y - 0.125, z);
        this.setSize(0.01F, 0.01F);
        this.pickSprite(sprites);
        this.quadSize = this.quadSize * (this.random.nextFloat() * 0.6F + 0.2F);
        this.lifetime = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = 0.0F;
    }

    EMSuspendedParticle(
            ClientLevel level, SpriteSet sprites, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed
    ) {
        super(level, x, y - 0.125, z, xSpeed, ySpeed, zSpeed);
        this.setSize(0.01F, 0.01F);
        this.pickSprite(sprites);
        this.quadSize = this.quadSize * (this.random.nextFloat() * 0.6F + 0.6F);
        this.lifetime = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = 0.0F;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class GlimmerbugAirProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public GlimmerbugAirProvider(SpriteSet sprites) {
            this.sprite = sprites;
        }

        public Particle createParticle(
                SimpleParticleType type,
                ClientLevel p_level,
                double p_x,
                double p_y,
                double p_z,
                double xSpeed,
                double ySpeed,
                double zSpeed
        ) {
            EMSuspendedParticle suspendedparticle = new EMSuspendedParticle(p_level, this.sprite, p_x, p_y, p_z, 0.0, -0.8F, 0.0) {
                @Override
                public Optional<ParticleGroup> getParticleGroup() {
                    return Optional.of(ParticleGroup.SPORE_BLOSSOM);
                }
            };
            suspendedparticle.lifetime = Mth.randomBetweenInclusive(p_level.random, 500, 1000);
            suspendedparticle.gravity = 0.01F;

            return suspendedparticle;
        }
    }

}
