package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class EMDataMapProvider extends DataMapProvider {

    protected EMDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(EMItems.WOODEN_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.EMERALD_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.GOLDEN_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.DIAMOND_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.LAPIS_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.QUARTZ_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.REDSTONE_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.GLOWSTONE_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.PRISMARINE_WAND_HANDLE.getId(), new FurnaceFuel(80), false)
                .add(EMItems.NETHERITE_WAND_HANDLE.getId(), new FurnaceFuel(80), false);
    }

}
