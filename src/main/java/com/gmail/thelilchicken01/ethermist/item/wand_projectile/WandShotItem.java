package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class WandShotItem extends Item {

    private WandModifiers WAND_MODIFIER;

    public WandShotItem(WandModifiers modifier) {
        super(new Item.Properties().stacksTo(1));
        this.WAND_MODIFIER = modifier;
    }

    public WandShotItem() {
        super(new Item.Properties().stacksTo(1));
    }

    public WandProjectile createProjectile(Level level, ItemStack item, LivingEntity shooter, List<? extends Entity> target) {

        WandProjectile shot = new WandProjectile(level, shooter, target);

        shot.setItem(item);
        return shot;

    }

    public WandModifiers getModifier() {
        return WAND_MODIFIER;
    }

    public void setModifier(WandModifiers modifier) {
        this.WAND_MODIFIER = modifier;
    }

}
