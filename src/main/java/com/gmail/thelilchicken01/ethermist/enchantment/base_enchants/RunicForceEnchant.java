package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public class RunicForceEnchant implements IWandBaseEffect {

    public static final MapCodec<RunicForceEnchant> CODEC = MapCodec.unit(RunicForceEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.knockbackMult = state.knockbackMult + (level * 0.85);

    }

}
