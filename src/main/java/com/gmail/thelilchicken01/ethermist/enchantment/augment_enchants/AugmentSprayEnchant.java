package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.MapCodec;

public record AugmentSprayEnchant() implements IWandAugmentEffect {

    public static final MapCodec<AugmentSprayEnchant> CODEC = MapCodec.unit(AugmentSprayEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        double damage = Math.max(0.0, state.damage);
        double damageMod = 1.0 / (1.0 + 0.81 * (1.0 / (1.0 + level)) * Math.sqrt(damage));
        state.damage *= damageMod;

        state.lifespanSeconds = Math.max(1.0, state.lifespanSeconds * 0.1);

        state.projectileSpeedMult *= 0.5;

        state.cooldownTicks = 5;

    }

}
