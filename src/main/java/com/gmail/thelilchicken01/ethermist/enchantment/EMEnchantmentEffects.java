package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.AncientPowerEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.ArcaneVelocityEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.GreaterDistanceEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.QuickCastEnchant;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EMEnchantmentEffects {

    public static final DeferredRegister<MapCodec<? extends EnchantmentValueEffect>> ENCH_VALUE_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_VALUE_EFFECT_TYPE, Ethermist.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> QUICK_CAST = ENCH_VALUE_EFFECTS.register("quick_cast",
            () -> QuickCastEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> GREATER_DISTANCE = ENCH_VALUE_EFFECTS.register("greater_distance",
            () -> GreaterDistanceEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> ARCANE_VELOCITY = ENCH_VALUE_EFFECTS.register("arcane_velocity",
            () -> ArcaneVelocityEnchant.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> ANCIENT_POWER = ENCH_VALUE_EFFECTS.register("ancient_power",
            () -> AncientPowerEnchant.CODEC);

    public static void register(IEventBus bus) {
        ENCH_VALUE_EFFECTS.register(bus);
    }

}
