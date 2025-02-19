package com.gmail.thelilchicken01.ethermist.datagen.tags;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EMEnchantTagProvider extends EnchantmentTagsProvider {

    public EMEnchantTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        addBaseEnchantment("arcane_velocity");
        addBaseEnchantment("quick_cast");
        addBaseEnchantment("enduring_magic");
        addBaseEnchantment("runic_power");
        addBaseEnchantment("ancient_power");
        addBaseEnchantment("stable_orb");

        addAugmentEnchantment("augment_split", true);
        addAugmentEnchantment("augment_aoe", true);
        addAugmentEnchantment("augment_spray", true);
        addAugmentEnchantment("augment_meteor", true);
        addAugmentEnchantment("augment_abundance", false);
        addTreasureAugmentEnchantment("augment_homing", false);

        addExcludeEnchantment("exclude_monsters");
        addExcludeEnchantment("exclude_animals");
        addExcludeEnchantment("exclude_players");

        addMainEnchantment("fireball");
        addMainEnchantment("thunderstrike");
        addMainEnchantment("kinetic_rush");
        addMainEnchantment("volatile_energy");
        addMainEnchantment("seismic_surge");
        addTreasureMainEnchantment("chaos_magic");

    }

    private void addMainEnchantment(String ench) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.MAIN_DAMAGE_SPELLS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
    }

    private void addExcludeEnchantment(String ench) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.EXCLUDE_SPELLS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
    }

    private void addAugmentEnchantment(String ench, boolean exclusive) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        if (exclusive) {
            tag(EMTags.Enchantments.AUGMENT_SPELLS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        }
    }

    private void addTreasureMainEnchantment(String ench) {
        tag(EnchantmentTags.TREASURE).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.MAIN_DAMAGE_SPELLS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
    }

    private void addTreasureAugmentEnchantment(String ench, boolean exclusive) {
        tag(EnchantmentTags.TREASURE).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        if (exclusive) {
            tag(EMTags.Enchantments.AUGMENT_SPELLS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        }
    }

    private void addBaseEnchantment(String ench) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, ench));
    }

}
