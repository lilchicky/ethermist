package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class EMInjectLootTableProvider implements LootTableSubProvider {

    private final HolderLookup.Provider registries;

    public EMInjectLootTableProvider(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> writer) {
        writer.accept(EMLootTables.WITCH_ORB_TO_WITCH, EMLootTableUtil.singleItemInject(EMItems.WITCH_ORB, 0.01f));
        writer.accept(EMLootTables.WITCH_ORB_TO_PILLAGER_OUTPOST, EMLootTableUtil.singleItemInject(EMItems.WITCH_ORB, 0.1f));

        writer.accept(EMLootTables.POISON_ORB_TO_JUNGLE_TEMPLE, EMLootTableUtil.singleItemInject(EMItems.POISON_ORB, 0.33f));
        writer.accept(EMLootTables.POISON_ORB_TO_MINESHAFT, EMLootTableUtil.singleItemInject(EMItems.POISON_ORB, 0.33f));
        writer.accept(EMLootTables.POISON_ORB_TO_CAVE_SPIDER, EMLootTableUtil.singleItemInject(EMItems.POISON_ORB, 0.01f));

        writer.accept(EMLootTables.LEVITATION_ORB_TO_END_CITY, EMLootTableUtil.singleItemInject(EMItems.LEVITATION_ORB, 0.25f));

        writer.accept(EMLootTables.FROZEN_ORB_TO_IGLOO, EMLootTableUtil.singleItemInject(EMItems.FROZEN_ORB, 0.1f));

        writer.accept(EMLootTables.FLAME_ORB_TO_NETHER_BRIDGE, EMLootTableUtil.singleItemInject(EMItems.FLAME_ORB, 0.33f));
        writer.accept(EMLootTables.FLAME_ORB_TO_BASTION_OTHER, EMLootTableUtil.singleItemInject(EMItems.FLAME_ORB, 0.1f));

        writer.accept(EMLootTables.DULL_ORB_TO_SIMPLE_DUNGEON, EMLootTableUtil.singleItemInject(EMItems.DULL_ORB, 0.33f));
        writer.accept(EMLootTables.DULL_ORB_TO_STRONGHOLD_CROSSING, EMLootTableUtil.singleItemInject(EMItems.DULL_ORB, 0.1f));
        writer.accept(EMLootTables.DULL_ORB_TO_STRONGHOLD_CORRIDOR, EMLootTableUtil.singleItemInject(EMItems.DULL_ORB, 0.1f));

        writer.accept(EMLootTables.ANCIENT_ORB_TO_ANCIENT_CITY, EMLootTableUtil.singleItemInject(EMItems.ANCIENT_ORB, 0.33f));
    }
}
