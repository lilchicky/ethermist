package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeStateTest;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AugmentFocusEnchant implements IWandAugmentEffect {

    public static final MapCodec<AugmentFocusEnchant> CODEC = MapCodec.unit(AugmentFocusEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public void modifyWandAttributes(WandAttributeStateTest state, int level) {
        state.modifyExistingAttribute(EMAttributes.WAND_DAMAGE, WandAttributeStateTest.Operation.MULT, ((level + 1) * 0.5f) + 1);
        state.modifyExistingAttribute(EMAttributes.PROJECTILE_SPEED, WandAttributeStateTest.Operation.MULT, 4.5f);
        state.modifyExistingAttribute(EMAttributes.ACCURACY, 1.0f);

        int cooldownTicks = (int) (state.getAttributeModifierAmount(EMAttributes.COOLDOWN) * 20);

        state.modifyExistingAttribute(EMAttributes.COOLDOWN, Math.max(cooldownTicks * 4, 160) / 20.0f);
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
            shooter.setDeltaMovement(shooter.getDeltaMovement().add(shooter.getLookAngle().scale(-0.3f)));
            shooter.hurtMarked = true;
        }

        return false;
    }
}
