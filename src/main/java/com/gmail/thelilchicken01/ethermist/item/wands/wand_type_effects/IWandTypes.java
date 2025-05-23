package com.gmail.thelilchicken01.ethermist.item.wands.wand_type_effects;

import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public interface IWandTypes {

    double getDurabilityMult();

    int getEnchantability();

    double getLifespanSeconds();

    int getSpellDamage();

    float getInaccuracy();

    float getProjectileSpeed();

    boolean getCanIgnite();

    double getKnockback();

    int getCooldown();

    WandShotItem getShotItem();

    ResourceKey<DamageType> getDamageType();

    float[] getTrailColor();

    Supplier<Ingredient> getRepairItem();

    SoundEvent getShootSound();

}
