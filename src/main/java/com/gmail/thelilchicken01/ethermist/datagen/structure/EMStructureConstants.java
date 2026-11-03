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

    public static final StructureConstant ANCIENT_STONE_PORTAL = new StructureConstant("ancient_stone_portal");
    public static final StructureConstant SPARKLING_PORTAL = new StructureConstant("sparkling_portal");
    public static final StructureConstant STONE_PORTAL = new StructureConstant("stone_portal");
    public static final StructureConstant TIMEWORN_PORTAL = new StructureConstant("timeworn_portal");

    public record StructureConstant(String name) {
        public ResourceKey<Structure> structure() {
            return structure(name);
        }

        public ResourceKey<Structure> structure(String name) {
            return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
        }

        public ResourceKey<StructureSet> set() {
            return set(name);
        }

        public ResourceKey<StructureSet> set(String name) {
            return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name));
        }
    }
}
