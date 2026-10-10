package com.gmail.thelilchicken01.ethermist.datagen.tags;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
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
                .add(EMEntityTypes.RUNIC_SKELETON.get())
                .add(EMEntityTypes.SPECTRAL_LICH.get());

        tag(EntityTypeTags.FALL_DAMAGE_IMMUNE)
                .add(EMEntityTypes.PYLON.get());

        tag(EntityTypeTags.SKELETONS)
                .add(EMEntityTypes.RUNIC_SKELETON.get())
                .add(EMEntityTypes.SPECTRAL_LICH.get());

        tag(EntityTypeTags.WITHER_FRIENDS)
                .add(EMEntityTypes.RUNIC_SKELETON.get())
                .add(EMEntityTypes.SPECTRAL_LICH.get());

        tag(EntityTypeTags.IMPACT_PROJECTILES)
                .add(EMEntityTypes.WAND_PROJECTILE.get());

        tag(Tags.EntityTypes.CAPTURING_NOT_SUPPORTED)
                .add(EMEntityTypes.GLIMMERBUG_QUEEN.get())
                .add(EMEntityTypes.FORGEMASTER.get());

        tag(EMTags.EntityTypes.IGNORED_BY_WAND_TARGETING)
                .addTag(EntityTypeTags.DEFLECTS_PROJECTILES)
                .add(EntityType.ITEM)
                .add(EntityType.EXPERIENCE_ORB)
                .add(EntityType.PAINTING)
                .add(EntityType.ITEM_FRAME)
                .add(EntityType.AREA_EFFECT_CLOUD)
                .add(EntityType.ARMOR_STAND)
                .add(EntityType.ARROW)
                .addTag(EntityTypeTags.IMPACT_PROJECTILES)
                .addTag(Tags.EntityTypes.BOATS)
                .add(EntityType.BLOCK_DISPLAY)
                .addTag(Tags.EntityTypes.MINECARTS)
                .add(EntityType.EGG)
                .add(EntityType.EXPERIENCE_BOTTLE)
                .add(EntityType.EYE_OF_ENDER)
                .add(EntityType.ENDER_PEARL)
                .add(EntityType.FALLING_BLOCK)
                .add(EntityType.FISHING_BOBBER)
                .add(EntityType.GLOW_ITEM_FRAME)
                .add(EntityType.ITEM_DISPLAY)
                .add(EntityType.LEASH_KNOT)
                .add(EntityType.LIGHTNING_BOLT)
                .add(EntityType.POTION)
                .add(EntityType.LLAMA_SPIT)
                .add(EntityType.SPECTRAL_ARROW)
                .add(EntityType.TEXT_DISPLAY);

    }

}
