package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.loot.predicates.GlimmerbugPredicate;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.NbtPredicate;
import net.minecraft.advancements.critereon.SlimePredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.nbt.TagParser;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class EMEntityLootProvider extends EntityLootSubProvider {

    public EMEntityLootProvider(HolderLookup.Provider registries) {
        super(FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
        return Stream.of(
                EMEntityTypes.GLOOMIE.get(),
                EMEntityTypes.RUNIC_SKELETON.get(),
                EMEntityTypes.SIHEREK.get(),
                EMEntityTypes.GLIMMERBUG.get(),
                EMEntityTypes.GLIMMERBUG_QUEEN.get(),
                EMEntityTypes.ZALKUL.get()
        );
    }

    @Override
    public void generate() {

        add(EMEntityTypes.GLOOMIE.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(EMLootTableUtil.rangedDrop(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get(), 1, 2, 1))
                                .add(EMLootTableUtil.empty(3))
                )
        );

        add(EMEntityTypes.GLIMMERBUG.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(EMLootTableUtil.singleDrop(EMItems.GLIMMERBUG_ABDOMEN.get(), 1))
                                .when(
                                        LootItemEntityPropertyCondition.hasProperties(
                                                LootContext.EntityTarget.THIS,
                                                EntityPredicate.Builder.entity().subPredicate(GlimmerbugPredicate.isSummoned(false))
                                        )
                                )
                )
        );

        add(EMEntityTypes.GLIMMERBUG_QUEEN.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(EMLootTableUtil.singleDrop(EMItems.GLIMMERBUG_PARTS, 99))
                                .add(EMLootTableUtil.singleDrop(EMItems.GLIMMERBUG_ORB, 1))
                ).withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(EMLootTableUtil.rangedDrop(EMItems.GLIMMERBUG_ABDOMEN, 2, 6, 1))
                )
        );

        add(EMEntityTypes.RUNIC_SKELETON.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 0, 3, 1))
                )
        );

        add(EMEntityTypes.ZALKUL.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 0, 3, 1))
                ).withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BLAZE_POWDER, 0, 2, 1))
                ).withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(EMLootTableUtil.empty(99))
                                .add(EMLootTableUtil.singleDrop(EMItems.FLAME_ORB, 1))
                )
        );

        add(EMEntityTypes.SIHEREK.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(EMLootTableUtil.rangedDrop(Items.BONE, 0, 3, 30))
                                .add(EMLootTableUtil.singleDrop(EMItems.WOODEN_WAND_HANDLE, 1))
                )
        );

    }

}
