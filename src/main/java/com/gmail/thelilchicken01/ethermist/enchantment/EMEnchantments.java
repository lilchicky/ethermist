package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.EMTags;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.AncientPowerEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.ArcaneVelocityEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.GreaterDistanceEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.QuickCastEnchant;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;

public class EMEnchantments {

    public static final ResourceKey<Enchantment> QUICK_CAST = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "quick_cast"));
    public static final ResourceKey<Enchantment> GREATER_DISTANCE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "greater_distance"));
    public static final ResourceKey<Enchantment> ARCANE_VELOCITY = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "arcane_velocity"));
    public static final ResourceKey<Enchantment> ANCIENT_POWER = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "ancient_power"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchants = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        // Thorns = 1, Unbreaking = 5, Sharpness = 10

        register(context, QUICK_CAST, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.WANDS),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        5,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new QuickCastEnchant())
        );

        register(context, GREATER_DISTANCE, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.WANDS),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        5,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new GreaterDistanceEnchant())
        );

        register(context, ARCANE_VELOCITY, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.WANDS),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        5,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new ArcaneVelocityEnchant())
        );

        register(context, ANCIENT_POWER, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.WANDS),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        5,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new AncientPowerEnchant())
        );

    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }

}
