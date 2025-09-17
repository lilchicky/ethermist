package com.gmail.thelilchicken01.ethermist.compat;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.WandRecipe;
import com.gmail.thelilchicken01.ethermist.screen.WandforgingTableMenu;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.gmail.thelilchicken01.ethermist.datagen.recipes.EMRecipeRegistration.WAND_RECIPE_LOCATION;

public class WandRecipeCategory implements IRecipeCategory<WandRecipe> {

    private final int GUI_WIDTH = 174;
    private final int GUI_HEIGHT = 81;

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, WAND_RECIPE_LOCATION);
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
            "textures/gui/container/wandforging_table.png");

    public static final RecipeType<WandRecipe> WAND_RECIPE_RECIPE_TYPE = new RecipeType<>(UID, WandRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public WandRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, GUI_WIDTH, GUI_HEIGHT);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EMBlocks.WANDFORGING_TABLE));
    }

    @Override
    public RecipeType<WandRecipe> getRecipeType() {
        return WAND_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.ethermist.wandforging_table.menu");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WandRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, WandforgingTableMenu.INPUT_1_X, WandforgingTableMenu.INPUT_Y).addIngredients(recipe.getIngredients().getFirst());
        builder.addSlot(RecipeIngredientRole.INPUT, WandforgingTableMenu.INPUT_2_X, WandforgingTableMenu.INPUT_Y).addIngredients(recipe.getIngredients().getLast());

        builder.addSlot(RecipeIngredientRole.OUTPUT, WandforgingTableMenu.OUTPUT_X, WandforgingTableMenu.OUTPUT_Y).addItemStack(recipe.getResultItem(null));
    }

    @Override
    public void draw(WandRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        background.draw(guiGraphics);
    }

    @Override
    public int getWidth() {
        return GUI_WIDTH;
    }

    @Override
    public int getHeight() {
        return GUI_HEIGHT;
    }

}
