package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.gmail.thelilchicken01.ethermist.datagen.DataGenerators.*;
import static com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandUtil.getBaseWandName;

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

        wandHandle(EMItems.WOODEN_WAND_HANDLE);
        wandItem(EMItems.WOODEN_FLAME_WAND);
        wandItem(EMItems.WOODEN_DULL_WAND);
        wandItem(EMItems.WOODEN_POISON_WAND);
        wandItem(EMItems.WOODEN_LEVITATION_WAND);
        wandItem(EMItems.WOODEN_WITHER_WAND);
        wandItem(EMItems.WOODEN_WITCH_WAND);
        wandItem(EMItems.WOODEN_HEAVY_WAND);
        wandItem(EMItems.WOODEN_FROZEN_WAND);
        wandItem(EMItems.WOODEN_GLASS_WAND);

        wandHandle(EMItems.EMERALD_WAND_HANDLE);
        wandItem(EMItems.EMERALD_FLAME_WAND);
        wandItem(EMItems.EMERALD_DULL_WAND);
        wandItem(EMItems.EMERALD_POISON_WAND);
        wandItem(EMItems.EMERALD_LEVITATION_WAND);
        wandItem(EMItems.EMERALD_WITHER_WAND);
        wandItem(EMItems.EMERALD_WITCH_WAND);
        wandItem(EMItems.EMERALD_HEAVY_WAND);
        wandItem(EMItems.EMERALD_FROZEN_WAND);
        wandItem(EMItems.EMERALD_GLASS_WAND);

        wandHandle(EMItems.DIAMOND_WAND_HANDLE);
        wandItem(EMItems.DIAMOND_FLAME_WAND);
        wandItem(EMItems.DIAMOND_DULL_WAND);
        wandItem(EMItems.DIAMOND_POISON_WAND);
        wandItem(EMItems.DIAMOND_LEVITATION_WAND);
        wandItem(EMItems.DIAMOND_WITHER_WAND);
        wandItem(EMItems.DIAMOND_WITCH_WAND);
        wandItem(EMItems.DIAMOND_HEAVY_WAND);
        wandItem(EMItems.DIAMOND_FROZEN_WAND);
        wandItem(EMItems.DIAMOND_GLASS_WAND);

        wandHandle(EMItems.GOLDEN_WAND_HANDLE);
        wandItem(EMItems.GOLDEN_FLAME_WAND);
        wandItem(EMItems.GOLDEN_DULL_WAND);
        wandItem(EMItems.GOLDEN_POISON_WAND);
        wandItem(EMItems.GOLDEN_LEVITATION_WAND);
        wandItem(EMItems.GOLDEN_WITHER_WAND);
        wandItem(EMItems.GOLDEN_WITCH_WAND);
        wandItem(EMItems.GOLDEN_HEAVY_WAND);
        wandItem(EMItems.GOLDEN_FROZEN_WAND);
        wandItem(EMItems.GOLDEN_GLASS_WAND);

        wandHandle(EMItems.LAPIS_WAND_HANDLE);
        wandItem(EMItems.LAPIS_FLAME_WAND);
        wandItem(EMItems.LAPIS_DULL_WAND);
        wandItem(EMItems.LAPIS_POISON_WAND);
        wandItem(EMItems.LAPIS_LEVITATION_WAND);
        wandItem(EMItems.LAPIS_WITHER_WAND);
        wandItem(EMItems.LAPIS_WITCH_WAND);
        wandItem(EMItems.LAPIS_HEAVY_WAND);
        wandItem(EMItems.LAPIS_FROZEN_WAND);
        wandItem(EMItems.LAPIS_GLASS_WAND);

        wandHandle(EMItems.QUARTZ_WAND_HANDLE);
        wandItem(EMItems.QUARTZ_FLAME_WAND);
        wandItem(EMItems.QUARTZ_DULL_WAND);
        wandItem(EMItems.QUARTZ_POISON_WAND);
        wandItem(EMItems.QUARTZ_LEVITATION_WAND);
        wandItem(EMItems.QUARTZ_WITHER_WAND);
        wandItem(EMItems.QUARTZ_WITCH_WAND);
        wandItem(EMItems.QUARTZ_HEAVY_WAND);
        wandItem(EMItems.QUARTZ_FROZEN_WAND);
        wandItem(EMItems.QUARTZ_GLASS_WAND);

        wandHandle(EMItems.REDSTONE_WAND_HANDLE);
        wandItem(EMItems.REDSTONE_FLAME_WAND);
        wandItem(EMItems.REDSTONE_DULL_WAND);
        wandItem(EMItems.REDSTONE_POISON_WAND);
        wandItem(EMItems.REDSTONE_LEVITATION_WAND);
        wandItem(EMItems.REDSTONE_WITHER_WAND);
        wandItem(EMItems.REDSTONE_WITCH_WAND);
        wandItem(EMItems.REDSTONE_HEAVY_WAND);
        wandItem(EMItems.REDSTONE_FROZEN_WAND);
        wandItem(EMItems.REDSTONE_GLASS_WAND);

        wandHandle(EMItems.GLOWSTONE_WAND_HANDLE);
        wandItem(EMItems.GLOWSTONE_FLAME_WAND);
        wandItem(EMItems.GLOWSTONE_DULL_WAND);
        wandItem(EMItems.GLOWSTONE_POISON_WAND);
        wandItem(EMItems.GLOWSTONE_LEVITATION_WAND);
        wandItem(EMItems.GLOWSTONE_WITHER_WAND);
        wandItem(EMItems.GLOWSTONE_WITCH_WAND);
        wandItem(EMItems.GLOWSTONE_HEAVY_WAND);
        wandItem(EMItems.GLOWSTONE_FROZEN_WAND);
        wandItem(EMItems.GLOWSTONE_GLASS_WAND);

        wandHandle(EMItems.PRISMARINE_WAND_HANDLE);
        wandItem(EMItems.PRISMARINE_FLAME_WAND);
        wandItem(EMItems.PRISMARINE_DULL_WAND);
        wandItem(EMItems.PRISMARINE_POISON_WAND);
        wandItem(EMItems.PRISMARINE_LEVITATION_WAND);
        wandItem(EMItems.PRISMARINE_WITHER_WAND);
        wandItem(EMItems.PRISMARINE_WITCH_WAND);
        wandItem(EMItems.PRISMARINE_HEAVY_WAND);
        wandItem(EMItems.PRISMARINE_FROZEN_WAND);
        wandItem(EMItems.PRISMARINE_GLASS_WAND);

        wandHandle(EMItems.NETHERITE_WAND_HANDLE);
        wandItem(EMItems.NETHERITE_FLAME_WAND);
        wandItem(EMItems.NETHERITE_DULL_WAND);
        wandItem(EMItems.NETHERITE_POISON_WAND);
        wandItem(EMItems.NETHERITE_LEVITATION_WAND);
        wandItem(EMItems.NETHERITE_WITHER_WAND);
        wandItem(EMItems.NETHERITE_WITCH_WAND);
        wandItem(EMItems.NETHERITE_HEAVY_WAND);
        wandItem(EMItems.NETHERITE_FROZEN_WAND);
        wandItem(EMItems.NETHERITE_GLASS_WAND);

        orbItem(EMItems.DULL_ORB);
        orbItem(EMItems.FLAME_ORB);
        orbItem(EMItems.POISON_ORB);
        orbItem(EMItems.LEVITATION_ORB);
        orbItem(EMItems.WITHER_ORB);
        orbItem(EMItems.WITCH_ORB);
        orbItem(EMItems.FROZEN_ORB);
        orbItem(EMItems.GLASS_ORB);

        shotItem(EMItems.GENERIC_SHOT);
        shotItem(EMItems.FLAME_SHOT);
        shotItem(EMItems.METEOR_SHOT);
        shotItem(EMItems.POISON_SHOT);
        shotItem(EMItems.LEVITATION_SHOT);
        shotItem(EMItems.WITHER_SHOT);
        shotItem(EMItems.WITCH_SHOT);
        shotItem(EMItems.HEAVY_SHOT);
        shotItem(EMItems.FROZEN_SHOT);
        shotItem(EMItems.GLASS_SHOT);

        basicItem(EMItems.EXCLUSION_TOME.get());
        basicItem(EMItems.WAND_TOME.get());
        basicItem(EMItems.AUGMENT_TOME.get());
        basicItem(EMItems.MAIN_SPELL_TOME.get());
        basicItem(EMItems.BASE_SPELL_TOME.get());

        basicItemFolder(EMItems.SHROOM_CLUSTER.get(), "food");
        basicItemFolder(EMItems.TOASTED_SHROOM_CLUSTER.get(), "food");

        withExistingParent(EMItems.GLOOMIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(EMItems.GLIMMERBUG_QUEEN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(EMItems.GLIMMERBUG_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }

    public void basicItemFolder(Item item, String folder) {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        this.withExistingParent(itemId.getPath(), "item/generated")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(itemId.getNamespace(), "item/" + folder + "/" + itemId.getPath()));
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

    public void wandItem(DeferredItem<?> wand) {
        this.withExistingParent(wand.getId().getPath(), ResourceLocation.parse("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/wand_handle_base"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/wand_handle_tier"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/wand_handle_gems"))
                .texture("layer3", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/" + getBaseWandName(wand.getId().getPath())));
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
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/wand_handle_empty_base"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/wand_handle_empty_tier"))
                .texture("layer2", ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/wands/handles/wand_handle_empty_gems"));
    }

    public void shotItem(DeferredItem<?> item) {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/shots/" + item.getId().getPath()));
    }

}
