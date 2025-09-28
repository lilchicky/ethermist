package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.component.EMDataComponents;
import com.gmail.thelilchicken01.ethermist.datagen.recipes.EMRecipeRegistration;
import com.gmail.thelilchicken01.ethermist.effect.EMEffects;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantComponents;
import com.gmail.thelilchicken01.ethermist.enchantment.enchant_registries.EMWandAugments;
import com.gmail.thelilchicken01.ethermist.enchantment.enchant_registries.EMWandBaseEnchants;
import com.gmail.thelilchicken01.ethermist.enchantment.enchant_registries.EMWandExclusionEnchants;
import com.gmail.thelilchicken01.ethermist.enchantment.enchant_registries.EMWandSpells;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.datagen.EMCreativeTab;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.EMWandHandles;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects.EMWandOrbs;
import com.gmail.thelilchicken01.ethermist.particle.*;
import com.gmail.thelilchicken01.ethermist.screen.EMMenuTypes;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.gmail.thelilchicken01.ethermist.util.EMCustomTasks;
import com.gmail.thelilchicken01.ethermist.util.EMRegistries;
import com.gmail.thelilchicken01.ethermist.worldgen.feature.EMFeatures;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPOIs;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMFoliagePlacerType;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTreeDecorators;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTrunkPlacerType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
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

        // Register Custom Registries
        bus.addListener(this::newRegistry);
        EMRegistries.WAND_HANDLES.register(bus);
        EMRegistries.WAND_ORBS.register(bus);
        EMRegistries.WAND_BASE_EFFECT.register(bus);
        EMRegistries.WAND_AUGMENT_EFFECT.register(bus);
        EMRegistries.WAND_SPELL_EFFECT.register(bus);
        EMRegistries.WAND_EXCLUSION_EFFECT.register(bus);

        // Register custom content
        EMWandOrbs.register(bus);
        EMWandHandles.register(bus);
        EMCreativeTab.register(bus);
        EMBlocks.register(bus);
        EMItems.register(bus);
        EMMenuTypes.register(bus);
        EMDataComponents.register(bus);
        LOGGER.info("Successfully registered Ethermist items");

        EMParticleTypes.register(bus);
        LOGGER.info("Successfully registered Ethermist particles");

        EMTrunkPlacerType.register(bus);
        EMFoliagePlacerType.register(bus);
        EMPOIs.register(bus);
        EMTreeDecorators.register(bus);
        EMFeatures.register(bus);
        LOGGER.info("Successfully registered Ethermist world generation features");

        EMRecipeRegistration.register(bus);

        EMEntityTypes.register(bus);

        EMAttributes.register(bus);

        EMEnchantComponents.register(bus);
        EMWandBaseEnchants.register(bus);
        EMWandAugments.register(bus);
        EMWandSpells.register(bus);
        EMWandExclusionEnchants.register(bus);

        EMEffects.register(bus);

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

    private void newRegistry(final NewRegistryEvent event) {

        event.create(new RegistryBuilder<>(EMRegistries.WAND_HANDLES_REGISTRY_KEY)
                .sync(true)
                .defaultKey(ResourceLocation.fromNamespaceAndPath(MODID, "wooden")));

        event.create(new RegistryBuilder<>(EMRegistries.WAND_ORBS_REGISTRY_KEY)
                .sync(true)
                .defaultKey(ResourceLocation.fromNamespaceAndPath(MODID, "empty")));

        event.create(new RegistryBuilder<>(EMRegistries.WAND_BASE_EFFECT_REGISTRY_KEY)
                .sync(true)
                .defaultKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "empty")));

        event.create(new RegistryBuilder<>(EMRegistries.WAND_AUGMENT_EFFECT_REGISTRY_KEY)
                .sync(true)
                .defaultKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "empty")));

        event.create(new RegistryBuilder<>(EMRegistries.WAND_EXCLUSION_EFFECT_REGISTRY_KEY)
                .sync(true)
                .defaultKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "empty")));

        event.create(new RegistryBuilder<>(EMRegistries.WAND_SPELL_EFFECT_REGISTRY_KEY)
                .sync(true)
                .defaultKey(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "empty")));

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

}
