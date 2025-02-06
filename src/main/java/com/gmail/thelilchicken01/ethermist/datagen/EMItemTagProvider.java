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

        tag(ItemTags.STONE_BRICKS)
                .add(EMBlocks.ETHERSTONE_BRICKS.get().asItem())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get().asItem());

        tag(Tags.Items.SANDSTONE_BLOCKS)
                .add(EMBlocks.TIMEWORN_SANDSTONE.get().asItem())
                .add(EMBlocks.SPARKLING_SANDSTONE.get().asItem());

        tag(Tags.Items.GRAVELS)
                .add(EMBlocks.CRUMBLING_ETHERSTONE.get().asItem());

        tag(ItemTags.PLANKS)
                .add(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get().asItem())
                .add(EMBlocks.SLIMY_PLANKS.get().asItem())
                .add(EMBlocks.FROSTPINE_PLANKS.get().asItem())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get().asItem());

        tag(ItemTags.LOGS)
                .add(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM.get().asItem())
                .add(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM.get().asItem());

        tag(ItemTags.LEAVES)
                .add(EMBlocks.ANCIENT_LEAVES.get().asItem())
                .add(EMBlocks.SLIMY_LEAVES.get().asItem())
                .add(EMBlocks.FROSTPINE_LEAVES.get().asItem());

        tag(ItemTags.SAPLINGS)
                .add(EMBlocks.GLIMMERING_ANCIENT_SAPLING.get().asItem())
                .add(EMBlocks.SLIMY_SAPLING.get().asItem())
                .add(EMBlocks.FROSTPINE_SAPLING.get().asItem());

        tag(ItemTags.FLOWERS)
                .add(EMBlocks.GLIMMER_BLOSSOM.get().asItem());

        tag(ItemTags.SMALL_FLOWERS)
                .add(EMBlocks.GLIMMER_BLOSSOM.get().asItem());

        tag(Tags.Items.GEMS)
                .add(EMItems.GENERIC_SHOT.get());

        tag(EMTags.Items.TOMES)
                .add(EMItems.EXCLUSION_TOME.get());

        tag(EMTags.Items.MAGIC_ENCHANTABLE)
                .add(EMItems.EXCLUSION_TOME.get());

        tag(EMTags.Items.ORBS)
                .add(EMItems.DULL_ORB.get())
                .add(EMItems.FLAME_ORB.get());

        addWands(EMItems.DULL_WAND.get());
        addWands(EMItems.FLAME_WAND.get());
        addWands(EMItems.WAND_TOME.get());

        addRedstone(EMBlocks.ETHERSTONE_BUTTON.get().asItem(), EMBlocks.ETHERSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.GLIMMERING_ANCIENT_BUTTON.get().asItem(), EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.SLIMY_BUTTON.get().asItem(), EMBlocks.SLIMY_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.FROSTPINE_BUTTON.get().asItem(), EMBlocks.FROSTPINE_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.SPARKLING_SANDSTONE_BUTTON.get().asItem(), EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON.get().asItem(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get().asItem(), EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get().asItem(), true);

        addFences(EMBlocks.GLIMMERING_ANCIENT_FENCE.get().asItem(), true);
        addFences(EMBlocks.SLIMY_FENCE.get().asItem(), true);
        addFences(EMBlocks.FROSTPINE_FENCE.get().asItem(), true);
        addFences(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get().asItem(), true);

        addLogs(EMBlocks.GLIMMERING_ANCIENT_LOG.get().asItem(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get().asItem(), EMBlocks.GLIMMERING_ANCIENT_WOOD.get().asItem(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get().asItem(), true);
        addLogs(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().asItem(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().asItem(), EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get().asItem(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get().asItem(), true);
        addLogs(EMBlocks.SLIMY_LOG.get().asItem(), EMBlocks.STRIPPED_SLIMY_LOG.get().asItem(), EMBlocks.SLIMY_WOOD.get().asItem(), EMBlocks.STRIPPED_SLIMY_WOOD.get().asItem(), true);
        addLogs(EMBlocks.FROSTPINE_LOG.get().asItem(), EMBlocks.STRIPPED_FROSTPINE_LOG.get().asItem(), EMBlocks.FROSTPINE_WOOD.get().asItem(), EMBlocks.STRIPPED_FROSTPINE_WOOD.get().asItem(), true);

        addDoors(EMBlocks.GLIMMERING_ANCIENT_DOOR.get().asItem(), true);
        addDoors(EMBlocks.SLIMY_DOOR.get().asItem(), true);
        addDoors(EMBlocks.FROSTPINE_DOOR.get().asItem(), true);
        addDoors(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get().asItem(), true);

    }

    // Functions to make sure I don't miss any tags

    private void addWands(Item wand) {
        tag(EMTags.Items.WANDS).add(wand);
        tag(EMTags.Items.MAGIC_ENCHANTABLE).add(wand);
        tag(ItemTags.DURABILITY_ENCHANTABLE).add(wand);
    }

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
