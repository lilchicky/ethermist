package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public class StableOrbEnchant implements IWandBaseEffect {

    public static final MapCodec<StableOrbEnchant> CODEC = MapCodec.unit(StableOrbEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.inaccuracyPercent = state.inaccuracyPercent / Math.pow((level + 1), 0.95);

    }

}
