package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FlammableGlimmerbugBlocks extends EMFlammableRotatedPillarBlock {

    public FlammableGlimmerbugBlocks() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).emissiveRendering((state, getter, pos) -> {
            return false;
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
