package com.gmail.thelilchicken01.ethermist.datagen;

import com.gmail.thelilchicken01.ethermist.util.EMDamageTypes;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageType;

public class EMDamageTypesProvider {

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(EMDamageTypes.GENERIC_MAGIC, new DamageType("generic_magic", 1.0f));
        context.register(EMDamageTypes.POISON_MAGIC, new DamageType("poison_magic", 1.0f));
        context.register(EMDamageTypes.FLAME_MAGIC, new DamageType("flame_magic", 1.0f));
        context.register(EMDamageTypes.WITHER_MAGIC, new DamageType("wither_magic", 1.0f));
        context.register(EMDamageTypes.LEVITATION_MAGIC, new DamageType("levitation_magic", 1.0f));
        context.register(EMDamageTypes.WITCH_MAGIC, new DamageType("witch_magic", 1.0f));
        context.register(EMDamageTypes.HEAVY_MAGIC, new DamageType("heavy_magic", 1.0f));
        context.register(EMDamageTypes.FROZEN_MAGIC, new DamageType("frozen_magic", 1.0f));
        context.register(EMDamageTypes.GLASS_MAGIC, new DamageType("glass_magic", 1.0f));
        context.register(EMDamageTypes.GLIMMERBUG_MAGIC, new DamageType("glimmerbug_magic", 1.0f));
        context.register(EMDamageTypes.FORGEMASTER_MAGIC, new DamageType("forgemaster_magic", 1.0f));

        context.register(EMDamageTypes.FORGEMASTER_SHOT, new DamageType("forgemaster_shot", 1.0f));
        context.register(EMDamageTypes.FORGEMASTER_KNOCKUP, new DamageType("forgemaster_knockup", 1.0f));

        context.register(EMDamageTypes.ICICLE, new DamageType("icicle", 1.0f));
    }

}
