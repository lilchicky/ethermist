package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntry;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
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
        return Stream.of(EMEntityTypes.GLOOMIE.get());
    }


    @Override
    public void generate() {

        add(EMEntityTypes.GLOOMIE.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(
                                        LootItem.lootTableItem(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                                .setWeight(1)
                                )
                                .add(EmptyLootItem.emptyItem().setWeight(3))
                )
        );

    }

}
