package com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class SeismicSurgeEnchant implements IWandSpellEffect {

    public static final MapCodec<SeismicSurgeEnchant> CODEC = MapCodec.unit(SeismicSurgeEnchant::new);

    @Override
    public MapCodec<? extends IWandSpellEffect> codec() {
        return CODEC;
    }

    @Override
    public void onHit(
            Level level,
            Entity shooter,
            @Nullable Entity target,
            @Nullable BlockPos hitPos,
            WandProjectile shot,
            int spellLevel) {

        if (target == null && hitPos != null) {
            Block block = level.getBlockState(hitPos).getBlock();
            float playerBreakStrength = (float)((Math.pow(shot.getDamage() + spellLevel, 2)) / 18);
            if (block.defaultDestroyTime() <= playerBreakStrength && block.defaultDestroyTime() > 0.0f) {
                level.destroyBlock(hitPos, true, shooter);
                shot.remove(Entity.RemovalReason.KILLED);
            }
            else {
                shot.remove(Entity.RemovalReason.KILLED);
            }
        } else {
            if (target instanceof LivingEntity livingTarget) {
                livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, spellLevel * 40, spellLevel));
            }
        }

    }
}
