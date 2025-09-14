package com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ThunderstrikeEnchant implements IWandSpellEffect {

    public static final MapCodec<ThunderstrikeEnchant> CODEC = MapCodec.unit(ThunderstrikeEnchant::new);

    @Override
    public MapCodec<? extends IWandSpellEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.cooldownTicks = (int)Math.round((8L * state.cooldownTicks + 240L) / 7.0);

    }

    @Override
    public void onHit(Level level,
                      Entity shooter,
                      @Nullable Entity target,
                      @Nullable BlockPos hitPos,
                      WandProjectile shot,
                      int spellLevel) {

        for (int x = 0; x < spellLevel; x++) {
            LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
            if (bolt != null) {
                bolt.moveTo(shot.getX(), shot.getY(), shot.getZ());
                level.addFreshEntity(bolt);
            }
        }

    }
}
