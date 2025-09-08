package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.WandTier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMRegistries {

    public static final ResourceKey<Registry<WandTier>> WAND_TIER_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_tiers"));

    public static final DeferredRegister<WandTier> WAND_TIERS =
            DeferredRegister.create(WAND_TIER_REGISTRY_KEY, Ethermist.MODID);

}
