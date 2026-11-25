package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.ArrayList;
import java.util.List;

public class WandAttributeStateTest {

    private final List<WandAttributeHolder> modifiers = new ArrayList<>();

    public WandAttributeStateTest() {}

    public void modifyExistingAttribute(Holder<Attribute> attribute, Operation operation, float amount) {
        for (WandAttributeHolder holder : modifiers) {
            if (holder.attribute != attribute) continue;

            holder.amount = operation == Operation.ADDITION ? holder.amount + amount : holder.amount * amount;
        }
    }

    public void modifyExistingAttribute(Holder<Attribute> attribute, float amount) {
        for (WandAttributeHolder holder : modifiers) {
            if (holder.attribute != attribute) continue;

            holder.amount = amount;
        }
    }

    public float getAttributeModifierAmount(Holder<Attribute> attribute) {
        for (WandAttributeHolder holder : modifiers) {
            if (holder.attribute != attribute) continue;
            return holder.amount;
        }
        return 0.0f;
    }

    public void addAttribute(WandAttributeHolder attribute) {
        for (WandAttributeHolder holder : modifiers) {
            if (attribute.attribute == holder.attribute) return;
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
        modifiers.add(new WandAttributeHolder(EMAttributes.COOLDOWN, WandItem.COOLDOWN_ID, baseCooldownTicks / 20.0f, AttributeModifier.Operation.ADD_VALUE));
        modifiers.add(new WandAttributeHolder(EMAttributes.WAND_DAMAGE, WandItem.BASE_WAND_DAMAGE_ID, baseDamage, AttributeModifier.Operation.ADD_VALUE));
        modifiers.add(new WandAttributeHolder(EMAttributes.LIFESPAN, WandItem.LIFESPAN_ID, baseLifespanSeconds, AttributeModifier.Operation.ADD_VALUE));
        modifiers.add(new WandAttributeHolder(EMAttributes.PROJECTILE_SPEED, WandItem.PROJECTILE_SPEED_ID, baseProjectileSpeed, AttributeModifier.Operation.ADD_VALUE));
        modifiers.add(new WandAttributeHolder(EMAttributes.WAND_KNOCKBACK, WandItem.WAND_KNOCKBACK_ID, baseKnockback, AttributeModifier.Operation.ADD_VALUE));
        modifiers.add(new WandAttributeHolder(EMAttributes.ACCURACY, WandItem.ACCURACY_ID, 1.0f - (baseInaccuracy / 100), AttributeModifier.Operation.ADD_VALUE));
        return this;
    }

    public void build(ItemAttributeModifiers.Builder builder) {
        for (WandAttributeHolder holder : modifiers) holder.addToBuilder(builder, EquipmentSlotGroup.MAINHAND);
    }

    public static class WandAttributeHolder {

        private final Holder<Attribute> attribute;
        private final ResourceLocation id;
        private float amount;
        private final AttributeModifier.Operation operation;

        public WandAttributeHolder(Holder<Attribute> attribute, ResourceLocation id, float amount,
                                   AttributeModifier.Operation operation) {
            this.attribute = attribute;
            this.id = id;
            this.amount = amount;
            this.operation = operation;
        }

        public void addToBuilder(ItemAttributeModifiers.Builder builder, EquipmentSlotGroup slot) {
            builder.add(
                    attribute,
                    new AttributeModifier(id, amount, operation),
                    slot
            );
        }

    }

    public record WandAttributeModifier(Holder<Attribute> attribute, float amount, Operation operation) {}

    public enum Operation {
        ADDITION,
        MULT,
        PERCENT
    }

}
