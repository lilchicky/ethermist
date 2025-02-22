package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.worldgen.EMConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class EMTreeGrowers {

    public static final TreeGrower GLIMMERING_ANCIENT_TREE = new TreeGrower(Ethermist.MODID + ":glimmering_ancient_tree",
            Optional.of(EMConfiguredFeatures.MEGA_GLIMMERING_ANCIENT_TREE_KEY), Optional.of(EMConfiguredFeatures.GLIMMERING_ANCIENT_TREE_KEY), Optional.empty());

    public static final TreeGrower ANCIENT_TREE = new TreeGrower(Ethermist.MODID + ":ancient_tree",
            Optional.of(EMConfiguredFeatures.MEGA_ANCIENT_TREE_KEY), Optional.of(EMConfiguredFeatures.ANCIENT_TREE_KEY), Optional.empty());

    public static final TreeGrower SLIMY_TREE = new TreeGrower(Ethermist.MODID + ":slimy_tree",
            Optional.empty(), Optional.of(EMConfiguredFeatures.SLIMY_TREE_KEY), Optional.empty());

    public static final TreeGrower BLUE_ABYSSAL_MUSHROOM = new TreeGrower(Ethermist.MODID + ":blue_abyssal_mushroom",
            Optional.empty(), Optional.of(EMConfiguredFeatures.BLUE_ABYSSAL_MUSHROOM_KEY), Optional.empty());

    public static final TreeGrower ORANGE_ABYSSAL_MUSHROOM = new TreeGrower(Ethermist.MODID + ":orange_abyssal_mushroom",
            Optional.empty(), Optional.of(EMConfiguredFeatures.ORANGE_ABYSSAL_MUSHROOM_KEY), Optional.empty());

    public static final TreeGrower FROSTPINE_TREE = new TreeGrower(Ethermist.MODID + ":frostpine_tree",
            Optional.empty(), Optional.of(EMConfiguredFeatures.FROSTPINE_TREE_KEY), Optional.empty());

    public static final TreeGrower RED_AMBERWOOD_TREE = new TreeGrower(Ethermist.MODID + ":red_amberwood_tree",
            Optional.of(EMConfiguredFeatures.RED_MEGA_AMBERWOOD_TREE_KEY), Optional.of(EMConfiguredFeatures.RED_AMBERWOOD_TREE_KEY), Optional.empty());
    public static final TreeGrower GREEN_AMBERWOOD_TREE = new TreeGrower(Ethermist.MODID + ":green_amberwood_tree",
            Optional.of(EMConfiguredFeatures.GREEN_MEGA_AMBERWOOD_TREE_KEY), Optional.of(EMConfiguredFeatures.GREEN_AMBERWOOD_TREE_KEY), Optional.empty());
    public static final TreeGrower ORANGE_AMBERWOOD_TREE = new TreeGrower(Ethermist.MODID + ":orange_amberwood_tree",
            Optional.of(EMConfiguredFeatures.ORANGE_MEGA_AMBERWOOD_TREE_KEY), Optional.of(EMConfiguredFeatures.ORANGE_AMBERWOOD_TREE_KEY), Optional.empty());
    public static final TreeGrower YELLOW_AMBERWOOD_TREE = new TreeGrower(Ethermist.MODID + ":yellow_amberwood_tree",
            Optional.of(EMConfiguredFeatures.YELLOW_MEGA_AMBERWOOD_TREE_KEY), Optional.of(EMConfiguredFeatures.YELLOW_AMBERWOOD_TREE_KEY), Optional.empty());

    public static final TreeGrower CHARRED_TREE = new TreeGrower(Ethermist.MODID + ":charred_tree",
            Optional.empty(), Optional.of(EMConfiguredFeatures.CHARRED_TREE_STUMP_KEY), Optional.empty());

}
