package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeStateTest;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.mojang.serialization.MapCodec;

public class RunicForceEnchant implements IWandBaseEffect {

    public static final MapCodec<RunicForceEnchant> CODEC = MapCodec.unit(RunicForceEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void modifyWandAttributes(WandAttributeStateTest state, int level) {
        state.modifyExistingAttribute(EMAttributes.WAND_KNOCKBACK, WandAttributeStateTest.Operation.ADDITION, (level * 1.75f));
    }

}
