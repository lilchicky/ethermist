package com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;

import java.util.List;

import static com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandSpellHandler.drawLine;
import static com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandSpellHandler.processWandModifiers;

public class VolatileEnergyEnchant implements IWandSpellEffect {

    public static final MapCodec<VolatileEnergyEnchant> CODEC = MapCodec.unit(VolatileEnergyEnchant::new);

    @Override
    public MapCodec<? extends IWandSpellEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.damage *= 0.5;

    }

    @Override
    public void onTick(WandProjectile shot, int tick, List<? extends Entity> target, int spellLevel) {

        if (tick % 2 == 0 && shot.getShooter() != null) {

            DamageSource damageSource = new DamageSource(
                    shot.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(shot.getDamageType()),
                    shot,
                    shot.getShooter(),
                    null
            );

            int range = (spellLevel + 1) * 2;
            List<Entity> closeTargets = WandUtil.getNearbyEntities(shot.level(), range, shot);

            closeTargets = WandUtil.filterNearbyEntities(shot.level(), closeTargets, shot, shot.getOwner(), shot.getTargetType());

            if (!closeTargets.isEmpty()) {
                processWandModifiers((WandShotItem) shot.getItem().getItem(), closeTargets.getLast(), shot.getShooter(), shot.getOriginWandStack());
                drawLine(shot.position(), closeTargets.getLast().position(), (ServerLevel) shot.level());
                closeTargets.getLast().hurt(damageSource, (float) shot.getDamage());
            }
        }

    }
}
