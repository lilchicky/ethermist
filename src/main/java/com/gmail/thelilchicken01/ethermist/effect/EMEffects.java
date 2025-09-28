package com.gmail.thelilchicken01.ethermist.effect;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMEffects {

    public static final DeferredRegister<MobEffect> EM_MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Ethermist.MODID);

    public static final Holder<MobEffect> SLOW_WAND = EM_MOB_EFFECTS.register("slow_wand",
            () -> new EMAttributeEffect(MobEffectCategory.HARMFUL, 9109504).addAttributeModifier(
                    EMAttributes.COOLDOWN,
                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "effect.slow_wand"),
                    0.5,
                    AttributeModifier.Operation.ADD_VALUE
            )
    );

    public static void register(IEventBus bus) {
        EM_MOB_EFFECTS.register(bus);
    }

}
