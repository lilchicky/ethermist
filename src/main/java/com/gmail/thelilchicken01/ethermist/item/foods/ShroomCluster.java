package com.gmail.thelilchicken01.ethermist.item.foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ShroomCluster extends Item {

    public ShroomCluster() {
        super(new Properties().food(
                new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationModifier(0.3f)
                        .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1.0f)
                        .build()
        ));
    }

}
