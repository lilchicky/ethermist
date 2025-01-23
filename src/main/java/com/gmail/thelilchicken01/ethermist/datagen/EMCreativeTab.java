package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EMCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ethermist.MODID);

    public static final Supplier<CreativeModeTab> EM_BLOCK_TAB = CREATIVE_TAB.register("em_block_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(EMBlocks.RICH_GRASS_BLOCK.get()))
            .title(Component.translatable("creativetab.ethermist.em_block_tab"))
            .displayItems((itemDisplayParameters, output) -> {

                // Ancient Wood
                output.accept(EMBlocks.ANCIENT_LOG);
                output.accept(EMBlocks.ANCIENT_WOOD);
                output.accept(EMBlocks.STRIPPED_ANCIENT_LOG);
                output.accept(EMBlocks.STRIPPED_ANCIENT_WOOD);

                output.accept(EMBlocks.PEEKING_ANCIENT_LOG);
                output.accept(EMBlocks.PEEKING_ANCIENT_WOOD);
                output.accept(EMBlocks.STRIPPED_PEEKING_ANCIENT_LOG);
                output.accept(EMBlocks.STRIPPED_PEEKING_ANCIENT_WOOD);

                output.accept(EMBlocks.ANCIENT_PLANKS);
                output.accept(EMBlocks.ANCIENT_STAIRS);
                output.accept(EMBlocks.ANCIENT_SLAB);
                output.accept(EMBlocks.ANCIENT_FENCE);
                output.accept(EMBlocks.ANCIENT_FENCE_GATE);
                output.accept(EMBlocks.ANCIENT_DOOR);
                output.accept(EMBlocks.ANCIENT_TRAPDOOR);
                output.accept(EMBlocks.ANCIENT_PRESSURE_PLATE);
                output.accept(EMBlocks.ANCIENT_BUTTON);

                // Slimy Wood
                output.accept(EMBlocks.SLIMY_LOG);
                output.accept(EMBlocks.SLIMY_WOOD);
                output.accept(EMBlocks.STRIPPED_SLIMY_LOG);
                output.accept(EMBlocks.STRIPPED_SLIMY_WOOD);

                output.accept(EMBlocks.SLIMY_PLANKS);
                output.accept(EMBlocks.SLIMY_STAIRS);
                output.accept(EMBlocks.SLIMY_SLAB);
                output.accept(EMBlocks.SLIMY_FENCE);
                output.accept(EMBlocks.SLIMY_FENCE_GATE);
                output.accept(EMBlocks.SLIMY_DOOR);
                output.accept(EMBlocks.SLIMY_TRAPDOOR);
                output.accept(EMBlocks.SLIMY_PRESSURE_PLATE);
                output.accept(EMBlocks.SLIMY_BUTTON);

                // Abyssal Mushrooms
                output.accept(EMBlocks.BLUE_ABYSSAL_MUSHROOM_STEM);
                output.accept(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_STEM);

                output.accept(EMBlocks.BLUE_ABYSSAL_MUSHROOM_TOP);
                output.accept(EMBlocks.ORANGE_ABYSSAL_MUSHROOM_TOP);

                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM);
                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM_STAIRS);
                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM_SLAB);
                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE);
                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM_FENCE_GATE);
                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM_DOOR);
                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM_TRAPDOOR);
                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE);
                output.accept(EMBlocks.CUBED_ABYSSAL_MUSHROOM_BUTTON);

                // Etherstone
                output.accept(EMBlocks.ETHERSTONE);
                output.accept(EMBlocks.ETHERSTONE_STAIRS);
                output.accept(EMBlocks.ETHERSTONE_SLAB);
                output.accept(EMBlocks.ETHERSTONE_WALL);
                output.accept(EMBlocks.ETHERSTONE_PRESSURE_PLATE);
                output.accept(EMBlocks.ETHERSTONE_BUTTON);

                output.accept(EMBlocks.ETHERSTONE_BRICKS);
                output.accept(EMBlocks.ETHERSTONE_BRICK_STAIRS);
                output.accept(EMBlocks.ETHERSTONE_BRICK_SLAB);
                output.accept(EMBlocks.ETHERSTONE_BRICK_WALL);

                // Sparkling Sand
                output.accept(EMBlocks.SPARKLING_SANDSTONE);
                output.accept(EMBlocks.SPARKLING_SANDSTONE_STAIRS);
                output.accept(EMBlocks.SPARKLING_SANDSTONE_SLAB);
                output.accept(EMBlocks.SPARKLING_SANDSTONE_WALL);
                output.accept(EMBlocks.SPARKLING_SANDSTONE_PRESSURE_PLATE);
                output.accept(EMBlocks.SPARKLING_SANDSTONE_BUTTON);

                output.accept(EMBlocks.SPARKLING_SANDSTONE_BRICKS);
                output.accept(EMBlocks.SPARKLING_SANDSTONE_BRICK_STAIRS);
                output.accept(EMBlocks.SPARKLING_SANDSTONE_BRICK_SLAB);
                output.accept(EMBlocks.SPARKLING_SANDSTONE_BRICK_WALL);

                // Timeworn Sand
                output.accept(EMBlocks.TIMEWORN_SANDSTONE);
                output.accept(EMBlocks.TIMEWORN_SANDSTONE_STAIRS);
                output.accept(EMBlocks.TIMEWORN_SANDSTONE_SLAB);
                output.accept(EMBlocks.TIMEWORN_SANDSTONE_WALL);

                output.accept(EMBlocks.POLISHED_TIMEWORN_SANDSTONE);
                output.accept(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_STAIRS);
                output.accept(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_SLAB);
                output.accept(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_WALL);
                output.accept(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE);
                output.accept(EMBlocks.POLISHED_TIMEWORN_SANDSTONE_BUTTON);

                // Dirts
                output.accept(EMBlocks.RICH_GRASS_BLOCK);
                output.accept(EMBlocks.RICH_DIRT);
                output.accept(EMBlocks.CRUMBLING_ETHERSTONE);
                output.accept(EMBlocks.TIMEWORN_SAND);
                output.accept(EMBlocks.SPARKLING_SAND);

                // Leaves
                output.accept(EMBlocks.ANCIENT_LEAVES);
                output.accept(EMBlocks.SLIMY_LEAVES);

                // Plants
                output.accept(EMBlocks.ANCIENT_SAPLING);
                output.accept(EMBlocks.SLIMY_SAPLING);
                output.accept(EMBlocks.RICH_GRASS);
                output.accept(EMBlocks.GLIMMER_BLOSSOM);

                output.accept(EMBlocks.MIST_GEM_ORE);
                output.accept(EMBlocks.GLIMMERBUG_HIVE);
                output.accept(EMBlocks.ETHERMIST_PORTAL);

            })
            .build());

    /*
                ------------------------- ITEMS -------------------------
    */

    public static final Supplier<CreativeModeTab> EM_ITEM_TAB = CREATIVE_TAB.register("em_item_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(EMItems.DULL_WAND.get()))
            .title(Component.translatable("creativetab.ethermist.em_item_tab"))
            .displayItems((itemDisplayParameters, output) -> {

                // Wands
                output.accept(EMItems.DULL_WAND.get());
                output.accept(EMItems.FLAME_WAND.get());

                // Misc
                output.accept(EMItems.FOCUS_TOME.get());
                output.accept(EMItems.WAND_TOME.get());

            }).build());

    public static void register (IEventBus bus) {
        CREATIVE_TAB.register(bus);
    }

}
