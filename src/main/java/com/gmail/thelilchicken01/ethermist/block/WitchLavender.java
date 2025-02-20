package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;

public class WitchLavender extends FlowerBlock {

    public WitchLavender() {
        super(MobEffects.REGENERATION, 15, Properties.ofFullCopy(Blocks.POPPY));
    }

}
