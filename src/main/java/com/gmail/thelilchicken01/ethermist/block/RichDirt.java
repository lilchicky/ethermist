package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class RichDirt extends Block {

    public RichDirt() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (itemAbility == ItemAbilities.HOE_TILL) {
            return EMBlocks.LUSH_FARMLAND.get().defaultBlockState();
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
