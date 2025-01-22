package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.AncientPowerEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.ArcaneVelocityEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.GreaterDistanceEnchant;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.QuickCastEnchant;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WandEnchantHandler {

    public static void processShot(Level level, Player player, ItemStack thisWand, WandItem wand) {

        WandShotItem itemSkin = wand.getShotItem();

        ItemStack shotStack = new ItemStack(wand.getShotItem());

        int newLifespan = GreaterDistanceEnchant.modifyLifespan(thisWand.getEnchantmentLevel(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(EMEnchantments.GREATER_DISTANCE)), wand.getLifespanSeconds());

        float pSpeed = ArcaneVelocityEnchant.modifyPSpeed(thisWand.getEnchantmentLevel(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(EMEnchantments.ARCANE_VELOCITY)), wand.getProjectileSpeed());

        shoot(level, player, pSpeed, newLifespan, shotStack, wand, itemSkin, thisWand);

        player.getCooldowns().addCooldown(wand, getModifiedCooldown(thisWand, level));

    }

    private static void shoot(Level level, Player player, float pSpeed, int lifespan,
                              ItemStack shotStack, WandItem wand, WandShotItem shotItem, ItemStack wandItem) {

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player);

        shot.shootFromRotation(
                player,
                player.getXRot(),
                player.getYRot(),
                0,
                pSpeed,
                wand.getInaccuracy());

        shot.setDamage(getModifiedDamage(level, wandItem, wand));
        shot.setLifetime(lifespan * 20);
        shot.setTrail(wand.getTrail());
        shot.setCanIgnite(wand.getCanIgnite());
        shot.setKnockbackStrength(wand.getKnockback());

        level.addFreshEntity(shot);

    }

    public static void processHitEntity(Level level, Entity shooter, Entity target, WandShotItem shotItem, WandProjectile shot) {

        if(shot.isOnFire() || shot.canIgnite) target.setRemainingFireTicks(100);

        DamageSource damageSource = new DamageSource(
                level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(EMDamageTypes.GENERIC_MAGIC),
                shot,
                shooter,
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

    public static void processTick(WandProjectile shot, double threshold, int ticksSinceFired) {

        if (ticksSinceFired > shot.lifetime || shot.getDeltaMovement().lengthSqr() < threshold) {
            shot.remove(Entity.RemovalReason.KILLED);
        }
    }

    private static double getModifiedDamage(Level level, ItemStack wandItem, WandItem wand) {
        List<ItemAttributeModifiers.Entry> modifiers = wandItem.getAttributeModifiers().modifiers();

        for (ItemAttributeModifiers.Entry entries : modifiers) {
            if (entries.modifier().is(WandItem.WAND_DAMAGE_ID)) {
                return entries.modifier().amount();
            }
        }
        return 0;
    }

    private static int getModifiedCooldown(ItemStack wandItem, Level level) {
        List<ItemAttributeModifiers.Entry> modifiers = wandItem.getAttributeModifiers().modifiers();

        for (ItemAttributeModifiers.Entry entries : modifiers) {
            if (entries.modifier().is(WandItem.COOLDOWN_ID)) {
                return (int) (entries.modifier().amount() * 20);
            }
        }
        return 0;

    }

    public static List<Component> getHoverText(ItemStack wandItem, WandItem wand, Item.TooltipContext context, List<Component> lore) {

        lore.add(Component.translatable(wand.getDescriptionId() + ".wand_desc").withColor(0xAAAAAA));
        lore.add(Component.empty());

        return lore;
    }

}
