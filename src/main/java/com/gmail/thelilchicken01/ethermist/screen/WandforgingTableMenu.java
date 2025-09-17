package com.gmail.thelilchicken01.ethermist.screen;

import java.util.List;
import javax.annotation.Nullable;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.EMRecipeRegistration;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.WandRecipe;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.WandRecipeInput;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class WandforgingTableMenu extends ItemCombinerMenu {
    public static final int INPUT_SLOT_1 = 0;
    public static final int INPUT_SLOT_2 = 1;
    public static final int OUTPUT_SLOT = 2;
    public static final int INPUT_1_X = 44;
    public static final int INPUT_2_X = 116;
    public static final int OUTPUT_X = 80;
    public static final int INPUT_Y = 37;
    public static final int OUTPUT_Y = 53;
    private final Level level;
    @Nullable
    private RecipeHolder<WandRecipe> selectedRecipe;
    private final List<RecipeHolder<WandRecipe>> recipes;

    public WandforgingTableMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL);
    }

    public WandforgingTableMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(EMMenuTypes.WANDFORGING_TABLE_MENU.get(), containerId, playerInventory, access);
        this.level = playerInventory.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(EMRecipeRegistration.WAND_RECIPE_TYPE.get());
    }

    @Override
    protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create()
                .withSlot(INPUT_SLOT_1, INPUT_1_X, INPUT_Y, stack ->
                        this.recipes.stream().anyMatch(recipe -> recipe.value().isWandIngredient(stack)))
                .withSlot(INPUT_SLOT_2, INPUT_2_X, INPUT_Y, stack ->
                        this.recipes.stream().anyMatch(recipe -> recipe.value().isWandIngredient(stack)))
                .withResultSlot(OUTPUT_SLOT, OUTPUT_X, OUTPUT_Y)
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
        this.access.execute((level, pos) -> {
            level.playSound(
                    null,
                    pos,
                    SoundEvents.ENCHANTMENT_TABLE_USE,
                    SoundSource.BLOCKS,
                    1.0F, 1.0F
            );
        });
    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.inputSlots.getItem(INPUT_SLOT_1), this.inputSlots.getItem(INPUT_SLOT_2));
    }

    private WandRecipeInput createRecipeInput() {
        return new WandRecipeInput(this.inputSlots.getItem(INPUT_SLOT_1), this.inputSlots.getItem(INPUT_SLOT_2));
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
        WandRecipeInput wandrecipeinput = this.createRecipeInput();
        List<RecipeHolder<WandRecipe>> list = this.level.getRecipeManager().getRecipesFor(EMRecipeRegistration.WAND_RECIPE_TYPE.get(), wandrecipeinput, this.level);
        if (list.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            RecipeHolder<WandRecipe> recipeholder = list.getFirst();
            ItemStack itemstack = recipeholder.value().assemble(wandrecipeinput, this.level.registryAccess());
            if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
                this.selectedRecipe = recipeholder;
                this.resultSlots.setRecipeUsed(recipeholder);
                this.resultSlots.setItem(0, itemstack);
            }
        }
    }

    @Override
    public int getSlotToQuickMoveTo(ItemStack stack) {
        return this.inputSlots.canPlaceItem(0, stack) ? 0 : 1;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultSlots && super.canTakeItemForPickAll(stack, slot);
    }

}
