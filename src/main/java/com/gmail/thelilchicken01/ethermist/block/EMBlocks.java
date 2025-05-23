package com.gmail.thelilchicken01.ethermist.block;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.particle.EMParticleTypes;
import com.gmail.thelilchicken01.ethermist.worldgen.tree.EMTreeGrowers;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
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
    public static final DeferredBlock<Block> MOLTEN_ETHERSTONE = registerBlock("molten_etherstone", () -> new MagmaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK).strength(1.5F, 6.0F)));

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

    // Ancient Etherstone
    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE = registerBlock("ancient_etherstone", AncientEtherstone::new);
    public static final DeferredBlock<StairBlock> ANCIENT_ETHERSTONE_STAIRS = registerBlock("ancient_etherstone_stairs", () -> new StairBlock(EMBlocks.ANCIENT_ETHERSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE.get())));
    public static final DeferredBlock<SlabBlock> ANCIENT_ETHERSTONE_SLAB = registerBlock("ancient_etherstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE.get())));
    public static final DeferredBlock<PressurePlateBlock> ANCIENT_ETHERSTONE_PRESSURE_PLATE = registerBlock("ancient_etherstone_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE.get())));
    public static final DeferredBlock<ButtonBlock> ANCIENT_ETHERSTONE_BUTTON = registerBlock("ancient_etherstone_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE.get()).noCollission()));
    public static final DeferredBlock<WallBlock> ANCIENT_ETHERSTONE_WALL = registerBlock("ancient_etherstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE.get())));

    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_BRICKS = registerBlock("ancient_etherstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE.get()).strength(1.2f)));
    public static final DeferredBlock<StairBlock> ANCIENT_ETHERSTONE_BRICK_STAIRS = registerBlock("ancient_etherstone_brick_stairs", () -> new StairBlock(EMBlocks.ANCIENT_ETHERSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> ANCIENT_ETHERSTONE_BRICK_SLAB = registerBlock("ancient_etherstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get())));
    public static final DeferredBlock<WallBlock> ANCIENT_ETHERSTONE_BRICK_WALL = registerBlock("ancient_etherstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ANCIENT_ETHERSTONE_BRICKS.get())));

    // Witchstone
    public static final DeferredBlock<Block> WITCHSTONE = registerBlock("witchstone", Etherstone::new);
    public static final DeferredBlock<StairBlock> WITCHSTONE_STAIRS = registerBlock("witchstone_stairs", () -> new StairBlock(EMBlocks.WITCHSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.WITCHSTONE.get())));
    public static final DeferredBlock<SlabBlock> WITCHSTONE_SLAB = registerBlock("witchstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.WITCHSTONE.get())));
    public static final DeferredBlock<WallBlock> WITCHSTONE_WALL = registerBlock("witchstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.WITCHSTONE.get())));

    // Polished Witchstone
    public static final DeferredBlock<Block> POLISHED_WITCHSTONE = registerBlock("polished_witchstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(EMBlocks.WITCHSTONE.get()).requiresCorrectToolForDrops()));
    public static final DeferredBlock<StairBlock> POLISHED_WITCHSTONE_STAIRS = registerBlock("polished_witchstone_stairs", () -> new StairBlock(EMBlocks.POLISHED_WITCHSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_WITCHSTONE.get())));
    public static final DeferredBlock<SlabBlock> POLISHED_WITCHSTONE_SLAB = registerBlock("polished_witchstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_WITCHSTONE.get())));
    public static final DeferredBlock<PressurePlateBlock> POLISHED_WITCHSTONE_PRESSURE_PLATE = registerBlock("polished_witchstone_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_WITCHSTONE.get())));
    public static final DeferredBlock<ButtonBlock> POLISHED_WITCHSTONE_BUTTON = registerBlock("polished_witchstone_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_WITCHSTONE.get()).noCollission()));
    public static final DeferredBlock<WallBlock> POLISHED_WITCHSTONE_WALL = registerBlock("polished_witchstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_WITCHSTONE.get())));

    // Dawnshale
    public static final DeferredBlock<Block> DAWNSHALE = registerBlock("dawnshale", () -> new Block(BlockBehaviour.Properties.ofFullCopy(EMBlocks.ETHERSTONE.get())));
    public static final DeferredBlock<StairBlock> DAWNSHALE_STAIRS = registerBlock("dawnshale_stairs", () -> new StairBlock(EMBlocks.DAWNSHALE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.DAWNSHALE.get())));
    public static final DeferredBlock<SlabBlock> DAWNSHALE_SLAB = registerBlock("dawnshale_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.DAWNSHALE.get())));
    public static final DeferredBlock<WallBlock> DAWNSHALE_WALL = registerBlock("dawnshale_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.DAWNSHALE.get())));

    // Polished Dawnshale
    public static final DeferredBlock<Block> POLISHED_DAWNSHALE = registerBlock("polished_dawnshale", () -> new Block(BlockBehaviour.Properties.ofFullCopy(EMBlocks.DAWNSHALE.get()).requiresCorrectToolForDrops()));
    public static final DeferredBlock<StairBlock> POLISHED_DAWNSHALE_STAIRS = registerBlock("polished_dawnshale_stairs", () -> new StairBlock(EMBlocks.POLISHED_DAWNSHALE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_DAWNSHALE.get())));
    public static final DeferredBlock<SlabBlock> POLISHED_DAWNSHALE_SLAB = registerBlock("polished_dawnshale_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_DAWNSHALE.get())));
    public static final DeferredBlock<PressurePlateBlock> POLISHED_DAWNSHALE_PRESSURE_PLATE = registerBlock("polished_dawnshale_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_DAWNSHALE.get())));
    public static final DeferredBlock<ButtonBlock> POLISHED_DAWNSHALE_BUTTON = registerBlock("polished_dawnshale_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_DAWNSHALE.get()).noCollission()));
    public static final DeferredBlock<WallBlock> POLISHED_DAWNSHALE_WALL = registerBlock("polished_dawnshale_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_DAWNSHALE.get())));

    // Rich Dirt
    public static final DeferredBlock<Block> RICH_DIRT = registerBlock("rich_dirt", RichDirt::new);
    public static final DeferredBlock<Block> RICH_GRASS_BLOCK = registerBlock("rich_grass_block", () -> new RichGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));

    // Glimmering Ancient Wood
    public static final DeferredBlock<Block> GLIMMERING_ANCIENT_LOG = registerBlock("glimmering_ancient_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG), true));
    public static final DeferredBlock<Block> GLIMMERING_ANCIENT_WOOD = registerBlock("glimmering_ancient_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD), true));
    public static final DeferredBlock<Block> STRIPPED_GLIMMERING_ANCIENT_LOG = registerBlock("stripped_glimmering_ancient_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG), true));
    public static final DeferredBlock<Block> STRIPPED_GLIMMERING_ANCIENT_WOOD = registerBlock("stripped_glimmering_ancient_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD), true));

    public static final DeferredBlock<Block> SUSPICIOUS_GLIMMERING_ANCIENT_LOG = registerBlock("suspicious_glimmering_ancient_log", GlimmerbugBlocks::new);
    public static final DeferredBlock<Block> SUSPICIOUS_GLIMMERING_ANCIENT_WOOD = registerBlock("suspicious_glimmering_ancient_wood", GlimmerbugBlocks::new);
    public static final DeferredBlock<Block> STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_LOG = registerBlock("stripped_suspicious_glimmering_ancient_log", GlimmerbugBlocks::new);
    public static final DeferredBlock<Block> STRIPPED_SUSPICIOUS_GLIMMERING_ANCIENT_WOOD = registerBlock("stripped_suspicious_glimmering_ancient_wood", GlimmerbugBlocks::new);

    public static final DeferredBlock<Block> GLIMMERING_ANCIENT_PLANKS = registerBlock("glimmering_ancient_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> ANCIENT_LEAVES = registerBlock("ancient_leaves", () -> new EMFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA_LEAVES)));

    public static final DeferredBlock<Block> GLIMMERING_ANCIENT_SAPLING = registerBlock("glimmering_ancient_sapling", () -> new SaplingBlock(EMTreeGrowers.GLIMMERING_ANCIENT_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> GLIMMERING_ANCIENT_STAIRS = registerBlock("glimmering_ancient_stairs", () -> new StairBlock(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> GLIMMERING_ANCIENT_SLAB = registerBlock("glimmering_ancient_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get())));
    public static final DeferredBlock<PressurePlateBlock> GLIMMERING_ANCIENT_PRESSURE_PLATE = registerBlock("glimmering_ancient_pressure_plate", () -> new PressurePlateBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get())));
    public static final DeferredBlock<ButtonBlock> GLIMMERING_ANCIENT_BUTTON = registerBlock("glimmering_ancient_button", () -> new ButtonBlock(BlockSetType.CHERRY, 30, BlockBehaviour.Properties.ofFullCopy(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> GLIMMERING_ANCIENT_FENCE = registerBlock("glimmering_ancient_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> GLIMMERING_ANCIENT_FENCE_GATE = registerBlock("glimmering_ancient_fence_gate", () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get())));
    public static final DeferredBlock<DoorBlock> GLIMMERING_ANCIENT_DOOR = registerBlock("glimmering_ancient_door", () -> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> GLIMMERING_ANCIENT_TRAPDOOR = registerBlock("glimmering_ancient_trapdoor", () -> new TrapDoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(EMBlocks.GLIMMERING_ANCIENT_PLANKS.get()).noOcclusion()));

    // Ancient Wood
    public static final DeferredBlock<Block> ANCIENT_LOG = registerBlock("ancient_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG), true));
    public static final DeferredBlock<Block> ANCIENT_WOOD = registerBlock("ancient_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD), true));
    public static final DeferredBlock<Block> STRIPPED_ANCIENT_LOG = registerBlock("stripped_ancient_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG), true));
    public static final DeferredBlock<Block> STRIPPED_ANCIENT_WOOD = registerBlock("stripped_ancient_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD), true));

    public static final DeferredBlock<Block> ANCIENT_PLANKS = registerBlock("ancient_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

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
    public static final DeferredBlock<Block> SLIMY_LOG = registerBlock("slimy_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).sound(SoundType.SLIME_BLOCK), true));
    public static final DeferredBlock<Block> SLIMY_WOOD = registerBlock("slimy_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.SLIME_BLOCK), true));
    public static final DeferredBlock<Block> STRIPPED_SLIMY_LOG = registerBlock("stripped_slimy_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.SLIME_BLOCK), true));
    public static final DeferredBlock<Block> STRIPPED_SLIMY_WOOD = registerBlock("stripped_slimy_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.SLIME_BLOCK), true));

    public static final DeferredBlock<Block> SLIMY_PLANKS = registerBlock("slimy_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<Block> SLIMY_LEAVES = registerBlock("slimy_leaves", () -> new EMFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<Block> SLIMY_SAPLING = registerBlock("slimy_sapling", () -> new SaplingBlock(EMTreeGrowers.SLIMY_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> SLIMY_STAIRS = registerBlock("slimy_stairs", () -> new StairBlock(EMBlocks.SLIMY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> SLIMY_SLAB = registerBlock("slimy_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<PressurePlateBlock> SLIMY_PRESSURE_PLATE = registerBlock("slimy_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<ButtonBlock> SLIMY_BUTTON = registerBlock("slimy_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> SLIMY_FENCE = registerBlock("slimy_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> SLIMY_FENCE_GATE = registerBlock("slimy_fence_gate", () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get())));
    public static final DeferredBlock<DoorBlock> SLIMY_DOOR = registerBlock("slimy_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> SLIMY_TRAPDOOR = registerBlock("slimy_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.SLIMY_PLANKS.get()).noOcclusion()));

    // Frostpine Wood
    public static final DeferredBlock<Block> FROSTPINE_LOG = registerBlock("frostpine_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).sound(SoundType.WOOD), true));
    public static final DeferredBlock<Block> FROSTPINE_WOOD = registerBlock("frostpine_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD), true));
    public static final DeferredBlock<Block> STRIPPED_FROSTPINE_LOG = registerBlock("stripped_frostpine_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.WOOD), true));
    public static final DeferredBlock<Block> STRIPPED_FROSTPINE_WOOD = registerBlock("stripped_frostpine_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.WOOD), true));

    public static final DeferredBlock<Block> FROSTPINE_PLANKS = registerBlock("frostpine_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> FROSTPINE_LEAVES = registerBlock("frostpine_leaves", () -> new EMFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> FROSTPINE_SAPLING = registerBlock("frostpine_sapling", () -> new SaplingBlock(EMTreeGrowers.FROSTPINE_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> FROSTPINE_STAIRS = registerBlock("frostpine_stairs", () -> new StairBlock(EMBlocks.FROSTPINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.FROSTPINE_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> FROSTPINE_SLAB = registerBlock("frostpine_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.FROSTPINE_PLANKS.get())));
    public static final DeferredBlock<PressurePlateBlock> FROSTPINE_PRESSURE_PLATE = registerBlock("frostpine_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.FROSTPINE_PLANKS.get())));
    public static final DeferredBlock<ButtonBlock> FROSTPINE_BUTTON = registerBlock("frostpine_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(EMBlocks.FROSTPINE_PLANKS.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> FROSTPINE_FENCE = registerBlock("frostpine_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.FROSTPINE_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> FROSTPINE_FENCE_GATE = registerBlock("frostpine_fence_gate", () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.FROSTPINE_PLANKS.get())));
    public static final DeferredBlock<DoorBlock> FROSTPINE_DOOR = registerBlock("frostpine_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.FROSTPINE_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> FROSTPINE_TRAPDOOR = registerBlock("frostpine_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.FROSTPINE_PLANKS.get()).noOcclusion()));

    // Amberwood Wood
    public static final DeferredBlock<Block> AMBERWOOD_LOG = registerBlock("amberwood_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).sound(SoundType.WOOD), true));
    public static final DeferredBlock<Block> AMBERWOOD_WOOD = registerBlock("amberwood_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD), true));
    public static final DeferredBlock<Block> STRIPPED_AMBERWOOD_LOG = registerBlock("stripped_amberwood_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.WOOD), true));
    public static final DeferredBlock<Block> STRIPPED_AMBERWOOD_WOOD = registerBlock("stripped_amberwood_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.WOOD), true));

    public static final DeferredBlock<Block> AMBERWOOD_PLANKS = registerBlock("amberwood_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RED_AMBERWOOD_LEAVES = registerBlock("red_amberwood_leaves", () -> new EMAnimatedFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), EMParticleTypes.RED_LEAVES::get));
    public static final DeferredBlock<Block> ORANGE_AMBERWOOD_LEAVES = registerBlock("orange_amberwood_leaves", () -> new EMAnimatedFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), EMParticleTypes.ORANGE_LEAVES::get));
    public static final DeferredBlock<Block> YELLOW_AMBERWOOD_LEAVES = registerBlock("yellow_amberwood_leaves", () -> new EMAnimatedFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), EMParticleTypes.YELLOW_LEAVES::get));
    public static final DeferredBlock<Block> GREEN_AMBERWOOD_LEAVES = registerBlock("green_amberwood_leaves", () -> new EMFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredBlock<Block> GREEN_AMBERWOOD_SAPLING = registerBlock("green_amberwood_sapling", () -> new SaplingBlock(EMTreeGrowers.GREEN_AMBERWOOD_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> RED_AMBERWOOD_SAPLING = registerBlock("red_amberwood_sapling", () -> new SaplingBlock(EMTreeGrowers.RED_AMBERWOOD_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ORANGE_AMBERWOOD_SAPLING = registerBlock("orange_amberwood_sapling", () -> new SaplingBlock(EMTreeGrowers.ORANGE_AMBERWOOD_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> YELLOW_AMBERWOOD_SAPLING = registerBlock("yellow_amberwood_sapling", () -> new SaplingBlock(EMTreeGrowers.YELLOW_AMBERWOOD_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> AMBERWOOD_STAIRS = registerBlock("amberwood_stairs", () -> new StairBlock(EMBlocks.AMBERWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.AMBERWOOD_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> AMBERWOOD_SLAB = registerBlock("amberwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.AMBERWOOD_PLANKS.get())));
    public static final DeferredBlock<PressurePlateBlock> AMBERWOOD_PRESSURE_PLATE = registerBlock("amberwood_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.AMBERWOOD_PLANKS.get())));
    public static final DeferredBlock<ButtonBlock> AMBERWOOD_BUTTON = registerBlock("amberwood_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(EMBlocks.AMBERWOOD_PLANKS.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> AMBERWOOD_FENCE = registerBlock("amberwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.AMBERWOOD_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> AMBERWOOD_FENCE_GATE = registerBlock("amberwood_fence_gate", () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.AMBERWOOD_PLANKS.get())));
    public static final DeferredBlock<DoorBlock> AMBERWOOD_DOOR = registerBlock("amberwood_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.AMBERWOOD_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> AMBERWOOD_TRAPDOOR = registerBlock("amberwood_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.AMBERWOOD_PLANKS.get()).noOcclusion()));

    // Charred Wood
    public static final DeferredBlock<Block> CHARRED_LOG = registerBlock("charred_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(1.5F, 2.0F), false));
    public static final DeferredBlock<Block> CHARRED_WOOD = registerBlock("charred_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD).strength(1.5F, 2.0F), false));
    public static final DeferredBlock<Block> STRIPPED_CHARRED_LOG = registerBlock("stripped_charred_log", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.WOOD).strength(1.5F, 2.0F), false));
    public static final DeferredBlock<Block> STRIPPED_CHARRED_WOOD = registerBlock("stripped_charred_wood", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.WOOD).strength(1.5F, 2.0F), false));

    public static final DeferredBlock<Block> CHARRED_PLANKS = registerBlock("charred_planks", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(1.5F, 2.0F)));

    public static final DeferredBlock<Block> CHARRED_SAPLING = registerBlock("charred_sapling", () -> new EMStoneSapling(EMTreeGrowers.CHARRED_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> CHARRED_STAIRS = registerBlock("charred_stairs", () -> new StairBlock(EMBlocks.CHARRED_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.CHARRED_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> CHARRED_SLAB = registerBlock("charred_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.CHARRED_PLANKS.get())));
    public static final DeferredBlock<PressurePlateBlock> CHARRED_PRESSURE_PLATE = registerBlock("charred_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CHARRED_PLANKS.get())));
    public static final DeferredBlock<ButtonBlock> CHARRED_BUTTON = registerBlock("charred_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CHARRED_PLANKS.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> CHARRED_FENCE = registerBlock("charred_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.CHARRED_PLANKS.get())));
    public static final DeferredBlock<FenceGateBlock> CHARRED_FENCE_GATE = registerBlock("charred_fence_gate", () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CHARRED_PLANKS.get())));
    public static final DeferredBlock<DoorBlock> CHARRED_DOOR = registerBlock("charred_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CHARRED_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> CHARRED_TRAPDOOR = registerBlock("charred_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CHARRED_PLANKS.get()).noOcclusion()));

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
    public static final DeferredBlock<Block> CHISELED_TIMEWORN_SANDSTONE = registerBlock("chiseled_timeworn_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> TIMEWORN_SANDSTONE_STAIRS = registerBlock("timeworn_sandstone_stairs", () -> new StairBlock(EMBlocks.TIMEWORN_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<SlabBlock> TIMEWORN_SANDSTONE_SLAB = registerBlock("timeworn_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<WallBlock> TIMEWORN_SANDSTONE_WALL = registerBlock("timeworn_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.TIMEWORN_SANDSTONE.get())));

    public static final DeferredBlock<StairBlock> POLISHED_TIMEWORN_SANDSTONE_STAIRS = registerBlock("polished_timeworn_sandstone_stairs", () -> new StairBlock(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<SlabBlock> POLISHED_TIMEWORN_SANDSTONE_SLAB = registerBlock("polished_timeworn_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<PressurePlateBlock> POLISHED_TIMEWORN_SANDSTONE_PRESSURE_PLATE = registerBlock("polished_timeworn_sandstone_pressure_plate", () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())));
    public static final DeferredBlock<ButtonBlock> POLISHED_TIMEWORN_SANDSTONE_BUTTON = registerBlock("polished_timeworn_sandstone_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get()).noCollission()));
    public static final DeferredBlock<WallBlock> POLISHED_TIMEWORN_SANDSTONE_WALL = registerBlock("polished_timeworn_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.POLISHED_TIMEWORN_SANDSTONE.get())));

    // Cobbled Etherstone
    public static final DeferredBlock<Block> COBBLED_ETHERSTONE = registerBlock("cobbled_etherstone", CobbledEtherstone::new);
    public static final DeferredBlock<StairBlock> COBBLED_ETHERSTONE_STAIRS = registerBlock("cobbled_etherstone_stairs", () -> new StairBlock(EMBlocks.COBBLED_ETHERSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.COBBLED_ETHERSTONE.get())));
    public static final DeferredBlock<SlabBlock> COBBLED_ETHERSTONE_SLAB = registerBlock("cobbled_etherstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.COBBLED_ETHERSTONE.get())));
    public static final DeferredBlock<WallBlock> COBBLED_ETHERSTONE_WALL = registerBlock("cobbled_etherstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.COBBLED_ETHERSTONE.get())));

    public static final DeferredBlock<Block> MOSSY_COBBLED_ETHERSTONE = registerBlock("mossy_cobbled_etherstone", CobbledEtherstone::new);
    public static final DeferredBlock<StairBlock> MOSSY_COBBLED_ETHERSTONE_STAIRS = registerBlock("mossy_cobbled_etherstone_stairs", () -> new StairBlock(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get())));
    public static final DeferredBlock<SlabBlock> MOSSY_COBBLED_ETHERSTONE_SLAB = registerBlock("mossy_cobbled_etherstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get())));
    public static final DeferredBlock<WallBlock> MOSSY_COBBLED_ETHERSTONE_WALL = registerBlock("mossy_cobbled_etherstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.MOSSY_COBBLED_ETHERSTONE.get())));

    // Crumbling Etherstone
    public static final DeferredBlock<FallingBlock> CRUMBLING_ETHERSTONE = registerBlock("crumbling_etherstone", () -> new CrumblingEtherstone(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL)));

    // Flowers
    public static final DeferredBlock<FlowerBlock> GLIMMERBUD = registerBlock("glimmerbud", Glimmerbud::new);
    public static final DeferredBlock<FlowerPotBlock> GLIMMERBUD_FLOWER_POT = BLOCKS.register("glimmerbud_flower_pot", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EMBlocks.GLIMMERBUD, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)));

    public static final DeferredBlock<FlowerBlock> NIGHTBELL = registerBlock("nightbell", Nightbell::new);
    public static final DeferredBlock<FlowerPotBlock> NIGHTBELL_FLOWER_POT = BLOCKS.register("nightbell_flower_pot", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EMBlocks.NIGHTBELL, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)));

    public static final DeferredBlock<FlowerBlock> WITCH_LAVENDER = registerBlock("witch_lavender", WitchLavender::new);
    public static final DeferredBlock<FlowerPotBlock> WITCH_LAVENDER_FLOWER_POT = BLOCKS.register("witch_lavender_flower_pot", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EMBlocks.WITCH_LAVENDER, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)));

    public static final DeferredBlock<FlowerBlock> DAWNING_HYACINTH = registerBlock("dawning_hyacinth", DawningHyacinth::new);
    public static final DeferredBlock<FlowerPotBlock> DAWNING_HYACINTH_FLOWER_POT = BLOCKS.register("dawning_hyacinth_flower_pot", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EMBlocks.DAWNING_HYACINTH, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)));

    public static final DeferredBlock<Block> CINDERBLOOM = registerBlock("cinderbloom", Cinderbloom::new);
    public static final DeferredBlock<FlowerBlock> SLIMY_ALLIUM = registerBlock("slimy_allium", SlimyAllium::new);

    public static final DeferredBlock<FlowerBlock> SMALL_ABYSSAL_MUSHROOM = registerBlock("small_abyssal_mushroom", SmallAbyssalMushroom::new);
    public static final DeferredBlock<DoublePlantBlock> TALL_ABYSSAL_MUSHROOM = registerBlock("tall_abyssal_mushroom", TallAbyssalMushroom::new);
    public static final DeferredBlock<BushBlock> ABYSSAL_MUSHROOM = registerBlock("abyssal_mushroom", AbyssalMushroom::new);

    public static final DeferredBlock<BushBlock> RICH_GRASS = registerBlock("rich_grass", () -> new RichGrass(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
    public static final DeferredBlock<DoublePlantBlock> RICH_TALL_GRASS = registerBlock("rich_tall_grass", RichTallGrass::new);

    // Abyssal Mushroom
    public static final DeferredBlock<Block> LARGE_BLUE_ABYSSAL_MUSHROOM_TOP = registerBlock("large_blue_abyssal_mushroom_top", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK).strength(2.0f).sound(SoundType.MUD)));
    public static final DeferredBlock<Block> LARGE_ORANGE_ABYSSAL_MUSHROOM_TOP = registerBlock("large_orange_abyssal_mushroom_top", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK).strength(2.0f).sound(SoundType.MUD)));
    public static final DeferredBlock<Block> LARGE_ABYSSAL_MUSHROOM_GILLS = registerBlock("large_abyssal_mushroom_gills", () -> new EMRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK).strength(1.8F, 1.0F).sound(SoundType.MUD), false));
    public static final DeferredBlock<RotatedPillarBlock> LARGE_ABYSSAL_MUSHROOM_STEM = registerBlock("large_abyssal_mushroom_stem", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM).strength(2.0f).sound(SoundType.MUD)));

    public static final DeferredBlock<Block> CUBED_ABYSSAL_MUSHROOM = registerBlock("cubed_abyssal_mushroom", () -> new EMFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.MUDDY_MANGROVE_ROOTS)));
    
    public static final DeferredBlock<StairBlock> CUBED_ABYSSAL_MUSHROOM_STAIRS = registerBlock("cubed_abyssal_mushroom_stairs", () -> new StairBlock(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())));
    public static final DeferredBlock<SlabBlock> CUBED_ABYSSAL_MUSHROOM_SLAB = registerBlock("cubed_abyssal_mushroom_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())));
    public static final DeferredBlock<PressurePlateBlock> CUBED_ABYSSAL_MUSHROOM_PRESSURE_PLATE = registerBlock("cubed_abyssal_mushroom_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())));
    public static final DeferredBlock<ButtonBlock> CUBED_ABYSSAL_MUSHROOM_BUTTON = registerBlock("cubed_abyssal_mushroom_button", () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()).noCollission()));
    public static final DeferredBlock<FenceBlock> CUBED_ABYSSAL_MUSHROOM_FENCE = registerBlock("cubed_abyssal_mushroom_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())));
    public static final DeferredBlock<FenceGateBlock> CUBED_ABYSSAL_MUSHROOM_FENCE_GATE = registerBlock("cubed_abyssal_mushroom_fence_gate", () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get())));
    public static final DeferredBlock<DoorBlock> CUBED_ABYSSAL_MUSHROOM_DOOR = registerBlock("cubed_abyssal_mushroom_door", () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> CUBED_ABYSSAL_MUSHROOM_TRAPDOOR = registerBlock("cubed_abyssal_mushroom_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(EMBlocks.CUBED_ABYSSAL_MUSHROOM.get()).noOcclusion()));

    // Ores
    public static final DeferredBlock<Block> ETHERSTONE_COPPER_ORE = registerBlock("etherstone_copper_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE)));
    public static final DeferredBlock<Block> ETHERSTONE_IRON_ORE = registerBlock("etherstone_iron_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final DeferredBlock<Block> ETHERSTONE_COAL_ORE = registerBlock("etherstone_coal_ore", () -> new DropExperienceBlock(UniformInt.of(0, 2), BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE)));
    public static final DeferredBlock<Block> ETHERSTONE_REDSTONE_ORE = registerBlock("etherstone_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_ORE)));
    public static final DeferredBlock<Block> ETHERSTONE_LAPIS_ORE = registerBlock("etherstone_lapis_ore", () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_ORE)));
    public static final DeferredBlock<Block> ETHERSTONE_DIAMOND_ORE = registerBlock("etherstone_diamond_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));
    public static final DeferredBlock<Block> ETHERSTONE_GOLD_ORE = registerBlock("etherstone_gold_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE)));
    public static final DeferredBlock<Block> ETHERSTONE_EMERALD_ORE = registerBlock("etherstone_emerald_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)));

    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_COPPER_ORE = registerBlock("ancient_etherstone_copper_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE).strength(1.2f)));
    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_IRON_ORE = registerBlock("ancient_etherstone_iron_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE).strength(1.2f)));
    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_COAL_ORE = registerBlock("ancient_etherstone_coal_ore", () -> new DropExperienceBlock(UniformInt.of(0, 2), BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE).strength(1.2f)));
    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_REDSTONE_ORE = registerBlock("ancient_etherstone_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_ORE).strength(1.2f)));
    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_LAPIS_ORE = registerBlock("ancient_etherstone_lapis_ore", () -> new DropExperienceBlock(UniformInt.of(2, 5), BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_ORE).strength(1.2f)));
    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_DIAMOND_ORE = registerBlock("ancient_etherstone_diamond_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).strength(1.2f)));
    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_GOLD_ORE = registerBlock("ancient_etherstone_gold_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE).strength(1.2f)));
    public static final DeferredBlock<Block> ANCIENT_ETHERSTONE_EMERALD_ORE = registerBlock("ancient_etherstone_emerald_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE).strength(1.2f)));

    // Misc
    public static final DeferredBlock<Block> ICICLE = registerBlock("icicle", Icicle::new);


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
