package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import net.minecraft.client.renderer.block.model.multipart.MultiPart;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootParams;

import java.util.List;

public class Cinderbloom extends PinkPetalsBlock {

    public Cinderbloom() {
        super(Properties.ofFullCopy(Blocks.PINK_PETALS).sound(SoundType.GRASS).mapColor(MapColor.COLOR_ORANGE));
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide()) {
            if (entity instanceof LivingEntity livingentity) {
                livingentity.hurt(level.damageSources().onFire(), 1.0f);
            }
        }
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || state.is(EMTags.Blocks.CAN_SUPPORT_CHARRED_TREE);
    }

}
