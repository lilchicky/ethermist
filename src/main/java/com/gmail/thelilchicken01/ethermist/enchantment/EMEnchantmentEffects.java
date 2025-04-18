package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.*;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EMEnchantmentEffects {

    public static final DeferredRegister<MapCodec<? extends EnchantmentValueEffect>> ENCH_VALUE_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_VALUE_EFFECT_TYPE, Ethermist.MODID);

    // Base Enchants
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> QUICK_CAST = ENCH_VALUE_EFFECTS.register("quick_cast",
            () -> QuickCastEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> ENDURING_MAGIC = ENCH_VALUE_EFFECTS.register("enduring_magic",
            () -> EnduringMagicEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> ARCANE_VELOCITY = ENCH_VALUE_EFFECTS.register("arcane_velocity",
            () -> ArcaneVelocityEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> ANCIENT_POWER = ENCH_VALUE_EFFECTS.register("ancient_power",
            () -> AncientPowerEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> RUNIC_FORCE = ENCH_VALUE_EFFECTS.register("runic_force",
            () -> RunicForceEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> STABLE_ORB = ENCH_VALUE_EFFECTS.register("stable_orb",
            () -> StableOrbEnchant.CODEC);

    // Augment Enchants
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> AUGMENT_SPLIT = ENCH_VALUE_EFFECTS.register("augment_split",
            () -> AugmentSplitEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> AUGMENT_HOMING = ENCH_VALUE_EFFECTS.register("augment_homing",
            () -> AugmentHomingEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> AUGMENT_AOE = ENCH_VALUE_EFFECTS.register("augment_aoe",
            () -> AugmentAOEEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> AUGMENT_SPRAY = ENCH_VALUE_EFFECTS.register("augment_spray",
            () -> AugmentSprayEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> AUGMENT_METEOR = ENCH_VALUE_EFFECTS.register("augment_meteor",
            () -> AugmentMeteorEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> AUGMENT_ABUNDANCE = ENCH_VALUE_EFFECTS.register("augment_abundance",
            () -> AugmentAbundanceEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> AUGMENT_FOCUS = ENCH_VALUE_EFFECTS.register("augment_focus",
            () -> AugmentFocusEnchant.CODEC);

    // Focus Enchants
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> EXCLUDE_MONSTERS = ENCH_VALUE_EFFECTS.register("exclude_monsters",
            () -> ExcludeMonstersEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> EXCLUDE_ANIMALS = ENCH_VALUE_EFFECTS.register("exclude_animals",
            () -> ExcludeAnimalsEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> EXCLUDE_PLAYERS = ENCH_VALUE_EFFECTS.register("exclude_players",
            () -> ExcludePlayersEnchant.CODEC);

    // Main Spells
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> FIREBALL = ENCH_VALUE_EFFECTS.register("fireball",
            () -> FireballEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> CHAOS_MAGIC = ENCH_VALUE_EFFECTS.register("chaos_magic",
            () -> ChaosMagicEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> THUNDERSTRIKE = ENCH_VALUE_EFFECTS.register("thunderstrike",
            () -> ThunderstrikeEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> KINETIC_RUSH = ENCH_VALUE_EFFECTS.register("kinetic_rush",
            () -> KineticRushEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> VOLATILE_ENERGY = ENCH_VALUE_EFFECTS.register("volatile_energy",
            () -> VolatileEnergyEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> SEISMIC_SURGE = ENCH_VALUE_EFFECTS.register("seismic_surge",
            () -> SeismicSurgeEnchant.CODEC);

    public static void register(IEventBus bus) {
        ENCH_VALUE_EFFECTS.register(bus);
    }

}
