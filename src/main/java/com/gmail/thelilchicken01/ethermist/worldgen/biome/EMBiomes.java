package com.gmail.thelilchicken01.ethermist.worldgen.biome;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.worldgen.EMGeneralPlacedFeatures;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class EMBiomes {

    public static final ResourceKey<Biome> ABYSSAL_DEPTHS = create("abyssal_depths");
    public static final ResourceKey<Biome> ABYSSAL_FLATS = create("abyssal_flats");
    public static final ResourceKey<Biome> AMBERWOOD_GROVE = create("amberwood_grove");
    public static final ResourceKey<Biome> AMETHYST_GARDENS = create("amethyst_gardens");
    public static final ResourceKey<Biome> ANCIENT_FIELDS = create("ancient_fields");
    public static final ResourceKey<Biome> ANCIENT_FOREST = create("ancient_forest");
    public static final ResourceKey<Biome> BLOOMING_MEADOWS = create("blooming_meadows");
    public static final ResourceKey<Biome> BURNING_CRAGS = create("burning_crags");
    public static final ResourceKey<Biome> ERODED_BEACH = create("eroded_beach");
    public static final ResourceKey<Biome> FORGOTTEN_OCEAN = create("forgotten_ocean");
    public static final ResourceKey<Biome> FROSTPINE_FOREST = create("frostpine_forest");
    public static final ResourceKey<Biome> FROZEN_EXPANSE = create("frozen_expanse");
    public static final ResourceKey<Biome> GLIMMERING_ANCIENT_FOREST = create("glimmering_ancient_forest");
    public static final ResourceKey<Biome> SLIMY_FOREST = create("slimy_forest");
    public static final ResourceKey<Biome> SLIMY_SWAMP = create("slimy_swamp");
    public static final ResourceKey<Biome> SPARKLING_BEACH = create("sparkling_beach");
    public static final ResourceKey<Biome> TIMEWORN_DESERT = create("timeworn_desert");
    public static final ResourceKey<Biome> TWISTING_RIVER = create("twisting_river");
    public static final ResourceKey<Biome> WINDY_PEAKS = create("windy_peaks");

    private static final Music NORMAL_MUSIC = null;

    private static ResourceKey<Biome> create(String path) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
    }

    public static void bootstrap(BootstrapContext<Biome> context) {

        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        context.register(
                ABYSSAL_DEPTHS,
                new Biome.BiomeBuilder()
                        .downfall(0.5f)
                        .temperature(0.5f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(12638463)
                                        .skyColor(2049470)
                                        .waterColor(986997)
                                        .waterFogColor(1184396)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(NORMAL_MUSIC)
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures()
                                        .addAbyssalShrooms(false)
                                        .builder()
                                        .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.ABYSSAL_FOSSIL)
                                        .build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultSpawns(false)
                                        .defaultWater()
                                        .builder()
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                ABYSSAL_FLATS,
                new Biome.BiomeBuilder()
                        .downfall(0.0f)
                        .temperature(2.0f)
                        .hasPrecipitation(false)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(12638463)
                                        .skyColor(11184810)
                                        .waterColor(7829367)
                                        .waterFogColor(5592405)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures()
                                        .addAbyssalShrooms(true)
                                        .builder()
                                        .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.ABYSSAL_FOSSIL)
                                        .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.FOSSIL_UPPER)
                                        .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.FOSSIL_LOWER)
                                        .build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultMonsters()
                                        .defaultAmbient()
                                        .builder()
                                        .addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, DefaultEthermistSpawnSettings.DEFAULT_GLOW_SQUID)
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                ANCIENT_FOREST,
                new Biome.BiomeBuilder()
                        .downfall(0.8f)
                        .temperature(0.7f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(12638463)
                                        .skyColor(2049470)
                                        .waterColor(986997)
                                        .waterFogColor(1184396)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures()
                                        .builder()
                                        .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.ETHERSTONE_BOULDER)
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.MEGA_ANCIENT_TREE)
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.ANCIENT_TREE)
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SOURDEW_PATCH)
                                        .build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultSpawns(true)
                                        .builder()
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

    }

}
