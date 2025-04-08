package com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public record EnduringMagicEnchant() implements EnchantmentValueEffect {

    public static final MapCodec<EnduringMagicEnchant> CODEC = MapCodec.unit(EnduringMagicEnchant::new);

    @Override
    public float process(int level, RandomSource randomSource, float v) {
        return level;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> codec() {
        return CODEC;
    }

    public static double modifyLifespan(int level, double lifespan) {
        return lifespan * (level + 1);
    }
}
