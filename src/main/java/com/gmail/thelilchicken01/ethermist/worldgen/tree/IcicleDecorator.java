package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.block.Icicle;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.Random;

public class IcicleDecorator extends TreeDecorator {

    public static final MapCodec<IcicleDecorator> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.FLOAT.fieldOf("chance").forGetter(decorator -> decorator.chance)
            ).apply(instance, IcicleDecorator::new)
    );

    private final float chance;

    public IcicleDecorator(float chance) {
        this.chance = chance;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return EMTreeDecorators.ICICLE_DECORATOR.get();
    }

    @Override
    public void place(Context context) {

        context.leaves().forEach(leafPos -> {
            if (context.random().nextFloat() < chance && context.isAir(leafPos.below())) {
                BlockState baseIcicle = EMBlocks.ICICLE.get().defaultBlockState()
                        .setValue(Icicle.TIP_DIRECTION, Direction.DOWN)
                        .setValue(Icicle.THICKNESS, DripstoneThickness.TIP);

                int length = 1;

                if (context.random().nextBoolean() && context.isAir(leafPos.below(2))) {
                    length = 2;
                    if (context.random().nextBoolean() && context.isAir(leafPos.below(3))) {
                        length = 3;
                    }
                }

                for (int i = 0; i < length; i++) {
                    DripstoneThickness thickness = switch (i) {
                        case 0 -> (length == 3) ? DripstoneThickness.BASE
                                : (length == 2) ? DripstoneThickness.FRUSTUM
                                : DripstoneThickness.TIP;
                        case 1 -> (length == 3) ? DripstoneThickness.FRUSTUM : DripstoneThickness.TIP;
                        default -> DripstoneThickness.TIP;
                    };

                    context.setBlock(leafPos.below(i + 1), baseIcicle.setValue(Icicle.THICKNESS, thickness));
                }
            }
        });

    }
}
