package com.gmail.thelilchicken01.ethermist.worldgen.biome;

import com.gmail.thelilchicken01.ethermist.worldgen.EMGeneralPlacedFeatures;
import com.gmail.thelilchicken01.ethermist.worldgen.EMOresPlaced;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class DefaultEthermistFeatures {

    private final BiomeGenerationSettings.Builder BUILDER;

    public DefaultEthermistFeatures(BootstrapContext<Biome> context) {
        this.BUILDER = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
    }

    public BiomeGenerationSettings.Builder builder() {
        return this.BUILDER;
    }

    public DefaultEthermistFeatures defaultFeatures() {
        this
                .addCarvers()
                .addOres()
                .addUndergroundStructures()
                .addDefaultVegetation()
                .addLocalFeatures()
                .freeze()
                .addSprings(false)
                .addLakes(false);

        return this;
    }

    public DefaultEthermistFeatures burningCrags() {
        this
                .addCarvers()
                .addOres()
                .addUndergroundStructures()
                .addDefaultVegetation()
                .addLocalFeatures()
                .freeze()
                .addLakes(true)
                .addSprings(true);

        this.BUILDER.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.CRAG_SPIKE_PLACED);

        return this;
    }

    public DefaultEthermistFeatures addOres() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.RICH_DIRT_BLOB)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.CRUMBLING_ETHERSTONE_BLOB)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.WITCHSTONE_BLOB_UPPER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.WITCHSTONE_BLOB_LOWER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.DAWNMARL_BLOB_UPPER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.DAWNMARL_BLOB_LOWER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.DUSKSHALE_BLOB_UPPER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.DUSKSHALE_BLOB_LOWER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_COAL_UPPER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_COAL_LOWER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_IRON_UPPER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_IRON_MIDDLE)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_IRON_SMALL)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_GOLD)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_GOLD_LOWER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_REDSTONE)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_REDSTONE_LOWER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_DIAMOND)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_DIAMOND_MEDIUM)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_DIAMOND_LARGE)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_DIAMOND_BURIED)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_LAPIS)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_LAPIS_BURIED)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.ETHERSTONE_ORE_COPPER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CavePlacements.UNDERWATER_MAGMA)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.CRUMBLING_ETHERSTONE_BLOB)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMGeneralPlacedFeatures.SPARKLING_SAND_DISK);

        return this;
    }

    public DefaultEthermistFeatures addCarvers() {
        this.BUILDER
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND)
                .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);

        return this;
    }

    public DefaultEthermistFeatures addUndergroundStructures() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.MONSTER_ROOM)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.MONSTER_ROOM_DEEP);

        return this;
    }

    public DefaultEthermistFeatures freeze() {
        this.BUILDER.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, MiscOverworldPlacements.FREEZE_TOP_LAYER);
        return this;
    }

    public DefaultEthermistFeatures addLakes(boolean isDense) {
        this.BUILDER.addFeature(GenerationStep.Decoration.LAKES, EMGeneralPlacedFeatures.ETHERMIST_LAVA_LAKE);
        return this;
    }

    public DefaultEthermistFeatures addLocalFeatures() {
        this.BUILDER.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CavePlacements.AMETHYST_GEODE);
        return this;
    }

    public DefaultEthermistFeatures addDefaultVegetation() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.ETHERMIST_GLOW_LICHEN)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.LARGE_ABYSSAL_MUSHROOM_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SMALL_ABYSSAL_MUSHROOM_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.NIGHTBELL_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.WITCH_LAVENDER_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DAWNING_HYACINTH_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.PYRUSCIA_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.RICH_GRASS_PATCH);

        return this;
    }

    public DefaultEthermistFeatures addDenseVegetation() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_NIGHTBELL_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_WITCH_LAVENDER_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_DAWNING_HYACINTH_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_PYRUSCIA_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_RICH_GRASS_PATCH);

        return this;
    }

    public DefaultEthermistFeatures addSprings(boolean isDense) {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, EMGeneralPlacedFeatures.EM_WATER_SPRING_PLACED)
                .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, (
                        isDense ? EMGeneralPlacedFeatures.EM_DENSE_LAVA_SPRING_PLACED : EMGeneralPlacedFeatures.EM_LAVA_SPRING_PLACED
                ));

        return this;
    }

    public DefaultEthermistFeatures addAbyssalShrooms(boolean aboveGround) {
        if (aboveGround) {
            this.BUILDER
                    .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.LARGE_GROUNDED_ABYSSAL_MUSHROOM_PATCH)
                    .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SMALL_GROUNDED_ABYSSAL_MUSHROOM_PATCH)
                    .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SPARSE_LARGE_ABYSSAL_MUSHROOM);
        }
        else {
            this.BUILDER.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.LARGE_ABYSSAL_MUSHROOM);
        }

        return this;
    }

}
