package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class EMChestLootTableProvider implements LootTableSubProvider {

    private final HolderLookup.Provider registries;

    public EMChestLootTableProvider(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> writer) {
        writer.accept(
                EMLootTables.FORGEMASTER_GENERIC,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0f, 4.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 1, 3, 3))
                                .add(EMLootTableUtil.singleDrop(EMItems.WOODEN_WAND_HANDLE, 1))
                ).withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(EMLootTableUtil.singleDrop(Items.DIAMOND, 1))
                                .add(EMLootTableUtil.enchantedItem(Items.BOOK, 1, this.registries))
                )
        );

        writer.accept(
                EMLootTables.STONE_RUINS_SIMPLE,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0f, 4.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 1, 5, 3))
                                .add(EMLootTableUtil.rangedDrop(Items.IRON_INGOT, 1, 3, 2))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ANCIENT_LOG, 4, 12, 3))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ETHERSTONE_BRICKS, 2, 7, 2))
                )
        );

        writer.accept(
                EMLootTables.STONE_RUINS_MEDIUM,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0f, 4.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 1, 5, 3))
                                .add(EMLootTableUtil.rangedDrop(Items.IRON_INGOT, 1, 3, 2))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ANCIENT_LOG, 4, 12, 3))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ETHERSTONE_BRICKS, 2, 7, 2))
                )
        );

        writer.accept(
                EMLootTables.STONE_RUINS_LARGE,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0f, 4.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 1, 5, 3))
                                .add(EMLootTableUtil.rangedDrop(Items.IRON_INGOT, 1, 3, 2))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ANCIENT_LOG, 4, 12, 3))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ETHERSTONE_BRICKS, 2, 7, 2))
                )
        );

        writer.accept(
                EMLootTables.STONE_RUINS_END,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0f, 4.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 1, 5, 3))
                                .add(EMLootTableUtil.rangedDrop(Items.IRON_INGOT, 1, 3, 2))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ANCIENT_LOG, 4, 12, 3))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ETHERSTONE_BRICKS, 2, 7, 2))
                )
        );
    }
}
