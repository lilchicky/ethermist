package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class Cinderbloom extends FlowerBlock {

    public Cinderbloom() {
        super(MobEffects.FIRE_RESISTANCE, 15, Properties.ofFullCopy(Blocks.POPPY));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || state.is(EMTags.Blocks.CAN_SUPPORT_CHARRED_TREE);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide()) {
            if (entity instanceof LivingEntity livingentity) {
                livingentity.hurt(level.damageSources().onFire(), 1.0f);
            }
        }
    }

}
