package com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandExclusionEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.monster.Enemy;

import java.util.List;

public class ExcludeMonstersEnchant implements IWandExclusionEffect {

    public static final MapCodec<ExcludeMonstersEnchant> CODEC = MapCodec.unit(ExcludeMonstersEnchant::new);

    @Override
    public MapCodec<? extends IWandExclusionEffect> codec() {
        return CODEC;
    }

    @Override
    public List<Class<?>> getExclusive() {
        return List.of(Enemy.class);
    }
}
