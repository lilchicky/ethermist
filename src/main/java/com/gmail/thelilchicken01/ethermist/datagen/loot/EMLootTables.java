package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EMLootTables {

    private static final Set<ResourceKey<LootTable>> LOCATIONS = new HashSet<>();
    private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    // Chests
    public static final ResourceKey<LootTable> FORGEMASTER_GENERIC = chest("forgemaster_generic");

    // Injections
    public static final ResourceKey<LootTable> WITCH_ORB_TO_WITCH = inject("witch_orb/witch_orb_to_witch");
    public static final ResourceKey<LootTable> WITCH_ORB_TO_PILLAGER_OUTPOST = inject("witch_orb/witch_orb_to_pillager_outpost");

    public static final ResourceKey<LootTable> DULL_ORB_TO_SIMPLE_DUNGEON = inject("dull_orb/dull_orb_to_simple_dungeon");
    public static final ResourceKey<LootTable> DULL_ORB_TO_STRONGHOLD_CORRIDOR = inject("dull_orb/dull_orb_to_stronghold_corridor");
    public static final ResourceKey<LootTable> DULL_ORB_TO_STRONGHOLD_CROSSING = inject("dull_orb/dull_orb_to_stronghold_crossing");

    public static final ResourceKey<LootTable> FLAME_ORB_TO_NETHER_BRIDGE = inject("flame_orb/flame_orb_to_nether_bridge");
    public static final ResourceKey<LootTable> FLAME_ORB_TO_BASTION_OTHER = inject("flame_orb/flame_orb_to_bastion_other");

    public static final ResourceKey<LootTable> POISON_ORB_TO_CAVE_SPIDER = inject("poison_orb/poison_orb_to_cave_spider");
    public static final ResourceKey<LootTable> POISON_ORB_TO_JUNGLE_TEMPLE = inject("poison_orb/poison_orb_to_jungle_temple");
    public static final ResourceKey<LootTable> POISON_ORB_TO_MINESHAFT = inject("poison_orb/poison_orb_to_mineshaft");

    public static final ResourceKey<LootTable> LEVITATION_ORB_TO_END_CITY = inject("levitation_orb/levitation_orb_to_end_city");

    public static final ResourceKey<LootTable> FROZEN_ORB_TO_IGLOO = inject("frozen_orb/frozen_orb_to_igloo");

    public static final ResourceKey<LootTable> ANCIENT_ORB_TO_ANCIENT_CITY = inject("ancient_orb/ancient_orb_to_ancient_city");

    public EMLootTables() {}

    private static ResourceKey<LootTable> inject(String name) {
        return register("inject/" + name);
    }

    private static ResourceKey<LootTable> chest(String name) {
        return register("chests/" + name);
    }

    private static ResourceKey<LootTable> register(String name) {
        return register(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name)));
    }

    private static ResourceKey<LootTable> register(ResourceKey<LootTable> name) {
        if (LOCATIONS.add(name)) {
            return name;
        } else {
            throw new IllegalArgumentException(name.location() + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceKey<LootTable>> all() {
        return IMMUTABLE_LOCATIONS;
    }

}
