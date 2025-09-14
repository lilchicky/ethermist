package com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ChaosMagicEnchant implements IWandSpellEffect {

    public static final MapCodec<ChaosMagicEnchant> CODEC = MapCodec.unit(ChaosMagicEnchant::new);

    @Override
    public MapCodec<? extends IWandSpellEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.damage *= level;

    }

    @Override
    public void onHit(Level level,
                      Entity shooter,
                      @Nullable Entity target,
                      @Nullable BlockPos hitPos,
                      WandProjectile shot,
                      int spellLevel) {
        var legendary = 1;
        var ultra = 7;
        var rare = 12;
        var uncommon = 16;
        var common = 18;

        int[] entityWeights = {
                rare, // Teleport player
                rare, // Teleport target
                ultra, // Explode @ Player
                rare, // Levitation
                ultra, // Confusion
                uncommon, // Bad Omen
                rare, // Good Omen
                common, // Glowing
                common, // Regen
                uncommon, // Resistance
                common, // Haste
                legendary, // Cake
                legendary, // Spawn Egg
                legendary, // Duplicate Mob
                uncommon, // Saturation
                ultra, // Explode @ Target
        };

        int totalEntityWeight = 0;
        for (int w : entityWeights) {
            totalEntityWeight += w;
        }

        for (int iterations = 0; iterations < spellLevel; iterations++) {

            Random random = new Random();
            int entityChoice = random.nextInt(totalEntityWeight);

            if (shooter != null && target != null) {

                int currentWeight = 0;
                int index = -1;
                for (int x = 0; x < entityWeights.length; x++) {
                    currentWeight += entityWeights[x];
                    if (entityChoice < currentWeight) {
                        index = x;
                        break;
                    }
                }

                switch (index) {
                    case 0 -> {
                        shooter.teleportTo(target.getX(), target.getY(), target.getZ());
                        level.playSound(null,
                                shot.getX(),
                                shot.getY(),
                                shot.getZ(),
                                SoundEvents.CHORUS_FRUIT_TELEPORT,
                                SoundSource.PLAYERS,
                                1.0f,
                                level.getRandom().nextFloat() * 0.4f + 0.8f);
                    }
                    case 1 -> {
                        target.teleportTo(shooter.getX(), shooter.getY(), shooter.getZ());
                        level.playSound(null,
                                shot.getX(),
                                shot.getY(),
                                shot.getZ(),
                                SoundEvents.CHORUS_FRUIT_TELEPORT,
                                SoundSource.PLAYERS,
                                1.0f,
                                level.getRandom().nextFloat() * 0.4f + 0.8f);
                    }
                    case 2 -> {
                        level.explode(
                                null,
                                shooter.getX(),
                                shooter.getY(),
                                shooter.getZ(),
                                (float) spellLevel,
                                false,
                                Level.ExplosionInteraction.NONE
                        );
                        level.playSound(null,
                                shooter.getX(),
                                shooter.getY(),
                                shooter.getZ(),
                                SoundEvents.GENERIC_EXPLODE,
                                SoundSource.PLAYERS,
                                1.0f,
                                level.getRandom().nextFloat() * 0.4f + 0.8f);
                    }
                    case 3 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20 * spellLevel, 2 * spellLevel));
                        }
                        if (target instanceof LivingEntity livingTarget) {
                            livingTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20 * spellLevel, 2 * spellLevel));
                        }
                    }
                    case 4 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 80 * spellLevel, 100 * spellLevel));
                        }
                    }
                    case 5 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 200 * spellLevel, 2 * spellLevel));
                        }
                    }
                    case 6 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 400 * spellLevel));
                        }
                    }
                    case 7 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100 * spellLevel));
                        }
                        if (target instanceof LivingEntity livingTarget) {
                            livingTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100 * spellLevel));
                        }
                    }
                    case 8 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100 * spellLevel, spellLevel));
                        }
                    }
                    case 9 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100 * spellLevel, spellLevel));
                        }
                    }
                    case 10 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100 * spellLevel, spellLevel));
                        }
                    }
                    case 11 -> {
                        level.setBlock(BlockPos.containing(new Vec3(target.getX(), target.getY(), target.getZ())), Blocks.CAKE.defaultBlockState(), 3);
                        if (!(target instanceof Player)) {
                            target.kill();
                        }
                    }
                    case 12 -> {
                        ResourceLocation id = ResourceLocation.bySeparator(target.getType().getDescriptionId(), '.');
                        String[] splitID = id.getPath().split("\\.");
                        String namespace = splitID[0];
                        String entity = splitID[1];
                        Item spawnEgg = BuiltInRegistries.ITEM.getOptional(ResourceLocation.fromNamespaceAndPath(
                                namespace,
                                entity + "_spawn_egg")
                        ).orElse(null);
                        if (spawnEgg != null) {
                            ItemStack spawnEggItem = new ItemStack(spawnEgg);
                            BlockPos pos = target.blockPosition();

                            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), spawnEggItem));
                        }
                    }
                    case 13 -> {
                        Entity clone = target.getType().create(level);
                        if (clone != null) {
                            clone.moveTo(target.getX(), target.getY(), target.getZ(), target.getYRot(), target.getXRot());
                            clone.setDeltaMovement(target.getDeltaMovement());
                            if (clone instanceof LivingEntity livingClone && target instanceof LivingEntity livingTarget) {
                                livingClone.setHealth(livingTarget.getHealth());
                                for (MobEffectInstance effect : livingTarget.getActiveEffects()) {
                                    livingClone.addEffect(effect);
                                }
                                level.addFreshEntity(livingClone);
                            }
                        }
                    }
                    case 14 -> {
                        if (shooter instanceof Player player) {
                            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10 * spellLevel));
                        }
                    }
                    case 15 -> {
                        level.explode(
                                null,
                                target.getX(),
                                target.getY(),
                                target.getZ(),
                                (float) spellLevel,
                                false,
                                Level.ExplosionInteraction.NONE
                        );
                        level.playSound(null,
                                target.getX(),
                                target.getY(),
                                target.getZ(),
                                SoundEvents.GENERIC_EXPLODE,
                                SoundSource.PLAYERS,
                                1.0f,
                                level.getRandom().nextFloat() * 0.4f + 0.8f);
                    }
                }
            }
        }
    }
}
