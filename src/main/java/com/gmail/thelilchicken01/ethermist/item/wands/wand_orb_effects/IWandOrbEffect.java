package com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects;

import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public interface IWandOrbEffect {
    void apply(WandShotItem shotItem, Entity target, Entity shooter, WandProjectile shot);
}
