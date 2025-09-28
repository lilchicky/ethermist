package com.gmail.thelilchicken01.ethermist.effect.potion;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.effect.EMMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMPotions {

    public static final DeferredRegister<Potion> EM_POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, Ethermist.MODID);

    public static final Holder<Potion> FASTER_CASTING_POTION = EM_POTIONS.register("em_faster_casting_potion",
            () -> new Potion(new MobEffectInstance(EMMobEffects.FASTER_CASTING, 3600, 0)));

    public static final Holder<Potion> SLOWER_CASTING_POTION = EM_POTIONS.register("em_slower_casting_potion",
            () -> new Potion(new MobEffectInstance(EMMobEffects.SLOWER_CASTING, 3600, 0)));

    public static void register(IEventBus bus) {
        EM_POTIONS.register(bus);
    }

}
