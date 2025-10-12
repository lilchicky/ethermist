package com.gmail.thelilchicken01.ethermist.entity.mobs;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.IShearable;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GloomieEntity extends Animal implements IShearable {

    public final AnimationState idleState = new AnimationState();
    public final AnimationState hideState = new AnimationState();
    public final AnimationState swimState = new AnimationState();

    private int regrowTimer;
    private int regrowThreshold;

    private static final EntityDataAccessor<Boolean> SHEARED = SynchedEntityData.defineId(GloomieEntity.class, EntityDataSerializers.BOOLEAN);

    public GloomieEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);

        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.moveControl = new GloomieEntity.WaterMoveControl(this);

        this.regrowThreshold = 6000 + random.nextInt(1200);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new Goal() {
            @Override
            public boolean canUse() {
                return !isInWaterOrBubble();
            }

            @Override
            public void start() {
                GloomieEntity.this.getNavigation().stop();
                GloomieEntity.this.setDeltaMovement(0, 0, 0);
                GloomieEntity.this.setSpeed(0);
            }

            @Override
            public boolean requiresUpdateEveryTick() {
                return true;
            }
        });

        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get().asItem()), false));

        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 1.0, 40));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public void tick() {
        super.tick();

        if (isSheared()) {
            regrowTimer++;
            if (regrowTimer > regrowThreshold) {
                setSheared(false);
            }
        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();

        this.setAirSupply(300);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.9f;
    }

    @Override
    public boolean isPushedByFluid(FluidType type) {
        return false;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.FISH_SWIM, 0.07f, 0.5f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.TROPICAL_FISH_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.DOLPHIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0f;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get().asItem());
    }

    public boolean isSheared() {
        return this.entityData.get(SHEARED);
    }

    public void setSheared(boolean sheared) {
        this.entityData.set(SHEARED, sheared);
        if (sheared) {
            this.regrowThreshold = 6000 + random.nextInt(1200);
            regrowTimer = 0;
        }
    }

    @Override
    public boolean isShearable(@Nullable Player player, ItemStack item, Level level, BlockPos pos) {
        return !this.isSheared() && !this.isBaby();
    }

    @Override
    public List<ItemStack> onSheared(@Nullable Player player, ItemStack item, Level level, BlockPos pos) {
        this.setSheared(true);
        this.gameEvent(GameEvent.SHEAR, player);
        this.level().playSound(null, this.blockPosition(), SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS);

        int count = this.random.nextInt(2, 4);
        return List.of(new ItemStack(EMBlocks.SMALL_ABYSSAL_MUSHROOM.get().asItem(), count));
    }


    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return EMEntityTypes.GLOOMIE.get().create(level);
    }

    private void setupAnimationStates() {

        boolean inWater = this.isInWaterOrBubble();
        boolean isMoving = this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6;

        if (inWater && isMoving) {
            if (!this.swimState.isStarted()) {
                this.swimState.start(this.tickCount);
            }
            this.idleState.stop();
            this.hideState.stop();
        } else {
            if (this.swimState.isStarted()) {
                this.swimState.stop();
            }

            if (inWater) {
                if (!this.idleState.isStarted()) {
                    this.idleState.start(this.tickCount);
                }
                this.hideState.stop();
            } else {
                this.idleState.stop();
                if (!this.hideState.isStarted()) {
                    this.hideState.start(this.tickCount);
                }
            }
        }
    }


    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WaterBoundPathNavigation(this, level);
    }

    static class WaterMoveControl extends MoveControl {
        private final GloomieEntity fish;

        WaterMoveControl(GloomieEntity fish) {
            super(fish);
            this.fish = fish;
        }

        @Override
        public void tick() {
            if (this.fish.isEyeInFluidType(Fluids.WATER.getFluidType())) {
                this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0, 0.005, 0.0));
            }

            if (this.operation == MoveControl.Operation.MOVE_TO && !this.fish.getNavigation().isDone()) {
                float f = (float) (this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.fish.setSpeed(Mth.lerp(0.125F, this.fish.getSpeed(), f));
                double d0 = this.wantedX - this.fish.getX();
                double d1 = this.wantedY - this.fish.getY();
                double d2 = this.wantedZ - this.fish.getZ();
                if (d1 != 0.0) {
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0, (double) this.fish.getSpeed() * (d1 / d3) * 0.1, 0.0));
                }

                if (d0 != 0.0 || d2 != 0.0) {
                    float f1 = (float) (Mth.atan2(d2, d0) * 180.0F / (float) Math.PI) - 90.0F;
                    this.fish.setYRot(this.rotlerp(this.fish.getYRot(), f1, 90.0F));
                    this.fish.yBodyRot = this.fish.getYRot();
                }
            } else {
                this.fish.setSpeed(0.0F);
            }
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHEARED, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Sheared", this.isSheared());
        tag.putInt("RegrowTimer", this.regrowTimer);
        tag.putInt("RegrowThreshold", this.regrowThreshold);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(SHEARED, tag.getBoolean("Sheared"));
        this.regrowTimer = tag.getInt("RegrowTimer");
        this.regrowThreshold = tag.getInt("RegrowThreshold");
    }

    public static boolean checkSpawn(EntityType<? extends LivingEntity> entity, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        int i = level.getLevel().getSeaLevel();
        int j = i - 13;
        return (pos.getY() >= j
                && pos.getY() <= i
                && level.getFluidState(pos.below()).is(FluidTags.WATER)
                && level.getBlockState(pos.above()).is(Blocks.WATER))
                || spawnType == MobSpawnType.SPAWNER;
    }

}
