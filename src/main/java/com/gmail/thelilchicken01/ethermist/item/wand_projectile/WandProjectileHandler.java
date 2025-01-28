package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class WandProjectileHandler {

    public static void processShot(Level level, Player player, ItemStack thisWand, WandItem wand,
                                   @Nullable BlockPos pos, @Nullable LivingEntity clickedEntity) {

        int newLifespan = (int)getAttribute(thisWand, WandItem.LIFESPAN_ID);
        float pSpeed = (float)getAttribute(thisWand, WandItem.PROJECTILE_SPEED_ID);

        AtomicBoolean augmentedShot = new AtomicBoolean(false);
        AtomicBoolean isHoming = new AtomicBoolean(false);
        AtomicBoolean isMeteor = new AtomicBoolean(false);
        AtomicBoolean isRush = new AtomicBoolean(false);
        AtomicReference<SpellModifiers.TargetType> type = new AtomicReference<>(SpellModifiers.TargetType.ALL);
        AtomicReference<SpellModifiers.SpellType> spellType = new AtomicReference<>(SpellModifiers.SpellType.GENERIC);
        AtomicInteger spellLevel = new AtomicInteger(0);

        EnchantmentHelper.runIterationOnItem(thisWand, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.AUGMENT_HOMING.location())) {
                isHoming.set(true);
            }
            if (enchantHolder.is(EMEnchantments.FOCUS_MONSTERS.location())) {
                type.set(SpellModifiers.TargetType.MONSTERS);
            }
            if (enchantHolder.is(EMEnchantments.FOCUS_ANIMALS.location())) {
                type.set(SpellModifiers.TargetType.ANIMALS);
            }
            if (enchantHolder.is(EMEnchantments.FOCUS_PLAYERS.location())) {
                type.set(SpellModifiers.TargetType.PLAYERS);
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
        });

        WandShotItem shotItem;
        ItemStack shotStack;

        if (isMeteor.get()) {
            shotItem = EMItems.METEOR_SHOT.get();
            shotItem.setModifier(wand.getShotItem().getModifier());

            shotStack = new ItemStack(EMItems.METEOR_SHOT.get());
        }
        else {
            shotItem = wand.getShotItem();
            shotStack = new ItemStack(wand.getShotItem());
        }

        List<? extends LivingEntity> target;
        switch (type.get()) {
            case SpellModifiers.TargetType.MONSTERS -> {
                List<Monster> nearbyEntities = getNearbyEntities(level, newLifespan * 10, player, Monster.class);
                target = getClosestEntity(nearbyEntities, Monster.class, player);
            }
            case SpellModifiers.TargetType.ANIMALS -> {
                List<Animal> nearbyEntities = getNearbyEntities(level, newLifespan * 10, player, Animal.class);
                target = getClosestEntity(nearbyEntities, Animal.class, player);
            }
            case SpellModifiers.TargetType.PLAYERS -> {
                List<Player> nearbyEntities = getNearbyEntities(level, newLifespan * 10, player, Player.class);
                target = getClosestEntity(nearbyEntities, Player.class, player);
            }
            default -> {
                List<LivingEntity> nearbyEntities = getNearbyEntities(level, newLifespan * 10, player, LivingEntity.class);
                target = getClosestEntity(nearbyEntities, LivingEntity.class, player);
            }
        }

        EnchantmentHelper.runIterationOnItem(thisWand, (enchantHolder, enchantLevel) -> {
            if (!isRush.get()) {
                if (enchantHolder.is(EMEnchantments.AUGMENT_SPLIT.location())) {
                    if (target != null && !target.isEmpty()) {
                        WandShotHandler.shootSplit(level, player, List.of(target.getLast()), pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                enchantLevel, isHoming.get(), type.get(), spellType.get(), spellLevel.get());
                    } else {
                        WandShotHandler.shootSplit(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                enchantLevel, isHoming.get(), type.get(), spellType.get(), spellLevel.get());
                    }
                    augmentedShot.set(true);
                }
                if (enchantHolder.is(EMEnchantments.AUGMENT_AOE.location())) {
                    WandShotHandler.shootAOE(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                            enchantLevel, isHoming.get(), type.get(), spellType.get(), spellLevel.get());
                    augmentedShot.set(true);
                }
                if (enchantHolder.is(EMEnchantments.AUGMENT_METEOR.location())) {
                    if (pos != null) {
                        WandShotHandler.shootAtPos(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                isHoming.get(), type.get(), spellType.get(), spellLevel.get(), pos);
                    } else if (clickedEntity != null) {
                        WandShotHandler.shootAtEntity(level, player, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand,
                                isHoming.get(), type.get(), spellType.get(), spellLevel.get(), clickedEntity);
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
                                            isHoming.get(), type.get(), spellType.get(), spellLevel.get());
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
            }
        });

        if (!augmentedShot.get()) {
            WandShotHandler.shoot(level, player, target, pSpeed, newLifespan, shotStack, wand, shotItem, thisWand, isHoming.get(), type.get(), spellType.get(), spellLevel.get());
        }
        if (isRush.get()) {
            if (!level.isClientSide()) {
                RandomSource random = RandomSource.create();

                double power = getAttribute(thisWand, WandItem.BASE_WAND_DAMAGE_ID) / 2.0;
                double inaccuracy = 1 - getAttribute(thisWand, WandItem.ACCURACY_ID);

                Vec3 launch = player.getLookAngle();

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

        player.getCooldowns().addCooldown(wand, (int) (getAttribute(thisWand, WandItem.COOLDOWN_ID) * 20));

    }

    public static void processHitEntity(Level level, Entity shooter, Entity target, WandShotItem shotItem, WandProjectile shot) {

        if(shot.isOnFire() || shot.canIgnite) target.setRemainingFireTicks(100);

        int lastHurtResistant = target.invulnerableTime;
        target.invulnerableTime = 0;

        DamageSource damageSource = new DamageSource(
                level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(EMDamageTypes.GENERIC_MAGIC),
                shot,
                shooter,
                null
        );

        boolean damaged;
        if (!(target == shooter)) {
            switch (shot.targetType) {
                case SpellModifiers.TargetType.MONSTERS -> {
                    damaged = target instanceof Monster &&
                            target.hurt(damageSource, (float) shot.damage);
                }
                case SpellModifiers.TargetType.ANIMALS -> {
                    damaged = target instanceof Animal &&
                            target.hurt(damageSource, (float) shot.damage);
                }
                case SpellModifiers.TargetType.PLAYERS -> {
                    damaged = target instanceof Player &&
                            target.hurt(damageSource, (float) shot.damage);
                }
                default -> {
                    damaged = target.hurt(damageSource, (float) shot.damage);
                }
            }
        }
        else {
            damaged = false;
        }

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
                WandSpellHandler.processWandModifiers(shotItem, livingTarget, player);
                WandSpellHandler.processSpells(level, player, livingTarget, null, shot);
            }

        }
        else if (!damaged) target.invulnerableTime = lastHurtResistant;

    }

    public static void processHit(Level level, Vec3 pos, HitResult.Type type, WandProjectile shot) {

        WandSpellHandler.processSpells(level, null, null, pos, shot);

        if (!level.isClientSide() && (!shot.noPhysics || type != HitResult.Type.BLOCK)) {
            shot.remove(Entity.RemovalReason.KILLED);
        }

    }

    public static void processTick(WandProjectile shot, double threshold, int ticksSinceFired, int counter,
                                   List<? extends LivingEntity> target) {

        if (ticksSinceFired > shot.lifetime || shot.getDeltaMovement().lengthSqr() < threshold) {
            shot.remove(Entity.RemovalReason.KILLED);
        }

        if (ticksSinceFired > 5 && shot.isHoming) {

            for (LivingEntity entity : target) {

                if (!entity.isDeadOrDying()) {
                    Vec3 currentPos = shot.getPosition(1.0f);
                    Vec3 targetPos = entity.getPosition(1.0f).add(0.0, entity.getEyeHeight() * 0.5, 0.0);
                    Vec3 newVector = targetPos.subtract(currentPos).normalize();

                    shot.setDeltaMovement(newVector);
                }

            }

        }

    }

    public static double getAttribute(ItemStack wandItem, ResourceLocation attributeID) {
        List<ItemAttributeModifiers.Entry> modifiers = wandItem.getAttributeModifiers().modifiers();

        for (ItemAttributeModifiers.Entry entries : modifiers) {
            if (entries.modifier().is(attributeID)) {
                return entries.modifier().amount();
            }
        }
        return 0;
    }

    public static <T extends LivingEntity> List<T> getNearbyEntities(Level level, int range, Player player, Class<T> type) {
        return level.getNearbyEntities(type, TargetingConditions.DEFAULT, player, new AABB(
                player.getX() - range,
                player.getY() - range,
                player.getZ() - range,
                player.getX() + range,
                player.getY() + range,
                player.getZ() + range));
    }

    public static <T extends LivingEntity> List<T> getClosestEntity(List<T> entities, Class<T> type, Player player) {
        return entities.stream().filter(iterate ->
                        player.hasLineOfSight(iterate) && !iterate.isInvulnerable() && iterate.distanceTo(player) < 24)
                .sorted(Comparator.comparingDouble(iterate -> -iterate.distanceTo(player)))
                .collect(Collectors.toList());
    }

}
