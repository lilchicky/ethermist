package com.gmail.thelilchicken01.ethermist.datagen.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.List;

public class EMStructureSets {

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        // Forgemaster Castle
        context.register(
                EMStructureConstants.FORGEMASTER_CASTLE.set(),
                new StructureSet(
                        structures.getOrThrow(EMStructureConstants.FORGEMASTER_CASTLE.structure()),
                        new RandomSpreadStructurePlacement(128, 64, RandomSpreadType.LINEAR, 3554793)
                )
        );

        // Glimmerbug Cave
        context.register(
                EMStructureConstants.GLIMMERBUG_CAVE.set(),
                new StructureSet(
                        structures.getOrThrow(EMStructureConstants.GLIMMERBUG_CAVE.structure()),
                        new RandomSpreadStructurePlacement(12, 4, RandomSpreadType.LINEAR, 98160847)
                )
        );

        // Portals
        context.register(
                EMStructureConstants.ANCIENT_STONE_PORTAL.set("portals"),
                new StructureSet(
                        List.of(
                                new StructureSet.StructureSelectionEntry(structures.getOrThrow(EMStructureConstants.ANCIENT_STONE_PORTAL.structure()), 1),
                                new StructureSet.StructureSelectionEntry(structures.getOrThrow(EMStructureConstants.SPARKLING_PORTAL.structure()), 1),
                                new StructureSet.StructureSelectionEntry(structures.getOrThrow(EMStructureConstants.STONE_PORTAL.structure()), 1),
                                new StructureSet.StructureSelectionEntry(structures.getOrThrow(EMStructureConstants.TIMEWORN_PORTAL.structure()), 1)
                        ),
                        new RandomSpreadStructurePlacement(40, 20, RandomSpreadType.LINEAR, 43293109)
                )
        );

        // Ruins
        context.register(
                EMStructureConstants.GENERIC_RUINS.set(),
                new StructureSet(
                        List.of(
                                new StructureSet.StructureSelectionEntry(structures.getOrThrow(EMStructureConstants.GENERIC_RUINS.structure()), 1)
                        ),
                        new RandomSpreadStructurePlacement(4, 2, RandomSpreadType.LINEAR, 31390291)
                )
        );
    }

}
