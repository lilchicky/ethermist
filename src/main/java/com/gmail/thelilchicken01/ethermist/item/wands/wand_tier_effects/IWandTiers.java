package com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects;

import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;

public interface IWandTiers {

    String getDescription();

    float[] getHandleColor();

    Supplier<Ingredient> getRepairItem();

    double getModifierFor(IWandTiers targetTier);

    List<Component> getModifierString();

}

