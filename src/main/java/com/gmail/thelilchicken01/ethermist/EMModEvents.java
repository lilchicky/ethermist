package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

@EventBusSubscriber(modid = Ethermist.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EMModEvents {

    @SubscribeEvent
    public static void onAddEntityAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, EMAttributes.COOLDOWN);
        event.add(EntityType.PLAYER, EMAttributes.WAND_DAMAGE);
        event.add(EntityType.PLAYER, EMAttributes.WAND_KNOCKBACK);
        event.add(EntityType.PLAYER, EMAttributes.PROJECTILE_SPEED);
        event.add(EntityType.PLAYER, EMAttributes.LIFESPAN);
        event.add(EntityType.PLAYER, EMAttributes.ACCURACY);
    }

}
