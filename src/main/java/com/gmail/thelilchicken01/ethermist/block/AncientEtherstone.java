package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

public class AncientEtherstone extends Block {

    public AncientEtherstone() {

        super(Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.9f));

    }

}
