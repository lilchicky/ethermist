package com.gmail.thelilchicken01.ethermist.datagen.structure.pools;

import com.gmail.thelilchicken01.ethermist.datagen.structure.pools.ruins.RuinsPools;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class EMTemplatePoolsProvider {

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        ForgemasterCastlePools.bootstrap(context);
        GlimmerbugCavePools.bootstrap(context);
        PortalPools.bootstrap(context);
        RuinsPools.bootstrap(context);
    }

}
