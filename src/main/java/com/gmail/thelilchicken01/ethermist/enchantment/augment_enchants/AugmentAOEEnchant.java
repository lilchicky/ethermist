package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.EMAttributes;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.SpellModifiers;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotHandler.setShotInfo;

public record AugmentAOEEnchant() implements IWandAugmentEffect {

    public static final MapCodec<AugmentAOEEnchant> CODEC = MapCodec.unit(AugmentAOEEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public boolean shoot(
            Level level,
            Player player,
            @Nullable List<? extends Entity> target,
            float pSpeed,
            double lifespan,
            ItemStack shotStack,
            WandItem wand,
            WandShotItem shotItem,
            ItemStack wandItem,
            boolean isHoming,
            List<SpellModifiers.TargetType> targetType,
            @Nullable BlockPos pos,
            @Nullable Entity clickedEntity,
            List<WandProjectile.SpellEntry> savedSpells,
            int spellLevel) {

        float wedges = (360.0f / (spellLevel * 3));
        int index = 0;

        WandProjectile shot;

        for (int x = 0; x < spellLevel * 3; x++) {

            if (target != null && !target.isEmpty()) {
                shot = shotItem.createProjectile(level, shotStack, player, List.of(target.get(index)), wandItem);
                index++;

                if (index >= target.size()) {
                    index = 0;
                }
            }
            else {
                shot = shotItem.createProjectile(level, shotStack, player, target, wandItem);
            }

            shot.shootFromRotation(
                    player,
                    0.0f,
                    player.getYRot() + (x * wedges),
                    0.0f,
                    pSpeed,
                    0.0f);

            shot.setPos(shot.getX(), player.getEyeHeight() * 0.8 + player.getY(), shot.getZ());

            level.addFreshEntity(setShotInfo(player, shot, wand, wandItem, lifespan, isHoming, targetType, savedSpells));

        }

        return true;
    }
}
