package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.EMAttributes;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.SpellModifiers;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotHandler;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotHandler.setShotInfo;

public record AugmentSplitEnchant() implements IWandAugmentEffect {

    public static final MapCodec<AugmentSplitEnchant> CODEC = MapCodec.unit(AugmentSplitEnchant::new);

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

        // This is added for the homing enchantment, so all bullets home in on the closest mob
        List<? extends Entity> targetHolder = target;
        if (target != null && !target.isEmpty()) {
            targetHolder = List.of(target.getLast());
        }

        WandProjectile shot = shotItem.createProjectile(level, shotStack, player, targetHolder, wandItem);

        shot.shootFromRotation(
                player,
                player.getXRot(),
                player.getYRot(),
                0,
                pSpeed,
                (float)(100 - (WandUtil.getAttribute(player, EMAttributes.ACCURACY, WandItem.ACCURACY_ID)*100)));

        level.addFreshEntity(setShotInfo(player, shot, wand, wandItem, lifespan, isHoming, targetType, savedSpells));

        for (int x = 0; x < spellLevel; x++) {

            WandProjectile splitShot = shotItem.createProjectile(level, shotStack, player, target, wandItem);
            WandProjectile splitShot2 = shotItem.createProjectile(level, shotStack, player, target, wandItem);

            splitShot.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot() + (10 * x),
                    0,
                    pSpeed,
                    (float)(100 - (WandUtil.getAttribute(player, EMAttributes.ACCURACY, WandItem.ACCURACY_ID)*100)));

            splitShot2.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot() - (10 * x),
                    0,
                    pSpeed,
                    (float)(100 - (WandUtil.getAttribute(player, EMAttributes.ACCURACY, WandItem.ACCURACY_ID)*100)));

            level.addFreshEntity(setShotInfo(player, splitShot, wand, wandItem, lifespan, isHoming, targetType, savedSpells));
            level.addFreshEntity(setShotInfo(player, splitShot2, wand, wandItem, lifespan, isHoming, targetType, savedSpells));

        }

        return true;
    }
}
