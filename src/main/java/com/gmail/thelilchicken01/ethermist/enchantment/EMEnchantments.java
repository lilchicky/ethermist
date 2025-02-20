package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;

public class EMEnchantments {

    private static final int excludeColor = 0x5555FF;
    private static final int augmentColor = 0x55a4ff;
    private static final int mainSpellColor = 0x6b2ec7;

    public static final ResourceKey<Enchantment> QUICK_CAST = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "quick_cast"));
    public static final ResourceKey<Enchantment> ENDURING_MAGIC = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "enduring_magic"));
    public static final ResourceKey<Enchantment> ARCANE_VELOCITY = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "arcane_velocity"));
    public static final ResourceKey<Enchantment> ANCIENT_POWER = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "ancient_power"));
    public static final ResourceKey<Enchantment> RUNIC_FORCE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "runic_force"));
    public static final ResourceKey<Enchantment> STABLE_ORB = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "stable_orb"));
    public static final ResourceKey<Enchantment> AUGMENT_SPLIT = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_split"));
    public static final ResourceKey<Enchantment> AUGMENT_HOMING = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_homing"));
    public static final ResourceKey<Enchantment> EXCLUDE_MONSTERS = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "exclude_monsters"));
    public static final ResourceKey<Enchantment> EXCLUDE_ANIMALS = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "exclude_animals"));
    public static final ResourceKey<Enchantment> EXCLUDE_PLAYERS = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "exclude_players"));
    public static final ResourceKey<Enchantment> AUGMENT_AOE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_aoe"));
    public static final ResourceKey<Enchantment> AUGMENT_SPRAY = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_spray"));
    public static final ResourceKey<Enchantment> AUGMENT_METEOR = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_meteor"));
    public static final ResourceKey<Enchantment> FIREBALL = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "fireball"));
    public static final ResourceKey<Enchantment> CHAOS_MAGIC = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "chaos_magic"));
    public static final ResourceKey<Enchantment> THUNDERSTRIKE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "thunderstrike"));
    public static final ResourceKey<Enchantment> KINETIC_RUSH = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "kinetic_rush"));
    public static final ResourceKey<Enchantment> VOLATILE_ENERGY = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "volatile_energy"));
    public static final ResourceKey<Enchantment> SEISMIC_SURGE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "seismic_surge"));
    public static final ResourceKey<Enchantment> AUGMENT_ABUNDANCE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_abundance"));
    public static final ResourceKey<Enchantment> AUGMENT_FOCUS = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "augment_focus"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchants = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        // Thorns = 1, Unbreaking = 5, Sharpness = 10

        /*
        ---------- Base Enchants ----------
         */

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
        );

        /*
        ---------- Augment Enchants ----------
         */

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
        );

        register(context, AUGMENT_AOE, Enchantment.enchantment(Enchantment.definition(
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
        );

        register(context, AUGMENT_SPRAY, Enchantment.enchantment(Enchantment.definition(
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
        );

        register(context, AUGMENT_METEOR, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        3,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(augmentColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.AUGMENT_SPELLS))
        );

        register(context, AUGMENT_ABUNDANCE, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        3,
                        4,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(augmentColor))
                .exclusiveWith(HolderSet.empty())
        );

        register(context, AUGMENT_FOCUS, Enchantment.enchantment(Enchantment.definition(
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
        );

        /*
        ---------- Focus Enchants ----------
         */

        register(context, EXCLUDE_MONSTERS, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.TOMES),
                        1,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(excludeColor))
                .exclusiveWith(HolderSet.empty())
        );

        register(context, EXCLUDE_ANIMALS, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.TOMES),
                        1,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(excludeColor))
                .exclusiveWith(HolderSet.empty())
        );

        register(context, EXCLUDE_PLAYERS, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.TOMES),
                        1,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(excludeColor))
                .exclusiveWith(HolderSet.empty())
        );

        /*
        ---------- Focus Enchants ----------
         */

        register(context, FIREBALL, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        1,
                        3,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(mainSpellColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.MAIN_DAMAGE_SPELLS))
        );

        register(context, CHAOS_MAGIC, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        1,
                        3,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(mainSpellColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.MAIN_DAMAGE_SPELLS))
        );

        register(context, THUNDERSTRIKE, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        1,
                        3,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(mainSpellColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.MAIN_DAMAGE_SPELLS))
        );

        register(context, KINETIC_RUSH, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        1,
                        1,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(mainSpellColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.MAIN_DAMAGE_SPELLS))
        );

        register(context, VOLATILE_ENERGY, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        1,
                        3,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(mainSpellColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.MAIN_DAMAGE_SPELLS))
        );

        register(context, SEISMIC_SURGE, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(EMTags.Items.MAGIC_ENCHANTABLE),
                        items.getOrThrow(EMTags.Items.WANDS),
                        1,
                        3,
                        Enchantment.dynamicCost(1, 11),
                        Enchantment.dynamicCost(21, 11),
                        2,
                        EquipmentSlotGroup.HAND))
                .withCustomName(c -> c.withColor(mainSpellColor))
                .exclusiveWith(enchants.getOrThrow(EMTags.Enchantments.MAIN_DAMAGE_SPELLS))
        );

    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }

}
