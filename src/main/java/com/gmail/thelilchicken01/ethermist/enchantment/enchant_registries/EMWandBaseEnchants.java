package com.gmail.thelilchicken01.ethermist.enchantment.enchant_registries;

import com.gmail.thelilchicken01.ethermist.EMRegistries;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.base_enchants.*;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMWandBaseEnchants {

    public static final DeferredRegister<MapCodec<? extends IWandBaseEffect>> EM_BASE_WAND_ENCHANTS =
            DeferredRegister.create(EMRegistries.WAND_BASE_EFFECT.getRegistryName(), Ethermist.MODID);

    public static final DeferredHolder<MapCodec<? extends IWandBaseEffect>, MapCodec<? extends IWandBaseEffect>> ANCIENT_POWER =
            EM_BASE_WAND_ENCHANTS.register("ancient_power", () -> AncientPowerEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandBaseEffect>, MapCodec<? extends IWandBaseEffect>> QUICK_CAST =
            EM_BASE_WAND_ENCHANTS.register("quick_cast", () -> QuickCastEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandBaseEffect>, MapCodec<? extends IWandBaseEffect>> ARCANE_VELOCITY =
            EM_BASE_WAND_ENCHANTS.register("arcane_velocity", () -> ArcaneVelocityEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandBaseEffect>, MapCodec<? extends IWandBaseEffect>> RUNIC_FORCE =
            EM_BASE_WAND_ENCHANTS.register("runic_force", () -> RunicForceEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandBaseEffect>, MapCodec<? extends IWandBaseEffect>> STABLE_ORB =
            EM_BASE_WAND_ENCHANTS.register("stable_orb", () -> StableOrbEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandBaseEffect>, MapCodec<? extends IWandBaseEffect>> ENDURING_MAGIC =
            EM_BASE_WAND_ENCHANTS.register("enduring_magic", () -> EnduringMagicEnchant.CODEC);

    public static void register(IEventBus bus) {
        EM_BASE_WAND_ENCHANTS.register(bus);
    }

}
