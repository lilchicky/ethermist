package com.gmail.thelilchicken01.ethermist.item.armor;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class MageArmorItem extends ArmorItem {

    private final ItemAttributeModifiers attributes;

    public MageArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, ItemAttributeModifiers attributes) {
        super(material, type, properties);
        this.attributes = attributes;
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        ItemAttributeModifiers baseWand = super.getDefaultAttributeModifiers(stack);
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();

        for (var attribute : baseWand.modifiers()) {
            builder.add(attribute.attribute(), attribute.modifier(), attribute.slot());
        }

        for (var attribute : attributes.modifiers()) {
            builder.add(attribute.attribute(), attribute.modifier(), attribute.slot());
        }

        return builder.build();
    }

}
