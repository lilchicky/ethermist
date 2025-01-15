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

                .add(EMBlocks.MIST_GEM_ORE.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(EMBlocks.RICH_DIRT.get())
                .add(EMBlocks.RICH_GRASS.get())
                .add(EMBlocks.SPARKLING_SAND.get())
                .add(EMBlocks.TIMEWORN_SAND.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(EMBlocks.ANCIENT_PLANKS.get())
                .add(EMBlocks.ANCIENT_STAIRS.get())
                .add(EMBlocks.ANCIENT_SLAB.get())
                .add(EMBlocks.ANCIENT_FENCE_GATE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(EMBlocks.MIST_GEM_ORE.get());

        tag(BlockTags.LEAVES)
                .add(EMBlocks.ANCIENT_LEAVES.get());

        tag(BlockTags.SAPLINGS)
                .add(EMBlocks.ANCIENT_SAPLING.get());

        tag(BlockTags.DIRT)
                .add(EMBlocks.RICH_GRASS.get())
                .add(EMBlocks.RICH_DIRT.get());

        tag(BlockTags.SAND)
                .add(EMBlocks.SPARKLING_SAND.get())
                .add(EMBlocks.TIMEWORN_SAND.get());

        tag(Tags.Blocks.GRAVELS)
                .add(EMBlocks.CRUMBLING_ETHERSTONE.get());

        tag(BlockTags.FENCE_GATES)
                .add(EMBlocks.ANCIENT_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(EMBlocks.ETHERSTONE_WALL.get());

        addRedstone(EMBlocks.ETHERSTONE_BUTTON.get(), EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), false);
        addRedstone(EMBlocks.ANCIENT_BUTTON.get(), EMBlocks.ANCIENT_PRESSURE_PLATE.get(), true);

        addFences(EMBlocks.ANCIENT_FENCE.get(), true);

        addLogs(EMBlocks.ANCIENT_LOG.get(), EMBlocks.STRIPPED_ANCIENT_LOG.get(), EMBlocks.ANCIENT_WOOD.get(), EMBlocks.STRIPPED_ANCIENT_WOOD.get(), true);

        addDoors(EMBlocks.ANCIENT_DOOR.get(), EMBlocks.ANCIENT_TRAPDOOR.get(), true);

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
