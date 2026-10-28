package com.gmail.thelilchicken01.ethermist.worldgen.biome;

import com.gmail.thelilchicken01.ethermist.worldgen.EMGeneralPlacedFeatures;
import com.gmail.thelilchicken01.ethermist.worldgen.EMOresPlaced;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
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

    public DefaultEthermistFeatures defaultFeatures(boolean isCold) {
        this
                .addCarvers()
                .addOres()
                .addUndergroundStructures()
                .addDefaultVegetation(isCold)
                .addLocalFeatures()
                .freeze()
                .addSprings(false)
                .addLakes(false);

        return this;
    }

    public DefaultEthermistFeatures populateBurningCrags() {
        this
                .addCarvers()
                .addOres()
                .addUndergroundStructures()
                .addLocalFeatures()
                .freeze()
                .addLakes(true)
                .addSprings(true)
                .addFossils(true);

        this.BUILDER.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.CHARRED_TREE_STUMP);
        this.BUILDER.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.CHARRED_TREE);
        this.BUILDER.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.CHARRED_DEAD_LOG);
        this.BUILDER.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.CINDERBLOOM_PATCH);
        this.BUILDER.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.RICH_GRASS_PATCH);

        this.BUILDER.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.CRAG_SPIKE);
        this.BUILDER.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.BLACKSTONE_BLOB_UPPER);
        this.BUILDER.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMOresPlaced.BLACKSTONE_BLOB_LOWER);
        this.BUILDER.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMGeneralPlacedFeatures.MOLTEN_ETHERSTONE_DISK);

        return this;
    }

    public DefaultEthermistFeatures populateAncientForest() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.ETHERSTONE_BOULDER)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.MEGA_ANCIENT_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.ANCIENT_TREE);

        return this;
    }

    public DefaultEthermistFeatures populateAmberwoodGrove() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.RED_AMBERWOOD_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.ORANGE_AMBERWOOD_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.YELLOW_AMBERWOOD_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.GREEN_AMBERWOOD_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.FALLEN_AMBERWOOD_LEAVES);

        return this;
    }

    public DefaultEthermistFeatures populateAncientField() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SPARSE_ANCIENT_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.RICH_TALL_GRASS_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_RICH_GRASS_PATCH);

        return this;
    }

    public DefaultEthermistFeatures populateBloomingMeadows() {
        this.populateAncientField();
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_NIGHTBELL_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_WITCH_LAVENDER_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_DAWNING_HYACINTH_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_PYRUSCIA_PATCH);

        return this;
    }

    public DefaultEthermistFeatures populateFrostpineForest() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.FROSTPINE_TREE);

        return this;
    }

    public DefaultEthermistFeatures populateFrozenExpanse() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SPARSE_FROSTPINE_TREE)
                .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.ICICLE_GROUND);

        return this;
    }

    public DefaultEthermistFeatures populateGlimmeringAncientForest() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.MEGA_GLIMMERING_ANCIENT_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.GLIMMERING_ANCIENT_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.BUSH_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.GLIMMERBUD_PATCH);

        return this;
    }

    public DefaultEthermistFeatures populateSlimyForest() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SLIMY_TREE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DENSE_SLIMY_ALLIUM_PATCH);

        return this;
    }

    public DefaultEthermistFeatures populateTimewornDesert() {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.CHRONOTHORN_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH_2)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_CACTUS_DESERT);

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
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EMGeneralPlacedFeatures.CRUMBLING_ETHERSTONE_DISK)
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

    public DefaultEthermistFeatures addDefaultVegetation(boolean isCold) {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.ETHERMIST_GLOW_LICHEN)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.LARGE_ABYSSAL_MUSHROOM_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SMALL_ABYSSAL_MUSHROOM_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.NIGHTBELL_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.WITCH_LAVENDER_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.DAWNING_HYACINTH_PATCH)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.RICH_GRASS_PATCH);

        if (!isCold) {
            this.BUILDER.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.PYRUSCIA_PATCH);
        }

        return this;
    }

    public DefaultEthermistFeatures addSprings(boolean isDense) {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, EMGeneralPlacedFeatures.EM_WATER_SPRING)
                .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, (
                        isDense ? EMGeneralPlacedFeatures.EM_DENSE_LAVA_SPRING : EMGeneralPlacedFeatures.EM_LAVA_SPRING
                ));

        return this;
    }

    public DefaultEthermistFeatures addSourdewPatch() {
        this.BUILDER.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EMGeneralPlacedFeatures.SOURDEW_PATCH);
        return this;
    }

    public DefaultEthermistFeatures addFossils(boolean onSurface) {
        this.BUILDER
                .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.FOSSIL_UPPER)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.FOSSIL_LOWER);

        if (onSurface) {
            this.BUILDER.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EMGeneralPlacedFeatures.ABYSSAL_FOSSIL);
        }

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
