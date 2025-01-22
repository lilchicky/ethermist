package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class WandEnchantHandler {

    public static void processShot(Level level, Player player, ItemStack thisWand, WandItem wand) {

        WandShotItem itemSkin = wand.getShotItem();

        ItemStack shotStack = new ItemStack(wand.getShotItem());

        int newLifespan = (int)getAttribute(thisWand, WandItem.LIFESPAN_ID);

        float pSpeed = (float)getAttribute(thisWand, WandItem.PROJECTILE_SPEED_ID);

        shoot(level, player, pSpeed, newLifespan, shotStack, wand, itemSkin, thisWand);

        player.getCooldowns().addCooldown(wand, (int)(getAttribute(thisWand, WandItem.COOLDOWN_ID) * 20));

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
                (float)(100 - (getAttribute(wandItem, WandItem.ACCURACY_ID)*100)));

        //shot.setPos(shot.getX(), player.getEyeHeight() * 0.75 + player.getY(), shot.getZ());

        shot.setDamage((int)getAttribute(wandItem, WandItem.BASE_WAND_DAMAGE_ID));
        shot.setLifetime(lifespan * 20);
        shot.setCanIgnite(wand.getCanIgnite());
        shot.setKnockbackStrength(getAttribute(wandItem, WandItem.WAND_KNOCKBACK_ID));

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

}
