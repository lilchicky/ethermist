package com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public record GreaterDistanceEnchant() implements EnchantmentValueEffect {

    public static final MapCodec<GreaterDistanceEnchant> CODEC = MapCodec.unit(GreaterDistanceEnchant::new);

    @Override
    public float process(int level, RandomSource randomSource, float v) {
        return level;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> codec() {
        return CODEC;
    }

    public static int modifyLifespan(int level, int lifespan) {
        return lifespan + (level);
    }
}
