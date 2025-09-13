package com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects;

import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;

public interface IWandTiers {

    ResourceLocation id();

    String getDescription();
    float[] getHandleColor();
    Supplier<Ingredient> getRepairItem();
    List<Component> getModifierString();
    boolean doesBuffSpell();

    void apply(WandAttributeState state);

}

