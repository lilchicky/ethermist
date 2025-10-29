package com.gmail.thelilchicken01.ethermist.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class EMFoods {
    public static final FoodProperties SHROOM_CLUSTER = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1.0f)
            .build();
    public static final FoodProperties TOASTED_SHROOM_CLUSTER = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f).build();
    public static final FoodProperties GLIMMERBUG_SHELL = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 60, 0), 0.5f)
            .build();
}
