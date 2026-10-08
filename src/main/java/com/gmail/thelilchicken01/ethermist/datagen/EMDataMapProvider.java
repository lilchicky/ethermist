package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class EMDataMapProvider extends DataMapProvider {

    protected EMDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
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

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(EMItems.SOURDEW_SEEDS.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.SOURDEW.getId(), new Compostable(0.65f), false)
                .add(EMBlocks.ABYSSAL_MUSHROOM.getId(), new Compostable(0.5f), false)
                .add(EMBlocks.TALL_ABYSSAL_MUSHROOM.getId(), new Compostable(0.65f), false)
                .add(EMBlocks.SMALL_ABYSSAL_MUSHROOM.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP.getId(), new Compostable(0.85f), false)
                .add(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP.getId(), new Compostable(0.85f), false)
                .add(EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS.getId(), new Compostable(0.85f), false)
                .add(EMBlocks.SMALL_ABYSSAL_MUSHROOM.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.RICH_TALL_GRASS.getId(), new Compostable(0.5f), false)
                .add(EMBlocks.RICH_GRASS.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.FALLEN_AMBERWOOD_LEAVES.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.CHRONOTHORN.getId(), new Compostable(0.65f), false)

                .add(EMBlocks.ANCIENT_LEAVES.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.SLIMY_LEAVES.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.FROSTPINE_LEAVES.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.GREEN_AMBERWOOD_LEAVES.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.RED_AMBERWOOD_LEAVES.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.ORANGE_AMBERWOOD_LEAVES.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.YELLOW_AMBERWOOD_LEAVES.getId(), new Compostable(0.3f), false)

                .add(EMBlocks.ANCIENT_SAPLING.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.GLIMMERING_ANCIENT_SAPLING.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.SLIMY_SAPLING.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.FROSTPINE_SAPLING.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.GREEN_AMBERWOOD_SAPLING.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.RED_AMBERWOOD_SAPLING.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.ORANGE_AMBERWOOD_SAPLING.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.YELLOW_AMBERWOOD_SAPLING.getId(), new Compostable(0.3f), false)

                .add(EMBlocks.GLIMMERBUD.getId(), new Compostable(0.65f), false)
                .add(EMBlocks.NIGHTBELL.getId(), new Compostable(0.65f), false)
                .add(EMBlocks.WITCH_LAVENDER.getId(), new Compostable(0.65f), false)
                .add(EMBlocks.DAWNING_HYACINTH.getId(), new Compostable(0.65f), false)
                .add(EMBlocks.CINDERBLOOM.getId(), new Compostable(0.3f), false)
                .add(EMBlocks.SLIMY_ALLIUM.getId(), new Compostable(0.65f), false)
                .add(EMBlocks.PYRUSCIA.getId(), new Compostable(0.65f), false)

                .add(EMItems.SHROOM_CLUSTER.getId(), new Compostable(0.85f), false);
    }

}
