package com.gmail.thelilchicken01.ethermist.item.armor;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.mojang.datafixers.types.templates.Hook;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class EMArmorMaterials {

    public static final Holder<ArmorMaterial> LEATHER_HOOD = register("leather_hood",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 3);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 3);
            }), 5, () -> Items.LEATHER, SoundEvents.ARMOR_EQUIP_LEATHER);

    public static final Holder<ArmorMaterial> IRON_HOOD = register("iron_hood",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 3);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 3);
            }), 5, () -> Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_IRON);

    public static final Holder<ArmorMaterial> GOLD_HOOD = register("gold_hood",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 3);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 3);
            }), 5, () -> Items.GOLD_INGOT, SoundEvents.ARMOR_EQUIP_GOLD);

    public static final Holder<ArmorMaterial> DIAMOND_HOOD = register("diamond_hood",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 3);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 3);
            }), 5, () -> Items.DIAMOND, SoundEvents.ARMOR_EQUIP_DIAMOND);

    public static final Holder<ArmorMaterial> NETHERITE_HOOD = register("netherite_hood",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 3);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 3);
            }), 5, () -> Items.NETHERITE_INGOT, SoundEvents.ARMOR_EQUIP_NETHERITE);

    public static final Holder<ArmorMaterial> AMETHYST_CROWN = register("amethyst_crown",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 3);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 3);
            }), 5, () -> Items.AMETHYST_SHARD, SoundEvents.ARMOR_EQUIP_GOLD);

    private static Holder<ArmorMaterial> register(
            String name,
            EnumMap<ArmorItem.Type, Integer> typeProtection,
            int enchantability,
            Supplier<Item> repairItem,
            Holder<SoundEvent> equipSound) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(repairItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, 1, 1));
    }

}
