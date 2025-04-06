package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum WandTypes {

    DULL_WAND(
            1.0,
            7,
            1,
            4,
            15.0f,
            0.25f,
            false,
            0.25,
            80,
            EMItems.GENERIC_SHOT.get(),
            EMDamageTypes.GENERIC_MAGIC,
            new float[]{0.50196f, 0.38431f, 0.64314f},
            () -> Ingredient.of(
                    Items.AMETHYST_SHARD
            ),
            SoundEvents.EVOKER_CAST_SPELL
    ),

    FLAME_WAND(
            1.9,
            10,
            1,
            6,
            7.5f,
            0.25f,
            true,
            0.25,
            80,
            EMItems.FLAME_SHOT.get(),
            EMDamageTypes.FLAME_MAGIC,
            new float[]{1.0f, 0.1f, 0.1f},
            () -> Ingredient.of(
                    Items.AMETHYST_SHARD,
                    Items.BLAZE_POWDER
            ),
            SoundEvents.BLAZE_SHOOT
    ),

    POISON_WAND(
            1.7,
            11,
            2,
            5,
            9.5f,
            0.35f,
            false,
            0.25,
            80,
            EMItems.POISON_SHOT.get(),
            EMDamageTypes.POISON_MAGIC,
            new float[]{0.396f, 0.455f, 0.196f},
            () -> Ingredient.of(
                    Items.AMETHYST_SHARD,
                    Items.SPIDER_EYE
            ),
            SoundEvents.SPIDER_HURT
    ),

    LEVITATION_WAND(
            4.2,
            25,
            3,
            11,
            0.5f,
            0.2f,
            false,
            0.25,
            30,
            EMItems.LEVITATION_SHOT.get(),
            EMDamageTypes.LEVITATION_MAGIC,
            new float[]{0.95f, 0.95f, 0.95f},
            () -> Ingredient.of(
                    Items.AMETHYST_SHARD,
                    Items.PHANTOM_MEMBRANE
            ),
            SoundEvents.SHULKER_SHOOT
    ),

    WITHER_WAND(
            2.7,
            20,
            1,
            8,
            8.5f,
            0.25f,
            false,
            0.25,
            100,
            EMItems.WITHER_SHOT.get(),
            EMDamageTypes.WITHER_MAGIC,
            new float[]{0.1f, 0.1f, 0.1f},
            () -> Ingredient.of(
                    Items.AMETHYST_SHARD,
                    Items.COAL
            ),
            SoundEvents.WITHER_SHOOT
    ),

    WITCH_WAND(
            1.4,
            16,
            3,
            5,
            12.0f,
            0.3f,
            false,
            0.25,
            80,
            EMItems.WITCH_SHOT.get(),
            EMDamageTypes.WITCH_MAGIC,
            new float[]{0.247f, 0.145f, 0.216f},
            () -> Ingredient.of(
                    Items.AMETHYST_SHARD,
                    Items.SUGAR,
                    Items.GLASS_BOTTLE,
                    Items.REDSTONE,
                    Items.GLOWSTONE_DUST
            ),
            SoundEvents.WITCH_THROW
    );

    private final double durabilityMult;
    private final int enchantability;
    private final int lifespanSeconds;
    private final int spellDamage;
    private final float inaccuracy;
    private final float projectileSpeed;
    private final boolean canIgnite;
    private final double knockback;
    private final int cooldownTicks;
    private final WandShotItem shotItem;
    private final ResourceKey<DamageType> damageType;
    private final float[] trailColor;
    private final Supplier<Ingredient> repairItem;
    private final SoundEvent shootSound;

    // Constructor
    WandTypes(double durabilityMult, int enchantability, int lifespanSeconds, int spellDamage, float inaccuracy, float projectileSpeed, boolean canIgnite,
              double knockback, int cooldownTicks, WandShotItem shotItem, ResourceKey<DamageType> damageType, float[] trailColor, Supplier<Ingredient> repairItem,
              SoundEvent shootSound) {
        this.durabilityMult = durabilityMult;
        this.enchantability = enchantability;
        this.lifespanSeconds = lifespanSeconds;
        this.spellDamage = spellDamage;
        this.inaccuracy = inaccuracy;
        this.projectileSpeed = projectileSpeed;
        this.canIgnite = canIgnite;
        this.knockback = knockback;
        this.cooldownTicks = cooldownTicks;
        this.shotItem = shotItem;
        this.damageType = damageType;
        this.trailColor = trailColor;
        this.repairItem = repairItem;
        this.shootSound = shootSound;
    }

    public double getDurabilityMult() {
        return durabilityMult;
    }

    public int getEnchantability() {
        return enchantability;
    }

    public int getLifespanSeconds() {
        return lifespanSeconds;
    }

    public int getSpellDamage() {
        return spellDamage;
    }

    public float getInaccuracy() {
        return inaccuracy;
    }

    public float getProjectileSpeed() {
        return projectileSpeed;
    }

    public boolean getCanIgnite() {
        return canIgnite;
    }

    public double getKnockback() {
        return knockback;
    }

    public int getCooldown() {
        return cooldownTicks;
    }

    public WandShotItem getShotItem() {
        return shotItem;
    }

    public ResourceKey<DamageType> getDamageType() {
        return damageType;
    }

    public float[] getTrailColor() {
        return trailColor;
    }

    public Supplier<Ingredient> getRepairItem() {
        return repairItem;
    }

    public SoundEvent getShootSound() {
        return shootSound;
    }
}
