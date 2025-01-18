package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.EMTags;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPortalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Optional;
import java.util.function.Predicate;

public class WandItem extends Item {

    private final SoundEvent SHOOT_SOUND;

    public WandItem(Properties properties, SoundEvent shootSound) {
        super(properties.stacksTo(1));
        this.SHOOT_SOUND = shootSound;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack wand = player.getItemInHand(usedHand);

        WandShotItem shotItem = EMItems.MIST_GEM.get();

        if(!player.getCooldowns().isOnCooldown(this)) {
            ItemStack shotItemStack = new ItemStack(EMItems.MIST_GEM.get());
            shoot(level, player, shotItemStack, shotItem);

            level.playSound(player,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SHOOT_SOUND,
                    SoundSource.PLAYERS,
                    1.0f,
                    level.getRandom().nextFloat() * 0.4f + 0.8f);
            player.awardStat(Stats.ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, this.getCooldownSeconds() * 20);

            wand.hurtAndBreak(1, player, wand.getEquipmentSlot());

        }

        return super.use(level, player, usedHand);

    }

    private void shoot(Level level, Player player, ItemStack shotStack, WandShotItem shotItem) {
        WandProjectile shot = shotItem.createProjectile(level, shotStack, player);
        shot.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, this.getProjectileSpeed(), this.getInaccuracy());

        shot.setDamage(shot.getDamage() + this.getBonusDamage());
        shot.setLifetime(this.getLifespanSeconds() * 20);
        shot.setTrail(this.getTrail());
        shot.setCanIgnite(this.getCanIgnite());
        shot.setKnockbackStrength(this.getKnockback());

        level.addFreshEntity(shot);

    }

    // DEFAULTS
    public int getLifespanSeconds() {
        return 6;
    }
    public int getBonusDamage() {
        return 0;
    }
    public float getInaccuracy() {
        return 1.0f;
    }
    public float getProjectileSpeed() {
        return 1.0f;
    }
    public ParticleOptions getTrail() {
        return null;
    }
    public boolean getCanIgnite() {
        return false;
    }
    public double getKnockback() {
        return 1.0;
    }
    public int getCooldownSeconds() {
        return 1;
    }

    /*
    UseOn code courtesy of Undergarden :)
     */

    @Override
    public InteractionResult useOn(UseOnContext context) {

        if (context.getLevel().getBlockState(context.getClickedPos()).is(EMTags.Blocks.PORTAL_FRAME_BLOCKS) &&
                (context.getLevel().dimension() == Level.OVERWORLD || context.getLevel().dimension() == Ethermist.ETHERMIST)) {
            BlockPos framePos = context.getClickedPos().relative(context.getClickedFace());
            Optional<EMPortalShape> optional = findPortalShape(
                    context.getLevel(),
                    framePos,
                    shape -> shape.isValid() && shape.getNumPortalBlocks() == 0,
                    Direction.Axis.X);
            if (optional.isPresent()) {
                optional.get().createPortalBlocks();
                context.getLevel().playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);

                if (!context.getLevel().isClientSide()) {
                    context.getItemInHand().hurtAndBreak(1,
                            context.getPlayer(),
                            context.getItemInHand().getEquipmentSlot());
                }

                return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
            }
        }
        else {
            this.use(context.getLevel(), context.getPlayer(), context.getHand());
            return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
        }
        return InteractionResult.FAIL;
    }

    public static Optional<EMPortalShape> findPortalShape(LevelAccessor accessor, BlockPos pos, Predicate<EMPortalShape> shape, Direction.Axis axis) {
        Optional<EMPortalShape> optional = Optional.of(new EMPortalShape(accessor, pos, axis)).filter(shape);
        if (optional.isPresent()) {
            return optional;
        } else {
            Direction.Axis oppositeAxis = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
            return Optional.of(new EMPortalShape(accessor, pos, oppositeAxis)).filter(shape);
        }
    }

}
