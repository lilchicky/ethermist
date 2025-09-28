package com.gmail.thelilchicken01.ethermist.util;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.entity.client.renderer.*;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.IDyeableWandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.IWandHandle;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.EMWandHandles;
import com.gmail.thelilchicken01.ethermist.particle.*;
import com.gmail.thelilchicken01.ethermist.screen.EMMenuTypes;
import com.gmail.thelilchicken01.ethermist.screen.WandforgingTableScreen;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.component.DataComponents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
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
        event.registerEntityRenderer(EMEntityTypes.FORGEMASTER.get(), ForgemasterRenderer::new);
        event.registerEntityRenderer(EMEntityTypes.PYLON.get(), PylonRenderer::new);

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

                    int baseColor = 0xFF000000 | (
                            stack.get(DataComponents.DYED_COLOR) != null
                                    ? (stack.get(DataComponents.DYED_COLOR).rgb() & 0xFFFFFF)
                                    : (Ethermist.WAND_COLOR & 0xFFFFFF)
                    );

                    if (layer == 0) {

                        return baseColor;

                    } else if (layer == 1) {

                        IWandHandle tier = (stack.getItem() instanceof IDyeableWandItem dyeable)
                                ? dyeable.getHandle(stack)
                                : null;

                        if (tier != null) {
                            boolean isWooden = tier.id().equals(EMWandHandles.WOODEN.getId());

                            if (isWooden) {
                                return baseColor;
                            }

                            float[] rgb = tier.getHandleColor();
                            int r = (int) (Math.max(0f, Math.min(1f, rgb[0])) * 255f);
                            int g = (int) (Math.max(0f, Math.min(1f, rgb[1])) * 255f);
                            int b = (int) (Math.max(0f, Math.min(1f, rgb[2])) * 255f);
                            return 0xFF000000 | (r << 16) | (g << 8) | b;
                        }

                        return baseColor;
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

                // ---------- Wands ----------
                EMItems.DULL_WAND.get(),
                EMItems.FLAME_WAND.get(),
                EMItems.POISON_WAND.get(),
                EMItems.WITHER_WAND.get(),
                EMItems.LEVITATION_WAND.get(),
                EMItems.WITCH_WAND.get(),
                EMItems.HEAVY_WAND.get(),
                EMItems.FROZEN_WAND.get(),
                EMItems.GLASS_WAND.get(),
                EMItems.GLIMMERBUG_WAND.get(),
                EMItems.FORGED_HEART_WAND.get()

        );
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(EMMenuTypes.WANDFORGING_TABLE_MENU.get(), WandforgingTableScreen::new);
    }

}
