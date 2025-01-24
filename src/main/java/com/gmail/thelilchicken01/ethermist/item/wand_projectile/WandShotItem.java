package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class WandShotItem extends Item {

    private final int DAMAGE;
    private final WandModifiers WAND_MODIFIER;

    public WandShotItem(int damage, WandModifiers modifier) {
        super(new Item.Properties().stacksTo(1));
        this.DAMAGE = damage;
        this.WAND_MODIFIER = modifier;
    }

    public WandProjectile createProjectile(Level level, ItemStack item, LivingEntity shooter, List<? extends LivingEntity> target) {

        WandProjectile shot = new WandProjectile(level, shooter, target);

        shot.setItem(item);
        shot.setDamage(DAMAGE);
        return shot;

    }

    public WandProjectile createNonTargetProjectile(Level level, ItemStack item, LivingEntity shooter) {

        WandProjectile shot = new WandProjectile(level, shooter);

        shot.setItem(item);
        shot.setDamage(DAMAGE);
        return shot;

    }

    public WandModifiers getModifier() {
        return WAND_MODIFIER;
    }

    public double modifyDamage(double damage, WandProjectile projectile, Entity target, @Nullable Entity shooter, Level level) {
        return damage;
    }

    public void onLivingEntityHit(WandProjectile projectile, LivingEntity target, @Nullable Entity shooter, Level level) {
    }

}
