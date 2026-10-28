package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.structure.EMProcessors;
import com.gmail.thelilchicken01.ethermist.datagen.structure.EMStructureSets;
import com.gmail.thelilchicken01.ethermist.datagen.structure.EMStructures;
import com.gmail.thelilchicken01.ethermist.datagen.structure.pools.EMTemplatePoolsProvider;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.worldgen.*;
import com.gmail.thelilchicken01.ethermist.worldgen.biome.EMBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EMDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, EMConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, EMPlacedFeatures::bootstrap)
            .add(Registries.BIOME, EMBiomes::bootstrap)
            .add(Registries.DAMAGE_TYPE, EMDamageTypesProvider::bootstrap)
            .add(Registries.ENCHANTMENT, EMEnchantments::bootstrap)
            .add(Registries.PROCESSOR_LIST, EMProcessors::bootstrap)
            .add(Registries.TEMPLATE_POOL, EMTemplatePoolsProvider::bootstrap)
            .add(Registries.STRUCTURE_SET, EMStructureSets::bootstrap)
            .add(Registries.STRUCTURE, EMStructures::bootstrap);

    public EMDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Ethermist.MODID));
    }

}
