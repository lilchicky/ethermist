package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class EMGlobalLootModifierProvider extends GlobalLootModifierProvider {

    private static final ResourceKey<LootTable> WITCH_ORB_TO_WITCH = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/witch_orb/witch_orb_to_witch"));
    private static final ResourceKey<LootTable> WITCH_ORB_TO_PILLAGER_OUTPOST = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/witch_orb/witch_orb_to_pillager_outpost"));

    private static final ResourceKey<LootTable> DULL_ORB_TO_SIMPLE_DUNGEON = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/dull_orb/dull_orb_to_simple_dungeon"));
    private static final ResourceKey<LootTable> DULL_ORB_TO_STRONGHOLD_CORRIDOR = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/dull_orb/dull_orb_to_stronghold_corridor"));
    private static final ResourceKey<LootTable> DULL_ORB_TO_STRONGHOLD_CROSSING = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/dull_orb/dull_orb_to_stronghold_crossing"));

    private static final ResourceKey<LootTable> FLAME_ORB_TO_NETHER_BRIDGE = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/flame_orb/flame_orb_to_nether_bridge"));
    private static final ResourceKey<LootTable> FLAME_ORB_TO_BASTION_OTHER = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/flame_orb/flame_orb_to_bastion_other"));

    private static final ResourceKey<LootTable> POISON_ORB_TO_CAVE_SPIDER = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/poison_orb/poison_orb_to_cave_spider"));
    private static final ResourceKey<LootTable> POISON_ORB_TO_JUNGLE_TEMPLE = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/poison_orb/poison_orb_to_jungle_temple"));
    private static final ResourceKey<LootTable> POISON_ORB_TO_MINESHAFT = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/poison_orb/poison_orb_to_mineshaft"));

    private static final ResourceKey<LootTable> LEVITATION_ORB_TO_END_CITY = ResourceKey.create(Registries.LOOT_TABLE,
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "inject/levitation_orb/levitation_orb_to_end_city"));

    public EMGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Ethermist.MODID);
    }

    @Override
    protected void start() {

        /*
        ----------  Witch Orb  ----------
         */

        this.add("witch_orb_to_witch", addLootTable("entities/witch", WITCH_ORB_TO_WITCH));
        this.add("witch_orb_to_pillager_outpost", addLootTable("chests/pillager_outpost", WITCH_ORB_TO_PILLAGER_OUTPOST));

        /*
        ----------  Dull Orb  ----------
         */

        this.add("dull_orb_to_simple_dungeon", addLootTable("chests/simple_dungeon", DULL_ORB_TO_SIMPLE_DUNGEON));
        this.add("dull_orb_to_stronghold_corridor", addLootTable("chests/stronghold_corridor", DULL_ORB_TO_STRONGHOLD_CORRIDOR));
        this.add("dull_orb_to_stronghold_crossing", addLootTable("chests/stronghold_crossing", DULL_ORB_TO_STRONGHOLD_CROSSING));

        /*
        ----------  Flame Orb  ----------
         */

        this.add("flame_orb_to_nether_bridge", addLootTable("chests/nether_bridge", FLAME_ORB_TO_NETHER_BRIDGE));
        this.add("flame_orb_to_bastion_other", addLootTable("chests/bastion_other", FLAME_ORB_TO_BASTION_OTHER));

        /*
        ----------  Poison Orb  ----------
         */

        this.add("poison_orb_to_cave_spider", addLootTable("entities/cave_spider", POISON_ORB_TO_CAVE_SPIDER));
        this.add("poison_orb_to_jungle_temple", addLootTable("chests/jungle_temple", POISON_ORB_TO_JUNGLE_TEMPLE));
        this.add("poison_orb_to_mineshaft", addLootTable("chests/abandoned_mineshaft", POISON_ORB_TO_MINESHAFT));

        /*
        ----------  Levitation Orb  ----------
         */

        this.add("levitation_orb_to_end_city_treasure", addLootTable("chests/end_city_treasure", LEVITATION_ORB_TO_END_CITY));

    }

    private AddTableLootModifier addLootTable(String table, ResourceKey<LootTable> key) {

        return new AddTableLootModifier(
                new LootItemCondition[] {
                        new LootTableIdCondition.Builder(
                                ResourceLocation.withDefaultNamespace(table)
                        ).build()
                },
                key
        );

    }

}
