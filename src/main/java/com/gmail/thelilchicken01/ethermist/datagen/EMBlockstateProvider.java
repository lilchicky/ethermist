package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.gmail.thelilchicken01.ethermist.datagen.DataGenerators.*;

public class EMBlockstateProvider extends BlockStateProvider {

    public EMBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Ethermist.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(EMBlocks.GLIMMERBUG_HIVE, null);

        // Etherstone
        simpleBlock(EMBlocks.MOLTEN_ETHERSTONE, null);

        stairsBlockFolder(EMBlocks.ETHERSTONE_STAIRS.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get(), ETHERSTONE), ETHERSTONE);
        slabBlockFolder(EMBlocks.ETHERSTONE_SLAB.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get(), ETHERSTONE), blockTextureFolder(EMBlocks.ETHERSTONE.get(), ETHERSTONE), ETHERSTONE);
        buttonBlockFolder(EMBlocks.ETHERSTONE_BUTTON.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get(), ETHERSTONE), ETHERSTONE);
        pressurePlateBlockFolder(EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get(), ETHERSTONE), ETHERSTONE);
        wallBlock(EMBlocks.ETHERSTONE_WALL.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get(), ETHERSTONE));
        blockItem(EMBlocks.ETHERSTONE_STAIRS, ETHERSTONE);
        blockItem(EMBlocks.ETHERSTONE_SLAB, ETHERSTONE);
        blockItem(EMBlocks.ETHERSTONE_PRESSURE_PLATE, ETHERSTONE);

        simpleBlock(EMBlocks.ETHERSTONE_BRICKS, null);
        stairsBlock(EMBlocks.ETHERSTONE_BRICK_STAIRS.get(), blockTexture(EMBlocks.ETHERSTONE_BRICKS.get()));
        slabBlock(EMBlocks.ETHERSTONE_BRICK_SLAB.get(), blockTexture(EMBlocks.ETHERSTONE_BRICKS.get()), blockTexture(EMBlocks.ETHERSTONE_BRICKS.get()));
        wallBlock(EMBlocks.ETHERSTONE_BRICK_WALL.get(), blockTexture(EMBlocks.ETHERSTONE_BRICKS.get()));
        blockItem(EMBlocks.ETHERSTONE_BRICK_STAIRS, null);
        blockItem(EMBlocks.ETHERSTONE_BRICK_SLAB, null);
        
        // Cobbled Etherstone
        simpleBlock(EMBlocks.COBBLED_ETHERSTONE, null);
        stairsBlock(EMBlocks.COBBLED_ETHERSTONE_STAIRS.get(), blockTexture(EMBlocks.COBBLED_ETHERSTONE.get()));
        slabBlock(EMBlocks.COBBLED_ETHERSTONE_SLAB.get(), blockTexture(EMBlocks.COBBLED_ETHERSTONE.get()), blockTexture(EMBlocks.COBBLED_ETHERSTONE.get()));
        wallBlock(EMBlocks.COBBLED_ETHERSTONE_WALL.get(), blockTexture(EMBlocks.COBBLED_ETHERSTONE.get()));
        blockItem(EMBlocks.COBBLED_ETHERSTONE_STAIRS, null);
        blockItem(EMBlocks.COBBLED_ETHERSTONE_SLAB, null);

        // Mossy Cobbled Etherstone
        simpleBlock(EMBlocks.MOSSY_COBBLED_ETHERSTONE, null);
        stairsBlock(EMBlocks.MOSSY_COBBLED_ETHERSTONE_STAIRS.get(), blockTexture(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get()));
        slabBlock(EMBlocks.MOSSY_COBBLED_ETHERSTONE_SLAB.get(), blockTexture(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get()), blockTexture(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get()));
        wallBlock(EMBlocks.MOSSY_COBBLED_ETHERSTONE_WALL.get(), blockTexture(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get()));
        blockItem(EMBlocks.MOSSY_COBBLED_ETHERSTONE_STAIRS, null);
        blockItem(EMBlocks.MOSSY_COBBLED_ETHERSTONE_SLAB, null);

        // Glimmering Ancient Wood
        logBlock((RotatedPillarBlock) EMBlocks.GLIMMERING_ANCIENT_LOG.get(), GLIMMERING_WOOD);
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get(), GLIMMERING_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.GLIMMERING_ANCIENT_WOOD.get(), EMBlocks.GLIMMERING_ANCIENT_LOG.get(), GLIMMERING_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD.get(), EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG.get(), GLIMMERING_WOOD);

        logBlock((RotatedPillarBlock) EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(), GLIMMERING_WOOD);
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(), GLIMMERING_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(), EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(), GLIMMERING_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD.get(), EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG.get(), GLIMMERING_WOOD);

        simpleBlock(EMBlocks.GLIMMERING_ANCIENT_PLANKS, GLIMMERING_WOOD);
        leavesBlock(EMBlocks.ANCIENT_LEAVES);
        saplingBlock(EMBlocks.GLIMMERING_ANCIENT_SAPLING, GLIMMERING_WOOD);

        stairsBlockFolder(EMBlocks.GLIMMERING_ANCIENT_STAIRS.get(), blockTextureFolder(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), GLIMMERING_WOOD), GLIMMERING_WOOD);
        slabBlockFolder(EMBlocks.GLIMMERING_ANCIENT_SLAB.get(), blockTextureFolder(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), GLIMMERING_WOOD), blockTextureFolder(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), GLIMMERING_WOOD), GLIMMERING_WOOD);
        buttonBlockFolder(EMBlocks.GLIMMERING_ANCIENT_BUTTON.get(), blockTextureFolder(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), GLIMMERING_WOOD), GLIMMERING_WOOD);
        pressurePlateBlockFolder(EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), GLIMMERING_WOOD), GLIMMERING_WOOD);
        fenceBlockFolder(EMBlocks.GLIMMERING_ANCIENT_FENCE.get(), blockTextureFolder(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), GLIMMERING_WOOD), GLIMMERING_WOOD);
        fenceGateBlockFolder(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE.get(), blockTextureFolder(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get(), GLIMMERING_WOOD), GLIMMERING_WOOD);
        doorBlock(EMBlocks.GLIMMERING_ANCIENT_DOOR.get(), GLIMMERING_WOOD);
        trapdoorBlock(EMBlocks.GLIMMERING_ANCIENT_TRAPDOOR.get(), GLIMMERING_WOOD);

        blockItem(EMBlocks.GLIMMERING_ANCIENT_STAIRS, GLIMMERING_WOOD);
        blockItem(EMBlocks.GLIMMERING_ANCIENT_SLAB, GLIMMERING_WOOD);
        blockItem(EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE, GLIMMERING_WOOD);
        blockItem(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE, GLIMMERING_WOOD);
        blockItem(EMBlocks.GLIMMERING_ANCIENT_TRAPDOOR, "_bottom", GLIMMERING_WOOD);
        blockItem(EMBlocks.GLIMMERING_ANCIENT_LOG, GLIMMERING_WOOD);
        blockItem(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG, GLIMMERING_WOOD);
        blockItem(EMBlocks.GLIMMERING_ANCIENT_WOOD, GLIMMERING_WOOD);
        blockItem(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD, GLIMMERING_WOOD);
        blockItem(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG, GLIMMERING_WOOD);
        blockItem(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG, GLIMMERING_WOOD);
        blockItem(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD, GLIMMERING_WOOD);
        blockItem(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD, GLIMMERING_WOOD);
        blockItem(EMBlocks.GLIMMERING_ANCIENT_SAPLING, GLIMMERING_WOOD);

        // Ancient Wood
        logBlock((RotatedPillarBlock) EMBlocks.ANCIENT_LOG.get(), ANCIENT_WOOD);
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_ANCIENT_LOG.get(), ANCIENT_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.ANCIENT_WOOD.get(), EMBlocks.ANCIENT_LOG.get(), ANCIENT_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.STRIPPED_ANCIENT_WOOD.get(), EMBlocks.STRIPPED_ANCIENT_LOG.get(), ANCIENT_WOOD);
        
        simpleBlock(EMBlocks.ANCIENT_PLANKS, ANCIENT_WOOD);
        saplingBlock(EMBlocks.ANCIENT_SAPLING, ANCIENT_WOOD);

        stairsBlockFolder(EMBlocks.ANCIENT_STAIRS.get(), blockTextureFolder(EMBlocks.ANCIENT_PLANKS.get(), ANCIENT_WOOD), ANCIENT_WOOD);
        slabBlockFolder(EMBlocks.ANCIENT_SLAB.get(), blockTextureFolder(EMBlocks.ANCIENT_PLANKS.get(), ANCIENT_WOOD), blockTextureFolder(EMBlocks.ANCIENT_PLANKS.get(), ANCIENT_WOOD), ANCIENT_WOOD);
        buttonBlockFolder(EMBlocks.ANCIENT_BUTTON.get(), blockTextureFolder(EMBlocks.ANCIENT_PLANKS.get(), ANCIENT_WOOD), ANCIENT_WOOD);
        pressurePlateBlockFolder(EMBlocks.ANCIENT_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.ANCIENT_PLANKS.get(), ANCIENT_WOOD), ANCIENT_WOOD);
        fenceBlockFolder(EMBlocks.ANCIENT_FENCE.get(), blockTextureFolder(EMBlocks.ANCIENT_PLANKS.get(), ANCIENT_WOOD), ANCIENT_WOOD);
        fenceGateBlockFolder(EMBlocks.ANCIENT_FENCE_GATE.get(), blockTextureFolder(EMBlocks.ANCIENT_PLANKS.get(), ANCIENT_WOOD), ANCIENT_WOOD);
        doorBlock(EMBlocks.ANCIENT_DOOR.get(), ANCIENT_WOOD);
        trapdoorBlock(EMBlocks.ANCIENT_TRAPDOOR.get(), ANCIENT_WOOD);

        blockItem(EMBlocks.ANCIENT_STAIRS, ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_SLAB, ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_PRESSURE_PLATE, ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_FENCE_GATE, ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_TRAPDOOR, "_bottom", ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_LOG, ANCIENT_WOOD);
        blockItem(EMBlocks.STRIPPED_ANCIENT_LOG, ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_WOOD, ANCIENT_WOOD);
        blockItem(EMBlocks.STRIPPED_ANCIENT_WOOD, ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_SAPLING, ANCIENT_WOOD);

        // Slimy Wood
        logBlock((RotatedPillarBlock) EMBlocks.SLIMY_LOG.get(), SLIMY_WOOD);
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_SLIMY_LOG.get(), SLIMY_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.SLIMY_WOOD.get(), EMBlocks.SLIMY_LOG.get(), SLIMY_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.STRIPPED_SLIMY_WOOD.get(), EMBlocks.STRIPPED_SLIMY_LOG.get(), SLIMY_WOOD);

        simpleBlock(EMBlocks.SLIMY_PLANKS, SLIMY_WOOD);
        leavesBlock(EMBlocks.SLIMY_LEAVES);
        saplingBlock(EMBlocks.SLIMY_SAPLING, SLIMY_WOOD);

        stairsBlockFolder(EMBlocks.SLIMY_STAIRS.get(), blockTextureFolder(EMBlocks.SLIMY_PLANKS.get(), SLIMY_WOOD), SLIMY_WOOD);
        slabBlockFolder(EMBlocks.SLIMY_SLAB.get(), blockTextureFolder(EMBlocks.SLIMY_PLANKS.get(), SLIMY_WOOD), blockTextureFolder(EMBlocks.SLIMY_PLANKS.get(), SLIMY_WOOD), SLIMY_WOOD);
        buttonBlockFolder(EMBlocks.SLIMY_BUTTON.get(), blockTextureFolder(EMBlocks.SLIMY_PLANKS.get(), SLIMY_WOOD), SLIMY_WOOD);
        pressurePlateBlockFolder(EMBlocks.SLIMY_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.SLIMY_PLANKS.get(), SLIMY_WOOD), SLIMY_WOOD);
        fenceBlockFolder(EMBlocks.SLIMY_FENCE.get(), blockTextureFolder(EMBlocks.SLIMY_PLANKS.get(), SLIMY_WOOD), SLIMY_WOOD);
        fenceGateBlockFolder(EMBlocks.SLIMY_FENCE_GATE.get(), blockTextureFolder(EMBlocks.SLIMY_PLANKS.get(), SLIMY_WOOD), SLIMY_WOOD);
        doorBlock(EMBlocks.SLIMY_DOOR.get(), SLIMY_WOOD);
        trapdoorBlock(EMBlocks.SLIMY_TRAPDOOR.get(), SLIMY_WOOD);

        blockItem(EMBlocks.SLIMY_STAIRS, SLIMY_WOOD);
        blockItem(EMBlocks.SLIMY_SLAB, SLIMY_WOOD);
        blockItem(EMBlocks.SLIMY_PRESSURE_PLATE, SLIMY_WOOD);
        blockItem(EMBlocks.SLIMY_FENCE_GATE, SLIMY_WOOD);
        blockItem(EMBlocks.SLIMY_TRAPDOOR, "_bottom", SLIMY_WOOD);
        blockItem(EMBlocks.SLIMY_LOG, SLIMY_WOOD);
        blockItem(EMBlocks.STRIPPED_SLIMY_LOG, SLIMY_WOOD);
        blockItem(EMBlocks.SLIMY_WOOD, SLIMY_WOOD);
        blockItem(EMBlocks.STRIPPED_SLIMY_WOOD, SLIMY_WOOD);
        blockItem(EMBlocks.SLIMY_SAPLING, SLIMY_WOOD);

        // Frostpine Wood
        logBlock((RotatedPillarBlock) EMBlocks.FROSTPINE_LOG.get(), FROSTPINE_WOOD);
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_FROSTPINE_LOG.get(), FROSTPINE_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.FROSTPINE_WOOD.get(), EMBlocks.FROSTPINE_LOG.get(), FROSTPINE_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.STRIPPED_FROSTPINE_WOOD.get(), EMBlocks.STRIPPED_FROSTPINE_LOG.get(), FROSTPINE_WOOD);

        simpleBlock(EMBlocks.FROSTPINE_PLANKS, FROSTPINE_WOOD);
        leavesBlock(EMBlocks.FROSTPINE_LEAVES);
        saplingBlock(EMBlocks.FROSTPINE_SAPLING, FROSTPINE_WOOD);

        stairsBlockFolder(EMBlocks.FROSTPINE_STAIRS.get(), blockTextureFolder(EMBlocks.FROSTPINE_PLANKS.get(), FROSTPINE_WOOD), FROSTPINE_WOOD);
        slabBlockFolder(EMBlocks.FROSTPINE_SLAB.get(), blockTextureFolder(EMBlocks.FROSTPINE_PLANKS.get(), FROSTPINE_WOOD), blockTextureFolder(EMBlocks.FROSTPINE_PLANKS.get(), FROSTPINE_WOOD), FROSTPINE_WOOD);
        buttonBlockFolder(EMBlocks.FROSTPINE_BUTTON.get(), blockTextureFolder(EMBlocks.FROSTPINE_PLANKS.get(), FROSTPINE_WOOD), FROSTPINE_WOOD);
        pressurePlateBlockFolder(EMBlocks.FROSTPINE_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.FROSTPINE_PLANKS.get(), FROSTPINE_WOOD), FROSTPINE_WOOD);
        fenceBlockFolder(EMBlocks.FROSTPINE_FENCE.get(), blockTextureFolder(EMBlocks.FROSTPINE_PLANKS.get(), FROSTPINE_WOOD), FROSTPINE_WOOD);
        fenceGateBlockFolder(EMBlocks.FROSTPINE_FENCE_GATE.get(), blockTextureFolder(EMBlocks.FROSTPINE_PLANKS.get(), FROSTPINE_WOOD), FROSTPINE_WOOD);
        doorBlock(EMBlocks.FROSTPINE_DOOR.get(), FROSTPINE_WOOD);
        trapdoorBlock(EMBlocks.FROSTPINE_TRAPDOOR.get(), FROSTPINE_WOOD);

        blockItem(EMBlocks.FROSTPINE_STAIRS, FROSTPINE_WOOD);
        blockItem(EMBlocks.FROSTPINE_SLAB, FROSTPINE_WOOD);
        blockItem(EMBlocks.FROSTPINE_PRESSURE_PLATE, FROSTPINE_WOOD);
        blockItem(EMBlocks.FROSTPINE_FENCE_GATE, FROSTPINE_WOOD);
        blockItem(EMBlocks.FROSTPINE_TRAPDOOR, "_bottom", FROSTPINE_WOOD);
        blockItem(EMBlocks.FROSTPINE_LOG, FROSTPINE_WOOD);
        blockItem(EMBlocks.STRIPPED_FROSTPINE_LOG, FROSTPINE_WOOD);
        blockItem(EMBlocks.FROSTPINE_WOOD, FROSTPINE_WOOD);
        blockItem(EMBlocks.STRIPPED_FROSTPINE_WOOD, FROSTPINE_WOOD);
        blockItem(EMBlocks.FROSTPINE_SAPLING, FROSTPINE_WOOD);

        // Amberwood Wood
        logBlock((RotatedPillarBlock) EMBlocks.AMBERWOOD_LOG.get(), AMBERWOOD_WOOD);
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_AMBERWOOD_LOG.get(), AMBERWOOD_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.AMBERWOOD_WOOD.get(), EMBlocks.AMBERWOOD_LOG.get(), AMBERWOOD_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.STRIPPED_AMBERWOOD_WOOD.get(), EMBlocks.STRIPPED_AMBERWOOD_LOG.get(), AMBERWOOD_WOOD);

        simpleBlock(EMBlocks.AMBERWOOD_PLANKS, AMBERWOOD_WOOD);
        leavesBlock(EMBlocks.RED_AMBERWOOD_LEAVES);
        leavesBlock(EMBlocks.ORANGE_AMBERWOOD_LEAVES);
        leavesBlock(EMBlocks.YELLOW_AMBERWOOD_LEAVES);
        leavesBlock(EMBlocks.GREEN_AMBERWOOD_LEAVES);
        saplingBlock(EMBlocks.GREEN_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);
        saplingBlock(EMBlocks.RED_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);
        saplingBlock(EMBlocks.ORANGE_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);
        saplingBlock(EMBlocks.YELLOW_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);

        stairsBlockFolder(EMBlocks.AMBERWOOD_STAIRS.get(), blockTextureFolder(EMBlocks.AMBERWOOD_PLANKS.get(), AMBERWOOD_WOOD), AMBERWOOD_WOOD);
        slabBlockFolder(EMBlocks.AMBERWOOD_SLAB.get(), blockTextureFolder(EMBlocks.AMBERWOOD_PLANKS.get(), AMBERWOOD_WOOD), blockTextureFolder(EMBlocks.AMBERWOOD_PLANKS.get(), AMBERWOOD_WOOD), AMBERWOOD_WOOD);
        buttonBlockFolder(EMBlocks.AMBERWOOD_BUTTON.get(), blockTextureFolder(EMBlocks.AMBERWOOD_PLANKS.get(), AMBERWOOD_WOOD), AMBERWOOD_WOOD);
        pressurePlateBlockFolder(EMBlocks.AMBERWOOD_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.AMBERWOOD_PLANKS.get(), AMBERWOOD_WOOD), AMBERWOOD_WOOD);
        fenceBlockFolder(EMBlocks.AMBERWOOD_FENCE.get(), blockTextureFolder(EMBlocks.AMBERWOOD_PLANKS.get(), AMBERWOOD_WOOD), AMBERWOOD_WOOD);
        fenceGateBlockFolder(EMBlocks.AMBERWOOD_FENCE_GATE.get(), blockTextureFolder(EMBlocks.AMBERWOOD_PLANKS.get(), AMBERWOOD_WOOD), AMBERWOOD_WOOD);
        doorBlock(EMBlocks.AMBERWOOD_DOOR.get(), AMBERWOOD_WOOD);
        trapdoorBlock(EMBlocks.AMBERWOOD_TRAPDOOR.get(), AMBERWOOD_WOOD);

        blockItem(EMBlocks.AMBERWOOD_STAIRS, AMBERWOOD_WOOD);
        blockItem(EMBlocks.AMBERWOOD_SLAB, AMBERWOOD_WOOD);
        blockItem(EMBlocks.AMBERWOOD_PRESSURE_PLATE, AMBERWOOD_WOOD);
        blockItem(EMBlocks.AMBERWOOD_FENCE_GATE, AMBERWOOD_WOOD);
        blockItem(EMBlocks.AMBERWOOD_TRAPDOOR, "_bottom", AMBERWOOD_WOOD);
        blockItem(EMBlocks.AMBERWOOD_LOG, AMBERWOOD_WOOD);
        blockItem(EMBlocks.STRIPPED_AMBERWOOD_LOG, AMBERWOOD_WOOD);
        blockItem(EMBlocks.AMBERWOOD_WOOD, AMBERWOOD_WOOD);
        blockItem(EMBlocks.STRIPPED_AMBERWOOD_WOOD, AMBERWOOD_WOOD);
        blockItem(EMBlocks.GREEN_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);

        // Ashen Wood
        logBlock((RotatedPillarBlock) EMBlocks.CHARRED_LOG.get(), ASHEN_WOOD);
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_CHARRED_LOG.get(), ASHEN_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.CHARRED_WOOD.get(), EMBlocks.CHARRED_LOG.get(), ASHEN_WOOD);
        woodBlock((RotatedPillarBlock) EMBlocks.STRIPPED_CHARRED_WOOD.get(), EMBlocks.STRIPPED_CHARRED_LOG.get(), ASHEN_WOOD);

        simpleBlock(EMBlocks.CHARRED_PLANKS, ASHEN_WOOD);
        saplingBlock(EMBlocks.CHARRED_SAPLING, ASHEN_WOOD);

        stairsBlockFolder(EMBlocks.CHARRED_STAIRS.get(), blockTextureFolder(EMBlocks.CHARRED_PLANKS.get(), ASHEN_WOOD), ASHEN_WOOD);
        slabBlockFolder(EMBlocks.CHARRED_SLAB.get(), blockTextureFolder(EMBlocks.CHARRED_PLANKS.get(), ASHEN_WOOD), blockTextureFolder(EMBlocks.CHARRED_PLANKS.get(), ASHEN_WOOD), ASHEN_WOOD);
        buttonBlockFolder(EMBlocks.CHARRED_BUTTON.get(), blockTextureFolder(EMBlocks.CHARRED_PLANKS.get(), ASHEN_WOOD), ASHEN_WOOD);
        pressurePlateBlockFolder(EMBlocks.CHARRED_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.CHARRED_PLANKS.get(), ASHEN_WOOD), ASHEN_WOOD);
        fenceBlockFolder(EMBlocks.CHARRED_FENCE.get(), blockTextureFolder(EMBlocks.CHARRED_PLANKS.get(), ASHEN_WOOD), ASHEN_WOOD);
        fenceGateBlockFolder(EMBlocks.CHARRED_FENCE_GATE.get(), blockTextureFolder(EMBlocks.CHARRED_PLANKS.get(), ASHEN_WOOD), ASHEN_WOOD);
        doorBlock(EMBlocks.CHARRED_DOOR.get(), ASHEN_WOOD);
        trapdoorBlock(EMBlocks.CHARRED_TRAPDOOR.get(), ASHEN_WOOD);

        blockItem(EMBlocks.CHARRED_STAIRS, ASHEN_WOOD);
        blockItem(EMBlocks.CHARRED_SLAB, ASHEN_WOOD);
        blockItem(EMBlocks.CHARRED_PRESSURE_PLATE, ASHEN_WOOD);
        blockItem(EMBlocks.CHARRED_FENCE_GATE, ASHEN_WOOD);
        blockItem(EMBlocks.CHARRED_TRAPDOOR, "_bottom", ASHEN_WOOD);
        blockItem(EMBlocks.CHARRED_LOG, ASHEN_WOOD);
        blockItem(EMBlocks.STRIPPED_CHARRED_LOG, ASHEN_WOOD);
        blockItem(EMBlocks.CHARRED_WOOD, ASHEN_WOOD);
        blockItem(EMBlocks.STRIPPED_CHARRED_WOOD, ASHEN_WOOD);
        blockItem(EMBlocks.CHARRED_SAPLING, ASHEN_WOOD);

        // Sparkling Sand
        simpleBlock(EMBlocks.SPARKLING_SANDSTONE_BRICKS, null);

        stairsBlockFolder(EMBlocks.SPARKLING_SANDSTONE_STAIRS.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get(), SPARKLING_SANDSTONE), SPARKLING_SANDSTONE);
        slabBlockFolder(EMBlocks.SPARKLING_SANDSTONE_SLAB.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get(), SPARKLING_SANDSTONE), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get(), SPARKLING_SANDSTONE), SPARKLING_SANDSTONE);
        buttonBlockFolder(EMBlocks.SPARKLING_SANDSTONE_BUTTON.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get(), SPARKLING_SANDSTONE), SPARKLING_SANDSTONE);
        pressurePlateBlockFolder(EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get(), SPARKLING_SANDSTONE), SPARKLING_SANDSTONE);
        wallBlock(EMBlocks.SPARKLING_SANDSTONE_WALL.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get(), SPARKLING_SANDSTONE));
        blockItem(EMBlocks.SPARKLING_SANDSTONE_STAIRS, SPARKLING_SANDSTONE);
        blockItem(EMBlocks.SPARKLING_SANDSTONE_SLAB, SPARKLING_SANDSTONE);
        blockItem(EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE, SPARKLING_SANDSTONE);

        stairsBlock(EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS.get(), blockTexture(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get()));
        slabBlock(EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB.get(), blockTexture(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get()), blockTexture(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get()));
        wallBlock(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL.get(), blockTexture(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get()));
        blockItem(EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS, null);
        blockItem(EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB, null);

        // Timeworn Sand
        simpleBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE, null);

        stairsBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        slabBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        buttonBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        pressurePlateBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        wallBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        blockItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS, null);
        blockItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB, null);
        blockItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE, null);
        
        stairsBlockFolder(EMBlocks.TIMEWORN_SANDSTONE_STAIRS.get(), blockTextureFolder(EMBlocks.TIMEWORN_SANDSTONE.get(), TIMEWORN_SANDSTONE), TIMEWORN_SANDSTONE);
        slabBlockFolder(EMBlocks.TIMEWORN_SANDSTONE_SLAB.get(), blockTextureFolder(EMBlocks.TIMEWORN_SANDSTONE.get(), TIMEWORN_SANDSTONE), blockTextureFolder(EMBlocks.TIMEWORN_SANDSTONE.get(), TIMEWORN_SANDSTONE), TIMEWORN_SANDSTONE);
        wallBlock(EMBlocks.TIMEWORN_SANDSTONE_WALL.get(), blockTextureFolder(EMBlocks.TIMEWORN_SANDSTONE.get(), TIMEWORN_SANDSTONE));
        blockItem(EMBlocks.TIMEWORN_SANDSTONE_STAIRS, TIMEWORN_SANDSTONE);
        blockItem(EMBlocks.TIMEWORN_SANDSTONE_SLAB, TIMEWORN_SANDSTONE);

        // Rich Dirt
        getVariantBuilder(EMBlocks.RICH_GRASS_BLOCK.get()).forAllStates((state -> {
            boolean snowy = state.getValue(BlockStateProperties.SNOWY);

            return ConfiguredModel.builder()
                    .modelFile(models().cubeBottomTop("rich_grass_block" + (snowy ? "_snowy" : ""),
                            modLoc("block/rich_grass_block_side" + (snowy ? "_snowy" : "")),
                            modLoc("block/rich_dirt/rich_dirt"),
                            modLoc("block/rich_grass_block_top" + (snowy ? "_snowy" : ""))
                    )).build();
        }));

        blockItem(EMBlocks.RICH_GRASS_BLOCK, null);

        // Flowers
        plantBlock(EMBlocks.GLIMMERBUD);
        flowerPotBlock(EMBlocks.GLIMMERBUD_FLOWER_POT, EMBlocks.GLIMMERBUD);

        plantBlock(EMBlocks.NIGHTBELL);
        flowerPotBlock(EMBlocks.NIGHTBELL_FLOWER_POT, EMBlocks.NIGHTBELL);

        plantBlock(EMBlocks.WITCH_LAVENDER);
        flowerPotBlock(EMBlocks.WITCH_LAVENDER_FLOWER_POT, EMBlocks.WITCH_LAVENDER);

        plantBlock(EMBlocks.DAWNING_HYACINTH);
        flowerPotBlock(EMBlocks.DAWNING_HYACINTH_FLOWER_POT, EMBlocks.DAWNING_HYACINTH);

        plantBlock(EMBlocks.SLIMY_ALLIUM);
        plantBlock(EMBlocks.SMALL_ABYSSAL_MUSHROOM);
        doublePlantBlock(EMBlocks.TALL_ABYSSAL_MUSHROOM);
        plantBlock(EMBlocks.ABYSSAL_MUSHROOM);

        plantBlock(EMBlocks.RICH_GRASS);
        doublePlantBlock(EMBlocks.RICH_TALL_GRASS);

        // Abyssal Mushrooms
        simpleBlock(EMBlocks.LARGE_BLUE_ABYSSAL_MUSHROOM_TOP, null);
        simpleBlock(EMBlocks.LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP, null);
        woodBlock(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get(), EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM.get(), ABYSSAL_MUSHROOM);
        woodBlock((RotatedPillarBlock) EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS.get(), EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS.get(), ABYSSAL_MUSHROOM);

        blockItem(EMBlocks.LARGE_ABYSSAL_MUSHROOM_STEM, ABYSSAL_MUSHROOM);

        simpleBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM, ABYSSAL_MUSHROOM);

        stairsBlockFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS.get(), blockTextureFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), ABYSSAL_MUSHROOM), ABYSSAL_MUSHROOM);
        slabBlockFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get(), blockTextureFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), ABYSSAL_MUSHROOM), blockTextureFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), ABYSSAL_MUSHROOM), ABYSSAL_MUSHROOM);
        buttonBlockFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get(), blockTextureFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), ABYSSAL_MUSHROOM), ABYSSAL_MUSHROOM);
        pressurePlateBlockFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), ABYSSAL_MUSHROOM), ABYSSAL_MUSHROOM);
        fenceBlockFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get(), blockTextureFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), ABYSSAL_MUSHROOM), ABYSSAL_MUSHROOM);
        fenceGateBlockFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get(), blockTextureFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get(), ABYSSAL_MUSHROOM), ABYSSAL_MUSHROOM);
        doorBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get(), ABYSSAL_MUSHROOM);
        trapdoorBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR.get(), ABYSSAL_MUSHROOM);

        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS, ABYSSAL_MUSHROOM);
        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB, ABYSSAL_MUSHROOM);
        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE, ABYSSAL_MUSHROOM);
        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE, ABYSSAL_MUSHROOM);
        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR, "_bottom", ABYSSAL_MUSHROOM);
        blockItem(EMBlocks.LARGE_ABYSSAL_MUSHROOM_GILLS, ABYSSAL_MUSHROOM);

    }

    private void simpleBlock(DeferredBlock<?> block, @Nullable String folder) {
        ResourceLocation name = BuiltInRegistries.BLOCK.getKey(block.get());
        simpleBlockWithItem(block.get(), models().cubeAll(
                folder != null ? "ethermist:block/" + folder + "/" + name.getPath() : name.getPath(),
                folder != null ? this.blockTextureFolder(block.get(), folder) : blockTexture(block.get())
        ));
    }

    private void blockItem(DeferredBlock<?> block, @Nullable String folder) {
        String path = folder == null ? "ethermist:block/" + block.getId().getPath() : "ethermist:block/" + folder + "/" + block.getId().getPath();
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(path));
    }

    private void blockItem(DeferredBlock<?> block, String appendix, @Nullable String folder) {
        String path = folder == null ? "ethermist:block/" + block.getId().getPath() + appendix : "ethermist:block/" + folder + "/" + block.getId().getPath() + appendix;
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(path));
    }

    private void saplingBlock(DeferredBlock<Block> block, @Nullable String folder) {
        ResourceLocation name = BuiltInRegistries.BLOCK.getKey(block.get());
        simpleBlock(block.get(), models().cross(
                folder != null ? "ethermist:block/" + folder + "/" + name.getPath() : name.getPath(),
                folder != null ? this.blockTextureFolder(block.get(), folder) : blockTexture(block.get())
        ).renderType("cutout"));
    }

    private void plantBlock(DeferredBlock<?> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void plantBlockCustomTexture(DeferredBlock<?> blockRegistryObject, String loc) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(),
                        ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + loc)).renderType("cutout"));
    }

    public void doublePlantBlock(DeferredBlock<?> block) {
        Function<BlockState, ConfiguredModel[]> function = state -> customDoubleBlockStates(state, block);

        getVariantBuilder(block.get()).forAllStates(function);
    }


    private ConfiguredModel[] customDoubleBlockStates(BlockState state, DeferredBlock<?> block) {
        DoubleBlockHalf blockHalf = state.getValue(TallFlowerBlock.HALF);
        List<ConfiguredModel> models = new ArrayList<>();
        String lowerModelName = BuiltInRegistries.BLOCK.getKey(block.get()).getPath() + "_lower";
        String upperModelName = BuiltInRegistries.BLOCK.getKey(block.get()).getPath() + "_upper";

        if (blockHalf == DoubleBlockHalf.LOWER) {
            models.add(new ConfiguredModel(models().cross(lowerModelName,
                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + lowerModelName)).renderType("cutout")));
        } else if (blockHalf == DoubleBlockHalf.UPPER) {
            models.add(new ConfiguredModel(models().cross(upperModelName,
                    ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + upperModelName)).renderType("cutout")));
        }

        return models.toArray(new ConfiguredModel[0]);
    }

    private void flowerPotBlock(DeferredBlock<FlowerPotBlock> block, DeferredBlock<FlowerBlock> flower) {
        simpleBlock(block.get(), models().withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), "minecraft:block/flower_pot_cross")
                .texture("plant", blockTexture(flower.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void woodBlock(RotatedPillarBlock block, Block log, String folder) {
        ResourceLocation texture = blockTextureFolder(log, folder);
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        axisBlock(block, models().cubeColumn(baseName, texture, texture),
                models().cubeColumnHorizontal(baseName + "_horizontal", texture, texture));
    }

    private void logBlock(RotatedPillarBlock block, String folder) {
        ResourceLocation texture = blockTextureFolder(block, folder);
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        axisBlock(block, models().cubeColumn(baseName, texture, ResourceLocation.parse(texture + "_top")),
                models().cubeColumnHorizontal(baseName + "_horizontal", texture, ResourceLocation.parse(texture + "_top")));
    }

    private void doorBlock(DoorBlock block, String folder) {
        ResourceLocation name = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation top = modLoc("block/" + folder + "/" + name.getPath() + "_top");
        ResourceLocation bottom = modLoc("block/" + folder + "/" + name.getPath() + "_bottom");
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();

        ModelFile bottomLeft = (models().doorBottomLeft(baseName + "_bottom_left", bottom, top)).renderType("cutout");
        ModelFile bottomLeftOpen = (models().doorBottomLeftOpen(baseName + "_bottom_left_open", bottom, top)).renderType("cutout");
        ModelFile bottomRight = (models().doorBottomRight(baseName + "_bottom_right", bottom, top)).renderType("cutout");
        ModelFile bottomRightOpen = (models().doorBottomRightOpen(baseName + "_bottom_right_open", bottom, top)).renderType("cutout");
        ModelFile topLeft = (models().doorTopLeft(baseName + "_top_left", bottom, top)).renderType("cutout");
        ModelFile topLeftOpen = (models().doorTopLeftOpen(baseName + "_top_left_open", bottom, top)).renderType("cutout");
        ModelFile topRight = (models().doorTopRight(baseName + "_top_right", bottom, top)).renderType("cutout");
        ModelFile topRightOpen = (models().doorTopRightOpen(baseName + "_top_right_open", bottom, top)).renderType("cutout");
        this.doorBlock(block, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
    }

    private void trapdoorBlock(TrapDoorBlock block, String folder) {
        ResourceLocation texture = blockTextureFolder(block, folder);
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        ModelFile bottom = models().trapdoorOrientableBottom(baseName + "_bottom", texture).renderType("cutout");
        ModelFile top = models().trapdoorOrientableTop(baseName + "_top", texture).renderType("cutout");
        ModelFile open = models().trapdoorOrientableOpen(baseName + "_open", texture).renderType("cutout");
        trapdoorBlock(block, bottom, top, open, true);
    }

    private void stairsBlockFolder(StairBlock block, ResourceLocation texture, String folder) {
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        ModelFile stairs = this.models().stairs(baseName, texture, texture, texture);
        ModelFile stairsInner = this.models().stairsInner(baseName + "_inner", texture, texture, texture);
        ModelFile stairsOuter = this.models().stairsOuter(baseName + "_outer", texture, texture, texture);
        this.stairsBlock(block, stairs, stairsInner, stairsOuter);
    }

    private void slabBlockFolder(SlabBlock block, ResourceLocation doubleSlab, ResourceLocation texture, String folder) {
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        slabBlock(block,
                this.models().slab(baseName, texture, texture, texture),
                this.models().slabTop(baseName + "_top", texture, texture, texture),
                this.models().getExistingFile(doubleSlab));
    }

    private void buttonBlockFolder(ButtonBlock block, ResourceLocation texture, String folder) {
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        ModelFile button = this.models().button(baseName, texture);
        ModelFile buttonPressed = this.models().buttonPressed(baseName + "_pressed", texture);
        this.buttonBlock(block, button, buttonPressed);
    }

    private void pressurePlateBlockFolder(PressurePlateBlock block, ResourceLocation texture, String folder) {
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        ModelFile pressurePlate = this.models().pressurePlate(baseName, texture);
        ModelFile pressurePlateDown = this.models().pressurePlateDown(baseName + "_down", texture);
        this.pressurePlateBlock(block, pressurePlate, pressurePlateDown);
    }

    private void fenceBlockFolder(FenceBlock block, ResourceLocation texture, String folder) {
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        fourWayBlock(block, this.models().fencePost(baseName + "_post", texture), this.models().fenceSide(baseName + "_side", texture));
    }

    private void fenceGateBlockFolder(FenceGateBlock block, ResourceLocation texture, String folder) {
        String baseName = "block/" + folder + "/" + BuiltInRegistries.BLOCK.getKey(block).getPath();
        ModelFile gate = this.models().fenceGate(baseName, texture);
        ModelFile gateOpen = this.models().fenceGateOpen(baseName + "_open", texture);
        ModelFile gateWall = this.models().fenceGateWall(baseName + "_wall", texture);
        ModelFile gateWallOpen = this.models().fenceGateWallOpen(baseName + "_wall_open", texture);
        fenceGateBlock(block, gate, gateOpen, gateWall, gateWallOpen);
    }

    public ResourceLocation blockTextureFolder(Block block, String folder) {
        ResourceLocation name = BuiltInRegistries.BLOCK.getKey(block);
        return modLoc("block/" + folder + "/" + name.getPath());
    }

}
