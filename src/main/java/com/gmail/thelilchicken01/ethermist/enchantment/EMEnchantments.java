package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.EMTags;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.*;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;

public class EMEnchantments {

    private static final int focusColor = 0x57B9FF;
    private static final int augmentColor = 0xBF77F6;

    public static final ResourceKey<Enchantment> QUICK_CAST = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "quick_cast"));
    public static final ResourceKey<Enchantment> ENDURING_MAGIC = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "enduring_magic"));
    public static final ResourceKey<Enchantment> ARCANE_VELOCITY = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "arcane_velocity"));
    public static final ResourceKey<Enchantment> ANCIENT_POWER = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "ancient_power"));
    public static final ResourceKey<Enchantment> RUNIC_FORCE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "runic_force"));
    public static final ResourceKey<Enchantment> STABLE_ORB = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "stable_orb"));
    public static final ResourceKey<Enchantment> AUGMENT_SPLIT = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_split"));
    public static final ResourceKey<Enchantment> AUGMENT_HOMING = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_homing"));
    public static final ResourceKey<Enchantment> FOCUS_MONSTERS = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "focus_monsters"));
    public static final ResourceKey<Enchantment> FOCUS_ANIMALS = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "focus_animals"));
    public static final ResourceKey<Enchantment> FOCUS_PLAYERS = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "focus_players"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchants = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        // Thorns = 1, Unbreaking = 5, Sharpness = 10

        register(context, QUICK_CAST, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        5,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(55, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new QuickCastEnchant())
        );

        register(context, ENDURING_MAGIC, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        5,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(55, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new EnduringMagicEnchant())
        );

        register(context, ARCANE_VELOCITY, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        5,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(55, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new ArcaneVelocityEnchant())
        );

        register(context, ANCIENT_POWER, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        5,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(55, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new AncientPowerEnchant())
        );

        register(context, RUNIC_FORCE, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        3,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(55, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new RunicForceEnchant())
        );

        register(context, STABLE_ORB, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        5,
                        4,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(55, 8),
                        2,
                        EquipmentSlotGroup.HAND))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new StableOrbEnchant())
        );

        register(context, AUGMENT_SPLIT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        3,
                        4,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(augmentColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.AUGMENT_SPELLS))
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new AugmentSplitEnchant())
        );

        register(context, AUGMENT_HOMING, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        1,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(augmentColor))
                .exclusiveWith(HolderSet.empty())
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new AugmentHomingEnchant())
        );

        register(context, FOCUS_MONSTERS, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.TOMES),
                        1,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(focusColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.FOCUS_SPELLS))
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new FocusMonstersEnchant())
        );

        register(context, FOCUS_ANIMALS, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.TOMES),
                        1,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(focusColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.FOCUS_SPELLS))
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new FocusAnimalsEnchant())
        );

        register(context, FOCUS_PLAYERS, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.TOMES),
                        1,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(focusColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.FOCUS_SPELLS))
                .withEffect(EnchantmentEffectComponents.AMMO_USE, new FocusPlayersEnchant())
        );

    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }

}
