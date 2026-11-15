package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.effect.EMMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class EMFoods {
    public static final FoodProperties SHROOM_CLUSTER = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1.0f)
            .build();
    public static final FoodProperties TOASTED_SHROOM_CLUSTER = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f).build();
    public static final FoodProperties GLIMMERBUG_ABDOMEN = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 60, 0), 0.5f)
            .build();
    public static final FoodProperties SOURDEW_SLICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodProperties SOURDEW_SMOOTHIE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.5f)
            .fast()
            .alwaysEdible()
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .effect(() -> new MobEffectInstance(EMMobEffects.FASTER_CASTING, 320, 2), 1.0f)
            .build();
}
