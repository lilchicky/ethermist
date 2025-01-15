package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
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
        dropSelf(EMBlocks.ETHERSTONE.get());
        dropSelf(EMBlocks.ETHERSTONE_STAIRS.get());
        add(EMBlocks.ETHERSTONE_SLAB.get(),
                block -> createSlabItemTable(EMBlocks.ETHERSTONE_SLAB.get()));
        dropSelf(EMBlocks.ETHERSTONE_PRESSURE_PLATE.get());
        dropSelf(EMBlocks.ETHERSTONE_BUTTON.get());
        dropSelf(EMBlocks.ETHERSTONE_WALL.get());

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

        // Rich Dirt
        dropSelf(EMBlocks.RICH_DIRT.get());
        add(EMBlocks.RICH_GRASS.get(),
            block -> createSilkTouchDispatchTable(EMBlocks.RICH_GRASS.get(),
                    LootItem.lootTableItem(EMBlocks.RICH_DIRT.get())
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));

        add(EMBlocks.MIST_GEM_ORE.get(),
                block -> createMultipleOreDrops(EMBlocks.MIST_GEM_ORE.get(), EMItems.MIST_GEM.get(), 1, 3));

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
