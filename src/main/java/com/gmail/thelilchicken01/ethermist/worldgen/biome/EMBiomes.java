package com.gmail.thelilchicken01.ethermist.worldgen.biome;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.worldgen.EMGeneralPlacedFeatures;
import com.gmail.thelilchicken01.ethermist.worldgen.EMOresPlaced;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
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

    private static final int DEFAULT_FOG = 12638463;
    private static final int DEFAULT_SKY = 2049470;
    private static final int DEFAULT_WATER = 986997;
    private static final int DEFAULT_WATER_FOG = 1184396;

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
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(DEFAULT_SKY)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(NORMAL_MUSIC)
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .addAbyssalShrooms(false)
                                        .addFossils(true)
                                        .builder().build()
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
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(11184810)
                                        .waterColor(7829367)
                                        .waterFogColor(5592405)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .addAbyssalShrooms(true)
                                        .addFossils(true)
                                        .builder().build()
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
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(DEFAULT_SKY)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateAncientForest()
                                        .addSourdewPatch()
                                        .builder()
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

        context.register(
                AMBERWOOD_GROVE,
                new Biome.BiomeBuilder()
                        .downfall(0.8f)
                        .temperature(0.7f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(DEFAULT_SKY)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateAmberwoodGrove()
                                        .addSourdewPatch()
                                        .builder()
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

        context.register(
                AMETHYST_GARDENS,
                new Biome.BiomeBuilder()
                        .downfall(0.8f)
                        .temperature(2.0f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(4264816)
                                        .waterColor(9464268)
                                        .waterFogColor(9464290)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FLOWER_FOREST))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(true)
                                        .builder()
                                        .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.AMETHYST_SPIKE)
                                        .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.SMALL_AMETHYST_SPIKE)
                                        .build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultSpawns(false)
                                        .builder()
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                ANCIENT_FIELDS,
                new Biome.BiomeBuilder()
                        .downfall(0.8f)
                        .temperature(0.7f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(DEFAULT_SKY)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_MEADOW))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateAncientField()
                                        .addSourdewPatch()
                                        .builder()
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

        context.register(
                BLOOMING_MEADOWS,
                new Biome.BiomeBuilder()
                        .downfall(0.8f)
                        .temperature(0.7f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(DEFAULT_SKY)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CHERRY_GROVE))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateBloomingMeadows()
                                        .addSourdewPatch()
                                        .builder()
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

        context.register(
                BURNING_CRAGS,
                new Biome.BiomeBuilder()
                        .downfall(0.0f)
                        .temperature(2.0f)
                        .hasPrecipitation(false)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(16746496)
                                        .waterColor(15624960)
                                        .waterFogColor(14308864)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .populateBurningCrags()
                                        .builder()
                                        .build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultAmbient()
                                        .defaultMonsters()
                                        .builder()
                                        .addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, DefaultEthermistSpawnSettings.DEFAULT_GLOW_SQUID)
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                ERODED_BEACH,
                new Biome.BiomeBuilder()
                        .downfall(0.3f)
                        .temperature(0.2f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(DEFAULT_SKY)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(NORMAL_MUSIC)
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(true)
                                        .builder()
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
                FORGOTTEN_OCEAN,
                new Biome.BiomeBuilder()
                        .downfall(0.5f)
                        .temperature(0.5f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(3824789)
                                        .waterColor(986964)
                                        .waterFogColor(1184348)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(NORMAL_MUSIC)
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(true)
                                        .addAbyssalShrooms(false)
                                        .addFossils(true)
                                        .builder().build()
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
                FROSTPINE_FOREST,
                new Biome.BiomeBuilder()
                        .downfall(0.8f)
                        .temperature(0.0f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(7972607)
                                        .waterColor(4350177)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(true)
                                        .populateFrostpineForest()
                                        .builder()
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

        context.register(
                FROZEN_EXPANSE,
                new Biome.BiomeBuilder()
                        .downfall(0.5f)
                        .temperature(0.0f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(7972607)
                                        .waterColor(4350177)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(true)
                                        .populateFrozenExpanse()
                                        .addFossils(true)
                                        .builder()
                                        .build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultAmbient()
                                        .defaultMonsters()
                                        .builder()
                                        .addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, DefaultEthermistSpawnSettings.DEFAULT_GLOW_SQUID)
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                GLIMMERING_ANCIENT_FOREST,
                new Biome.BiomeBuilder()
                        .downfall(1.0f)
                        .temperature(0.7f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(2075391)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateGlimmeringAncientForest()
                                        .addSourdewPatch()
                                        .builder()
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

        context.register(
                SLIMY_FOREST,
                new Biome.BiomeBuilder()
                        .downfall(0.8f)
                        .temperature(0.7f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(1018383)
                                        .waterColor(12032)
                                        .waterFogColor(18688)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateSlimyForest()
                                        .addSourdewPatch()
                                        .builder()
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

        context.register(
                SLIMY_SWAMP,
                new Biome.BiomeBuilder()
                        .downfall(0.9f)
                        .temperature(0.8f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(1018383)
                                        .waterColor(12032)
                                        .waterFogColor(18688)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateSlimyForest()
                                        .addSourdewPatch()
                                        .addFossils(false)
                                        .builder()
                                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY)
                                        .build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultSpawns(false)
                                        .builder()
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                SPARKLING_BEACH,
                new Biome.BiomeBuilder()
                        .downfall(0.4f)
                        .temperature(0.8f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(DEFAULT_SKY)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(NORMAL_MUSIC)
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .builder().build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultSpawns(false)
                                        .builder()
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                TIMEWORN_DESERT,
                new Biome.BiomeBuilder()
                        .downfall(0.0f)
                        .temperature(2.0f)
                        .hasPrecipitation(false)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(6724)
                                        .waterColor(3628949)
                                        .waterFogColor(3624823)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateTimewornDesert()
                                        .builder().build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultAmbient()
                                        .defaultMonsters()
                                        .builder()
                                        .addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, DefaultEthermistSpawnSettings.DEFAULT_GLOW_SQUID)
                                        .build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                TWISTING_RIVER,
                new Biome.BiomeBuilder()
                        .downfall(0.5f)
                        .temperature(0.5f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(DEFAULT_SKY)
                                        .waterColor(DEFAULT_WATER)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(NORMAL_MUSIC)
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(false)
                                        .populateAncientField()
                                        .addAbyssalShrooms(false)
                                        .builder().build()
                        )
                        .mobSpawnSettings(
                                new DefaultEthermistSpawnSettings(context)
                                        .defaultSpawns(true)
                                        .defaultWater()
                                        .builder().build()
                        )
                        .build(),
                Lifecycle.stable()
        );

        context.register(
                WINDY_PEAKS,
                new Biome.BiomeBuilder()
                        .downfall(0.9f)
                        .temperature(-0.7f)
                        .hasPrecipitation(true)
                        .specialEffects(
                                new BiomeSpecialEffects.Builder()
                                        .fogColor(DEFAULT_FOG)
                                        .skyColor(7972607)
                                        .waterColor(4350177)
                                        .waterFogColor(DEFAULT_WATER_FOG)
                                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JAGGED_PEAKS))
                                        .build()
                        )
                        .generationSettings(
                                new DefaultEthermistFeatures(context)
                                        .defaultFeatures(true)
                                        .builder()
                                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_EMERALD)
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

    }

}
