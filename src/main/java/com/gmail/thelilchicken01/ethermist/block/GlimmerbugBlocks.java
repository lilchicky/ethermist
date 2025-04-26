package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugEntity;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import java.util.concurrent.atomic.AtomicBoolean;

public class GlimmerbugBlocks extends EMRotatedPillarBlock {

    public GlimmerbugBlocks() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).lightLevel((state) -> 12), true);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (!level.isClientSide() && !player.isCreative()) {

            AtomicBoolean isSilkTouch = new AtomicBoolean(false);

            EnchantmentHelper.runIterationOnItem(player.getMainHandItem(), (enchantHolder, enchantLevel) -> {
                if (enchantHolder.is(Enchantments.SILK_TOUCH.location())) {
                    isSilkTouch.set(true);
                }
            });

            if (!isSilkTouch.get()) {
                GlimmerbugEntity bug = new GlimmerbugEntity(EMEntityTypes.GLIMMERBUG.get(), level);

                bug.setPos(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);

                bug.setYRot((float) (Math.random() * 360.0));
                bug.setYHeadRot(bug.getYRot());

                bug.finalizeSpawn(
                        (ServerLevelAccessor) level,
                        level.getCurrentDifficultyAt(pos),
                        MobSpawnType.MOB_SUMMONED,
                        null
                );

                level.addFreshEntity(bug);
            }
        }
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int l = 0; l < 14; ++l) {
            blockpos$mutableblockpos.set(i + Mth.nextInt(rand, -7, 7), j - Mth.nextInt(rand, -7, 7), k + Mth.nextInt(rand, -7, 7));
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(level, blockpos$mutableblockpos)) {
                level.addParticle(EMParticleTypes.GLIMMERBUG_AIR.get(), (double)blockpos$mutableblockpos.getX() + rand.nextDouble(), (double)blockpos$mutableblockpos.getY() + rand.nextDouble(), (double)blockpos$mutableblockpos.getZ() + rand.nextDouble(), (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }

    }

}
