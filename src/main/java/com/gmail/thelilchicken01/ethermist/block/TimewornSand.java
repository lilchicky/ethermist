package com.gmail.thelilchicken01.ethermist.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;

public class TimewornSand extends FallingBlock {

    public static final MapCodec<TimewornSand> CODEC = simpleCodec(TimewornSand::new);

    public TimewornSand(Properties properties) {
        super (properties);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }

}
