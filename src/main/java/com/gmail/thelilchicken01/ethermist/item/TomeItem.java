package com.gmail.thelilchicken01.ethermist.item;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

import java.util.List;

public class TomeItem extends BookItem {

    public TomeItem() {
        super(new Item.Properties());
    }

    // Credit to Apotheosis/Apothic Enchanting for this bit
    @Override
    public ItemStack applyEnchantments(ItemStack stack, List<EnchantmentInstance> enchantments) {
        stack = stack.transmuteCopy(Items.ENCHANTED_BOOK);
        for (EnchantmentInstance instance : enchantments) {
            stack.enchant(instance.enchantment, instance.level);
        }
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lore, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, lore, tooltipFlag);
        lore.add(Component.translatable(this.getDescriptionId() + ".desc").withColor(0xAAAAAA));
    }
}
