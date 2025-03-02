package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.function.Predicate;

public class AbyssalMushroomCapPlacer extends FoliagePlacer {

    public static final MapCodec<AbyssalMushroomCapPlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    IntProvider.codec(0, 16).fieldOf("radius").forGetter(placer -> placer.radius),
                    IntProvider.codec(0, 16).fieldOf("offset").forGetter(placer -> placer.offset),
                    BlockStateProvider.CODEC.fieldOf("gills").forGetter(placer -> placer.gills)
            ).apply(instance, AbyssalMushroomCapPlacer::new)
    );

    private final BlockStateProvider gills;

    public AbyssalMushroomCapPlacer(IntProvider radius, IntProvider offset, BlockStateProvider gills) {
        super(radius, offset);
        this.gills = gills;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EMFoliagePlacerType.ABYSSAL_MUSHROOM_TOP_PLACER.get();
    }

    @Override
    protected void createFoliage(
            LevelSimulatedReader level,
            FoliagePlacer.FoliageSetter setter,
            RandomSource random,
            TreeConfiguration config,
            int treeHeight,
            FoliagePlacer.FoliageAttachment attachment,
            int foliageHeight,
            int radius,
            int offset
    ) {
        int centerX = attachment.pos().getX();
        int centerY = attachment.pos().getY() + offset;
        int centerZ = attachment.pos().getZ();

        int topRadius = radius - 1;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                int distSquared = x * x + z * z;

                BlockPos posBottom = new BlockPos(centerX + x, centerY, centerZ + z);

                if (distSquared <= radius * radius) {
                    if (!level.isStateAtPosition(posBottom, state -> state.is(gills.getState(random, posBottom).getBlock()))) {
                        tryPlaceLeaf(level, setter, random, config, posBottom);
                    }
                }

                if (distSquared <= topRadius * topRadius) {
                    BlockPos posTop = new BlockPos(centerX + x, centerY + 1, centerZ + z);
                    tryPlaceLeaf(level, setter, random, config, posTop);
                }

                if (distSquared <= (radius - 1) * (radius - 1)) {

                    if (level.isStateAtPosition(posBottom, state -> state.isAir() || state.is(BlockTags.REPLACEABLE_BY_TREES))) {

                        Direction.Axis axis;
                        if (Math.abs(x) > Math.abs(z)) {
                            axis = Direction.Axis.X;
                        } else if (Math.abs(z) > Math.abs(x)) {
                            axis = Direction.Axis.Z;
                        } else {
                            axis = Direction.Axis.Y;
                        }

                        BlockState gillState = gills.getState(random, posBottom).setValue(BlockStateProperties.AXIS, axis);
                        setter.set(posBottom, gillState);

                    }
                }

            }
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return 2;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return localY == 0
                ? (localX > 1 || localZ > 1) && localX != 0 && localZ != 0
                : localX == range && localZ == range && range > 0;
    }

}
