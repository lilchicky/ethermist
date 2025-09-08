package com.gmail.thelilchicken01.ethermist.item.wands.wand_type_effects;

import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugEntity;
import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import com.gmail.thelilchicken01.ethermist.item.wands.*;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.IWandTiers;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.EMWandTiers;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.HashMap;
import java.util.Map;

public class EMWandTypeEffects {

    private static final Map<IWandTypes, IWandTypeEffect> TYPE_EFFECTS = new HashMap<>();

    public static void addTypeEffect(IWandTypes type, IWandTypeEffect effect) {
        if (TYPE_EFFECTS.containsKey(type)) {
            throw new IllegalStateException("Duplicate registration for wand type: " + type);
        }
        TYPE_EFFECTS.put(type, effect);
    }

    public static IWandTypeEffect getTypeEffect(IWandTypes type) {
        return TYPE_EFFECTS.get(type);
    }

    public static void registerTypeEffects() {

        addTypeEffect(WandTypes.FLAME, (shotItem, target, player, wand) -> {
            IWandTiers tier = wand.getItem() instanceof WandItem wandItem ? wandItem.getTier() : EMWandTiers.WOODEN.get();
            target.setRemainingFireTicks(tier.doesBuffSpell() ? 400 : 200);
        });

        addTypeEffect(WandTypes.POISON, (shotItem, target, player, wand) -> {
            IWandTiers tier = wand.getItem() instanceof WandItem wandItem ? wandItem.getTier() : EMWandTiers.WOODEN.get();
            if (target instanceof LivingEntity livingTarget) {
                livingTarget.addEffect(new MobEffectInstance(MobEffects.POISON, tier.doesBuffSpell() ? 200 : 100, 2));
            }
        });

        addTypeEffect(WandTypes.WITHER, (shotItem, target, player, wand) -> {
            IWandTiers tier = wand.getItem() instanceof WandItem wandItem ? wandItem.getTier() : EMWandTiers.WOODEN.get();
            if (target instanceof LivingEntity livingTarget) {
                livingTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, tier.doesBuffSpell() ? 200 : 100, 1));
            }
        });

        addTypeEffect(WandTypes.LEVITATION, (shotItem, target, player, wand) -> {
            IWandTiers tier = wand.getItem() instanceof WandItem wandItem ? wandItem.getTier() : EMWandTiers.WOODEN.get();
            if (target instanceof LivingEntity livingTarget) {
                livingTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, tier.doesBuffSpell() ? 150 : 100));
            }
        });

        addTypeEffect(WandTypes.WITCH, (shotItem, target, player, wand) -> {
            IWandTiers tier = wand.getItem() instanceof WandItem wandItem ? wandItem.getTier() : EMWandTiers.WOODEN.get();
            RandomSource random = player.getRandom();

            switch (random.nextInt(3)) {
                case 0 ->
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, tier.doesBuffSpell() ? 80 : 40, tier.doesBuffSpell() ? 1 : 0));
                case 1 ->
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, tier.doesBuffSpell() ? 200 : 100));
                case 2 ->
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, tier.doesBuffSpell() ? 120 : 60, tier.doesBuffSpell() ? 1 : 0));
            }

            if (target instanceof LivingEntity livingTarget) {
                switch (random.nextInt(3)) {
                    case 0 ->
                            livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, tier.doesBuffSpell() ? 120 : 60, tier.doesBuffSpell() ? 1 : 0));
                    case 1 ->
                            livingTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, tier.doesBuffSpell() ? 160 : 80));
                    case 2 ->
                            livingTarget.addEffect(new MobEffectInstance(MobEffects.POISON, tier.doesBuffSpell() ? 160 : 80));
                }
            }

            if (player.isInWater() && random.nextBoolean()) {
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, tier.doesBuffSpell() ? 400 : 100));
            }
        });

        addTypeEffect(WandTypes.FROZEN, (shotItem, target, player, wand) -> {
            IWandTiers tier = wand.getItem() instanceof WandItem wandItem ? wandItem.getTier() : EMWandTiers.WOODEN.get();
            if (target instanceof LivingEntity livingTarget) {
                livingTarget.setTicksFrozen(livingTarget.getTicksFrozen() + (tier.doesBuffSpell() ? 120 : 60));
            }
        });

        addTypeEffect(WandTypes.GLIMMERBUG, (shotItem, target, player, wand) -> {
            IWandTiers tier = wand.getItem() instanceof WandItem wandItem ? wandItem.getTier() : EMWandTiers.WOODEN.get();

            if (!player.level().isClientSide()) {
                GlimmerbugEntity bug = new GlimmerbugEntity(EMEntityTypes.GLIMMERBUG.get(), player.level());

                bug.setPos(player.getX(), player.getY(), player.getZ());
                bug.setHasLifespan(true);
                bug.setSummoned(true);
                bug.setOwnerUUID(player.getUUID());
                bug.tame(player);
                bug.setLifespanSeconds(
                        Math.max(
                                WandUtil.getAttribute(player, EMAttributes.COOLDOWN, WandItem.COOLDOWN_ID) * 4,
                                3
                        )
                );

                if (tier.doesBuffSpell()) {
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
        });

    }

}
