package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import com.gmail.thelilchicken01.ethermist.component.EMDataComponents;
import com.gmail.thelilchicken01.ethermist.item.HandleItem;
import com.gmail.thelilchicken01.ethermist.item.OrbItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.stream.Stream;

public class WandRecipe implements Recipe<WandRecipeInput> {

    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;

    public WandRecipe(Ingredient left, Ingredient right, ItemStack result) {
        this.base = left;
        this.addition = right;
        this.result = result;
    }

    public boolean isWandIngredient(ItemStack stack) {
        return (stack.getItem() instanceof WandItem || stack.getItem() instanceof OrbItem || stack.getItem() instanceof HandleItem);
    }

    @Override
    public boolean matches(WandRecipeInput input, Level level) {
        return ((this.base.test(input.left())) || (this.addition.test(input.left()))) &&
                ((this.base.test(input.right())) || (this.addition.test(input.right()))) &&
                !(this.addition.test(input.right()) && this.addition.test(input.left()));
    }

    @Override
    public ItemStack assemble(WandRecipeInput input, HolderLookup.Provider registries) {

        boolean isLeftBase = this.base.test(input.left());
        boolean isRightBase = this.base.test(input.right());

        final var HANDLE_COMP = EMDataComponents.WAND_HANDLE.get();

        ItemStack out;

        if (isLeftBase && isRightBase) {

            boolean isLeftWand = input.left().getItem() instanceof WandItem;
            boolean isRightWand = input.right().getItem() instanceof WandItem;

            if ((isLeftWand && isRightWand) || (!isLeftWand && !isRightWand)) {
                return ItemStack.EMPTY;
            }

            ItemStack wand = isLeftWand ? input.left() : input.right();
            ItemStack handle = isLeftWand ? input.right() : input.left();

            var additionHandleComp = handle.get(HANDLE_COMP);
            if (additionHandleComp == null) return ItemStack.EMPTY;

            out = wand.copy();
            out.applyComponents(handle.getComponentsPatch());
            out.set(HANDLE_COMP, additionHandleComp);

            return out;

        }

        if (isLeftBase || isRightBase) {
            ItemStack base = isLeftBase ? input.left() : input.right();

            var additionHandleComp = base.get(HANDLE_COMP);
            if (additionHandleComp == null) return ItemStack.EMPTY;

            if (base.getItem() instanceof WandItem) {
                out = base.transmuteCopy(this.result.getItem());
                out.applyComponents(this.result.getComponentsPatch());
                out.set(HANDLE_COMP, additionHandleComp);
            } else {
                out = this.result.copy();
                out.set(HANDLE_COMP, additionHandleComp);
            }

            return out;

        }

        return ItemStack.EMPTY;

    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    @Override
    public boolean isIncomplete() {
        return Stream.of(this.base, this.addition).anyMatch(Ingredient::hasNoItems);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return EMCustomRecipes.WAND_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return EMCustomRecipes.WAND_RECIPE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<WandRecipe> {

        private static final MapCodec<WandRecipe> CODEC = RecordCodecBuilder.mapCodec(
                instance -> instance.group(
                                Ingredient.CODEC.fieldOf("left").forGetter(recipe -> recipe.base),
                                Ingredient.CODEC.fieldOf("right").forGetter(recipe -> recipe.addition),
                                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
                        )
                        .apply(instance, WandRecipe::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, WandRecipe> STREAM_CODEC = StreamCodec.of(
                WandRecipe.Serializer::toNetwork, WandRecipe.Serializer::fromNetwork
        );

        @Override
        public MapCodec<WandRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WandRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static WandRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            Ingredient ingredient1 = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            return new WandRecipe(ingredient, ingredient1, itemstack);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, WandRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.base);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.addition);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }

    }

}
