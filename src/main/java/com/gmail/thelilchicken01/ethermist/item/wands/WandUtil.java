package com.gmail.thelilchicken01.ethermist.item.wands;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WandUtil {

    public static <T extends Entity> List<Entity> getNearbyEntities(Level level, int range, Entity center) {
        return level.getEntities(EntityTypeTest.forClass(Entity.class), new AABB(
                        center.getX() - range,
                        center.getY() - range,
                        center.getZ() - range,
                        center.getX() + range,
                        center.getY() + range,
                        center.getZ() + range),
                entity -> true
        );
    }

    public static List<Entity> filterNearbyEntities(Level level, List<Entity> entities, Entity self, @Nullable Entity owner, List<Class<?>> types) {

        List<Entity> filteredEntities = entities.stream()
                .filter(entity -> types == null || types.isEmpty()
                        || types.stream().noneMatch(cls -> cls.isInstance(entity)))
                .toList();

        return filteredEntities.stream()
                .filter(iterate ->
                        !iterate.isInvulnerable() &&
                                iterate.distanceTo(self) < 24 &&
                                iterate.isAlive() &&
                                !(iterate instanceof Player otherPlayer && otherPlayer.isCreative()) &&
                                !iterate.isSpectator() &&
                                hasLineOfSight(level, self, iterate) &&
                                !iterate.equals(owner) &&
                                !iterate.equals(self) &&
                                !(iterate instanceof ItemEntity) &&
                                !(iterate instanceof ExperienceOrb) &&
                                !(iterate instanceof HangingEntity) &&
                                !(iterate instanceof LeashFenceKnotEntity) &&
                                !(iterate.isInvisible()) &&
                                !(iterate instanceof TamableAnimal tamed && tamed.isTame()) &&
                                !(iterate instanceof Projectile) &&
                                !(iterate instanceof ArmorStand) &&
                                !iterate.getType().is(EntityTypeTags.DEFLECTS_PROJECTILES)
                )
                .sorted(Comparator.comparingDouble(iterate -> -iterate.distanceTo(self)))
                .collect(Collectors.toList());
    }

    private static boolean hasLineOfSight(Level level, Entity looker, Entity lookAt) {

        BlockHitResult result = level.clip(new ClipContext(
                looker.getEyePosition(),
                lookAt.getEyePosition(),
                ClipContext.Block.VISUAL,
                ClipContext.Fluid.NONE,
                looker
        ));

        return result.getType() == HitResult.Type.MISS;
    }

    public static double getAttribute(LivingEntity entity, Holder<Attribute> attribute, ResourceLocation attributeID) {
        AttributeMap attributes = entity.getAttributes();
        return attributes.getModifierValue(attribute, attributeID);
    }

}
