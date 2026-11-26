package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.mojang.serialization.MapCodec;

public class EnduringMagicEnchant implements IWandBaseEffect {

    public static final MapCodec<EnduringMagicEnchant> CODEC = MapCodec.unit(EnduringMagicEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void modifyWandAttributes(WandAttributeState state, int level) {
        state.modifyExistingAttribute(EMAttributes.LIFESPAN, WandAttributeState.Operation.MULT, (level + 1));
    }

}
