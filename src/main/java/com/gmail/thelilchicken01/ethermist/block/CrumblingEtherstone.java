package com.gmail.thelilchicken01.ethermist.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;

public class CrumblingEtherstone extends FallingBlock {

    public static final MapCodec<CrumblingEtherstone> CODEC = simpleCodec(CrumblingEtherstone::new);

    public CrumblingEtherstone(Properties properties) {
        super (properties);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }

}
