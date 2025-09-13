package com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public class ChaosMagicEnchant implements IWandSpellEffect {

    public static final MapCodec<ChaosMagicEnchant> CODEC = MapCodec.unit(ChaosMagicEnchant::new);

    @Override
    public MapCodec<? extends IWandSpellEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.damage *= level;

    }

}
