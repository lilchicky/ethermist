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
                .add(EMEntityTypes.FORGEMASTER.get());

        tag(EntityTypeTags.FALL_DAMAGE_IMMUNE)
                .add(EMEntityTypes.PYLON.get());

        /*
                    Exclusion Enchantment Tags
         */

        tag(EMTags.Entities.EXCLUDE_MONSTERS)
                .add(
                        EntityType.BLAZE,
                        EntityType.BOGGED,
                        EntityType.CAVE_SPIDER,
                        EntityType.CREEPER,
                        EntityType.DROWNED,
                        EntityType.ELDER_GUARDIAN,
                        EntityType.ENDERMITE,
                        EntityType.EVOKER,
                        EntityType.GHAST,
                        EntityType.GUARDIAN,
                        EntityType.HOGLIN,
                        EntityType.HUSK,
                        EntityType.ILLUSIONER,
                        EntityType.MAGMA_CUBE,
                        EntityType.PHANTOM,
                        EntityType.PIGLIN,
                        EntityType.PIGLIN_BRUTE,
                        EntityType.PILLAGER,
                        EntityType.RAVAGER,
                        EntityType.SHULKER,
                        EntityType.SILVERFISH,
                        EntityType.SKELETON,
                        EntityType.SLIME,
                        EntityType.SPIDER,
                        EntityType.STRAY,
                        EntityType.VEX,
                        EntityType.VINDICATOR,
                        EntityType.WARDEN,
                        EntityType.WITCH,
                        EntityType.WITHER,
                        EntityType.WITHER_SKELETON,
                        EntityType.ZOGLIN,
                        EntityType.ZOMBIE,
                        EntityType.ZOMBIE_VILLAGER,
                        EntityType.ZOMBIFIED_PIGLIN
                );

        tag(EMTags.Entities.EXCLUDE_ANIMALS)
                .add(
                        EntityType.ALLAY,
                        EntityType.ARMADILLO,
                        EntityType.AXOLOTL,
                        EntityType.BAT,
                        EntityType.BEE,
                        EntityType.CAMEL,
                        EntityType.CAT,
                        EntityType.CHICKEN,
                        EntityType.COW,
                        EntityType.DONKEY,
                        EntityType.FOX,
                        EntityType.FROG,
                        EntityType.GLOW_SQUID,
                        EntityType.GOAT,
                        EntityType.HORSE,
                        EntityType.LLAMA,
                        EntityType.MOOSHROOM,
                        EntityType.MULE,
                        EntityType.OCELOT,
                        EntityType.PANDA,
                        EntityType.PARROT,
                        EntityType.PIG,
                        EntityType.POLAR_BEAR,
                        EntityType.RABBIT,
                        EntityType.SHEEP,
                        EntityType.SNIFFER,
                        EntityType.SNOW_GOLEM,
                        EntityType.SQUID,
                        EntityType.STRIDER,
                        EntityType.TADPOLE,
                        EntityType.TURTLE,
                        EntityType.WOLF,
                        EntityType.COD,
                        EntityType.DOLPHIN,
                        EntityType.PUFFERFISH,
                        EntityType.SALMON,
                        EntityType.TROPICAL_FISH
                );

        tag(EMTags.Entities.EXCLUDE_VILLAGERS)
                .add(
                        EntityType.VILLAGER,
                        EntityType.WANDERING_TRADER,
                        EntityType.IRON_GOLEM
                );

        tag(EMTags.Entities.EXCLUDE_PLAYERS)
                .add(EntityType.PLAYER);

    }

}
