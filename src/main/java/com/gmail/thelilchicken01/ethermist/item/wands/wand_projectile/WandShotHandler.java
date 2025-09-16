package com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile;

import com.gmail.thelilchicken01.ethermist.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class WandShotHandler {

    public static void shoot(Level level, Player player, @Nullable List<? extends Entity> target, float pSpeed, double lifespan,
                             ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem,
                             boolean isHoming, List<SpellModifiers.TargetType> targetType, List<WandProjectile.SpellEntry> savedSpells) {

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player, target, wandItem);

        shot.shootFromRotation(
                player,
                player.getXRot(),
                player.getYRot(),
                0,
                pSpeed,
                (float)(100 - (WandUtil.getAttribute(player, EMAttributes.ACCURACY, WandItem.ACCURACY_ID)*100)));

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

        level.addFreshEntity(setShotInfo(player, shot, wand, wandItem, lifespan, isHoming, targetType, savedSpells));

    }

    // Public helper method to bulk apply relevant details to spawned wand projectiles
    public static WandProjectile setShotInfo(Player player,
                                             WandProjectile shot,
                                             WandItem wand,
                                             ItemStack wandItem,
                                             double lifespan,
                                             boolean isHoming,
                                             List<SpellModifiers.TargetType> targetType,
                                             List<WandProjectile.SpellEntry> savedSpells) {

        shot.setDamage((int)WandUtil.getAttribute(player, EMAttributes.WAND_DAMAGE, WandItem.BASE_WAND_DAMAGE_ID));
        shot.setLifetime((int)(lifespan * 20));
        shot.setCanIgnite(wand.getOrb().getCanIgnite());
        shot.setKnockbackStrength(WandUtil.getAttribute(player, EMAttributes.WAND_KNOCKBACK, WandItem.WAND_KNOCKBACK_ID));
        shot.setHoming(isHoming);
        shot.setTargetType(targetType);
        shot.setDamageType(wand.getOrb().getDamageType());
        shot.setTrailColor(wand.getTrailColor(wandItem));
        shot.setOriginWandTier(wand.getHandle());
        shot.setOriginWandType(wand.getOrb());
        shot.setSpellEntries(savedSpells);

        return shot;

    }

}
