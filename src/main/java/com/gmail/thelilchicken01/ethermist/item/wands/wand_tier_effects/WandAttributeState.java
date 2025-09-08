package com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects;

import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.UUID;

public class WandAttributeState {

    public int cooldownTicks;
    public double damage;
    public double lifespanSeconds;
    public double projectileSpeedMult;
    public double knockbackMult;
    public double inaccuracyPercent;

    public WandAttributeState() {}

    public WandAttributeState seed(
            int baseCooldownTicks,
            double baseDamage,
            double baseLifespanSeconds,
            double baseProjectileSpeedMul,
            double baseKnockbackMul,
            double baseInaccuracyPct
    ) {
        this.cooldownTicks = baseCooldownTicks;
        this.damage = baseDamage;
        this.lifespanSeconds = baseLifespanSeconds;
        this.projectileSpeedMult = baseProjectileSpeedMul;
        this.knockbackMult = baseKnockbackMul;
        this.inaccuracyPercent = baseInaccuracyPct;
        return this;
    }

    public enum Key {
        COOLDOWN_TICKS, DAMAGE, LIFESPAN_SECONDS, PROJECTILE_SPEED_MULT, KNOCKBACK_MULT, INACCURACY_PERCENT
    }

    public void add(Key key, double value) {
        switch (key) {
            case COOLDOWN_TICKS -> cooldownTicks += (int) Math.round(value);
            case DAMAGE -> damage += value;
            case LIFESPAN_SECONDS -> lifespanSeconds += value;
            case INACCURACY_PERCENT -> inaccuracyPercent += value;
            default -> throw new IllegalArgumentException("add() cannot be used for " + key);
        }
    }

    public void mult(Key key, double value) {
        switch (key) {
            case PROJECTILE_SPEED_MULT -> projectileSpeedMult *= value;
            case KNOCKBACK_MULT -> knockbackMult *= value;
            case LIFESPAN_SECONDS -> lifespanSeconds *= value;
            case DAMAGE -> damage *= value;
            case COOLDOWN_TICKS -> cooldownTicks = (int) Math.round(cooldownTicks * value);
            case INACCURACY_PERCENT -> inaccuracyPercent *= value;
            default -> throw new IllegalArgumentException("mult() cannot be used for " + key);
        }
    }

    public void percent(Key key, double value) {
        switch (key) {
            case PROJECTILE_SPEED_MULT -> projectileSpeedMult *= (1.0 + value);
            case KNOCKBACK_MULT -> knockbackMult *= (1.0 + value);
            case DAMAGE -> damage *= (1.0 + value);
            case INACCURACY_PERCENT -> inaccuracyPercent -= value;
            default -> throw new IllegalArgumentException("percent() cannot be used for " + key);
        }
    }

    public void clamp() {
        if (cooldownTicks < 5) cooldownTicks = 5; // cooldown cannot be faster than a quarter second
        if (damage < 0.5) damage = 0.5; // damage cannot be under 1 heart
        if (lifespanSeconds < 0.25) lifespanSeconds = 0.25; // min lifespan
        if (projectileSpeedMult < 0.1) projectileSpeedMult = 0.1; // min speed
        if (knockbackMult < 0.0) knockbackMult = 0.0; // knockback cannot be under none
        if (inaccuracyPercent < 0.0) inaccuracyPercent = 0.0; // inaccuracy cannot be over 100%
    }

    public void addToBuilder(
            ItemAttributeModifiers.Builder builder,
            EquipmentSlotGroup slot
    ) {
        builder.add(
                EMAttributes.PROJECTILE_SPEED,
                new AttributeModifier(WandItem.PROJECTILE_SPEED_ID, projectileSpeedMult, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                slot
        );

        builder.add(
                EMAttributes.WAND_KNOCKBACK,
                new AttributeModifier(WandItem.WAND_KNOCKBACK_ID, knockbackMult, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                slot
        );

        builder.add(
                EMAttributes.COOLDOWN,
                new AttributeModifier(WandItem.COOLDOWN_ID, cooldownTicks / 20.0, AttributeModifier.Operation.ADD_VALUE),
                slot
        );

        builder.add(
                EMAttributes.WAND_DAMAGE,
                new AttributeModifier(WandItem.BASE_WAND_DAMAGE_ID, damage, AttributeModifier.Operation.ADD_VALUE),
                slot
        );

        builder.add(
                EMAttributes.LIFESPAN,
                new AttributeModifier(WandItem.LIFESPAN_ID, lifespanSeconds, AttributeModifier.Operation.ADD_VALUE),
                slot
        );

        double accuracyMultiplier = 1.0 - (Math.max(inaccuracyPercent, 0.0) / 100.0);
        builder.add(
                EMAttributes.ACCURACY,
                new AttributeModifier(WandItem.ACCURACY_ID, accuracyMultiplier, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                slot
        );
    }

}
