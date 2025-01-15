package com.gmail.thelilchicken01.ethermist.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SparklingSand extends FallingBlock {

    public static final MapCodec<SparklingSand> CODEC = simpleCodec(SparklingSand::new);

    public SparklingSand(Properties properties) {
        super (properties);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }

}
