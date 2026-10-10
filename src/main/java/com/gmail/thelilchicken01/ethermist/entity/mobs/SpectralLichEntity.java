package com.gmail.thelilchicken01.ethermist.entity.mobs;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("FieldCanBeLocal")
public class SpectralLichEntity extends Monster {

    public final AnimationState idleState = new AnimationState();
    public final AnimationState pursueState = new AnimationState();
    public final AnimationState walkState = new AnimationState();

    public SpectralLichEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.005, false));
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
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
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
    protected int getBaseExperienceReward() {
        return 20;
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
}
