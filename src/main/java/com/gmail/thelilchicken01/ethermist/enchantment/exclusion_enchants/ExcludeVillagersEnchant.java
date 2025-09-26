package com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandExclusionEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class ExcludeVillagersEnchant implements IWandExclusionEffect {

    public static final MapCodec<ExcludeVillagersEnchant> CODEC = MapCodec.unit(ExcludeVillagersEnchant::new);

    @Override
    public MapCodec<? extends IWandExclusionEffect> codec() {
        return CODEC;
    }

    @Override
    public List<Class<?>> getExclusive() {
        return List.of(
                AbstractVillager.class,
                IronGolem.class
        );
    }
}
