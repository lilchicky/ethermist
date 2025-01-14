package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Etherstone extends Block {

    public Etherstone() {

        super(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops());

    }

}
