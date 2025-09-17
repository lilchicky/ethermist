package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMCustomRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> EM_RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, Ethermist.MODID);
    public static final DeferredRegister<RecipeType<?>> EM_RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, Ethermist.MODID);

    // Serializers
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<WandDyeRecipe>> WAND_DYE_RECIPE = EM_RECIPE_SERIALIZERS.register("wand_dye_recipe",
            () -> new SimpleCraftingRecipeSerializer<>(WandDyeRecipe::new)
    );
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<WandRecipe>> WAND_RECIPE_SERIALIZER = EM_RECIPE_SERIALIZERS.register("wand_recipe",
            WandRecipe.Serializer::new
    );

    // Types
    public static final DeferredHolder<RecipeType<?>, RecipeType<WandRecipe>> WAND_RECIPE_TYPE = EM_RECIPE_TYPES.register("wand_recipe",
            () -> new RecipeType<WandRecipe>() {
                @Override
                public String toString() {
                    return "wand_recipe";
                }
            }
    );

    public static void register(IEventBus bus) {
        EM_RECIPE_SERIALIZERS.register(bus);
        EM_RECIPE_TYPES.register(bus);
    }

}
