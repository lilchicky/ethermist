package com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public record QuickCastEnchant() implements EnchantmentValueEffect {

    public static final MapCodec<QuickCastEnchant> CODEC = MapCodec.unit(QuickCastEnchant::new);

    @Override
    public float process(int level, RandomSource randomSource, float v) {
        return level;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> codec() {
        return CODEC;
    }

    public static int modifyCooldown(Holder<Enchantment> enchHolder, int level, int cooldown) {
        if (enchHolder.is(EMEnchantments.QUICK_CAST.location())) {
            return (int) (cooldown / Math.pow((level + 1), 0.3));
        }
        return -1;
    }
}
