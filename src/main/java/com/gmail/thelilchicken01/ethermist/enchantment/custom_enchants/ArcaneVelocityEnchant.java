package com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public record ArcaneVelocityEnchant() implements EnchantmentValueEffect {

    public static final MapCodec<ArcaneVelocityEnchant> CODEC = MapCodec.unit(ArcaneVelocityEnchant::new);

    @Override
    public float process(int level, RandomSource randomSource, float v) {
        return level;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> codec() {
        return CODEC;
    }

    public static float modifyPSpeed(int level, float pspeed) {
        return pspeed + ((level + 1) * 0.25f);
    }
}
