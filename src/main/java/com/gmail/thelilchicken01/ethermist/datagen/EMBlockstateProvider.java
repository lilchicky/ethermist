package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
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
        stairsBlock(EMBlocks.ETHERSTONE_STAIRS.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get()));
        slabBlock(EMBlocks.ETHERSTONE_SLAB.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get()), blockTextureFolder(EMBlocks.ETHERSTONE.get()));
        buttonBlock(EMBlocks.ETHERSTONE_BUTTON.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get()));
        pressurePlateBlock(EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get()));
        wallBlock(EMBlocks.ETHERSTONE_WALL.get(), blockTextureFolder(EMBlocks.ETHERSTONE.get()));
        blockItem(EMBlocks.ETHERSTONE_STAIRS);
        blockItem(EMBlocks.ETHERSTONE_SLAB);
        blockItem(EMBlocks.ETHERSTONE_PRESSURE_PLATE);

        simpleBlock(EMBlocks.ETHERSTONE_BRICKS);
        stairsBlock(EMBlocks.ETHERSTONE_BRICK_STAIRS.get(), blockTexture(EMBlocks.ETHERSTONE_BRICKS.get()));
        slabBlock(EMBlocks.ETHERSTONE_BRICK_SLAB.get(), blockTexture(EMBlocks.ETHERSTONE_BRICKS.get()), blockTexture(EMBlocks.ETHERSTONE_BRICKS.get()));
        wallBlock(EMBlocks.ETHERSTONE_BRICK_WALL.get(), blockTexture(EMBlocks.ETHERSTONE_BRICKS.get()));
        blockItem(EMBlocks.ETHERSTONE_BRICK_STAIRS);
        blockItem(EMBlocks.ETHERSTONE_BRICK_SLAB);

        // Ancient Wood
        logBlock((RotatedPillarBlock) EMBlocks.ANCIENT_LOG.get());
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_ANCIENT_LOG.get());
        axisBlock((RotatedPillarBlock) EMBlocks.ANCIENT_WOOD.get(), blockTexture(EMBlocks.ANCIENT_LOG.get()));
        axisBlock((RotatedPillarBlock) EMBlocks.STRIPPED_ANCIENT_WOOD.get(), blockTexture(EMBlocks.STRIPPED_ANCIENT_LOG.get()));

        logBlock((RotatedPillarBlock) EMBlocks.PEEKING_ANCIENT_LOG.get());
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_PEEKING_ANCIENT_LOG.get());
        axisBlock((RotatedPillarBlock) EMBlocks.PEEKING_ANCIENT_WOOD.get(), blockTexture(EMBlocks.PEEKING_ANCIENT_LOG.get()));
        axisBlock((RotatedPillarBlock) EMBlocks.STRIPPED_PEEKING_ANCIENT_WOOD.get(), blockTexture(EMBlocks.STRIPPED_PEEKING_ANCIENT_LOG.get()));

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
        blockItem(EMBlocks.PEEKING_ANCIENT_LOG);
        blockItem(EMBlocks.STRIPPED_PEEKING_ANCIENT_LOG);
        blockItem(EMBlocks.PEEKING_ANCIENT_WOOD);
        blockItem(EMBlocks.STRIPPED_PEEKING_ANCIENT_WOOD);
        blockItem(EMBlocks.ANCIENT_SAPLING);

        // Slimy Wood
        logBlock((RotatedPillarBlock) EMBlocks.SLIMY_LOG.get());
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_SLIMY_LOG.get());
        axisBlock((RotatedPillarBlock) EMBlocks.SLIMY_WOOD.get(), blockTexture(EMBlocks.SLIMY_LOG.get()));
        axisBlock((RotatedPillarBlock) EMBlocks.STRIPPED_SLIMY_WOOD.get(), blockTexture(EMBlocks.STRIPPED_SLIMY_LOG.get()));

        simpleBlock(EMBlocks.SLIMY_PLANKS);
        leavesBlock(EMBlocks.SLIMY_LEAVES);
        saplingBlock(EMBlocks.SLIMY_SAPLING);

        stairsBlock(EMBlocks.SLIMY_STAIRS.get(), blockTexture(EMBlocks.SLIMY_PLANKS.get()));
        slabBlock(EMBlocks.SLIMY_SLAB.get(), blockTexture(EMBlocks.SLIMY_PLANKS.get()), blockTexture(EMBlocks.SLIMY_PLANKS.get()));
        buttonBlock(EMBlocks.SLIMY_BUTTON.get(), blockTexture(EMBlocks.SLIMY_PLANKS.get()));
        pressurePlateBlock(EMBlocks.SLIMY_PRESSURE_PLATE.get(), blockTexture(EMBlocks.SLIMY_PLANKS.get()));
        fenceBlock(EMBlocks.SLIMY_FENCE.get(), blockTexture(EMBlocks.SLIMY_PLANKS.get()));
        fenceGateBlock(EMBlocks.SLIMY_FENCE_GATE.get(), blockTexture(EMBlocks.SLIMY_PLANKS.get()));
        doorBlockWithRenderType(EMBlocks.SLIMY_DOOR.get(), modLoc("block/slimy_door_bottom"), modLoc("block/slimy_door_top"), "cutout");
        trapdoorBlockWithRenderType(EMBlocks.SLIMY_TRAPDOOR.get(), modLoc("block/slimy_trapdoor"), true, "cutout");

        blockItem(EMBlocks.SLIMY_STAIRS);
        blockItem(EMBlocks.SLIMY_SLAB);
        blockItem(EMBlocks.SLIMY_PRESSURE_PLATE);
        blockItem(EMBlocks.SLIMY_FENCE_GATE);
        blockItem(EMBlocks.SLIMY_TRAPDOOR, "_bottom");
        blockItem(EMBlocks.SLIMY_LOG);
        blockItem(EMBlocks.STRIPPED_SLIMY_LOG);
        blockItem(EMBlocks.SLIMY_WOOD);
        blockItem(EMBlocks.STRIPPED_SLIMY_WOOD);
        blockItem(EMBlocks.SLIMY_SAPLING);

        // Frostpine Wood
        logBlock((RotatedPillarBlock) EMBlocks.FROSTPINE_LOG.get());
        logBlock((RotatedPillarBlock) EMBlocks.STRIPPED_FROSTPINE_LOG.get());
        axisBlock((RotatedPillarBlock) EMBlocks.FROSTPINE_WOOD.get(), blockTexture(EMBlocks.FROSTPINE_LOG.get()));
        axisBlock((RotatedPillarBlock) EMBlocks.STRIPPED_FROSTPINE_WOOD.get(), blockTexture(EMBlocks.STRIPPED_FROSTPINE_LOG.get()));

        simpleBlock(EMBlocks.FROSTPINE_PLANKS);
        leavesBlock(EMBlocks.FROSTPINE_LEAVES);
        saplingBlock(EMBlocks.FROSTPINE_SAPLING);

        stairsBlock(EMBlocks.FROSTPINE_STAIRS.get(), blockTexture(EMBlocks.FROSTPINE_PLANKS.get()));
        slabBlock(EMBlocks.FROSTPINE_SLAB.get(), blockTexture(EMBlocks.FROSTPINE_PLANKS.get()), blockTexture(EMBlocks.FROSTPINE_PLANKS.get()));
        buttonBlock(EMBlocks.FROSTPINE_BUTTON.get(), blockTexture(EMBlocks.FROSTPINE_PLANKS.get()));
        pressurePlateBlock(EMBlocks.FROSTPINE_PRESSURE_PLATE.get(), blockTexture(EMBlocks.FROSTPINE_PLANKS.get()));
        fenceBlock(EMBlocks.FROSTPINE_FENCE.get(), blockTexture(EMBlocks.FROSTPINE_PLANKS.get()));
        fenceGateBlock(EMBlocks.FROSTPINE_FENCE_GATE.get(), blockTexture(EMBlocks.FROSTPINE_PLANKS.get()));
        doorBlockWithRenderType(EMBlocks.FROSTPINE_DOOR.get(), modLoc("block/frostpine_door_bottom"), modLoc("block/frostpine_door_top"), "cutout");
        trapdoorBlockWithRenderType(EMBlocks.FROSTPINE_TRAPDOOR.get(), modLoc("block/frostpine_trapdoor"), true, "cutout");

        blockItem(EMBlocks.FROSTPINE_STAIRS);
        blockItem(EMBlocks.FROSTPINE_SLAB);
        blockItem(EMBlocks.FROSTPINE_PRESSURE_PLATE);
        blockItem(EMBlocks.FROSTPINE_FENCE_GATE);
        blockItem(EMBlocks.FROSTPINE_TRAPDOOR, "_bottom");
        blockItem(EMBlocks.FROSTPINE_LOG);
        blockItem(EMBlocks.STRIPPED_FROSTPINE_LOG);
        blockItem(EMBlocks.FROSTPINE_WOOD);
        blockItem(EMBlocks.STRIPPED_FROSTPINE_WOOD);
        blockItem(EMBlocks.FROSTPINE_SAPLING);

        // Sparkling Sand
        simpleBlock(EMBlocks.SPARKLING_SANDSTONE_BRICKS);

        stairsBlock(EMBlocks.SPARKLING_SANDSTONE_STAIRS.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get()));
        slabBlock(EMBlocks.SPARKLING_SANDSTONE_SLAB.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get()), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get()));
        buttonBlock(EMBlocks.SPARKLING_SANDSTONE_BUTTON.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get()));
        pressurePlateBlock(EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get()));
        wallBlock(EMBlocks.SPARKLING_SANDSTONE_WALL.get(), blockTextureFolder(EMBlocks.SPARKLING_SANDSTONE.get()));
        blockItem(EMBlocks.SPARKLING_SANDSTONE_STAIRS);
        blockItem(EMBlocks.SPARKLING_SANDSTONE_SLAB);
        blockItem(EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE);

        stairsBlock(EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS.get(), blockTexture(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get()));
        slabBlock(EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB.get(), blockTexture(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get()), blockTexture(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get()));
        wallBlock(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL.get(), blockTexture(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get()));
        blockItem(EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS);
        blockItem(EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB);

        // Timeworn Sand
        simpleBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE);

        stairsBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        slabBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        buttonBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        pressurePlateBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        wallBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL.get(), blockTexture(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()));
        blockItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS);
        blockItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB);
        blockItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE);
        
        stairsBlock(EMBlocks.TIMEWORN_SANDSTONE_STAIRS.get(), blockTextureFolder(EMBlocks.TIMEWORN_SANDSTONE.get()));
        slabBlock(EMBlocks.TIMEWORN_SANDSTONE_SLAB.get(), blockTextureFolder(EMBlocks.TIMEWORN_SANDSTONE.get()), blockTextureFolder(EMBlocks.TIMEWORN_SANDSTONE.get()));
        wallBlock(EMBlocks.TIMEWORN_SANDSTONE_WALL.get(), blockTextureFolder(EMBlocks.TIMEWORN_SANDSTONE.get()));
        blockItem(EMBlocks.TIMEWORN_SANDSTONE_STAIRS);
        blockItem(EMBlocks.TIMEWORN_SANDSTONE_SLAB);

        // Rich Dirt
        simpleBlock(EMBlocks.RICH_GRASS_BLOCK.get(), models().cubeBottomTop("rich_grass_block",
                modLoc("block/rich_grass_block_side"), modLoc("block/rich_dirt/rich_dirt"), modLoc("block/rich_grass_block_top")));
        blockItem(EMBlocks.RICH_GRASS_BLOCK);

        // Flowers
        plantBlock(EMBlocks.GLIMMER_BLOSSOM);
        flowerPotBlock(EMBlocks.GLIMMER_BLOSSOM_FLOWER_POT, EMBlocks.GLIMMER_BLOSSOM);
        plantBlock(EMBlocks.RICH_GRASS);

        // Abyssal Mushrooms
        simpleBlock(EMBlocks.BLUE_ABYSSAL_MUSHROOM_TOP);
        simpleBlock(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_TOP);
        logBlock(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM.get());
        logBlock(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM.get());

        blockItem(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM);
        blockItem(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM);

        simpleBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM);

        stairsBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS.get(), blockTexture(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()));
        slabBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB.get(), blockTexture(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()), blockTexture(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()));
        buttonBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON.get(), blockTexture(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()));
        pressurePlateBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE.get(), blockTexture(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()));
        fenceBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE.get(), blockTexture(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()));
        fenceGateBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE.get(), blockTexture(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()));
        doorBlockWithRenderType(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.get(), modLoc("block/cubed_abyssal_mushroom_door_bottom"), modLoc("block/cubed_abyssal_mushroom_door_top"), "cutout");
        trapdoorBlockWithRenderType(EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR.get(), modLoc("block/cubed_abyssal_mushroom_trapdoor"), true, "cutout");

        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS);
        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB);
        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE);
        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE);
        blockItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR, "_bottom");

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

    private void plantBlock(DeferredBlock<?> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
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

    public ResourceLocation blockTextureFolder(Block block) {
        ResourceLocation name = BuiltInRegistries.BLOCK.getKey(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), "block/" + name.getPath() + "/" + name.getPath());
    }

}
