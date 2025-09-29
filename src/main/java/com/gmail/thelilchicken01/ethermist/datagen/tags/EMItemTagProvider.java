package com.gmail.thelilchicken01.ethermist.datagen.tags;

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
                .add(EMBlocks.ETHERSTONE.asItem())
                .add(EMBlocks.WITCHSTONE.asItem())
                .add(EMBlocks.DAWNSHALE.asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE.asItem());

        tag(Tags.Items.COBBLESTONES_NORMAL)
                .add(EMBlocks.COBBLED_ETHERSTONE.get().asItem());

        tag(Tags.Items.COBBLESTONES_MOSSY)
                .add(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get().asItem());

        tag(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(EMBlocks.ANCIENT_ETHERSTONE.get().asItem())
                .add(EMBlocks.COBBLED_ETHERSTONE.get().asItem());

        tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(EMBlocks.ANCIENT_ETHERSTONE.get().asItem())
                .add(EMBlocks.COBBLED_ETHERSTONE.get().asItem());

        tag(ItemTags.SAND)
                .add(EMBlocks.SPARKLING_SAND.get().asItem())
                .add(EMBlocks.TIMEWORN_SAND.get().asItem());

        tag(ItemTags.STONE_BRICKS)
                .add(EMBlocks.ETHERSTONE_BRICKS.get().asItem())
                .add(EMBlocks.CRACKED_ETHERSTONE_BRICKS.get().asItem())
                .add(EMBlocks.MOSSY_ETHERSTONE_BRICKS.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get().asItem())
                .add(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get().asItem());

        tag(Tags.Items.SANDSTONE_BLOCKS)
                .add(EMBlocks.TIMEWORN_SANDSTONE.get().asItem())
                .add(EMBlocks.SPARKLING_SANDSTONE.get().asItem());

        tag(Tags.Items.GRAVELS)
                .add(EMBlocks.CRUMBLING_ETHERSTONE.get().asItem());

        tag(ItemTags.PLANKS)
                .add(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get().asItem())
                .add(EMBlocks.ANCIENT_PLANKS.get().asItem())
                .add(EMBlocks.SLIMY_PLANKS.get().asItem())
                .add(EMBlocks.FROSTPINE_PLANKS.get().asItem())
                .add(EMBlocks.AMBERWOOD_PLANKS.get().asItem())
                .add(EMBlocks.CHARRED_PLANKS.get().asItem())
                .add(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get().asItem());

        tag(ItemTags.LOGS)
                .add(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get().asItem());

        tag(ItemTags.LEAVES)
                .add(EMBlocks.ANCIENT_LEAVES.get().asItem())
                .add(EMBlocks.SLIMY_LEAVES.get().asItem())
                .add(EMBlocks.RED_AMBERWOOD_LEAVES.get().asItem())
                .add(EMBlocks.ORANGE_AMBERWOOD_LEAVES.get().asItem())
                .add(EMBlocks.YELLOW_AMBERWOOD_LEAVES.get().asItem())
                .add(EMBlocks.GREEN_AMBERWOOD_LEAVES.get().asItem())
                .add(EMBlocks.FROSTPINE_LEAVES.get().asItem());

        tag(ItemTags.SAPLINGS)
                .add(EMBlocks.GLIMMERING_ANCIENT_SAPLING.get().asItem())
                .add(EMBlocks.ANCIENT_SAPLING.get().asItem())
                .add(EMBlocks.SLIMY_SAPLING.get().asItem())
                .add(EMBlocks.GREEN_AMBERWOOD_SAPLING.get().asItem())
                .add(EMBlocks.RED_AMBERWOOD_SAPLING.get().asItem())
                .add(EMBlocks.ORANGE_AMBERWOOD_SAPLING.get().asItem())
                .add(EMBlocks.YELLOW_AMBERWOOD_SAPLING.get().asItem())
                .add(EMBlocks.CHARRED_SAPLING.get().asItem())
                .add(EMBlocks.FROSTPINE_SAPLING.get().asItem());

        tag(ItemTags.FLOWERS)
                .add(EMBlocks.GLIMMERBUD.get().asItem())
                .add(EMBlocks.SLIMY_ALLIUM.get().asItem())
                .add(EMBlocks.WITCH_LAVENDER.get().asItem())
                .add(EMBlocks.DAWNING_HYACINTH.get().asItem())
                .add(EMBlocks.CINDERBLOOM.get().asItem())
                .add(EMBlocks.NIGHTBELL.get().asItem())
                .add(EMBlocks.CHRONOTHORN.get().asItem());

        tag(ItemTags.SMALL_FLOWERS)
                .add(EMBlocks.GLIMMERBUD.get().asItem())
                .add(EMBlocks.SLIMY_ALLIUM.get().asItem())
                .add(EMBlocks.WITCH_LAVENDER.get().asItem())
                .add(EMBlocks.DAWNING_HYACINTH.get().asItem())
                .add(EMBlocks.CINDERBLOOM.get().asItem())
                .add(EMBlocks.NIGHTBELL.get().asItem())
                .add(EMBlocks.CHRONOTHORN.get().asItem());

        tag(EMTags.Items.TOMES)
                .add(EMItems.EXCLUSION_TOME.get())
                .add(EMItems.AUGMENT_TOME.get())
                .add(EMItems.WAND_TOME.get())
                .add(EMItems.MAIN_SPELL_TOME.get())
                .add(EMItems.BASE_SPELL_TOME.get());

        tag(EMTags.Items.WANDS).add(EMItems.WAND_TOME.get());

        tag(EMTags.Items.MAGIC_ENCHANTABLE)
                .add(EMItems.WAND_TOME.get())
                .add(EMItems.AUGMENT_TOME.get())
                .add(EMItems.MAIN_SPELL_TOME.get())
                .add(EMItems.BASE_SPELL_TOME.get())
                .add(EMItems.EXCLUSION_TOME.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(EMItems.WAND_TOME.get())
                .add(EMItems.BASE_SPELL_TOME.get());

        tag(EMTags.Items.ENCHANTABLE_BASE)
                .addTag(EMTags.Items.WANDS)
                .add(EMItems.BASE_SPELL_TOME.get());

        tag(EMTags.Items.ENCHANTABLE_EXCLUSIONS)
                .add(EMItems.EXCLUSION_TOME.get());

        tag(EMTags.Items.ENCHANTABLE_AUGMENTS)
                .addTag(EMTags.Items.WANDS)
                .add(EMItems.AUGMENT_TOME.get());

        tag(EMTags.Items.ENCHANTABLE_MAIN_SPELLS)
                .addTag(EMTags.Items.WANDS)
                .add(EMItems.MAIN_SPELL_TOME.get());

        tag(ItemTags.MACE_ENCHANTABLE).add(EMItems.HEAVY_WAND.get());

        tag(Tags.Items.PLAYER_WORKSTATIONS_CRAFTING_TABLES).add(EMBlocks.WANDFORGING_TABLE.get().asItem());

        /*
        ---------- Foods ----------
         */

        tag(Tags.Items.MUSHROOMS)
                .add(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get().asItem())
                .add(EMBlocks.ABYSSAL_MUSHROOM.get().asItem())
                .add(EMBlocks.TALL_ABYSSAL_MUSHROOM.get().asItem());

        tag(Tags.Items.FOODS)
                .add(EMItems.SHROOM_CLUSTER.get())
                .add(EMItems.TOASTED_SHROOM_CLUSTER.get());

        tag(Tags.Items.FOODS_VEGETABLE)
                .add(EMItems.SHROOM_CLUSTER.get())
                .add(EMItems.TOASTED_SHROOM_CLUSTER.get());

        /*
        ---------- Wand Stuff ----------
         */

        tag(EMTags.Items.ORBS)
                .add(EMItems.DULL_ORB.get())
                .add(EMItems.POISON_ORB.get())
                .add(EMItems.LEVITATION_ORB.get())
                .add(EMItems.WITHER_ORB.get())
                .add(EMItems.FLAME_ORB.get())
                .add(EMItems.WITCH_ORB.get())
                .add(EMItems.FROZEN_ORB.get())
                .add(EMItems.GLASS_ORB.get())
                .add(EMItems.GLIMMERBUG_ORB.get())
                .add(EMItems.FORGEMASTER_HEART_ORB.get());

        tag(EMTags.Items.DYEABLE_WANDS)
                .add(EMItems.WOODEN_WAND_HANDLE.get())
                .add(EMItems.EMERALD_WAND_HANDLE.get())
                .add(EMItems.DIAMOND_WAND_HANDLE.get())
                .add(EMItems.GOLDEN_WAND_HANDLE.get())
                .add(EMItems.LAPIS_WAND_HANDLE.get())
                .add(EMItems.QUARTZ_WAND_HANDLE.get())
                .add(EMItems.REDSTONE_WAND_HANDLE.get())
                .add(EMItems.GLOWSTONE_WAND_HANDLE.get())
                .add(EMItems.PRISMARINE_WAND_HANDLE.get())
                .add(EMItems.NETHERITE_WAND_HANDLE.get());

        tag(EMTags.Items.WAND_BASE)
                .add(EMItems.WOODEN_WAND_HANDLE.get())
                .add(EMItems.EMERALD_WAND_HANDLE.get())
                .add(EMItems.DIAMOND_WAND_HANDLE.get())
                .add(EMItems.GOLDEN_WAND_HANDLE.get())
                .add(EMItems.LAPIS_WAND_HANDLE.get())
                .add(EMItems.QUARTZ_WAND_HANDLE.get())
                .add(EMItems.REDSTONE_WAND_HANDLE.get())
                .add(EMItems.GLOWSTONE_WAND_HANDLE.get())
                .add(EMItems.PRISMARINE_WAND_HANDLE.get())
                .add(EMItems.NETHERITE_WAND_HANDLE.get());

        // ---------- Wands ----------
        addWands(EMItems.DULL_WAND.get());
        addWands(EMItems.FLAME_WAND.get());
        addWands(EMItems.POISON_WAND.get());
        addWands(EMItems.LEVITATION_WAND.get());
        addWands(EMItems.WITHER_WAND.get());
        addWands(EMItems.WITCH_WAND.get());
        addWands(EMItems.HEAVY_WAND.get());
        addWands(EMItems.FROZEN_WAND.get());
        addWands(EMItems.GLASS_WAND.get());
        addWands(EMItems.GLIMMERBUG_WAND.get());
        addWands(EMItems.FORGED_HEART_WAND.get());

        addRedstone(EMBlocks.ETHERSTONE_BUTTON.get().asItem(), EMBlocks.ETHERSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.ANCIENT_ETHERSTONE_BUTTON.get().asItem(), EMBlocks.ANCIENT_ETHERSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.POLISHED_WITCHSTONE_BUTTON.get().asItem(), EMBlocks.POLISHED_WITCHSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.POLISHED_DAWNSHALE_BUTTON.get().asItem(), EMBlocks.POLISHED_DAWNSHALE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.GLIMMERING_ANCIENT_BUTTON.get().asItem(), EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.ANCIENT_BUTTON.get().asItem(), EMBlocks.ANCIENT_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.SLIMY_BUTTON.get().asItem(), EMBlocks.SLIMY_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.FROSTPINE_BUTTON.get().asItem(), EMBlocks.FROSTPINE_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.SPARKLING_SANDSTONE_BUTTON.get().asItem(), EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON.get().asItem(), EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE.get().asItem(), false);
        addRedstone(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get().asItem(), EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.AMBERWOOD_BUTTON.get().asItem(), EMBlocks.AMBERWOOD_PRESSURE_PLATE.get().asItem(), true);
        addRedstone(EMBlocks.CHARRED_BUTTON.get().asItem(), EMBlocks.CHARRED_PRESSURE_PLATE.get().asItem(), true);

        addFences(EMBlocks.GLIMMERING_ANCIENT_FENCE.get().asItem(), true);
        addFences(EMBlocks.ANCIENT_FENCE.get().asItem(), true);
        addFences(EMBlocks.SLIMY_FENCE.get().asItem(), true);
        addFences(EMBlocks.FROSTPINE_FENCE.get().asItem(), true);
        addFences(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get().asItem(), true);
        addFences(EMBlocks.AMBERWOOD_FENCE.get().asItem(), true);
        addFences(EMBlocks.CHARRED_FENCE.get().asItem(), true);

        addLogs(EMBlocks.GLIMMERING_ANCIENT_LOG.get().asItem(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get().asItem(), EMBlocks.GLIMMERING_ANCIENT_WOOD.get().asItem(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get().asItem(), true);
        addLogs(EMBlocks.ANCIENT_LOG.get().asItem(), EMBlocks.STRIPPED_ANCIENT_LOG.get().asItem(), EMBlocks.ANCIENT_WOOD.get().asItem(), EMBlocks.STRIPPED_ANCIENT_WOOD.get().asItem(), true);
        addLogs(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().asItem(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get().asItem(), EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get().asItem(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get().asItem(), true);
        addLogs(EMBlocks.SLIMY_LOG.get().asItem(), EMBlocks.STRIPPED_SLIMY_LOG.get().asItem(), EMBlocks.SLIMY_WOOD.get().asItem(), EMBlocks.STRIPPED_SLIMY_WOOD.get().asItem(), true);
        addLogs(EMBlocks.FROSTPINE_LOG.get().asItem(), EMBlocks.STRIPPED_FROSTPINE_LOG.get().asItem(), EMBlocks.FROSTPINE_WOOD.get().asItem(), EMBlocks.STRIPPED_FROSTPINE_WOOD.get().asItem(), true);
        addLogs(EMBlocks.AMBERWOOD_LOG.get().asItem(), EMBlocks.STRIPPED_AMBERWOOD_LOG.get().asItem(), EMBlocks.AMBERWOOD_WOOD.get().asItem(), EMBlocks.STRIPPED_AMBERWOOD_WOOD.get().asItem(), true);
        addLogs(EMBlocks.CHARRED_LOG.get().asItem(), EMBlocks.STRIPPED_CHARRED_LOG.get().asItem(), EMBlocks.CHARRED_WOOD.get().asItem(), EMBlocks.STRIPPED_CHARRED_WOOD.get().asItem(), false);

        addDoors(EMBlocks.GLIMMERING_ANCIENT_DOOR.get().asItem(), true);
        addDoors(EMBlocks.ANCIENT_DOOR.get().asItem(), true);
        addDoors(EMBlocks.SLIMY_DOOR.get().asItem(), true);
        addDoors(EMBlocks.FROSTPINE_DOOR.get().asItem(), true);
        addDoors(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get().asItem(), true);
        addDoors(EMBlocks.AMBERWOOD_DOOR.get().asItem(), true);
        addDoors(EMBlocks.CHARRED_DOOR.get().asItem(), true);

        /*
        ----------  Ores ----------
         */

        tag(Tags.Items.ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ETHERSTONE_COAL_ORE.get().asItem())
                .add(EMBlocks.ETHERSTONE_REDSTONE_ORE.get().asItem())
                .add(EMBlocks.ETHERSTONE_DIAMOND_ORE.get().asItem())
                .add(EMBlocks.ETHERSTONE_LAPIS_ORE.get().asItem())
                .add(EMBlocks.ETHERSTONE_EMERALD_ORE.get().asItem())
                .add(EMBlocks.ETHERSTONE_GOLD_ORE.get().asItem())
                .add(EMBlocks.ETHERSTONE_COPPER_ORE.get().asItem())

                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COAL_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get().asItem());

        // Ore Specific
        tag(ItemTags.COPPER_ORES)
                .add(EMBlocks.ETHERSTONE_COPPER_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get().asItem());
        tag(Tags.Items.ORES_COPPER)
                .add(EMBlocks.ETHERSTONE_COPPER_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get().asItem());

        tag(ItemTags.IRON_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());
        tag(Tags.Items.ORES_IRON)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());

        tag(ItemTags.GOLD_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());
        tag(Tags.Items.ORES_GOLD)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());

        tag(ItemTags.COAL_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());
        tag(Tags.Items.ORES_COAL)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());

        tag(ItemTags.DIAMOND_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());
        tag(Tags.Items.ORES_DIAMOND)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());

        tag(ItemTags.EMERALD_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());
        tag(Tags.Items.ORES_EMERALD)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());

        tag(ItemTags.LAPIS_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());
        tag(Tags.Items.ORES_LAPIS)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());

        tag(ItemTags.REDSTONE_ORES)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());
        tag(Tags.Items.ORES_REDSTONE)
                .add(EMBlocks.ETHERSTONE_IRON_ORE.get().asItem())
                .add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get().asItem());

    }

    // Functions to make sure I don't miss any tags

    private void addWands(Item wand) {
        tag(EMTags.Items.WANDS).add(wand);
        tag(EMTags.Items.MAGIC_ENCHANTABLE).add(wand);
        tag(ItemTags.DURABILITY_ENCHANTABLE).add(wand);
        tag(EMTags.Items.DYEABLE_WANDS).add(wand);
        tag(EMTags.Items.WAND_BASE).add(wand);
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
        else {
            tag(ItemTags.NON_FLAMMABLE_WOOD).add(log).add(stripped_log).add(wood).add(stripped_wood);
        }

    }

}
