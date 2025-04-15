package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.entity.client.model.GloomieModel;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GloomieEntity;
import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;
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
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EMEntityTypes.GLOOMIE.get(), GloomieEntity.createAttributes().build());
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
