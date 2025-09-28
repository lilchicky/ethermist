package com.gmail.thelilchicken01.ethermist.util;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class EMDamageTypes {

    public static final ResourceKey<DamageType> GENERIC_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "generic_magic_damage")
    );
    public static final ResourceKey<DamageType> POISON_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "poison_magic_damage")
    );
    public static final ResourceKey<DamageType> FLAME_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "flame_magic_damage")
    );
    public static final ResourceKey<DamageType> WITHER_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wither_magic_damage")
    );
    public static final ResourceKey<DamageType> LEVITATION_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "levitation_magic_damage")
    );
    public static final ResourceKey<DamageType> WITCH_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "witch_magic_damage")
    );
    public static final ResourceKey<DamageType> HEAVY_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "heavy_magic_damage")
    );
    public static final ResourceKey<DamageType> FROZEN_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "frozen_magic_damage")
    );
    public static final ResourceKey<DamageType> GLASS_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glass_magic_damage")
    );
    public static final ResourceKey<DamageType> GLIMMERBUG_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glimmerbug_magic_damage")
    );
    public static final ResourceKey<DamageType> FORGEMASTER_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "forgemaster_heart_damage")
    );

    // Entity Damage Types
    public static final ResourceKey<DamageType> FORGEMASTER_SHOT = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "forgemaster_shot")
    );
    public static final ResourceKey<DamageType> FORGEMASTER_KNOCKUP = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "forgemaster_knockup")
    );

    public static final ResourceKey<DamageType> ICICLE = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "icicle")
    );

}
