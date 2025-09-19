package com.gmail.thelilchicken01.ethermist.entity.mobs;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.List;

public class PylonEntity extends Monster {

    public final AnimationState idleState = new AnimationState();

    private static final EntityDataAccessor<Integer> LIFESPAN_SECONDS =
            SynchedEntityData.defineId(PylonEntity.class, EntityDataSerializers.INT);
    private int lifespanCounter = 0;

    public PylonEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.01)
                .add(Attributes.ATTACK_DAMAGE, 1)
                .add(Attributes.FOLLOW_RANGE, 0);
    }

    public void setLifespanSeconds(int seconds) {
        this.entityData.set(LIFESPAN_SECONDS, Math.max(1, seconds));
    }

    public int getLifespanSeconds() {
        return this.entityData.get(LIFESPAN_SECONDS);
    }

    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
        this.addEffect(new MobEffectInstance(MobEffects.GLOWING, (getLifespanSeconds() + 1) * 20, 0, false, false));
    }

    @Override
    public void tick() {
        super.tick();

        lifespanCounter++;

        if (!this.level().isClientSide() && lifespanCounter > (getLifespanSeconds() + 1) * 20) {
            this.remove(RemovalReason.KILLED);
        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public int getTeamColor() {
        int total = Math.max(1, getLifespanSeconds() * 20);
        float t = Mth.clamp((float) this.lifespanCounter / (float) total, 0.0F, 1.0F);

        int r = (int)(255 * t);
        int g = (int)(255 * (1.0F - t));
        int b = 0;

        return (r << 16) | (g << 8) | b;
    }

    @Override
    public void baseTick() {
        super.baseTick();

        this.setAirSupply(300);
    }

    @Override
    public boolean isPushedByFluid(FluidType type) {
        return false;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 0.15f, 0.5f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BEACON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.GLASS_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.GLASS_BREAK;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0f;
    }

    private void setupAnimationStates() {
        if (!this.idleState.isStarted()) {
            this.idleState.start(this.tickCount);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("lifespan", getLifespanSeconds());
        tag.putInt("lifespan_remaining", this.lifespanCounter);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setLifespanSeconds(tag.getInt("lifespan"));
        this.lifespanCounter = tag.getInt("lifespan_remaining");
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LIFESPAN_SECONDS, 60);
    }

}
