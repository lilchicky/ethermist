package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.data.PackOutput;
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

        simpleBlock(EMBlocks.ETHERSTONE);
        stairsBlock(EMBlocks.ETHERSTONE_STAIRS.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        slabBlock(EMBlocks.ETHERSTONE_SLAB.get(), blockTexture(EMBlocks.ETHERSTONE.get()), blockTexture(EMBlocks.ETHERSTONE.get()));
        buttonBlock(EMBlocks.ETHERSTONE_BUTTON.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        pressurePlateBlock(EMBlocks.ETHERSTONE_PRESSURE_PLATE.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        fenceBlock(EMBlocks.ETHERSTONE_FENCE.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        fenceGateBlock(EMBlocks.ETHERSTONE_FENCE_GATE.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        wallBlock(EMBlocks.ETHERSTONE_WALL.get(), blockTexture(EMBlocks.ETHERSTONE.get()));
        doorBlockWithRenderType(EMBlocks.ETHERSTONE_DOOR.get(), modLoc("block/etherstone_door_bottom"), modLoc("block/etherstone_door_top"), "cutout");
        trapdoorBlockWithRenderType(EMBlocks.ETHERSTONE_TRAPDOOR.get(), modLoc("block/etherstone_trapdoor"), true, "cutout");
        blockItem(EMBlocks.ETHERSTONE_STAIRS);
        blockItem(EMBlocks.ETHERSTONE_SLAB);
        blockItem(EMBlocks.ETHERSTONE_PRESSURE_PLATE);
        blockItem(EMBlocks.ETHERSTONE_FENCE_GATE);
        blockItem(EMBlocks.ETHERSTONE_TRAPDOOR, "_bottom");

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

}
