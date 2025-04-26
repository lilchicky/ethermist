package com.gmail.thelilchicken01.ethermist.datagen.recipes;

import com.gmail.thelilchicken01.ethermist.item.EMItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EMWandMappings {

    public static final Map<Supplier<? extends Item>, Map<String, WandMapping>> WAND_MAPS = new HashMap<>();

    public static int registerMappings() {
        registerWandType(EMItems.DULL_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_DULL_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_DULL_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_DULL_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_DULL_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_DULL_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_DULL_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_DULL_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_DULL_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_DULL_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_DULL_WAND)
        );
        registerWandType(EMItems.FLAME_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_FLAME_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_FLAME_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_FLAME_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_FLAME_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_FLAME_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_FLAME_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_FLAME_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_FLAME_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_FLAME_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_FLAME_WAND)
        );
        registerWandType(EMItems.LEVITATION_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_LEVITATION_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_LEVITATION_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_LEVITATION_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_LEVITATION_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_LEVITATION_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_LEVITATION_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_LEVITATION_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_LEVITATION_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_LEVITATION_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_LEVITATION_WAND)
        );
        registerWandType(EMItems.WITHER_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_WITHER_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_WITHER_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_WITHER_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_WITHER_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_WITHER_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_WITHER_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_WITHER_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_WITHER_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_WITHER_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_WITHER_WAND)
        );
        registerWandType(EMItems.POISON_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_POISON_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_POISON_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_POISON_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_POISON_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_POISON_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_POISON_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_POISON_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_POISON_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_POISON_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_POISON_WAND)
        );
        registerWandType(EMItems.WITCH_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_WITCH_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_WITCH_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_WITCH_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_WITCH_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_WITCH_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_WITCH_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_WITCH_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_WITCH_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_WITCH_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_WITCH_WAND)
        );
        registerWandType(EMItems.FROZEN_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_FROZEN_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_FROZEN_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_FROZEN_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_FROZEN_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_FROZEN_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_FROZEN_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_FROZEN_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_FROZEN_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_FROZEN_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_FROZEN_WAND)
        );
        registerWandType(EMItems.GLASS_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_GLASS_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_GLASS_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_GLASS_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_GLASS_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_GLASS_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_GLASS_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_GLASS_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_GLASS_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_GLASS_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_GLASS_WAND)
        );
        registerWandType(() -> Items.HEAVY_CORE,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_HEAVY_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_HEAVY_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_HEAVY_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_HEAVY_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_HEAVY_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_HEAVY_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_HEAVY_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_HEAVY_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_HEAVY_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_HEAVY_WAND)
        );
        registerWandType(EMItems.GLIMMERBUG_ORB,
                new SupplierTriple("wooden", EMItems.WOODEN_WAND_HANDLE, EMItems.WOODEN_GLIMMERBUG_WAND),
                new SupplierTriple("emerald", EMItems.EMERALD_WAND_HANDLE, EMItems.EMERALD_GLIMMERBUG_WAND),
                new SupplierTriple("diamond", EMItems.DIAMOND_WAND_HANDLE, EMItems.DIAMOND_GLIMMERBUG_WAND),
                new SupplierTriple("golden", EMItems.GOLDEN_WAND_HANDLE, EMItems.GOLDEN_GLIMMERBUG_WAND),
                new SupplierTriple("lapis", EMItems.LAPIS_WAND_HANDLE, EMItems.LAPIS_GLIMMERBUG_WAND),
                new SupplierTriple("quartz", EMItems.QUARTZ_WAND_HANDLE, EMItems.QUARTZ_GLIMMERBUG_WAND),
                new SupplierTriple("redstone", EMItems.REDSTONE_WAND_HANDLE, EMItems.REDSTONE_GLIMMERBUG_WAND),
                new SupplierTriple("glowstone", EMItems.GLOWSTONE_WAND_HANDLE, EMItems.GLOWSTONE_GLIMMERBUG_WAND),
                new SupplierTriple("prismarine", EMItems.PRISMARINE_WAND_HANDLE, EMItems.PRISMARINE_GLIMMERBUG_WAND),
                new SupplierTriple("netherite", EMItems.NETHERITE_WAND_HANDLE, EMItems.NETHERITE_GLIMMERBUG_WAND)
        );

        return WAND_MAPS.size();

    }

    private static void registerWandType(Supplier<? extends Item> orb, SupplierTriple... triples) {
        Map<String, WandMapping> tierMap = new HashMap<>();
        for (SupplierTriple triple : triples) {
            tierMap.put(triple.tier(), new WandMapping(triple.handle(), triple.wand()));
        }
        WAND_MAPS.put(orb, tierMap);
    }

    public record WandMapping(Supplier<? extends Item> handle, Supplier<? extends Item> wand) {}
    public record SupplierTriple(String tier, Supplier<Item> handle, Supplier<? extends Item> wand) {}
}
