package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WandProjectile extends Fireball {

    protected double damage = 2;
    protected double lifetime = 120;
    protected double knockbackStrength = 1;
    protected ParticleOptions trail = null;
    protected boolean canIgnite = false;
    protected boolean isHoming = false;
    protected List<? extends Entity> target;
    protected Player shooter = null;
    protected List<SpellModifiers.TargetType> targetType = List.of(SpellModifiers.TargetType.ALL);
    protected SpellModifiers.SpellType spellType = SpellModifiers.SpellType.GENERIC;
    protected int spellLevel = 0;
    protected ResourceKey<DamageType> damageType = EMDamageTypes.GENERIC_MAGIC;

    private int ticksSinceFired = 0;

    private static final double STOP_THRESHOLD = 0.00001;

    public WandProjectile(EntityType<? extends Fireball> entityType, Level level) {
        super(entityType, level);
    }

    public WandProjectile(Level level, LivingEntity shooter) {
        this(level, shooter, 0, 0, 0);
        setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
    }

    public WandProjectile(Level level, LivingEntity shooter, List<? extends Entity> target) {
        this(level, shooter, 0, 0, 0);
        this.target = target;
        if (shooter instanceof Player player) {
            this.shooter = player;
        }
        setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
    }

    public WandProjectile(Level level, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(EMEntityTypes.WAND_PROJECTILE.get(), shooter, new Vec3(accelX, accelY, accelZ), level);
    }

    public WandProjectile(Level level, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(EMEntityTypes.WAND_PROJECTILE.get(), x, y, z, new Vec3(accelX, accelY, accelZ), level);
    }

    @Override
    public void tick() {

        super.tick();

        ticksSinceFired++;
        WandProjectileHandler.processTick(this, STOP_THRESHOLD, ticksSinceFired, this.tickCount, target);

        if (this.level() instanceof ServerLevel level && this.trail != null) {
            Random random = new Random();
            level.sendParticles(this.trail, this.getX(), this.getY() + (this.getEyeHeight() * 0.5), this.getZ(), 1,
                    (random.nextDouble() - 0.5) * 0.1, (random.nextDouble() - 0.5) * 0.1, (random.nextDouble() - 0.5) * 0.1, 1);
        }
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        WandProjectileHandler.processHit(level(), getOwner(), result.getLocation(), result, this);
    }

    // Math courtesy of Guns n Roses
    @Override
    public void shootFromRotation(Entity shooter, float xRot, float yRot, float p_37255_, float speed, float spread) {
        float f = -Mth.sin(yRot * ((float) Math.PI / 180F)) * Mth.cos(xRot * ((float) Math.PI / 180F));
        float f1 = -Mth.sin((xRot + p_37255_) * ((float) Math.PI / 180F));
        float f2 = Mth.cos(yRot * ((float) Math.PI / 180F)) * Mth.cos(xRot * ((float) Math.PI / 180F));
        shoot(f, f1, f2, speed, spread);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("tsf", ticksSinceFired);
        compound.putDouble("damage", damage);
        compound.putDouble("lifetime", lifetime);
        compound.putBoolean("ignites", canIgnite);
        if (knockbackStrength != 0) compound.putDouble("knockback", knockbackStrength);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        ticksSinceFired = compound.getInt("tsf");
        damage = compound.getDouble("damage");
        lifetime = compound.getDouble("lifetime");
        canIgnite = compound.getBoolean("ignites");
        knockbackStrength = compound.getDouble("knockback");
    }

    @Override
    public boolean isOnFire() {
        return canIgnite;
    }

    @Override
    protected @Nullable ParticleOptions getTrailParticle() {
        return trail;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
    public void setKnockbackStrength(double knockbackStrength) {
        this.knockbackStrength = knockbackStrength;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public void setCanIgnite(boolean canIgnite) {
        this.canIgnite = canIgnite;
    }

    public void setHoming(boolean isHoming) {
        this.isHoming = isHoming;
    }

    public void setTargetType(List<SpellModifiers.TargetType> targetType) {
        this.targetType = targetType;
    }

    public void setSpellType(SpellModifiers.SpellType spellType) {
        this.spellType = spellType;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public void setDamageType(ResourceKey<DamageType> damageType) {
        this.damageType = damageType;
    }

    public void setTrail(@Nullable ParticleOptions trail) {
        this.trail = trail;
    }

}
