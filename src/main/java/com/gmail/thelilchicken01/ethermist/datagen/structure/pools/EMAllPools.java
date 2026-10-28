package com.gmail.thelilchicken01.ethermist.datagen.structure.pools;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class EMAllPools {

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        ForgemasterCastlePools.bootstrap(context);
    }

}
