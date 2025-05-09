package com.gmail.thelilchicken01.ethermist.entity;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugEntity;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugQueenEntity;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GloomieEntity;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
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

    public static final DeferredHolder<EntityType<?>, EntityType<GloomieEntity>> GLOOMIE =
            EM_ENTITY_TYPES.register("gloomie",
                    () -> EntityType.Builder.of(GloomieEntity::new, MobCategory.CREATURE)
                            .sized(0.7f, 0.7f)
                            .build(Ethermist.MODID + ":gloomie"));

    public static final DeferredHolder<EntityType<?>, EntityType<GlimmerbugQueenEntity>> GLIMMERBUG_QUEEN =
            EM_ENTITY_TYPES.register("glimmerbug_queen",
                    () -> EntityType.Builder.of(GlimmerbugQueenEntity::new, MobCategory.CREATURE)
                            .sized(1.15f, 0.45f)
                            .build(Ethermist.MODID + ":glimmerbug_queen"));

    public static final DeferredHolder<EntityType<?>, EntityType<GlimmerbugEntity>> GLIMMERBUG =
            EM_ENTITY_TYPES.register("glimmerbug",
                    () -> EntityType.Builder.of(GlimmerbugEntity::new, MobCategory.CREATURE)
                            .sized(0.72f, 0.45f)
                            .build(Ethermist.MODID + ":glimmerbug"));

    public static void register (IEventBus bus) {
        EM_ENTITY_TYPES.register(bus);
    }

}
