package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
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

    public static List<Entity> filterNearbyEntities(Level level, List<Entity> entities, Entity self, @Nullable Entity owner, List<SpellModifiers.TargetType> types) {
        List<Entity> filteredEntities = entities;
        for (SpellModifiers.TargetType type : types) {
            if (type.getTargetClass() != null) {
                filteredEntities = filteredEntities.stream().filter(iterate -> !type.getTargetClass().isInstance(iterate)).toList();
            }
        }
        return filteredEntities.stream().filter(iterate ->
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
                                !(iterate.getTags().contains(EntityTypeTags.DEFLECTS_PROJECTILES.location().getPath()))
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
