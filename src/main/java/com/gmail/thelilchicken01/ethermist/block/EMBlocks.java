package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTreeGrowers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;

import java.util.function.Supplier;

public class EMBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Ethermist.MODID);

    // Glimmerbug Hive
    public static final DeferredBlock<Block> GLIMMERBUG_HIVE = registerBlock("glimmerbug_hive", GlimmerbugHive::new);

    // Etherstone
    public static final DeferredBlock<Block> ETHERSTONE = registerBlock("etherstone", Etherstone::new);
    public static final DeferredBlock<StairBlock> ETHERSTONE_STAIRS = registerBlock("etherstone_stairs", () -> new StairBlock(EMBlocks.ETHERSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));
    public static final DeferredBlock<SlabBlock> ETHERSTONE_SLAB = registerBlock("etherstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));
    public static final DeferredBlock<PressurePlateBlock> ETHERSTONE_PRESSURE_PLATE = registerBlock("etherstone_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));
    public static final DeferredBlock<ButtonBlock> ETHERSTONE_BUTTON = registerBlock("etherstone_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get()).noCollission()));
    public static final DeferredBlock<WallBlock> ETHERSTONE_WALL = registerBlock("etherstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));

    // Mist Gem Ore
    public static final DeferredBlock<Block> MIST_GEM_ORE = registerBlock("mist_gem_ore", Etherstone::new);

    // Rich Dirt
    public static final DeferredBlock<Block> RICH_DIRT = registerBlock("rich_dirt", RichDirt::new);
    public static final DeferredBlock<Block> RICH_GRASS = registerBlock("rich_grass", RichGrass::new);

    // Ancient Wood
    public static final DeferredBlock<Block> ANCIENT_LOG = registerBlock("ancient_log", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> ANCIENT_WOOD = registerBlock("ancient_wood", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_ANCIENT_LOG = registerBlock("stripped_ancient_log", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_ANCIENT_WOOD = registerBlock("stripped_ancient_wood", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final DeferredBlock<Block> ANCIENT_PLANKS = registerBlock("ancient_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> ANCIENT_LEAVES = registerBlock("ancient_leaves", () -> new EMFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredBlock<Block> ANCIENT_SAPLING = registerBlock("ancient_sapling", () -> new SaplingBlock(EMTreeGrowers.ANCIENT_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> ANCIENT_STAIRS = registerBlock("ancient_stairs", () -> new StairBlock(EMBlocks.ANCIENT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> ANCIENT_SLAB = registerBlock("ancient_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<PressurePlateBlock> ANCIENT_PRESSURE_PLATE = registerBlock("ancient_pressure_plate", () -> new PressurePlateBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<ButtonBlock> ANCIENT_BUTTON = registerBlock("ancient_button", () -> new ButtonBlock(BlockSetType.CHERRY, 40, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> ANCIENT_FENCE = registerBlock("ancient_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> ANCIENT_FENCE_GATE = registerBlock("ancent_fence_gate", () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<DoorBlock> ANCIENT_DOOR = registerBlock("ancient_door", () -> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> ANCIENT_TRAPDOOR = registerBlock("ancient_trapdoor", () -> new TrapDoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get()).noOcclusion()));


    /*
    Register Functions
     */

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> newBlock = BLOCKS.register(name, block);
        registerBlockItem(name, newBlock);
        return newBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        EMItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

}
