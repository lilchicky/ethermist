package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.enchantment.QuickCastEnchant;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class WandEnchantHandler {

    private static int cooldownModifier = 0;

    public static void processShot(Level level, Player player, ItemStack thisWand, WandItem wand) {

        ItemStack shotStack = new ItemStack(wand.getShotItem());
        shoot(level, player, shotStack, wand);

        player.getCooldowns().addCooldown(wand,
                (QuickCastEnchant.modifyCooldown(thisWand.getEnchantmentLevel(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT)
                        .getHolderOrThrow(EMEnchantments.QUICK_CAST)), wand.getCooldown()) + cooldownModifier)
        );

    }

    private static void shoot(Level level, Player player, ItemStack shotStack, WandItem wand) {
        WandProjectile shot = wand.getShotItem().createProjectile(level, shotStack, player);
        shot.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, wand.getProjectileSpeed(), wand.getInaccuracy());

        shot.setDamage(shot.getDamage() + wand.getBonusDamage());
        shot.setLifetime(wand.getLifespanSeconds() * 20);
        shot.setTrail(wand.getTrail());
        shot.setCanIgnite(wand.getCanIgnite());
        shot.setKnockbackStrength(wand.getKnockback());

        level.addFreshEntity(shot);

    }

    public static void processHitEntity(Level level, Entity shooter, Entity target, WandShotItem shotItem, WandProjectile shot) {

        if(shot.isOnFire() || shot.canIgnite) target.setRemainingFireTicks(100);

        DamageSource damageSource = new DamageSource(
                level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(EMDamageTypes.GENERIC_MAGIC),
                shooter,
                shot,
                null
        );
        boolean damaged = target.hurt(damageSource, (float) shotItem.modifyDamage(shot.damage, shot, target, shooter, level));

        if(damaged && target instanceof LivingEntity livingTarget) {

            // Knockback Math
            if (shot.knockbackStrength != 0) {
                Vec3 vec = shot.getDeltaMovement().multiply(1, 0, 1).normalize().scale(shot.knockbackStrength);
                if (vec.lengthSqr() > 0) {
                    livingTarget.push(vec.x, 0.1, vec.z);
                }
            }

            // Wand Specific Modifiers
            if(shooter instanceof Player player) {
                switch (shotItem.getModifier()) {
                    case FLAME_WAND -> {
                        livingTarget.setRemainingFireTicks(200);
                    }
                    case LEVITATION_WAND -> {
                        livingTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
                    }
                    default -> {
                        break;
                    }
                }
            }

            shotItem.onLivingEntityHit(shot, livingTarget, shooter, level);

        }

    }

    public static void processHit(Level level, Vec3 pos, HitResult.Type type, WandProjectile shot) {

        if (!level.isClientSide() && (!shot.noPhysics || type != HitResult.Type.BLOCK)) {
            shot.remove(Entity.RemovalReason.KILLED);
        }

    }

}
