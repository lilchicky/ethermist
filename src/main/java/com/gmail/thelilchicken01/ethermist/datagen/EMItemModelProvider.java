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

public class EMItemModelProvider extends ItemModelProvider {

    public EMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        buttonItemFolder(EMBlocks.ETHERSTONE_BUTTON, EMBlocks.ETHERSTONE);
        wallItemFolder(EMBlocks.ETHERSTONE_WALL, EMBlocks.ETHERSTONE);

        buttonItemFolder(EMBlocks.SPARKLING_SANDSTONE_BUTTON, EMBlocks.SPARKLING_SANDSTONE);
        wallItemFolder(EMBlocks.SPARKLING_SANDSTONE_WALL, EMBlocks.SPARKLING_SANDSTONE);
        wallItem(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL, EMBlocks.SPARKLING_SANDSTONE_BRICKS);

        buttonItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON, EMBlocks.POLISHED_TIMEWORN_SANDSTONE);
        wallItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL, EMBlocks.POLISHED_TIMEWORN_SANDSTONE);
        wallItemFolder(EMBlocks.TIMEWORN_SANDSTONE_WALL, EMBlocks.TIMEWORN_SANDSTONE);

        wallItem(EMBlocks.ETHERSTONE_BRICK_WALL, EMBlocks.ETHERSTONE_BRICKS);

        fenceItem(EMBlocks.GLIMMERING_ANCIENT_FENCE, EMBlocks.GLIMMERING_ANCIENT_PLANKS);
        buttonItem(EMBlocks.GLIMMERING_ANCIENT_BUTTON, EMBlocks.GLIMMERING_ANCIENT_PLANKS);
        basicItem(EMBlocks.GLIMMERING_ANCIENT_DOOR.asItem());
        saplingItem(EMBlocks.GLIMMERING_ANCIENT_SAPLING);

        fenceItem(EMBlocks.SLIMY_FENCE, EMBlocks.SLIMY_PLANKS);
        buttonItem(EMBlocks.SLIMY_BUTTON, EMBlocks.SLIMY_PLANKS);
        basicItem(EMBlocks.SLIMY_DOOR.asItem());
        saplingItem(EMBlocks.SLIMY_SAPLING);

        fenceItem(EMBlocks.FROSTPINE_FENCE, EMBlocks.FROSTPINE_PLANKS);
        buttonItem(EMBlocks.FROSTPINE_BUTTON, EMBlocks.FROSTPINE_PLANKS);
        basicItem(EMBlocks.FROSTPINE_DOOR.asItem());
        saplingItem(EMBlocks.FROSTPINE_SAPLING);

        fenceItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE, EMBlocks.CUBED_ABYSSAL_MUSHROOM);
        buttonItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON, EMBlocks.CUBED_ABYSSAL_MUSHROOM);
        basicItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.asItem());

        saplingItem(EMBlocks.GLIMMER_BLOSSOM);
        saplingItem(EMBlocks.RICH_GRASS);

        basicHandheld(EMItems.WAND_HANDLE);
        wandItem(EMItems.DULL_WAND);
        wandItem(EMItems.FLAME_WAND);

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

    public void buttonItemFolder(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + baseBlock.getId().getPath() + "/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItemFolder(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + baseBlock.getId().getPath() + "/" + baseBlock.getId().getPath()));
    }


    public void saplingItem(DeferredBlock<?> block) {
        this.withExistingParent(block.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + block.getId().getPath()));
    }

    public void wandItem(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/" + item.getId().getPath()));
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

    public void shotItem(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/shots/" + item.getId().getPath()));
    }

}
