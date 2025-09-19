package com.gmail.thelilchicken01.ethermist.datagen.tags;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EMBlockTagProvider extends BlockTagsProvider {

    public EMBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(EMBlocks.MOLTEN_ETHERSTONE.get())

                .add(EMBlocks.ETHERSTONE.get())
                .add(EMBlocks.ETHERSTONE_STAIRS.get())
                .add(EMBlocks.ETHERSTONE_SLAB.get())
                .add(EMBlocks.ETHERSTONE_WALL.get())

                .add(EMBlocks.ANCIENT_ETHERSTONE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_STAIRS.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_SLAB.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_WALL.get())

                .add(EMBlocks.WITCHSTONE.get())
                .add(EMBlocks.WITCHSTONE_STAIRS.get())
                .add(EMBlocks.WITCHSTONE_SLAB.get())
                .add(EMBlocks.WITCHSTONE_WALL.get())

                .add(EMBlocks.POLISHED_WITCHSTONE.get())
                .add(EMBlocks.POLISHED_WITCHSTONE_STAIRS.get())
                .add(EMBlocks.POLISHED_WITCHSTONE_SLAB.get())
                .add(EMBlocks.POLISHED_WITCHSTONE_WALL.get())

                .add(EMBlocks.DAWNSHALE.get())
                .add(EMBlocks.DAWNSHALE_STAIRS.get())
                .add(EMBlocks.DAWNSHALE_SLAB.get())
                .add(EMBlocks.DAWNSHALE_WALL.get())

                .add(EMBlocks.POLISHED_DAWNSHALE.get())
                .add(EMBlocks.POLISHED_DAWNSHALE_STAIRS.get())
                .add(EMBlocks.POLISHED_DAWNSHALE_SLAB.get())
                .add(EMBlocks.POLISHED_DAWNSHALE_WALL.get())

                .add(EMBlocks.COBBLED_ETHERSTONE.get())
                .add(EMBlocks.COBBLED_ETHERSTONE_STAIRS.get())
                .add(EMBlocks.COBBLED_ETHERSTONE_SLAB.get())
                .add(EMBlocks.COBBLED_ETHERSTONE_WALL.get())

                .add(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get())
                .add(EMBlocks.MOSSY_COBBLED_ETHERSTONE_STAIRS.get())
                .add(EMBlocks.MOSSY_COBBLED_ETHERSTONE_SLAB.get())
                .add(EMBlocks.MOSSY_COBBLED_ETHERSTONE_WALL.get())

                .add(EMBlocks.ETHERSTONE_BRICKS.get())
                .add(EMBlocks.ETHERSTONE_BRICK_STAIRS.get())
                .add(EMBlocks.ETHERSTONE_BRICK_SLAB.get())
                .add(EMBlocks.ETHERSTONE_BRICK_WALL.get())

                .add(EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_BRICK_STAIRS.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_BRICK_SLAB.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_BRICK_WALL.get())

                .add(EMBlocks.SPARKLING_SANDSTONE.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_STAIRS.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_SLAB.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_WALL.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL.get())

                .add(EMBlocks.TIMEWORN_SANDSTONE.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())
                .add(EMBlocks.CHISELED_TIMEWORN_SANDSTONE.get())
                .add(EMBlocks.TIMEWORN_SANDSTONE_STAIRS.get())
                .add(EMBlocks.TIMEWORN_SANDSTONE_SLAB.get())
                .add(EMBlocks.TIMEWORN_SANDSTONE_WALL.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(EMBlocks.RICH_DIRT.get())
                .add(EMBlocks.RICH_GRASS_BLOCK.get())
                .add(EMBlocks.SPARKLING_SAND.get())
                .add(EMBlocks.TIMEWORN_SAND.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(EMBlocks.GLIMMERING_ANCIENT_STAIRS.get())
                .add(EMBlocks.GLIMMERING_ANCIENT_SLAB.get())
                .add(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE.get())

                .add(EMBlocks.ANCIENT_STAIRS.get())
                .add(EMBlocks.ANCIENT_SLAB.get())
                .add(EMBlocks.ANCIENT_FENCE_GATE.get())

                .add(EMBlocks.SLIMY_STAIRS.get())
                .add(EMBlocks.SLIMY_SLAB.get())
                .add(EMBlocks.SLIMY_FENCE_GATE.get())

                .add(EMBlocks.FROSTPINE_STAIRS.get())
                .add(EMBlocks.FROSTPINE_SLAB.get())
                .add(EMBlocks.FROSTPINE_FENCE_GATE.get())

                .add(EMBlocks.AMBERWOOD_STAIRS.get())
                .add(EMBlocks.AMBERWOOD_SLAB.get())
                .add(EMBlocks.AMBERWOOD_FENCE_GATE.get())

                .add(EMBlocks.CHARRED_STAIRS.get())
                .add(EMBlocks.CHARRED_SLAB.get())
                .add(EMBlocks.CHARRED_FENCE_GATE.get())

                .add(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get())
                .add(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS.get())

                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get())

                .add(EMBlocks.WANDFORGING_TABLE.get());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get())
                .add(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get())

                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get());

        tag(Tags.Blocks.SANDSTONE_BLOCKS)
                .add(EMBlocks.TIMEWORN_SANDSTONE.get())
                .add(EMBlocks.SPARKLING_SANDSTONE.get());

        tag(BlockTags.REPLACEABLE_BY_TREES)
                .add(EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS.get())
                .add(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP.get());

        tag(BlockTags.LOGS)
                .add(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get());

        tag(BlockTags.LEAVES)
                .add(EMBlocks.ANCIENT_LEAVES.get())
                .add(EMBlocks.SLIMY_LEAVES.get())
                .add(EMBlocks.RED_AMBERWOOD_LEAVES.get())
                .add(EMBlocks.ORANGE_AMBERWOOD_LEAVES.get())
                .add(EMBlocks.YELLOW_AMBERWOOD_LEAVES.get())
                .add(EMBlocks.GREEN_AMBERWOOD_LEAVES.get())
                .add(EMBlocks.FROSTPINE_LEAVES.get());

        tag(BlockTags.SAPLINGS)
                .add(EMBlocks.GLIMMERING_ANCIENT_SAPLING.get())
                .add(EMBlocks.ANCIENT_SAPLING.get())
                .add(EMBlocks.SLIMY_SAPLING.get())
                .add(EMBlocks.GREEN_AMBERWOOD_SAPLING.get())
                .add(EMBlocks.RED_AMBERWOOD_SAPLING.get())
                .add(EMBlocks.ORANGE_AMBERWOOD_SAPLING.get())
                .add(EMBlocks.YELLOW_AMBERWOOD_SAPLING.get())
                .add(EMBlocks.CHARRED_SAPLING.get())
                .add(EMBlocks.FROSTPINE_SAPLING.get());

        tag(BlockTags.INFINIBURN_OVERWORLD)
                .add(EMBlocks.MOLTEN_ETHERSTONE.get());

        tag(BlockTags.MOSS_REPLACEABLE)
                .add(EMBlocks.ETHERSTONE.get())
                .add(EMBlocks.WITCHSTONE.get())
                .add(EMBlocks.DAWNSHALE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE.get());

        tag(BlockTags.SCULK_REPLACEABLE)
                .add(EMBlocks.SPARKLING_SAND.get())
                .add(EMBlocks.SPARKLING_SANDSTONE.get())
                .add(EMBlocks.TIMEWORN_SANDSTONE.get())
                .add(EMBlocks.TIMEWORN_SAND.get())
                .add(EMBlocks.ETHERSTONE.get())
                .add(EMBlocks.WITCHSTONE.get())
                .add(EMBlocks.DAWNSHALE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE.get());

        tag(BlockTags.DRIPSTONE_REPLACEABLE)
                .add(EMBlocks.ETHERSTONE.get())
                .add(EMBlocks.WITCHSTONE.get())
                .add(EMBlocks.DAWNSHALE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE.get());

        tag(BlockTags.DIRT)
                .add(EMBlocks.RICH_GRASS_BLOCK.get())
                .add(EMBlocks.RICH_DIRT.get());

        tag(BlockTags.SAND)
                .add(EMBlocks.SPARKLING_SAND.get())
                .add(EMBlocks.TIMEWORN_SAND.get());

        tag(Tags.Blocks.GRAVELS)
                .add(EMBlocks.CRUMBLING_ETHERSTONE.get());

        tag(BlockTags.FLOWERS)
                .add(EMBlocks.GLIMMERBUD.get())
                .add(EMBlocks.SLIMY_ALLIUM.get())
                .add(EMBlocks.WITCH_LAVENDER.get())
                .add(EMBlocks.DAWNING_HYACINTH.get())
                .add(EMBlocks.CINDERBLOOM.get())
                .add(EMBlocks.NIGHTBELL.get());

        tag(BlockTags.SMALL_FLOWERS)
                .add(EMBlocks.GLIMMERBUD.get())
                .add(EMBlocks.SLIMY_ALLIUM.get())
                .add(EMBlocks.WITCH_LAVENDER.get())
                .add(EMBlocks.DAWNING_HYACINTH.get())
                .add(EMBlocks.CINDERBLOOM.get())
                .add(EMBlocks.NIGHTBELL.get());

        tag(BlockTags.FLOWER_POTS)
                .add(EMBlocks.GLIMMERBUD_FLOWER_POT.get())
                .add(EMBlocks.WITCH_LAVENDER_FLOWER_POT.get())
                .add(EMBlocks.DAWNING_HYACINTH_FLOWER_POT.get())
                .add(EMBlocks.NIGHTBELL_FLOWER_POT.get());

        tag(BlockTags.FENCE_GATES)
                .add(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE.get())
                .add(EMBlocks.ANCIENT_FENCE_GATE.get())
                .add(EMBlocks.SLIMY_FENCE_GATE.get())
                .add(EMBlocks.FROSTPINE_FENCE_GATE.get())
                .add(EMBlocks.AMBERWOOD_FENCE_GATE.get())
                .add(EMBlocks.CHARRED_FENCE_GATE.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(EMBlocks.ETHERSTONE_WALL.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_WALL.get())
                .add(EMBlocks.WITCHSTONE_WALL.get())
                .add(EMBlocks.DAWNSHALE_WALL.get())
                .add(EMBlocks.POLISHED_WITCHSTONE_WALL.get())
                .add(EMBlocks.POLISHED_DAWNSHALE_WALL.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_BRICK_WALL.get())
                .add(EMBlocks.ETHERSTONE_BRICK_WALL.get())
                .add(EMBlocks.COBBLED_ETHERSTONE_WALL.get())
                .add(EMBlocks.MOSSY_COBBLED_ETHERSTONE_WALL.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_WALL.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL.get())
                .add(EMBlocks.TIMEWORN_SANDSTONE_WALL.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get());

        tag(EMTags.Blocks.PORTAL_FRAME_BLOCKS)
                .add(EMBlocks.ETHERSTONE_BRICKS.get())
                .add(EMBlocks.POLISHED_WITCHSTONE.get())
                .add(EMBlocks.POLISHED_DAWNSHALE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get());

        tag(EMTags.Blocks.CAN_GROW_ICICLE)
                .add(EMBlocks.FROSTPINE_LEAVES.get())
                .addTag(Tags.Blocks.STONES)
                .addTag(Tags.Blocks.COBBLESTONES)
                .addTag(BlockTags.DIRT)
                .addTag(BlockTags.ICE);

        tag(EMTags.Blocks.CAN_SUPPORT_CHARRED_TREE)
                .addTag(Tags.Blocks.STONES)
                .addTag(BlockTags.DIRT)
                .addTag(Tags.Blocks.GRAVELS)
                .addTag(Tags.Blocks.COBBLESTONES)
                .add(Blocks.BLACKSTONE)
                .add(EMBlocks.MOLTEN_ETHERSTONE.get());

        tag(Tags.Blocks.COBBLESTONES_NORMAL)
                .add(EMBlocks.COBBLED_ETHERSTONE.get());

        tag(Tags.Blocks.COBBLESTONES_MOSSY)
                .add(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get());

        tag(Tags.Blocks.STONES)
                .add(EMBlocks.ETHERSTONE.get())
                .add(EMBlocks.WITCHSTONE.get())
                .add(EMBlocks.DAWNSHALE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE.get());

        tag(EMTags.Blocks.ETHERMIST_STONES)
                .add(EMBlocks.ETHERSTONE.get())
                .add(EMBlocks.WITCHSTONE.get())
                .add(EMBlocks.DAWNSHALE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE.get());

        tag(Tags.Blocks.PLAYER_WORKSTATIONS_CRAFTING_TABLES)
                .add(EMBlocks.WANDFORGING_TABLE.get());

        tag(EMTags.Blocks.CAN_SUPPORT_FORGEMASTER_PYLON)
                .addTag(BlockTags.PLANKS)
                .addTag(BlockTags.LOGS)
                .addTag(BlockTags.STONE_BRICKS);

        addPlanks(EMBlocks.ANCIENT_PLANKS.get());
        addPlanks(EMBlocks.SLIMY_PLANKS.get());
        addPlanks(EMBlocks.FROSTPINE_PLANKS.get());
        addPlanks(EMBlocks.AMBERWOOD_PLANKS.get());
        addPlanks(EMBlocks.CHARRED_PLANKS.get());

        addRedstone(EMBlocks.ETHERSTONE_BUTTON.get(), EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.POLISHED_WITCHSTONE_BUTTON.get(), EMBlocks.POLISHED_WITCHSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.POLISHED_DAWNSHALE_BUTTON.get(), EMBlocks.POLISHED_DAWNSHALE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.ANCIENT_ETHERSTONE_BUTTON.get(), EMBlocks.ANCIENT_ETHERSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.GLIMMERING_ANCIENT_BUTTON.get(), EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.ANCIENT_BUTTON.get(), EMBlocks.ANCIENT_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.SLIMY_BUTTON.get(), EMBlocks.SLIMY_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.FROSTPINE_BUTTON.get(), EMBlocks.FROSTPINE_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.SPARKLING_SANDSTONE_BUTTON.get(), EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get(), EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.AMBERWOOD_BUTTON.get(), EMBlocks.AMBERWOOD_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.CHARRED_BUTTON.get(), EMBlocks.CHARRED_PRESSURE_PLATE.get(), true);

        addFences(EMBlocks.GLIMMERING_ANCIENT_FENCE.get(), true);
        addFences(EMBlocks.ANCIENT_FENCE.get(), true);
        addFences(EMBlocks.SLIMY_FENCE.get(), true);
        addFences(EMBlocks.FROSTPINE_FENCE.get(), true);
        addFences(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get(), true);
        addFences(EMBlocks.AMBERWOOD_FENCE.get(), true);
        addFences(EMBlocks.CHARRED_FENCE.get(), true);

        addLogs(EMBlocks.GLIMMERING_ANCIENT_LOG.get(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get(), EMBlocks.GLIMMERING_ANCIENT_WOOD.get(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get(), true);
        addLogs(EMBlocks.ANCIENT_LOG.get(), EMBlocks.STRIPPED_ANCIENT_LOG.get(), EMBlocks.ANCIENT_WOOD.get(), EMBlocks.STRIPPED_ANCIENT_WOOD.get(), true);
        addLogs(EMBlocks.SLIMY_LOG.get(), EMBlocks.STRIPPED_SLIMY_LOG.get(), EMBlocks.SLIMY_WOOD.get(), EMBlocks.STRIPPED_SLIMY_WOOD.get(), true);
        addLogs(EMBlocks.FROSTPINE_LOG.get(), EMBlocks.STRIPPED_FROSTPINE_LOG.get(), EMBlocks.FROSTPINE_WOOD.get(), EMBlocks.STRIPPED_FROSTPINE_WOOD.get(), true);
        addLogs(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(), EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(), true);
        addLogs(EMBlocks.AMBERWOOD_LOG.get(), EMBlocks.STRIPPED_AMBERWOOD_LOG.get(), EMBlocks.AMBERWOOD_WOOD.get(), EMBlocks.STRIPPED_AMBERWOOD_WOOD.get(), true);
        addLogs(EMBlocks.CHARRED_LOG.get(), EMBlocks.STRIPPED_CHARRED_LOG.get(), EMBlocks.CHARRED_WOOD.get(), EMBlocks.STRIPPED_CHARRED_WOOD.get(), false);

        addDoors(EMBlocks.GLIMMERING_ANCIENT_DOOR.get(), EMBlocks.GLIMMERING_ANCIENT_TRAPDOOR.get(), true);
        addDoors(EMBlocks.ANCIENT_DOOR.get(), EMBlocks.ANCIENT_TRAPDOOR.get(), true);
        addDoors(EMBlocks.SLIMY_DOOR.get(), EMBlocks.SLIMY_TRAPDOOR.get(), true);
        addDoors(EMBlocks.FROSTPINE_DOOR.get(), EMBlocks.FROSTPINE_TRAPDOOR.get(), true);
        addDoors(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get(), EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR.get(), true);
        addDoors(EMBlocks.AMBERWOOD_DOOR.get(), EMBlocks.AMBERWOOD_TRAPDOOR.get(), true);
        addDoors(EMBlocks.CHARRED_DOOR.get(), EMBlocks.CHARRED_TRAPDOOR.get(), true);

        /*
        ----------  Ores ----------
         */

        tag(EMTags.Blocks.ETHERSTONE_ORE_REPLACEABLES)
                .add(EMBlocks.ETHERSTONE.get());

        tag(EMTags.Blocks.ANCIENT_ETHERSTONE_ORE_REPLACEABLES)
                .add(EMBlocks.ANCIENT_ETHERSTONE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ETHERSTONE_COAL_ORE.get())
                .add(EMBlocks.ETHERSTONE_REDSTONE_ORE.get())
                .add(EMBlocks.ETHERSTONE_DIAMOND_ORE.get())
                .add(EMBlocks.ETHERSTONE_LAPIS_ORE.get())
                .add(EMBlocks.ETHERSTONE_EMERALD_ORE.get())
                .add(EMBlocks.ETHERSTONE_GOLD_ORE.get())
                .add(EMBlocks.ETHERSTONE_COPPER_ORE.get())
        
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COAL_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ETHERSTONE_COPPER_ORE.get())
        
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(EMBlocks.ETHERSTONE_DIAMOND_ORE.get())
                .add(EMBlocks.ETHERSTONE_EMERALD_ORE.get())
                .add(EMBlocks.ETHERSTONE_REDSTONE_ORE.get())
                .add(EMBlocks.ETHERSTONE_LAPIS_ORE.get())
                .add(EMBlocks.ETHERSTONE_GOLD_ORE.get())

                .add(EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get());

        tag(Tags.Blocks.ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ETHERSTONE_COAL_ORE.get())
                .add(EMBlocks.ETHERSTONE_REDSTONE_ORE.get())
                .add(EMBlocks.ETHERSTONE_DIAMOND_ORE.get())
                .add(EMBlocks.ETHERSTONE_LAPIS_ORE.get())
                .add(EMBlocks.ETHERSTONE_EMERALD_ORE.get())
                .add(EMBlocks.ETHERSTONE_GOLD_ORE.get())
                .add(EMBlocks.ETHERSTONE_COPPER_ORE.get())

                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COAL_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get());

        // Ore Specific
        tag(BlockTags.COPPER_ORES)
                .add(EMBlocks.ETHERSTONE_COPPER_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get());
        tag(Tags.Blocks.ORES_COPPER)
                .add(EMBlocks.ETHERSTONE_COPPER_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get());

        tag(BlockTags.IRON_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_IRON)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());

        tag(BlockTags.GOLD_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_GOLD)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());

        tag(BlockTags.COAL_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_COAL)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());

        tag(BlockTags.DIAMOND_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_DIAMOND)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());

        tag(BlockTags.EMERALD_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_EMERALD)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());

        tag(BlockTags.LAPIS_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_LAPIS)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());

        tag(BlockTags.REDSTONE_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_REDSTONE)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get());

    }

    // Functions to make sure I don't miss any tags

    private void addRedstone(Block button, Block plate, Boolean wooden) {

        tag(BlockTags.BUTTONS).add(button);
        tag(BlockTags.PRESSURE_PLATES).add(plate);

        if (wooden) {
            tag(BlockTags.WOODEN_BUTTONS).add(button);
            tag(BlockTags.WOODEN_PRESSURE_PLATES).add(plate);
            tag(BlockTags.MINEABLE_WITH_AXE).add(button).add(plate);
        }
        else {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(button).add(plate);
        }

    }

    private void addFences(Block fence, Boolean wooden) {

        tag(BlockTags.FENCES).add(fence);

        if (wooden) {
            tag(BlockTags.WOODEN_FENCES).add(fence);
            tag(BlockTags.MINEABLE_WITH_AXE).add(fence);
        }
        else {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(fence);
        }
    }

    private void addDoors(Block door, Block trapdoor, Boolean wooden) {

        tag(BlockTags.DOORS).add(door);

        if (wooden) {
            tag(BlockTags.WOODEN_DOORS).add(door);
            tag(BlockTags.MINEABLE_WITH_AXE).add(door).add(trapdoor);
        }
        else {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(door).add(trapdoor);
        }
    }

    private void addLogs(Block log, Block stripped_log, Block wood, Block stripped_wood, Boolean flammable) {

        tag(BlockTags.LOGS).add(log).add(stripped_log).add(wood).add(stripped_wood);
        tag(BlockTags.MINEABLE_WITH_AXE).add(log).add(stripped_log).add(wood).add(stripped_wood);

        if (flammable) {
            tag(BlockTags.LOGS_THAT_BURN).add(log).add(stripped_log).add(wood).add(stripped_wood);
        }

    }

    private void addPlanks(Block plank) {
        tag(BlockTags.PLANKS).add(plank);
        tag(BlockTags.MINEABLE_WITH_AXE).add(plank);
    }

}
