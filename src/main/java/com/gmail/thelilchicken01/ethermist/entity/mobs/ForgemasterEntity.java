package com.gmail.thelilchicken01.ethermist.entity.mobs;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.EMWandHandles;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects.EMWandOrbs;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.SpellModifiers;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class ForgemasterEntity extends Monster {

    public final AnimationState idleState = new AnimationState();
    public final AnimationState attackState = new AnimationState();
    public final AnimationState walkState = new AnimationState();

    private final ServerBossEvent bossEvent = (ServerBossEvent) (new ServerBossEvent(
            this.getDisplayName(),
            BossEvent.BossBarColor.PURPLE,
            BossEvent.BossBarOverlay.NOTCHED_20
    ).setDarkenScreen(true));

    private final double SHOOT_COOLDOWN = 1;
    private final int SHOOT_DAMAGE = 15;
    private final int SHOOT_LIFESPAN = 5 * 20;

    private final int KNOCKUP_COOLDOWN = 5;
    private final int KNOCKUP_RANGE = 6;
    private final int KNOCKUP_DAMAGE = 10;

    private final int PYLON_COOLDOWN = 8;
    public final int PYLON_CONSUME_COOLDOWN = 16;
    private final int PYLON_BASE_COUNT = 8;
    private final int PYLON_PER_ADDITIONAL_PLAYER = 4;
    private final int PYLON_SPAWN_RADIUS = 12;

    private static final float TOTAL_HEALTH = 900.0f;
    private final double PHASE_2_HEALTH_PERCENT = 0.8;
    private final double PHASE_3_HEALTH_PERCENT = 0.4;

    // Percent of max health healed per pylon consumed.
    private final double HEALTH_PERCENT_HEALED_PER_PYLON = 0.075;

    private boolean isPhase2 = false;
    private boolean isPhase3 = false;
    private double cooldownMod = 1;

    private final WandShotItem SHOT_ITEM = EMItems.FORGEMASTER_SHOT.get();
    private final ItemStack SHOT_ITEM_STACK = new ItemStack(SHOT_ITEM);

    private int shootCounter;
    private int knockupCounter;
    private int pylonCounter;
    private int pylonConsumeCounter;

    private boolean hasPylons = false;

    public ForgemasterEntity(EntityType<? extends Monster> entityType, Level level) {
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
                .add(Attributes.MAX_HEALTH, TOTAL_HEALTH)
                .add(Attributes.ARMOR, 15)
                .add(Attributes.ATTACK_DAMAGE, 30)
                .add(Attributes.ATTACK_SPEED, 0.5)
                .add(Attributes.MOVEMENT_SPEED, 0.1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10)
                .add(Attributes.FOLLOW_RANGE, 24);
    }

    @Override
    public void tick() {
        super.tick();

        shootCounter++;
        knockupCounter++;

        if (!hasPylons) {
            pylonCounter++;
        } else {
            pylonConsumeCounter++;
        }

        /*
                    Cast faster per phase
         */

        if (getHealth() < (getMaxHealth() * PHASE_3_HEALTH_PERCENT)) {
            isPhase3 = true;
            cooldownMod = 0.3;
            addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));
        } else if (getHealth() < (getMaxHealth() * PHASE_2_HEALTH_PERCENT)) {
            isPhase2 = true;
            cooldownMod = 0.6;
            addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0));
        }

        /*
                    All Phases (Meteor Shot)
         */

        if (!level().isClientSide()) {

            if (shootCounter > (SHOOT_COOLDOWN * cooldownMod) * 20 && this.getTarget() != null) {

                WandProjectile shot = SHOT_ITEM.createProjectile(this.level(), SHOT_ITEM_STACK, this, List.of(this.getTarget()));

                Vec3 currentPos = getEyePosition();
                Vec3 targetPos = getTarget().getPosition(1.0f);
                Vec3 targetVector = targetPos.subtract(currentPos).normalize();

                shot.shoot(targetVector.x, targetVector.y + 0.1, targetVector.z, 0.4f, 0.0f);

                shot.setDamage(SHOOT_DAMAGE);
                shot.setLifetime(SHOOT_LIFESPAN);
                shot.setCanIgnite(false);
                shot.setKnockbackStrength(0.5);
                shot.setHoming(false);
                shot.setOwner(this);
                shot.setOriginWandOrb(EMWandOrbs.FORGEMASTER.get());
                shot.setOriginWandHandle(EMWandHandles.WOODEN.get());
                shot.setTargetType(List.of(SpellModifiers.TargetType.ALL));
                shot.setDamageType(EMDamageTypes.FORGEMASTER_SHOT);
                shot.setTrailColor(new float[]{1.0f, 0.1f, 0.1f});

                this.level().addFreshEntity(shot);
                this.playSound(
                        SoundEvents.BLAZE_SHOOT,
                        0.2f,
                        this.level().getRandom().nextFloat() * 0.4f + 0.8f
                );

                shootCounter = 0;

            }

            /*
                        Phase 2 (Knockup)
             */

            if (knockupCounter > KNOCKUP_COOLDOWN * 20 && this.getTarget() != null && isPhase2) {

                List<LivingEntity> nearbyEntities = this.level().getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT, this, new AABB(
                        this.getX() - KNOCKUP_RANGE,
                        this.getY() - KNOCKUP_RANGE,
                        this.getZ() - KNOCKUP_RANGE,
                        this.getX() + KNOCKUP_RANGE,
                        this.getY() + KNOCKUP_RANGE,
                        this.getZ() + KNOCKUP_RANGE));

                this.playSound(
                        SoundEvents.GENERIC_EXPLODE.value(),
                        1.0f,
                        this.level().getRandom().nextFloat() * 0.4f + 0.8f
                );

                if (this.level() instanceof ServerLevel server) {
                    server.sendParticles(ParticleTypes.EXPLOSION,
                            this.getX(), this.getY(), this.getZ(),
                            10,
                            3.0, 0.0, 3.0,
                            0.0
                    );
                }

                for (LivingEntity entity : nearbyEntities) {

                    if (!(entity instanceof PylonEntity)) {

                        DamageSource damageSource = new DamageSource(
                                this.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(EMDamageTypes.FORGEMASTER_KNOCKUP),
                                this,
                                this,
                                null
                        );

                        entity.hurtMarked = true;
                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, 1.0, 0.0).multiply(0.0, 2.0, 0.0).normalize());
                        entity.hurt(damageSource, KNOCKUP_DAMAGE);

                    }

                }

                knockupCounter = 0;

            }

            /*
                        Phase 3 (Pylons)
             */

            // Spawn the pylons, then set hasPylons to true
            if (pylonCounter > PYLON_COOLDOWN * 20 && isPhase3) {

                this.playSound(
                        SoundEvents.ANVIL_USE,
                        1.0f,
                        this.level().getRandom().nextFloat() * 0.01f + 0.1f
                );

                setInvulnerable(true);
                bossEvent.setColor(BossEvent.BossBarColor.WHITE);

                int spawnedPylons = 0;
                int spawnTries = 0;

                List<Player> nearbyPlayers = this.level().getNearbyEntities(Player.class, TargetingConditions.DEFAULT, this, new AABB(
                        this.getX() - 24,
                        this.getY() - 24,
                        this.getZ() - 24,
                        this.getX() + 24,
                        this.getY() + 24,
                        this.getZ() + 24));

                while (spawnedPylons < (PYLON_BASE_COUNT + (PYLON_PER_ADDITIONAL_PLAYER * nearbyPlayers.size()))) {

                    // IMPORTANT TO BREAK OUT OF WHILE LOOP IF TOO MANY ATTEMPTS!!
                    spawnTries++;

                    double randomX = getX() + ((Math.random() - 0.5) * (PYLON_SPAWN_RADIUS * 2));
                    double randomZ = getZ() + ((Math.random() - 0.5) * (PYLON_SPAWN_RADIUS * 2));

                    BlockPos.MutableBlockPos spawnPos = new BlockPos.MutableBlockPos(randomX, this.getY(), randomZ);

                    while (spawnPos.getY() > this.level().getMinBuildHeight() && this.level().getBlockState(spawnPos).isAir()) {
                        spawnPos.move(Direction.DOWN);
                    }

                    BlockState spawnState = this.level().getBlockState(spawnPos);

                    if (spawnState.is(EMTags.Blocks.CAN_SUPPORT_FORGEMASTER_PYLON)) {

                        BlockPos pylonPos = spawnPos.above();
                        PylonEntity pylon = new PylonEntity(EMEntityTypes.PYLON.get(), this.level());

                        pylon.setPos(pylonPos.getX() + 0.5, pylonPos.getY(), pylonPos.getZ() + 0.5);
                        pylon.setLifespanSeconds(PYLON_CONSUME_COOLDOWN);

                        this.level().addFreshEntity(pylon);

                        spawnedPylons++;

                    }

                    if (spawnTries > 1024) {
                        Ethermist.LOGGER.info("Failed to find enough valid Pylon spawn locations!");
                        break;
                    }

                }

                hasPylons = true;
                pylonCounter = 0;

            }

            // Consume spawned pylons, then set has pylons back to false

            if (pylonConsumeCounter > 0) {

                List<PylonEntity> nearbyPylons = this.level().getNearbyEntities(PylonEntity.class, TargetingConditions.DEFAULT, this,
                        new AABB(this.getX() - (PYLON_SPAWN_RADIUS * 2),
                                this.getY() - PYLON_SPAWN_RADIUS,
                                this.getZ() - (PYLON_SPAWN_RADIUS * 2),
                                this.getX() + (PYLON_SPAWN_RADIUS * 2),
                                this.getY() + PYLON_SPAWN_RADIUS,
                                this.getZ() + (PYLON_SPAWN_RADIUS * 2)));

                // End phase early if all pylons are killed
                if (nearbyPylons.isEmpty()) {
                    playSound(SoundEvents.ANVIL_DESTROY, 1.0f, 0.1f);

                    setInvulnerable(false);
                    bossEvent.setColor(BossEvent.BossBarColor.PURPLE);

                    hasPylons = false;
                    pylonConsumeCounter = 0;
                }

                if (pylonConsumeCounter > PYLON_CONSUME_COOLDOWN * 20 && isPhase3) {

                    int pylonsConsumed = 0;

                    playSound(SoundEvents.ANVIL_DESTROY, 1.0f, 0.1f);

                    setInvulnerable(false);
                    bossEvent.setColor(BossEvent.BossBarColor.PURPLE);

                    for (PylonEntity pylon : nearbyPylons) {
                        pylon.remove(RemovalReason.KILLED);
                        pylonsConsumed++;
                    }

                    heal((float) (pylonsConsumed * (getMaxHealth() * HEALTH_PERCENT_HEALED_PER_PYLON)));

                    hasPylons = false;
                    pylonConsumeCounter = 0;

                }

            }

        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide()) {
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        }
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
    protected int getBaseExperienceReward() {
        return 12000;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 0.5f, 0.1f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    @Override
    public float getVoicePitch() {
        return 1.2f;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    private void setupAnimationStates() {

        boolean isMoving = this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6;

        if (this.swinging) {
            this.idleState.stop();
            this.walkState.stop();

            this.attackState.stop();
            this.attackState.start(this.tickCount);
            this.swinging = false;
            return;
        }

        if (!this.attackState.isStarted()) {
            if (isMoving) {
                this.idleState.stop();
                this.attackState.stop();
                this.walkState.startIfStopped(this.tickCount);
            } else {
                this.walkState.stop();
                this.attackState.stop();
                this.idleState.startIfStopped(this.tickCount);
            }
        }

    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        tag.putInt("shoot_counter", this.shootCounter);
        tag.putInt("knockup_counter", this.knockupCounter);
        tag.putInt("pylon_counter", this.pylonCounter);
        tag.putInt("pylon_consume_counter", this.pylonConsumeCounter);

        tag.putBoolean("has_pylons", this.hasPylons);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        this.shootCounter = tag.getInt("shoot_counter");
        this.knockupCounter = tag.getInt("knockup_counter");
        this.pylonCounter = tag.getInt("pylon_counter");
        this.pylonConsumeCounter = tag.getInt("pylon_consume_counter");

        this.hasPylons = tag.getBoolean("has_pylons");
    }
}
