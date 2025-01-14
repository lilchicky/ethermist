package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EMBlockTagProvider extends BlockTagsProvider {

    public EMBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(EMBlocks.ETHERSTONE.get())
                .add(EMBlocks.ETHERSTONE_STAIRS.get())
                .add(EMBlocks.ETHERSTONE_SLAB.get())
                .add(EMBlocks.ETHERSTONE_BUTTON.get())
                .add(EMBlocks.ETHERSTONE_PRESSURE_PLATE.get())
                .add(EMBlocks.ETHERSTONE_FENCE.get())
                .add(EMBlocks.ETHERSTONE_FENCE_GATE.get())
                .add(EMBlocks.ETHERSTONE_WALL.get())
                .add(EMBlocks.ETHERSTONE_DOOR.get())
                .add(EMBlocks.ETHERSTONE_TRAPDOOR.get())

                .add(EMBlocks.MIST_GEM_ORE.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(EMBlocks.RICH_DIRT.get())
                .add(EMBlocks.RICH_GRASS.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(EMBlocks.MIST_GEM_ORE.get());

        tag(BlockTags.FENCES)
                .add(EMBlocks.ETHERSTONE_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(EMBlocks.ETHERSTONE_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(EMBlocks.ETHERSTONE_WALL.get());
    }

}
