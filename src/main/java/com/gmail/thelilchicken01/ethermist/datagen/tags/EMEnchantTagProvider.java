package com.gmail.thelilchicken01.ethermist.datagen.tags;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EMEnchantTagProvider extends EnchantmentTagsProvider {

    public EMEnchantTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        addBaseEnchantment(EMEnchantments.ARCANE_VELOCITY);
        addBaseEnchantment(EMEnchantments.QUICK_CAST);
        addBaseEnchantment(EMEnchantments.ENDURING_MAGIC);
        addBaseEnchantment(EMEnchantments.RUNIC_FORCE);
        addBaseEnchantment(EMEnchantments.ANCIENT_POWER);
        addBaseEnchantment(EMEnchantments.STABLE_ORB);

        addAugmentEnchantment(EMEnchantments.AUGMENT_SPLIT, true);
        addAugmentEnchantment(EMEnchantments.AUGMENT_AOE, true);
        addAugmentEnchantment(EMEnchantments.AUGMENT_SPRAY, true);
        addAugmentEnchantment(EMEnchantments.AUGMENT_METEOR, true);
        addAugmentEnchantment(EMEnchantments.AUGMENT_ABUNDANCE, false);
        addAugmentEnchantment(EMEnchantments.AUGMENT_FOCUS, true);
        addTreasureAugmentEnchantment(EMEnchantments.AUGMENT_HOMING, false);

        addExcludeEnchantment(EMEnchantments.EXCLUDE_MONSTERS);
        addExcludeEnchantment(EMEnchantments.EXCLUDE_ANIMALS);
        addExcludeEnchantment(EMEnchantments.EXCLUDE_PLAYERS);
        addExcludeEnchantment(EMEnchantments.EXCLUDE_VILLAGERS);

        addMainEnchantment(EMEnchantments.FIREBALL);
        addMainEnchantment(EMEnchantments.THUNDERSTRIKE);
        addMainEnchantment(EMEnchantments.KINETIC_RUSH);
        addMainEnchantment(EMEnchantments.VOLATILE_ENERGY);
        addMainEnchantment(EMEnchantments.SEISMIC_SURGE);
        addTreasureMainEnchantment(EMEnchantments.CHAOS_MAGIC);

        tag(Tags.Enchantments.INCREASE_BLOCK_DROPS)
                .add(EMEnchantments.AUGMENT_ABUNDANCE);

        tag(Tags.Enchantments.INCREASE_ENTITY_DROPS)
                .add(EMEnchantments.AUGMENT_ABUNDANCE);

        tag(EMTags.Enchantments.SPECTRAL_LICH_WAND_CAN_HAVE)
                .add(EMEnchantments.THUNDERSTRIKE)
                .add(EMEnchantments.RUNIC_FORCE)
                .add(EMEnchantments.ANCIENT_POWER)
                .add(EMEnchantments.QUICK_CAST)
                .add(EMEnchantments.ARCANE_VELOCITY)
                .add(EMEnchantments.ENDURING_MAGIC)
                .add(EMEnchantments.AUGMENT_AOE)
                .add(EMEnchantments.AUGMENT_SPLIT)
                .add(EMEnchantments.AUGMENT_SPRAY);

    }

    private void addMainEnchantment(ResourceKey<Enchantment> ench) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).add(ench);
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).add(ench);
        tag(EMTags.Enchantments.MAIN_DAMAGE_SPELLS).add(ench);
        tag(EnchantmentTags.NON_TREASURE).add(ench);
    }

    private void addExcludeEnchantment(ResourceKey<Enchantment> ench) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).add(ench);
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).add(ench);
        tag(EMTags.Enchantments.EXCLUDE_SPELLS).add(ench);
        tag(EnchantmentTags.NON_TREASURE).add(ench);
    }

    private void addAugmentEnchantment(ResourceKey<Enchantment> ench, boolean exclusive) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).add(ench);
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).add(ench);
        tag(EnchantmentTags.NON_TREASURE).add(ench);
        if (exclusive) {
            tag(EMTags.Enchantments.AUGMENT_SPELLS).add(ench);
        }
    }

    private void addTreasureMainEnchantment(ResourceKey<Enchantment> ench) {
        tag(EnchantmentTags.TREASURE).add(ench);
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).add(ench);
        tag(EMTags.Enchantments.MAIN_DAMAGE_SPELLS).add(ench);
        tag(EnchantmentTags.ON_RANDOM_LOOT).add(ench);
    }

    private void addTreasureAugmentEnchantment(ResourceKey<Enchantment> ench, boolean exclusive) {
        tag(EnchantmentTags.TREASURE).add(ench);
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).add(ench);
        tag(EnchantmentTags.ON_RANDOM_LOOT).add(ench);
        if (exclusive) {
            tag(EMTags.Enchantments.AUGMENT_SPELLS).add(ench);
        }
    }

    private void addBaseEnchantment(ResourceKey<Enchantment> ench) {
        tag(EnchantmentTags.IN_ENCHANTING_TABLE).add(ench);
        tag(EMTags.Enchantments.WAND_ENCHANTMENTS).add(ench);
        tag(EnchantmentTags.NON_TREASURE).add(ench);
    }

}
