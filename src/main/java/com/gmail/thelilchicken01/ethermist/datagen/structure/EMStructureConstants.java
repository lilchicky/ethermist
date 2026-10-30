package com.gmail.thelilchicken01.ethermist.datagen.structure;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class EMStructureConstants {
    public static final StructureConstant FORGEMASTER_CASTLE = new StructureConstant("forgemaster_castle");
    public static final StructureConstant GLIMMERBUG_CAVE = new StructureConstant("glimmerbug_cave");

    public record StructureConstant(String name) {
        public ResourceKey<Structure> structureKey() {
            return customStructureKey(name);
        }

        public ResourceKey<Structure> customStructureKey(String name) {
            return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
        }

        public ResourceKey<StructureSet> setKey() {
            return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
        }
    }
}
