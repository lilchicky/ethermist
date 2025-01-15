package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EMItemTagProvider extends ItemTagsProvider {

    public EMItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                             CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(Tags.Items.STONES)
                .add(EMBlocks.ETHERSTONE.asItem());

        tag(ItemTags.SAND)
                .add(EMBlocks.SPARKLING_SAND.get().asItem())
                .add(EMBlocks.TIMEWORN_SAND.get().asItem());

        tag(Tags.Items.GRAVELS)
                .add(EMBlocks.CRUMBLING_ETHERSTONE.get().asItem());

        tag(ItemTags.PLANKS)
                .add(EMBlocks.ANCIENT_PLANKS.get().asItem())
                .add(EMBlocks.SLIMY_PLANKS.get().asItem());

        tag(ItemTags.LEAVES)
                .add(EMBlocks.ANCIENT_LEAVES.get().asItem())
                .add(EMBlocks.SLIMY_LEAVES.get().asItem());

        tag(ItemTags.SAPLINGS)
                .add(EMBlocks.ANCIENT_SAPLING.get().asItem())
                .add(EMBlocks.SLIMY_SAPLING.get().asItem());

        tag(Tags.Items.GEMS)
                .add(EMItems.MIST_GEM.get());

        addRedstone(EMBlocks.ETHERSTONE_BUTTON.get().asItem(), EMBlocks.ETHERSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.ANCIENT_BUTTON.get().asItem(), EMBlocks.ANCIENT_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.SLIMY_BUTTON.get().asItem(), EMBlocks.SLIMY_PRESSURE_PLATE.get().asItem(), true);

        addFences(EMBlocks.ANCIENT_FENCE.get().asItem(), true);
        addFences(EMBlocks.SLIMY_FENCE.get().asItem(), true);

        addLogs(EMBlocks.ANCIENT_LOG.get().asItem(), EMBlocks.STRIPPED_ANCIENT_LOG.get().asItem(), EMBlocks.ANCIENT_WOOD.get().asItem(), EMBlocks.STRIPPED_ANCIENT_WOOD.get().asItem(), true);
        addLogs(EMBlocks.SLIMY_LOG.get().asItem(), EMBlocks.STRIPPED_SLIMY_LOG.get().asItem(), EMBlocks.SLIMY_WOOD.get().asItem(), EMBlocks.STRIPPED_SLIMY_WOOD.get().asItem(), true);

        addDoors(EMBlocks.ANCIENT_DOOR.get().asItem(), true);
        addDoors(EMBlocks.SLIMY_DOOR.get().asItem(), true);

    }

    // Functions to make sure I don't miss any tags

    private void addRedstone(Item button, Item plate, Boolean wooden) {

        tag(ItemTags.BUTTONS).add(button);

        if (wooden) {
            tag(ItemTags.WOODEN_BUTTONS).add(button);
            tag(ItemTags.WOODEN_PRESSURE_PLATES).add(plate);
        }

    }

    private void addFences(Item fence, Boolean wooden) {

        tag(ItemTags.FENCES).add(fence);

        if (wooden) {
            tag(ItemTags.WOODEN_FENCES).add(fence);
        }
    }

    private void addDoors(Item door, Boolean wooden) {

        tag(ItemTags.DOORS).add(door);

        if (wooden) {
            tag(ItemTags.WOODEN_DOORS).add(door);
        }
    }

    private void addLogs(Item log, Item stripped_log, Item wood, Item stripped_wood, Boolean flammable) {

        tag(ItemTags.LOGS).add(log).add(stripped_log).add(wood).add(stripped_wood);

        if (flammable) {
            tag(ItemTags.LOGS_THAT_BURN).add(log).add(stripped_log).add(wood).add(stripped_wood);
        }

    }

}
