package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.worldgen.EMGeneralFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class EMTreeGrowers {

    public static final TreeGrower GLIMMERING_ANCIENT_TREE = new TreeGrower(Ethermist.MODID + ":glimmering_ancient_tree",
            Optional.of(EMGeneralFeatures.MEGA_GLIMMERING_ANCIENT_TREE_KEY), Optional.of(EMGeneralFeatures.GLIMMERING_ANCIENT_TREE_KEY), Optional.empty());

    public static final TreeGrower ANCIENT_TREE = new TreeGrower(Ethermist.MODID + ":ancient_tree",
            Optional.of(EMGeneralFeatures.MEGA_ANCIENT_TREE_KEY), Optional.of(EMGeneralFeatures.ANCIENT_TREE_KEY), Optional.empty());

    public static final TreeGrower SLIMY_TREE = new TreeGrower(Ethermist.MODID + ":slimy_tree",
            Optional.empty(), Optional.of(EMGeneralFeatures.SLIMY_TREE_KEY), Optional.empty());

    public static final TreeGrower LARGE_ABYSSAL_MUSHROOM = new TreeGrower(Ethermist.MODID + ":large_abyssal_mushroom",
            Optional.empty(), Optional.of(EMGeneralFeatures.LARGE_ABYSSAL_MUSHROOM_KEY), Optional.empty());

    public static final TreeGrower FROSTPINE_TREE = new TreeGrower(Ethermist.MODID + ":frostpine_tree",
            Optional.empty(), Optional.of(EMGeneralFeatures.FROSTPINE_TREE_KEY), Optional.empty());

    public static final TreeGrower RED_AMBERWOOD_TREE = new TreeGrower(Ethermist.MODID + ":red_amberwood_tree",
            Optional.of(EMGeneralFeatures.RED_MEGA_AMBERWOOD_TREE_KEY), Optional.of(EMGeneralFeatures.RED_AMBERWOOD_TREE_KEY), Optional.empty());
    public static final TreeGrower GREEN_AMBERWOOD_TREE = new TreeGrower(Ethermist.MODID + ":green_amberwood_tree",
            Optional.of(EMGeneralFeatures.GREEN_MEGA_AMBERWOOD_TREE_KEY), Optional.of(EMGeneralFeatures.GREEN_AMBERWOOD_TREE_KEY), Optional.empty());
    public static final TreeGrower ORANGE_AMBERWOOD_TREE = new TreeGrower(Ethermist.MODID + ":orange_amberwood_tree",
            Optional.of(EMGeneralFeatures.ORANGE_MEGA_AMBERWOOD_TREE_KEY), Optional.of(EMGeneralFeatures.ORANGE_AMBERWOOD_TREE_KEY), Optional.empty());
    public static final TreeGrower YELLOW_AMBERWOOD_TREE = new TreeGrower(Ethermist.MODID + ":yellow_amberwood_tree",
            Optional.of(EMGeneralFeatures.YELLOW_MEGA_AMBERWOOD_TREE_KEY), Optional.of(EMGeneralFeatures.YELLOW_AMBERWOOD_TREE_KEY), Optional.empty());

    public static final TreeGrower CHARRED_TREE = new TreeGrower(Ethermist.MODID + ":charred_tree",
            Optional.empty(), Optional.of(EMGeneralFeatures.CHARRED_TREE_KEY), Optional.empty());

}
