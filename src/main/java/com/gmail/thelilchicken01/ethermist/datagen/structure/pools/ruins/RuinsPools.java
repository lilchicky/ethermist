package com.gmail.thelilchicken01.ethermist.datagen.structure.pools.ruins;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class RuinsPools {
    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        GenericRuinsPools.bootstrap(context);
        StoneRuinsPools.bootstrap(context);
    }
}
