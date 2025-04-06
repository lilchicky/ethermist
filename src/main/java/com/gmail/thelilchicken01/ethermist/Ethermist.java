package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.EMRecipeSerializer;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantmentEffects;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.datagen.EMCreativeTab;
import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.particle.*;
import com.gmail.thelilchicken01.ethermist.worldgen.feature.EMFeatures;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPOIs;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMFoliagePlacerType;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTreeDecorators;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTrunkPlacerType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
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

    // Default Color
    public static final int WAND_COLOR = 9004839;

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Ethermist(IEventBus bus, ModContainer modContainer) {

        // Register the commonSetup method for modloading
        bus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register custom content
        EMCreativeTab.register(bus);

        EMParticleTypes.register(bus);

        EMTrunkPlacerType.register(bus);
        EMFoliagePlacerType.register(bus);
        EMPOIs.register(bus);
        EMTreeDecorators.register(bus);
        EMFeatures.register(bus);

        EMRecipeSerializer.register(bus);

        EMBlocks.register(bus);
        EMItems.register(bus);

        EMEntityTypes.register(bus);

        EMEnchantmentEffects.register(bus);
        EMAttributes.register(bus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, EMConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EMBlocks.GLIMMERBUD.getId(), EMBlocks.GLIMMERBUD_FLOWER_POT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EMBlocks.NIGHTBELL.getId(), EMBlocks.NIGHTBELL_FLOWER_POT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EMBlocks.WITCH_LAVENDER.getId(), EMBlocks.WITCH_LAVENDER_FLOWER_POT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(EMBlocks.DAWNING_HYACINTH.getId(), EMBlocks.DAWNING_HYACINTH_FLOWER_POT);
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
            event.registerSpriteSet(EMParticleTypes.WAND_TRAIL.get(), WandTrailParticle.Provider::new);
            event.registerSpriteSet(EMParticleTypes.ETHERMIST_PORTAL.get(), EthermistPortalParticle.Provider::new);
            event.registerSpriteSet(EMParticleTypes.RED_LEAVES.get(), EMLeavesParticle.Provider::new);
            event.registerSpriteSet(EMParticleTypes.ORANGE_LEAVES.get(), EMLeavesParticle.Provider::new);
            event.registerSpriteSet(EMParticleTypes.YELLOW_LEAVES.get(), EMLeavesParticle.Provider::new);
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            event.register((stack, layer) -> {
                if (layer == 0) {
                    DyedItemColor color = stack.get(DataComponents.DYED_COLOR);
                    return color != null ? (0xFF << 24) | color.rgb() : WAND_COLOR;
                }
                return 0xFFFFFFFF;
            },
                    EMItems.WAND_HANDLE.get(),
                    EMItems.DULL_WAND.get(),
                    EMItems.FLAME_WAND.get(),
                    EMItems.POISON_WAND.get(),
                    EMItems.WITHER_WAND.get(),
                    EMItems.LEVITATION_WAND.get(),
                    EMItems.WITCH_WAND.get()
            );
        }
    }
}
