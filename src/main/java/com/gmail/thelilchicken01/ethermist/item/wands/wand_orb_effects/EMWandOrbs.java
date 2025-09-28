package com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects;

import com.gmail.thelilchicken01.ethermist.effect.EMEffects;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.gmail.thelilchicken01.ethermist.util.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.util.EMRegistries;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugEntity;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMWandOrbs {

    public static final DeferredRegister<WandOrb> EM_WAND_ORBS =
            DeferredRegister.create(EMRegistries.WAND_ORBS.getRegistryName(), Ethermist.MODID);

    public static final DeferredHolder<WandOrb, WandOrb> DULL =
            EM_WAND_ORBS.register("dull", () ->
                    new WandOrb.Builder()
                            .durabilityMult(1.0)
                            .enchantability(7)
                            .lifespanSeconds(1)
                            .damage(4)
                            .inaccuracy(15.0f)
                            .projectileSpeed(0.25f)
                            .canIgnite(false)
                            .knockback(0.25)
                            .cooldown(80)
                            .shot(EMItems.GENERIC_SHOT.get())
                            .damageType(EMDamageTypes.GENERIC_MAGIC)
                            .color(0.50196f, 0.38431f, 0.64314f)
                            .repair(() ->
                                    Ingredient.of(Items.AMETHYST_SHARD)
                            )
                            .sound(SoundEvents.EVOKER_CAST_SPELL)
                            .effect((shotItem, target, player, shot) -> {})
                            .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> FLAME =
            EM_WAND_ORBS.register("flame", () ->
                    new WandOrb.Builder()
                            .durabilityMult(1.9)
                            .enchantability(10)
                            .lifespanSeconds(1)
                            .damage(6)
                            .inaccuracy(7.5f)
                            .projectileSpeed(0.2f)
                            .canIgnite(true)
                            .knockback(0.25)
                            .cooldown(80)
                            .shot(EMItems.FLAME_SHOT.get())
                            .damageType(EMDamageTypes.FLAME_MAGIC)
                            .color(1.0f, 0.1f, 0.1f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD,
                                            Items.BLAZE_POWDER
                                    )
                            )
                            .sound(SoundEvents.BLAZE_SHOOT)
                            .effect((shotItem, target, player, shot) -> {
                                target.setRemainingFireTicks(shot.getOriginWandTier().doesBuffSpell() ? 400 : 200);
                            })
                            .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> POISON =
            EM_WAND_ORBS.register("poison", () ->
                    new WandOrb.Builder()
                            .durabilityMult(1.7)
                            .enchantability(11)
                            .lifespanSeconds(2)
                            .damage(5)
                            .inaccuracy(9.5f)
                            .projectileSpeed(0.35f)
                            .canIgnite(false)
                            .knockback(0.25)
                            .cooldown(80)
                            .shot(EMItems.POISON_SHOT.get())
                            .damageType(EMDamageTypes.POISON_MAGIC)
                            .color(0.396f, 0.455f, 0.196f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD,
                                            Items.SPIDER_EYE
                                    )
                            )
                            .sound(SoundEvents.SPIDER_HURT)
                            .effect((shotItem, target, player, shot) -> {
                                if (target instanceof LivingEntity livingTarget) {
                                    livingTarget.addEffect(new MobEffectInstance(MobEffects.POISON, shot.getOriginWandTier().doesBuffSpell() ? 200 : 100, 2));
                                }
                            })
                            .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> LEVITATION =
            EM_WAND_ORBS.register("levitation", () ->
                    new WandOrb.Builder()
                            .durabilityMult(4.2)
                            .enchantability(25)
                            .lifespanSeconds(3)
                            .damage(11)
                            .inaccuracy(0.5f)
                            .projectileSpeed(0.2f)
                            .canIgnite(false)
                            .knockback(0.15)
                            .cooldown(30)
                            .shot(EMItems.LEVITATION_SHOT.get())
                            .damageType(EMDamageTypes.LEVITATION_MAGIC)
                            .color(0.95f, 0.95f, 0.95f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD,
                                            Items.PHANTOM_MEMBRANE
                                    )
                            )
                            .sound(SoundEvents.SHULKER_SHOOT)
                            .effect((shotItem, target, player, shot) -> {
                                if (target instanceof LivingEntity livingTarget) {
                                    livingTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, shot.getOriginWandTier().doesBuffSpell() ? 150 : 100));
                                }
                            })
                            .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> WITHER =
            EM_WAND_ORBS.register("wither", () ->
                    new WandOrb.Builder()
                            .durabilityMult(2.7)
                            .enchantability(20)
                            .lifespanSeconds(1)
                            .damage(8)
                            .inaccuracy(8.5f)
                            .projectileSpeed(0.3f)
                            .canIgnite(false)
                            .knockback(0.25)
                            .cooldown(100)
                            .shot(EMItems.WITHER_SHOT.get())
                            .damageType(EMDamageTypes.WITHER_MAGIC)
                            .color(0.1f, 0.1f, 0.1f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD,
                                            Items.COAL
                                    )
                            )
                            .sound(SoundEvents.WITHER_SHOOT)
                            .effect((shotItem, target, player, shot) -> {
                                if (target instanceof LivingEntity livingTarget) {
                                    livingTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, shot.getOriginWandTier().doesBuffSpell() ? 200 : 100, 1));
                                }
                            })
                            .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> WITCH =
            EM_WAND_ORBS.register("witch", () ->
                    new WandOrb.Builder()
                            .durabilityMult(1.4)
                            .enchantability(16)
                            .lifespanSeconds(3)
                            .damage(5)
                            .inaccuracy(12.0f)
                            .projectileSpeed(0.3f)
                            .canIgnite(false)
                            .knockback(0.25)
                            .cooldown(80)
                            .shot(EMItems.WITCH_SHOT.get())
                            .damageType(EMDamageTypes.WITCH_MAGIC)
                            .color(0.247f, 0.145f, 0.216f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD,
                                            Items.SUGAR,
                                            Items.GLASS_BOTTLE,
                                            Items.REDSTONE,
                                            Items.GLOWSTONE_DUST
                                    )
                            )
                            .sound(SoundEvents.WITCH_THROW)
                            .effect((shotItem, target, shooter, shot) -> {
                                if (shooter instanceof Player player) {
                                    RandomSource random = player.getRandom();

                                    switch (random.nextInt(3)) {
                                        case 0 ->
                                                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, shot.getOriginWandTier().doesBuffSpell() ? 80 : 40, shot.getOriginWandTier().doesBuffSpell() ? 1 : 0));
                                        case 1 ->
                                                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, shot.getOriginWandTier().doesBuffSpell() ? 200 : 100));
                                        case 2 ->
                                                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, shot.getOriginWandTier().doesBuffSpell() ? 120 : 60, shot.getOriginWandTier().doesBuffSpell() ? 1 : 0));
                                    }

                                    if (target instanceof LivingEntity livingTarget) {
                                        switch (random.nextInt(3)) {
                                            case 0 ->
                                                    livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, shot.getOriginWandTier().doesBuffSpell() ? 120 : 60, shot.getOriginWandTier().doesBuffSpell() ? 1 : 0));
                                            case 1 ->
                                                    livingTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, shot.getOriginWandTier().doesBuffSpell() ? 160 : 80));
                                            case 2 ->
                                                    livingTarget.addEffect(new MobEffectInstance(MobEffects.POISON, shot.getOriginWandTier().doesBuffSpell() ? 160 : 80));
                                        }
                                    }

                                    if (player.isInWater() && random.nextBoolean()) {
                                        player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, shot.getOriginWandTier().doesBuffSpell() ? 400 : 100));
                                    }
                                }
                            })
                            .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> HEAVY =
            EM_WAND_ORBS.register("heavy", () ->
                    new WandOrb.Builder()
                            .durabilityMult(3.0)
                            .enchantability(15)
                            .lifespanSeconds(1)
                            .damage(4)
                            .inaccuracy(15.0f)
                            .projectileSpeed(0.15f)
                            .canIgnite(false)
                            .knockback(0.55)
                            .cooldown(100)
                            .shot(EMItems.HEAVY_SHOT.get())
                            .damageType(EMDamageTypes.HEAVY_MAGIC)
                            .color(0.5f, 0.5f, 0.5f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD,
                                            Items.BREEZE_ROD
                                    )
                            )
                            .sound(SoundEvents.WITHER_SHOOT)
                            .effect((shotItem, target, player, shot) -> {})
                            .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> FROZEN =
            EM_WAND_ORBS.register("frozen", () ->
                            new WandOrb.Builder()
                                    .durabilityMult(1.3)
                                    .enchantability(15)
                                    .lifespanSeconds(1)
                                    .damage(6)
                                    .inaccuracy(9.0f)
                                    .projectileSpeed(0.35f)
                                    .canIgnite(false)
                                    .knockback(0.2)
                                    .cooldown(90)
                                    .shot(EMItems.FROZEN_SHOT.get())
                                    .damageType(EMDamageTypes.FROZEN_MAGIC)
                                    .color(0.678f, 0.847f, 0.902f)
                                    .repair(() ->
                                            Ingredient.of(
                                                    Items.AMETHYST_SHARD,
                                                    Items.ICE,
                                                    EMBlocks.ICICLE
                                            )
                                    )
                                    .sound(SoundEvents.GLASS_BREAK)
                                    .effect((shotItem, target, player, shot) -> {
                                        if (target instanceof LivingEntity livingTarget) {
                                            livingTarget.setTicksFrozen(livingTarget.getTicksFrozen() + (shot.getOriginWandTier().doesBuffSpell() ? 120 : 60));
                                        }
                                    })
                                    .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> GLASS =
            EM_WAND_ORBS.register("glass", () ->
                    new WandOrb.Builder()
                            .durabilityMult(0.03)
                            .enchantability(20)
                            .lifespanSeconds(0.5)
                            .damage(16)
                            .inaccuracy(5.0f)
                            .projectileSpeed(0.05f)
                            .canIgnite(false)
                            .knockback(-0.25)
                            .cooldown(80)
                            .shot(EMItems.GLASS_SHOT.get())
                            .damageType(EMDamageTypes.GLASS_MAGIC)
                            .color(0.482f, 0.682f, 0.718f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD,
                                            Items.GLASS
                                    )
                            )
                            .sound(SoundEvents.EVOKER_CAST_SPELL)
                            .effect((shotItem, target, player, shot) -> {})
                            .build()
            );

    public static final DeferredHolder<WandOrb, WandOrb> GLIMMERBUG =
            EM_WAND_ORBS.register("glimmerbug", () ->
                    new WandOrb.Builder()
                            .durabilityMult(8.4)
                            .enchantability(15)
                            .lifespanSeconds(1.5)
                            .damage(6)
                            .inaccuracy(12.0f)
                            .projectileSpeed(0.1f)
                            .canIgnite(false)
                            .knockback(0.25)
                            .cooldown(100)
                            .shot(EMItems.GLIMMERBUG_SHOT.get())
                            .damageType(EMDamageTypes.GLIMMERBUG_MAGIC)
                            .color(0.784f, 0.353f, 0.196f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD
                                    )
                            )
                            .sound(SoundEvents.TURTLE_EGG_BREAK)
                            .effect((shotItem, target, shooter, shot) -> {
                                if (!shooter.level().isClientSide() && shooter instanceof Player player) {
                                    GlimmerbugEntity bug = new GlimmerbugEntity(EMEntityTypes.GLIMMERBUG.get(), player.level());

                                    bug.setPos(player.getX(), player.getY(), player.getZ());
                                    bug.setHasLifespan(true);
                                    bug.setSummoned(true);
                                    bug.setOwnerUUID(player.getUUID());
                                    bug.tame(player);
                                    bug.setLifespanSeconds(
                                            Math.max(
                                                    WandUtil.getAttribute(player, EMAttributes.COOLDOWN) * 4,
                                                    3
                                            )
                                    );

                                    if (shot.getOriginWandTier().doesBuffSpell()) {
                                        bug.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) (bug.getLifespanSeconds() * 20)));
                                        bug.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) (bug.getLifespanSeconds() * 20)));
                                        bug.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) (bug.getLifespanSeconds() * 20)));
                                    }

                                    bug.finalizeSpawn(
                                            (ServerLevelAccessor) player.level(),
                                            player.level().getCurrentDifficultyAt(player.blockPosition()),
                                            MobSpawnType.MOB_SUMMONED,
                                            null
                                    );

                                    player.level().addFreshEntity(bug);
                                }
                            })
                            .build()
            );

    /*
                    Mob Shot Effects
     */

    public static final DeferredHolder<WandOrb, WandOrb> FORGEMASTER =
            EM_WAND_ORBS.register("forgemaster", () ->
                    new WandOrb.Builder()
                            .durabilityMult(1)
                            .enchantability(1)
                            .lifespanSeconds(1)
                            .damage(1)
                            .inaccuracy(1)
                            .projectileSpeed(1)
                            .canIgnite(false)
                            .knockback(1)
                            .cooldown(1)
                            .shot(EMItems.FORGEMASTER_SHOT.get())
                            .damageType(EMDamageTypes.FORGEMASTER_SHOT)
                            .color(1f, 1f, 1f)
                            .repair(() ->
                                    Ingredient.of(
                                            Items.AMETHYST_SHARD
                                    )
                            )
                            .sound(SoundEvents.BLAZE_SHOOT)
                            .effect((shotItem, target, player, shot) -> {
                                if (target instanceof LivingEntity livingTarget) {
                                    livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0));
                                    livingTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0));
                                    livingTarget.addEffect(new MobEffectInstance(EMEffects.SLOWER_CASTING, 40, 1));
                                }
                            })
                            .build()
            );

    public static void register (IEventBus bus) {
        EM_WAND_ORBS.register(bus);
    }

}
