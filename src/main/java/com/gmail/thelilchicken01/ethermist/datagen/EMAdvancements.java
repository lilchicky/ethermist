package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class EMAdvancements extends AdvancementProvider {
    /**
     * Constructs an advancement provider using the generators to write the
     * advancements to a file.
     *
     * @param output             the target directory of the data generator
     * @param registries         a future of a lookup for registries and their objects
     * @param existingFileHelper a helper used to find whether a file exists
     */
    public EMAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
                          ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new EMAdvancementGenerator()));
    }

    private static final class EMAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {

            // Root
            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            new ItemStack(EMBlocks.RICH_GRASS_BLOCK.asItem()),
                            Component.translatable("advancements.ethermist.root.title"),
                            Component.translatable("advancements.ethermist.root.description"),
                            ResourceLocation.fromNamespaceAndPath(
                                    Ethermist.MODID,
                                    "textures/block/ancient_etherstone/ancient_etherstone.png"
                            ),
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("on_join", PlayerTrigger.TriggerInstance.tick())
                    .requirements(AdvancementRequirements.allOf(List.of("on_join")))
                    .save(saver, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "root"), existingFileHelper);

            // Find Orb
            AdvancementHolder orb = Advancement.Builder.advancement()
                    .parent(AdvancementSubProvider.createPlaceholder(root.toString()))
                    .display(
                            new ItemStack(EMItems.DULL_ORB.get()),
                            Component.translatable("advancements.ethermist.find_orb.title"),
                            Component.translatable("advancements.ethermist.find_orb.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion(
                            "find_orb",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ItemPredicate.Builder.item()
                                            .of(EMTags.Items.ORBS)
                                            .build()
                            )
                    )
                    .requirements(AdvancementRequirements.allOf(List.of("find_orb")))
                    .save(saver, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "find_orb"), existingFileHelper);

            // Find Handle
            AdvancementHolder handle = Advancement.Builder.advancement()
                    .parent(AdvancementSubProvider.createPlaceholder(orb.toString()))
                    .display(
                            new ItemStack(EMItems.WOODEN_WAND_HANDLE.get()),
                            Component.translatable("advancements.ethermist.find_handle.title"),
                            Component.translatable("advancements.ethermist.find_handle.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion(
                            "find_handle",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ItemPredicate.Builder.item()
                                            .of(EMTags.Items.HANDLES)
                                            .build()
                            )
                    )
                    .requirements(AdvancementRequirements.allOf(List.of("find_handle")))
                    .save(saver, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "find_handle"), existingFileHelper);

        }
    }
}
