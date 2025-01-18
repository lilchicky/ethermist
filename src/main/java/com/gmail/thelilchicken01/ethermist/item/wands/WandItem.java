package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPortalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Optional;
import java.util.function.Predicate;

public class WandItem extends Item {

    public WandItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    /*
    Use code courtesy of Undergarden :)
     */

    @Override
    public InteractionResult useOn(UseOnContext context) {

        if (context.getLevel().dimension() == Level.OVERWORLD || context.getLevel().dimension() == Ethermist.ETHERMIST) {
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
                    context.getItemInHand().hurtAndBreak(1, context.getPlayer(), context.getItemInHand().getEquipmentSlot());
                }

                return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
            }
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
