package com.gmail.thelilchicken01.ethermist.compat;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.EMRecipeBuilder;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.EMRecipeRegistration;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.WandRecipe;
import com.gmail.thelilchicken01.ethermist.screen.WandforgingTableScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIEMPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new WandRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();

        List<WandRecipe> list = manager.getAllRecipesFor(
                EMRecipeRegistration.WAND_RECIPE_TYPE.get()).stream().map(RecipeHolder::value).toList();

        registration.addRecipes(WandRecipeCategory.WAND_RECIPE_RECIPE_TYPE, list);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(EMBlocks.WANDFORGING_TABLE.asItem()),
                WandRecipeCategory.WAND_RECIPE_RECIPE_TYPE);
    }
}
