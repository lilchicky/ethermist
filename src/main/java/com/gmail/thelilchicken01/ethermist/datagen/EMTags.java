package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

public class EMTags {

    public static final class Blocks {

        public static final TagKey<Block> PORTAL_FRAME_BLOCKS = mod("portal_frame_blocks");
        public static final TagKey<Block> CAN_GROW_ICICLE = mod("can_grow_icicle");

        private static TagKey<Block> mod(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
        }

    }

    public static final class Items {

        public static final TagKey<Item> WANDS = mod("wands");
        public static final TagKey<Item> MAGIC_ENCHANTABLE = mod("magic_enchantable");
        public static final TagKey<Item> TOMES = mod("tomes");
        public static final TagKey<Item> ORBS = mod("orbs");

        private static TagKey<Item> mod(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
        }

    }

    public static final class Enchantments {

        public static final TagKey<Enchantment> WAND_ENCHANTMENTS = mod("wand_enchantments");

        public static final TagKey<Enchantment> MAIN_DAMAGE_SPELLS = mod("main_damage_spells");
        public static final TagKey<Enchantment> AUGMENT_SPELLS = mod("augment_spells");
        public static final TagKey<Enchantment> EXCLUDE_SPELLS = mod("focus_spells");

        private static TagKey<Enchantment> mod(String path) {
            return TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
        }

    }

}
