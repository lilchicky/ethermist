package com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public record FocusMonstersEnchant() implements EnchantmentValueEffect {

    public static final MapCodec<FocusMonstersEnchant> CODEC = MapCodec.unit(FocusMonstersEnchant::new);

    @Override
    public float process(int level, RandomSource randomSource, float v) {
        return level;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> codec() {
        return CODEC;
    }

}
