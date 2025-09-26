package com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants;

import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandExclusionEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.base_enchants.QuickCastEnchant;
import com.mojang.serialization.MapCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

import java.util.List;

public class ExcludeMonstersEnchant implements IWandExclusionEffect {

    public static final MapCodec<ExcludeMonstersEnchant> CODEC = MapCodec.unit(ExcludeMonstersEnchant::new);

    @Override
    public MapCodec<? extends IWandExclusionEffect> codec() {
        return CODEC;
    }

    @Override
    public List<Class<? extends Entity>> getExclusive() {
        return List.of(Monster.class);
    }
}
