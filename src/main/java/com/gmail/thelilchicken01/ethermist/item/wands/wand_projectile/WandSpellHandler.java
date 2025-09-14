package com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile;

import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantComponents;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_type_effects.EMWandTypeEffects;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_type_effects.IWandTypeEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class WandSpellHandler {

    public static void processWandModifiers(WandShotItem shotItem, Entity target, Player player, ItemStack wand) {

        if (wand.getItem() instanceof WandItem wandItem) {
            IWandTypeEffect effect = EMWandTypeEffects.getTypeEffect(wandItem.getType());
            if (effect != null) {
                effect.apply(shotItem, target, player, wand);
            }
        }

    }

    public static void processSpells(Level level, Entity shooter, @Nullable Entity target, @Nullable BlockPos hitPos, WandProjectile shot) {

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

                    for (int iterations = 0; iterations < shot.spellLevel; iterations++) {

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
                                            (float) shot.spellLevel,
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
                                        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20 * shot.spellLevel, 2 * shot.spellLevel));
                                    }
                                    if (target instanceof LivingEntity livingTarget) {
                                        livingTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20 * shot.spellLevel, 2 * shot.spellLevel));
                                    }
                                }
                                case 4 -> {
                                    if (shooter instanceof Player player) {
                                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 80 * shot.spellLevel, 100 * shot.spellLevel));
                                    }
                                }
                                case 5 -> {
                                    if (shooter instanceof Player player) {
                                        player.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 200 * shot.spellLevel, 2 * shot.spellLevel));
                                    }
                                }
                                case 6 -> {
                                    if (shooter instanceof Player player) {
                                        player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 400 * shot.spellLevel));
                                    }
                                }
                                case 7 -> {
                                    if (shooter instanceof Player player) {
                                        player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100 * shot.spellLevel));
                                    }
                                    if (target instanceof LivingEntity livingTarget) {
                                        livingTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100 * shot.spellLevel));
                                    }
                                }
                                case 8 -> {
                                    if (shooter instanceof Player player) {
                                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100 * shot.spellLevel, shot.spellLevel));
                                    }
                                }
                                case 9 -> {
                                    if (shooter instanceof Player player) {
                                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100 * shot.spellLevel, shot.spellLevel));
                                    }
                                }
                                case 10 -> {
                                    if (shooter instanceof Player player) {
                                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100 * shot.spellLevel, shot.spellLevel));
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
                                        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10 * shot.spellLevel));
                                    }
                                }
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
                case THUNDERSTRIKE -> {
                    for (int x = 0; x < shot.spellLevel; x++) {
                        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
                        if (bolt != null) {
                            bolt.moveTo(shot.getX(), shot.getY(), shot.getZ());
                            level.addFreshEntity(bolt);
                        }
                    }
                }
                case SEISMIC_SURGE -> {
                    if (target == null && hitPos != null) {
                        Block block = level.getBlockState(hitPos).getBlock();
                        float playerBreakSpeed = (float)((Math.pow(shot.damage + shot.spellLevel, 2)) / 18);
                        if (block.defaultDestroyTime() <= playerBreakSpeed && block.defaultDestroyTime() > 0.0f) {
                            level.destroyBlock(hitPos, true, shooter);
                            shot.remove(Entity.RemovalReason.KILLED);
                        }
                        else {
                            shot.remove(Entity.RemovalReason.KILLED);
                        }
                    } else {
                        if (target instanceof LivingEntity livingTarget) {
                            livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, shot.spellLevel * 40, shot.spellLevel));
                        }
                    }
                }
            }
        }

    }

    public static void processSpellTick(WandProjectile shot, int tick, List<? extends Entity> target) {

        EnchantmentHelper.runIterationOnItem(shot.originWandStack, (enchant, level) -> {

            IWandSpellEffect spell = enchant.value().effects().get(EMEnchantComponents.WAND_SPELL_EFFECT.get());

            if (spell != null) {
                spell.onTick(shot, tick, target, level);
            }

        });

    }

    /*
    ---------- Helper Methods ----------
     */

    public static void drawLine(Vec3 start, Vec3 end, ServerLevel level) {
        int num = 24;
        Vec3 step = end.subtract(start).scale(1.0 / num);
        for (int x = 0; x <= num; x++) {
            Vec3 pos = start.add(step.scale(x));
            level.sendParticles(EMParticleTypes.VOLATILE_ENERGY_TETHER.get(), pos.x, pos.y, pos.z, 1, 0, 0, 0, 0);
        }
    }

}
