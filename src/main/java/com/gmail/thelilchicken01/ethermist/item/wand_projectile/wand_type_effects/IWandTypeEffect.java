package com.gmail.thelilchicken01.ethermist.item.wand_projectile.wand_type_effects;

import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface IWandTypeEffect {
    void apply(WandShotItem shotItem, Entity target, Player player, ItemStack wand);
}
