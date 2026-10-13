package com.gmail.thelilchicken01.ethermist.entity.mobs;

import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectileHandler;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("FieldCanBeLocal")
public class SpectralLichEntity extends Monster implements RangedAttackMob {

    public final AnimationState idleState = new AnimationState();
    public final AnimationState pursueState = new AnimationState();
    public final AnimationState walkState = new AnimationState();

    private final WandAttackGoal<SpectralLichEntity> wandGoal = new WandAttackGoal<>(this, 1.0F, 15.0f, 0.5f);
    private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2, false) {
        public void stop() {
            super.stop();
            SpectralLichEntity.this.setAggressive(false);
        }

        public void start() {
            super.start();
            SpectralLichEntity.this.setAggressive(true);
        }
    };

    public SpectralLichEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.reassessWeaponGoal();
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.00f));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 24.0f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ARMOR, 2)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.MOVEMENT_SPEED, 0.23)
                .add(Attributes.FOLLOW_RANGE, 24);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        ItemStack wandStack = this.getMainHandItem();

        if (wandStack.getItem() instanceof WandItem wand &&
                WandProjectileHandler.processShot(this.level(), this, wandStack, wand, null, null))
        {
            this.level().playSound(null,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    wand.getOrb().getShootSound(),
                    SoundSource.HOSTILE,
                    1.0f,
                    random.nextFloat() * 0.4f + 0.8f);
        }
    }

    @Override
    protected int getBaseExperienceReward() {
        return 15;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 0.15f, 0.5f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.WITHER_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_HURT;
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);

        Optional<HolderSet.Named<Item>> holdable = BuiltInRegistries.ITEM.getTag(EMTags.Items.SPECTRAL_LICH_CAN_SPAWN_WITH);

        holdable.flatMap(holders -> holders.getRandomElement(random)).ifPresent(item ->
                setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(item.value())));
    }

    @Override
    protected void populateDefaultEquipmentEnchantments(ServerLevelAccessor level, RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentEnchantments(level, random, difficulty);

        var enchantHolders = level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EMTags.Enchantments.SPECTRAL_LICH_WAND_CAN_HAVE);
        ItemStack handItem = getItemBySlot(EquipmentSlot.MAINHAND);

        if (handItem.isEmpty() || enchantHolders.isEmpty()) return;

        int numEnchants = 2 + random.nextInt(1 + Mth.floor(difficulty.getSpecialMultiplier() * 2));
        List<Holder<Enchantment>> enchants = new ArrayList<>(enchantHolders.get().stream().toList());

        if (enchants.isEmpty()) return;

        for (int i = 0; i < numEnchants; i++) {
            Holder<Enchantment> next = enchants.remove(random.nextInt(enchants.size()));

            if (!next.value().definition().supportedItems().contains(handItem.getItemHolder())) continue;

            boolean compatible = EnchantmentHelper.getEnchantmentsForCrafting(handItem)
                    .keySet()
                    .stream()
                    .allMatch(existing -> Enchantment.areCompatible(existing, next));

            if (!compatible) continue;

            int levelToApply = random.nextInt(next.value().getMaxLevel());

            if (levelToApply > 0) {
                handItem.enchant(next, levelToApply);
            }
        }
    }

    public void reassessWeaponGoal() {
        if (!this.level().isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.removeGoal(this.wandGoal);

            ItemStack held = this.getMainHandItem();

            if (held.getItem() instanceof WandItem) {
                this.goalSelector.addGoal(1, this.wandGoal);
            }
            else {
                this.goalSelector.addGoal(1, this.meleeGoal);
            }
        }
    }

    @Override
    public boolean canPickUpLoot() {
        return true;
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        this.populateDefaultEquipmentSlots(random, difficulty);
        this.populateDefaultEquipmentEnchantments(level, random, difficulty);
        this.reassessWeaponGoal();

        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    private void setupAnimationStates() {

        boolean isMoving = this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6;

        if (this.isAggressive() && isMoving) {
            walkState.stop();
            idleState.stop();
            pursueState.startIfStopped(this.tickCount);
        } else if (isMoving) {
            pursueState.stop();
            idleState.stop();
            walkState.startIfStopped(this.tickCount);
        } else {
            pursueState.stop();
            walkState.stop();
            idleState.startIfStopped(this.tickCount);
        }
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.reassessWeaponGoal();
    }

    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {
        super.setItemSlot(slot, stack);
        if (!this.level().isClientSide) {
            this.reassessWeaponGoal();
        }
    }

    public static class WandAttackGoal<T extends Mob & RangedAttackMob> extends Goal {
        private final T mob;
        private final double speed;
        private final float rangeSqr;
        private int cooldownTicks;
        private int cooldown;
        private final float cooldownModifier;

        public WandAttackGoal(T mob, double speed, float range, float cooldownModifier) {
            this.mob = mob;
            this.speed = speed;
            this.rangeSqr = range * range;
            this.cooldownModifier = cooldownModifier;
            refreshCooldown();
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        private void refreshCooldown() {
            this.cooldownTicks = Math.max((int)((WandUtil.getAttribute(mob, EMAttributes.COOLDOWN) * 20) * this.cooldownModifier), 5);
        }

        @Override
        public boolean canUse() {
            return mob.getTarget() != null && mob.getMainHandItem().getItem() instanceof WandItem;
        }

        @Override
        public boolean canContinueToUse() {
            return canUse();
        }

        @Override
        public void start() {
            cooldown = cooldownTicks;
        }

        @Override
        public void tick() {
            refreshCooldown();
            LivingEntity target = mob.getTarget();
            if (target == null) return;

            mob.getLookControl().setLookAt(target, 30.0F, 30.0F);

            double distanceSqr = mob.distanceToSqr(target);
            if (distanceSqr > rangeSqr || !mob.getSensing().hasLineOfSight(target)) {
                mob.getNavigation().moveTo(target, speed);
                return;
            }

            mob.getNavigation().stop();

            if (cooldown > 0) {
                cooldown--;
                return;
            }

            mob.performRangedAttack(target, 1.0F);
            cooldown = cooldownTicks;
        }
    }

}
