package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantmentEffects;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.datagen.EMCreativeTab;
import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.particle.*;
import com.gmail.thelilchicken01.ethermist.worldgen.feature.EMFeatures;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPOIs;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTreeDecorators;
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
import net.neoforged.neoforge.event.tick.ServerTickEvent;
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
    public static final EMCustomTasks SCHEDULER = new EMCustomTasks();

    public static final Logger LOGGER = LogUtils.getLogger();

    // Blockstate Datagen Folder Locations
    public static final String ETHERSTONE = "etherstone";
    public static final String GLIMMERING_WOOD = "glimmering_wood";
    public static final String ANCIENT_WOOD = "ancient_wood";
    public static final String SLIMY_WOOD = "slimy_wood";
    public static final String FROSTPINE_WOOD = "frostpine_wood";
    public static final String SPARKLING_SANDSTONE = "sparkling_sandstone";
    public static final String TIMEWORN_SANDSTONE = "timeworn_sandstone";
    public static final String ABYSSAL_MUSHROOM = "abyssal_mushroom";

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
        EMPOIs.register(modEventBus);
        EMTreeDecorators.register(modEventBus);
        EMFeatures.register(modEventBus);

        EMBlocks.register(modEventBus);
        EMItems.register(modEventBus);

        EMEntityTypes.register(modEventBus);

        EMEnchantmentEffects.register(modEventBus);
        EMAttributes.register(modEventBus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, EMConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EMBlocks.GLIMMER_BLOSSOM.getId(), EMBlocks.GLIMMER_BLOSSOM_FLOWER_POT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EMBlocks.NIGHT_LAVENDER.getId(), EMBlocks.NIGHT_LAVENDER_FLOWER_POT);
        });

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("The Ethermist awakens");
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {
        SCHEDULER.tick(event.getServer().getTickCount());
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
            event.registerSpriteSet(EMParticleTypes.GLIMMERBUG_AIR.get(), EMSuspendedParticle.GlimmerbugAirProvider::new);
            event.registerSpriteSet(EMParticleTypes.VOLATILE_ENERGY_TETHER.get(), VolatileEnergyTetherParticle.Provider::new);
            event.registerSpriteSet(EMParticleTypes.GENERIC_TRAIL.get(), WandTrailParticle.Provider::new);
            event.registerSpriteSet(EMParticleTypes.ETHERMIST_PORTAL.get(), EthermistPortalParticle.Provider::new);
        }
    }
}
