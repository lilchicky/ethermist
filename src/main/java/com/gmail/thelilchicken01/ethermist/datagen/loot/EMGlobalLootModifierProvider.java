package com.gmail.thelilchicken01.ethermist.datagen.loot;

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

    public EMGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Ethermist.MODID);
    }

    @Override
    protected void start() {

        /*
        ----------  Witch Orb  ----------
         */

        this.add("witch_orb_to_witch", addLootTable("entities/witch", EMLootTables.WITCH_ORB_TO_WITCH));
        this.add("witch_orb_to_pillager_outpost", addLootTable("chests/pillager_outpost", EMLootTables.WITCH_ORB_TO_PILLAGER_OUTPOST));

        /*
        ----------  Dull Orb  ----------
         */

        this.add("dull_orb_to_simple_dungeon", addLootTable("chests/simple_dungeon", EMLootTables.DULL_ORB_TO_SIMPLE_DUNGEON));
        this.add("dull_orb_to_stronghold_corridor", addLootTable("chests/stronghold_corridor", EMLootTables.DULL_ORB_TO_STRONGHOLD_CORRIDOR));
        this.add("dull_orb_to_stronghold_crossing", addLootTable("chests/stronghold_crossing", EMLootTables.DULL_ORB_TO_STRONGHOLD_CROSSING));

        /*
        ----------  Flame Orb  ----------
         */

        this.add("flame_orb_to_nether_bridge", addLootTable("chests/nether_bridge", EMLootTables.FLAME_ORB_TO_NETHER_BRIDGE));
        this.add("flame_orb_to_bastion_other", addLootTable("chests/bastion_other", EMLootTables.FLAME_ORB_TO_BASTION_OTHER));

        /*
        ----------  Poison Orb  ----------
         */

        this.add("poison_orb_to_cave_spider", addLootTable("entities/cave_spider", EMLootTables.POISON_ORB_TO_CAVE_SPIDER));
        this.add("poison_orb_to_jungle_temple", addLootTable("chests/jungle_temple", EMLootTables.POISON_ORB_TO_JUNGLE_TEMPLE));
        this.add("poison_orb_to_mineshaft", addLootTable("chests/abandoned_mineshaft", EMLootTables.POISON_ORB_TO_MINESHAFT));

        /*
        ----------  Levitation Orb  ----------
         */

        this.add("levitation_orb_to_end_city_treasure", addLootTable("chests/end_city_treasure", EMLootTables.LEVITATION_ORB_TO_END_CITY));

        /*
        ----------  Frozen Orb  ----------
         */

        this.add("frozen_orb_to_igloo", addLootTable("chests/igloo_chest", EMLootTables.FROZEN_ORB_TO_IGLOO));

        /*
        ----------  Ancient Orb  ----------
         */

        this.add("ancient_orb_to_ancient_city", addLootTable("chests/ancient_city", EMLootTables.ANCIENT_ORB_TO_ANCIENT_CITY));

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
