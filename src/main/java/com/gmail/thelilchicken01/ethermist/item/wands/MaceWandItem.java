package com.gmail.thelilchicken01.ethermist.item.wands;

import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Predicate;

public class MaceWandItem extends WandItem {

    public MaceWandItem(IWandTypes type, IWandTiers tier) {
        super(type, tier);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof ServerPlayer serverplayer && canSmashAttack(serverplayer)) {
            ServerLevel serverlevel = (ServerLevel) attacker.level();
            if (serverplayer.isIgnoringFallDamageFromCurrentImpulse() && serverplayer.currentImpulseImpactPos != null) {
                if (serverplayer.currentImpulseImpactPos.y > serverplayer.position().y) {
                    serverplayer.currentImpulseImpactPos = serverplayer.position();
                }
            } else {
                serverplayer.currentImpulseImpactPos = serverplayer.position();
            }

            serverplayer.setIgnoreFallDamageFromCurrentImpulse(true);
            serverplayer.setDeltaMovement(serverplayer.getDeltaMovement().with(Direction.Axis.Y, 0.01F));
            serverplayer.connection.send(new ClientboundSetEntityMotionPacket(serverplayer));
            if (target.onGround()) {
                serverplayer.setSpawnExtraParticlesOnFall(true);
                SoundEvent soundevent = serverplayer.fallDistance > 5.0F ? SoundEvents.MACE_SMASH_GROUND_HEAVY : SoundEvents.MACE_SMASH_GROUND;
                serverlevel.playSound(
                        null, serverplayer.getX(), serverplayer.getY(), serverplayer.getZ(), soundevent, serverplayer.getSoundSource(), 1.0F, 1.0F
                );
            } else {
                serverlevel.playSound(
                        null, serverplayer.getX(), serverplayer.getY(), serverplayer.getZ(), SoundEvents.MACE_SMASH_AIR, serverplayer.getSoundSource(), 1.0F, 1.0F
                );
            }

            knockback(serverlevel, serverplayer, target);
        }

        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
        if (canSmashAttack(attacker)) {
            attacker.resetFallDistance();
        }
    }

    @Override
    public float getAttackDamageBonus(Entity target, float damage, DamageSource damageSource) {
        if (damageSource.getDirectEntity() instanceof LivingEntity livingentity) {
            if (!canSmashAttack(livingentity)) {
                return 0.0F;
            } else {
                float f3 = 3.0F;
                float f = 8.0F;
                float f1 = livingentity.fallDistance;
                float f2;
                if (f1 <= 3.0F) {
                    f2 = 4.0F * f1;
                } else if (f1 <= 8.0F) {
                    f2 = 12.0F + 2.0F * (f1 - 3.0F);
                } else {
                    f2 = 22.0F + f1 - 8.0F;
                }

                return livingentity.level() instanceof ServerLevel serverlevel
                        ? f2 + EnchantmentHelper.modifyFallBasedDamage(serverlevel, livingentity.getWeaponItem(), target, damageSource, 0.0F) * f1
                        : f2;
            }
        } else {
            return 0.0F;
        }
    }

    private static void knockback(Level level, Player player, Entity entity) {
        level.levelEvent(2013, entity.getOnPos(), 750);
        level.getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(3.5), knockbackPredicate(player, entity))
                .forEach(p_347296_ -> {
                    Vec3 vec3 = p_347296_.position().subtract(entity.position());
                    double d0 = getKnockbackPower(player, p_347296_, vec3);
                    Vec3 vec31 = vec3.normalize().scale(d0);
                    if (d0 > 0.0) {
                        p_347296_.push(vec31.x, 0.7F, vec31.z);
                        if (p_347296_ instanceof ServerPlayer serverplayer) {
                            serverplayer.connection.send(new ClientboundSetEntityMotionPacket(serverplayer));
                        }
                    }
                });
    }

    private static Predicate<LivingEntity> knockbackPredicate(Player player, Entity entity) {
        return p_344407_ -> {
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag6;
            label62:
            {
                flag = !p_344407_.isSpectator();
                flag1 = p_344407_ != player && p_344407_ != entity;
                flag2 = !player.isAlliedTo(p_344407_);
                if (p_344407_ instanceof TamableAnimal tamableanimal && tamableanimal.isTame() && player.getUUID().equals(tamableanimal.getOwnerUUID())) {
                    flag6 = true;
                    break label62;
                }

                flag6 = false;
            }

            boolean flag3;
            label55:
            {
                flag3 = !flag6;
                if (p_344407_ instanceof ArmorStand armorstand && armorstand.isMarker()) {
                    flag6 = false;
                    break label55;
                }

                flag6 = true;
            }

            boolean flag4 = flag6;
            boolean flag5 = entity.distanceToSqr(p_344407_) <= Math.pow(3.5, 2.0);
            return flag && flag1 && flag2 && flag3 && flag4 && flag5;
        };
    }

    private static double getKnockbackPower(Player player, LivingEntity entity, Vec3 entityPos) {
        return (3.5 - entityPos.length())
                * 0.7F
                * (double) (player.fallDistance > 5.0F ? 2 : 1)
                * (1.0 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
    }

    public static boolean canSmashAttack(LivingEntity entity) {
        return entity.fallDistance > 1.5F && !entity.isFallFlying();
    }

}
