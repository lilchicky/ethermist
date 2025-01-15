package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class EMItemModelProvider extends ItemModelProvider {

    public EMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(EMItems.MIST_GEM.get());

        buttonItem(EMBlocks.ETHERSTONE_BUTTON, EMBlocks.ETHERSTONE);
        wallItem(EMBlocks.ETHERSTONE_WALL, EMBlocks.ETHERSTONE);

        fenceItem(EMBlocks.ANCIENT_FENCE, EMBlocks.ANCIENT_PLANKS);
        buttonItem(EMBlocks.ANCIENT_BUTTON, EMBlocks.ANCIENT_PLANKS);
        basicItem(EMBlocks.ANCIENT_DOOR.asItem());
        saplingItem(EMBlocks.ANCIENT_SAPLING);

    }

    // By Kaupenjoe
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ethermist.MODID,
                        "block/" + baseBlock.getId().getPath()));
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

    public ItemModelBuilder saplingItem(DeferredBlock<?> block) {
        return withExistingParent(block.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block/" + block.getId().getPath()));
    }

}
