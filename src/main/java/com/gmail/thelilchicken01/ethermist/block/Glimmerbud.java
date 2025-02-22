package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Glimmerbud extends FlowerBlock {

    public Glimmerbud() {
        super(MobEffects.GLOWING, 15, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).emissiveRendering((state, getter, pos) -> true).lightLevel((state) -> 8));
    }

}
