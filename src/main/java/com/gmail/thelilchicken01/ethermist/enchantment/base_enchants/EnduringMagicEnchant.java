package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public class EnduringMagicEnchant implements IWandBaseEffect {

    public static final MapCodec<EnduringMagicEnchant> CODEC = MapCodec.unit(EnduringMagicEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.lifespanSeconds = state.lifespanSeconds * (level + 1);

    }

}
