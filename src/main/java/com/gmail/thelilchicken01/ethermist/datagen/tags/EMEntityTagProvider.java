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
import net.minecraft.world.entity.EntityType;
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
                .add(EMEntityTypes.GLOOMIE.get())
                .add(EMEntityTypes.FORGEMASTER.get())
                .add(EMEntityTypes.PYLON.get());

        tag(Tags.EntityTypes.BOSSES)
                .add(EMEntityTypes.FORGEMASTER.get())
                .add(EMEntityTypes.GLIMMERBUG_QUEEN.get());

        tag(EntityTypeTags.ARTHROPOD)
                .add(EMEntityTypes.GLIMMERBUG_QUEEN.get())
                .add(EMEntityTypes.GLIMMERBUG.get());

        tag(EntityTypeTags.AQUATIC)
                .add(EMEntityTypes.GLOOMIE.get());

        tag(EntityTypeTags.UNDEAD)
                .add(EMEntityTypes.FORGEMASTER.get())
                .add(EMEntityTypes.RUNIC_SKELETON.get());

        tag(EntityTypeTags.FALL_DAMAGE_IMMUNE)
                .add(EMEntityTypes.PYLON.get());

        tag(EntityTypeTags.SKELETONS)
                .add(EMEntityTypes.RUNIC_SKELETON.get());

        tag(EntityTypeTags.WITHER_FRIENDS)
                .add(EMEntityTypes.RUNIC_SKELETON.get());

        tag(EntityTypeTags.IMPACT_PROJECTILES)
                .add(EMEntityTypes.WAND_PROJECTILE.get());

        tag(Tags.EntityTypes.CAPTURING_NOT_SUPPORTED)
                .add(EMEntityTypes.GLIMMERBUG_QUEEN.get())
                .add(EMEntityTypes.FORGEMASTER.get());

    }

}
