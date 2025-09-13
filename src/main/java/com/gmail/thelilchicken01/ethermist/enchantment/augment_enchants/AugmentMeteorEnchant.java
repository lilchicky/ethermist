package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import static com.gmail.thelilchicken01.ethermist.item.wands.WandItem.BLOCK_INTERACTION_RANGE_ID;
import static com.gmail.thelilchicken01.ethermist.item.wands.WandItem.ENTITY_INTERACTION_RANGE_ID;

public record AugmentMeteorEnchant() implements IWandAugmentEffect {

    public static final MapCodec<AugmentMeteorEnchant> CODEC = MapCodec.unit(AugmentMeteorEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.damage *= 3.0;
        state.lifespanSeconds *= 5.0;
        state.inaccuracyPercent *= 0.1; // 90% more accurate

    }

    @Override
    public void addSpecialAttributes(ItemAttributeModifiers.Builder builder) {

        builder.add(
                Attributes.BLOCK_INTERACTION_RANGE,
                new AttributeModifier(BLOCK_INTERACTION_RANGE_ID, 16, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ENTITY_INTERACTION_RANGE,
                new AttributeModifier(ENTITY_INTERACTION_RANGE_ID, 16, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );

    }
}
