package com.gmail.thelilchicken01.ethermist.entity.mobs;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class GlimmerbugEntity extends TamableAnimal {

    private static final EntityDataAccessor<Boolean> SUMMONED = SynchedEntityData.defineId(GlimmerbugEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_LIFESPAN = SynchedEntityData.defineId(GlimmerbugEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Optional<UUID>> OWNER_UUID = SynchedEntityData.defineId(GlimmerbugEntity.class, EntityDataSerializers.OPTIONAL_UUID);

    private double lifespanSeconds = 20;
    private int remainingLife = 400;

    public GlimmerbugEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.ARMOR, 0D)
                .add(Attributes.ATTACK_DAMAGE, 4D)
                .add(Attributes.ATTACK_SPEED, 2D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public void tick() {
        super.tick();

        if (hasLifespan()) {

            remainingLife--;

            if (!level().isClientSide()) {

                if (remainingLife <= 0) {

                    remove(RemovalReason.KILLED);

                }

            }

        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

    }

    @Override
    public boolean isPersistenceRequired() {
        return this.isSummoned();
    }

    @Override
    public boolean canBeLeashed() {
        return this.isSummoned();
    }

    public boolean isSummoned() {
        return this.entityData.get(SUMMONED);
    }

    public boolean hasLifespan() {
        return this.entityData.get(HAS_LIFESPAN);
    }

    public double getLifespanSeconds() {
        return lifespanSeconds;
    }

    public void setSummoned(boolean newSummoned) {
        this.entityData.set(SUMMONED, newSummoned);
    }

    public void setHasLifespan(boolean hasLifespan) {
        this.entityData.set(HAS_LIFESPAN, hasLifespan);
    }

    public void setLifespanSeconds(double lifespanSeconds) {
        this.lifespanSeconds = lifespanSeconds;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.GRASS_STEP, 0.1f, 1.0f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SILVERFISH_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.TURTLE_EGG_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SILVERFISH_DEATH;
    }

    @Override
    public float getVoicePitch() {
        return 1.2f;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }

    @Override
    public boolean shouldDropExperience() {
        return !isSummoned();
    }

    @Override
    protected boolean shouldDropLoot() {
        return !isSummoned() && !hasLifespan();
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    private void setupAnimationStates() {



    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {

        remainingLife = (int)(20 * lifespanSeconds);

        if (isSummoned()) {
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(6D);
            this.getAttribute(Attributes.ARMOR).setBaseValue(4D);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4D);

            this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.005, false));
            this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
            this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.00));

            this.targetSelector.addGoal(0, new OwnerHurtByTargetGoal(this));
            this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Monster.class, true));
        }
        else {
            this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.005, false));
            this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.00));

            this.targetSelector.addGoal(0, new HurtByTargetGoal(this).setAlertOthers());
        }

        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SUMMONED, false);
        builder.define(HAS_LIFESPAN, false);
        builder.define(OWNER_UUID, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Summoned", this.isSummoned());
        tag.putBoolean("HasLifespan", this.hasLifespan());
        tag.putInt("RemainingLifeTicks", remainingLife);
        tag.putDouble("LifespanSeconds", lifespanSeconds);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(SUMMONED, tag.getBoolean("Summoned"));
        this.entityData.set(HAS_LIFESPAN, tag.getBoolean("HasLifespan"));
        remainingLife = tag.getInt("RemainingLifeTicks");
        lifespanSeconds = tag.getDouble("LifespanSeconds");
    }

}
