package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.WandTier;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMRegistries {

    public static final ResourceKey<Registry<WandTier>> WAND_TIER_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_tiers"));

    public static final ResourceKey<Registry<MapCodec<? extends IWandBaseEffect>>> WAND_BASE_EFFECT_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_base_effect_key"));

    public static final ResourceKey<Registry<MapCodec<? extends IWandAugmentEffect>>> WAND_AUGMENT_EFFECT_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_augment_effect_key"));

    public static final ResourceKey<Registry<MapCodec<? extends IWandSpellEffect>>> WAND_SPELL_EFFECT_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_spell_effect_key"));

    // ---------------------------------

    public static final DeferredRegister<WandTier> WAND_TIERS =
            DeferredRegister.create(WAND_TIER_REGISTRY_KEY, Ethermist.MODID);

    public static final DeferredRegister<MapCodec<? extends IWandBaseEffect>> WAND_BASE_EFFECT =
            DeferredRegister.create(WAND_BASE_EFFECT_REGISTRY_KEY, Ethermist.MODID);

    public static final DeferredRegister<MapCodec<? extends IWandAugmentEffect>> WAND_AUGMENT_EFFECT =
            DeferredRegister.create(WAND_AUGMENT_EFFECT_REGISTRY_KEY, Ethermist.MODID);

    public static final DeferredRegister<MapCodec<? extends IWandSpellEffect>> WAND_SPELL_EFFECT =
            DeferredRegister.create(WAND_SPELL_EFFECT_REGISTRY_KEY, Ethermist.MODID);

}
