package com.gmail.thelilchicken01.ethermist.item.wands.wand_type_effects;

import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.IWandTiers;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.WandTier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface IWandTypeEffect {
    void apply(WandShotItem shotItem, Entity target, Player player, WandProjectile shot);
}
