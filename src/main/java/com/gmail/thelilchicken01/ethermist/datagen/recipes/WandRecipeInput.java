package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record WandRecipeInput(ItemStack left, ItemStack right) implements RecipeInput {
    @Override
    public ItemStack getItem(int slot) {
        return switch (slot) {
            case 0 -> this.left;
            case 1 -> this.right;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        };
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return this.left.isEmpty() && this.right.isEmpty();
    }
}
