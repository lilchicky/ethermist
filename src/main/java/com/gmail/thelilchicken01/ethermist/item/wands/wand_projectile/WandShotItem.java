package com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class WandShotItem extends Item {

    public WandShotItem() {
        super(new Item.Properties().stacksTo(1));
    }

    public WandProjectile createProjectile(Level level, ItemStack item, LivingEntity shooter, List<? extends Entity> target, ItemStack wand) {

        WandProjectile shot = new WandProjectile(level, shooter, target, wand);

        shot.setItem(item);
        return shot;

    }

}
