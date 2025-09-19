package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.entity.client.model.*;
import com.gmail.thelilchicken01.ethermist.entity.mobs.*;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = Ethermist.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EMModEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GloomieModel.LAYER_LOCATION, GloomieModel::createBodyLayer);
        event.registerLayerDefinition(GlimmerbugQueenModel.LAYER_LOCATION, GlimmerbugQueenModel::createBodyLayer);
        event.registerLayerDefinition(GlimmerbugModel.LAYER_LOCATION, GlimmerbugModel::createBodyLayer);
        event.registerLayerDefinition(ForgemasterModel.LAYER_LOCATION, ForgemasterModel::createBodyLayer);
        event.registerLayerDefinition(PylonModel.LAYER_LOCATION, PylonModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EMEntityTypes.GLOOMIE.get(), GloomieEntity.createAttributes().build());
        event.put(EMEntityTypes.GLIMMERBUG_QUEEN.get(), GlimmerbugQueenEntity.createAttributes().build());
        event.put(EMEntityTypes.GLIMMERBUG.get(), GlimmerbugEntity.createAttributes().build());
        event.put(EMEntityTypes.FORGEMASTER.get(), ForgemasterEntity.createAttributes().build());
        event.put(EMEntityTypes.PYLON.get(), PylonEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void onAddEntityAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, EMAttributes.COOLDOWN);
        event.add(EntityType.PLAYER, EMAttributes.WAND_DAMAGE);
        event.add(EntityType.PLAYER, EMAttributes.WAND_KNOCKBACK);
        event.add(EntityType.PLAYER, EMAttributes.PROJECTILE_SPEED);
        event.add(EntityType.PLAYER, EMAttributes.LIFESPAN);
        event.add(EntityType.PLAYER, EMAttributes.ACCURACY);
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {

    }

}
