package com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile;

import com.gmail.thelilchicken01.ethermist.EMDamageTypes;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.WandHandle;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects.WandOrb;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
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
import java.util.List;

public class WandProjectile extends Fireball {

    // Used to save spells from enchantments to the projectile
    public record SpellEntry(ResourceLocation enchantId, int level) {}
    private List<SpellEntry> spellEntries = List.of();

    protected int damage = 2;
    protected int lifetime = 120;
    protected double knockbackStrength = 1;
    protected ParticleOptions trail = null;
    protected boolean canIgnite = false;
    protected boolean isHoming = false;
    protected List<? extends Entity> target;
    protected Player shooter = null;
    protected List<TagKey<EntityType<?>>> targetType = new ArrayList<>();
    protected ResourceKey<DamageType> damageType = EMDamageTypes.GENERIC_MAGIC;
    protected WandHandle originWandTier = null;
    protected WandOrb originWandType = null;

    public static final EntityDataAccessor<Float> TRAIL_COLOR_RED;
    public static final EntityDataAccessor<Float> TRAIL_COLOR_GREEN;
    public static final EntityDataAccessor<Float> TRAIL_COLOR_BLUE;

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

        float[] trail = this.getTrailColor();
        if (this.level().isClientSide()) {
            Minecraft.getInstance().particleEngine.createParticle(
                    EMParticleTypes.WAND_TRAIL.get(),
                    this.getX(), this.getY() + (this.getEyeHeight() * 0.5), this.getZ(),
                    trail[0], trail[1], trail[2]
            );
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
        compound.putInt("ticks_since_fired", ticksSinceFired);
        compound.putInt("damage", damage);
        compound.putInt("lifetime", lifetime);
        compound.putBoolean("can_ignite", canIgnite);
        if (knockbackStrength != 0) compound.putDouble("knockback", knockbackStrength);

        ListTag spells = new ListTag();
        for (SpellEntry entry : spellEntries) {
            CompoundTag tag = new CompoundTag();
            tag.putString("enchant", entry.enchantId().toString());
            tag.putInt("level", entry.level());
            spells.add(tag);
        }

        compound.put("spell_entries", spells);

    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {

        super.readAdditionalSaveData(compound);
        ticksSinceFired = compound.getInt("ticks_since_fired");
        damage = compound.getInt("damage");
        lifetime = compound.getInt("lifetime");
        canIgnite = compound.getBoolean("can_ignite");
        knockbackStrength = compound.getDouble("knockback");

        if (compound.contains("spell_entries", ListTag.TAG_LIST)) {
            ListTag nbtSpells = compound.getList("spell_entries", ListTag.TAG_COMPOUND);
            List<SpellEntry> temp = new ArrayList<>();
            for (int x = 0; x < nbtSpells.size(); x++) {
                CompoundTag tag = nbtSpells.getCompound(x);
                temp.add(new SpellEntry(ResourceLocation.parse(tag.getString("enchant")), tag.getInt("level")));
            }
            this.spellEntries = List.copyOf(temp);
        }
        else {
            this.spellEntries = List.of();
        }

    }

    public void setSpellEntries(List<SpellEntry> entries) { this.spellEntries = List.copyOf(entries); }
    public List<SpellEntry> getSpellEntries() { return this.spellEntries; }

    public boolean hasSpell(ResourceLocation enchantId) {
        for (SpellEntry e : spellEntries) if (e.enchantId().equals(enchantId)) return true;
        return false;
    }


    @Override
    public boolean isOnFire() {
        return canIgnite;
    }
    public void setCanIgnite(boolean canIgnite) { this.canIgnite = canIgnite; }

    @Override
    protected @Nullable ParticleOptions getTrailParticle() {
        return trail;
    }

    public void setDamage(int damage) { this.damage = damage; }
    public int getDamage() { return damage; }

    public void setLifetime(int lifetime) { this.lifetime = lifetime; }
    public int getLifetime() { return lifetime; }

    public void setHoming(boolean homing) { this.isHoming = homing; }

    public void setTargetType(List<TagKey<EntityType<?>>> targetType) {
        this.targetType.addAll(targetType);
    }
    public List<TagKey<EntityType<?>>> getTargetType() { return this.targetType; }

    public void setDamageType(ResourceKey<DamageType> damageType) { this.damageType = damageType; }
    public ResourceKey<DamageType> getDamageType() { return this.damageType; }

    public void setKnockbackStrength(double knockbackStrength) {
        this.knockbackStrength = knockbackStrength;
    }

    public void setShooter(Player shooter) { this.shooter = shooter; }
    public Player getShooter() { return shooter; }

    public void setOriginWandHandle(WandHandle tier) { this.originWandTier = tier; }
    public WandHandle getOriginWandTier() { return originWandTier; }

    public void setOriginWandOrb(WandOrb type) { this.originWandType = type; }
    public WandOrb getOriginWandType() { return originWandType; }

    public void setTrailColor(float[] trailColor) {
        this.entityData.set(TRAIL_COLOR_RED, trailColor[0]);
        this.entityData.set(TRAIL_COLOR_GREEN, trailColor[1]);
        this.entityData.set(TRAIL_COLOR_BLUE, trailColor[2]);
    }

    public float[] getTrailColor() {
        float r = this.entityData.get(TRAIL_COLOR_RED);
        float g = this.entityData.get(TRAIL_COLOR_GREEN);
        float b = this.entityData.get(TRAIL_COLOR_BLUE);
        return new float[]{r, g, b};
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(TRAIL_COLOR_RED, 1.0f);
        builder.define(TRAIL_COLOR_GREEN, 1.0f);
        builder.define(TRAIL_COLOR_BLUE, 1.0f);
    }

    static {

        TRAIL_COLOR_RED = SynchedEntityData.defineId(WandProjectile.class, EntityDataSerializers.FLOAT);
        TRAIL_COLOR_GREEN = SynchedEntityData.defineId(WandProjectile.class, EntityDataSerializers.FLOAT);
        TRAIL_COLOR_BLUE = SynchedEntityData.defineId(WandProjectile.class, EntityDataSerializers.FLOAT);

    }

}
