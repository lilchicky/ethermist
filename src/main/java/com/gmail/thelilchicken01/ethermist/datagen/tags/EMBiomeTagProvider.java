package com.gmail.thelilchicken01.ethermist.datagen.tags;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EMBiomeTagProvider extends BiomeTagsProvider {

    public EMBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(Tags.Biomes.IS_AQUATIC)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "abyssal_depths"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "forgotten_ocean"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "twisting_river"));

        tag(Tags.Biomes.IS_BEACH)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "sparkling_beach"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "eroded_beach"));

        tag(Tags.Biomes.IS_MOUNTAIN)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "windy_peaks"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "amethyst_gardens"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "burning_crags"));

        tag(Tags.Biomes.IS_DESERT)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "timeworn_desert"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frozen_expanse"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "burning_crags"));

        tag(Tags.Biomes.IS_FOREST)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "ancient_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glimmering_ancient_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "slimy_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frostpine_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "amberwood_grove"));

        tag(Tags.Biomes.IS_PLAINS)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "ancient_fields"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "blooming_meadows"));

        tag(Tags.Biomes.IS_SNOWY)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frozen_expanse"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frostpine_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "windy_peaks"));

        tag(Tags.Biomes.IS_SWAMP)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "slimy_swamp"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "slimy_forest"));

        tag(Tags.Biomes.IS_RARE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "amethyst_gardens"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "burning_crags"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "abyssal_flats"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "slimy_forest"));

        tag(Tags.Biomes.IS_JUNGLE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glimmering_ancient_forest"));

        tag(Tags.Biomes.IS_HOT)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "timeworn_desert"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "burning_crags"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "amberwood_grove"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glimmering_ancient_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "slimy_swamp"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "slimy_forest"));

        tag(Tags.Biomes.IS_COLD)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frostpine_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frozen_expanse"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "windy_peaks"));

        tag(Tags.Biomes.IS_DRY)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "timeworn_desert"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "burning_crags"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "amethyst_gardens"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "windy_peaks"));

        tag(Tags.Biomes.IS_WET)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "slimy_swamp"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "slimy_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "blooming_meadows"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "ancient_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glimmering_ancient_forest"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "twisting_river"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "forgotten_ocean"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "abyssal_depths"));

        tag(Tags.Biomes.IS_STONY_SHORES)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "eroded_beach"));

        tag(Tags.Biomes.IS_RIVER)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "twisting_river"));

        tag(Tags.Biomes.IS_DEAD)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "abyssal_flats"));

        tag(Tags.Biomes.IS_DEEP_OCEAN)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "forgotten_ocean"));

        tag(Tags.Biomes.IS_DENSE_VEGETATION)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glimmering_ancient_forest"));

        tag(Tags.Biomes.IS_DECIDUOUS_TREE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frostpine_forest"));

        tag(Tags.Biomes.IS_FLORAL)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "blooming_meadows"));

        tag(Tags.Biomes.IS_ICY)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frozen_expanse"));

        tag(Tags.Biomes.IS_SANDY)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "timeworn_desert"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "sparkling_beach"));

        tag(Tags.Biomes.IS_SPARSE_VEGETATION)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "timeworn_desert"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "sparkling_beach"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "eroded_beach"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "burning_crags"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "amethyst_gardens"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "abyssal_flats"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frozen_expanse"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "windy_peaks"));

    }

}
