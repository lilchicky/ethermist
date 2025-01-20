package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EMEnchantmentEffects {

    public static final DeferredRegister<MapCodec<? extends EnchantmentValueEffect>> ENCH_VALUE_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_VALUE_EFFECT_TYPE, Ethermist.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentValueEffect>> QUICK_CAST = ENCH_VALUE_EFFECTS.register("quick_cast", () -> QuickCastEnchant.CODEC);

    public static void register(IEventBus bus) {
        ENCH_VALUE_EFFECTS.register(bus);
    }

}
