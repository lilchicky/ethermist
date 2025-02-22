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

                /*
                    For new wood, remember to add:
                    - Wood Block
                    - Sapling
                    - Leaves
                 */

                // Ancient Wood
                output.accept(EMBlocks.ANCIENT_LOG);
                output.accept(EMBlocks.ANCIENT_WOOD);
                output.accept(EMBlocks.STRIPPED_ANCIENT_LOG);
                output.accept(EMBlocks.STRIPPED_ANCIENT_WOOD);

                output.accept(EMBlocks.ANCIENT_PLANKS);
                output.accept(EMBlocks.ANCIENT_STAIRS);
                output.accept(EMBlocks.ANCIENT_SLAB);
                output.accept(EMBlocks.ANCIENT_FENCE);
                output.accept(EMBlocks.ANCIENT_FENCE_GATE);
                output.accept(EMBlocks.ANCIENT_DOOR);
                output.accept(EMBlocks.ANCIENT_TRAPDOOR);
                output.accept(EMBlocks.ANCIENT_PRESSURE_PLATE);
                output.accept(EMBlocks.ANCIENT_BUTTON);

                // Glimmering Ancient Wood
                output.accept(EMBlocks.GLIMMERING_ANCIENT_LOG);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_WOOD);
                output.accept(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_LOG);
                output.accept(EMBlocks.STRIPPED_GLIMMERING_ANCIENT_WOOD);

                output.accept(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_LOG);
                output.accept(EMBlocks.SUSPICIOUS_GLIMMERING_ANCIENT_WOOD);
                output.accept(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG);
                output.accept(EMBlocks.STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD);

                output.accept(EMBlocks.GLIMMERING_ANCIENT_PLANKS);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_STAIRS);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_SLAB);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_FENCE);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_FENCE_GATE);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_DOOR);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_TRAPDOOR);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_PRESSURE_PLATE);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_BUTTON);

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

                // Frostpine Wood
                output.accept(EMBlocks.FROSTPINE_LOG);
                output.accept(EMBlocks.FROSTPINE_WOOD);
                output.accept(EMBlocks.STRIPPED_FROSTPINE_LOG);
                output.accept(EMBlocks.STRIPPED_FROSTPINE_WOOD);

                output.accept(EMBlocks.FROSTPINE_PLANKS);
                output.accept(EMBlocks.FROSTPINE_STAIRS);
                output.accept(EMBlocks.FROSTPINE_SLAB);
                output.accept(EMBlocks.FROSTPINE_FENCE);
                output.accept(EMBlocks.FROSTPINE_FENCE_GATE);
                output.accept(EMBlocks.FROSTPINE_DOOR);
                output.accept(EMBlocks.FROSTPINE_TRAPDOOR);
                output.accept(EMBlocks.FROSTPINE_PRESSURE_PLATE);
                output.accept(EMBlocks.FROSTPINE_BUTTON);

                // Amberwood Wood
                output.accept(EMBlocks.AMBERWOOD_LOG);
                output.accept(EMBlocks.AMBERWOOD_WOOD);
                output.accept(EMBlocks.STRIPPED_AMBERWOOD_LOG);
                output.accept(EMBlocks.STRIPPED_AMBERWOOD_WOOD);

                output.accept(EMBlocks.AMBERWOOD_PLANKS);
                output.accept(EMBlocks.AMBERWOOD_STAIRS);
                output.accept(EMBlocks.AMBERWOOD_SLAB);
                output.accept(EMBlocks.AMBERWOOD_FENCE);
                output.accept(EMBlocks.AMBERWOOD_FENCE_GATE);
                output.accept(EMBlocks.AMBERWOOD_DOOR);
                output.accept(EMBlocks.AMBERWOOD_TRAPDOOR);
                output.accept(EMBlocks.AMBERWOOD_PRESSURE_PLATE);
                output.accept(EMBlocks.AMBERWOOD_BUTTON);

                // Ashen Wood
                output.accept(EMBlocks.CHARRED_LOG);
                output.accept(EMBlocks.CHARRED_WOOD);
                output.accept(EMBlocks.STRIPPED_CHARRED_LOG);
                output.accept(EMBlocks.STRIPPED_CHARRED_WOOD);

                output.accept(EMBlocks.CHARRED_PLANKS);
                output.accept(EMBlocks.CHARRED_STAIRS);
                output.accept(EMBlocks.CHARRED_SLAB);
                output.accept(EMBlocks.CHARRED_FENCE);
                output.accept(EMBlocks.CHARRED_FENCE_GATE);
                output.accept(EMBlocks.CHARRED_DOOR);
                output.accept(EMBlocks.CHARRED_TRAPDOOR);
                output.accept(EMBlocks.CHARRED_PRESSURE_PLATE);
                output.accept(EMBlocks.CHARRED_BUTTON);

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

                output.accept(EMBlocks.COBBLED_ETHERSTONE);
                output.accept(EMBlocks.COBBLED_ETHERSTONE_STAIRS);
                output.accept(EMBlocks.COBBLED_ETHERSTONE_SLAB);
                output.accept(EMBlocks.COBBLED_ETHERSTONE_WALL);

                output.accept(EMBlocks.MOSSY_COBBLED_ETHERSTONE);
                output.accept(EMBlocks.MOSSY_COBBLED_ETHERSTONE_STAIRS);
                output.accept(EMBlocks.MOSSY_COBBLED_ETHERSTONE_SLAB);
                output.accept(EMBlocks.MOSSY_COBBLED_ETHERSTONE_WALL);

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

                // Misc Natural Blocks
                output.accept(EMBlocks.MOLTEN_ETHERSTONE.get());

                // Leaves
                output.accept(EMBlocks.ANCIENT_LEAVES);
                output.accept(EMBlocks.SLIMY_LEAVES);
                output.accept(EMBlocks.FROSTPINE_LEAVES);
                output.accept(EMBlocks.GREEN_AMBERWOOD_LEAVES);
                output.accept(EMBlocks.RED_AMBERWOOD_LEAVES);
                output.accept(EMBlocks.ORANGE_AMBERWOOD_LEAVES);
                output.accept(EMBlocks.YELLOW_AMBERWOOD_LEAVES);

                // Plants
                output.accept(EMBlocks.ANCIENT_SAPLING);
                output.accept(EMBlocks.GLIMMERING_ANCIENT_SAPLING);
                output.accept(EMBlocks.SLIMY_SAPLING);
                output.accept(EMBlocks.FROSTPINE_SAPLING);
                output.accept(EMBlocks.GREEN_AMBERWOOD_SAPLING);
                output.accept(EMBlocks.RED_AMBERWOOD_SAPLING);
                output.accept(EMBlocks.ORANGE_AMBERWOOD_SAPLING);
                output.accept(EMBlocks.YELLOW_AMBERWOOD_SAPLING);
                output.accept(EMBlocks.CHARRED_SAPLING);

                output.accept(EMBlocks.RICH_GRASS);
                output.accept(EMBlocks.GLIMMERBUD);
                output.accept(EMBlocks.NIGHTBELL);
                output.accept(EMBlocks.WITCH_LAVENDER);
                output.accept(EMBlocks.DAWNING_HYACINTH);
                output.accept(EMBlocks.CINDERBLOOM);
                output.accept(EMBlocks.SLIMY_ALLIUM);

                output.accept(EMBlocks.GLIMMERBUG_HIVE);
                output.accept(EMBlocks.ETHERMIST_PORTAL);

                // Misc
                output.accept(EMBlocks.ICICLE);

            })
            .build());

    /*
                ------------------------- ITEMS -------------------------
    */

    public static final Supplier<CreativeModeTab> EM_ITEM_TAB = CREATIVE_TAB.register("em_item_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(EMItems.DULL_WAND.get()))
            .title(Component.translatable("creativetab.ethermist.em_item_tab"))
            .displayItems((itemDisplayParameters, output) -> {

                // Orbs
                output.accept(EMItems.DULL_ORB.get());
                output.accept(EMItems.POISON_ORB.get());
                output.accept(EMItems.FLAME_ORB.get());
                output.accept(EMItems.WITHER_ORB.get());
                output.accept(EMItems.LEVITATION_ORB.get());

                // Wands
                output.accept(EMItems.WAND_HANDLE.get());

                //for (int color : Arrays.stream(DyeColor.values()).mapToInt(DyeColor::getTextColor).toArray()) {
                //    ItemStack coloredHandle = new ItemStack(EMItems.WAND_HANDLE.get());
                //    coloredHandle.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
                //    output.accept(coloredHandle);
                //}

                output.accept(EMItems.DULL_WAND.get());
                output.accept(EMItems.POISON_WAND.get());
                output.accept(EMItems.FLAME_WAND.get());
                output.accept(EMItems.WITHER_WAND.get());
                output.accept(EMItems.LEVITATION_WAND.get());

                // Misc
                output.accept(EMItems.WAND_TOME.get());
                output.accept(EMItems.BASE_SPELL_TOME.get());
                output.accept(EMItems.AUGMENT_TOME.get());
                output.accept(EMItems.MAIN_SPELL_TOME.get());
                output.accept(EMItems.EXCLUSION_TOME.get());

            }).build());

    public static void register (IEventBus bus) {
        CREATIVE_TAB.register(bus);
    }

}
