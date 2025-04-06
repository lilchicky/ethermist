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

import static com.gmail.thelilchicken01.ethermist.datagen.DataGenerators.*;

public class EMItemModelProvider extends ItemModelProvider {

    public EMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        buttonItemFolder(EMBlocks.ETHERSTONE_BUTTON, EMBlocks.ETHERSTONE, ETHERSTONE);
        wallItemFolder(EMBlocks.ETHERSTONE_WALL, EMBlocks.ETHERSTONE, ETHERSTONE);

        wallItem(EMBlocks.WITCHSTONE_WALL, EMBlocks.WITCHSTONE);

        buttonItem(EMBlocks.POLISHED_WITCHSTONE_BUTTON, EMBlocks.POLISHED_WITCHSTONE);
        wallItem(EMBlocks.POLISHED_WITCHSTONE_WALL, EMBlocks.POLISHED_WITCHSTONE);

        wallItem(EMBlocks.DAWNSHALE_WALL, EMBlocks.DAWNSHALE);

        buttonItem(EMBlocks.POLISHED_DAWNSHALE_BUTTON, EMBlocks.POLISHED_DAWNSHALE);
        wallItem(EMBlocks.POLISHED_DAWNSHALE_WALL, EMBlocks.POLISHED_DAWNSHALE);

        buttonItemFolder(EMBlocks.ANCIENT_ETHERSTONE_BUTTON, EMBlocks.ANCIENT_ETHERSTONE, ANCIENT_ETHERSTONE);
        wallItemFolder(EMBlocks.ANCIENT_ETHERSTONE_WALL, EMBlocks.ANCIENT_ETHERSTONE, ANCIENT_ETHERSTONE);

        buttonItemFolder(EMBlocks.SPARKLING_SANDSTONE_BUTTON, EMBlocks.SPARKLING_SANDSTONE, SPARKLING_SANDSTONE);
        wallItemFolder(EMBlocks.SPARKLING_SANDSTONE_WALL, EMBlocks.SPARKLING_SANDSTONE, SPARKLING_SANDSTONE);
        wallItem(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL, EMBlocks.SPARKLING_SANDSTONE_BRICKS);

        buttonItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON, EMBlocks.POLISHED_TIMEWORN_SANDSTONE);
        wallItem(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL, EMBlocks.POLISHED_TIMEWORN_SANDSTONE);
        wallItemFolder(EMBlocks.TIMEWORN_SANDSTONE_WALL, EMBlocks.TIMEWORN_SANDSTONE, TIMEWORN_SANDSTONE);

        wallItem(EMBlocks.ETHERSTONE_BRICK_WALL, EMBlocks.ETHERSTONE_BRICKS);
        wallItem(EMBlocks.ANCIENT_ETHERSTONE_BRICK_WALL, EMBlocks.ANCIENT_ETHERSTONE_BRICKS);
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

        fenceItemFolder(EMBlocks.CHARRED_FENCE, EMBlocks.CHARRED_PLANKS, ASHEN_WOOD);
        buttonItemFolder(EMBlocks.CHARRED_BUTTON, EMBlocks.CHARRED_PLANKS, ASHEN_WOOD);
        basicItem(EMBlocks.CHARRED_DOOR.asItem());
        saplingItemFolder(EMBlocks.CHARRED_SAPLING, ASHEN_WOOD);

        fenceItemFolder(EMBlocks.AMBERWOOD_FENCE, EMBlocks.AMBERWOOD_PLANKS, AMBERWOOD_WOOD);
        buttonItemFolder(EMBlocks.AMBERWOOD_BUTTON, EMBlocks.AMBERWOOD_PLANKS, AMBERWOOD_WOOD);
        basicItem(EMBlocks.AMBERWOOD_DOOR.asItem());
        saplingItemFolder(EMBlocks.GREEN_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);
        saplingItemFolder(EMBlocks.RED_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);
        saplingItemFolder(EMBlocks.ORANGE_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);
        saplingItemFolder(EMBlocks.YELLOW_AMBERWOOD_SAPLING, AMBERWOOD_WOOD);

        fenceItemFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE, EMBlocks.CUBED_ABYSSAL_MUSHROOM, ABYSSAL_MUSHROOM);
        buttonItemFolder(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON, EMBlocks.CUBED_ABYSSAL_MUSHROOM, ABYSSAL_MUSHROOM);
        basicItem(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR.asItem());

        crossItem(EMBlocks.GLIMMERBUD);
        crossItem(EMBlocks.NIGHTBELL);
        crossItem(EMBlocks.SLIMY_ALLIUM);
        crossItem(EMBlocks.WITCH_LAVENDER);
        crossItem(EMBlocks.DAWNING_HYACINTH);
        crossItem(EMBlocks.RICH_GRASS);
        crossItemCustomTexture(EMBlocks.RICH_TALL_GRASS, "rich_tall_grass_upper");
        crossItem(EMBlocks.SMALL_ABYSSAL_MUSHROOM);
        basicItem(EMBlocks.TALL_ABYSSAL_MUSHROOM.get().asItem());
        crossItem(EMBlocks.ABYSSAL_MUSHROOM);

        wandHandle(EMItems.WAND_HANDLE);
        wandItem(EMItems.FLAME_WAND, EMItems.WAND_HANDLE);
        wandItem(EMItems.DULL_WAND, EMItems.WAND_HANDLE);
        wandItem(EMItems.POISON_WAND, EMItems.WAND_HANDLE);
        wandItem(EMItems.LEVITATION_WAND, EMItems.WAND_HANDLE);
        wandItem(EMItems.WITHER_WAND, EMItems.WAND_HANDLE);
        wandItem(EMItems.WITCH_WAND, EMItems.WAND_HANDLE);
        wandItem(EMItems.HEAVY_WAND, EMItems.WAND_HANDLE);

        orbItem(EMItems.DULL_ORB);
        orbItem(EMItems.FLAME_ORB);
        orbItem(EMItems.POISON_ORB);
        orbItem(EMItems.LEVITATION_ORB);
        orbItem(EMItems.WITHER_ORB);
        orbItem(EMItems.WITCH_ORB);

        shotItem(EMItems.GENERIC_SHOT);
        shotItem(EMItems.FLAME_SHOT);
        shotItem(EMItems.METEOR_SHOT);
        shotItem(EMItems.POISON_SHOT);
        shotItem(EMItems.LEVITATION_SHOT);
        shotItem(EMItems.WITHER_SHOT);
        shotItem(EMItems.WITCH_SHOT);

        basicItem(EMItems.EXCLUSION_TOME.get());
        basicItem(EMItems.WAND_TOME.get());
        basicItem(EMItems.AUGMENT_TOME.get());
        basicItem(EMItems.MAIN_SPELL_TOME.get());
        basicItem(EMItems.BASE_SPELL_TOME.get());

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

    public void crossItemCustomTexture(DeferredBlock<?> block, String loc) {
        this.withExistingParent(block.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + loc));
    }

    public void saplingItemFolder(DeferredBlock<?> block, String folder) {
        this.withExistingParent(block.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + folder + "/" + block.getId().getPath()));
    }

    public void wandItem(DeferredItem<?> wand, DeferredItem<?> handle) {
        this.withExistingParent(wand.getId().getPath(), ResourceLocation.parse("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/" + handle.getId().getPath()))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/" + handle.getId().getPath() + "_overlay"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/" + wand.getId().getPath()));
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
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/" + item.getId().getPath() + "_empty"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/" + item.getId().getPath() + "_empty_overlay"));
    }

    public void shotItem(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/shots/" + item.getId().getPath()));
    }

}
