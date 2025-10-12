package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.armor.EMArmorMaterials;
import com.gmail.thelilchicken01.ethermist.item.foods.ShroomCluster;
import com.gmail.thelilchicken01.ethermist.item.foods.ToastedShroomCluster;
import com.gmail.thelilchicken01.ethermist.item.wands.*;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects.EMWandOrbs;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.EMWandHandles;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.BookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ethermist.MODID);

    public static final DeferredItem<WandShotItem> GENERIC_SHOT = ITEMS.register("generic_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> FLAME_SHOT = ITEMS.register("flame_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> POISON_SHOT = ITEMS.register("poison_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> LEVITATION_SHOT = ITEMS.register("levitation_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> WITHER_SHOT = ITEMS.register("wither_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> WITCH_SHOT = ITEMS.register("witch_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> HEAVY_SHOT = ITEMS.register("heavy_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> FROZEN_SHOT = ITEMS.register("frozen_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> GLASS_SHOT = ITEMS.register("glass_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> GLIMMERBUG_SHOT = ITEMS.register("glimmerbug_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> FORGEMASTER_HEART_SHOT = ITEMS.register("forgemaster_heart_shot", WandShotItem::new);

    public static final DeferredItem<WandShotItem> FORGEMASTER_SHOT = ITEMS.register("forgemaster_shot", WandShotItem::new);

    /*
    ---------- Orbs ----------
     */

    public static final DeferredItem<OrbItem> DULL_ORB = ITEMS.register("dull_orb", () -> new OrbItem(EMWandOrbs.DULL));
    public static final DeferredItem<OrbItem> FLAME_ORB = ITEMS.register("flame_orb", () -> new OrbItem(EMWandOrbs.FLAME));
    public static final DeferredItem<OrbItem> POISON_ORB = ITEMS.register("poison_orb", () -> new OrbItem(EMWandOrbs.POISON));
    public static final DeferredItem<OrbItem> LEVITATION_ORB = ITEMS.register("levitation_orb", () -> new OrbItem(EMWandOrbs.LEVITATION));
    public static final DeferredItem<OrbItem> WITHER_ORB = ITEMS.register("wither_orb", () -> new OrbItem(EMWandOrbs.WITHER));
    public static final DeferredItem<OrbItem> WITCH_ORB = ITEMS.register("witch_orb", () -> new OrbItem(EMWandOrbs.WITCH));
    public static final DeferredItem<OrbItem> FROZEN_ORB = ITEMS.register("frozen_orb", () -> new OrbItem(EMWandOrbs.FROZEN));
    public static final DeferredItem<OrbItem> GLASS_ORB = ITEMS.register("glass_orb", () -> new OrbItem(EMWandOrbs.GLASS));
    public static final DeferredItem<OrbItem> GLIMMERBUG_ORB = ITEMS.register("glimmerbug_orb", () -> new OrbItem(EMWandOrbs.GLIMMERBUG));
    public static final DeferredItem<OrbItem> FORGEMASTER_HEART_ORB = ITEMS.register("forgemaster_heart_orb", () -> new OrbItem(EMWandOrbs.FORGEMASTER_HEART));

    /*
    ---------- Wands ----------
    */
    public static final DeferredItem<WandItem> DULL_WAND = ITEMS.register("dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> FLAME_WAND = ITEMS.register("flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> POISON_WAND = ITEMS.register("poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> LEVITATION_WAND = ITEMS.register("levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> WITHER_WAND = ITEMS.register("wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> WITCH_WAND = ITEMS.register("witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> HEAVY_WAND = ITEMS.register("heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> FROZEN_WAND = ITEMS.register("frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> GLASS_WAND = ITEMS.register("glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> GLIMMERBUG_WAND = ITEMS.register("glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> FORGED_HEART_WAND = ITEMS.register("forged_heart_wand", () -> new WandItem(EMWandOrbs.FORGEMASTER_HEART, EMWandHandles.WOODEN));

     /*
    ---------- Handles ----------
     */

    public static final DeferredItem<Item> WOODEN_WAND_HANDLE = ITEMS.register("wooden_wand_handle", () -> new HandleItem(EMWandHandles.WOODEN));
    public static final DeferredItem<Item> EMERALD_WAND_HANDLE = ITEMS.register("emerald_wand_handle", () -> new HandleItem(EMWandHandles.EMERALD));
    public static final DeferredItem<Item> DIAMOND_WAND_HANDLE = ITEMS.register("diamond_wand_handle", () -> new HandleItem(EMWandHandles.DIAMOND));
    public static final DeferredItem<Item> GOLDEN_WAND_HANDLE = ITEMS.register("golden_wand_handle", () -> new HandleItem(EMWandHandles.GOLDEN));
    public static final DeferredItem<Item> LAPIS_WAND_HANDLE = ITEMS.register("lapis_wand_handle", () -> new HandleItem(EMWandHandles.LAPIS));
    public static final DeferredItem<Item> QUARTZ_WAND_HANDLE = ITEMS.register("quartz_wand_handle", () -> new HandleItem(EMWandHandles.QUARTZ));
    public static final DeferredItem<Item> REDSTONE_WAND_HANDLE = ITEMS.register("redstone_wand_handle", () -> new HandleItem(EMWandHandles.REDSTONE));
    public static final DeferredItem<Item> GLOWSTONE_WAND_HANDLE = ITEMS.register("glowstone_wand_handle", () -> new HandleItem(EMWandHandles.GLOWSTONE));
    public static final DeferredItem<Item> PRISMARINE_WAND_HANDLE = ITEMS.register("prismarine_wand_handle", () -> new HandleItem(EMWandHandles.PRISMARINE));
    public static final DeferredItem<Item> NETHERITE_WAND_HANDLE = ITEMS.register("netherite_wand_handle", () -> new HandleItem(EMWandHandles.NETHERITE));

    /*
    ---------- Tomes ----------
     */

    public static final DeferredItem<BookItem> EXCLUSION_TOME = ITEMS.register("exclusion_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> WAND_TOME = ITEMS.register("wand_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> AUGMENT_TOME = ITEMS.register("augment_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> MAIN_SPELL_TOME = ITEMS.register("main_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> BASE_SPELL_TOME = ITEMS.register("base_spell_tome", TomeItem::new);

    /*
    ---------- Foods ----------
     */

    public static final DeferredItem<Item> SHROOM_CLUSTER = ITEMS.register("shroom_cluster", ShroomCluster::new);
    public static final DeferredItem<Item> TOASTED_SHROOM_CLUSTER = ITEMS.register("toasted_shroom_cluster", ToastedShroomCluster::new);

    /*
    ---------- Spawn Eggs ----------
     */

    public static final DeferredItem<Item> GLOOMIE_SPAWN_EGG = ITEMS.register("gloomie_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.GLOOMIE, 0x211b52, 0x804617, new Item.Properties()));
    public static final DeferredItem<Item> GLIMMERBUG_QUEEN_SPAWN_EGG = ITEMS.register("glimmerbug_queen_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.GLIMMERBUG_QUEEN, 0xd47958, 0xc85a32, new Item.Properties()));
    public static final DeferredItem<Item> GLIMMERBUG_SPAWN_EGG = ITEMS.register("glimmerbug_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.GLIMMERBUG, 0xc85a32, 0x276c22, new Item.Properties()));
    public static final DeferredItem<Item> FORGEMASTER_SPAWN_EGG = ITEMS.register("forgemaster_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.FORGEMASTER, 0x7F7F7F, 0xA64DFF, new Item.Properties()));
    public static final DeferredItem<Item> PYLON_SPAWN_EGG = ITEMS.register("pylon_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.PYLON, 0xFF3B3B, 0x7F7F7F, new Item.Properties()));
    public static final DeferredItem<Item> RUNIC_SKELETON_SPAWN_EGG = ITEMS.register("runic_skeleton_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.RUNIC_SKELETON, 0xaf815e, 0x832387, new Item.Properties()));

    /*
    ---------- Equipment ----------
     */

    public static final DeferredItem<ArmorItem> LEATHER_HOOD = ITEMS.register("leather_hood",
            () -> new ArmorItem(EMArmorMaterials.LEATHER_HOOD, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(5))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(EMAttributes.WAND_DAMAGE, new AttributeModifier(
                                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "hood.damage"),
                                            0.5,
                                            AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.HEAD)
                                    .build())));

    public static final DeferredItem<ArmorItem> IRON_HOOD = ITEMS.register("iron_hood",
            () -> new ArmorItem(EMArmorMaterials.IRON_HOOD, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(EMAttributes.WAND_DAMAGE, new AttributeModifier(
                                                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "hood.damage"),
                                                    1,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.HEAD)
                                    .build())));

    public static final DeferredItem<ArmorItem> GOLDEN_HOOD = ITEMS.register("golden_hood",
            () -> new ArmorItem(EMArmorMaterials.GOLD_HOOD, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(7))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(EMAttributes.WAND_DAMAGE, new AttributeModifier(
                                                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "hood.damage"),
                                                    1,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.HEAD)
                                    .add(EMAttributes.PROJECTILE_SPEED, new AttributeModifier(
                                                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "hood.projectile_speed"),
                                                    0.5,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.HEAD)
                                    .build())));

    public static final DeferredItem<ArmorItem> DIAMOND_HOOD = ITEMS.register("diamond_hood",
            () -> new ArmorItem(EMArmorMaterials.DIAMOND_HOOD, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(EMAttributes.WAND_DAMAGE, new AttributeModifier(
                                                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "hood.damage"),
                                                    1.5,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.HEAD)
                                    .build())));

    public static final DeferredItem<ArmorItem> NETHERITE_HOOD = ITEMS.register("netherite_hood",
            () -> new ArmorItem(EMArmorMaterials.NETHERITE_HOOD, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(EMAttributes.WAND_DAMAGE, new AttributeModifier(
                                                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "hood.damage"),
                                                    2,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.HEAD)
                                    .build())));

    public static final DeferredItem<ArmorItem> AMETHYST_CROWN = ITEMS.register("amethyst_crown",
            () -> new ArmorItem(EMArmorMaterials.AMETHYST_CROWN, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(6))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(EMAttributes.COOLDOWN, new AttributeModifier(
                                                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "hood.cooldown"),
                                                    -0.5,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.HEAD)
                                    .build())));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}
