package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CobbledEtherstone extends Block {

    public CobbledEtherstone() {

        super(Properties.ofFullCopy(Blocks.COBBLESTONE).requiresCorrectToolForDrops());

    }

}
