package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
import java.util.concurrent.atomic.AtomicReference;

public class WandEnchantHandler {

    public static void processShot(Level level, Player player, ItemStack thisWand, WandItem wand) {

        WandShotItem itemSkin = wand.getShotItem();

        ItemStack shotStack = new ItemStack(wand.getShotItem());

        int newLifespan = (int)getAttribute(thisWand, WandItem.LIFESPAN_ID);
        float pSpeed = (float)getAttribute(thisWand, WandItem.PROJECTILE_SPEED_ID);

        AtomicBoolean augmentedShot = new AtomicBoolean(false);
        AtomicBoolean isHoming = new AtomicBoolean(false);
        AtomicReference<TargetType> type = new AtomicReference<>(TargetType.ALL);

        EnchantmentHelper.runIterationOnItem(thisWand, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.AUGMENT_HOMING.location())) {
                isHoming.set(true);
            }
            if (enchantHolder.is(EMEnchantments.FOCUS_MONSTERS.location())) {
                type.set(TargetType.MONSTERS);
            }
            if (enchantHolder.is(EMEnchantments.FOCUS_ANIMALS.location())) {
                type.set(TargetType.ANIMALS);
            }
            if (enchantHolder.is(EMEnchantments.FOCUS_PLAYERS.location())) {
                type.set(TargetType.PLAYERS);
            }
        });

        LivingEntity target;
        switch (type.get()) {
            case TargetType.MONSTERS -> {
                List<Monster> nearbyEntities = getNearbyEntities(level, newLifespan * 10, player, Monster.class);
                target = getClosestEntity(nearbyEntities, Monster.class, player);
            }
            case TargetType.ANIMALS -> {
                List<Animal> nearbyEntities = getNearbyEntities(level, newLifespan * 10, player, Animal.class);
                target = getClosestEntity(nearbyEntities, Animal.class, player);
            }
            case TargetType.PLAYERS -> {
                List<Player> nearbyEntities = getNearbyEntities(level, newLifespan * 10, player, Player.class);
                target = getClosestEntity(nearbyEntities, Player.class, player);
            }
            default -> {
                List<LivingEntity> nearbyEntities = getNearbyEntities(level, newLifespan * 10, player, LivingEntity.class);
                target = getClosestEntity(nearbyEntities, LivingEntity.class, player);
            }
        }

        EnchantmentHelper.runIterationOnItem(thisWand, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.AUGMENT_SPLIT.location())) {
                shootSplit(level, player, target, pSpeed, newLifespan, shotStack, wand, itemSkin, thisWand, enchantLevel, isHoming.get(), type.get());
                augmentedShot.set(true);
            }
        });

        if (!augmentedShot.get()) {
            shoot(level, player, target, pSpeed, newLifespan, shotStack, wand, itemSkin, thisWand, isHoming.get(), type.get());
        }

        player.getCooldowns().addCooldown(wand, (int)(getAttribute(thisWand, WandItem.COOLDOWN_ID) * 20));

    }

    private static void shoot(Level level, Player player, @Nullable LivingEntity target, float pSpeed, int lifespan,
                              ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem,
                              boolean isHoming, TargetType targetType) {

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player, target);

        shot.shootFromRotation(
                player,
                player.getXRot(),
                player.getYRot(),
                0,
                pSpeed,
                (float)(100 - (getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

        //shot.setPos(shot.getX(), player.getEyeHeight() * 0.75 + player.getY(), shot.getZ());

        shot.setDamage((int)getAttribute(wandItem, WandItem.BASE_WAND_DAMAGE_ID));
        shot.setLifetime(lifespan * 20);
        shot.setCanIgnite(wand.getCanIgnite());
        shot.setKnockbackStrength(getAttribute(wandItem, WandItem.WAND_KNOCKBACK_ID));
        shot.setHoming(isHoming);
        shot.setTargetType(targetType);

        level.addFreshEntity(shot);

    }

    private static void shootSplit(Level level, Player player, @Nullable LivingEntity target, float pSpeed, int lifespan,
                                   ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem, int iterations,
                                   boolean isHoming, TargetType targetType) {

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player, target);

        shot.shootFromRotation(
                player,
                player.getXRot(),
                player.getYRot(),
                0,
                pSpeed,
                (float)(100 - (getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

        shot.setDamage((int)getAttribute(wandItem, WandItem.BASE_WAND_DAMAGE_ID));
        shot.setLifetime(lifespan * 20);
        shot.setCanIgnite(wand.getCanIgnite());
        shot.setKnockbackStrength(getAttribute(wandItem, WandItem.WAND_KNOCKBACK_ID));
        shot.setHoming(isHoming);
        shot.setTargetType(targetType);

        level.addFreshEntity(shot);

        for (int x = 0; x < iterations; x++) {

            WandProjectile splitShot = shotItem.createProjectile(level, shotStack, player, target);
            WandProjectile splitShot2 = shotItem.createProjectile(level, shotStack, player, target);

            splitShot.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot() + (10 * x),
                    0,
                    pSpeed,
                    (float)(100 - (getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

            splitShot2.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot() - (10 * x),
                    0,
                    pSpeed,
                    (float)(100 - (getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

            splitShot.setDamage((int)getAttribute(wandItem, WandItem.BASE_WAND_DAMAGE_ID));
            splitShot.setLifetime(lifespan * 20);
            splitShot.setCanIgnite(wand.getCanIgnite());
            splitShot.setKnockbackStrength(getAttribute(wandItem, WandItem.WAND_KNOCKBACK_ID));
            splitShot.setHoming(isHoming);
            splitShot.setTargetType(targetType);

            splitShot2.setDamage((int)getAttribute(wandItem, WandItem.BASE_WAND_DAMAGE_ID));
            splitShot2.setLifetime(lifespan * 20);
            splitShot2.setCanIgnite(wand.getCanIgnite());
            splitShot2.setKnockbackStrength(getAttribute(wandItem, WandItem.WAND_KNOCKBACK_ID));
            splitShot2.setHoming(isHoming);
            splitShot2.setTargetType(targetType);

            level.addFreshEntity(splitShot);
            level.addFreshEntity(splitShot2);

        }

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
        switch (shot.targetType) {
            case TargetType.MONSTERS -> {
                damaged = target instanceof Monster &&
                        target.hurt(damageSource, (float) shotItem.modifyDamage(shot.damage, shot, target, shooter, level));
            }
            case TargetType.ANIMALS -> {
                damaged = target instanceof Animal &&
                        target.hurt(damageSource, (float) shotItem.modifyDamage(shot.damage, shot, target, shooter, level));
            }
            case TargetType.PLAYERS -> {
                damaged = target instanceof Player &&
                        target.hurt(damageSource, (float) shotItem.modifyDamage(shot.damage, shot, target, shooter, level));
            }
            default -> {
                damaged = target.hurt(damageSource, (float) shotItem.modifyDamage(shot.damage, shot, target, shooter, level));
            }
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
                switch (shotItem.getModifier()) {
                    case FLAME_WAND -> {
                        livingTarget.setRemainingFireTicks(200);
                    }
                    case LEVITATION_WAND -> {
                        livingTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
                    }
                    default -> {
                    }
                }
            }

            shotItem.onLivingEntityHit(shot, livingTarget, shooter, level);

        }
        else if (!damaged) target.invulnerableTime = lastHurtResistant;

    }

    public static void processHit(Level level, Vec3 pos, HitResult.Type type, WandProjectile shot) {

        if (!level.isClientSide() && (!shot.noPhysics || type != HitResult.Type.BLOCK)) {
            shot.remove(Entity.RemovalReason.KILLED);
        }

    }

    public static void processTick(WandProjectile shot, double threshold, int ticksSinceFired, LivingEntity target) {

        if (ticksSinceFired > shot.lifetime || shot.getDeltaMovement().lengthSqr() < threshold) {
            shot.remove(Entity.RemovalReason.KILLED);
        }
        if (ticksSinceFired > 5) {

            if (!(target == null) && !target.isDeadOrDying()) {

                Vec3 currentPos = shot.getPosition(1.0f);
                Vec3 targetPos = target.getPosition(1.0f).add(0.0, target.getEyeHeight() * 0.5, 0.0);
                Vec3 newVector = targetPos.subtract(currentPos).normalize();

                shot.setDeltaMovement(newVector);
            }

        }

    }

    private static double getAttribute(ItemStack wandItem, ResourceLocation attributeID) {
        List<ItemAttributeModifiers.Entry> modifiers = wandItem.getAttributeModifiers().modifiers();

        for (ItemAttributeModifiers.Entry entries : modifiers) {
            if (entries.modifier().is(attributeID)) {
                return entries.modifier().amount();
            }
        }
        return 0;
    }

    public static List<Component> getHoverText(ItemStack wandItem, WandItem wand, Item.TooltipContext context, List<Component> lore) {

        lore.add(Component.translatable(wand.getDescriptionId() + ".wand_desc").withColor(0xAAAAAA));
        lore.add(Component.empty());

        return lore;
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

    public static <T extends LivingEntity> T getClosestEntity(List<T> entities, Class<T> type, Player player) {
        return entities.stream().filter(iterate ->
                        player.hasLineOfSight(iterate) && !iterate.isInvulnerable() && iterate.distanceTo(player) < 24)
                .min(Comparator.comparingDouble(iterate -> iterate.distanceTo(player)))
                .orElse(null);
    }

}
