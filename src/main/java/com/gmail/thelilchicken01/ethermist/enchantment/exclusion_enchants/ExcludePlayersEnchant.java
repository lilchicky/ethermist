package com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandExclusionEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class ExcludePlayersEnchant implements IWandExclusionEffect {

    public static final MapCodec<ExcludePlayersEnchant> CODEC = MapCodec.unit(ExcludePlayersEnchant::new);

    @Override
    public MapCodec<? extends IWandExclusionEffect> codec() {
        return CODEC;
    }

    @Override
    public List<Class<?>> getExclusive() {
        return List.of(Player.class);
    }
}
