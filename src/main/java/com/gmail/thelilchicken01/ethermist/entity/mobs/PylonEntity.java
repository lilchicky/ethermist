package com.gmail.thelilchicken01.ethermist.entity.mobs;

import com.gmail.thelilchicken01.ethermist.effect.EMMobEffects;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.level.NoteBlockEvent;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PylonEntity extends Monster implements OwnableEntity {

    public final AnimationState idleState = new AnimationState();

    private final int BUFF_RADIUS = 6;

    private static final EntityDataAccessor<Float> LIFESPAN_SECONDS = SynchedEntityData.defineId(PylonEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> LIFESPAN_COUNTER = SynchedEntityData.defineId(PylonEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IS_FRIENDLY = SynchedEntityData.defineId(PylonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_BUFFED = SynchedEntityData.defineId(PylonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Optional<UUID>> OWNER_UUID = SynchedEntityData.defineId(PylonEntity.class, EntityDataSerializers.OPTIONAL_UUID);

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
                .add(Attributes.FOLLOW_RANGE, 24);
    }

    public void setLifespanSeconds(float seconds) {
        this.entityData.set(LIFESPAN_SECONDS, Math.max(1, seconds));
    }

    public double getLifespanSeconds() {
        return this.entityData.get(LIFESPAN_SECONDS);
    }

    public int getLifespanCounter() {
        return this.entityData.get(LIFESPAN_COUNTER);
    }

    public void setLifespanCounter(int seconds) {
        this.entityData.set(LIFESPAN_COUNTER, seconds);
    }

    public void addLifespanCounter(int additional) {
        this.entityData.set(LIFESPAN_COUNTER, getLifespanCounter() + additional);
    }

    public void setOwnerUUID(UUID uuid) {
        this.entityData.set(OWNER_UUID, Optional.ofNullable(uuid));
    }

    public void setIsFriendly(boolean friendly) {
        this.entityData.set(IS_FRIENDLY, friendly);
    }

    public boolean isFriendly() {
        return this.entityData.get(IS_FRIENDLY);
    }

    public void setIsBuffed(boolean buffed) {
        this.entityData.set(IS_BUFFED, buffed);
    }

    public boolean isBuffed() {
        return this.entityData.get(IS_BUFFED);
    }

    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();

        this.setTimerName();

        int duration = Math.max(1, (int) ((getLifespanSeconds() + 1) * 20) - getLifespanCounter());
        this.addEffect(new MobEffectInstance(MobEffects.GLOWING, duration, 0, false, false));
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide()) {
            addLifespanCounter(1);

            if (this.level() instanceof ServerLevel server) {

                if (this.entityData.get(IS_FRIENDLY)) {
                    if (this.tickCount % 10 == 0) {
                        double y = this.getY() + 0.5;
                        double cx = this.getX();
                        double cz = this.getZ();

                        var particle = net.minecraft.core.particles.ParticleTypes.ENCHANT;

                        for (int i = 0; i < 128; i++) {
                            double angle = (Math.PI * 2.0 * i) / 128;
                            double px = cx + BUFF_RADIUS * Math.cos(angle);
                            double pz = cz + BUFF_RADIUS * Math.sin(angle);

                            server.sendParticles(particle, px, y, pz, 1, 0.0, 0.01, 0.0, 0.0);
                        }

                        if (this.getOwner() != null) {
                            List<LivingEntity> nearby = server.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(BUFF_RADIUS));

                            for (LivingEntity entity : nearby) {
                                if (
                                        entity.distanceToSqr(this) <= (BUFF_RADIUS * BUFF_RADIUS) &&
                                                (entity instanceof Player ||
                                                        (entity instanceof OwnableEntity tamable &&
                                                                this.getOwnerUUID() != null &&
                                                                this.getOwnerUUID().equals(tamable.getOwnerUUID())
                                                        )
                                                )
                                ) {
                                    entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, this.isBuffed() ? 1 : 0));
                                    entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, this.isBuffed() ? 1 : 0));
                                    entity.addEffect(new MobEffectInstance(EMMobEffects.ARCANE_AMPLIFICATION, 40, this.isBuffed() ? 1 : 0));
                                }
                            }
                        }
                    }
                }

                if (getLifespanCounter() % 20 == 0) {
                    this.setTimerName();
                }

            }

            if (getLifespanCounter() > (getLifespanSeconds() + 1) * 20) {
                this.remove(RemovalReason.KILLED);
            }
        } else {
            this.setupAnimationStates();
        }

    }

    private void setTimerName() {
        double currentHealth = getLifespanSeconds() - ((double) getLifespanCounter() / 20);

        MutableComponent name = Component.literal(String.valueOf((int)currentHealth));

        if (this.getOwner() != null && this.getOwner() instanceof Player player) {
            name.append(Component.literal(" - ")
                    .append(player.getDisplayName())
                    .append(Component.translatable("generic.ethermist.pylon.name_suffix")));
        }

        this.setCustomName(name.withColor(this.getTeamColor()));
        this.setCustomNameVisible(true);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public int getTeamColor() {
        if (!this.isFriendly()) {
            int total = Math.max(1, (int) (getLifespanSeconds() * 20));
            int elapsed = Mth.clamp(getLifespanCounter(), 0, total);
            float t = (float) elapsed / (float) total;

            int r = (int) (255 * t);
            int g = (int) (255 * (1.0F - t));
            return (r << 16) | (g << 8);
        }
        else {
            return 3381759;
        }
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
        this.idleState.startIfStopped(this.tickCount);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putDouble("lifespan", getLifespanSeconds());
        tag.putInt("lifespan_remaining", getLifespanCounter());
        tag.putBoolean("is_buffed", isBuffed());
        if (this.getOwnerUUID() != null) {
            tag.putUUID("owner", this.getOwnerUUID());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setLifespanSeconds(tag.getInt("lifespan"));
        this.setLifespanCounter(tag.getInt("lifespan_remaining"));
        this.setIsBuffed(tag.getBoolean("is_buffed"));

        UUID uuid;
        if (tag.hasUUID("owner")) {
            uuid = tag.getUUID("owner");
        } else {
            String s = tag.getString("owner");
            uuid = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), s);
        }

        if (uuid != null) {
            try {
                this.setOwnerUUID(uuid);
                this.setIsFriendly(true);
            } catch (Throwable throwable) {
                this.setIsFriendly(false);
            }
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LIFESPAN_SECONDS, 30f);
        builder.define(LIFESPAN_COUNTER, 0);
        builder.define(IS_FRIENDLY, false);
        builder.define(IS_BUFFED, false);
        builder.define(OWNER_UUID, Optional.empty());
    }

    @Override
    public @Nullable UUID getOwnerUUID() {
        return this.entityData.get(OWNER_UUID).orElse(null);
    }

    @Override
    public boolean isBaby() {
        return isFriendly();
    }

    @Override
    protected int getBaseExperienceReward() {
        return isFriendly() ? 0 : 10;
    }
}
