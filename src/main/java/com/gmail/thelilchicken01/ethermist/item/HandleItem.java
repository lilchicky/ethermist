package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class HandleItem extends Item {

    public HandleItem() {
        super(new Properties().stacksTo(1).component(DataComponents.DYED_COLOR, new DyedItemColor(Ethermist.WAND_COLOR, false)));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().getBlockState(context.getClickedPos()).is(Blocks.WATER_CAULDRON)) {
            BlockState cauldron = context.getLevel().getBlockState(context.getClickedPos());
            if (cauldron.getValue(LayeredCauldronBlock.LEVEL) > 0) {
                ItemStack wand = context.getItemInHand();
                if (wand.get(DataComponents.DYED_COLOR).rgb() != Ethermist.WAND_COLOR) {
                    System.out.println(wand.get(DataComponents.DYED_COLOR).rgb());
                    wand.set(DataComponents.DYED_COLOR, new DyedItemColor(Ethermist.WAND_COLOR, true));
                    return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
                }
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lore, TooltipFlag tooltipFlag) {

        lore.add(Component.translatable("item." + Ethermist.MODID + ".wand.dyeable").withColor(0xAAAAAA));

        super.appendHoverText(stack, context, lore, tooltipFlag);
    }

}
