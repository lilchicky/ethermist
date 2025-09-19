package com.gmail.thelilchicken01.ethermist.datagen.tags;

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
        public static final TagKey<Block> CAN_SUPPORT_CHARRED_TREE = mod("can_support_charred_tree");
        public static final TagKey<Block> ETHERSTONE_ORE_REPLACEABLES = mod("etherstone_ore_replaceables");
        public static final TagKey<Block> ANCIENT_ETHERSTONE_ORE_REPLACEABLES = mod("ancient_etherstone_ore_replaceables");
        public static final TagKey<Block> ETHERMIST_STONES = mod("ethermist_stones");
        public static final TagKey<Block> CAN_SUPPORT_FORGEMASTER_PYLON = mod("can_support_forgemaster_pylon");

        private static TagKey<Block> mod(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, path));
        }

    }

    public static final class Items {

        public static final TagKey<Item> WANDS = mod("wands");
        public static final TagKey<Item> ENCHANTABLE_BASE = mod("enchantable_base");
        public static final TagKey<Item> ENCHANTABLE_AUGMENTS = mod("enchantable_augments");
        public static final TagKey<Item> ENCHANTABLE_EXCLUSIONS = mod("enchantable_exclusions");
        public static final TagKey<Item> ENCHANTABLE_MAIN_SPELLS = mod("enchantable_main_spells");
        public static final TagKey<Item> DYEABLE_WANDS = mod("dyeable_wands");
        public static final TagKey<Item> MAGIC_ENCHANTABLE = mod("magic_enchantable");
        public static final TagKey<Item> TOMES = mod("tomes");
        public static final TagKey<Item> ORBS = mod("orbs");
        public static final TagKey<Item> WAND_BASE = mod("wand_base");

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
