package com.gmail.thelilchicken01.ethermist.datagen.tags;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.worldgen.biome.EMBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EMBiomeTagProvider extends BiomeTagsProvider {

    public EMBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ethermist.MODID, existingFileHelper);
    }

    private static ResourceKey<Biome> create(String path) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(Tags.Biomes.IS_AQUATIC)
                .add(EMBiomes.ABYSSAL_DEPTHS)
                .add(EMBiomes.FORGOTTEN_OCEAN)
                .add(EMBiomes.TWISTING_RIVER);

        tag(Tags.Biomes.IS_BEACH)
                .add(EMBiomes.SPARKLING_BEACH)
                .add(EMBiomes.ERODED_BEACH);

        tag(Tags.Biomes.IS_MOUNTAIN)
                .add(EMBiomes.WINDY_PEAKS)
                .add(EMBiomes.AMETHYST_GARDENS)
                .add(EMBiomes.BURNING_CRAGS);

        tag(Tags.Biomes.IS_DESERT)
                .add(EMBiomes.TIMEWORN_DESERT)
                .add(EMBiomes.FROZEN_EXPANSE)
                .add(EMBiomes.BURNING_CRAGS);

        tag(Tags.Biomes.IS_FOREST)
                .add(EMBiomes.ANCIENT_FOREST)
                .add(EMBiomes.GLIMMERING_ANCIENT_FOREST)
                .add(EMBiomes.SLIMY_FOREST)
                .add(EMBiomes.FROSTPINE_FOREST)
                .add(EMBiomes.AMBERWOOD_GROVE);

        tag(Tags.Biomes.IS_PLAINS)
                .add(EMBiomes.ANCIENT_FIELDS)
                .add(EMBiomes.BLOOMING_MEADOWS);

        tag(Tags.Biomes.IS_SNOWY)
                .add(EMBiomes.FROZEN_EXPANSE)
                .add(EMBiomes.FROSTPINE_FOREST)
                .add(EMBiomes.WINDY_PEAKS);

        tag(Tags.Biomes.IS_SWAMP)
                .add(EMBiomes.SLIMY_SWAMP)
                .add(EMBiomes.SLIMY_FOREST);

        tag(Tags.Biomes.IS_RARE)
                .add(EMBiomes.AMETHYST_GARDENS)
                .add(EMBiomes.BURNING_CRAGS)
                .add(EMBiomes.ABYSSAL_FLATS)
                .add(EMBiomes.SLIMY_FOREST);

        tag(Tags.Biomes.IS_JUNGLE)
                .add(EMBiomes.GLIMMERING_ANCIENT_FOREST);

        tag(Tags.Biomes.IS_HOT)
                .add(EMBiomes.TIMEWORN_DESERT)
                .add(EMBiomes.BURNING_CRAGS)
                .add(EMBiomes.AMBERWOOD_GROVE)
                .add(EMBiomes.GLIMMERING_ANCIENT_FOREST)
                .add(EMBiomes.SLIMY_SWAMP)
                .add(EMBiomes.SLIMY_FOREST);

        tag(Tags.Biomes.IS_COLD)
                .add(EMBiomes.FROSTPINE_FOREST)
                .add(EMBiomes.FROZEN_EXPANSE)
                .add(EMBiomes.WINDY_PEAKS);

        tag(Tags.Biomes.IS_DRY)
                .add(EMBiomes.TIMEWORN_DESERT)
                .add(EMBiomes.BURNING_CRAGS)
                .add(EMBiomes.AMETHYST_GARDENS)
                .add(EMBiomes.WINDY_PEAKS);

        tag(Tags.Biomes.IS_WET)
                .add(EMBiomes.SLIMY_SWAMP)
                .add(EMBiomes.SLIMY_FOREST)
                .add(EMBiomes.BLOOMING_MEADOWS)
                .add(EMBiomes.ANCIENT_FOREST)
                .add(EMBiomes.GLIMMERING_ANCIENT_FOREST)
                .add(EMBiomes.TWISTING_RIVER)
                .add(EMBiomes.FORGOTTEN_OCEAN)
                .add(EMBiomes.ABYSSAL_DEPTHS);

        tag(Tags.Biomes.IS_STONY_SHORES)
                .add(EMBiomes.ERODED_BEACH);

        tag(Tags.Biomes.IS_RIVER)
                .add(EMBiomes.TWISTING_RIVER);

        tag(Tags.Biomes.IS_DEAD)
                .add(EMBiomes.ABYSSAL_FLATS);

        tag(Tags.Biomes.IS_DEEP_OCEAN)
                .add(EMBiomes.FORGOTTEN_OCEAN);

        tag(Tags.Biomes.IS_DENSE_VEGETATION)
                .add(EMBiomes.GLIMMERING_ANCIENT_FOREST);

        tag(Tags.Biomes.IS_DECIDUOUS_TREE)
                .add(EMBiomes.FROSTPINE_FOREST);

        tag(Tags.Biomes.IS_FLORAL)
                .add(EMBiomes.BLOOMING_MEADOWS);

        tag(Tags.Biomes.IS_ICY)
                .add(EMBiomes.FROZEN_EXPANSE);

        tag(Tags.Biomes.IS_SANDY)
                .add(EMBiomes.TIMEWORN_DESERT)
                .add(EMBiomes.SPARKLING_BEACH);

        tag(Tags.Biomes.IS_SPARSE_VEGETATION)
                .add(EMBiomes.TIMEWORN_DESERT)
                .add(EMBiomes.SPARKLING_BEACH)
                .add(EMBiomes.ERODED_BEACH)
                .add(EMBiomes.BURNING_CRAGS)
                .add(EMBiomes.AMETHYST_GARDENS)
                .add(EMBiomes.ABYSSAL_FLATS)
                .add(EMBiomes.FROZEN_EXPANSE)
                .add(EMBiomes.WINDY_PEAKS);

        // Structures
        tag(EMTags.Biomes.HAS_FORGEMASTER_CASTLE)
                .add(EMBiomes.ANCIENT_FOREST);

        tag(EMTags.Biomes.HAS_TIMEWORN_PORTAL)
                .addTag(Tags.Biomes.IS_DESERT)
                .addTag(Tags.Biomes.IS_DRY);

        tag(EMTags.Biomes.HAS_STONE_PORTAL)
                .addTag(Tags.Biomes.IS_JUNGLE)
                .addTag(Tags.Biomes.IS_FOREST)
                .addTag(Tags.Biomes.IS_MOUNTAIN)
                .addTag(Tags.Biomes.IS_PLAINS)
                .addTag(Tags.Biomes.IS_SWAMP);

        tag(EMTags.Biomes.HAS_SPARKLING_PORTAL)
                .addTag(Tags.Biomes.IS_AQUATIC)
                .addTag(Tags.Biomes.IS_BEACH);

        tag(EMTags.Biomes.HAS_GLIMMERBUG_CAVE)
                .add(EMBiomes.GLIMMERING_ANCIENT_FOREST);

        tag(EMTags.Biomes.HAS_GENERIC_RUINS)
                .addAll(
                        List.of(
                                EMBiomes.AMBERWOOD_GROVE,
                                EMBiomes.AMETHYST_GARDENS,
                                EMBiomes.ANCIENT_FIELDS,
                                EMBiomes.ANCIENT_FOREST,
                                EMBiomes.BLOOMING_MEADOWS,
                                EMBiomes.BURNING_CRAGS,
                                EMBiomes.FROSTPINE_FOREST,
                                EMBiomes.FROZEN_EXPANSE,
                                EMBiomes.GLIMMERING_ANCIENT_FOREST,
                                EMBiomes.SLIMY_FOREST,
                                EMBiomes.SLIMY_SWAMP
                        )
                );

        tag(EMTags.Biomes.HAS_ANCIENT_STONE_PORTAL)
                .addTag(Tags.Biomes.IS_COLD)
                .addTag(Tags.Biomes.IS_SNOWY)
                .addTag(Tags.Biomes.IS_ICY);

    }

}
