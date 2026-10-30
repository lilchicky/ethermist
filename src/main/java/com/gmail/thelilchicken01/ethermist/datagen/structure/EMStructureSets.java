package com.gmail.thelilchicken01.ethermist.datagen.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class EMStructureSets {

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
                EMStructureConstants.FORGEMASTER_CASTLE.setKey(),
                new StructureSet(
                        structures.getOrThrow(EMStructureConstants.FORGEMASTER_CASTLE.structureKey()),
                        new RandomSpreadStructurePlacement(128, 64, RandomSpreadType.LINEAR, 3554793)
                )
        );

        context.register(
                EMStructureConstants.GLIMMERBUG_CAVE.setKey(),
                new StructureSet(
                        structures.getOrThrow(EMStructureConstants.GLIMMERBUG_CAVE.structureKey()),
                        new RandomSpreadStructurePlacement(12, 4, RandomSpreadType.LINEAR, 98160847)
                )
        );
    }

}
