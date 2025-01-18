package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class EMTags {

    public static final class Blocks {

        public static final TagKey<Block> PORTAL_FRAME_BLOCKS = mod("portal_frame_blocks");

        private static TagKey<Block> mod(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
        }

    }

    public static final class Items {

        public static final TagKey<Item> WANDS = mod("wands");

        private static TagKey<Item> mod(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
        }

    }

}
