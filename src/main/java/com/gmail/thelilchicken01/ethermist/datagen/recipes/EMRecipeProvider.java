package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.OrbItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EMRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public EMRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

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
                .unlockedBy("has_etherstone", has(EMBlocks.ETHERSTONE)).save(output);

        oreSmelting(output, List.of(EMBlocks.COBBLED_ETHERSTONE.get()),
                RecipeCategory.BUILDING_BLOCKS, EMBlocks.ETHERSTONE.get(), 0.25f, 200, "stone");
        
        // Cobbled Etherstone
        stairBuilder(EMBlocks.COBBLED_ETHERSTONE_STAIRS.get(), Ingredient.of(EMBlocks.COBBLED_ETHERSTONE)).group("stairs")
                .unlockedBy("has_cobbled_etherstone", has(EMBlocks.COBBLED_ETHERSTONE)).save(output);
        slab(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_SLAB.get(), EMBlocks.COBBLED_ETHERSTONE.get());
        wall(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_WALL.get(), EMBlocks.COBBLED_ETHERSTONE.get());

        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_STAIRS.get(), EMBlocks.COBBLED_ETHERSTONE.get(), 1);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_SLAB.get(), EMBlocks.COBBLED_ETHERSTONE.get(), 2);
        stonecutting(output, RecipeCategory.BUILDING_BLOCKS, EMBlocks.COBBLED_ETHERSTONE_WALL.get(), EMBlocks.COBBLED_ETHERSTONE.get(), 1);

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

        stairBuilder(EMBlocks.MOSSY_COBBLED_ETHERSTONE_STAIRS.get(), Ingredient.of(EMBlocks.MOSSY_COBBLED_ETHERSTONE)).group("stairs")
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
                .requires(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_STEM.get())
                .unlockedBy("has_large_blue_abyssal_mushroom_stem", has(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_STEM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CUBED_ABYSSAL_MUSHROOM.getId().getPath() + "_blue"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), 4)
                .requires(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_STEM.get())
                .unlockedBy("has_large_orange_abyssal_mushroom_stem", has(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_STEM))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.CUBED_ABYSSAL_MUSHROOM.getId().getPath() + "_orange"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMBlocks.SMALL_ABYSSAL_MUSHROOM.get(), 9)
                .requires(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP.get())
                .unlockedBy("has_large_orange_abyssal_mushroom_top", has(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SMALL_ABYSSAL_MUSHROOM.getId().getPath() + "_orange"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMBlocks.SMALL_ABYSSAL_MUSHROOM.get(), 9)
                .requires(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP.get())
                .unlockedBy("has_large_blue_abyssal_mushroom_top", has(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP))
                .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, EMBlocks.SMALL_ABYSSAL_MUSHROOM.getId().getPath() + "_blue"));

        // Flowers to Dyes
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

        // Misc Recipes
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

        // Tomes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMItems.EXCLUSION_TOME.get(), 8)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.BOOK)
                .define('b', Items.SPYGLASS)
                .unlockedBy("has_spyglass", has(Items.SPYGLASS)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMItems.AUGMENT_TOME.get(), 8)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.BOOK)
                .define('b', Items.REDSTONE)
                .unlockedBy("has_redstone", has(Items.REDSTONE)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMItems.MAIN_SPELL_TOME.get(), 8)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.BOOK)
                .define('b', Items.DIAMOND)
                .unlockedBy("has_diamond", has(Items.DIAMOND)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMItems.BASE_SPELL_TOME.get(), 8)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.BOOK)
                .define('b', Items.AMETHYST_SHARD)
                .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMItems.WAND_TOME.get(), 8)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.BOOK)
                .define('b', EMTags.Items.ORBS)
                .unlockedBy("has_orb", has(EMTags.Items.ORBS)).save(output);

        // Wands
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMItems.WAND_HANDLE.get(), 1)
                .pattern(" ba")
                .pattern("bab")
                .pattern("ab ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.STICK)
                .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD)).save(output);

        List<Item> wands = new ArrayList<>(List.of(
                EMItems.DULL_WAND.get(),
                EMItems.FLAME_WAND.get(),
                EMItems.WAND_HANDLE.get(),
                EMItems.LEVITATION_WAND.get(),
                EMItems.WITHER_WAND.get(),
                EMItems.POISON_WAND.get()
        ));
        List<OrbItem> orbs = new ArrayList<>(List.of(
                EMItems.DULL_ORB.get(),
                EMItems.FLAME_ORB.get(),
                EMItems.LEVITATION_ORB.get(),
                EMItems.WITHER_ORB.get(),
                EMItems.POISON_ORB.get()
        ));

        for (Item wand : wands) {
            for (OrbItem orb : orbs) {
                Item result = orb.getWand();
                if (result != null && result != wand) {
                    SmithingTransformRecipeBuilder.smithing(
                            Ingredient.EMPTY,
                            Ingredient.of(wand),
                            Ingredient.of(orb),
                            RecipeCategory.COMBAT,
                            result
                    ).unlocks("has_" + getItemName(orb), has(orb))
                            .save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                                    getItemName(result) + "_from_" + getItemName(orb) + "_and_" + getItemName(wand)));
                }
            }
        }

        SpecialRecipeBuilder.special(WandDyeRecipe::new).save(output, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_dye"));

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
        SingleItemRecipeBuilder builder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, resultCount).unlockedBy(getHasName(material), has(material));
        String id = getConversionRecipeName(result, material);
        builder.save(recipeOutput, Ethermist.MODID + ":" + id + "_stonecutting");
    }

}
