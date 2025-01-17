package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class AncientTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<AncientTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            p_70090_ -> trunkPlacerParts(p_70090_).apply(p_70090_, AncientTrunkPlacer::new)
    );

    public AncientTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    protected TrunkPlacerType<?> type() {
        return EMTrunkPlacerType.ANCIENT_TRUNK_PLACER.get();
    }

    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();

        BlockPos blockpos = pos.below();
        setDirtAt(level, blockSetter, random, blockpos, config);
        setDirtAt(level, blockSetter, random, blockpos.east(), config);
        setDirtAt(level, blockSetter, random, blockpos.south(), config);
        setDirtAt(level, blockSetter, random, blockpos.south().east(), config);
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int i = freeTreeHeight - random.nextInt(4);
        int j = 2 - random.nextInt(3);
        int xPos = pos.getX();
        int yPos = pos.getY();
        int zPos = pos.getZ();
        int j1 = xPos;
        int k1 = zPos;
        int treeMaxPos = yPos + freeTreeHeight - 1;

        for(int i2 = 0; i2 < freeTreeHeight; ++i2) {
            if (i2 >= i && j > 0) {
                j1 += direction.getStepX();
                k1 += direction.getStepZ();
                --j;
            }

            int j2 = yPos + i2;
            BlockPos blockpos1 = new BlockPos(j1, j2, k1);
            if (TreeFeature.isAirOrLeaves(level, blockpos1)) {
                this.placeLog(level, blockSetter, random, blockpos1, config);
                this.placeLog(level, blockSetter, random, blockpos1.east(), config);
                this.placeLog(level, blockSetter, random, blockpos1.south(), config);
                this.placeLog(level, blockSetter, random, blockpos1.east().south(), config);
            }
        }

        list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(j1, treeMaxPos, k1), 0, true));

        for(int x = -1; x <= 2; ++x) {
            for(int y = -1; y <= 2; ++y) {
                if ((x < 0 || x > 1 || y < 0 || y > 1) && random.nextInt(3) <= 2) {
                    int rootSize = random.nextInt(6) + 5;
                    int rootDepth = random.nextInt(3) + 3;

                    for(int rootCount = 0; rootCount < rootSize; ++rootCount) {
                        this.placeLog(level, blockSetter, random, new BlockPos(xPos + x, (yPos - rootDepth) + rootCount - 1, zPos + y), config);
                    }
                }
            }
        }

        for (int x2 = -1; x2 <= 2; x2++) {
            for (int y2 = -1; y2 <= 2; y2++) {
                if ((x2 < 0 || x2 > 1 || y2 < 0 || y2 > 1) && random.nextInt(3) <= 1) {
                    int branchSize = random.nextInt(6) + 3;

                    for (int branchCount = 0; branchCount < branchSize; branchCount++) {
                        BlockPos currentPos = new BlockPos(xPos + x2, treeMaxPos - branchCount + 2, zPos + y2);
                        this.placeLog(level, blockSetter, random, currentPos, config);
                    }

                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(j1 + x2, treeMaxPos, k1 + y2), 0, false));
                }
            }
        }

        return list;
    }

}
