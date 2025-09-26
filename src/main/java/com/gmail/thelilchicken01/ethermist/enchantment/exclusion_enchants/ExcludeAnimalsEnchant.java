package com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandExclusionEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class ExcludeAnimalsEnchant implements IWandExclusionEffect {

    public static final MapCodec<ExcludeAnimalsEnchant> CODEC = MapCodec.unit(ExcludeAnimalsEnchant::new);

    @Override
    public MapCodec<? extends IWandExclusionEffect> codec() {
        return CODEC;
    }

    @Override
    public List<Class<?>> getExclusive() {
        return List.of(
                Animal.class,
                AmbientCreature.class,
                WaterAnimal.class
        );
    }
}
