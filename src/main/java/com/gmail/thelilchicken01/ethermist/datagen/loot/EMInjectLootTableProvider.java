package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;

public class EMInjectLootTableProvider implements LootTableSubProvider {

    private final HolderLookup.Provider registries;

    public EMInjectLootTableProvider(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> writer) {
        writer.accept(EMLootTables.WITCH_ORB_TO_WITCH, EMLootTableHelper.singleItemInject(EMItems.WITCH_ORB, 0.01f));
        writer.accept(EMLootTables.WITCH_ORB_TO_PILLAGER_OUTPOST, EMLootTableHelper.singleItemInject(EMItems.WITCH_ORB, 0.1f));

        writer.accept(EMLootTables.POISON_ORB_TO_JUNGLE_TEMPLE, EMLootTableHelper.singleItemInject(EMItems.POISON_ORB, 0.33f));
        writer.accept(EMLootTables.POISON_ORB_TO_MINESHAFT, EMLootTableHelper.singleItemInject(EMItems.POISON_ORB, 0.33f));
        writer.accept(EMLootTables.POISON_ORB_TO_CAVE_SPIDER, EMLootTableHelper.singleItemInject(EMItems.POISON_ORB, 0.01f));

        writer.accept(EMLootTables.LEVITATION_ORB_TO_END_CITY, EMLootTableHelper.singleItemInject(EMItems.LEVITATION_ORB, 0.25f));

        writer.accept(EMLootTables.FROZEN_ORB_TO_IGLOO, EMLootTableHelper.singleItemInject(EMItems.FROZEN_ORB, 0.1f));

        writer.accept(EMLootTables.FLAME_ORB_TO_NETHER_BRIDGE, EMLootTableHelper.singleItemInject(EMItems.FLAME_ORB, 0.33f));
        writer.accept(EMLootTables.FLAME_ORB_TO_BASTION_OTHER, EMLootTableHelper.singleItemInject(EMItems.FLAME_ORB, 0.1f));

        writer.accept(EMLootTables.DULL_ORB_TO_SIMPLE_DUNGEON, EMLootTableHelper.singleItemInject(EMItems.DULL_ORB, 0.33f));
        writer.accept(EMLootTables.DULL_ORB_TO_STRONGHOLD_CROSSING, EMLootTableHelper.singleItemInject(EMItems.DULL_ORB, 0.1f));
        writer.accept(EMLootTables.DULL_ORB_TO_STRONGHOLD_CORRIDOR, EMLootTableHelper.singleItemInject(EMItems.DULL_ORB, 0.1f));

        writer.accept(EMLootTables.ANCIENT_ORB_TO_ANCIENT_CITY, EMLootTableHelper.singleItemInject(EMItems.ANCIENT_ORB, 0.33f));
    }
}
