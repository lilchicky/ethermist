package com.gmail.thelilchicken01.ethermist.item.foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ToastedShroomCluster extends Item {

    public ToastedShroomCluster() {
        super(new Properties().food(
                new FoodProperties.Builder()
                        .nutrition(8)
                        .saturationModifier(0.7f)
                        .build()
        ));
    }

}
