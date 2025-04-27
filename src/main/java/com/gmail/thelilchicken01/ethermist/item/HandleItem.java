package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.IWandTiers;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class HandleItem extends Item implements IDyeableWandItem {

    private final IWandTiers TIER;

    public HandleItem(IWandTiers tier) {
        super(new Properties().stacksTo(1).component(DataComponents.DYED_COLOR, new DyedItemColor(Ethermist.WAND_COLOR, false)));
        this.TIER = tier;
    }

    public IWandTiers getTier() {
        return TIER;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().getBlockState(context.getClickedPos()).is(Blocks.WATER_CAULDRON)) {
            BlockState cauldron = context.getLevel().getBlockState(context.getClickedPos());
            int fillLevel = cauldron.getValue(LayeredCauldronBlock.LEVEL);
            if (fillLevel > 0) {
                ItemStack wand = context.getItemInHand();
                if (wand.get(DataComponents.DYED_COLOR).rgb() != Ethermist.WAND_COLOR) {
                    wand.set(DataComponents.DYED_COLOR, new DyedItemColor(Ethermist.WAND_COLOR, false));
                    LayeredCauldronBlock.lowerFillLevel(cauldron, context.getLevel(), context.getClickedPos());
                    return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
                }
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lore, TooltipFlag tooltipFlag) {

        // This code is added to make the "Dyeable" text multicolored, without
        // hardcoding it. That lets it dynamically work with different
        // language files, no matter the length of the phrase used here.

        int[] colors = {
                0xFF5555, // red
                0xFFAA00, // orange
                0xFFFF55, // yellow
                0x55FF55, // green
                0x55FFFF, // cyan
                0x5555FF, // blue
                0xAA00FF  // purple
        };

        MutableComponent dyeableText = Component.empty();
        String text = I18n.get("item." + Ethermist.MODID + ".wand.dyeable");

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int color = colors[i % colors.length];

            dyeableText.append(Component.literal(String.valueOf(c)).withColor(color));
        }

        lore.add(dyeableText);
        lore.add(Component.empty());

        lore.addAll(TIER.getModifierString());

        lore.add(Component.empty());
        lore.add(Component.translatable("item.ethermist.handle_description.line_1").withColor(0xAAAAAA));
        lore.add(Component.translatable("item.ethermist.handle_description.line_2").withColor(0xAAAAAA));

        if (stack.isEnchanted()) {
            lore.add(Component.empty());
        }

        super.appendHoverText(stack, context, lore, tooltipFlag);

    }

}
