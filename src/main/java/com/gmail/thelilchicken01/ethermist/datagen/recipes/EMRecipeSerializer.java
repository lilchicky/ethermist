package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMRecipeSerializer {

    public static final DeferredRegister<RecipeSerializer<?>> EM_RECIPE_SERIALIZER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, Ethermist.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> WAND_DYE_RECIPE = EM_RECIPE_SERIALIZER.register("wand_dye_recipe",
            () -> new SimpleCraftingRecipeSerializer<>(WandDyeRecipe::new)
    );

    public static void register (IEventBus bus) {
        EM_RECIPE_SERIALIZER.register(bus);
    }

}
