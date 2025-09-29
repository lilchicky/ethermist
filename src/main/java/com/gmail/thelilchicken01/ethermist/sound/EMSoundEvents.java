package com.gmail.thelilchicken01.ethermist.sound;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/*
alarm_clock_ticking_01.wav by joedeshon -- https://freesound.org/s/78563/ -- License: Attribution 4.0
 */

public class EMSoundEvents {

    public static final DeferredRegister<SoundEvent> EM_SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Ethermist.MODID);

    public static final Supplier<SoundEvent> CHRONOTHORN_REWIND = registerSoundEvent("chronothorn_rewind");

    public static final Supplier<SoundEvent> CHARRED_WOOD_BREAK = registerSoundEvent("charred_wood_break");
    public static final Supplier<SoundEvent> CHARRED_WOOD_STEP = registerSoundEvent("charred_wood_step");
    public static final Supplier<SoundEvent> CHARRED_WOOD_PLACE = registerSoundEvent("charred_wood_place");
    public static final Supplier<SoundEvent> CHARRED_WOOD_HIT = registerSoundEvent("charred_wood_hit");
    public static final Supplier<SoundEvent> CHARRED_WOOD_FALL = registerSoundEvent("charred_wood_fall");

    public static final DeferredSoundType CHARRED_WOOD_SOUND_TYPE = new DeferredSoundType(1f, 1f,
            EMSoundEvents.CHARRED_WOOD_BREAK,
            EMSoundEvents.CHARRED_WOOD_STEP,
            EMSoundEvents.CHARRED_WOOD_PLACE,
            EMSoundEvents.CHARRED_WOOD_HIT,
            EMSoundEvents.CHARRED_WOOD_FALL
    );

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, name);
        return EM_SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus bus) {
        EM_SOUND_EVENTS.register(bus);
    }

}
