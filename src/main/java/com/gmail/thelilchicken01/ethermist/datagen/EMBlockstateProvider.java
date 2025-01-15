package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class EMBlockstateProvider extends BlockStateProvider {

    public EMBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Ethermist.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(EMBlocks.GLIMMERBUG_HIVE);
        simpleBlock(EMBlocks.MIST_GEM_ORE);

        // Etherstone
        simpleBlock(EMBlocks.ETHERSTONE);
        stairsBlock(EMBlocks.ETHERSTONE_STAIRS.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        slabBlock(EMBlocks.ETHERSTONE_SLAB.get(), blockTexture(EMBlocks.ETHERSTONE.get()), blockTexture(EMBlocks.ETHERSTONE.get()));
        buttonBlock(EMBlocks.ETHERSTONE_BUTTON.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        pressurePlateBlock(EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        wallBlock(EMBlocks.ETHERSTONE_WALL.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        blockItem(EMBlocks.ETHERSTONE_STAIRS);
        blockItem(EMBlocks.ETHERSTONE_SLAB);
        blockItem(EMBlocks.ETHERSTONE_PRESSURE_PLATE);


        // Ancient Wood
        logBlock((RotatedPillarBlock) EMBlocks.ANCIENT_LOG.get());
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_ANCIENT_LOG.get());
        axisBlock((RotatedPillarBlock) EMBlocks.ANCIENT_WOOD.get(), blockTexture(EMBlocks.ANCIENT_LOG.get()));
        axisBlock((RotatedPillarBlock) EMBlocks.STRIPPED_ANCIENT_WOOD.get(), blockTexture(EMBlocks.STRIPPED_ANCIENT_LOG.get()));

        simpleBlock(EMBlocks.ANCIENT_PLANKS);
        leavesBlock(EMBlocks.ANCIENT_LEAVES);
        saplingBlock(EMBlocks.ANCIENT_SAPLING);

        stairsBlock(EMBlocks.ANCIENT_STAIRS.get(), blockTexture(EMBlocks.ANCIENT_PLANKS.get()));
        slabBlock(EMBlocks.ANCIENT_SLAB.get(), blockTexture(EMBlocks.ANCIENT_PLANKS.get()), blockTexture(EMBlocks.ANCIENT_PLANKS.get()));
        buttonBlock(EMBlocks.ANCIENT_BUTTON.get(), blockTexture(EMBlocks.ANCIENT_PLANKS.get()));
        pressurePlateBlock(EMBlocks.ANCIENT_PRESSURE_PLATE.get(), blockTexture(EMBlocks.ANCIENT_PLANKS.get()));
        fenceBlock(EMBlocks.ANCIENT_FENCE.get(), blockTexture(EMBlocks.ANCIENT_PLANKS.get()));
        fenceGateBlock(EMBlocks.ANCIENT_FENCE_GATE.get(), blockTexture(EMBlocks.ANCIENT_PLANKS.get()));
        doorBlockWithRenderType(EMBlocks.ANCIENT_DOOR.get(), modLoc("block/ancient_door_bottom"), modLoc("block/ancient_door_top"), "cutout");
        trapdoorBlockWithRenderType(EMBlocks.ANCIENT_TRAPDOOR.get(), modLoc("block/ancient_trapdoor"), true, "cutout");

        blockItem(EMBlocks.ANCIENT_STAIRS);
        blockItem(EMBlocks.ANCIENT_SLAB);
        blockItem(EMBlocks.ANCIENT_PRESSURE_PLATE);
        blockItem(EMBlocks.ANCIENT_FENCE_GATE);
        blockItem(EMBlocks.ANCIENT_TRAPDOOR, "_bottom");
        blockItem(EMBlocks.ANCIENT_LOG);
        blockItem(EMBlocks.STRIPPED_ANCIENT_LOG);
        blockItem(EMBlocks.ANCIENT_WOOD);
        blockItem(EMBlocks.STRIPPED_ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_SAPLING);

        // Rich Dirt
        simpleBlock(EMBlocks.RICH_GRASS.get(), models().cubeBottomTop("rich_grass",
                modLoc("block/rich_grass_side"), modLoc("block/rich_dirt/rich_dirt"), modLoc("block/rich_grass_top")));
        blockItem(EMBlocks.RICH_GRASS);

    }

    private void simpleBlock(DeferredBlock<?> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    private void blockItem(DeferredBlock<?> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile("ethermist:block/" + block.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> block, String appendix) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile("ethermist:block/" + block.getId().getPath() + appendix));
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

}
