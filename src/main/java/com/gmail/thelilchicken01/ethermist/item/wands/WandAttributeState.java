package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.EMAttributes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.Locale;

public class WandAttributeState {

    public enum WandAttribute {COOLDOWN_TICKS, DAMAGE, LIFESPAN_SECONDS, PROJECTILE_SPEED_MULT, KNOCKBACK_MULT, INACCURACY_PERCENT}

    public enum AttributeOperation {ADDITION, MULT, PERCENT}

    public enum TooltipStyle {ADDITION, MULT, PERCENT}

    private static <E extends Enum<E>> Codec<E> enumCodec(Class<E> c) {
        return Codec.STRING.xmap(
                string -> Enum.valueOf(c, string.trim().toUpperCase(Locale.ROOT)),
                e -> e.name().toLowerCase(Locale.ROOT)
        );
    }

    public static final Codec<WandAttribute> WAND_ATTRIBUTE_CODEC = enumCodec(WandAttribute.class);
    public static final Codec<AttributeOperation> OPERATION_CODEC = enumCodec(AttributeOperation.class);
    public static final Codec<TooltipStyle> TOOLTIP_STYLE_CODEC = enumCodec(TooltipStyle.class);

    public int cooldownTicks;
    public double damage;
    public double lifespanSeconds;
    public double projectileSpeedMult;
    public double knockbackMult;
    public double inaccuracyPercent;

    public WandAttributeState() {
    }

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

    public void apply(WandAttribute key, AttributeOperation type, double value) {
        switch (key) {
            case COOLDOWN_TICKS -> {
                switch (type) {
                    case ADDITION -> cooldownTicks += (int) Math.round(value);
                    case MULT -> cooldownTicks = (int) Math.round(cooldownTicks * value);
                    case PERCENT -> cooldownTicks = (int) Math.round(cooldownTicks * (1.0 + value));
                }
            }

            case DAMAGE -> {
                switch (type) {
                    case ADDITION -> damage += value;
                    case MULT -> damage *= value;
                    case PERCENT -> damage *= (1.0 + value);
                }
            }

            case LIFESPAN_SECONDS -> {
                switch (type) {
                    case ADDITION -> lifespanSeconds += value;
                    case MULT -> lifespanSeconds *= value;
                    case PERCENT -> lifespanSeconds *= (1.0 + value);
                }
            }

            case PROJECTILE_SPEED_MULT -> {
                switch (type) {
                    case ADDITION -> projectileSpeedMult += value;
                    case MULT -> projectileSpeedMult *= value;
                    case PERCENT -> projectileSpeedMult *= (1.0 + value);
                }
            }

            case KNOCKBACK_MULT -> {
                switch (type) {
                    case ADDITION -> knockbackMult += value;
                    case MULT -> knockbackMult *= value;
                    case PERCENT -> knockbackMult *= (1.0 + value);
                }
            }

            case INACCURACY_PERCENT -> {
                switch (type) {
                    case ADDITION -> inaccuracyPercent -= value;
                    case MULT -> inaccuracyPercent *= value;
                    case PERCENT -> inaccuracyPercent *= (1.0 + value);
                }
            }
        }
    }

    public void clamp() {
        if (cooldownTicks < 5) cooldownTicks = 5; // cooldown cannot be faster than a quarter second
        if (damage < 0.5) damage = 0.5; // damage cannot be under 1 heart
        if (lifespanSeconds < 0.25) lifespanSeconds = 0.25; // min lifespan
        if (projectileSpeedMult < 0.1) projectileSpeedMult = 0.1; // min speed
        if (knockbackMult < 0.0) knockbackMult = 0.0; // knockback cannot be under none
        if (inaccuracyPercent < 0.0) inaccuracyPercent = 0.0; // inaccuracy cannot be over 100%
        if (inaccuracyPercent > 100.0) inaccuracyPercent = 100.0; // inaccuracy cannot be under 0%
    }

    public void addToBuilder(ItemAttributeModifiers.Builder builder, EquipmentSlotGroup slot) {

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

        double accuracy = 1.0 - (inaccuracyPercent / 100);
        builder.add(
                EMAttributes.ACCURACY,
                new AttributeModifier(WandItem.ACCURACY_ID, accuracy, AttributeModifier.Operation.ADD_VALUE),
                slot
        );
    }

    public record AttributeModifierHolder(WandAttribute attribute, AttributeOperation operation, double value,
                                          boolean seconds, String tooltipId, TooltipStyle tooltipStyle) {

        public void apply(WandAttributeState state) {
            double mod = value;
            if (seconds && attribute == WandAttribute.COOLDOWN_TICKS && operation != AttributeOperation.PERCENT) {
                mod = value * 20.0;
            }
            state.apply(attribute, operation, mod);
        }

        public static final Codec<AttributeModifierHolder> CODEC =
                RecordCodecBuilder.create(instance -> instance.group(
                        WAND_ATTRIBUTE_CODEC
                                .fieldOf("attribute")
                                .forGetter(AttributeModifierHolder::attribute),
                        OPERATION_CODEC
                                .fieldOf("operation")
                                .forGetter(AttributeModifierHolder::operation),
                        Codec.DOUBLE
                                .fieldOf("value")
                                .forGetter(AttributeModifierHolder::value),
                        Codec.BOOL
                                .optionalFieldOf("isSeconds", false)
                                .forGetter(AttributeModifierHolder::seconds),
                        Codec.STRING
                                .fieldOf("tooltip_id")
                                .forGetter(AttributeModifierHolder::tooltipId),
                        TOOLTIP_STYLE_CODEC
                                .fieldOf("tooltip_style")
                                .forGetter(AttributeModifierHolder::tooltipStyle)
                ).apply(instance, AttributeModifierHolder::new));

    }

}
