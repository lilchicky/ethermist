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

public class EMMobEffects {

    public static final DeferredRegister<MobEffect> EM_MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Ethermist.MODID);

    // Slower Casting
    public static final Holder<MobEffect> SLOWER_CASTING = EM_MOB_EFFECTS.register("slower_casting",
            () -> new EMAttributeEffect(MobEffectCategory.HARMFUL, 9109504).addAttributeModifier(
                    EMAttributes.COOLDOWN,
                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "effect.slower_casting"),
                    0.5,
                    AttributeModifier.Operation.ADD_VALUE
            )
    );

    // Faster Casting
    public static final Holder<MobEffect> FASTER_CASTING = EM_MOB_EFFECTS.register("faster_casting",
            () -> new EMAttributeEffect(MobEffectCategory.BENEFICIAL, 25600).addAttributeModifier(
                    EMAttributes.COOLDOWN,
                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "effect.faster_casting"),
                    -0.5,
                    AttributeModifier.Operation.ADD_VALUE
            )
    );

    public static void register(IEventBus bus) {
        EM_MOB_EFFECTS.register(bus);
    }

}
