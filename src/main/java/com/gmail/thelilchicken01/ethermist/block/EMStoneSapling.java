package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;

public class EMStoneSapling extends SaplingBlock {

    public EMStoneSapling(TreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || state.is(EMTags.Blocks.CAN_SUPPORT_CHARRED_TREE);
    }

}
