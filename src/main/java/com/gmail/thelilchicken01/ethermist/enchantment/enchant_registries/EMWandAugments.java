package com.gmail.thelilchicken01.ethermist.enchantment.enchant_registries;

import com.gmail.thelilchicken01.ethermist.util.EMRegistries;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants.*;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMWandAugments {

    public static final DeferredRegister<MapCodec<? extends IWandAugmentEffect>> EM_WAND_AUGMENTS =
            DeferredRegister.create(EMRegistries.WAND_AUGMENT_EFFECT.getRegistryName(), Ethermist.MODID);
    // ----------

    public static final DeferredHolder<MapCodec<? extends IWandAugmentEffect>, MapCodec<? extends IWandAugmentEffect>> AUGMENT_SPRAY =
            EM_WAND_AUGMENTS.register("augment_spray", () -> AugmentSprayEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandAugmentEffect>, MapCodec<? extends IWandAugmentEffect>> AUGMENT_FOCUS =
            EM_WAND_AUGMENTS.register("augment_focus", () -> AugmentFocusEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandAugmentEffect>, MapCodec<? extends IWandAugmentEffect>> AUGMENT_METEOR =
            EM_WAND_AUGMENTS.register("augment_meteor", () -> AugmentMeteorEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandAugmentEffect>, MapCodec<? extends IWandAugmentEffect>> AUGMENT_SPLIT =
            EM_WAND_AUGMENTS.register("augment_split", () -> AugmentSplitEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandAugmentEffect>, MapCodec<? extends IWandAugmentEffect>> AUGMENT_HOMING =
            EM_WAND_AUGMENTS.register("augment_homing", () -> AugmentHomingEnchant.CODEC);

    public static final DeferredHolder<MapCodec<? extends IWandAugmentEffect>, MapCodec<? extends IWandAugmentEffect>> AUGMENT_AOE =
            EM_WAND_AUGMENTS.register("augment_aoe", () -> AugmentAOEEnchant.CODEC);

    // ----------
    public static void register(IEventBus bus) {
        EM_WAND_AUGMENTS.register(bus);
    }

}
