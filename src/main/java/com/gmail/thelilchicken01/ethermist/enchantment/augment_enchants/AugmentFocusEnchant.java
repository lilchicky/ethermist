package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public class AugmentFocusEnchant implements IWandAugmentEffect {

    public static final MapCodec<AugmentFocusEnchant> CODEC = MapCodec.unit(AugmentFocusEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.damage *= (level * 1.5);
        state.projectileSpeedMult *= 4.5;
        state.inaccuracyPercent = 0.0;
        state.cooldownTicks = Math.max(state.cooldownTicks * 4, 100);

    }

}
