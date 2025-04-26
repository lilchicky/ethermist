package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.IDyeableWandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class WandProjectileHandler {

    public static void processShot(Level level, Player player, ItemStack thisWand, WandItem wand,
                                   @Nullable BlockPos pos, @Nullable Entity clickedEntity) {

        double newLifespan = WandUtil.getAttribute(player, EMAttributes.LIFESPAN, WandItem.LIFESPAN_ID);
        float pSpeed = (float)WandUtil.getAttribute(player, EMAttributes.PROJECTILE_SPEED, WandItem.PROJECTILE_SPEED_ID);

        AtomicBoolean augmentedShot = new AtomicBoolean(false);
        AtomicBoolean isHoming = new AtomicBoolean(false);
        AtomicBoolean isMeteor = new AtomicBoolean(false);
        AtomicBoolean isRush = new AtomicBoolean(false);
        AtomicBoolean isFocus = new AtomicBoolean(false);
        List<SpellModifiers.TargetType> types = new ArrayList<>();
        AtomicReference<SpellModifiers.SpellType> spellType = new AtomicReference<>(SpellModifiers.SpellType.GENERIC);
        AtomicInteger spellLevel = new AtomicInteger(0);

        EnchantmentHelper.runIterationOnItem(thisWand, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.AUGMENT_HOMING.location())) {
                isHoming.set(true);
            }
            if (enchantHolder.is(EMEnchantments.EXCLUDE_MONSTERS.location())) {
                types.add(SpellModifiers.TargetType.MONSTERS);
            }
            if (enchantHolder.is(EMEnchantments.EXCLUDE_ANIMALS.location())) {
                types.add(SpellModifiers.TargetType.ANIMALS);
            }
            if (enchantHolder.is(EMEnchantments.EXCLUDE_PLAYERS.location())) {
                types.add(SpellModifiers.TargetType.PLAYERS);
            }
            if (enchantHolder.is(EMEnchantments.AUGMENT_METEOR.location())) {
                isMeteor.set(true);
            }
            if (enchantHolder.is(EMEnchantments.FIREBALL.location())) {
                spellType.set(SpellModifiers.SpellType.FIREBALL);
                spellLevel.set(enchantLevel);
            }
            if (enchantHolder.is(EMEnchantments.CHAOS_MAGIC.location())) {
                spellType.set(SpellModifiers.SpellType.CHAOS_MAGIC);
                spellLevel.set(enchantLevel);
            }
            if (enchantHolder.is(EMEnchantments.THUNDERSTRIKE.location())) {
                spellType.set(SpellModifiers.SpellType.THUNDERSTRIKE);
                spellLevel.set(enchantLevel);
            }
            if (enchantHolder.is(EMEnchantments.KINETIC_RUSH.location())) {
                isRush.set(true);
                augmentedShot.set(true);
            }
            if (enchantHolder.is(EMEnchantments.VOLATILE_ENERGY.location())) {
                spellType.set(SpellModifiers.SpellType.VOLATILE_ENERGY);
                spellLevel.set(enchantLevel);
            }
            if (enchantHolder.is(EMEnchantments.SEISMIC_SURGE.location())) {
                spellType.set(SpellModifiers.SpellType.SEISMIC_SURGE);
                spellLevel.set(enchantLevel);
            }
        });

        if (types.isEmpty()) {
            types.add(SpellModifiers.TargetType.ALL);
        }

        WandShotItem shotItem;
        ItemStack shotStack;

        if (isMeteor.get()) {
            shotItem = EMItems.METEOR_SHOT.get();
            shotItem.setModifier(wand.getType().getShotItem().getModifier());

            shotStack = new ItemStack(EMItems.METEOR_SHOT.get());
        }
        else {
            shotItem = wand.getType().getShotItem();
            shotStack = new ItemStack(wand.getType().getShotItem());
        }

        List<Entity> nearby = WandUtil.getNearbyEntities(level, (int)(newLifespan * 10), player);
        List<Entity> target = WandUtil.filterNearbyEntities(level, nearby, player, null, types);

        EnchantmentHelper.runIterationOnItem(thisWand, (enchantHolder, enchantLevel) -> {
            if (!isRush.get()) {
                if (enchantHolder.is(EMEnchantments.AUGMENT_SPLIT.location())) {
                    if (!target.isEmpty()) {
                        WandShotHandler.shootSplit(level, player, List.of(target.getLast()), pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                enchantLevel, isHoming.get(), types, spellType.get(), spellLevel.get());
                    } else {
                        WandShotHandler.shootSplit(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                enchantLevel, isHoming.get(), types, spellType.get(), spellLevel.get());
                    }
                    augmentedShot.set(true);
                }
                if (enchantHolder.is(EMEnchantments.AUGMENT_AOE.location())) {
                    WandShotHandler.shootAOE(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                            enchantLevel, isHoming.get(), types, spellType.get(), spellLevel.get());
                    augmentedShot.set(true);
                }
                if (enchantHolder.is(EMEnchantments.AUGMENT_METEOR.location())) {
                    if (pos != null) {
                        WandShotHandler.shootAtPos(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                isHoming.get(), types, spellType.get(), spellLevel.get(), pos);
                    } else if (clickedEntity != null) {
                        WandShotHandler.shootAtEntity(level, player, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                isHoming.get(), types, spellType.get(), spellLevel.get(), clickedEntity);
                    }
                    augmentedShot.set(true);
                }
                if (enchantHolder.is(EMEnchantments.AUGMENT_SPRAY.location())) {
                    if (!level.isClientSide()) {

                        MinecraftServer server = level.getServer();

                        if (!(server == null)) {

                            for (int x = 0; x < enchantLevel + 2; x++) {

                                int scheduleShot = server.getTickCount() + (x * 2);

                                Ethermist.SCHEDULER.schedule(scheduleShot, () -> {
                                    WandShotHandler.shoot(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                            isHoming.get(), types, spellType.get(), spellLevel.get());
                                    level.playSound(null,
                                            player.getX(),
                                            player.getY(),
                                            player.getZ(),
                                            wand.SHOOT_SOUND,
                                            SoundSource.PLAYERS,
                                            0.5f,
                                            level.getRandom().nextFloat() * 0.4f + 0.8f);
                                });
                            }
                        }
                    }
                    augmentedShot.set(true);
                }
                if (enchantHolder.is(EMEnchantments.AUGMENT_FOCUS.location())) {
                    isFocus.set(true);
                }
            }
        });

        if (!augmentedShot.get()) {
            WandShotHandler.shoot(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand, isHoming.get(), types, spellType.get(), spellLevel.get());
        }
        if (isFocus.get() && !isRush.get()) {
            if (!level.isClientSide()) {
                player.setDeltaMovement(player.getDeltaMovement().add(player.getLookAngle().scale(-0.3f)));
                player.hurtMarked = true;
            }
        }
        if (isRush.get()) {
            if (!level.isClientSide()) {
                RandomSource random = RandomSource.create();

                double power = WandUtil.getAttribute(player, EMAttributes.WAND_DAMAGE, WandItem.BASE_WAND_DAMAGE_ID) / 2.0;
                double inaccuracy = 1 - WandUtil.getAttribute(player, EMAttributes.ACCURACY, WandItem.ACCURACY_ID);

                Vec3 launch = player.getViewVector(1.0f);

                double xOff = (random.nextDouble() * 2 - 1) * inaccuracy;
                double yOff = (random.nextDouble() * 2 - 1) * inaccuracy;
                double zOff = (random.nextDouble() * 2 - 1) * inaccuracy;

                Vec3 offsetLaunch = new Vec3(
                        launch.x + xOff,
                        launch.y + yOff,
                        launch.z + zOff
                ).normalize().scale(power);

                player.setDeltaMovement(offsetLaunch);
                player.hurtMarked = true;
            }
        }

        player.getCooldowns().addCooldown(wand, (int) (WandUtil.getAttribute(player, EMAttributes.COOLDOWN, WandItem.COOLDOWN_ID) * 20));

    }

    public static void processHitEntity(Level level, Entity shooter, Entity target, WandShotItem shotItem, WandProjectile shot, Vec3 hitPos, ItemStack originWandStack) {

        if(shot.isOnFire() || shot.canIgnite) target.setRemainingFireTicks(100);

        int lastHurtResistant = target.invulnerableTime;
        target.invulnerableTime = 0;

        DamageSource damageSource = new DamageSource(
                level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(shot.damageType),
                shot,
                shooter,
                null
        );

        boolean damaged;
        boolean canBeHurt = true;
        if (!(target == shooter)) {
            for (SpellModifiers.TargetType type : shot.targetType) {
                switch (type) {
                    case MONSTERS -> canBeHurt = !(target instanceof Monster);
                    case ANIMALS -> canBeHurt = !(target instanceof Animal);
                    case PLAYERS -> canBeHurt = !(target instanceof Player);
                }
                if (!canBeHurt) break;
            }
            canBeHurt = (!(target instanceof TamableAnimal tamed) || !tamed.isTame()) && canBeHurt;

            damaged = canBeHurt && target.hurt(damageSource, (float) shot.damage);

        }
        else {
            damaged = false;
        }

        if(damaged) {

            // Knockback Math
            if (shot.knockbackStrength != 0 && target.isPushable()) {
                Vec3 vec = shot.getDeltaMovement().multiply(1, 0, 1).normalize().scale(shot.knockbackStrength);
                if (vec.lengthSqr() > 0) {
                    target.push(vec.x, 0.1, vec.z);
                }
            }

            // Wand Specific Modifiers
            if(shooter instanceof Player player) {
                WandSpellHandler.processWandModifiers(shotItem, target, player, originWandStack);
                WandSpellHandler.processSpells(level, player, target, null, shot);
            }

        }
        else {
            target.invulnerableTime = lastHurtResistant;
        }

    }

    public static void processHit(Level level, Entity shooter, Vec3 pos, HitResult result, WandProjectile shot, ItemStack originWandStack) {

        if (result.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityResult = (EntityHitResult) result;
            Entity target = entityResult.getEntity();
            WandShotItem shotItem = (WandShotItem) shot.getItem().getItem();

            processHitEntity(level, shooter, target, shotItem, shot, pos, originWandStack);
        }
        else if (result.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockResult = (BlockHitResult) result;
            BlockPos hitPos = blockResult.getBlockPos();
            WandSpellHandler.processSpells(level, shooter, null, hitPos, shot);
        }

        if (!shot.spellType.equals(SpellModifiers.SpellType.SEISMIC_SURGE)) {
            if (!level.isClientSide() && (!shot.noPhysics || result.getType() != HitResult.Type.BLOCK)) {
                shot.remove(Entity.RemovalReason.KILLED);
            }
        }

    }

    public static void processTick(WandProjectile shot, double threshold, int ticksSinceFired, int tick,
                                   List<? extends Entity> target) {

        if (!shot.level().isClientSide() && (ticksSinceFired > shot.lifetime ||
                (shot.getDeltaMovement().lengthSqr() < threshold && shot.spellType != SpellModifiers.SpellType.VOLATILE_ENERGY))) {
            shot.remove(Entity.RemovalReason.KILLED);
        }

        WandSpellHandler.processSpellTick(shot, tick, target);

        if (!shot.level().isClientSide() && ticksSinceFired > 5 && shot.isHoming) {

            for (Entity entity : target) {

                if (entity.isAlive()) {
                    Vec3 currentPos = shot.getPosition(1.0f);
                    Vec3 targetPos = entity.getPosition(1.0f).add(0.0, entity.getEyeHeight() * 0.5, 0.0);
                    Vec3 newVector = targetPos.subtract(currentPos).normalize();

                    shot.setDeltaMovement(newVector);
                }

            }

        }

    }

}
