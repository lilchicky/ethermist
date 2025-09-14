package com.gmail.thelilchicken01.ethermist.enchantment.enchant_registries;

import com.gmail.thelilchicken01.ethermist.EMRegistries;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants.ChaosMagicEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants.KineticRushEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants.ThunderstrikeEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants.VolatileEnergyEnchant;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMWandSpells {

    public static final DeferredRegister<MapCodec<? extends IWandSpellEffect>> EM_WAND_SPELLS =
            DeferredRegister.create(EMRegistries.WAND_SPELL_EFFECT.getRegistryName(), Ethermist.MODID);
    // ----------

    public static final DeferredHolder<MapCodec<? extends IWandSpellEffect>, MapCodec<? extends IWandSpellEffect>> CHAOS_MAGIC =
            EM_WAND_SPELLS.register("chaos_magic", () -> ChaosMagicEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandSpellEffect>, MapCodec<? extends IWandSpellEffect>> VOLATILE_ENERGY =
            EM_WAND_SPELLS.register("volatile_energy", () -> VolatileEnergyEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandSpellEffect>, MapCodec<? extends IWandSpellEffect>> THUNDERSTRIKE =
            EM_WAND_SPELLS.register("thunderstrike", () -> ThunderstrikeEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandSpellEffect>, MapCodec<? extends IWandSpellEffect>> KINETIC_RUSH =
            EM_WAND_SPELLS.register("kinetic_rush", () -> KineticRushEnchant.CODEC);

    // ----------
    public static void register(IEventBus bus) {
        EM_WAND_SPELLS.register(bus);
    }

}
