package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class EMBlockLootProvider extends BlockLootSubProvider {

    public EMBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(EMBlocks.GLIMMERBUG_HIVE.get());

        // Etherstone
        dropSelf(EMBlocks.MOLTEN_ETHERSTONE.get());

        add(EMBlocks.ETHERSTONE.get(),
                block -> createSilkTouchDispatchTable(EMBlocks.ETHERSTONE.get(),
                        LootItem.lootTableItem(EMBlocks.COBBLED_ETHERSTONE.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));
        dropSelf(EMBlocks.ETHERSTONE_STAIRS.get());
        add(EMBlocks.ETHERSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.ETHERSTONE_SLAB.get()));
        dropSelf(EMBlocks.ETHERSTONE_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.ETHERSTONE_BUTTON.get());
        dropSelf(EMBlocks.ETHERSTONE_WALL.get());

        dropSelf(EMBlocks.ETHERSTONE_BRICKS.get());
        dropSelf(EMBlocks.ETHERSTONE_BRICK_STAIRS.get());
        add(EMBlocks.ETHERSTONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.ETHERSTONE_BRICK_SLAB.get()));
        dropSelf(EMBlocks.ETHERSTONE_BRICK_WALL.get());

        // Witchstone
        dropSelf(EMBlocks.WITCHSTONE.get());
        dropSelf(EMBlocks.WITCHSTONE_STAIRS.get());
        add(EMBlocks.WITCHSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.WITCHSTONE_SLAB.get()));
        dropSelf(EMBlocks.WITCHSTONE_WALL.get());

        // Polished Witchstone
        dropSelf(EMBlocks.POLISHED_WITCHSTONE.get());
        dropSelf(EMBlocks.POLISHED_WITCHSTONE_STAIRS.get());
        add(EMBlocks.POLISHED_WITCHSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.POLISHED_WITCHSTONE_SLAB.get()));
        dropSelf(EMBlocks.POLISHED_WITCHSTONE_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.POLISHED_WITCHSTONE_BUTTON.get());
        dropSelf(EMBlocks.POLISHED_WITCHSTONE_WALL.get());

        // Dawnshale
        dropSelf(EMBlocks.DAWNSHALE.get());
        dropSelf(EMBlocks.DAWNSHALE_STAIRS.get());
        add(EMBlocks.DAWNSHALE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.DAWNSHALE_SLAB.get()));
        dropSelf(EMBlocks.DAWNSHALE_WALL.get());

        // Polished Dawnshale
        dropSelf(EMBlocks.POLISHED_DAWNSHALE.get());
        dropSelf(EMBlocks.POLISHED_DAWNSHALE_STAIRS.get());
        add(EMBlocks.POLISHED_DAWNSHALE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.POLISHED_DAWNSHALE_SLAB.get()));
        dropSelf(EMBlocks.POLISHED_DAWNSHALE_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.POLISHED_DAWNSHALE_BUTTON.get());
        dropSelf(EMBlocks.POLISHED_DAWNSHALE_WALL.get());

        // Ancient Etherstone
        dropSelf(EMBlocks.ANCIENT_ETHERSTONE.get());
        dropSelf(EMBlocks.ANCIENT_ETHERSTONE_STAIRS.get());
        add(EMBlocks.ANCIENT_ETHERSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.ANCIENT_ETHERSTONE_SLAB.get()));
        dropSelf(EMBlocks.ANCIENT_ETHERSTONE_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.ANCIENT_ETHERSTONE_BUTTON.get());
        dropSelf(EMBlocks.ANCIENT_ETHERSTONE_WALL.get());

        dropSelf(EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get());
        dropSelf(EMBlocks.ANCIENT_ETHERSTONE_BRICK_STAIRS.get());
        add(EMBlocks.ANCIENT_ETHERSTONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.ANCIENT_ETHERSTONE_BRICK_SLAB.get()));
        dropSelf(EMBlocks.ANCIENT_ETHERSTONE_BRICK_WALL.get());

        // Cobbled Etherstone
        dropSelf(EMBlocks.COBBLED_ETHERSTONE.get());
        dropSelf(EMBlocks.COBBLED_ETHERSTONE_STAIRS.get());
        add(EMBlocks.COBBLED_ETHERSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.COBBLED_ETHERSTONE_SLAB.get()));
        dropSelf(EMBlocks.COBBLED_ETHERSTONE_WALL.get());

        // Mossy Cobbled Etherstone
        dropSelf(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get());
        dropSelf(EMBlocks.MOSSY_COBBLED_ETHERSTONE_STAIRS.get());
        add(EMBlocks.MOSSY_COBBLED_ETHERSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.MOSSY_COBBLED_ETHERSTONE_SLAB.get()));
        dropSelf(EMBlocks.MOSSY_COBBLED_ETHERSTONE_WALL.get());

        // Glimmering Ancient Wood
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_LOG.get());
        dropSelf(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get());
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_WOOD.get());
        dropSelf(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get());
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get());
        this.add(EMBlocks.ANCIENT_LEAVES.get(), block ->
                createLeavesDrops(block, EMBlocks.GLIMMERING_ANCIENT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_SAPLING.get());
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_STAIRS.get());
        add(EMBlocks.GLIMMERING_ANCIENT_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.GLIMMERING_ANCIENT_SLAB.get()));
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_BUTTON.get());
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_FENCE.get());
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE.get());
        add(EMBlocks.GLIMMERING_ANCIENT_DOOR.get(),
                block -> createDoorTable(EMBlocks.GLIMMERING_ANCIENT_DOOR.get()));
        dropSelf(EMBlocks.GLIMMERING_ANCIENT_TRAPDOOR.get());

        add(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(),
                block -> createSilkTouchDispatchTable(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(),
                        LootItem.lootTableItem(EMBlocks.GLIMMERING_ANCIENT_LOG.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));
        add(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(),
                block -> createSilkTouchDispatchTable(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(),
                        LootItem.lootTableItem(EMBlocks.GLIMMERING_ANCIENT_WOOD.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));
        add(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(),
                block -> createSilkTouchDispatchTable(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(),
                        LootItem.lootTableItem(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));
        add(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(),
                block -> createSilkTouchDispatchTable(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(),
                        LootItem.lootTableItem(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));

        // Ancient Wood
        dropSelf(EMBlocks.ANCIENT_LOG.get());
        dropSelf(EMBlocks.STRIPPED_ANCIENT_LOG.get());
        dropSelf(EMBlocks.ANCIENT_WOOD.get());
        dropSelf(EMBlocks.STRIPPED_ANCIENT_WOOD.get());
        dropSelf(EMBlocks.ANCIENT_PLANKS.get());
        this.add(EMBlocks.ANCIENT_LEAVES.get(), block ->
                createLeavesDrops(block, EMBlocks.ANCIENT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(EMBlocks.ANCIENT_SAPLING.get());
        dropSelf(EMBlocks.ANCIENT_STAIRS.get());
        add(EMBlocks.ANCIENT_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.ANCIENT_SLAB.get()));
        dropSelf(EMBlocks.ANCIENT_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.ANCIENT_BUTTON.get());
        dropSelf(EMBlocks.ANCIENT_FENCE.get());
        dropSelf(EMBlocks.ANCIENT_FENCE_GATE.get());
        add(EMBlocks.ANCIENT_DOOR.get(),
                block -> createDoorTable(EMBlocks.ANCIENT_DOOR.get()));
        dropSelf(EMBlocks.ANCIENT_TRAPDOOR.get());

        // Slimy Wood
        dropSelf(EMBlocks.SLIMY_LOG.get());
        dropSelf(EMBlocks.STRIPPED_SLIMY_LOG.get());
        dropSelf(EMBlocks.SLIMY_WOOD.get());
        dropSelf(EMBlocks.STRIPPED_SLIMY_WOOD.get());
        dropSelf(EMBlocks.SLIMY_PLANKS.get());
        this.add(EMBlocks.SLIMY_LEAVES.get(), block ->
                createLeavesDrops(block, EMBlocks.SLIMY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(EMBlocks.SLIMY_SAPLING.get());
        dropSelf(EMBlocks.SLIMY_STAIRS.get());
        add(EMBlocks.SLIMY_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.SLIMY_SLAB.get()));
        dropSelf(EMBlocks.SLIMY_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.SLIMY_BUTTON.get());
        dropSelf(EMBlocks.SLIMY_FENCE.get());
        dropSelf(EMBlocks.SLIMY_FENCE_GATE.get());
        add(EMBlocks.SLIMY_DOOR.get(),
                block -> createDoorTable(EMBlocks.SLIMY_DOOR.get()));
        dropSelf(EMBlocks.SLIMY_TRAPDOOR.get());

        // Frostpine Wood
        dropSelf(EMBlocks.FROSTPINE_LOG.get());
        dropSelf(EMBlocks.STRIPPED_FROSTPINE_LOG.get());
        dropSelf(EMBlocks.FROSTPINE_WOOD.get());
        dropSelf(EMBlocks.STRIPPED_FROSTPINE_WOOD.get());
        dropSelf(EMBlocks.FROSTPINE_PLANKS.get());
        this.add(EMBlocks.FROSTPINE_LEAVES.get(), block ->
                createLeavesDrops(block, EMBlocks.FROSTPINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(EMBlocks.FROSTPINE_SAPLING.get());
        dropSelf(EMBlocks.FROSTPINE_STAIRS.get());
        add(EMBlocks.FROSTPINE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.FROSTPINE_SLAB.get()));
        dropSelf(EMBlocks.FROSTPINE_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.FROSTPINE_BUTTON.get());
        dropSelf(EMBlocks.FROSTPINE_FENCE.get());
        dropSelf(EMBlocks.FROSTPINE_FENCE_GATE.get());
        add(EMBlocks.FROSTPINE_DOOR.get(),
                block -> createDoorTable(EMBlocks.FROSTPINE_DOOR.get()));
        dropSelf(EMBlocks.FROSTPINE_TRAPDOOR.get());

        // Amberwood Wood
        dropSelf(EMBlocks.AMBERWOOD_LOG.get());
        dropSelf(EMBlocks.STRIPPED_AMBERWOOD_LOG.get());
        dropSelf(EMBlocks.AMBERWOOD_WOOD.get());
        dropSelf(EMBlocks.STRIPPED_AMBERWOOD_WOOD.get());
        dropSelf(EMBlocks.AMBERWOOD_PLANKS.get());
        this.add(EMBlocks.RED_AMBERWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, EMBlocks.RED_AMBERWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(EMBlocks.ORANGE_AMBERWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, EMBlocks.ORANGE_AMBERWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(EMBlocks.YELLOW_AMBERWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, EMBlocks.YELLOW_AMBERWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(EMBlocks.GREEN_AMBERWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, EMBlocks.GREEN_AMBERWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(EMBlocks.GREEN_AMBERWOOD_SAPLING.get());
        dropSelf(EMBlocks.RED_AMBERWOOD_SAPLING.get());
        dropSelf(EMBlocks.ORANGE_AMBERWOOD_SAPLING.get());
        dropSelf(EMBlocks.YELLOW_AMBERWOOD_SAPLING.get());
        dropSelf(EMBlocks.AMBERWOOD_STAIRS.get());
        add(EMBlocks.AMBERWOOD_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.AMBERWOOD_SLAB.get()));
        dropSelf(EMBlocks.AMBERWOOD_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.AMBERWOOD_BUTTON.get());
        dropSelf(EMBlocks.AMBERWOOD_FENCE.get());
        dropSelf(EMBlocks.AMBERWOOD_FENCE_GATE.get());
        add(EMBlocks.AMBERWOOD_DOOR.get(),
                block -> createDoorTable(EMBlocks.AMBERWOOD_DOOR.get()));
        dropSelf(EMBlocks.AMBERWOOD_TRAPDOOR.get());

        // Ashen Wood
        dropSelf(EMBlocks.CHARRED_LOG.get());
        dropSelf(EMBlocks.STRIPPED_CHARRED_LOG.get());
        dropSelf(EMBlocks.CHARRED_WOOD.get());
        dropSelf(EMBlocks.STRIPPED_CHARRED_WOOD.get());
        dropSelf(EMBlocks.CHARRED_PLANKS.get());
        dropSelf(EMBlocks.CHARRED_SAPLING.get());
        dropSelf(EMBlocks.CHARRED_STAIRS.get());
        add(EMBlocks.CHARRED_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.CHARRED_SLAB.get()));
        dropSelf(EMBlocks.CHARRED_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.CHARRED_BUTTON.get());
        dropSelf(EMBlocks.CHARRED_FENCE.get());
        dropSelf(EMBlocks.CHARRED_FENCE_GATE.get());
        add(EMBlocks.CHARRED_DOOR.get(),
                block -> createDoorTable(EMBlocks.CHARRED_DOOR.get()));
        dropSelf(EMBlocks.CHARRED_TRAPDOOR.get());

        // Sparkling Sand
        dropSelf(EMBlocks.SPARKLING_SAND.get());
        dropSelf(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get());
        dropSelf(EMBlocks.SPARKLING_SANDSTONE.get());

        dropSelf(EMBlocks.SPARKLING_SANDSTONE_STAIRS.get());
        add(EMBlocks.SPARKLING_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.SPARKLING_SANDSTONE_SLAB.get()));
        dropSelf(EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.SPARKLING_SANDSTONE_BUTTON.get());
        dropSelf(EMBlocks.SPARKLING_SANDSTONE_WALL.get());

        dropSelf(EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS.get());
        add(EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB.get()));
        dropSelf(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL.get());

        // Timesworn Sand
        dropSelf(EMBlocks.TIMEWORN_SAND.get());
        dropSelf(EMBlocks.TIMEWORN_SANDSTONE.get());
        dropSelf(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get());
        dropSelf(EMBlocks.CHISELED_TIMEWORN_SANDSTONE.get());

        dropSelf(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS.get());
        add(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get()));
        dropSelf(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON.get());
        dropSelf(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get());

        dropSelf(EMBlocks.TIMEWORN_SANDSTONE_STAIRS.get());
        add(EMBlocks.TIMEWORN_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.TIMEWORN_SANDSTONE_SLAB.get()));
        dropSelf(EMBlocks.TIMEWORN_SANDSTONE_WALL.get());

        // Crumbling Etherstone
        dropSelf(EMBlocks.CRUMBLING_ETHERSTONE.get());

        // Rich Dirt
        dropSelf(EMBlocks.RICH_DIRT.get());
        add(EMBlocks.RICH_GRASS_BLOCK.get(),
                block -> createSilkTouchDispatchTable(EMBlocks.RICH_GRASS_BLOCK.get(),
                        LootItem.lootTableItem(EMBlocks.RICH_DIRT.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));

        // Flowers
        dropSelf(EMBlocks.GLIMMERBUD.get());
        add(EMBlocks.GLIMMERBUD_FLOWER_POT.get(),
                block -> createPotFlowerItemTable(EMBlocks.GLIMMERBUD.get().asItem()));

        dropSelf(EMBlocks.NIGHTBELL.get());
        add(EMBlocks.NIGHTBELL_FLOWER_POT.get(),
                block -> createPotFlowerItemTable(EMBlocks.NIGHTBELL.get().asItem()));

        dropSelf(EMBlocks.WITCH_LAVENDER.get());
        add(EMBlocks.WITCH_LAVENDER_FLOWER_POT.get(),
                block -> createPotFlowerItemTable(EMBlocks.WITCH_LAVENDER.get().asItem()));

        dropSelf(EMBlocks.DAWNING_HYACINTH.get());
        add(EMBlocks.DAWNING_HYACINTH_FLOWER_POT.get(),
                block -> createPotFlowerItemTable(EMBlocks.DAWNING_HYACINTH.get().asItem()));

        add(EMBlocks.CINDERBLOOM.get(), generateMultiblockDrops(EMBlocks.CINDERBLOOM.get(), false));
        add(EMBlocks.FALLEN_AMBERWOOD_LEAVES.get(), generateMultiblockDrops(EMBlocks.FALLEN_AMBERWOOD_LEAVES.get(), true));

        dropSelf(EMBlocks.SLIMY_ALLIUM.get());
        dropSelf(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get());
        add(EMBlocks.TALL_ABYSSAL_MUSHROOM.get(),
                block -> generateDoubleBlockShearsDrops(
                        EMBlocks.TALL_ABYSSAL_MUSHROOM.get(),
                        EMBlocks.SMALL_ABYSSAL_MUSHROOM.get(),
                        EMBlocks.TALL_ABYSSAL_MUSHROOM.get(),
                        1.0f
                )
        );
        add(EMBlocks.ABYSSAL_MUSHROOM.get(),
                block -> createSimpleMushroomDrops(
                        EMBlocks.ABYSSAL_MUSHROOM.get(),
                        EMBlocks.SMALL_ABYSSAL_MUSHROOM.get()
                )
        );

        add(EMBlocks.RICH_GRASS.get(),
                block -> createGrassDrops(EMBlocks.RICH_GRASS.get()));
        add(EMBlocks.RICH_TALL_GRASS.get(),
                block -> generateDoubleBlockShearsDrops(
                        EMBlocks.RICH_TALL_GRASS.get(),
                        Items.WHEAT_SEEDS,
                        EMBlocks.RICH_TALL_GRASS.get(),
                        0.125f
                )
        );

        // Abyssal Mushrooms
        dropSelf(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP.get());
        dropSelf(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP.get());
        dropSelf(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get());
        dropSelf(EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS.get());

        dropSelf(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get());
        dropSelf(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS.get());
        add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get()));
        dropSelf(EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get());
        dropSelf(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get());
        dropSelf(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get());
        add(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get(),
                block -> createDoorTable(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get()));
        dropSelf(EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR.get());

        // Ores
        add(EMBlocks.ETHERSTONE_COPPER_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ETHERSTONE_COPPER_ORE.get(), Items.RAW_COPPER, 2, 5));

        add(EMBlocks.ETHERSTONE_COAL_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ETHERSTONE_COAL_ORE.get(), Items.COAL, 1, 1));

        add(EMBlocks.ETHERSTONE_IRON_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ETHERSTONE_IRON_ORE.get(), Items.RAW_IRON, 1, 1));

        add(EMBlocks.ETHERSTONE_GOLD_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ETHERSTONE_GOLD_ORE.get(), Items.RAW_GOLD, 1, 1));

        add(EMBlocks.ETHERSTONE_REDSTONE_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ETHERSTONE_REDSTONE_ORE.get(), Items.REDSTONE, 4, 5));

        add(EMBlocks.ETHERSTONE_LAPIS_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ETHERSTONE_LAPIS_ORE.get(), Items.LAPIS_LAZULI, 4, 8));

        add(EMBlocks.ETHERSTONE_DIAMOND_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ETHERSTONE_DIAMOND_ORE.get(), Items.DIAMOND, 1, 1));

        add(EMBlocks.ETHERSTONE_EMERALD_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ETHERSTONE_EMERALD_ORE.get(), Items.EMERALD, 1, 1));


        add(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ANCIENT_ETHERSTONE_COPPER_ORE.get(), Items.RAW_COPPER, 2, 5));

        add(EMBlocks.ANCIENT_ETHERSTONE_COAL_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ANCIENT_ETHERSTONE_COAL_ORE.get(), Items.COAL, 1, 1));

        add(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ANCIENT_ETHERSTONE_IRON_ORE.get(), Items.RAW_IRON, 1, 1));

        add(EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ANCIENT_ETHERSTONE_GOLD_ORE.get(), Items.RAW_GOLD, 1, 1));

        add(EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ANCIENT_ETHERSTONE_REDSTONE_ORE.get(), Items.REDSTONE, 4, 5));

        add(EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ANCIENT_ETHERSTONE_LAPIS_ORE.get(), Items.LAPIS_LAZULI, 4, 8));

        add(EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ANCIENT_ETHERSTONE_DIAMOND_ORE.get(), Items.DIAMOND, 1, 1));

        add(EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.ANCIENT_ETHERSTONE_EMERALD_ORE.get(), Items.EMERALD, 1, 1));

        // Misc
        dropSelf(EMBlocks.ICICLE.get());
        dropSelf(EMBlocks.WANDFORGING_TABLE.get());

    }

    // By kaupenjoe
    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> lookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                        .apply(ApplyBonusCount.addOreBonusCount(lookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EMBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    protected LootTable.Builder createSimpleMushroomDrops(Block block, Block noShears) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .when(AnyOfCondition.anyOf(
                                        HAS_SHEARS,
                                        hasSilkTouch()
                                ))
                                .otherwise(
                                        ((LootPoolSingletonContainer.Builder<?>) this.applyExplosionCondition(block, LootItem.lootTableItem(noShears)))
                                                .when(LootItemRandomChanceCondition.randomChance(1.0f))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                        )
                );

    }

    private LootTable.Builder generateMultiblockDrops(Block block, boolean requiresSilkOrShears) {

        IntegerProperty flower_amount = IntegerProperty.create("flower_amount", 1, 4);

        LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F));

        if (requiresSilkOrShears) {
            poolBuilder.when(AnyOfCondition.anyOf(
                            HAS_SHEARS,
                            hasSilkTouch()
                    )
            );
        }

        for (int flowerCount : flower_amount.getPossibleValues()) {
            poolBuilder.add(LootItem.lootTableItem(block)
                    .when(LootItemBlockStatePropertyCondition
                            .hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                    .hasProperty(flower_amount, flowerCount)))
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(flowerCount))));
        }

        return LootTable.lootTable().withPool(poolBuilder);
    }

    protected LootTable.Builder generateDoubleBlockShearsDrops(Block block, ItemLike noShears, Block sheared, float otherwiseChance) {

        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(sheared)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                .when(AnyOfCondition.anyOf(
                        HAS_SHEARS,
                        hasSilkTouch()
                ))
                .otherwise(
                        ((LootPoolSingletonContainer.Builder<?>) this.applyExplosionCondition(block, LootItem.lootTableItem(noShears)))
                                .when(LootItemRandomChanceCondition.randomChance(otherwiseChance))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                );
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .add(builder)
                                .when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))
                                )
                                .when(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location()
                                                        .setBlock(
                                                                BlockPredicate.Builder.block()
                                                                        .of(block)
                                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))
                                                        ),
                                                new BlockPos(0, 1, 0)
                                        )
                                )
                )
                .withPool(
                        LootPool.lootPool()
                                .add(builder)
                                .when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))
                                )
                                .when(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location()
                                                        .setBlock(
                                                                BlockPredicate.Builder.block()
                                                                        .of(block)
                                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))
                                                        ),
                                                new BlockPos(0, -1, 0)
                                        )
                                )
                );
    }

}
