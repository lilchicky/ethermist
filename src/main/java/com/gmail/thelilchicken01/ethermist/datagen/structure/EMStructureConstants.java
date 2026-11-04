package com.gmail.thelilchicken01.ethermist.datagen.structure;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class EMStructureConstants {
    public static final StructureConstant FORGEMASTER_CASTLE = new StructureConstant("forgemaster_castle", "forgemaster_castle");
    public static final StructureConstant GLIMMERBUG_CAVE = new StructureConstant("glimmerbug_cave", "glimmerbug_cave");

    public static final StructureConstant ANCIENT_STONE_PORTAL = new StructureConstant("ancient_stone_portal", "portals", "portals");
    public static final StructureConstant SPARKLING_PORTAL = new StructureConstant("sparkling_portal", "portals", "portals");
    public static final StructureConstant STONE_PORTAL = new StructureConstant("stone_portal", "portals", "portals");
    public static final StructureConstant TIMEWORN_PORTAL = new StructureConstant("timeworn_portal", "portals", "portals");

    public static final StructureConstant GENERIC_RUINS = new StructureConstant("generic_ruins", "ruins", "ruins");
    public static final StructureConstant STONE_RUINS = new StructureConstant("stone_ruins", "ruins");

    public static class StructureConstant {

        private final String FOLDER;
        private final ResourceKey<Structure> STRUCTURE_KEY;
        private final ResourceKey<StructureSet> SET_KEY;

        public StructureConstant(String name) {
            this(name, name, null);
        }

        public StructureConstant(String name, String folder) {
            this(name, name, folder);
        }

        public StructureConstant(String name, String set_name, String folder) {
            String path = folder == null ? name : folder + "/" + name;

            this.FOLDER = folder;
            this.STRUCTURE_KEY = ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
            this.SET_KEY = ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, set_name));
        }

        public String getFolder() {
            return this.FOLDER + "/";
        }

        public String getNamedFolder() {
            // Get structure file name as a folder instead
            return this.STRUCTURE_KEY.location().getPath() + "/";
        }

        public ResourceKey<Structure> structure() {
            return this.STRUCTURE_KEY;
        }

        public ResourceKey<StructureSet> set() {
            return this.SET_KEY;
        }
    }
}
