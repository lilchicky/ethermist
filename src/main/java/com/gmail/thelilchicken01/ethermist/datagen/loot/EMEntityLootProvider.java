package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.*;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
                EMEntityTypes.SPECTRAL_LICH.get()
        );
    }

    @Override
    public void generate() {

        add(EMEntityTypes.GLOOMIE.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(getDrop(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get(), 1, 2, 1))
                                .add(EmptyLootItem.emptyItem().setWeight(3))
                )
        );

        add(EMEntityTypes.RUNIC_SKELETON.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(getDrop(Items.BONE, 0, 3, 1))
                )
        );

        add(EMEntityTypes.SPECTRAL_LICH.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(getDrop(Items.BONE, 0, 3, 30))
                                .add(getDrop(EMItems.WOODEN_WAND_HANDLE, 1, 1, 1))
                )
        );

    }

    private LootPoolEntryContainer.Builder<?> getDrop(ItemLike drop, int min, int max, int weight) {
        return LootItem.lootTableItem(drop)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                .setWeight(weight);
    }

}
