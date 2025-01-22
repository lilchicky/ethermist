package com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public record AncientPowerEnchant() implements EnchantmentValueEffect {

    public static final MapCodec<AncientPowerEnchant> CODEC = MapCodec.unit(AncientPowerEnchant::new);

    @Override
    public float process(int level, RandomSource randomSource, float v) {
        return level;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> codec() {
        return CODEC;
    }

    public static int modifyDamage(int level, int damage) {
        return damage + level;
    }
}
