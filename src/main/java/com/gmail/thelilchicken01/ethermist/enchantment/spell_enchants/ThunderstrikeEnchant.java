package com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public class ThunderstrikeEnchant implements IWandSpellEffect {

    public static final MapCodec<ThunderstrikeEnchant> CODEC = MapCodec.unit(ThunderstrikeEnchant::new);

    @Override
    public MapCodec<? extends IWandSpellEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.cooldownTicks = (int)Math.round((8L * state.cooldownTicks + 240L) / 7.0);

    }

}
