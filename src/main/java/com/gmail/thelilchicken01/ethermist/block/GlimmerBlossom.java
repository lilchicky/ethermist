package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class GlimmerBlossom extends FlowerBlock {

    public GlimmerBlossom() {
        super(MobEffects.GLOWING, 15, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).emissiveRendering((state, getter, pos) -> {
            return true;
        }).lightLevel((state) -> 8));
    }

}
