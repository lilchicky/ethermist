package com.gmail.thelilchicken01.ethermist.util;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandExclusionEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.WandHandle;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects.WandOrb;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMRegistries {

    public static final ResourceKey<Registry<WandHandle>> WAND_HANDLES_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_tiers"));

    public static final ResourceKey<Registry<WandOrb>> WAND_ORBS_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_types"));

    public static final ResourceKey<Registry<MapCodec<? extends IWandBaseEffect>>> WAND_BASE_EFFECT_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_base_effect_key"));

    public static final ResourceKey<Registry<MapCodec<? extends IWandAugmentEffect>>> WAND_AUGMENT_EFFECT_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_augment_effect_key"));

    public static final ResourceKey<Registry<MapCodec<? extends IWandExclusionEffect>>> WAND_EXCLUSION_EFFECT_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_exclusion_effect_key"));

    public static final ResourceKey<Registry<MapCodec<? extends IWandSpellEffect>>> WAND_SPELL_EFFECT_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_spell_effect_key"));

    // ---------------------------------

    public static final DeferredRegister<WandHandle> WAND_HANDLES =
            DeferredRegister.create(WAND_HANDLES_REGISTRY_KEY, Ethermist.MODID);

    public static final DeferredRegister<WandOrb> WAND_ORBS =
            DeferredRegister.create(WAND_ORBS_REGISTRY_KEY, Ethermist.MODID);

    public static final DeferredRegister<MapCodec<? extends IWandBaseEffect>> WAND_BASE_EFFECT =
            DeferredRegister.create(WAND_BASE_EFFECT_REGISTRY_KEY, Ethermist.MODID);

    public static final DeferredRegister<MapCodec<? extends IWandAugmentEffect>> WAND_AUGMENT_EFFECT =
            DeferredRegister.create(WAND_AUGMENT_EFFECT_REGISTRY_KEY, Ethermist.MODID);

    public static final DeferredRegister<MapCodec<? extends IWandExclusionEffect>> WAND_EXCLUSION_EFFECT =
            DeferredRegister.create(WAND_EXCLUSION_EFFECT_REGISTRY_KEY, Ethermist.MODID);

    public static final DeferredRegister<MapCodec<? extends IWandSpellEffect>> WAND_SPELL_EFFECT =
            DeferredRegister.create(WAND_SPELL_EFFECT_REGISTRY_KEY, Ethermist.MODID);

}
