package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class EMRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public EMRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        //Etherstone
        stairBuilder(EMBlocks.ETHERSTONE_STAIRS.get(), Ingredient.of(EMBlocks.ETHERSTONE))
                .unlockedBy("has_etherstone", has(EMBlocks.ETHERSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_SLAB.get(), EMBlocks.ETHERSTONE.get());
        buttonBuilder(EMBlocks.ETHERSTONE_BUTTON.get(), Ingredient.of(EMBlocks.ETHERSTONE))
                .unlockedBy("has_etherstone", has(EMBlocks.ETHERSTONE)).save(output);
        pressurePlate(output, EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), EMBlocks.ETHERSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_WALL.get(), EMBlocks.ETHERSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_STAIRS.get(), EMBlocks.ETHERSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_SLAB.get(), EMBlocks.ETHERSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE_WALL.get(), EMBlocks.ETHERSTONE.get(), 1);

        // Etherstone Bricks
        stairBuilder(EMBlocks.ETHERSTONE_BRICK_STAIRS.get(), Ingredient.of(EMBlocks.ETHERSTONE_BRICKS))
                .unlockedBy("has_etherstone_bricks", has(EMBlocks.ETHERSTONE_BRICKS)).save(output);
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
                .unlockedBy("has_etherstone", has(EMBlocks.ETHERSTONE)).save(output);

        // Ancient Etherstone
        stairBuilder(EMBlocks.ANCIENT_ETHERSTONE_STAIRS.get(), Ingredient.of(EMBlocks.ANCIENT_ETHERSTONE))
                .unlockedBy("has_ancient_etherstone", has(EMBlocks.ANCIENT_ETHERSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_SLAB.get(), EMBlocks.ANCIENT_ETHERSTONE.get());
        buttonBuilder(EMBlocks.ANCIENT_ETHERSTONE_BUTTON.get(), Ingredient.of(EMBlocks.ANCIENT_ETHERSTONE))
                .unlockedBy("has_ancient_etherstone", has(EMBlocks.ANCIENT_ETHERSTONE)).save(output);
        pressurePlate(output, EMBlocks.ANCIENT_ETHERSTONE_PRESSURE_PLATE.get(), EMBlocks.ANCIENT_ETHERSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_WALL.get(), EMBlocks.ANCIENT_ETHERSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_STAIRS.get(), EMBlocks.ANCIENT_ETHERSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_SLAB.get(), EMBlocks.ANCIENT_ETHERSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_WALL.get(), EMBlocks.ANCIENT_ETHERSTONE.get(), 1);

        // Ancient Etherstone Bricks
        stairBuilder(EMBlocks.ANCIENT_ETHERSTONE_BRICK_STAIRS.get(), Ingredient.of(EMBlocks.ANCIENT_ETHERSTONE_BRICKS))
                .unlockedBy("has_ancient_etherstone_bricks", has(EMBlocks.ANCIENT_ETHERSTONE_BRICKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_BRICK_SLAB.get(), EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_BRICK_WALL.get(), EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_BRICK_STAIRS.get(), EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_BRICK_SLAB.get(), EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_BRICK_WALL.get(), EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get(), 1);

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get(), EMBlocks.ANCIENT_ETHERSTONE.get(), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get(), 4)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.ANCIENT_ETHERSTONE.get())
                .unlockedBy("has_ancient_etherstone", has(EMBlocks.ANCIENT_ETHERSTONE)).save(output);

        // Witchstone
        stairBuilder(EMBlocks.WITCHSTONE_STAIRS.get(), Ingredient.of(EMBlocks.WITCHSTONE))
                .unlockedBy("has_witchstone", has(EMBlocks.WITCHSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.WITCHSTONE_SLAB.get(), EMBlocks.WITCHSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.WITCHSTONE_WALL.get(), EMBlocks.WITCHSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.WITCHSTONE_STAIRS.get(), EMBlocks.WITCHSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.WITCHSTONE_SLAB.get(), EMBlocks.WITCHSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.WITCHSTONE_WALL.get(), EMBlocks.WITCHSTONE.get(), 1);

        // Polished Witchstone
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_WITCHSTONE.get(), 4)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.WITCHSTONE.get())
                .unlockedBy("has_witchstone", has(EMBlocks.WITCHSTONE)).save(output);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_WITCHSTONE.get(), EMBlocks.WITCHSTONE.get(), 1);

        stairBuilder(EMBlocks.POLISHED_WITCHSTONE_STAIRS.get(), Ingredient.of(EMBlocks.POLISHED_WITCHSTONE))
                .unlockedBy("has_polished_witchstone", has(EMBlocks.POLISHED_WITCHSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_WITCHSTONE_SLAB.get(), EMBlocks.POLISHED_WITCHSTONE.get());
        buttonBuilder(EMBlocks.POLISHED_WITCHSTONE_BUTTON.get(), Ingredient.of(EMBlocks.POLISHED_WITCHSTONE))
                .unlockedBy("has_polished_witchstone", has(EMBlocks.POLISHED_WITCHSTONE)).save(output);
        pressurePlate(output, EMBlocks.POLISHED_WITCHSTONE_PRESSURE_PLATE.get(), EMBlocks.POLISHED_WITCHSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_WITCHSTONE_WALL.get(), EMBlocks.POLISHED_WITCHSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_WITCHSTONE_STAIRS.get(), EMBlocks.POLISHED_WITCHSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_WITCHSTONE_SLAB.get(), EMBlocks.POLISHED_WITCHSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_WITCHSTONE_WALL.get(), EMBlocks.POLISHED_WITCHSTONE.get(), 1);

        // Dawnshale
        stairBuilder(EMBlocks.DAWNSHALE_STAIRS.get(), Ingredient.of(EMBlocks.DAWNSHALE))
                .unlockedBy("has_dawnshale", has(EMBlocks.DAWNSHALE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.DAWNSHALE_SLAB.get(), EMBlocks.DAWNSHALE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.DAWNSHALE_WALL.get(), EMBlocks.DAWNSHALE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.DAWNSHALE_STAIRS.get(), EMBlocks.DAWNSHALE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.DAWNSHALE_SLAB.get(), EMBlocks.DAWNSHALE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.DAWNSHALE_WALL.get(), EMBlocks.DAWNSHALE.get(), 1);

        // Polished Dawnshale
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_DAWNSHALE.get(), 4)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.DAWNSHALE.get())
                .unlockedBy("has_dawnshale", has(EMBlocks.DAWNSHALE)).save(output);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_DAWNSHALE.get(), EMBlocks.DAWNSHALE.get(), 1);

        stairBuilder(EMBlocks.POLISHED_DAWNSHALE_STAIRS.get(), Ingredient.of(EMBlocks.POLISHED_DAWNSHALE))
                .unlockedBy("has_polished_dawnshale", has(EMBlocks.POLISHED_DAWNSHALE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_DAWNSHALE_SLAB.get(), EMBlocks.POLISHED_DAWNSHALE.get());
        buttonBuilder(EMBlocks.POLISHED_DAWNSHALE_BUTTON.get(), Ingredient.of(EMBlocks.POLISHED_DAWNSHALE))
                .unlockedBy("has_polished_dawnshale", has(EMBlocks.POLISHED_DAWNSHALE)).save(output);
        pressurePlate(output, EMBlocks.POLISHED_DAWNSHALE_PRESSURE_PLATE.get(), EMBlocks.POLISHED_DAWNSHALE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_DAWNSHALE_WALL.get(), EMBlocks.POLISHED_DAWNSHALE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_DAWNSHALE_STAIRS.get(), EMBlocks.POLISHED_DAWNSHALE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_DAWNSHALE_SLAB.get(), EMBlocks.POLISHED_DAWNSHALE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.POLISHED_DAWNSHALE_WALL.get(), EMBlocks.POLISHED_DAWNSHALE.get(), 1);

        // Cobbled Etherstone
        stairBuilder(EMBlocks.COBBLED_ETHERSTONE_STAIRS.get(), Ingredient.of(EMBlocks.COBBLED_ETHERSTONE))
                .unlockedBy("has_cobbled_etherstone", has(EMBlocks.COBBLED_ETHERSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_SLAB.get(), EMBlocks.COBBLED_ETHERSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_WALL.get(), EMBlocks.COBBLED_ETHERSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_STAIRS.get(), EMBlocks.COBBLED_ETHERSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_SLAB.get(), EMBlocks.COBBLED_ETHERSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_WALL.get(), EMBlocks.COBBLED_ETHERSTONE.get(), 1);

        oreSmelting(output, List.of(EMBlocks.COBBLED_ETHERSTONE.get()),
                RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE.get(), 0.25f, 200, "stone");

        // Mossy Cobbled Etherstone
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.MOSSY_COBBLED_ETHERSTONE.get(), 1)
                .requires(EMBlocks.COBBLED_ETHERSTONE.get())
                .requires(Blocks.VINE)
                .unlockedBy("has_cobbled_etherstone", has(EMBlocks.COBBLED_ETHERSTONE))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.MOSSY_COBBLED_ETHERSTONE.getId().getPath() + "_vine"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.MOSSY_COBBLED_ETHERSTONE.get(), 1)
                .requires(EMBlocks.COBBLED_ETHERSTONE.get())
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_cobbled_etherstone", has(EMBlocks.COBBLED_ETHERSTONE))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.MOSSY_COBBLED_ETHERSTONE.getId().getPath() + "_moss_block"));

        stairBuilder(EMBlocks.MOSSY_COBBLED_ETHERSTONE_STAIRS.get(), Ingredient.of(EMBlocks.MOSSY_COBBLED_ETHERSTONE))
                .unlockedBy("has_mossy_cobbled_etherstone", has(EMBlocks.MOSSY_COBBLED_ETHERSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.MOSSY_COBBLED_ETHERSTONE_SLAB.get(), EMBlocks.MOSSY_COBBLED_ETHERSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.MOSSY_COBBLED_ETHERSTONE_WALL.get(), EMBlocks.MOSSY_COBBLED_ETHERSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.MOSSY_COBBLED_ETHERSTONE_STAIRS.get(), EMBlocks.MOSSY_COBBLED_ETHERSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.MOSSY_COBBLED_ETHERSTONE_SLAB.get(), EMBlocks.MOSSY_COBBLED_ETHERSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.MOSSY_COBBLED_ETHERSTONE_WALL.get(), EMBlocks.MOSSY_COBBLED_ETHERSTONE.get(), 1);

        // Glimmering Ancient Wood
        stairBuilder(EMBlocks.GLIMMERING_ANCIENT_STAIRS.get(), Ingredient.of(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).group("stairs")
                .unlockedBy("has_glimmering_ancient_planks", has(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_SLAB.get(), EMBlocks.GLIMMERING_ANCIENT_PLANKS.get());
        buttonBuilder(EMBlocks.GLIMMERING_ANCIENT_BUTTON.get(), Ingredient.of(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).group("slabs")
                .unlockedBy("has_glimmering_ancient_planks", has(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).save(output);
        pressurePlate(output, EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE.get(), EMBlocks.GLIMMERING_ANCIENT_PLANKS.get());
        fenceBuilder(EMBlocks.GLIMMERING_ANCIENT_FENCE.get(), Ingredient.of(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).group("fences")
                .unlockedBy("has_glimmering_ancient_planks", has(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).save(output);
        fenceGateBuilder(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE.get(), Ingredient.of(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).group("fence_gates")
                .unlockedBy("has_glimmering_ancient_planks", has(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).save(output);
        doorBuilder(EMBlocks.GLIMMERING_ANCIENT_DOOR.get(), Ingredient.of(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).group("doors")
                .unlockedBy("has_glimmering_ancient_planks", has(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).save(output);
        trapdoorBuilder(EMBlocks.GLIMMERING_ANCIENT_TRAPDOOR.get(), Ingredient.of(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).group("trapdoors")
                .unlockedBy("has_glimmering_ancient_planks", has(EMBlocks.GLIMMERING_ANCIENT_PLANKS)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_glimmering_ancient_log", has(EMBlocks.GLIMMERING_ANCIENT_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERING_ANCIENT_PLANKS.getId().getPath() + "_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.GLIMMERING_ANCIENT_WOOD.get())
                .unlockedBy("has_glimmering_ancient_wood", has(EMBlocks.GLIMMERING_ANCIENT_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERING_ANCIENT_PLANKS.getId().getPath() + "_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_stripped_glimmering_ancient_log", has(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERING_ANCIENT_PLANKS.getId().getPath() + "_stripped_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get())
                .unlockedBy("has_stripped_glimmering_ancient_wood", has(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERING_ANCIENT_PLANKS.getId().getPath() + "_stripped_wood"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_glimmering_ancient_log", has(EMBlocks.GLIMMERING_ANCIENT_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_glimmering_ancient_wood", has(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_suspicious_glimmering_ancient_log", has(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERING_ANCIENT_PLANKS.getId().getPath() + "_suspicious_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_suspicious_glimmering_ancient_wood", has(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERING_ANCIENT_PLANKS.getId().getPath() + "_suspicious_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_stripped_suspicious_glimmering_ancient_log", has(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERING_ANCIENT_PLANKS.getId().getPath() + "_stripped_suspicious_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get())
                .unlockedBy("has_stripped_suspicious_glimmering_ancient_wood", has(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERING_ANCIENT_PLANKS.getId().getPath() + "_stripped_suspicious_wood"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_suspicious_glimmering_ancient_log", has(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get())
                .unlockedBy("has_suspicious_glimmering_ancient_wood", has(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG)).save(output);

        // Ancient Wood
        stairBuilder(EMBlocks.ANCIENT_STAIRS.get(), Ingredient.of(EMBlocks.ANCIENT_PLANKS)).group("stairs")
                .unlockedBy("has_ancient_planks", has(EMBlocks.ANCIENT_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.ANCIENT_SLAB.get(), EMBlocks.ANCIENT_PLANKS.get());
        buttonBuilder(EMBlocks.ANCIENT_BUTTON.get(), Ingredient.of(EMBlocks.ANCIENT_PLANKS)).group("buttons")
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

        // Frostpine Wood
        stairBuilder(EMBlocks.FROSTPINE_STAIRS.get(), Ingredient.of(EMBlocks.FROSTPINE_PLANKS)).group("stairs")
                .unlockedBy("has_frostpine_planks", has(EMBlocks.FROSTPINE_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.FROSTPINE_SLAB.get(), EMBlocks.FROSTPINE_PLANKS.get());
        buttonBuilder(EMBlocks.FROSTPINE_BUTTON.get(), Ingredient.of(EMBlocks.FROSTPINE_PLANKS)).group("buttons")
                .unlockedBy("has_frostpine_planks", has(EMBlocks.FROSTPINE_PLANKS)).save(output);
        pressurePlate(output, EMBlocks.FROSTPINE_PRESSURE_PLATE.get(), EMBlocks.FROSTPINE_PLANKS.get());
        fenceBuilder(EMBlocks.FROSTPINE_FENCE.get(), Ingredient.of(EMBlocks.FROSTPINE_PLANKS)).group("fences")
                .unlockedBy("has_frostpine_planks", has(EMBlocks.FROSTPINE_PLANKS)).save(output);
        fenceGateBuilder(EMBlocks.FROSTPINE_FENCE_GATE.get(), Ingredient.of(EMBlocks.FROSTPINE_PLANKS)).group("fence_gates")
                .unlockedBy("has_frostpine_planks", has(EMBlocks.FROSTPINE_PLANKS)).save(output);
        doorBuilder(EMBlocks.FROSTPINE_DOOR.get(), Ingredient.of(EMBlocks.FROSTPINE_PLANKS)).group("doors")
                .unlockedBy("has_frostpine_planks", has(EMBlocks.FROSTPINE_PLANKS)).save(output);
        trapdoorBuilder(EMBlocks.FROSTPINE_TRAPDOOR.get(), Ingredient.of(EMBlocks.FROSTPINE_PLANKS)).group("trapdoors")
                .unlockedBy("has_frostpine_planks", has(EMBlocks.FROSTPINE_PLANKS)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.FROSTPINE_PLANKS.get(), 4)
                .requires(EMBlocks.FROSTPINE_LOG.get())
                .unlockedBy("has_frostpine_log", has(EMBlocks.FROSTPINE_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.FROSTPINE_PLANKS.getId().getPath() + "_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.FROSTPINE_PLANKS.get(), 4)
                .requires(EMBlocks.FROSTPINE_WOOD.get())
                .unlockedBy("has_frostpine_wood", has(EMBlocks.FROSTPINE_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.FROSTPINE_PLANKS.getId().getPath() + "_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.FROSTPINE_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_FROSTPINE_LOG.get())
                .unlockedBy("has_stripped_frostpine_log", has(EMBlocks.STRIPPED_FROSTPINE_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.FROSTPINE_PLANKS.getId().getPath() + "_stripped_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.FROSTPINE_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_FROSTPINE_WOOD.get())
                .unlockedBy("has_stripped_frostpine_wood", has(EMBlocks.STRIPPED_FROSTPINE_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.FROSTPINE_PLANKS.getId().getPath() + "_stripped_wood"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.FROSTPINE_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.FROSTPINE_LOG.get())
                .unlockedBy("has_frostpine_log", has(EMBlocks.FROSTPINE_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.STRIPPED_FROSTPINE_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.STRIPPED_FROSTPINE_LOG.get())
                .unlockedBy("has_frostpine_wood", has(EMBlocks.STRIPPED_FROSTPINE_LOG)).save(output);

        // Amberwood Wood
        stairBuilder(EMBlocks.AMBERWOOD_STAIRS.get(), Ingredient.of(EMBlocks.AMBERWOOD_PLANKS)).group("stairs")
                .unlockedBy("has_amberwood_planks", has(EMBlocks.AMBERWOOD_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.AMBERWOOD_SLAB.get(), EMBlocks.AMBERWOOD_PLANKS.get());
        buttonBuilder(EMBlocks.AMBERWOOD_BUTTON.get(), Ingredient.of(EMBlocks.AMBERWOOD_PLANKS)).group("buttons")
                .unlockedBy("has_amberwood_planks", has(EMBlocks.AMBERWOOD_PLANKS)).save(output);
        pressurePlate(output, EMBlocks.AMBERWOOD_PRESSURE_PLATE.get(), EMBlocks.AMBERWOOD_PLANKS.get());
        fenceBuilder(EMBlocks.AMBERWOOD_FENCE.get(), Ingredient.of(EMBlocks.AMBERWOOD_PLANKS)).group("fences")
                .unlockedBy("has_amberwood_planks", has(EMBlocks.AMBERWOOD_PLANKS)).save(output);
        fenceGateBuilder(EMBlocks.AMBERWOOD_FENCE_GATE.get(), Ingredient.of(EMBlocks.AMBERWOOD_PLANKS)).group("fence_gates")
                .unlockedBy("has_amberwood_planks", has(EMBlocks.AMBERWOOD_PLANKS)).save(output);
        doorBuilder(EMBlocks.AMBERWOOD_DOOR.get(), Ingredient.of(EMBlocks.AMBERWOOD_PLANKS)).group("doors")
                .unlockedBy("has_amberwood_planks", has(EMBlocks.AMBERWOOD_PLANKS)).save(output);
        trapdoorBuilder(EMBlocks.AMBERWOOD_TRAPDOOR.get(), Ingredient.of(EMBlocks.AMBERWOOD_PLANKS)).group("trapdoors")
                .unlockedBy("has_amberwood_planks", has(EMBlocks.AMBERWOOD_PLANKS)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.AMBERWOOD_PLANKS.get(), 4)
                .requires(EMBlocks.AMBERWOOD_LOG.get())
                .unlockedBy("has_amberwood_log", has(EMBlocks.AMBERWOOD_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.AMBERWOOD_PLANKS.getId().getPath() + "_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.AMBERWOOD_PLANKS.get(), 4)
                .requires(EMBlocks.AMBERWOOD_WOOD.get())
                .unlockedBy("has_amberwood_wood", has(EMBlocks.AMBERWOOD_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.AMBERWOOD_PLANKS.getId().getPath() + "_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.AMBERWOOD_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_AMBERWOOD_LOG.get())
                .unlockedBy("has_stripped_amberwood_log", has(EMBlocks.STRIPPED_AMBERWOOD_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.AMBERWOOD_PLANKS.getId().getPath() + "_stripped_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.AMBERWOOD_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_AMBERWOOD_WOOD.get())
                .unlockedBy("has_stripped_amberwood_wood", has(EMBlocks.STRIPPED_AMBERWOOD_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.AMBERWOOD_PLANKS.getId().getPath() + "_stripped_wood"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.AMBERWOOD_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.AMBERWOOD_LOG.get())
                .unlockedBy("has_amberwood_log", has(EMBlocks.AMBERWOOD_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.STRIPPED_AMBERWOOD_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.STRIPPED_AMBERWOOD_LOG.get())
                .unlockedBy("has_amberwood_wood", has(EMBlocks.STRIPPED_AMBERWOOD_LOG)).save(output);

        // Charred Wood
        stairBuilder(EMBlocks.CHARRED_STAIRS.get(), Ingredient.of(EMBlocks.CHARRED_PLANKS)).group("stairs")
                .unlockedBy("has_charred_planks", has(EMBlocks.CHARRED_PLANKS)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.CHARRED_SLAB.get(), EMBlocks.CHARRED_PLANKS.get());
        buttonBuilder(EMBlocks.CHARRED_BUTTON.get(), Ingredient.of(EMBlocks.CHARRED_PLANKS)).group("buttons")
                .unlockedBy("has_charred_planks", has(EMBlocks.CHARRED_PLANKS)).save(output);
        pressurePlate(output, EMBlocks.CHARRED_PRESSURE_PLATE.get(), EMBlocks.CHARRED_PLANKS.get());
        fenceBuilder(EMBlocks.CHARRED_FENCE.get(), Ingredient.of(EMBlocks.CHARRED_PLANKS)).group("fences")
                .unlockedBy("has_charred_planks", has(EMBlocks.CHARRED_PLANKS)).save(output);
        fenceGateBuilder(EMBlocks.CHARRED_FENCE_GATE.get(), Ingredient.of(EMBlocks.CHARRED_PLANKS)).group("fence_gates")
                .unlockedBy("has_charred_planks", has(EMBlocks.CHARRED_PLANKS)).save(output);
        doorBuilder(EMBlocks.CHARRED_DOOR.get(), Ingredient.of(EMBlocks.CHARRED_PLANKS)).group("doors")
                .unlockedBy("has_charred_planks", has(EMBlocks.CHARRED_PLANKS)).save(output);
        trapdoorBuilder(EMBlocks.CHARRED_TRAPDOOR.get(), Ingredient.of(EMBlocks.CHARRED_PLANKS)).group("trapdoors")
                .unlockedBy("has_charred_planks", has(EMBlocks.CHARRED_PLANKS)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CHARRED_PLANKS.get(), 4)
                .requires(EMBlocks.CHARRED_LOG.get())
                .unlockedBy("has_charred_log", has(EMBlocks.CHARRED_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CHARRED_PLANKS.getId().getPath() + "_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CHARRED_PLANKS.get(), 4)
                .requires(EMBlocks.CHARRED_WOOD.get())
                .unlockedBy("has_charred_wood", has(EMBlocks.CHARRED_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CHARRED_PLANKS.getId().getPath() + "_wood"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CHARRED_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_CHARRED_LOG.get())
                .unlockedBy("has_stripped_charred_log", has(EMBlocks.STRIPPED_CHARRED_LOG))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CHARRED_PLANKS.getId().getPath() + "_stripped_log"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CHARRED_PLANKS.get(), 4)
                .requires(EMBlocks.STRIPPED_CHARRED_WOOD.get())
                .unlockedBy("has_stripped_charred_wood", has(EMBlocks.STRIPPED_CHARRED_WOOD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CHARRED_PLANKS.getId().getPath() + "_stripped_wood"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CHARRED_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.CHARRED_LOG.get())
                .unlockedBy("has_charred_log", has(EMBlocks.CHARRED_LOG)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.STRIPPED_CHARRED_WOOD.get(), 3)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.STRIPPED_CHARRED_LOG.get())
                .unlockedBy("has_charred_wood", has(EMBlocks.STRIPPED_CHARRED_LOG)).save(output);

        // Sparkling Sand
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE.get())
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.SPARKLING_SAND.get())
                .unlockedBy("has_sparkling_sand", has(EMBlocks.SPARKLING_SAND)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.SPARKLING_SANDSTONE_BRICKS.get(), 4)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.SPARKLING_SANDSTONE.get())
                .unlockedBy("has_sparkling_sandstone", has(EMBlocks.SPARKLING_SANDSTONE)).save(output);
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

        /*
        ---------- Timeworn Sand ----------
         */
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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CHISELED_TIMEWORN_SANDSTONE.get())
                .pattern("a")
                .pattern("a")
                .define('a', EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get())
                .unlockedBy("has_polished_timeworn_sandstone_slab", has(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB)).save(output);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.CHISELED_TIMEWORN_SANDSTONE.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get(), 1);

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

        /*
        ---------- Cubed Abyssal Mushroom ----------
         */
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
                .requires(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get())
                .unlockedBy("has_large_abyssal_mushroom_stem", has(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CUBED_ABYSSAL_MUSHROOM.getId().getPath()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMBlocks.SMALL_ABYSSAL_MUSHROOM.get(), 9)
                .requires(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP.get())
                .unlockedBy("has_large_orange_abyssal_mushroom_top", has(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SMALL_ABYSSAL_MUSHROOM.getId().getPath() + "_orange"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMBlocks.SMALL_ABYSSAL_MUSHROOM.get(), 9)
                .requires(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP.get())
                .unlockedBy("has_large_blue_abyssal_mushroom_top", has(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SMALL_ABYSSAL_MUSHROOM.getId().getPath() + "_blue"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMBlocks.SMALL_ABYSSAL_MUSHROOM.get(), 6)
                .requires(EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS.get())
                .unlockedBy("has_large_abyssal_mushroom_gills", has(EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SMALL_ABYSSAL_MUSHROOM.getId().getPath() + "_gills"));

        /*
        ---------- Flowers to Dyes ----------
         */
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.YELLOW_DYE, 1)
                .requires(EMBlocks.GLIMMERBUD.get())
                .unlockedBy("has_glimmerbud", has(EMBlocks.GLIMMERBUD))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.GLIMMERBUD.getId().getPath() + "_yellow_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.LIGHT_BLUE_DYE, 1)
                .requires(EMBlocks.NIGHTBELL.get())
                .unlockedBy("has_nightbell", has(EMBlocks.NIGHTBELL))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.NIGHTBELL.getId().getPath() + "_light_blue_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.LIME_DYE, 1)
                .requires(EMBlocks.SLIMY_ALLIUM.get())
                .unlockedBy("has_slimy_allium", has(EMBlocks.SLIMY_ALLIUM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SLIMY_ALLIUM.getId().getPath() + "_lime_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.PURPLE_DYE, 1)
                .requires(EMBlocks.WITCH_LAVENDER.get())
                .unlockedBy("has_witch_lavender", has(EMBlocks.WITCH_LAVENDER))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.WITCH_LAVENDER.getId().getPath() + "_purple_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.PINK_DYE, 1)
                .requires(EMBlocks.DAWNING_HYACINTH.get())
                .unlockedBy("has_dawning_hyacinth", has(EMBlocks.DAWNING_HYACINTH))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.DAWNING_HYACINTH.getId().getPath() + "_pink_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.ORANGE_DYE, 1)
                .requires(EMBlocks.CINDERBLOOM.get())
                .unlockedBy("has_cinderbloom", has(EMBlocks.CINDERBLOOM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CINDERBLOOM.getId().getPath() + "_orange_dye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.BLUE_DYE, 1)
                .requires(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get())
                .unlockedBy("has_small_abyssal_mushroom", has(EMBlocks.SMALL_ABYSSAL_MUSHROOM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SMALL_ABYSSAL_MUSHROOM.getId().getPath() + "_blue_dye"));

        /*
        ---------- Misc Recipes ----------
         */
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SLIME_BALL, 1)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.SLIMY_ALLIUM.get())
                .unlockedBy("has_slimy_allium", has(EMBlocks.SLIMY_ALLIUM)).save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHARCOAL, 1)
                .requires(EMBlocks.CHARRED_SAPLING.get())
                .unlockedBy("has_charred_sapling", has(EMBlocks.CHARRED_SAPLING))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CHARRED_SAPLING.getId().getPath() + "_charcoal"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMBlocks.CHARRED_SAPLING, 1)
                .requires(ItemTags.SAPLINGS)
                .requires(Items.FLINT_AND_STEEL)
                .unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
                .unlockedBy("has_flint_and_steel", has(Items.FLINT_AND_STEEL))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CHARRED_SAPLING.getId().getPath() + "_crafting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.MOLTEN_ETHERSTONE.get(), 1)
                .pattern("ab")
                .pattern("ba")
                .define('a', EMBlocks.ETHERSTONE.get())
                .define('b', Items.MAGMA_CREAM)
                .unlockedBy("has_etherstone", has(EMBlocks.ETHERSTONE))
                .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMBlocks.SMALL_ABYSSAL_MUSHROOM, 6)
                .requires(EMBlocks.TALL_ABYSSAL_MUSHROOM.get())
                .unlockedBy("has_tall_abyssal_mushroom", has(EMBlocks.TALL_ABYSSAL_MUSHROOM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.TALL_ABYSSAL_MUSHROOM.getId().getPath() + "_to_small"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMBlocks.SMALL_ABYSSAL_MUSHROOM, 3)
                .requires(EMBlocks.ABYSSAL_MUSHROOM.get())
                .unlockedBy("has_abyssal_mushroom", has(EMBlocks.ABYSSAL_MUSHROOM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.ABYSSAL_MUSHROOM.getId().getPath() + "_to_small"));

        /*
        ---------- Ores ----------
         */
        oreSmelting(output, List.of(EMBlocks.ETHERSTONE_COPPER_ORE.get()),
                RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper_ingot");
        oreBlasting(output, List.of(EMBlocks.ETHERSTONE_COPPER_ORE.get()),
                RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "copper_ingot");

        oreSmelting(output, List.of(EMBlocks.ETHERSTONE_IRON_ORE.get()),
                RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        oreBlasting(output, List.of(EMBlocks.ETHERSTONE_IRON_ORE.get()),
                RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");

        oreSmelting(output, List.of(EMBlocks.ETHERSTONE_COAL_ORE.get()),
                RecipeCategory.MISC, Items.COAL, 0.7f, 200, "coal");
        oreBlasting(output, List.of(EMBlocks.ETHERSTONE_COAL_ORE.get()),
                RecipeCategory.MISC, Items.COAL, 0.7f, 100, "coal");

        oreSmelting(output, List.of(EMBlocks.ETHERSTONE_GOLD_ORE.get()),
                RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 200, "gold_ingot");
        oreBlasting(output, List.of(EMBlocks.ETHERSTONE_GOLD_ORE.get()),
                RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 100, "gold_ingot");

        oreSmelting(output, List.of(EMBlocks.ETHERSTONE_REDSTONE_ORE.get()),
                RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "redstone");
        oreBlasting(output, List.of(EMBlocks.ETHERSTONE_REDSTONE_ORE.get()),
                RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "redstone");

        oreSmelting(output, List.of(EMBlocks.ETHERSTONE_DIAMOND_ORE.get()),
                RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "diamond");
        oreBlasting(output, List.of(EMBlocks.ETHERSTONE_DIAMOND_ORE.get()),
                RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "diamond");

        oreSmelting(output, List.of(EMBlocks.ETHERSTONE_EMERALD_ORE.get()),
                RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "emerald");
        oreBlasting(output, List.of(EMBlocks.ETHERSTONE_EMERALD_ORE.get()),
                RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "emerald");

        oreSmelting(output, List.of(EMBlocks.ETHERSTONE_LAPIS_ORE.get()),
                RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.7f, 200, "lapis_lazuli");
        oreBlasting(output, List.of(EMBlocks.ETHERSTONE_LAPIS_ORE.get()),
                RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.7f, 100, "lapis_lazuli");


        oreSmelting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get()),
                RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper_ingot");
        oreBlasting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get()),
                RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "copper_ingot");

        oreSmelting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get()),
                RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        oreBlasting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get()),
                RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");

        oreSmelting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_COAL_ORE.get()),
                RecipeCategory.MISC, Items.COAL, 0.7f, 200, "coal");
        oreBlasting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_COAL_ORE.get()),
                RecipeCategory.MISC, Items.COAL, 0.7f, 100, "coal");

        oreSmelting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get()),
                RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 200, "gold_ingot");
        oreBlasting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get()),
                RecipeCategory.MISC, Items.GOLD_INGOT, 1.0f, 100, "gold_ingot");

        oreSmelting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get()),
                RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "redstone");
        oreBlasting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get()),
                RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "redstone");

        oreSmelting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get()),
                RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "diamond");
        oreBlasting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get()),
                RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "diamond");

        oreSmelting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get()),
                RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "emerald");
        oreBlasting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get()),
                RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "emerald");

        oreSmelting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get()),
                RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.7f, 200, "lapis_lazuli");
        oreBlasting(output, List.of(EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get()),
                RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.7f, 100, "lapis_lazuli");

        /*
        ---------- Tomes ----------
         */
        addTomeRecipe(EMItems.EXCLUSION_TOME.get(), Items.SPYGLASS, output);
        addTomeRecipe(EMItems.AUGMENT_TOME.get(), Items.REDSTONE, output);
        addTomeRecipe(EMItems.MAIN_SPELL_TOME.get(), Items.DIAMOND, output);
        addTomeRecipe(EMItems.BASE_SPELL_TOME.get(), Items.AMETHYST_SHARD, output);
        addTomeRecipe(EMItems.WAND_TOME.get(), EMTags.Items.ORBS, output);

        /*
        ---------- Orbs ----------
         */
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMItems.WITCH_ORB, 1)
                .pattern(" b ")
                .pattern("bab")
                .pattern(" b ")
                .define('a', EMTags.Items.ORBS)
                .define('b', EMBlocks.WITCHSTONE.get())
                .unlockedBy("has_orb", has(EMTags.Items.ORBS))
                .unlockedBy("has_witchstone", has(EMBlocks.WITCHSTONE.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMItems.FROZEN_ORB, 1)
                .pattern(" b ")
                .pattern("bab")
                .pattern(" b ")
                .define('a', EMTags.Items.ORBS)
                .define('b', EMBlocks.ICICLE.get())
                .unlockedBy("has_orb", has(EMTags.Items.ORBS))
                .unlockedBy("has_icicle", has(EMBlocks.ICICLE.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMItems.GLASS_ORB, 1)
                .pattern(" b ")
                .pattern("bab")
                .pattern(" b ")
                .define('a', EMTags.Items.ORBS)
                .define('b', Blocks.GLASS)
                .unlockedBy("has_orb", has(EMTags.Items.ORBS))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .save(output);

        /*
        ---------- Wand Handles ----------
         */
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMItems.WOODEN_WAND_HANDLE.get(), 1)
                .pattern(" bc")
                .pattern("bcb")
                .pattern("cb ")
                .define('b', Items.STICK)
                .define('c', ItemTags.PLANKS)
                .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD))
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(output);

        addHandleRecipe(EMItems.EMERALD_WAND_HANDLE.get(), Tags.Items.GEMS_EMERALD, output);
        addHandleRecipe(EMItems.DIAMOND_WAND_HANDLE.get(), Tags.Items.GEMS_DIAMOND, output);
        addHandleRecipe(EMItems.GOLDEN_WAND_HANDLE.get(), Tags.Items.INGOTS_GOLD, output);
        addHandleRecipe(EMItems.LAPIS_WAND_HANDLE.get(), Tags.Items.GEMS_LAPIS, output);
        addHandleRecipe(EMItems.QUARTZ_WAND_HANDLE.get(), Tags.Items.GEMS_QUARTZ, output);
        addHandleRecipe(EMItems.REDSTONE_WAND_HANDLE.get(), Tags.Items.DUSTS_REDSTONE, output);
        addHandleRecipe(EMItems.GLOWSTONE_WAND_HANDLE.get(), Tags.Items.DUSTS_GLOWSTONE, output);
        addHandleRecipe(EMItems.PRISMARINE_WAND_HANDLE.get(), Tags.Items.GEMS_PRISMARINE, output);
        addHandleRecipe(EMItems.NETHERITE_WAND_HANDLE.get(), Tags.Items.INGOTS_NETHERITE, output);

        /*
        ---------- Misc ----------
         */
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EMBlocks.WANDFORGING_TABLE, 1)
                .pattern("aa")
                .pattern("bb")
                .pattern("bb")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', ItemTags.PLANKS)
                .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD))
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(output);

        /*
        ---------- Wands ----------
         */

        generateWandRecipes(output);

        SpecialRecipeBuilder.special(WandDyeRecipe::new).save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_dye"));

        /*
        ---------- Foods ----------
         */
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMItems.SHROOM_CLUSTER.get(), 1)
                .pattern("aa")
                .pattern("aa")
                .define('a', EMBlocks.SMALL_ABYSSAL_MUSHROOM.get())
                .unlockedBy("has_small_abyssal_mushroom", has(EMBlocks.SMALL_ABYSSAL_MUSHROOM)).save(output);

        oreSmelting(output, List.of(EMItems.SHROOM_CLUSTER.get()),
                RecipeCategory.MISC, EMItems.TOASTED_SHROOM_CLUSTER.get(), 0.35f, 200, "shroom_cluster");
        oreSmoking(output, List.of(EMItems.SHROOM_CLUSTER.get()),
                RecipeCategory.MISC, EMItems.TOASTED_SHROOM_CLUSTER.get(), 0.35f, 100, "shroom_cluster");

    }

    protected static void generateWandRecipes(RecipeOutput output) {
        for (Map.Entry<Supplier<? extends Item>, Map<String, EMWandMappings.WandMapping>> orbEntry : EMWandMappings.WAND_MAPS.entrySet()) {
            Supplier<? extends Item> orbSupplier = orbEntry.getKey();
            Item orbItem = orbSupplier.get();
            Map<String, EMWandMappings.WandMapping> tierMap = orbEntry.getValue();

            for (Map.Entry<String, EMWandMappings.WandMapping> tierEntry : tierMap.entrySet()) {
                String tier = tierEntry.getKey();
                EMWandMappings.WandMapping mapping = tierEntry.getValue();
                Item handleItem = mapping.handle().get();
                Item wandItem = mapping.wand().get();

                // Handle and Orb
                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.EMPTY,
                                Ingredient.of(handleItem),
                                Ingredient.of(orbItem),
                                RecipeCategory.COMBAT,
                                wandItem
                        )
                        .unlocks("has_" + getItemName(orbItem), has(orbItem))
                        .save(output, ResourceLocation.fromNamespaceAndPath(
                                Ethermist.MODID,
                                getItemName(wandItem) + "_from_" + getItemName(handleItem) + "_and_" + getItemName(orbItem)
                        ));

                // Wand and Orb
                for (Map.Entry<Supplier<? extends Item>, Map<String, EMWandMappings.WandMapping>> otherOrbEntry : EMWandMappings.WAND_MAPS.entrySet()) {
                    Supplier<? extends Item> otherOrbSupplier = otherOrbEntry.getKey();
                    Item otherOrbItem = otherOrbSupplier.get();
                    if (otherOrbItem == orbItem) continue;

                    EMWandMappings.WandMapping otherMapping = otherOrbEntry.getValue().get(tier);
                    if (otherMapping != null) {
                        Item otherWandItem = otherMapping.wand().get();

                        SmithingTransformRecipeBuilder.smithing(
                                        Ingredient.EMPTY,
                                        Ingredient.of(wandItem),
                                        Ingredient.of(otherOrbItem),
                                        RecipeCategory.COMBAT,
                                        otherWandItem
                                )
                                .unlocks("has_" + getItemName(otherOrbItem), has(otherOrbItem))
                                .save(output, ResourceLocation.fromNamespaceAndPath(
                                        Ethermist.MODID,
                                        getItemName(otherWandItem) + "_from_" + getItemName(wandItem) + "_and_" + getItemName(otherOrbItem)
                                ));
                    }
                }

                // Wand and Handle
                for (String otherTier : tierMap.keySet()) {
                    if (!otherTier.equals(tier)) {
                        EMWandMappings.WandMapping otherTierMapping = orbEntry.getValue().get(otherTier);
                        if (otherTierMapping != null) {
                            Item upgradedHandleItem = otherTierMapping.handle().get();
                            Item upgradedWandItem = otherTierMapping.wand().get();

                            SmithingTransformRecipeBuilder.smithing(
                                            Ingredient.EMPTY,
                                            Ingredient.of(wandItem),
                                            Ingredient.of(upgradedHandleItem),
                                            RecipeCategory.COMBAT,
                                            upgradedWandItem
                                    )
                                    .unlocks("has_" + getItemName(upgradedHandleItem), has(upgradedHandleItem))
                                    .save(output, ResourceLocation.fromNamespaceAndPath(
                                            Ethermist.MODID,
                                            getItemName(upgradedWandItem) + "_from_" + getItemName(wandItem) + "_and_" + getItemName(upgradedHandleItem)
                                    ));
                        }
                    }
                }
            }
        }
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

    protected static void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                     float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Ethermist.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void stonecutting(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, int resultCount) {
        SingleItemRecipeBuilder builder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, resultCount).unlockedBy(getHasName(material), has(material));
        String id = getConversionRecipeName(result, material);
        builder.save(recipeOutput, Ethermist.MODID + ":" + id + "_stonecutting");
    }

    protected static void addTomeRecipe(Item tome, Item material, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, tome, 8)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.BOOK)
                .define('b', material)
                .unlockedBy("has_" + material.getDescriptionId(), has(material)).save(output);
    }

    protected static void addTomeRecipe(Item tome, TagKey<Item> tag, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, tome, 8)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.BOOK)
                .define('b', tag)
                .unlockedBy("has_" + tag.location().getPath(), has(tag)).save(output);
    }

    protected static void addHandleRecipe(Item handle, TagKey<Item> gem, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, handle, 1)
                .pattern(" ba")
                .pattern("bcb")
                .pattern("ab ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.STICK)
                .define('c', gem)
                .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD))
                .unlockedBy("has_" + gem.location().getPath(), has(gem)).save(output);
    }

}
