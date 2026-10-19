package com.gmail.thelilchicken01.ethermist.entity.mobs;

import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("FieldCanBeLocal")
public class KarakaEntity extends Animal {

    public final AnimationState idleState = new AnimationState();
    public final AnimationState wagState = new AnimationState();
    public final AnimationState eatState = new AnimationState();
    public final AnimationState walkState = new AnimationState();

    private int animTicks = 0;

    private static final EntityDataAccessor<Boolean> ANTLERS = SynchedEntityData.defineId(KarakaEntity.class, EntityDataSerializers.BOOLEAN);

    public KarakaEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(EMTags.Items.IS_KARAKA_FOOD), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 24)
                .add(Attributes.ATTACK_DAMAGE, 6);
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
        return 10;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.HORSE_STEP, 0.15f, 0.5f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.HORSE_BREATHE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.HORSE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.HORSE_DEATH;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(EMTags.Items.IS_KARAKA_FOOD);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        KarakaEntity baby = EMEntityTypes.KARAKA.get().create(serverLevel);

        if (!level().isClientSide() && baby != null && ageableMob instanceof KarakaEntity parent) {
            if (hasAntlers() == parent.hasAntlers()) {
                baby.entityData.set(ANTLERS, hasAntlers());
            }
        }

        return baby;
    }

    private void stopIdles() {
        idleState.stop();
        eatState.stop();
        wagState.stop();
    }

    private void setupAnimationStates() {

        boolean isMoving = this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6;

        if (isMoving) {
            stopIdles();
            animTicks = 0;
            walkState.startIfStopped(this.tickCount);
        }
        else {
            walkState.stop();
            if (animTicks <= 0) {
                stopIdles();
                float nextState = random.nextFloat();

                if (nextState < 0.1) {
                    eatState.startIfStopped(this.tickCount);
                    animTicks = 70;
                } else if (nextState < 0.4) {
                    wagState.startIfStopped(this.tickCount);
                    animTicks = 40;
                } else {
                    idleState.startIfStopped(this.tickCount);
                    animTicks = 40;
                }
            }
            else {
                animTicks--;
            }
        }
    }

    public boolean hasAntlers() {
        return this.entityData.get(ANTLERS);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ANTLERS, random.nextBoolean());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Antlers", hasAntlers());
        compound.putInt("IdleAnimCooldown", this.animTicks);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(ANTLERS, compound.getBoolean("Antlers"));
        this.animTicks = compound.getInt("IdleAnimCooldown");
    }

    public static boolean checkSpawn(EntityType<? extends LivingEntity> entity, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getBlockState(pos.below()).is(BlockTags.DIRT) || spawnType == MobSpawnType.SPAWNER;
    }
}
