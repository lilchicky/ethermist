package com.gmail.thelilchicken01.ethermist;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = Ethermist.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EMConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue HIDE_ENCHANTMENT_GLINT = BUILDER
            .comment("Whether wands should hide the enchantment glint.")
            .comment("Helps with the visibility of the colors of dyed wands.")
            .comment("Default: False")
            .define("hideGlint", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean hideGlint;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        hideGlint = HIDE_ENCHANTMENT_GLINT.get();
    }
}
