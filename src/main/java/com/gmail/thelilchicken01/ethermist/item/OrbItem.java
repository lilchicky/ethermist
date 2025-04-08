package com.gmail.thelilchicken01.ethermist.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.function.Supplier;

public class OrbItem extends Item {

    public OrbItem() {
        super(new Item.Properties().stacksTo(16));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lore, TooltipFlag tooltipFlag) {

        lore.add(Component.translatable(this.getDescriptionId() + ".desc").withColor(0xAAAAAA));
        lore.add(Component.empty());
        lore.add(Component.translatable("item.ethermist.orb_description.line_1").withColor(0xAAAAAA));
        lore.add(Component.translatable("item.ethermist.orb_description.line_2").withColor(0xAAAAAA));

        super.appendHoverText(stack, context, lore, tooltipFlag);
    }
}
