package com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile;

import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantComponents;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.EMAttributes;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
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

public class WandProjectileHandler {

    // This "saves" the ID of every "spell" enchantment on the wand. This allows saving the spells to
    // the shot, without having to iterate over the itemstack every time I want to check spells
    // (especially useful for performance on tick related spells).
    private static List<WandProjectile.SpellEntry> saveSpellEntries(ItemStack wand) {

        List<WandProjectile.SpellEntry> saved = new ArrayList<>();
        EnchantmentHelper.runIterationOnItem(wand, (enchant, level) -> {
            var spell = enchant.value().effects().get(EMEnchantComponents.WAND_SPELL_EFFECT.get());
            if (spell != null) {
                enchant.unwrapKey().ifPresent(key ->
                        saved.add(new WandProjectile.SpellEntry(key.location(), level))
                );
            }
        });

        return List.copyOf(saved);

    }

    public static boolean processShot(Level level, Player player, ItemStack thisWand, WandItem wand,
                                   @Nullable BlockPos pos, @Nullable Entity clickedEntity) {

        // Get lifespan and projectile speed from wand
        double newLifespan = WandUtil.getAttribute(player, EMAttributes.LIFESPAN, WandItem.LIFESPAN_ID);
        float pSpeed = (float) WandUtil.getAttribute(player, EMAttributes.PROJECTILE_SPEED, WandItem.PROJECTILE_SPEED_ID);

        // Projectile flags
        AtomicBoolean isHoming = new AtomicBoolean(false);
        AtomicBoolean makesProjectile = new AtomicBoolean(true);
        AtomicBoolean hasShot = new AtomicBoolean(false);

        // Wand shot item and shot item stack
        WandShotItem shotItem = wand.getOrb().getShotItem();
        ItemStack shotStack = new ItemStack(wand.getOrb().getShotItem());

        // Handle wand target filtering
        List<SpellModifiers.TargetType> types = new ArrayList<>();
        EnchantmentHelper.runIterationOnItem(thisWand, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.EXCLUDE_MONSTERS.location())) {
                types.add(SpellModifiers.TargetType.MONSTERS);
            }
            if (enchantHolder.is(EMEnchantments.EXCLUDE_ANIMALS.location())) {
                types.add(SpellModifiers.TargetType.ANIMALS);
            }
            if (enchantHolder.is(EMEnchantments.EXCLUDE_PLAYERS.location())) {
                types.add(SpellModifiers.TargetType.PLAYERS);
            }
        });

        if (types.isEmpty()) {
            types.add(SpellModifiers.TargetType.ALL);
        }

        // Find all nearby entities based on wand filters
        List<Entity> nearby = WandUtil.getNearbyEntities(level, (int) (newLifespan * 10), player);
        List<Entity> target = WandUtil.filterNearbyEntities(level, nearby, player, null, types);

        // Special wand flags. Currently implemented for if wand is homing, and if it should create a projectile
        // or not (like Kinetic Rush)
        EnchantmentHelper.runIterationOnItem(thisWand, (enchant, enchantLevel) -> {
            IWandAugmentEffect augment = enchant.value().effects().get(EMEnchantComponents.WAND_AUGMENT_EFFECT.get());
            IWandSpellEffect spell = enchant.value().effects().get(EMEnchantComponents.WAND_SPELL_EFFECT.get());
            if (augment != null) {
                if (augment.doesProjectileHome()) {
                    isHoming.set(true);
                }
                if (!augment.doesCreateProjectile(
                        player,
                        target,
                        pos,
                        clickedEntity,
                        enchantLevel
                )) {
                    makesProjectile.set(false);
                }
            }
            if (spell != null) {
                if (!spell.doesCreateProjectile(
                        player,
                        target,
                        pos,
                        clickedEntity,
                        enchantLevel
                )) {
                    makesProjectile.set(false);
                }
            }
        });

        // Attempt to run special shoot code from an augment. Only first special shot is ever used,
        // if somehow a wand has multiple augments that change shooting.
        // Also note the flag in augment.shoot() can be used to run special code on shoot, but still shoot the
        // default projectile, like in the Focus augment.
        EnchantmentHelper.runIterationOnItem(thisWand, (enchant, enchantLevel) -> {
            IWandAugmentEffect augment = enchant.value().effects().get(EMEnchantComponents.WAND_AUGMENT_EFFECT.get());
            if (augment != null) {
                if (!hasShot.get() && augment.shoot(
                        level,
                        player,
                        target,
                        pSpeed,
                        newLifespan,
                        shotStack,
                        wand,
                        shotItem,
                        thisWand,
                        isHoming.get(),
                        types,
                        pos,
                        clickedEntity,
                        saveSpellEntries(thisWand),
                        enchantLevel)) {
                    hasShot.set(true);
                }
            }
        });

        // If there was no special shot fired, and the wand should create a projectile, then run a default shoot method.
        if (!hasShot.get() && makesProjectile.get()) {
            WandShotHandler.shoot(
                    level,
                    player,
                    target,
                    pSpeed,
                    newLifespan,
                    shotStack,
                    wand, shotItem,
                    thisWand,
                    isHoming.get(),
                    types,
                    saveSpellEntries(thisWand)
            );
            hasShot.set(true);
        }

        // Run any special spell effects on shoot (right click), like Kinetic Rush
        EnchantmentHelper.runIterationOnItem(thisWand, (enchant, enchantLevel) -> {
            IWandSpellEffect spell = enchant.value().effects().get(EMEnchantComponents.WAND_SPELL_EFFECT.get());
            if (spell != null) {
                spell.onShoot(level, player);
            }
        });

        // Add cooldown to wand
        player.getCooldowns().addCooldown(wand, (int) (WandUtil.getAttribute(player, EMAttributes.COOLDOWN, WandItem.COOLDOWN_ID) * 20));

        return hasShot.get();

    }

    public static void processHitEntity(Level level, Entity shooter, Entity target, WandShotItem shotItem, WandProjectile shot, Vec3 hitPos) {

        if (shot.isOnFire() || shot.canIgnite) target.setRemainingFireTicks(100);

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

        } else {
            damaged = false;
        }

        if (damaged) {

            // Knockback Math
            if (shot.knockbackStrength != 0 && target.isPushable()) {
                Vec3 vec = shot.getDeltaMovement().multiply(1, 0, 1).normalize().scale(shot.knockbackStrength);
                if (vec.lengthSqr() > 0) {
                    target.push(vec.x, 0.1, vec.z);
                }
            }

            // Wand Specific Modifiers
            if (shooter instanceof Player player) {
                WandSpellHandler.processWandModifiers(shotItem, target, player, shot);
                WandSpellHandler.processSpells(level, player, target, null, shot);
            }

        } else {
            target.invulnerableTime = lastHurtResistant;
        }

    }

    public static void processHit(Level level, Entity shooter, Vec3 pos, HitResult result, WandProjectile shot) {

        if (result.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityResult = (EntityHitResult) result;
            Entity target = entityResult.getEntity();
            WandShotItem shotItem = (WandShotItem) shot.getItem().getItem();

            processHitEntity(level, shooter, target, shotItem, shot, pos);
        } else if (result.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockResult = (BlockHitResult) result;
            BlockPos hitPos = blockResult.getBlockPos();
            WandSpellHandler.processSpells(level, shooter, null, hitPos, shot);
        }

        /*
                        UPDATE THIS TO NOT BE HARDCODED!!
         */
        if (!shot.hasSpell(EMEnchantments.SEISMIC_SURGE.location())) {
            if (!level.isClientSide() && (!shot.noPhysics || result.getType() != HitResult.Type.BLOCK)) {
                shot.remove(Entity.RemovalReason.KILLED);
            }
        }

    }

    public static void processTick(WandProjectile shot, double threshold, int ticksSinceFired, int tick,
                                   List<? extends Entity> target) {

        if (!shot.level().isClientSide() && (ticksSinceFired > shot.lifetime ||
                (shot.getDeltaMovement().lengthSqr() < threshold))) {
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
