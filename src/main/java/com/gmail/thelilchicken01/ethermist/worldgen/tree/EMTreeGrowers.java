package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.worldgen.EMConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class EMTreeGrowers {

    public static final TreeGrower ANCIENT_TREE = new TreeGrower(Ethermist.MODID + ":ancient_tree",
            Optional.empty(), Optional.of(EMConfiguredFeatures.ANCIENT_TREE_KEY), Optional.empty());

}
