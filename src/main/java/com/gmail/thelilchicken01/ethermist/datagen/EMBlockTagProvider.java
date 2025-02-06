package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
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
                .add(EMBlocks.ETHERSTONE.get())
                .add(EMBlocks.ETHERSTONE_STAIRS.get())
                .add(EMBlocks.ETHERSTONE_SLAB.get())
                .add(EMBlocks.ETHERSTONE_WALL.get())

                .add(EMBlocks.ETHERSTONE_BRICKS.get())
                .add(EMBlocks.ETHERSTONE_BRICK_STAIRS.get())
                .add(EMBlocks.ETHERSTONE_BRICK_SLAB.get())
                .add(EMBlocks.ETHERSTONE_BRICK_WALL.get())

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
                .add(EMBlocks.TIMEWORN_SANDSTONE_STAIRS.get())
                .add(EMBlocks.TIMEWORN_SANDSTONE_SLAB.get())
                .add(EMBlocks.TIMEWORN_SANDSTONE_WALL.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get())

                .add(EMBlocks.MIST_GEM_ORE.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(EMBlocks.RICH_DIRT.get())
                .add(EMBlocks.RICH_GRASS_BLOCK.get())
                .add(EMBlocks.SPARKLING_SAND.get())
                .add(EMBlocks.TIMEWORN_SAND.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get())
                .add(EMBlocks.GLIMMERING_ANCIENT_STAIRS.get())
                .add(EMBlocks.GLIMMERING_ANCIENT_SLAB.get())
                .add(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE.get())
                
                .add(EMBlocks.SLIMY_PLANKS.get())
                .add(EMBlocks.SLIMY_STAIRS.get())
                .add(EMBlocks.SLIMY_SLAB.get())
                .add(EMBlocks.SLIMY_FENCE_GATE.get())

                .add(EMBlocks.FROSTPINE_PLANKS.get())
                .add(EMBlocks.FROSTPINE_STAIRS.get())
                .add(EMBlocks.FROSTPINE_SLAB.get())
                .add(EMBlocks.FROSTPINE_FENCE_GATE.get())

                .add(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM.get())
                .add(EMBlocks.BLUE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.BLUE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_TOP.get())

                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(EMBlocks.BLUE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_TOP.get())
                .add(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM.get())
                .add(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM.get())

                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(EMBlocks.MIST_GEM_ORE.get());

        tag(Tags.Blocks.SANDSTONE_BLOCKS)
                .add(EMBlocks.TIMEWORN_SANDSTONE.get())
                .add(EMBlocks.SPARKLING_SANDSTONE.get());

        tag(BlockTags.LOGS)
                .add(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM.get())
                .add(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM.get());

        tag(BlockTags.LEAVES)
                .add(EMBlocks.ANCIENT_LEAVES.get())
                .add(EMBlocks.SLIMY_LEAVES.get())
                .add(EMBlocks.FROSTPINE_LEAVES.get());

        tag(BlockTags.SAPLINGS)
                .add(EMBlocks.GLIMMERING_ANCIENT_SAPLING.get())
                .add(EMBlocks.SLIMY_SAPLING.get())
                .add(EMBlocks.FROSTPINE_SAPLING.get());

        tag(BlockTags.DIRT)
                .add(EMBlocks.RICH_GRASS_BLOCK.get())
                .add(EMBlocks.RICH_DIRT.get());

        tag(BlockTags.SAND)
                .add(EMBlocks.SPARKLING_SAND.get())
                .add(EMBlocks.TIMEWORN_SAND.get());

        tag(Tags.Blocks.GRAVELS)
                .add(EMBlocks.CRUMBLING_ETHERSTONE.get());

        tag(BlockTags.FLOWERS)
                .add(EMBlocks.GLIMMER_BLOSSOM.get());

        tag(BlockTags.SMALL_FLOWERS)
                .add(EMBlocks.GLIMMER_BLOSSOM.get());

        tag(BlockTags.FLOWER_POTS)
                .add(EMBlocks.GLIMMER_BLOSSOM_FLOWER_POT.get());

        tag(BlockTags.FENCE_GATES)
                .add(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE.get())
                .add(EMBlocks.SLIMY_FENCE_GATE.get())
                .add(EMBlocks.FROSTPINE_FENCE_GATE.get())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(EMBlocks.ETHERSTONE_WALL.get())
                .add(EMBlocks.ETHERSTONE_BRICK_WALL.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_WALL.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL.get())
                .add(EMBlocks.TIMEWORN_SANDSTONE_WALL.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get());

        tag(EMTags.Blocks.PORTAL_FRAME_BLOCKS)
                .add(EMBlocks.ETHERSTONE_BRICKS.get())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get())
                .add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get());

        tag(EMTags.Blocks.CAN_GROW_ICICLE)
                .add(EMBlocks.FROSTPINE_LEAVES.get())
                .add(EMBlocks.RICH_GRASS.get())
                .add(EMBlocks.RICH_DIRT.get())
                .addTag(Tags.Blocks.STONES)
                .addTag(BlockTags.ICE);

        addRedstone(EMBlocks.ETHERSTONE_BUTTON.get(), EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.GLIMMERING_ANCIENT_BUTTON.get(), EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.SLIMY_BUTTON.get(), EMBlocks.SLIMY_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.FROSTPINE_BUTTON.get(), EMBlocks.FROSTPINE_PRESSURE_PLATE.get(), true);
        addRedstone(EMBlocks.SPARKLING_SANDSTONE_BUTTON.get(), EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON.get(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get(), EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get(), true);

        addFences(EMBlocks.GLIMMERING_ANCIENT_FENCE.get(), true);
        addFences(EMBlocks.SLIMY_FENCE.get(), true);
        addFences(EMBlocks.FROSTPINE_FENCE.get(), true);
        addFences(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get(), true);

        addLogs(EMBlocks.GLIMMERING_ANCIENT_LOG.get(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get(), EMBlocks.GLIMMERING_ANCIENT_WOOD.get(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get(), true);
        addLogs(EMBlocks.SLIMY_LOG.get(), EMBlocks.STRIPPED_SLIMY_LOG.get(), EMBlocks.SLIMY_WOOD.get(), EMBlocks.STRIPPED_SLIMY_WOOD.get(), true);
        addLogs(EMBlocks.FROSTPINE_LOG.get(), EMBlocks.STRIPPED_FROSTPINE_LOG.get(), EMBlocks.FROSTPINE_WOOD.get(), EMBlocks.STRIPPED_FROSTPINE_WOOD.get(), true);
        addLogs(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(), EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(), true);

        addDoors(EMBlocks.GLIMMERING_ANCIENT_DOOR.get(), EMBlocks.GLIMMERING_ANCIENT_TRAPDOOR.get(), true);
        addDoors(EMBlocks.SLIMY_DOOR.get(), EMBlocks.SLIMY_TRAPDOOR.get(), true);
        addDoors(EMBlocks.FROSTPINE_DOOR.get(), EMBlocks.FROSTPINE_TRAPDOOR.get(), true);
        addDoors(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get(), EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR.get(), true);

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

}
