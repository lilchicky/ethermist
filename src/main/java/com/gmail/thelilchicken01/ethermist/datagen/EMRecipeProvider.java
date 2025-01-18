package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EMRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public EMRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        List<ItemLike> MIST_GEM_SMELTABLES = List.of(EMBlocks.MIST_GEM_ORE);

        oreSmelting(output, MIST_GEM_SMELTABLES, RecipeCategory.MISC, EMItems.GENERIC_SHOT.get(), 0.25f, 200, "mist_gem");
        oreBlasting(output, MIST_GEM_SMELTABLES, RecipeCategory.MISC, EMItems.GENERIC_SHOT.get(), 0.25f, 100, "mist_gem");

        //Etherstone
        stairBuilder(EMBlocks.ETHERSTONE_STAIRS.get(), Ingredient.of(EMBlocks.ETHERSTONE)).group("stairs")
                .unlockedBy("has_etherstone", has(EMBlocks.ETHERSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_SLAB.get(), EMBlocks.ETHERSTONE.get());
        buttonBuilder(EMBlocks.ETHERSTONE_BUTTON.get(), Ingredient.of(EMBlocks.ETHERSTONE)).group("buttons")
                .unlockedBy("has_etherstone", has(EMBlocks.ETHERSTONE)).save(output);
        pressurePlate(output, EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), EMBlocks.ETHERSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_WALL.get(), EMBlocks.ETHERSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_STAIRS.get(), EMBlocks.ETHERSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_SLAB.get(), EMBlocks.ETHERSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_WALL.get(), EMBlocks.ETHERSTONE.get(), 1);

        stairBuilder(EMBlocks.ETHERSTONE_BRICK_STAIRS.get(), Ingredient.of(EMBlocks.ETHERSTONE_BRICKS)).group("stairs")
                .unlockedBy("has_etherstone", has(EMBlocks.ETHERSTONE_BRICKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_BRICK_SLAB.get(), EMBlocks.ETHERSTONE_BRICKS.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_BRICK_WALL.get(), EMBlocks.ETHERSTONE_BRICKS.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_BRICK_STAIRS.get(), EMBlocks.ETHERSTONE_BRICKS.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_BRICK_SLAB.get(), EMBlocks.ETHERSTONE_BRICKS.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_BRICK_WALL.get(), EMBlocks.ETHERSTONE_BRICKS.get(), 1);

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_BRICKS.get(), EMBlocks.ETHERSTONE.get(), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_BRICKS.get(), 4)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.ETHERSTONE.get())
                .unlockedBy("has_timeworn_sand", has(EMBlocks.ETHERSTONE)).save(output);

        // Ancient Wood
        stairBuilder(EMBlocks.ANCIENT_STAIRS.get(), Ingredient.of(EMBlocks.ANCIENT_PLANKS)).group("stairs")
                .unlockedBy("has_ancient_planks", has(EMBlocks.ANCIENT_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_SLAB.get(), EMBlocks.ANCIENT_PLANKS.get());
        buttonBuilder(EMBlocks.ANCIENT_BUTTON.get(), Ingredient.of(EMBlocks.ANCIENT_PLANKS)).group("slabs")
                .unlockedBy("has_ancient_planks", has(EMBlocks.ANCIENT_PLANKS)).save(output);
        pressurePlate(output, EMBlocks.ANCIENT_PRESSURE_PLATE.get(), EMBlocks.ANCIENT_PLANKS.get());
        fenceBuilder(EMBlocks.ANCIENT_FENCE.get(), Ingredient.of(EMBlocks.ANCIENT_PLANKS)).group("fences")
                .unlockedBy("has_ancient_planks", has(EMBlocks.ANCIENT_PLANKS)).save(output);
        fenceGateBuilder(EMBlocks.ANCIENT_FENCE_GATE.get(), Ingredient.of(EMBlocks.ANCIENT_PLANKS)).group("fence_gates")
                .unlockedBy("has_ancient_planks", has(EMBlocks.ANCIENT_PLANKS)).save(output);
        doorBuilder(EMBlocks.ANCIENT_DOOR.get(), Ingredient.of(EMBlocks.ANCIENT_PLANKS)).group("doors")
                .unlockedBy("has_ancient_planks", has(EMBlocks.ANCIENT_PLANKS)).save(output);
        trapdoorBuilder(EMBlocks.ANCIENT_TRAPDOOR.get(), Ingredient.of(EMBlocks.ANCIENT_PLANKS)).group("trapdoors")
                .unlockedBy("has_ancient_planks", has(EMBlocks.ANCIENT_PLANKS)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.ANCIENT_LOG.get())
                .unlockedBy("has_ancient_log", has(EMBlocks.ANCIENT_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ANCIENT_PLANKS.getId().getPath() + "_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.ANCIENT_WOOD.get())
                .unlockedBy("has_ancient_wood", has(EMBlocks.ANCIENT_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ANCIENT_PLANKS.getId().getPath() + "_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_ANCIENT_LOG.get())
                .unlockedBy("has_stripped_ancient_log", has(EMBlocks.STRIPPED_ANCIENT_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ANCIENT_PLANKS.getId().getPath() + "_stripped_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_ANCIENT_WOOD.get())
                .unlockedBy("has_stripped_ancient_wood", has(EMBlocks.STRIPPED_ANCIENT_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ANCIENT_PLANKS.getId().getPath() + "_stripped_wood"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.ANCIENT_LOG.get())
                .unlockedBy("has_ancient_log", has(EMBlocks.ANCIENT_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.STRIPPED_ANCIENT_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.STRIPPED_ANCIENT_LOG.get())
                .unlockedBy("has_ancient_wood", has(EMBlocks.STRIPPED_ANCIENT_LOG)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.PEEKING_ANCIENT_LOG.get())
                .unlockedBy("has_peeking_ancient_log", has(EMBlocks.PEEKING_ANCIENT_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ANCIENT_PLANKS.getId().getPath() + "_peeking_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.PEEKING_ANCIENT_LOG.get())
                .unlockedBy("has_peeking_ancient_wood", has(EMBlocks.PEEKING_ANCIENT_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ANCIENT_PLANKS.getId().getPath() + "_peeking_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_PEEKING_ANCIENT_LOG.get())
                .unlockedBy("has_stripped_peeking_ancient_log", has(EMBlocks.STRIPPED_PEEKING_ANCIENT_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ANCIENT_PLANKS.getId().getPath() + "_stripped_peeking_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_PEEKING_ANCIENT_WOOD.get())
                .unlockedBy("has_stripped_peeking_ancient_wood", has(EMBlocks.STRIPPED_PEEKING_ANCIENT_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ANCIENT_PLANKS.getId().getPath() + "_stripped_peeking_wood"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.PEEKING_ANCIENT_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.PEEKING_ANCIENT_LOG.get())
                .unlockedBy("has_peeking_ancient_log", has(EMBlocks.PEEKING_ANCIENT_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.STRIPPED_PEEKING_ANCIENT_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.STRIPPED_PEEKING_ANCIENT_LOG.get())
                .unlockedBy("has_peeking_ancient_wood", has(EMBlocks.STRIPPED_PEEKING_ANCIENT_LOG)).save(output);

        // Slimy Wood
        stairBuilder(EMBlocks.SLIMY_STAIRS.get(), Ingredient.of(EMBlocks.SLIMY_PLANKS)).group("stairs")
                .unlockedBy("has_slimy_planks", has(EMBlocks.SLIMY_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SLIMY_SLAB.get(), EMBlocks.SLIMY_PLANKS.get());
        buttonBuilder(EMBlocks.SLIMY_BUTTON.get(), Ingredient.of(EMBlocks.SLIMY_PLANKS)).group("buttons")
                .unlockedBy("has_slimy_planks", has(EMBlocks.SLIMY_PLANKS)).save(output);
        pressurePlate(output, EMBlocks.SLIMY_PRESSURE_PLATE.get(), EMBlocks.SLIMY_PLANKS.get());
        fenceBuilder(EMBlocks.SLIMY_FENCE.get(), Ingredient.of(EMBlocks.SLIMY_PLANKS)).group("fences")
                .unlockedBy("has_slimy_planks", has(EMBlocks.SLIMY_PLANKS)).save(output);
        fenceGateBuilder(EMBlocks.SLIMY_FENCE_GATE.get(), Ingredient.of(EMBlocks.SLIMY_PLANKS)).group("fence_gates")
                .unlockedBy("has_slimy_planks", has(EMBlocks.SLIMY_PLANKS)).save(output);
        doorBuilder(EMBlocks.SLIMY_DOOR.get(), Ingredient.of(EMBlocks.SLIMY_PLANKS)).group("doors")
                .unlockedBy("has_slimy_planks", has(EMBlocks.SLIMY_PLANKS)).save(output);
        trapdoorBuilder(EMBlocks.SLIMY_TRAPDOOR.get(), Ingredient.of(EMBlocks.SLIMY_PLANKS)).group("trapdoors")
                .unlockedBy("has_slimy_planks", has(EMBlocks.SLIMY_PLANKS)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SLIMY_PLANKS.get(), 4)
                .requires(EMBlocks.SLIMY_LOG.get())
                .unlockedBy("has_slimy_log", has(EMBlocks.SLIMY_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SLIMY_PLANKS.getId().getPath() + "_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SLIMY_PLANKS.get(), 4)
                .requires(EMBlocks.SLIMY_WOOD.get())
                .unlockedBy("has_slimy_wood", has(EMBlocks.SLIMY_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SLIMY_PLANKS.getId().getPath() + "_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SLIMY_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_SLIMY_LOG.get())
                .unlockedBy("has_stripped_slimy_log", has(EMBlocks.STRIPPED_SLIMY_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SLIMY_PLANKS.getId().getPath() + "_stripped_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SLIMY_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_SLIMY_WOOD.get())
                .unlockedBy("has_stripped_slimy_wood", has(EMBlocks.STRIPPED_SLIMY_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SLIMY_PLANKS.getId().getPath() + "_stripped_wood"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SLIMY_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.SLIMY_LOG.get())
                .unlockedBy("has_slimy_log", has(EMBlocks.SLIMY_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.STRIPPED_SLIMY_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.STRIPPED_SLIMY_LOG.get())
                .unlockedBy("has_slimy_wood", has(EMBlocks.STRIPPED_SLIMY_LOG)).save(output);

        // Sparkling Sand
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE.get())
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.SPARKLING_SAND.get())
                .unlockedBy("has_timeworn_sand", has(EMBlocks.SPARKLING_SAND)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_BRICKS.get(), 4)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.SPARKLING_SANDSTONE.get())
                .unlockedBy("has_timeworn_sandstone", has(EMBlocks.SPARKLING_SANDSTONE)).save(output);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_BRICKS.get(), EMBlocks.SPARKLING_SANDSTONE.get(), 1);

        stairBuilder(EMBlocks.SPARKLING_SANDSTONE_STAIRS.get(), Ingredient.of(EMBlocks.SPARKLING_SANDSTONE)).group("stairs")
                .unlockedBy("has_sparkling_sandstone", has(EMBlocks.SPARKLING_SANDSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_SLAB.get(), EMBlocks.SPARKLING_SANDSTONE.get());
        buttonBuilder(EMBlocks.SPARKLING_SANDSTONE_BUTTON.get(), Ingredient.of(EMBlocks.SPARKLING_SANDSTONE)).group("buttons")
                .unlockedBy("has_sparkling_sandstone", has(EMBlocks.SPARKLING_SANDSTONE)).save(output);
        pressurePlate(output, EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE.get(), EMBlocks.SPARKLING_SANDSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_WALL.get(), EMBlocks.SPARKLING_SANDSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_STAIRS.get(), EMBlocks.SPARKLING_SANDSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_SLAB.get(), EMBlocks.SPARKLING_SANDSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_WALL.get(), EMBlocks.SPARKLING_SANDSTONE.get(), 1);

        stairBuilder(EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS.get(), Ingredient.of(EMBlocks.SPARKLING_SANDSTONE_BRICKS)).group("stairs")
                .unlockedBy("has_sparkling_sandstone", has(EMBlocks.SPARKLING_SANDSTONE_BRICKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB.get(), EMBlocks.SPARKLING_SANDSTONE_BRICKS.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL.get(), EMBlocks.SPARKLING_SANDSTONE_BRICKS.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS.get(), EMBlocks.SPARKLING_SANDSTONE_BRICKS.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB.get(), EMBlocks.SPARKLING_SANDSTONE_BRICKS.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL.get(), EMBlocks.SPARKLING_SANDSTONE_BRICKS.get(), 1);

        // Timeworn Sand
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.TIMEWORN_SANDSTONE.get())
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.TIMEWORN_SAND.get())
                .unlockedBy("has_timeworn_sand", has(EMBlocks.TIMEWORN_SAND)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get(), 4)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.TIMEWORN_SANDSTONE.get())
                .unlockedBy("has_timeworn_sandstone", has(EMBlocks.TIMEWORN_SANDSTONE)).save(output);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get(), EMBlocks.TIMEWORN_SANDSTONE.get(), 1);

        stairBuilder(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS.get(), Ingredient.of(EMBlocks.POLISHED_TIMEWORN_SANDSTONE)).group("stairs")
                .unlockedBy("has_polished_timeworn_sandstone", has(EMBlocks.POLISHED_TIMEWORN_SANDSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get());
        buttonBuilder(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON.get(), Ingredient.of(EMBlocks.POLISHED_TIMEWORN_SANDSTONE)).group("buttons")
                .unlockedBy("has_polished_timeworn_sandstone", has(EMBlocks.POLISHED_TIMEWORN_SANDSTONE)).save(output);
        pressurePlate(output, EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get(), 1);

        stairBuilder(EMBlocks.TIMEWORN_SANDSTONE_STAIRS.get(), Ingredient.of(EMBlocks.TIMEWORN_SANDSTONE)).group("stairs")
                .unlockedBy("has_timeworn_sandstone", has(EMBlocks.TIMEWORN_SANDSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.TIMEWORN_SANDSTONE_SLAB.get(), EMBlocks.TIMEWORN_SANDSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.TIMEWORN_SANDSTONE_WALL.get(), EMBlocks.TIMEWORN_SANDSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.TIMEWORN_SANDSTONE_STAIRS.get(), EMBlocks.TIMEWORN_SANDSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.TIMEWORN_SANDSTONE_SLAB.get(), EMBlocks.TIMEWORN_SANDSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.TIMEWORN_SANDSTONE_WALL.get(), EMBlocks.TIMEWORN_SANDSTONE.get(), 1);
        
        // Cubed Abyssal Mushroom
        stairBuilder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS.get(), Ingredient.of(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).group("stairs")
                .unlockedBy("has_cubed_abyssal_mushroom", has(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get(), EMBlocks.CUBED_ABYSSAL_MUSHROOM.get());
        buttonBuilder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get(), Ingredient.of(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).group("buttons")
                .unlockedBy("has_cubed_abyssal_mushroom", has(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).save(output);
        pressurePlate(output, EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get(), EMBlocks.CUBED_ABYSSAL_MUSHROOM.get());
        fenceBuilder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get(), Ingredient.of(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).group("fences")
                .unlockedBy("has_cubed_abyssal_mushroom", has(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).save(output);
        fenceGateBuilder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get(), Ingredient.of(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).group("fence_gates")
                .unlockedBy("has_cubed_abyssal_mushroom", has(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).save(output);
        doorBuilder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get(), Ingredient.of(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).group("doors")
                .unlockedBy("has_cubed_abyssal_mushroom", has(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).save(output);
        trapdoorBuilder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR.get(), Ingredient.of(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).group("trapdoors")
                .unlockedBy("has_cubed_abyssal_mushroom", has(EMBlocks.CUBED_ABYSSAL_MUSHROOM)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), 4)
                .requires(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM.get())
                .unlockedBy("has_blue_abyssal_mushroom_stem", has(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CUBED_ABYSSAL_MUSHROOM.getId().getPath() + "_blue"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), 4)
                .requires(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM.get())
                .unlockedBy("has_orange_abyssal_mushroom_stem", has(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CUBED_ABYSSAL_MUSHROOM.getId().getPath() + "_orange"));

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Ethermist.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void stonecutting(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, int resultCount) {
        SingleItemRecipeBuilder builder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(new ItemLike[]{material}), category, result, resultCount).unlockedBy(getHasName(material), has(material));
        String id = getConversionRecipeName(result, material);
        builder.save(recipeOutput, Ethermist.MODID + ":" + id + "_stonecutting");
    }

}
