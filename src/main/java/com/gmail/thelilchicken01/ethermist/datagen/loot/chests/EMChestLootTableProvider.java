package com.gmail.thelilchicken01.ethermist.datagen.loot.chests;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class EMChestLootTableProvider implements LootTableSubProvider {

    public static final ResourceKey<LootTable> FORGEMASTER_GENERIC = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "chests/forgemaster_basic"));

    public EMChestLootTableProvider(HolderLookup.Provider registries) {}

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> writer) {
        writer.accept(
                FORGEMASTER_GENERIC,
                LootTable.lootTable()
        );
    }
}
