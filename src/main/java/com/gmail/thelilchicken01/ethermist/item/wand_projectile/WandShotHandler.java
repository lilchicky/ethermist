package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class WandShotHandler {

    public static void shoot(Level level, Player player, @Nullable List<? extends Entity> target, float pSpeed, int lifespan,
                             ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem,
                             boolean isHoming, List<SpellModifiers.TargetType> targetType, SpellModifiers.SpellType spellType, int spellLevel) {

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player, target);

        shot.shootFromRotation(
                player,
                player.getXRot(),
                player.getYRot(),
                0,
                pSpeed,
                (float)(100 - (WandUtil.getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

        float yaw = (float) Math.toRadians(player.getYRot());
        float pitch = (float) Math.toRadians(player.getXRot());

        double x = -Math.sin(yaw) * Math.cos(pitch);
        double y = -Math.sin(pitch);
        double z = Math.cos(yaw) * Math.cos(pitch);

        double offset = 0.3f;
        double xOffset = x * offset;
        double yOffset = y * offset;
        double zOffset = z * offset;

        shot.setPos(
                shot.getX() + xOffset,
                player.getEyeHeight() * 0.925 + player.getY() + yOffset,
                shot.getZ() + zOffset
        );

        level.addFreshEntity(setShotInfo(shot, wand, wandItem, lifespan, isHoming, targetType, spellType, spellLevel));

    }

    public static void shootSplit(Level level, Player player, @Nullable List<? extends Entity> target, float pSpeed, int lifespan,
                                   ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem, int iterations,
                                   boolean isHoming, List<SpellModifiers.TargetType> targetType, SpellModifiers.SpellType spellType, int spellLevel) {

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player, target);

        shot.shootFromRotation(
                player,
                player.getXRot(),
                player.getYRot(),
                0,
                pSpeed,
                (float)(100 - (WandUtil.getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

        level.addFreshEntity(setShotInfo(shot, wand, wandItem, lifespan, isHoming, targetType, spellType, spellLevel));

        for (int x = 0; x < iterations; x++) {

            WandProjectile splitShot = shotItem.createProjectile(level, shotStack, player, target);
            WandProjectile splitShot2 = shotItem.createProjectile(level, shotStack, player, target);

            splitShot.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot() + (10 * x),
                    0,
                    pSpeed,
                    (float)(100 - (WandUtil.getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

            splitShot2.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot() - (10 * x),
                    0,
                    pSpeed,
                    (float)(100 - (WandUtil.getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

            level.addFreshEntity(setShotInfo(splitShot, wand, wandItem, lifespan, isHoming, targetType, spellType, spellLevel));
            level.addFreshEntity(setShotInfo(splitShot2, wand, wandItem, lifespan, isHoming, targetType, spellType, spellLevel));

        }

    }

    public static void shootAOE(Level level, Player player, @Nullable List<? extends Entity> target, float pSpeed, int lifespan,
                                 ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem, int iterations,
                                 boolean isHoming, List<SpellModifiers.TargetType> targetType, SpellModifiers.SpellType spellType, int spellLevel) {

        float wedges = (360.0f / (iterations * 3));
        int index = 0;

        WandProjectile shot;

        for (int x = 0; x < iterations * 3; x++) {

            if (target != null && !target.isEmpty()) {
                shot = shotItem.createProjectile(level, shotStack, player, List.of(target.get(index)));
                index++;

                if (index >= target.size()) {
                    index = 0;
                }
            }
            else {
                shot = shotItem.createProjectile(level, shotStack, player, target);
            }

            shot.shootFromRotation(
                    player,
                    0.0f,
                    player.getYRot() + (x * wedges),
                    0.0f,
                    pSpeed,
                    0.0f);

            shot.setPos(shot.getX(), player.getEyeHeight() * 0.8 + player.getY(), shot.getZ());

            level.addFreshEntity(setShotInfo(shot, wand, wandItem, lifespan, isHoming, targetType, spellType, spellLevel));

        }

    }

    public static void shootAtPos(Level level, Player player, @Nullable List<? extends Entity> target, float pSpeed, int lifespan,
                                   ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem, boolean isHoming,
                                   List<SpellModifiers.TargetType> targetType, SpellModifiers.SpellType spellType, int spellLevel, BlockPos pos) {

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player, target);

        Vec3 currentPos = player.getEyePosition().add(0.0, 4.0, 0.0);
        Vec3 targetPos = new Vec3(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        Vec3 targetVector = targetPos.subtract(currentPos).normalize();

        shot.shoot(
                targetVector.x,
                targetVector.y + 0.1,
                targetVector.z,
                pSpeed,
                (float)(100 - (WandUtil.getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));
        shot.setPos(shot.getX(),
                shot.getY() + 4.0,
                shot.getZ());

        level.addFreshEntity(setShotInfo(shot, wand, wandItem, lifespan, isHoming, targetType, spellType, spellLevel));

    }

    public static void shootAtEntity(Level level, Player player, float pSpeed, int lifespan,
                                      ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem, boolean isHoming,
                                      List<SpellModifiers.TargetType> targetType, SpellModifiers.SpellType spellType, int spellLevel, Entity targetLoc) {

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player, List.of(targetLoc));

        Vec3 currentPos = player.getEyePosition().add(0.0, 4.0, 0.0);
        Vec3 targetPos = new Vec3(targetLoc.getX(), targetLoc.getY(), targetLoc.getZ());
        Vec3 targetVector = targetPos.subtract(currentPos).normalize();

        shot.shoot(
                targetVector.x,
                targetVector.y + 0.1,
                targetVector.z,
                pSpeed,
                (float)(100 - (WandUtil.getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

        shot.setPos(shot.getX(),
                shot.getY() + 4.0,
                shot.getZ());

        level.addFreshEntity(setShotInfo(shot, wand, wandItem, lifespan, isHoming, targetType, spellType, spellLevel));

    }

    private static WandProjectile setShotInfo(WandProjectile shot, WandItem wand, ItemStack wandItem, int lifespan, boolean isHoming,
                                    List<SpellModifiers.TargetType> targetType, SpellModifiers.SpellType spellType, int spellLevel) {

        shot.setDamage((int)WandUtil.getAttribute(wandItem, WandItem.BASE_WAND_DAMAGE_ID));
        shot.setLifetime(lifespan * 20);
        shot.setCanIgnite(wand.getTier().getCanIgnite());
        shot.setKnockbackStrength(WandUtil.getAttribute(wandItem, WandItem.WAND_KNOCKBACK_ID));
        shot.setHoming(isHoming);
        shot.setTargetType(targetType);
        shot.setSpellType(spellType);
        shot.setSpellLevel(spellLevel);
        shot.setDamageType(wand.getTier().getDamageType());
        shot.setTrailColor(wand.getTrailColor(wandItem));

        return shot;

    }

}
