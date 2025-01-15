package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.worldgen.EMBiomeModifiers;
import com.gmail.thelilchicken01.ethermist.worldgen.EMConfiguredFeatures;
import com.gmail.thelilchicken01.ethermist.worldgen.EMPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EMDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, EMConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, EMPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, EMBiomeModifiers::bootstrap);

    public EMDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Ethermist.MODID));
    }

}
