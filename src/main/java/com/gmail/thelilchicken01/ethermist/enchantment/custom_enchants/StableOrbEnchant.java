package com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public record StableOrbEnchant() implements EnchantmentValueEffect {

    public static final MapCodec<StableOrbEnchant> CODEC = MapCodec.unit(StableOrbEnchant::new);

    @Override
    public float process(int level, RandomSource randomSource, float v) {
        return level;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> codec() {
        return CODEC;
    }

    public static double modifyAccuracy(int level, double acc) {
        return acc / Math.pow((level + 1), 0.95);
    }
}
