package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.FossilFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.apache.commons.lang3.mutable.MutableInt;

public class EMFossilFeature extends Feature<FossilFeatureConfiguration> {

    public EMFossilFeature() {
        super(FossilFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<FossilFeatureConfiguration> context) {
        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        Rotation rotation = Rotation.getRandom(random);
        FossilFeatureConfiguration config = context.config();
        int i = random.nextInt(config.fossilStructures.size());
        StructureTemplateManager structuretemplatemanager = level.getLevel().getServer().getStructureManager();
        StructureTemplate structuretemplate = structuretemplatemanager.getOrCreate(config.fossilStructures.get(i));
        StructureTemplate structuretemplate1 = structuretemplatemanager.getOrCreate(config.overlayStructures.get(i));
        ChunkPos chunkpos = new ChunkPos(origin);
        BoundingBox boundingbox = new BoundingBox(
                chunkpos.getMinBlockX() - 16,
                level.getMinBuildHeight(),
                chunkpos.getMinBlockZ() - 16,
                chunkpos.getMaxBlockX() + 16,
                level.getMaxBuildHeight(),
                chunkpos.getMaxBlockZ() + 16
        );
        StructurePlaceSettings structureplacesettings = new StructurePlaceSettings().setRotation(rotation).setBoundingBox(boundingbox).setRandom(random);
        Vec3i vec3i = structuretemplate.getSize(rotation);
        BlockPos blockpos1 = origin.offset(-vec3i.getX() / 2, 0, -vec3i.getZ() / 2);
        int j = origin.getY();

        for (int k = 0; k < vec3i.getX(); k++) {
            for (int l = 0; l < vec3i.getZ(); l++) {
                j = Math.min(j, level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, blockpos1.getX() + k, blockpos1.getZ() + l));
            }
        }

        int i1 = j;
        BlockPos blockpos2 = structuretemplate.getZeroPositionWithTransform(blockpos1.atY(i1), Mirror.NONE, rotation);
        if (countEmptyCorners(level, structuretemplate.getBoundingBox(structureplacesettings, blockpos2))
                > config.maxEmptyCornersAllowed) {
            return false;
        } else {
            structureplacesettings.clearProcessors();
            config.fossilProcessors.value().list().forEach(structureplacesettings::addProcessor);
            structuretemplate.placeInWorld(level, blockpos2, blockpos2, structureplacesettings, random, 4);
            structureplacesettings.clearProcessors();
            config.overlayProcessors.value().list().forEach(structureplacesettings::addProcessor);
            structuretemplate1.placeInWorld(level, blockpos2, blockpos2, structureplacesettings, random, 4);
            return true;
        }
    }

    private static int countEmptyCorners(WorldGenLevel level, BoundingBox boundingBox) {
        MutableInt mutableint = new MutableInt(0);
        boundingBox.forAllCorners(p_284921_ -> {
            BlockState blockstate = level.getBlockState(p_284921_);
            if (blockstate.isAir() || blockstate.is(Blocks.LAVA) || blockstate.is(Blocks.WATER)) {
                mutableint.add(1);
            }
        });
        return mutableint.getValue();
    }

}
