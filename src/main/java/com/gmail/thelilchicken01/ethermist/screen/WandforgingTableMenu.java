package com.gmail.thelilchicken01.ethermist.screen;

import java.util.List;
import java.util.OptionalInt;
import javax.annotation.Nullable;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class WandforgingTableMenu extends ItemCombinerMenu {
    public static final int INPUT_SLOT_1 = 0;
    public static final int INPUT_SLOT_2 = 1;
    public static final int OUTPUT_SLOT = 2;
    public static final int INPUT_1_X = 44;
    public static final int INPUT_2_X = 116;
    private static final int OUTPUT_X = 80;
    public static final int INPUT_SLOT_Y = 37;
    public static final int OUTPUT_SLOT_Y = 53;
    private final Level level;
    @Nullable
    private RecipeHolder<SmithingRecipe> selectedRecipe;
    private final List<RecipeHolder<SmithingRecipe>> recipes;

    public WandforgingTableMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL);
    }

    public WandforgingTableMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(EMMenuTypes.WANDFORGING_TABLE_MENU.get(), containerId, playerInventory, access);
        this.level = playerInventory.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(RecipeType.SMITHING);
    }

    @Override
    protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create()
                .withSlot(INPUT_SLOT_1, INPUT_1_X, INPUT_SLOT_Y, stack -> this.recipes.stream().anyMatch(recipe -> recipe.value().isTemplateIngredient(stack)))
                .withSlot(INPUT_SLOT_2, INPUT_2_X, INPUT_SLOT_Y, stack -> this.recipes.stream().anyMatch(recipe -> recipe.value().isBaseIngredient(stack)))
                .withResultSlot(OUTPUT_SLOT, OUTPUT_X, OUTPUT_SLOT_Y)
                .build();
    }

    @Override
    protected boolean isValidBlock(BlockState state) {
        return state.is(EMBlocks.WANDFORGING_TABLE);
    }

    @Override
    protected boolean mayPickup(Player player, boolean hasStack) {
        return this.selectedRecipe != null && this.selectedRecipe.value().matches(this.createRecipeInput(), this.level);
    }

    @Override
    protected void onTake(Player player, ItemStack stack) {
        stack.onCraftedBy(player.level(), player, stack.getCount());
        this.resultSlots.awardUsedRecipes(player, this.getRelevantItems());
        this.shrinkStackInSlot(INPUT_SLOT_1);
        this.shrinkStackInSlot(INPUT_SLOT_2);
        this.access.execute((level, pos) -> level.levelEvent(1044, pos, 0));
    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.inputSlots.getItem(INPUT_SLOT_1), this.inputSlots.getItem(INPUT_SLOT_2));
    }

    private SmithingRecipeInput createRecipeInput() {
        return new SmithingRecipeInput(this.inputSlots.getItem(INPUT_SLOT_1), this.inputSlots.getItem(INPUT_SLOT_2), this.inputSlots.getItem(2));
    }

    private void shrinkStackInSlot(int index) {
        ItemStack itemstack = this.inputSlots.getItem(index);
        if (!itemstack.isEmpty()) {
            itemstack.shrink(1);
            this.inputSlots.setItem(index, itemstack);
        }
    }

    @Override
    public void createResult() {
        SmithingRecipeInput smithingrecipeinput = this.createRecipeInput();
        List<RecipeHolder<SmithingRecipe>> list = this.level.getRecipeManager().getRecipesFor(RecipeType.SMITHING, smithingrecipeinput, this.level);
        if (list.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            RecipeHolder<SmithingRecipe> recipeholder = list.get(0);
            ItemStack itemstack = recipeholder.value().assemble(smithingrecipeinput, this.level.registryAccess());
            if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
                this.selectedRecipe = recipeholder;
                this.resultSlots.setRecipeUsed(recipeholder);
                this.resultSlots.setItem(0, itemstack);
            }
        }
    }

    @Override
    public int getSlotToQuickMoveTo(ItemStack stack) {
        return this.findSlotToQuickMoveTo(stack).orElse(0);
    }

    private static OptionalInt findSlotMatchingIngredient(SmithingRecipe recipe, ItemStack stack) {
        if (recipe.isTemplateIngredient(stack)) {
            return OptionalInt.of(0);
        } else if (recipe.isBaseIngredient(stack)) {
            return OptionalInt.of(1);
        } else {
            return recipe.isAdditionIngredient(stack) ? OptionalInt.of(2) : OptionalInt.empty();
        }
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultSlots && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public boolean canMoveIntoInputSlots(ItemStack stack) {
        return this.findSlotToQuickMoveTo(stack).isPresent();
    }

    private OptionalInt findSlotToQuickMoveTo(ItemStack stack) {
        return this.recipes
                .stream()
                .flatMapToInt(p_300800_ -> findSlotMatchingIngredient(p_300800_.value(), stack).stream())
                .filter(p_294045_ -> !this.getSlot(p_294045_).hasItem())
                .findFirst();
    }
}
