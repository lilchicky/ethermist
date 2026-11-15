package com.gmail.thelilchicken01.ethermist.datagen.loot.predicates;

import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugEntity;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.EntitySubPredicate;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public record GlimmerbugPredicate(boolean summoned) implements EntitySubPredicate {

    public static final MapCodec<GlimmerbugPredicate> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.BOOL.optionalFieldOf("summoned", false)
                            .forGetter(GlimmerbugPredicate::summoned)
            ).apply(instance, GlimmerbugPredicate::new)
    );

    public static GlimmerbugPredicate isSummoned(boolean summoned) {
        return new GlimmerbugPredicate(summoned);
    }

    public boolean matches(Entity entity, ServerLevel level, @Nullable Vec3 position) {
        return entity instanceof GlimmerbugEntity glimmerbug && glimmerbug.isSummoned() == summoned;
    }

    public MapCodec<GlimmerbugPredicate> codec() {
        return EMSubPredicates.GLIMMERBUG.get();
    }
}
