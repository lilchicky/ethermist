package com.gmail.thelilchicken01.ethermist.datagen.loot;

import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class EMLootTableHelper {

    public static LootPoolEntryContainer.Builder<?> rangedDrop(ItemLike drop, int min, int max, int weight) {
        return LootItem.lootTableItem(drop)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                .setWeight(weight);
    }

    public static LootPoolEntryContainer.Builder<?> singleDrop(ItemLike drop, int weight) {
        return LootItem.lootTableItem(drop)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                .setWeight(weight);
    }

    public static LootPoolEntryContainer.Builder<?> empty(int weight) {
        return EmptyLootItem.emptyItem().setWeight(weight);
    }

    public static LootPoolEntryContainer.Builder<?> enchantedItem(ItemLike item, int weight, HolderLookup.Provider registries) {
        return LootItem.lootTableItem(item)
                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries))
                .setWeight(weight);
    }

    public static LootTable.Builder singleItemInject(ItemLike item, float chance) {
        BigInteger itemWeight;
        BigInteger total;
        BigDecimal probability = new BigDecimal(Float.toString(chance)).stripTrailingZeros();

        int scale = probability.scale();
        if (scale >= 0) {
            total = BigInteger.TEN.pow(scale);
            itemWeight = probability.unscaledValue();
        }
        else {
            itemWeight = probability.unscaledValue().multiply(BigInteger.TEN.pow(-scale));
            total = BigInteger.ONE;
        }

        BigInteger emptyWeight = total.subtract(itemWeight);
        BigInteger gcd = itemWeight.gcd(emptyWeight);

        itemWeight = itemWeight.divide(gcd);
        emptyWeight = emptyWeight.divide(gcd);

        return LootTable.lootTable().withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(EMLootTableHelper.singleDrop(item, itemWeight.intValue()))
                        .add(EMLootTableHelper.empty(emptyWeight.intValue()))
        );
    }

}
