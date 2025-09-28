package com.gmail.thelilchicken01.ethermist.enchantment.enchant_registries;

import com.gmail.thelilchicken01.ethermist.util.EMRegistries;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandExclusionEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants.ExcludeAnimalsEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants.ExcludeMonstersEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants.ExcludePlayersEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.exclusion_enchants.ExcludeVillagersEnchant;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMWandExclusionEnchants {

    public static final DeferredRegister<MapCodec<? extends IWandExclusionEffect>> EM_EXCLUSION_WAND_ENCHANTS =
            DeferredRegister.create(EMRegistries.WAND_EXCLUSION_EFFECT.getRegistryName(), Ethermist.MODID);

    public static final DeferredHolder<MapCodec<? extends IWandExclusionEffect>, MapCodec<? extends IWandExclusionEffect>> EXCLUDE_MONSTERS =
            EM_EXCLUSION_WAND_ENCHANTS.register("exclude_monsters", () -> ExcludeMonstersEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandExclusionEffect>, MapCodec<? extends IWandExclusionEffect>> EXCLUDE_PLAYERS =
            EM_EXCLUSION_WAND_ENCHANTS.register("exclude_players", () -> ExcludePlayersEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandExclusionEffect>, MapCodec<? extends IWandExclusionEffect>> EXCLUDE_ANIMALS =
            EM_EXCLUSION_WAND_ENCHANTS.register("exclude_animals", () -> ExcludeAnimalsEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandExclusionEffect>, MapCodec<? extends IWandExclusionEffect>> EXCLUDE_VILLAGERS =
            EM_EXCLUSION_WAND_ENCHANTS.register("exclude_villagers", () -> ExcludeVillagersEnchant.CODEC);

    public static void register(IEventBus bus) {
        EM_EXCLUSION_WAND_ENCHANTS.register(bus);
    }

}
