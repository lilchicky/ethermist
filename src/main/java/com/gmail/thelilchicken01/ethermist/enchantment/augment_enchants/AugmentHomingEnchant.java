package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public class AugmentHomingEnchant implements IWandAugmentEffect {

    public static final MapCodec<AugmentHomingEnchant> CODEC = MapCodec.unit(AugmentHomingEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public boolean doesProjectileHome() {
        return true;
    }
}
