package com.gmail.thelilchicken01.ethermist;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class EMDamageTypes {

    public static final ResourceKey<DamageType> GENERIC_MAGIC = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "generic_damage")
    );

    public static final ResourceKey<DamageType> ICICLE = ResourceKey.create(
            Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "icicle")
    );

}
