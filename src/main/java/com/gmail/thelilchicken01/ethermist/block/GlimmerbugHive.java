package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class GlimmerbugHive extends Block {

    public GlimmerbugHive() {

        super(BlockBehaviour.Properties.ofFullCopy(Blocks.SHROOMLIGHT).emissiveRendering((state, getter, pos) -> {
            return true;
        }).lightLevel((state) -> 12));

    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        double d0 = (double)i + rand.nextDouble();
        double d1 = (double)j + 0.7;
        double d2 = (double)k + rand.nextDouble();
        level.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, d0, d1, d2, (double)0.0F, (double)0.0F, (double)0.0F);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int l = 0; l < 14; ++l) {
            blockpos$mutableblockpos.set(i + Mth.nextInt(rand, -10, 10), j - rand.nextInt(10), k + Mth.nextInt(rand, -10, 10));
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(level, blockpos$mutableblockpos)) {
                level.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, (double)blockpos$mutableblockpos.getX() + rand.nextDouble(), (double)blockpos$mutableblockpos.getY() + rand.nextDouble(), (double)blockpos$mutableblockpos.getZ() + rand.nextDouble(), (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }

    }

}
