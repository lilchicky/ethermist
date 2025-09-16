package com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects;

import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Objects;
import java.util.function.Supplier;

public class WandOrb implements IWandOrb {

    private final double durabilityMult;
    private final int cooldown;
    private final double knockback;
    private final float inaccuracy;
    private final float projectileSpeed;
    private final boolean canIgnite;
    private final int enchantability;
    private final double lifespanSeconds;
    private final int damage;

    private final WandShotItem shotItem;
    private final ResourceKey<DamageType> damageType;
    private final float[] trailColor;
    private final Supplier<Ingredient> repairItem;
    private final SoundEvent shootSound;

    private final IWandOrbEffect effect;

    private WandOrb(
            double durabilityMult,
            int cooldown,
            double knockback,
            float inaccuracy,
            float projectileSpeed,
            boolean canIgnite,
            int enchantability,
            double lifespanSeconds,
            int damage,
            WandShotItem shotItem,
            ResourceKey<DamageType> damageType,
            float[] trailColor,
            Supplier<Ingredient> repairItem,
            SoundEvent shootSound,
            IWandOrbEffect effect
    ) {
        this.durabilityMult = durabilityMult;
        this.cooldown = cooldown;
        this.knockback = knockback;
        this.inaccuracy = inaccuracy;
        this.projectileSpeed = projectileSpeed;
        this.canIgnite = canIgnite;
        this.enchantability = enchantability;
        this.lifespanSeconds = lifespanSeconds;
        this.damage = damage;
        this.shotItem = Objects.requireNonNull(shotItem);
        this.damageType = Objects.requireNonNull(damageType);
        this.trailColor = Objects.requireNonNull(trailColor);
        this.repairItem = Objects.requireNonNull(repairItem);
        this.shootSound = Objects.requireNonNull(shootSound);
        this.effect = Objects.requireNonNull(effect);
    }

    @Override public double getDurabilityMult() { return durabilityMult; }

    @Override public int getEnchantability() {return enchantability;}
    @Override public double getLifespanSeconds() {return lifespanSeconds;}
    @Override public int getSpellDamage() {return damage;}
    @Override public int getCooldown() { return cooldown; }
    @Override public double getKnockback() { return knockback; }
    @Override public float getInaccuracy() { return inaccuracy; }
    @Override public float getProjectileSpeed() { return projectileSpeed; }
    @Override public boolean getCanIgnite() { return canIgnite; }
    @Override public WandShotItem getShotItem() { return shotItem; }
    @Override public ResourceKey<DamageType> getDamageType() { return damageType; }
    @Override public float[] getTrailColor() { return trailColor; }
    @Override public Supplier<Ingredient> getRepairItem() { return repairItem; }
    @Override public SoundEvent getShootSound() { return shootSound; }

    @Override
    public void apply(WandShotItem shotItem, Entity target, Player player, WandProjectile shot) {
        effect.apply(shotItem, target, player, shot);
    }

    public static final class Builder {
        private double durabilityMult;
        private int cooldown;
        private double knockback;
        private float inaccuracy;
        private float projectileSpeed;
        private boolean canIgnite;
        private int damage;
        private double lifespanSeconds;
        private int enchantability;
        private WandShotItem shotItem;
        private ResourceKey<DamageType> damageType;
        private float[] trailColor = new float[]{1,1,1};
        private Supplier<Ingredient> repairItem = () -> Ingredient.EMPTY;
        private SoundEvent shootSound;
        private IWandOrbEffect effect = (a, b, c, d) -> {};

        public Builder durabilityMult(double value){ this.durabilityMult = value; return this; }
        public Builder cooldown(int value){ this.cooldown = value; return this; }
        public Builder knockback(double value){ this.knockback = value; return this; }
        public Builder inaccuracy(float value){ this.inaccuracy = value; return this; }
        public Builder projectileSpeed(float value){ this.projectileSpeed = value; return this; }
        public Builder canIgnite(boolean value){ this.canIgnite = value; return this; }
        public Builder damage(int value){ this.damage = value; return this; }
        public Builder lifespanSeconds(double value){ this.lifespanSeconds = value; return this; }
        public Builder enchantability(int value){ this.enchantability = value; return this; }
        public Builder shot(WandShotItem value){ this.shotItem = value; return this; }
        public Builder damageType(ResourceKey<DamageType> value){ this.damageType = value; return this; }
        public Builder color(float r, float g, float b){ this.trailColor=new float[]{r,g,b}; return this; }
        public Builder repair(Supplier<Ingredient> value){ this.repairItem = value; return this; }
        public Builder sound(SoundEvent value){ this.shootSound = value; return this; }
        public Builder effect(IWandOrbEffect value){ this.effect = value; return this; }

        public WandOrb build() {
            return new WandOrb(durabilityMult, cooldown, knockback, inaccuracy, projectileSpeed, canIgnite, enchantability,
                    lifespanSeconds, damage, shotItem, damageType, trailColor, repairItem, shootSound, effect);
        }
    }
    
}
