package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.loot.EMBlockLootProvider;
import com.gmail.thelilchicken01.ethermist.datagen.loot.EMEntityLootProvider;
import com.gmail.thelilchicken01.ethermist.datagen.loot.EMGlobalLootModifierProvider;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.EMRecipeProvider;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMBlockTagProvider;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMEnchantTagProvider;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Ethermist.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    // Folder Locations
    public static final String ETHERSTONE = "etherstone";
    public static final String ANCIENT_ETHERSTONE = "ancient_etherstone";
    public static final String GLIMMERING_WOOD = "glimmering_wood";
    public static final String ANCIENT_WOOD = "ancient_wood";
    public static final String SLIMY_WOOD = "slimy_wood";
    public static final String FROSTPINE_WOOD = "frostpine_wood";
    public static final String SPARKLING_SANDSTONE = "sparkling_sandstone";
    public static final String TIMEWORN_SANDSTONE = "timeworn_sandstone";
    public static final String ABYSSAL_MUSHROOM = "large_abyssal_mushroom";
    public static final String AMBERWOOD_WOOD = "amberwood_wood";
    public static final String ASHEN_WOOD = "charred_wood";

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        BlockTagsProvider blockTagsProvider = new EMBlockTagProvider(packOutput, lookupProvider, existingFileHelper);

        gen.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(
                        new LootTableProvider.SubProviderEntry(EMBlockLootProvider::new, LootContextParamSets.BLOCK),
                        new LootTableProvider.SubProviderEntry(EMEntityLootProvider::new, LootContextParamSets.ENTITY)
                ),
                lookupProvider)
        );

        gen.addProvider(event.includeServer(), new EMDatapackProvider(packOutput, lookupProvider));

        gen.addProvider(event.includeServer(), new EMRecipeProvider(packOutput, lookupProvider));

        gen.addProvider(event.includeServer(), new EMDataMapProvider(packOutput, lookupProvider));

        gen.addProvider(event.includeServer(), blockTagsProvider);
        gen.addProvider(event.includeServer(), new EMItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        gen.addProvider(event.includeServer(), new EMEnchantTagProvider(packOutput, lookupProvider, existingFileHelper));

        gen.addProvider(event.includeClient(), new EMBlockstateProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeClient(), new EMItemModelProvider(packOutput, existingFileHelper));

        gen.addProvider(event.includeClient(), new EMParticleProvider(packOutput, existingFileHelper));

        gen.addProvider(event.includeServer(), new EMGlobalLootModifierProvider(packOutput, lookupProvider));

    }

}
