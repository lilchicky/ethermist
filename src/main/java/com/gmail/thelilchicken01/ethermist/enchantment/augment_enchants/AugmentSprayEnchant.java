package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantComponents;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotHandler;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public record AugmentSprayEnchant() implements IWandAugmentEffect {

    public static final MapCodec<AugmentSprayEnchant> CODEC = MapCodec.unit(AugmentSprayEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public void modifyWandAttributes(WandAttributeState state, int level) {
        float damage = state.getAttributeModifierAmount(EMAttributes.WAND_DAMAGE);
        float lifespan = state.getAttributeModifierAmount(EMAttributes.LIFESPAN);

        state.modifyExistingAttribute(EMAttributes.WAND_DAMAGE, WandAttributeState.Operation.MULT, (float)(1.0f / (1.0f + 0.81f * (1.0f / (1.0f + level)) * Math.sqrt(damage))));
        state.modifyExistingAttribute(EMAttributes.LIFESPAN, Math.max(1.0f, lifespan * 0.2f));
        state.modifyExistingAttribute(EMAttributes.PROJECTILE_SPEED, WandAttributeState.Operation.MULT, 0.5f);
    }

    @Override
    public boolean shoot(
            Level level,
            LivingEntity shooter,
            @Nullable List<? extends Entity> target,
            float pSpeed,
            double lifespan,
            ItemStack shotStack,
            WandItem wand,
            WandShotItem shotItem,
            ItemStack wandItem,
            boolean isHoming,
            List<Class<?>> targetType,
            @Nullable BlockPos pos,
            @Nullable Entity clickedEntity,
            List<WandProjectile.SpellEntry> savedSpells,
            int spellLevel) {

        if (!level.isClientSide()) {

            MinecraftServer server = level.getServer();

            AtomicBoolean makesProjectile = new AtomicBoolean(true);
            EnchantmentHelper.runIterationOnItem(wandItem, (enchant, enchantLevel) -> {
                IWandAugmentEffect augment = enchant.value().effects().get(EMEnchantComponents.WAND_AUGMENT_EFFECT.get());
                IWandSpellEffect spell = enchant.value().effects().get(EMEnchantComponents.WAND_SPELL_EFFECT.get());
                if (augment != null) {
                    if (!augment.doesCreateProjectile(shooter, target, pos, clickedEntity, enchantLevel)) {
                        makesProjectile.set(false);
                    }
                }
                if (spell != null) {
                    if (!spell.doesCreateProjectile(shooter, target, pos, clickedEntity, enchantLevel)) {
                        makesProjectile.set(false);
                    }
                }
            });

            if (!(server == null) && makesProjectile.get()) {

                ItemStack usedWand = wandItem.copy();

                for (int x = 0; x < spellLevel + 2; x++) {

                    int scheduleShot = server.getTickCount() + (x * 2);

                    Ethermist.SCHEDULER.schedule(scheduleShot, () -> {
                        WandShotHandler.shoot(level, shooter, target, pSpeed, lifespan, shotStack, wand, shotItem, usedWand,
                                isHoming, targetType, savedSpells);
                        level.playSound(null,
                                shooter.getX(),
                                shooter.getY(),
                                shooter.getZ(),
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
