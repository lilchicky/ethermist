package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeStateTest;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.mojang.serialization.MapCodec;

public class AncientPowerEnchant implements IWandBaseEffect {

    public static final MapCodec<AncientPowerEnchant> CODEC = MapCodec.unit(AncientPowerEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void modifyWandAttributes(WandAttributeStateTest state, int level) {
        state.modifyExistingAttribute(EMAttributes.WAND_DAMAGE, WandAttributeStateTest.Operation.ADDITION, (level > 0 ? 0.5f * level + 0.5f : 0));
    }

}
