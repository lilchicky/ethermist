package com.gmail.thelilchicken01.ethermist.entity.mobs;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlimmerbugQueenEntity extends TamableAnimal {

    public final AnimationState idleStateBase = new AnimationState();
    public final AnimationState idleStateWiggle = new AnimationState();
    public final AnimationState idleStateMandibles = new AnimationState();
    public final AnimationState attackState = new AnimationState();

    private int spawnCooldown;

    private int idleAnimCooldown = 0;

    private static final EntityDataAccessor<Boolean> PACIFIED = SynchedEntityData.defineId(GlimmerbugQueenEntity.class, EntityDataSerializers.BOOLEAN);

    public GlimmerbugQueenEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.005, false));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(0, new HurtByTargetGoal(this).setAlertOthers(GlimmerbugQueenEntity.class)); // SET TO GLIMMERBUGS
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 400D)
                .add(Attributes.ARMOR, 6D)
                .add(Attributes.ATTACK_DAMAGE, 8D)
                .add(Attributes.ATTACK_SPEED, 0.5D)
                .add(Attributes.MOVEMENT_SPEED, 0.01D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide()) {

            if (!isPacified()) {

                spawnCooldown++;

                if (spawnCooldown > 20 && getTarget() instanceof Player) {

                    // IMPLEMENT SPAWN CODE

                    spawnCooldown = 0;

                }

                if (this.hasCustomName()) {

                    Component name = this.getCustomName();
                    String easterEggTranslated = Component.translatable("entity.ethermist.glimmerbug_queen.easter_egg").getString();

                    if (name != null && name.getString().equals(easterEggTranslated)) {

                        List<Player> nearbyPlayers = this.level().getEntitiesOfClass(Player.class, new AABB(
                                this.getX() - 8, this.getY() - 8, this.getZ() - 8,
                                this.getX() + 8, this.getY() + 8, this.getZ() + 8
                        ));

                        for (Player player : nearbyPlayers) {

                            if (player instanceof ServerPlayer serverPlayer) {

                                CriteriaTriggers.TAME_ANIMAL.trigger(serverPlayer, this);

                            }

                        }

                        this.targetSelector.getAvailableGoals().clear();
                        this.setTarget(null);
                        this.setPacified(true);

                    }

                }

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
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isPersistenceRequired() {
        return true;
    }

    @Override
    public boolean canBeLeashed() {
        return isPacified();
    }

    public boolean isPacified() {
        return this.entityData.get(PACIFIED);
    }

    public void setPacified(boolean pacified) {
        this.entityData.set(PACIFIED, pacified);
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
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    private void setupAnimationStates() {

        if (this.swinging) {
            this.attackState.stop();
            this.attackState.start(this.tickCount);
            this.swinging = false;
            return;
        }

        if (idleAnimCooldown == 0) {

            this.idleStateBase.stop();
            this.idleStateWiggle.stop();
            this.idleStateMandibles.stop();

            if (this.random.nextFloat() < 0.5F) {
                if (this.random.nextBoolean()) {
                    this.idleStateWiggle.start(this.tickCount);
                }
                else {
                    this.idleStateMandibles.start(this.tickCount);
                }
            }
            else {
                this.idleStateBase.start(this.tickCount);
            }
            idleAnimCooldown = 80;
        }
        else {
            idleAnimCooldown--;
        }

    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PACIFIED, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Pacified", this.isPacified());
        tag.putInt("SpawnCooldown", this.spawnCooldown);
        tag.putInt("IdleAnimCooldown", this.idleAnimCooldown);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(PACIFIED, tag.getBoolean("Pacified"));
        this.spawnCooldown = tag.getInt("SpawnCooldown");
        this.idleAnimCooldown = tag.getInt("IdleAnimCooldown");
    }

}
