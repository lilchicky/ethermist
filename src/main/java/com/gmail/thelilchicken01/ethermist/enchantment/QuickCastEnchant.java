package com.gmail.thelilchicken01.ethermist.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.minecraft.world.phys.Vec3;

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

    public static int modifyCooldown(int level, int cooldown) {
        return (int)(cooldown / Math.pow((level + 1), 0.2));
    }
}
