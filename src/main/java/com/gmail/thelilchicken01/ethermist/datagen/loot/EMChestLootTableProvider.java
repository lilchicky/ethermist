package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
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
                                .add(EMLootTableHelper.rangedDrop(Items.BONE, 1, 3, 3))
                                .add(EMLootTableHelper.singleDrop(EMItems.WOODEN_WAND_HANDLE, 1))
                ).withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(EMLootTableHelper.singleDrop(Items.DIAMOND, 1))
                                .add(EMLootTableHelper.enchantedItem(Items.BOOK, 1, this.registries))
                )
        );
    }
}
