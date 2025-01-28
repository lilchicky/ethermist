package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

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

import javax.annotation.Nullable;
import java.util.Random;

public class WandSpellHandler {

    public static void processWandModifiers(WandShotItem shotItem, LivingEntity target, Player player) {

        switch (shotItem.getModifier()) {
            case FLAME_WAND -> {
                target.setRemainingFireTicks(200);
            }
            case LEVITATION_WAND -> {
                target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
            }
            default -> {
            }
        }

    }

    public static void processSpells(Level level, @Nullable Player player, @Nullable LivingEntity target, @Nullable Vec3 hitPos, WandProjectile shot) {

        if (!level.isClientSide()) {

            switch (shot.spellType) {
                case FIREBALL -> {
                    level.explode(
                            null,
                            shot.getX(),
                            shot.getY(),
                            shot.getZ(),
                            (float) shot.spellLevel,
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
                case CHAOS_MAGIC -> {

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
                            legendary, // Instakill
                            legendary, // Spawn Egg
                            legendary, // Duplicate Mob
                            uncommon, // Saturation
                            ultra, // Explode @ Target
                    };

                    int totalEntityWeight = 0;
                    for (int w : entityWeights) {
                        totalEntityWeight += w;
                    }

                    for (int iterations = 0; iterations < shot.spellLevel; iterations++) {

                        Random random = new Random();
                        int entityChoice = random.nextInt(totalEntityWeight);

                        if (player != null && target != null) {

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
                                    player.teleportTo(target.getX(), target.getY(), target.getZ());
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
                                    target.teleportTo(player.getX(), player.getY(), player.getZ());
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
                                            player.getX(),
                                            player.getY(),
                                            player.getZ(),
                                            (float) shot.spellLevel,
                                            false,
                                            Level.ExplosionInteraction.NONE
                                    );
                                    level.playSound(null,
                                            player.getX(),
                                            player.getY(),
                                            player.getZ(),
                                            SoundEvents.GENERIC_EXPLODE,
                                            SoundSource.PLAYERS,
                                            1.0f,
                                            level.getRandom().nextFloat() * 0.4f + 0.8f);
                                }
                                case 3 -> {
                                        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20 * shot.spellLevel, 2 * shot.spellLevel));
                                        target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20 * shot.spellLevel, 2 * shot.spellLevel));
                                }
                                case 4 ->
                                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 80 * shot.spellLevel, 100 * shot.spellLevel));
                                case 5 ->
                                        player.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 200 * shot.spellLevel, 2 * shot.spellLevel));
                                case 6 ->
                                        player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 400 * shot.spellLevel));
                                case 7 -> {
                                        player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100 * shot.spellLevel));
                                        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100 * shot.spellLevel));
                                }
                                case 8 ->
                                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100 * shot.spellLevel, shot.spellLevel));
                                case 9 ->
                                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100 * shot.spellLevel, shot.spellLevel));
                                case 10 ->
                                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100 * shot.spellLevel, shot.spellLevel));
                                case 11 -> {
                                    level.setBlock(BlockPos.containing(new Vec3(target.getX(), target.getY(), target.getZ())), Blocks.CAKE.defaultBlockState(), 3);
                                    target.remove(Entity.RemovalReason.KILLED);
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
                                        if (clone instanceof LivingEntity livingClone) {
                                            livingClone.setHealth(target.getHealth());
                                            for (MobEffectInstance effect : target.getActiveEffects()) {
                                                livingClone.addEffect(effect);
                                            }
                                            level.addFreshEntity(livingClone);
                                        }
                                    }
                                }
                                case 14 -> player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10 * shot.spellLevel));
                                case 15 -> {
                                    level.explode(
                                            null,
                                            target.getX(),
                                            target.getY(),
                                            target.getZ(),
                                            (float) shot.spellLevel,
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
                default -> {
                }
            }
        }

    }

}
