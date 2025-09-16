package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record WandRecipeInput(ItemStack input1, ItemStack input2) implements RecipeInput {
    @Override
    public ItemStack getItem(int slot) {
        return switch (slot) {
            case 0 -> this.input1;
            case 1 -> this.input2;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        };
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return this.input1.isEmpty() && this.input2.isEmpty();
    }
}
