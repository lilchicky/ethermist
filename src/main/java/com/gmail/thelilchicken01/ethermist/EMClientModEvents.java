package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.entity.client.renderer.GlimmerbugQueenRenderer;
import com.gmail.thelilchicken01.ethermist.entity.client.renderer.GlimmerbugRenderer;
import com.gmail.thelilchicken01.ethermist.entity.client.renderer.GloomieRenderer;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugEntity;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.IDyeableWandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandTiers;
import com.gmail.thelilchicken01.ethermist.particle.*;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.component.DataComponents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = Ethermist.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EMClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {

        event.registerEntityRenderer(EMEntityTypes.WAND_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(EMEntityTypes.GLOOMIE.get(), GloomieRenderer::new);
        event.registerEntityRenderer(EMEntityTypes.GLIMMERBUG_QUEEN.get(), GlimmerbugQueenRenderer::new);
        event.registerEntityRenderer(EMEntityTypes.GLIMMERBUG.get(), GlimmerbugRenderer::new);

    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(EMParticleTypes.GLIMMERBUG_AIR.get(), EMSuspendedParticle.GlimmerbugAirProvider::new);
        event.registerSpriteSet(EMParticleTypes.VOLATILE_ENERGY_TETHER.get(), VolatileEnergyTetherParticle.Provider::new);
        event.registerSpriteSet(EMParticleTypes.WAND_TRAIL.get(), WandTrailParticle.Provider::new);
        event.registerSpriteSet(EMParticleTypes.ETHERMIST_PORTAL.get(), EthermistPortalParticle.Provider::new);
        event.registerSpriteSet(EMParticleTypes.RED_LEAVES.get(), EMLeavesParticle.Provider::new);
        event.registerSpriteSet(EMParticleTypes.ORANGE_LEAVES.get(), EMLeavesParticle.Provider::new);
        event.registerSpriteSet(EMParticleTypes.YELLOW_LEAVES.get(), EMLeavesParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, layer) -> {

                    int woodenColor = stack.get(DataComponents.DYED_COLOR) != null ?
                            (0xFF << 24) | stack.get(DataComponents.DYED_COLOR).rgb()
                            : Ethermist.WAND_COLOR;

                    if (layer == 0) {
                        return woodenColor;
                    }
                    else if (layer == 1) {

                        WandTiers handleTier = ((IDyeableWandItem)stack.getItem()).getTier();

                        float[] rgb = handleTier.getHandleColor();

                        int r = (int)(rgb[0] * 255.0f);
                        int g = (int)(rgb[1] * 255.0f);
                        int b = (int)(rgb[2] * 255.0f);

                        int rgbPacked = (0xFF << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF);

                        return handleTier == WandTiers.WOODEN ? (0xFF << 24) | woodenColor : rgbPacked;
                    }
                    return 0xFFFFFFFF;
                },
                
                // ---------- Wand Handles ----------
                EMItems.WOODEN_WAND_HANDLE.get(),
                EMItems.EMERALD_WAND_HANDLE.get(),
                EMItems.DIAMOND_WAND_HANDLE.get(),
                EMItems.GOLDEN_WAND_HANDLE.get(),
                EMItems.LAPIS_WAND_HANDLE.get(),
                EMItems.QUARTZ_WAND_HANDLE.get(),
                EMItems.REDSTONE_WAND_HANDLE.get(),
                EMItems.GLOWSTONE_WAND_HANDLE.get(),
                EMItems.PRISMARINE_WAND_HANDLE.get(),
                EMItems.NETHERITE_WAND_HANDLE.get(),

                // ---------- Dull Wands ----------
                EMItems.WOODEN_DULL_WAND.get(),
                EMItems.EMERALD_DULL_WAND.get(),
                EMItems.DIAMOND_DULL_WAND.get(),
                EMItems.GOLDEN_DULL_WAND.get(),
                EMItems.LAPIS_DULL_WAND.get(),
                EMItems.QUARTZ_DULL_WAND.get(),
                EMItems.REDSTONE_DULL_WAND.get(),
                EMItems.GLOWSTONE_DULL_WAND.get(),
                EMItems.PRISMARINE_DULL_WAND.get(),
                EMItems.NETHERITE_DULL_WAND.get(),

                // ---------- Flame Wands ----------
                EMItems.WOODEN_FLAME_WAND.get(),
                EMItems.EMERALD_FLAME_WAND.get(),
                EMItems.DIAMOND_FLAME_WAND.get(),
                EMItems.GOLDEN_FLAME_WAND.get(),
                EMItems.LAPIS_FLAME_WAND.get(),
                EMItems.QUARTZ_FLAME_WAND.get(),
                EMItems.REDSTONE_FLAME_WAND.get(),
                EMItems.GLOWSTONE_FLAME_WAND.get(),
                EMItems.PRISMARINE_FLAME_WAND.get(),
                EMItems.NETHERITE_FLAME_WAND.get(),

                // ---------- Poison Wands ----------
                EMItems.WOODEN_POISON_WAND.get(),
                EMItems.EMERALD_POISON_WAND.get(),
                EMItems.DIAMOND_POISON_WAND.get(),
                EMItems.GOLDEN_POISON_WAND.get(),
                EMItems.LAPIS_POISON_WAND.get(),
                EMItems.QUARTZ_POISON_WAND.get(),
                EMItems.REDSTONE_POISON_WAND.get(),
                EMItems.GLOWSTONE_POISON_WAND.get(),
                EMItems.PRISMARINE_POISON_WAND.get(),
                EMItems.NETHERITE_POISON_WAND.get(),

                // ---------- Wither Wands ----------
                EMItems.WOODEN_WITHER_WAND.get(),
                EMItems.EMERALD_WITHER_WAND.get(),
                EMItems.DIAMOND_WITHER_WAND.get(),
                EMItems.GOLDEN_WITHER_WAND.get(),
                EMItems.LAPIS_WITHER_WAND.get(),
                EMItems.QUARTZ_WITHER_WAND.get(),
                EMItems.REDSTONE_WITHER_WAND.get(),
                EMItems.GLOWSTONE_WITHER_WAND.get(),
                EMItems.PRISMARINE_WITHER_WAND.get(),
                EMItems.NETHERITE_WITHER_WAND.get(),

                // ---------- Levitation Wands ----------
                EMItems.WOODEN_LEVITATION_WAND.get(),
                EMItems.EMERALD_LEVITATION_WAND.get(),
                EMItems.DIAMOND_LEVITATION_WAND.get(),
                EMItems.GOLDEN_LEVITATION_WAND.get(),
                EMItems.LAPIS_LEVITATION_WAND.get(),
                EMItems.QUARTZ_LEVITATION_WAND.get(),
                EMItems.REDSTONE_LEVITATION_WAND.get(),
                EMItems.GLOWSTONE_LEVITATION_WAND.get(),
                EMItems.PRISMARINE_LEVITATION_WAND.get(),
                EMItems.NETHERITE_LEVITATION_WAND.get(),

                // ---------- Witch Wands ----------
                EMItems.WOODEN_WITCH_WAND.get(),
                EMItems.EMERALD_WITCH_WAND.get(),
                EMItems.DIAMOND_WITCH_WAND.get(),
                EMItems.GOLDEN_WITCH_WAND.get(),
                EMItems.LAPIS_WITCH_WAND.get(),
                EMItems.QUARTZ_WITCH_WAND.get(),
                EMItems.REDSTONE_WITCH_WAND.get(),
                EMItems.GLOWSTONE_WITCH_WAND.get(),
                EMItems.PRISMARINE_WITCH_WAND.get(),
                EMItems.NETHERITE_WITCH_WAND.get(),

                // ---------- Heavy Wands ----------
                EMItems.WOODEN_HEAVY_WAND.get(),
                EMItems.EMERALD_HEAVY_WAND.get(),
                EMItems.DIAMOND_HEAVY_WAND.get(),
                EMItems.GOLDEN_HEAVY_WAND.get(),
                EMItems.LAPIS_HEAVY_WAND.get(),
                EMItems.QUARTZ_HEAVY_WAND.get(),
                EMItems.REDSTONE_HEAVY_WAND.get(),
                EMItems.GLOWSTONE_HEAVY_WAND.get(),
                EMItems.PRISMARINE_HEAVY_WAND.get(),
                EMItems.NETHERITE_HEAVY_WAND.get(),

                // ---------- Frozen Wands ----------
                EMItems.WOODEN_FROZEN_WAND.get(),
                EMItems.EMERALD_FROZEN_WAND.get(),
                EMItems.DIAMOND_FROZEN_WAND.get(),
                EMItems.GOLDEN_FROZEN_WAND.get(),
                EMItems.LAPIS_FROZEN_WAND.get(),
                EMItems.QUARTZ_FROZEN_WAND.get(),
                EMItems.REDSTONE_FROZEN_WAND.get(),
                EMItems.GLOWSTONE_FROZEN_WAND.get(),
                EMItems.PRISMARINE_FROZEN_WAND.get(),
                EMItems.NETHERITE_FROZEN_WAND.get(),

                // ---------- Glass Wands ----------
                EMItems.WOODEN_GLASS_WAND.get(),
                EMItems.EMERALD_GLASS_WAND.get(),
                EMItems.DIAMOND_GLASS_WAND.get(),
                EMItems.GOLDEN_GLASS_WAND.get(),
                EMItems.LAPIS_GLASS_WAND.get(),
                EMItems.QUARTZ_GLASS_WAND.get(),
                EMItems.REDSTONE_GLASS_WAND.get(),
                EMItems.GLOWSTONE_GLASS_WAND.get(),
                EMItems.PRISMARINE_GLASS_WAND.get(),
                EMItems.NETHERITE_GLASS_WAND.get(),

                // ---------- Glimmerbug Wands ----------
                EMItems.WOODEN_GLIMMERBUG_WAND.get(),
                EMItems.EMERALD_GLIMMERBUG_WAND.get(),
                EMItems.DIAMOND_GLIMMERBUG_WAND.get(),
                EMItems.GOLDEN_GLIMMERBUG_WAND.get(),
                EMItems.LAPIS_GLIMMERBUG_WAND.get(),
                EMItems.QUARTZ_GLIMMERBUG_WAND.get(),
                EMItems.REDSTONE_GLIMMERBUG_WAND.get(),
                EMItems.GLOWSTONE_GLIMMERBUG_WAND.get(),
                EMItems.PRISMARINE_GLIMMERBUG_WAND.get(),
                EMItems.NETHERITE_GLIMMERBUG_WAND.get()

        );
    }
}
