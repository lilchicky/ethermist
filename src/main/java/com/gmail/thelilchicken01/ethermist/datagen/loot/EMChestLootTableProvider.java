package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.effect.potion.EMPotions;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potions;
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
                                .setRolls(UniformGenerator.between(2.0f, 5.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 3, 5, 4))
                                .add(EMLootTableUtil.rangedDrop(Items.IRON_INGOT, 1, 3, 2))
                                .add(EMLootTableUtil.rangedDrop(Items.STICK, 1, 4, 3))
                                .add(EMLootTableUtil.rangedDrop(Items.AMETHYST_SHARD, 1, 2, 2))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ANCIENT_LOG, 4, 8, 3))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ETHERSTONE_BRICKS, 2, 7, 2))
                ).withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(EMLootTableUtil.empty(3))
                                .add(EMLootTableUtil.singleDrop(EMItems.DULL_ORB, 1))
                )
        );

        writer.accept(
                EMLootTables.STONE_RUINS_MEDIUM,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(3.0f, 6.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 3, 5, 4))
                                .add(EMLootTableUtil.rangedDrop(Items.IRON_INGOT, 1, 3, 2))
                                .add(EMLootTableUtil.rangedDrop(Items.GOLD_INGOT, 1, 3, 2))
                                .add(EMLootTableUtil.rangedDrop(Items.DIAMOND, 1, 3, 1))
                                .add(EMLootTableUtil.rangedDrop(Items.AMETHYST_SHARD, 2, 6, 3))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ETHERSTONE_BRICKS, 8, 24, 3))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.ANCIENT_LOG, 8, 24, 3))
                                .add(EMLootTableUtil.singleDrop(EMItems.DULL_ORB, 1))
                                .add(EMLootTableUtil.singleDrop(EMItems.FLAME_ORB, 1))
                                .add(EMLootTableUtil.singleDrop(EMItems.WITCH_ORB, 1))
                                .add(EMLootTableUtil.potion(EMPotions.ARCANE_AMPLIFICATION_POTION, true, 2))
                                .add(EMLootTableUtil.potion(Potions.SWIFTNESS, true, 2))
                                .add(EMLootTableUtil.enchantedItem(Items.BOOK, 1, this.registries))
                )
        );

        writer.accept(
                EMLootTables.STONE_RUINS_LARGE,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(4.0f, 8.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 1, 5, 1))
                                .add(EMLootTableUtil.rangedDrop(Items.IRON_INGOT, 2, 5, 2))
                                .add(EMLootTableUtil.rangedDrop(Items.GOLD_INGOT, 1, 6, 2))
                                .add(EMLootTableUtil.rangedDrop(Items.DIAMOND, 2, 4, 1))
                                .add(EMLootTableUtil.rangedDrop(Items.AMETHYST_SHARD, 2, 6, 3))
                                .add(EMLootTableUtil.enchantedItem(EMItems.WITHER_WAND, 1, this.registries))
                                .add(EMLootTableUtil.enchantedItem(EMItems.GLASS_WAND, 1, this.registries))
                                .add(EMLootTableUtil.potion(EMPotions.ARCANE_AMPLIFICATION_POTION, true, 2))
                                .add(EMLootTableUtil.potion(EMPotions.FASTER_CASTING_POTION, true, 2))
                                .add(EMLootTableUtil.enchantedItem(Items.BOOK, 1, this.registries, 1.0f, 3.0f))
                )
        );

        writer.accept(
                EMLootTables.STONE_RUINS_END,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(2.0f, 5.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 1, 5, 3))
                                .add(EMLootTableUtil.rangedDrop(Items.END_STONE, 4, 12, 3))
                                .add(EMLootTableUtil.rangedDrop(Items.CHORUS_FRUIT, 1, 4, 2))
                                .add(EMLootTableUtil.rangedDrop(Items.AMETHYST_SHARD, 2, 5, 2))
                                .add(EMLootTableUtil.enchantedItem(Items.BOOK, 3, this.registries, 2.0f, 4.0f))
                )
        );
    }
}
