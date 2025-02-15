package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;

public class NightLavender extends FlowerBlock {

    public NightLavender() {
        super(MobEffects.NIGHT_VISION, 15, Properties.ofFullCopy(Blocks.POPPY));
    }

}
