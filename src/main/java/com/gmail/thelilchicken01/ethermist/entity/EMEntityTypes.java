package com.gmail.thelilchicken01.ethermist.entity;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandProjectile;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMEntityTypes {

    public static final DeferredRegister<EntityType<?>> EM_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Ethermist.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<WandProjectile>> WAND_PROJECTILE =
            EM_ENTITY_TYPES.register("wand_projectile",
                    () -> EntityType.Builder.<WandProjectile>of(WandProjectile::new, MobCategory.MISC)
                            .sized(0.4f, 0.4f)
                            .setUpdateInterval(2)
                            .setTrackingRange(64)
                            .setShouldReceiveVelocityUpdates(true)
                            .build(Ethermist.MODID + ":wand_projectile"));

    public static void register (IEventBus bus) {
        EM_ENTITY_TYPES.register(bus);
    }

}
