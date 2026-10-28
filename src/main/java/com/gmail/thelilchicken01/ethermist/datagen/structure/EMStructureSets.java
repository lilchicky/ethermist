package com.gmail.thelilchicken01.ethermist.datagen.structure;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class EMStructureSets {

    public static final ResourceKey<StructureSet> FORGEMASTER_CASTLE = create("forgemaster_castle");

    private static ResourceKey<StructureSet> create(String path) {
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
    }

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
                FORGEMASTER_CASTLE,
                new StructureSet(
                        structures.getOrThrow(EMStructures.FORGEMASTER_CASTLE),
                        new RandomSpreadStructurePlacement(128, 64, RandomSpreadType.LINEAR, 3554793)
                )
        );
    }

}
