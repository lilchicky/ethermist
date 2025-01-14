package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RichDirt extends Block {

    public RichDirt() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    }

}
