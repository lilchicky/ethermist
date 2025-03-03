package com.gmail.thelilchicken01.ethermist.worldgen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EMPlacedFeatures {

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        EMGeneralPlacedFeatures.bootstrap(context);
        EMOresPlaced.bootstrap(context);

    }

}
