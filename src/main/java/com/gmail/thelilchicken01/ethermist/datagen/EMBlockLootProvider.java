package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class EMBlockLootProvider extends BlockLootSubProvider {

    protected EMBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(EMBlocks.GLIMMERBUG_HIVE.get());

        // Etherstone
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
        dropSelf(EMBlocks.GLIMMER_BLOSSOM.get());
        add(EMBlocks.GLIMMER_BLOSSOM_FLOWER_POT.get(),
                block -> createPotFlowerItemTable(EMBlocks.GLIMMER_BLOSSOM.get().asItem()));

        dropSelf(EMBlocks.NIGHTBELL.get());
        add(EMBlocks.NIGHTBELL_FLOWER_POT.get(),
                block -> createPotFlowerItemTable(EMBlocks.NIGHTBELL.get().asItem()));

        dropSelf(EMBlocks.WITCH_LAVENDER.get());
        add(EMBlocks.WITCH_LAVENDER_FLOWER_POT.get(),
                block -> createPotFlowerItemTable(EMBlocks.WITCH_LAVENDER.get().asItem()));

        dropSelf(EMBlocks.SLIMY_ALLIUM.get());

        add(EMBlocks.RICH_GRASS.get(),
                block -> createGrassDrops(EMBlocks.RICH_GRASS.get()));

        // Abyssal Mushrooms
        dropSelf(EMBlocks.BLUE_ABYSSAL_MUSHROOM_TOP.get());
        dropSelf(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_TOP.get());
        dropSelf(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM.get());
        dropSelf(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM.get());

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

        add(EMBlocks.MIST_GEM_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.MIST_GEM_ORE.get(), EMItems.GENERIC_SHOT.get(), 1, 3));

        // Misc
        dropSelf(EMBlocks.ICICLE.get());

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
}
