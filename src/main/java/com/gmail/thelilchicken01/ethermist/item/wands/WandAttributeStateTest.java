package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.ArrayList;
import java.util.List;

import static com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeStateTest.Operation.*;
import static net.neoforged.neoforge.common.extensions.IAttributeExtension.FORMAT;

public class WandAttributeStateTest {

    private final List<WandAttributeHolder> modifiers = new ArrayList<>();

    public WandAttributeStateTest() {}

    // Used when a set operation is being done on an existing attribute.
    public void modifyExistingAttribute(Holder<Attribute> attribute, Operation operation, float amount) {
        for (WandAttributeHolder holder : modifiers) {
            if (holder.attribute != attribute) continue;

            holder.modifyAmount(operation, amount);
            return;
        }
        Ethermist.LOGGER.warn("Attempted to modify attribute {}, but it could not be found on itemstack.", attribute.getRegisteredName());
    }

    // Used when the value of an existing attribute is being outright replaced.
    public void modifyExistingAttribute(Holder<Attribute> attribute, float amount) {
        for (WandAttributeHolder holder : modifiers) {
            if (holder.attribute != attribute) continue;

            holder.amount = amount;
            return;
        }
        Ethermist.LOGGER.warn("Attempted to set value of attribute {}, but it could not be found on itemstack.", attribute.getRegisteredName());
    }

    public float getAttributeModifierAmount(Holder<Attribute> attribute) {
        for (WandAttributeHolder holder : modifiers) {
            if (holder.attribute != attribute) continue;
            return holder.amount;
        }
        Ethermist.LOGGER.warn("Attempted to get the value of attribute {}, but it could not be found on itemstack.", attribute.getRegisteredName());
        return 0.0f;
    }

    public void addAttribute(WandAttributeHolder attribute) {
        for (WandAttributeHolder holder : modifiers) {
            if (attribute.attribute == holder.attribute) {
                Ethermist.LOGGER.warn("Attempted to add attribute {} to itemstack, but it already exists. New value will be ignored.", attribute.attribute.getRegisteredName());
                return;
            }
        }

        modifiers.add(attribute);
    }

    public WandAttributeStateTest seed(
            int baseCooldownTicks,
            float baseDamage,
            float baseLifespanSeconds,
            float baseProjectileSpeed,
            float baseKnockback,
            float baseInaccuracy
    ) {
        modifiers.add(new WandAttributeHolder("bonus_cooldown", EMAttributes.COOLDOWN, WandItem.COOLDOWN_ID, baseCooldownTicks / 20.0f, ADDITION));
        modifiers.add(new WandAttributeHolder("bonus_damage", EMAttributes.WAND_DAMAGE, WandItem.BASE_WAND_DAMAGE_ID, baseDamage, ADDITION));
        modifiers.add(new WandAttributeHolder("bonus_lifespan", EMAttributes.LIFESPAN, WandItem.LIFESPAN_ID, baseLifespanSeconds, ADDITION));
        modifiers.add(new WandAttributeHolder("bonus_projectile_speed", EMAttributes.PROJECTILE_SPEED, WandItem.PROJECTILE_SPEED_ID, baseProjectileSpeed, ADDITION));
        modifiers.add(new WandAttributeHolder("bonus_knockback", EMAttributes.WAND_KNOCKBACK, WandItem.WAND_KNOCKBACK_ID, baseKnockback, ADDITION));
        modifiers.add(new WandAttributeHolder("bonus_accuracy", EMAttributes.ACCURACY, WandItem.ACCURACY_ID, 1.0f - (baseInaccuracy / 100), ADDITION));
        return this;
    }

    public void addAllAttributesToBuilder(ItemAttributeModifiers.Builder builder) {
        for (WandAttributeHolder holder : modifiers) holder.addToBuilder(builder, EquipmentSlotGroup.MAINHAND);
    }

    public static class WandAttributeHolder {

        private final String id;
        private final Holder<Attribute> attribute;
        private final ResourceLocation attributeId;
        private float amount;
        private final Operation operation;

        public WandAttributeHolder(String id, Holder<Attribute> attribute, ResourceLocation attributeId, float amount,
                                   Operation operation) {
            this.id = id;
            this.attribute = attribute;
            this.attributeId = attributeId;
            this.amount = amount;
            this.operation = operation;
        }

        public void addToBuilder(ItemAttributeModifiers.Builder builder, EquipmentSlotGroup slot) {
            builder.add(
                    attribute,
                    new AttributeModifier(
                            attributeId,
                            amount,
                            operation == MULT || operation == PERCENT ?
                                    AttributeModifier.Operation.ADD_MULTIPLIED_BASE :
                                    AttributeModifier.Operation.ADD_VALUE
                    ),
                    slot
            );
        }

        public boolean apply(WandAttributeStateTest state) {
            for (WandAttributeHolder holder : state.modifiers) {
                if (holder.attribute != attribute) continue;

                modifyAmount(holder.operation, holder.amount);

                return true;
            }
            return false;
        }

        public void modifyAmount(Operation operation, float amount) {
            switch(operation) {
                case ADDITION -> this.amount += amount;
                case MULT -> this.amount *= amount;
                case PERCENT -> this.amount *= 1.0f + amount;
            }
        }

        public float getAmount() {
            return this.amount;
        }

        public Holder<Attribute> getAttribute() {
            return this.attribute;
        }

        public Operation getOperation() {
            return this.operation;
        }

        public Component getAttributeComponent() {
            final int color = 0xAAAAAA;
            String formattedAmount = "";

            switch (this.operation) {
                case ADDITION -> formattedAmount = (amount > 0 ? "+" : "") + FORMAT.format(amount);
                case PERCENT -> {
                    double pct = amount * 100.0f;
                    formattedAmount = (pct > 0 ? "+" : "") + FORMAT.format(pct) + "%";
                }
                case MULT -> formattedAmount = "x" + FORMAT.format(amount);
            }
            return Component.translatable("item.ethermist.wand_handle." + id, formattedAmount).withColor(color);
        }

    }

    public enum Operation {
        ADDITION,
        MULT,
        PERCENT
    }

}
