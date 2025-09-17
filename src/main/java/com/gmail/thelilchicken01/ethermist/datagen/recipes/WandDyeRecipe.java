package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class WandDyeRecipe extends CustomRecipe {
    public WandDyeRecipe(CraftingBookCategory category) {
        super(category);
    }

    public boolean matches(CraftingInput input, Level level) {
        ItemStack itemstack = ItemStack.EMPTY;
        List<ItemStack> list = Lists.newArrayList();

        for(int i = 0; i < input.size(); ++i) {
            ItemStack itemstack1 = input.getItem(i);
            if (!itemstack1.isEmpty()) {
                if (itemstack1.is(EMTags.Items.DYEABLE_WANDS)) {
                    if (!itemstack.isEmpty()) {
                        return false;
                    }

                    itemstack = itemstack1;
                } else {
                    if (!(itemstack1.getItem() instanceof DyeItem)) {
                        return false;
                    }

                    list.add(itemstack1);
                }
            }
        }

        return !itemstack.isEmpty() && !list.isEmpty();
    }

    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        List<DyeItem> list = Lists.newArrayList();
        ItemStack itemstack = ItemStack.EMPTY;

        for(int i = 0; i < input.size(); ++i) {
            ItemStack itemstack1 = input.getItem(i);
            if (!itemstack1.isEmpty()) {
                if (itemstack1.is(EMTags.Items.DYEABLE_WANDS)) {
                    if (!itemstack.isEmpty()) {
                        return ItemStack.EMPTY;
                    }

                    itemstack = itemstack1.copy();
                } else {
                    Item var8 = itemstack1.getItem();
                    if (!(var8 instanceof DyeItem dyeitem)) {
                        return ItemStack.EMPTY;
                    }

                    list.add(dyeitem);
                }
            }
        }

        return !itemstack.isEmpty() && !list.isEmpty() ? applyWandDyes(itemstack, list) : ItemStack.EMPTY;
    }

    private static ItemStack applyWandDyes(ItemStack stack, List<DyeItem> dyes) {
        if (!stack.is(EMTags.Items.DYEABLE_WANDS)) {
            return ItemStack.EMPTY;
        } else {
            ItemStack itemstack = stack.copyWithCount(1);
            int i = 0;
            int j = 0;
            int k = 0;
            int l = 0;
            int i1 = 0;
            DyedItemColor dyeditemcolor = itemstack.get(DataComponents.DYED_COLOR);
            if (dyeditemcolor != null) {
                int currentColor = dyeditemcolor.rgb();
                if (currentColor == Ethermist.WAND_COLOR) {
                    dyeditemcolor = null;
                }
                else {
                    int j1 = FastColor.ARGB32.red(dyeditemcolor.rgb());
                    int k1 = FastColor.ARGB32.green(dyeditemcolor.rgb());
                    int l1 = FastColor.ARGB32.blue(dyeditemcolor.rgb());
                    l += Math.max(j1, Math.max(k1, l1));
                    i += j1;
                    j += k1;
                    k += l1;
                    ++i1;
                }
            }

            for(DyeItem dyeitem : dyes) {
                int j3 = dyeitem.getDyeColor().getTextureDiffuseColor();
                int i2 = FastColor.ARGB32.red(j3);
                int j2 = FastColor.ARGB32.green(j3);
                int k2 = FastColor.ARGB32.blue(j3);
                l += Math.max(i2, Math.max(j2, k2));
                i += i2;
                j += j2;
                k += k2;
                ++i1;
            }

            int l2 = i / i1;
            int i3 = j / i1;
            int k3 = k / i1;
            float f = (float)l / (float)i1;
            float f1 = (float)Math.max(l2, Math.max(i3, k3));
            l2 = (int)((float)l2 * f / f1);
            i3 = (int)((float)i3 * f / f1);
            k3 = (int)((float)k3 * f / f1);
            int finalColor = FastColor.ARGB32.color(0, l2, i3, k3);
            boolean showColorTooltip = dyeditemcolor == null || dyeditemcolor.showInTooltip();
            itemstack.set(DataComponents.DYED_COLOR, new DyedItemColor(finalColor, showColorTooltip));
            return itemstack;
        }
    }

    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return EMRecipeRegistration.WAND_DYE_RECIPE.get();
    }
}

