package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantmentEffects;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EMEnchantTagProvider extends EnchantmentTagsProvider {

    public EMEnchantTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(EnchantmentTags.IN_ENCHANTING_TABLE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "arcane_velocity"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "quick_cast"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "greater_distance"))
                .addOptional(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "ancient_power"));

        tag(EMTags.Enchantments.MAIN_DAMAGE_SPELLS);


    }

}
