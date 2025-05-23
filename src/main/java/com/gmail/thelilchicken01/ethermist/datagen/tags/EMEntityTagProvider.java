package com.gmail.thelilchicken01.ethermist.datagen.tags;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EMEntityTagProvider extends EntityTypeTagsProvider {

    public EMEntityTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ethermist.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER)
                .add(EMEntityTypes.GLOOMIE.get());

        tag(Tags.EntityTypes.BOSSES)
                .add(EMEntityTypes.GLIMMERBUG_QUEEN.get());

        tag(EntityTypeTags.ARTHROPOD)
                .add(EMEntityTypes.GLIMMERBUG_QUEEN.get())
                .add(EMEntityTypes.GLIMMERBUG.get());

        tag(EntityTypeTags.AQUATIC)
                .add(EMEntityTypes.GLOOMIE.get());

    }

}
