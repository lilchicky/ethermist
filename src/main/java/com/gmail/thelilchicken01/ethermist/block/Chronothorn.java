package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.effect.EMMobEffects;
import com.gmail.thelilchicken01.ethermist.sound.EMSoundEvents;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Chronothorn extends FlowerBlock {

    public static final MapCodec<Chronothorn> CODEC = MapCodec.unit(Chronothorn::new);
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    private static final String COOLDOWN_TAG = "ethermist:chronothorn_cooldown";

    protected Chronothorn() {
        super(EMMobEffects.SLOWER_CASTING, 15, Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_GREEN));
    }

    @Override
    public MapCodec<? extends FlowerBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide() && entity instanceof LivingEntity livingEntity) {
            ServerLevel serverLevel = (ServerLevel) level;

            int cooldown = livingEntity.getPersistentData().getInt(COOLDOWN_TAG);
            if (cooldown > 0) {
                livingEntity.getPersistentData().putInt(COOLDOWN_TAG, cooldown - 1);
                return;
            }

            if (livingEntity instanceof ServerPlayer player) {
                Ethermist.SCHEDULER.schedule(serverLevel.getServer().getTickCount(), () -> {
                    if (player.isRemoved() || player.level() != serverLevel) return;

                    if (attemptRewind(livingEntity, serverLevel)) {
                        player.resetCurrentImpulseContext();
                    }
                });
                livingEntity.getPersistentData().putInt(COOLDOWN_TAG, 5);
                return;
            }

            if (attemptRewind(livingEntity, serverLevel)) {
                livingEntity.getPersistentData().putInt(COOLDOWN_TAG, 5);
            }
        }
    }

    private boolean attemptRewind(LivingEntity livingEntity, ServerLevel level) {
        for (int i = 0; i < 32; i++) {
            double d0 = livingEntity.getX() + (livingEntity.getRandom().nextDouble() - 0.5) * 8.0;
            double d1 = Mth.clamp(
                    livingEntity.getY() + (double) (livingEntity.getRandom().nextInt(16) - 8),
                    level.getMinBuildHeight(),
                    level.getMinBuildHeight() + level.getLogicalHeight() - 1
            );
            double d2 = livingEntity.getZ() + (livingEntity.getRandom().nextDouble() - 0.5) * 16.0;
            if (livingEntity.isPassenger()) {
                livingEntity.stopRiding();
            }

            Vec3 vec3 = livingEntity.position();
            if (livingEntity.randomTeleport(d0, d1, d2, true)) {
                level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(livingEntity));

                level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), EMSoundEvents.CHRONOTHORN_REWIND.get(), SoundSource.PLAYERS);
                livingEntity.resetFallDistance();
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || state.is(BlockTags.SAND);
    }
}
