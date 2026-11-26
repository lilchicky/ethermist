package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.mojang.serialization.MapCodec;

public class ArcaneVelocityEnchant implements IWandBaseEffect {

    public static final MapCodec<ArcaneVelocityEnchant> CODEC = MapCodec.unit(ArcaneVelocityEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void modifyWandAttributes(WandAttributeState state, int level) {
        state.modifyExistingAttribute(EMAttributes.PROJECTILE_SPEED, WandAttributeState.Operation.ADDITION, ((level + 1) * 0.25f));
    }

}
