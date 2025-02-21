package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class EMFlammableRotatedPillarBlock extends RotatedPillarBlock {

    public EMFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {

        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(EMBlocks.GLIMMERING_ANCIENT_LOG)) {
                return EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.GLIMMERING_ANCIENT_WOOD)) {
                return EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.ANCIENT_LOG)) {
                return EMBlocks.STRIPPED_ANCIENT_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.ANCIENT_WOOD)) {
                return EMBlocks.STRIPPED_ANCIENT_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.SLIMY_LOG)) {
                return EMBlocks.STRIPPED_SLIMY_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.SLIMY_WOOD)) {
                return EMBlocks.STRIPPED_SLIMY_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG)) {
                return EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD)) {
                return EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.FROSTPINE_LOG)) {
                return EMBlocks.STRIPPED_FROSTPINE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.FROSTPINE_WOOD)) {
                return EMBlocks.STRIPPED_FROSTPINE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.AMBERWOOD_LOG)) {
                return EMBlocks.STRIPPED_AMBERWOOD_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(EMBlocks.AMBERWOOD_WOOD)) {
                return EMBlocks.STRIPPED_AMBERWOOD_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
