package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class WandRecipeBuilder extends EMRecipeBuilder {

    private final Ingredient orb;
    private final Ingredient base = Ingredient.of(EMTags.Items.WAND_BASE);

    public WandRecipeBuilder(Item result, Ingredient orb) {
        super(new ItemStack(result));
        this.orb = orb;
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {

        Advancement.Builder advancement = output.advancement()
                .addCriterion("has_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement::addCriterion);
        WandRecipe recipe = new WandRecipe(this.base, this.orb, this.result);
        output.accept(id, recipe, advancement.build(id.withPrefix("recipes/wandforging/")));

    }
}
