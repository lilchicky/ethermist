package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;

public class FlameWand extends WandItem {

    public FlameWand() {
        super(new Properties().durability(400), SoundEvents.BLAZE_SHOOT);
    }

    @Override
    public float getInaccuracy() {
        return 0.7f;
    }

    @Override
    public boolean getCanIgnite() {
        return true;
    }

    @Override
    public ParticleOptions getTrail() {
        return ParticleTypes.SMOKE;
    }

    @Override
    public int getBonusDamage() {
        return 2;
    }

    @Override
    public WandShotItem getShotItem() {
        return EMItems.FLAME_SHOT.get();
    }
}
