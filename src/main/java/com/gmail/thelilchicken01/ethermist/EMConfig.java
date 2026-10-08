package com.gmail.thelilchicken01.ethermist;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Ethermist.MODID)
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
