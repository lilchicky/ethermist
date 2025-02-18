package com.gmail.thelilchicken01.ethermist.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class SlimyAllium extends FlowerBlock {

    public SlimyAllium() {
        super(MobEffects.JUMP, 15, Properties.ofFullCopy(Blocks.POPPY));
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide()) {
            if (entity instanceof LivingEntity livingentity) {
                livingentity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, level.random.nextInt(3)));
            }
        }
    }

}
