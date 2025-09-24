package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public class AncientPowerEnchant implements IWandBaseEffect {

    public static final MapCodec<AncientPowerEnchant> CODEC = MapCodec.unit(AncientPowerEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.damage += (level > 0 ? 0.5 * level + 0.5 : 0);

    }

}
