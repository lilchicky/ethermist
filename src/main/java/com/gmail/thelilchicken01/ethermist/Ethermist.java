package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.datagen.EMCreativeTab;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import com.gmail.thelilchicken01.ethermist.particle.EMSuspendedParticle;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPOIs;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMBlockStateProviderType;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTrunkPlacerType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Ethermist.MODID)
public class Ethermist {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "ethermist";

    public static final ResourceKey<Level> ETHERMIST = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "ethermist"));
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Ethermist(IEventBus modEventBus, ModContainer modContainer) {

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register custom content
        EMCreativeTab.register(modEventBus);

        EMParticleTypes.register(modEventBus);

        EMTrunkPlacerType.register(modEventBus);
        EMBlockStateProviderType.register(modEventBus);
        EMPOIs.register(modEventBus);

        EMBlocks.register(modEventBus);
        EMItems.register(modEventBus);

        EMEntityTypes.register(modEventBus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EMBlocks.GLIMMER_BLOSSOM.getId(), EMBlocks.GLIMMER_BLOSSOM_FLOWER_POT);
        });

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("The Ethermyst awakens");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {

            event.registerEntityRenderer(EMEntityTypes.WAND_PROJECTILE.get(), ThrownItemRenderer::new);

        }

        @SubscribeEvent
        public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(EMParticleTypes.GILMMERBUG_AIR.get(), EMSuspendedParticle.GlimmerbugAirProvider::new);
        }
    }
}
