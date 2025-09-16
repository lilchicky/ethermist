package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record WandRecipe(Ingredient input1, Ingredient input2, ItemStack output) implements Recipe<WandRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(input1);
        list.add(input2);
        return list;
    }

    @Override
    public boolean matches(WandRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }
        return false;
    }

    @Override
    public ItemStack assemble(WandRecipeInput input, HolderLookup.Provider registries) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return null;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

}
