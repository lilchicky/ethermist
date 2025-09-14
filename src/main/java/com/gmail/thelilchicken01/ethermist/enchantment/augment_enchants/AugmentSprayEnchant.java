package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
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

public record AugmentSprayEnchant() implements IWandAugmentEffect {

    public static final MapCodec<AugmentSprayEnchant> CODEC = MapCodec.unit(AugmentSprayEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        double damage = Math.max(0.0, state.damage);
        double damageMod = 1.0 / (1.0 + 0.81 * (1.0 / (1.0 + level)) * Math.sqrt(damage));
        state.damage *= damageMod;

        state.lifespanSeconds = Math.max(1.0, state.lifespanSeconds * 0.1);

        state.projectileSpeedMult *= 0.5;

        state.cooldownTicks = 5;

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

        if (!level.isClientSide()) {

            MinecraftServer server = level.getServer();

            if (!(server == null)) {

                for (int x = 0; x < spellLevel + 2; x++) {

                    int scheduleShot = server.getTickCount() + (x * 2);

                    Ethermist.SCHEDULER.schedule(scheduleShot, () -> {
                        WandShotHandler.shoot(level, player, target, pSpeed, lifespan, shotStack, wand, shotItem, wandItem,
                                isHoming, targetType, savedSpells);
                        level.playSound(null,
                                player.getX(),
                                player.getY(),
                                player.getZ(),
                                wand.getShootSound(),
                                SoundSource.PLAYERS,
                                0.5f,
                                level.getRandom().nextFloat() * 0.4f + 0.8f);
                    });
                }
            }
        }

        return true;
    }
}
