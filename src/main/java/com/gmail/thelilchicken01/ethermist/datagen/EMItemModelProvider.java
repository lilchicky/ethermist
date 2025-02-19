package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

import static com.gmail.thelilchicken01.ethermist.Ethermist.*;

public class EMItemModelProvider extends ItemModelProvider {

    public EMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        buttonItemFolder(EMBlocks.ETHERSTONE_BUTTON, EMBlocks.ETHERSTONE, ETHERSTONE);
        wallItemFolder(EMBlocks.ETHERSTONE_WALL, EMBlocks.ETHERSTONE, ETHERSTONE);

        buttonItemFolder(EMBlocks.SPARKLING_SANDSTONE_BUTTON, EMBlocks.SPARKLING_SANDSTONE, SPARKLING_SANDSTONE);
        wallItemFolder(EMBlocks.SPARKLING_SANDSTONE_WALL, EMBlocks.SPARKLING_SANDSTONE, SPARKLING_SANDSTONE);
        wallItem(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL, EMBlocks.SPARKLING_SANDSTONE_BRICKS);

        buttonItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON, EMBlocks.POLISHED_TIMEWORN_SANDSTONE);
        wallItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL, EMBlocks.POLISHED_TIMEWORN_SANDSTONE);
        wallItemFolder(EMBlocks.TIMEWORN_SANDSTONE_WALL, EMBlocks.TIMEWORN_SANDSTONE, TIMEWORN_SANDSTONE);

        wallItem(EMBlocks.ETHERSTONE_BRICK_WALL, EMBlocks.ETHERSTONE_BRICKS);
        wallItem(EMBlocks.COBBLED_ETHERSTONE_WALL, EMBlocks.COBBLED_ETHERSTONE);
        wallItem(EMBlocks.MOSSY_COBBLED_ETHERSTONE_WALL, EMBlocks.MOSSY_COBBLED_ETHERSTONE);

        fenceItemFolder(EMBlocks.GLIMMERING_ANCIENT_FENCE, EMBlocks.GLIMMERING_ANCIENT_PLANKS, GLIMMERING_WOOD);
        buttonItemFolder(EMBlocks.GLIMMERING_ANCIENT_BUTTON, EMBlocks.GLIMMERING_ANCIENT_PLANKS, GLIMMERING_WOOD);
        basicItem(EMBlocks.GLIMMERING_ANCIENT_DOOR.asItem());
        saplingItemFolder(EMBlocks.GLIMMERING_ANCIENT_SAPLING, GLIMMERING_WOOD);

        fenceItemFolder(EMBlocks.ANCIENT_FENCE, EMBlocks.ANCIENT_PLANKS, ANCIENT_WOOD);
        buttonItemFolder(EMBlocks.ANCIENT_BUTTON, EMBlocks.ANCIENT_PLANKS, ANCIENT_WOOD);
        basicItem(EMBlocks.ANCIENT_DOOR.asItem());
        saplingItemFolder(EMBlocks.ANCIENT_SAPLING, ANCIENT_WOOD);

        fenceItemFolder(EMBlocks.SLIMY_FENCE, EMBlocks.SLIMY_PLANKS, SLIMY_WOOD);
        buttonItemFolder(EMBlocks.SLIMY_BUTTON, EMBlocks.SLIMY_PLANKS, SLIMY_WOOD);
        basicItem(EMBlocks.SLIMY_DOOR.asItem());
        saplingItemFolder(EMBlocks.SLIMY_SAPLING, SLIMY_WOOD);

        fenceItemFolder(EMBlocks.FROSTPINE_FENCE, EMBlocks.FROSTPINE_PLANKS, FROSTPINE_WOOD);
        buttonItemFolder(EMBlocks.FROSTPINE_BUTTON, EMBlocks.FROSTPINE_PLANKS, FROSTPINE_WOOD);
        basicItem(EMBlocks.FROSTPINE_DOOR.asItem());
        saplingItemFolder(EMBlocks.FROSTPINE_SAPLING, FROSTPINE_WOOD);

        fenceItemFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE, EMBlocks.CUBED_ABYSSAL_MUSHROOM, ABYSSAL_MUSHROOM);
        buttonItemFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON, EMBlocks.CUBED_ABYSSAL_MUSHROOM, ABYSSAL_MUSHROOM);
        basicItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.asItem());

        crossItem(EMBlocks.GLIMMER_BLOSSOM);
        crossItem(EMBlocks.NIGHTBELL);
        crossItem(EMBlocks.SLIMY_ALLIUM);
        crossItem(EMBlocks.RICH_GRASS);

        wandHandle(EMItems.WAND_HANDLE);
        wandItem("dull_wand");
        wandItem("flame_wand");

        orbItem(EMItems.DULL_ORB);
        orbItem(EMItems.FLAME_ORB);

        shotItem(EMItems.GENERIC_SHOT);
        shotItem(EMItems.FLAME_SHOT);
        shotItem(EMItems.METEOR_SHOT);

        basicItem(EMItems.EXCLUSION_TOME.get());
        basicItem(EMItems.WAND_TOME.get());

    }

    // By Kaupenjoe
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void buttonItemFolder(DeferredBlock<?> block, DeferredBlock<Block> baseBlock, String folder) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + folder + "/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItemFolder(DeferredBlock<?> block, DeferredBlock<Block> baseBlock, String folder) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + folder + "/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItemFolder(DeferredBlock<?> block, DeferredBlock<Block> baseBlock, String folder) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + folder + "/" + baseBlock.getId().getPath()));
    }


    public void crossItem(DeferredBlock<?> block) {
        this.withExistingParent(block.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + block.getId().getPath()));
    }

    public void saplingItemFolder(DeferredBlock<?> block, String folder) {
        this.withExistingParent(block.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + folder + "/" + block.getId().getPath()));
    }

    public void wandItem(String orbID) {
        this.withExistingParent(orbID, ResourceLocation.parse("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/wand_handle"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/wand_handle_overlay"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/" + orbID));
    }

    public void orbItem(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/orbs/" + item.getId().getPath()));
    }

    public void basicHandheld(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/" + item.getId().getPath()));
    }

    public void wandHandle(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/" + item.getId().getPath()))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/" + item.getId().getPath() + "_overlay"));
    }

    public void shotItem(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/shots/" + item.getId().getPath()));
    }

}
