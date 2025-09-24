package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMEnchantComponents {

    public static final DeferredRegister<DataComponentType<?>> EM_ENCHANT_COMPONENT_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, Ethermist.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<IWandBaseEffect>> WAND_BASE_EFFECT =
            EM_ENCHANT_COMPONENT_TYPES.register("wand_base_effect", () -> DataComponentType.<IWandBaseEffect>builder()
                    .persistent(IWandBaseEffect.CODEC)
                    .build()
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<IWandAugmentEffect>> WAND_AUGMENT_EFFECT =
            EM_ENCHANT_COMPONENT_TYPES.register("wand_augment_effect", () -> DataComponentType.<IWandAugmentEffect>builder()
                    .persistent(IWandAugmentEffect.CODEC)
                    .build()
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<IWandSpellEffect>> WAND_SPELL_EFFECT =
            EM_ENCHANT_COMPONENT_TYPES.register("wand_spell_effect", () -> DataComponentType.<IWandSpellEffect>builder()
                    .persistent(IWandSpellEffect.CODEC)
                    .build()
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<IWandExclusionEffect>> WAND_EXCLUDE_EFFECT =
            EM_ENCHANT_COMPONENT_TYPES.register("wand_exclude_effect", () -> DataComponentType.<IWandExclusionEffect>builder()
                    .persistent(IWandExclusionEffect.CODEC)
                    .build()
            );

    public static void register(IEventBus bus) {
        EM_ENCHANT_COMPONENT_TYPES.register(bus);
    }

}
