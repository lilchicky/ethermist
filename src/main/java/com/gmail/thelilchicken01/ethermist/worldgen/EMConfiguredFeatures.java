package com.gmail.thelilchicken01.ethermist.worldgen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class EMConfiguredFeatures {

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        EMGeneralFeatures.bootstrap(context);
        EMOreFeatures.bootstrap(context);

    }

}
