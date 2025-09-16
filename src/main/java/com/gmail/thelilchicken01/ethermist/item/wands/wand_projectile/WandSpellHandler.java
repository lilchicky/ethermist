package com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile;

import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantComponents;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.CommonHooks;

import javax.annotation.Nullable;
import java.util.List;

public class WandSpellHandler {

    public static void processWandModifiers(WandShotItem shotItem, Entity target, Player player, WandProjectile shot) {

        if (shot.originWandType != null) {
            shot.originWandType.apply(shotItem, target, player, shot);
        }

    }

    public static void processSpells(Level level, Entity shooter, @Nullable Entity target, @Nullable BlockPos hitPos, WandProjectile shot) {

        if (!level.isClientSide()) {

            for (var spellEntry : shot.getSpellEntries()) {
                IWandSpellEffect spell = findSpellFromID(spellEntry.enchantId());
                if (spell != null) {
                    spell.onHit(level, shooter, target, hitPos, shot, spellEntry.level());
                }
            }

        }

    }

    public static void processSpellTick(WandProjectile shot, int tick, List<? extends Entity> target) {

        if (!shot.level().isClientSide()) {

            for (var spellEntry : shot.getSpellEntries()) {
                IWandSpellEffect spell = findSpellFromID(spellEntry.enchantId());
                if (spell != null) {
                    spell.onTick(shot, tick, target, spellEntry.level());
                }
            }

        }

    }

    /*
    ---------- Helper Methods ----------
     */

    // Draws line between target and shot. Currently used for Volatile Orb
    public static void drawLine(Vec3 start, Vec3 end, ServerLevel level) {
        int num = 24;
        Vec3 step = end.subtract(start).scale(1.0 / num);
        for (int x = 0; x <= num; x++) {
            Vec3 pos = start.add(step.scale(x));
            level.sendParticles(EMParticleTypes.VOLATILE_ENERGY_TETHER.get(), pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
        }
    }

    // Retrieves spell from registry based on ID
    @Nullable
    private static IWandSpellEffect findSpellFromID(ResourceLocation enchantId) {
        HolderLookup.RegistryLookup<Enchantment> lookup = CommonHooks.resolveLookup(Registries.ENCHANTMENT);
        if (lookup == null) return null;
        var key = ResourceKey.create(Registries.ENCHANTMENT, enchantId);
        var holderOpt = lookup.get(key);
        return holderOpt.map(enchantmentReference ->
                enchantmentReference.value().effects().get(EMEnchantComponents.WAND_SPELL_EFFECT.get())).orElse(null);
    }

}
