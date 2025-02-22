package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class CharredStumpPlacer extends TrunkPlacer {

    public static final MapCodec<CharredStumpPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> trunkPlacerParts(instance).apply(instance, CharredStumpPlacer::new)
    );

    public CharredStumpPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return EMTrunkPlacerType.CHARRED_STUMP_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {

        BlockPos blockpos = pos.below();
        setDirtAt(level, blockSetter, random, blockpos, config);
        setDirtAt(level, blockSetter, random, blockpos.east(), config);
        setDirtAt(level, blockSetter, random, blockpos.south(), config);
        setDirtAt(level, blockSetter, random, blockpos.south().east(), config);

        int modTreeHeight = freeTreeHeight + 4;

        int xPos = pos.getX();
        int yPos = pos.getY();
        int zPos = pos.getZ();

        int[] modifiers = {
                Math.max(modTreeHeight - random.nextInt(8), modTreeHeight / 2),
                Math.max(modTreeHeight - random.nextInt(8), modTreeHeight / 2),
                Math.max(modTreeHeight - random.nextInt(8), modTreeHeight / 2)
        };

        for(int trunkLoc = 0; trunkLoc < modTreeHeight; ++trunkLoc) {

            int j2 = yPos + trunkLoc;
            BlockPos basePos = new BlockPos(xPos, j2, zPos);
            if (TreeFeature.isAirOrLeaves(level, basePos)) {
                this.placeLog(level, blockSetter, random, basePos, config);

                if (trunkLoc <= modifiers[0]) {
                    this.placeLog(level, blockSetter, random, basePos.south(), config);
                }

                if (trunkLoc <= modifiers[1]) {
                    this.placeLog(level, blockSetter, random, basePos.east(), config);
                }

                if (trunkLoc <= modifiers[2]) {
                    this.placeLog(level, blockSetter, random, basePos.south().east(), config);
                }
            }
        }

        for(int x = -1; x <= 2; ++x) {
            for(int y = -1; y <= 2; ++y) {
                if ((x < 0 || x > 1 || y < 0 || y > 1) && random.nextInt(3) <= 2) {
                    int rootSize = random.nextInt(3) + 4;
                    int rootDepth = random.nextInt(3) + 1;

                    for(int rootCount = 0; rootCount < rootSize; ++rootCount) {
                        this.placeLog(level, blockSetter, random, new BlockPos(xPos + x, (yPos - rootDepth) + rootCount - 1, zPos + y), config);
                    }
                }
            }
        }

        return List.of();
    }

}
