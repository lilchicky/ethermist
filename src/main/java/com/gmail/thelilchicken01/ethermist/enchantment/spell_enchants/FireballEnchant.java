package com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FireballEnchant implements IWandSpellEffect {

    public static final MapCodec<FireballEnchant> CODEC = MapCodec.unit(FireballEnchant::new);

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

        level.explode(
                null,
                shot.getX(),
                shot.getY(),
                shot.getZ(),
                (float) spellLevel,
                true,
                Level.ExplosionInteraction.TNT
        );
        level.playSound(null,
                shot.getX(),
                shot.getY(),
                shot.getZ(),
                SoundEvents.GENERIC_EXPLODE,
                SoundSource.PLAYERS,
                1.0f,
                level.getRandom().nextFloat() * 0.4f + 0.8f);

    }
}
