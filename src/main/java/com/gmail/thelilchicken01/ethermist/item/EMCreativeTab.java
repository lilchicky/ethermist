package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EMCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ethermist.MODID);

    public static final Supplier<CreativeModeTab> EM_TAB = CREATIVE_TAB.register("em_creative_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(EMItems.MIST_GEM.get()))
            .title(Component.translatable("creativetab.ethermist.em_creative_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(EMItems.MIST_GEM);
                output.accept(EMBlocks.GLIMMERBUG_HIVE);

                // Etherstone
                output.accept(EMBlocks.ETHERSTONE);
                output.accept(EMBlocks.ETHERSTONE_STAIRS);
                output.accept(EMBlocks.ETHERSTONE_SLAB);
                output.accept(EMBlocks.ETHERSTONE_PRESSURE_PLATE);
                output.accept(EMBlocks.ETHERSTONE_BUTTON);
                output.accept(EMBlocks.ETHERSTONE_WALL);

                // Ancient Wood
                output.accept(EMBlocks.ANCIENT_LOG);
                output.accept(EMBlocks.STRIPPED_ANCIENT_LOG);
                output.accept(EMBlocks.ANCIENT_WOOD);
                output.accept(EMBlocks.STRIPPED_ANCIENT_WOOD);
                output.accept(EMBlocks.ANCIENT_PLANKS);
                output.accept(EMBlocks.ANCIENT_SAPLING);
                output.accept(EMBlocks.ANCIENT_LEAVES);
                output.accept(EMBlocks.ANCIENT_STAIRS);
                output.accept(EMBlocks.ANCIENT_SLAB);
                output.accept(EMBlocks.ANCIENT_PRESSURE_PLATE);
                output.accept(EMBlocks.ANCIENT_BUTTON);
                output.accept(EMBlocks.ANCIENT_FENCE);
                output.accept(EMBlocks.ANCIENT_FENCE_GATE);
                output.accept(EMBlocks.ANCIENT_DOOR);
                output.accept(EMBlocks.ANCIENT_TRAPDOOR);

                // Rich Dirt
                output.accept(EMBlocks.RICH_DIRT);
                output.accept(EMBlocks.RICH_GRASS);

                // Sparkling Sand
                output.accept(EMBlocks.SPARKLING_SAND);

                // Timeworn Sand
                output.accept(EMBlocks.TIMEWORN_SAND);

                // Crumbling Etherstone
                output.accept(EMBlocks.CRUMBLING_ETHERSTONE);

                output.accept(EMBlocks.MIST_GEM_ORE);

            })
            .build());

    public static void register (IEventBus bus) {
        CREATIVE_TAB.register(bus);
    }

}
