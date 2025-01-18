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
import net.minecraft.world.level.material.PushReaction;
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

    public static final DeferredBlock<Block> ETHERSTONE_BRICKS = registerBlock("etherstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));
    public static final DeferredBlock<StairBlock> ETHERSTONE_BRICK_STAIRS = registerBlock("etherstone_brick_stairs", () -> new StairBlock(EMBlocks.ETHERSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));
    public static final DeferredBlock<SlabBlock> ETHERSTONE_BRICK_SLAB = registerBlock("etherstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));
    public static final DeferredBlock<WallBlock> ETHERSTONE_BRICK_WALL = registerBlock("etherstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));

    // Mist Gem Ore
    public static final DeferredBlock<Block> MIST_GEM_ORE = registerBlock("mist_gem_ore", Etherstone::new);

    // Rich Dirt
    public static final DeferredBlock<Block> RICH_DIRT = registerBlock("rich_dirt", RichDirt::new);
    public static final DeferredBlock<Block> RICH_GRASS_BLOCK = registerBlock("rich_grass_block", () -> new RichGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));

    // Ancient Wood
    public static final DeferredBlock<Block> ANCIENT_LOG = registerBlock("ancient_log", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG)));
    public static final DeferredBlock<Block> ANCIENT_WOOD = registerBlock("ancient_wood", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ANCIENT_LOG = registerBlock("stripped_ancient_log", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)));
    public static final DeferredBlock<Block> STRIPPED_ANCIENT_WOOD = registerBlock("stripped_ancient_wood", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));

    public static final DeferredBlock<Block> PEEKING_ANCIENT_LOG = registerBlock("suspicious_ancient_log", FlammableGlimmerbugBlocks::new);
    public static final DeferredBlock<Block> PEEKING_ANCIENT_WOOD = registerBlock("suspicious_ancient_wood", FlammableGlimmerbugBlocks::new);
    public static final DeferredBlock<Block> STRIPPED_PEEKING_ANCIENT_LOG = registerBlock("stripped_suspicious_ancient_log", FlammableGlimmerbugBlocks::new);
    public static final DeferredBlock<Block> STRIPPED_PEEKING_ANCIENT_WOOD = registerBlock("stripped_suspicious_ancient_wood", FlammableGlimmerbugBlocks::new);

    public static final DeferredBlock<Block> ANCIENT_PLANKS = registerBlock("ancient_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> ANCIENT_LEAVES = registerBlock("ancient_leaves", () -> new EMFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA_LEAVES)));

    public static final DeferredBlock<Block> ANCIENT_SAPLING = registerBlock("ancient_sapling", () -> new SaplingBlock(EMTreeGrowers.ANCIENT_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> ANCIENT_STAIRS = registerBlock("ancient_stairs", () -> new StairBlock(EMBlocks.ANCIENT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> ANCIENT_SLAB = registerBlock("ancient_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<PressurePlateBlock> ANCIENT_PRESSURE_PLATE = registerBlock("ancient_pressure_plate", () -> new PressurePlateBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<ButtonBlock> ANCIENT_BUTTON = registerBlock("ancient_button", () -> new ButtonBlock(BlockSetType.CHERRY, 30, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> ANCIENT_FENCE = registerBlock("ancient_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> ANCIENT_FENCE_GATE = registerBlock("ancient_fence_gate", () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get())));
    public static final DeferredBlock<DoorBlock> ANCIENT_DOOR = registerBlock("ancient_door", () -> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> ANCIENT_TRAPDOOR = registerBlock("ancient_trapdoor", () -> new TrapDoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_PLANKS.get()).noOcclusion()));

    // Slimy Wood
    public static final DeferredBlock<Block> SLIMY_LOG = registerBlock("slimy_log", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<Block> SLIMY_WOOD = registerBlock("slimy_wood", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<Block> STRIPPED_SLIMY_LOG = registerBlock("stripped_slimy_log", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<Block> STRIPPED_SLIMY_WOOD = registerBlock("stripped_slimy_wood", () -> new EMFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<Block> SLIMY_PLANKS = registerBlock("slimy_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<Block> SLIMY_LEAVES = registerBlock("slimy_leaves", () -> new EMFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<Block> SLIMY_SAPLING = registerBlock("slimy_sapling", () -> new SaplingBlock(EMTreeGrowers.SLIMY_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> SLIMY_STAIRS = registerBlock("slimy_stairs", () -> new StairBlock(EMBlocks.SLIMY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> SLIMY_SLAB = registerBlock("slimy_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<PressurePlateBlock> SLIMY_PRESSURE_PLATE = registerBlock("slimy_pressure_plate", () -> new PressurePlateBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<ButtonBlock> SLIMY_BUTTON = registerBlock("slimy_button", () -> new ButtonBlock(BlockSetType.CHERRY, 30, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> SLIMY_FENCE = registerBlock("slimy_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> SLIMY_FENCE_GATE = registerBlock("slimy_fence_gate", () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<DoorBlock> SLIMY_DOOR = registerBlock("slimy_door", () -> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> SLIMY_TRAPDOOR = registerBlock("slimy_trapdoor", () -> new TrapDoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get()).noOcclusion()));

    // Sparkling Sand
    public static final DeferredBlock<FallingBlock> SPARKLING_SAND = registerBlock("sparkling_sand", () -> new SparklingSand(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)));
    public static final DeferredBlock<Block> SPARKLING_SANDSTONE = registerBlock("sparkling_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPARKLING_SANDSTONE_BRICKS = registerBlock("sparkling_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> SPARKLING_SANDSTONE_STAIRS = registerBlock("sparkling_sandstone_stairs", () -> new StairBlock(EMBlocks.SPARKLING_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.SPARKLING_SANDSTONE.get())));
    public static final DeferredBlock<SlabBlock> SPARKLING_SANDSTONE_SLAB = registerBlock("sparkling_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.SPARKLING_SANDSTONE.get())));
    public static final DeferredBlock<PressurePlateBlock> SPARKLING_SANDSTONE_PRESSURE_PLATE = registerBlock("sparkling_sandstone_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SPARKLING_SANDSTONE.get())));
    public static final DeferredBlock<ButtonBlock> SPARKLING_SANDSTONE_BUTTON = registerBlock("sparkling_sandstone_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SPARKLING_SANDSTONE.get()).noCollission()));
    public static final DeferredBlock<WallBlock> SPARKLING_SANDSTONE_WALL = registerBlock("sparkling_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.SPARKLING_SANDSTONE.get())));

    public static final DeferredBlock<StairBlock> SPARKLING_SANDSTONE_BRICK_STAIRS = registerBlock("sparkling_sandstone_brick_stairs", () -> new StairBlock(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> SPARKLING_SANDSTONE_BRICK_SLAB = registerBlock("sparkling_sandstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get())));
    public static final DeferredBlock<WallBlock> SPARKLING_SANDSTONE_BRICK_WALL = registerBlock("sparkling_sandstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.SPARKLING_SANDSTONE_BRICKS.get())));


    // Timesworn Sand
    public static final DeferredBlock<FallingBlock> TIMEWORN_SAND = registerBlock("timeworn_sand", () -> new TimewornSand(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)));
    public static final DeferredBlock<Block> TIMEWORN_SANDSTONE = registerBlock("timeworn_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> POLISHED_TIMEWORN_SANDSTONE = registerBlock("polished_timeworn_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> TIMEWORN_SANDSTONE_STAIRS = registerBlock("timeworn_sandstone_stairs", () -> new StairBlock(EMBlocks.TIMEWORN_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<SlabBlock> TIMEWORN_SANDSTONE_SLAB = registerBlock("timeworn_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<WallBlock> TIMEWORN_SANDSTONE_WALL = registerBlock("timeworn_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.TIMEWORN_SANDSTONE.get())));

    public static final DeferredBlock<StairBlock> POLISHED_TIMEWORN_SANDSTONE_STAIRS = registerBlock("polished_timeworn_sandstone_stairs", () -> new StairBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<SlabBlock> POLISHED_TIMEWORN_SANDSTONE_SLAB = registerBlock("polished_timeworn_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<PressurePlateBlock> POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE = registerBlock("polished_timeworn_sandstone_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<ButtonBlock> POLISHED_TIMEWORN_SANDSTONE_BUTTON = registerBlock("polished_timeworn_sandstone_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()).noCollission()));
    public static final DeferredBlock<WallBlock> POLISHED_TIMEWORN_SANDSTONE_WALL = registerBlock("polished_timeworn_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())));


    // Crumbling Etherstone
    public static final DeferredBlock<FallingBlock> CRUMBLING_ETHERSTONE = registerBlock("crumbling_etherstone", () -> new CrumblingEtherstone(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL)));

    // Flowers
    public static final DeferredBlock<FlowerBlock> GLIMMER_BLOSSOM = registerBlock("glimmer_blossom", GlimmerBlossom::new);
    public static final DeferredBlock<FlowerPotBlock> GLIMMER_BLOSSOM_FLOWER_POT = BLOCKS.register("glimmer_blossom_flower_pot", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EMBlocks.GLIMMER_BLOSSOM, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<BushBlock> RICH_GRASS = registerBlock("rich_grass", () -> new RichGrass(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));

    // Abyssal Mushroom
    public static final DeferredBlock<Block> BLUE_ABYSSAL_MUSHROOM_TOP = registerBlock("blue_abyssal_mushroom_top", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK).strength(2.0f)));
    public static final DeferredBlock<Block> ORANGE_ABYSSAL_MUSHROOM_TOP = registerBlock("orange_abyssal_mushroom_top", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK).strength(2.0f)));
    public static final DeferredBlock<RotatedPillarBlock> BLUE_ABYSSAL_MUSHROOM_STEM = registerBlock("blue_abyssal_mushroom_stem", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM).strength(2.0f)));
    public static final DeferredBlock<RotatedPillarBlock> ORANGE_ABYSSAL_MUSHROOM_STEM = registerBlock("orange_abyssal_mushroom_stem", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM).strength(2.0f)));


    // Unobtainable
    public static final DeferredBlock<Block> ETHERMIST_PORTAL = registerBlock("ethermist_portal_block", EMPortalBlock::new);

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
