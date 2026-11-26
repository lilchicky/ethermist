package com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects;

import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeStateTest;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.gmail.thelilchicken01.ethermist.util.EMRegistries;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public final class EMWandHandles {

    public static final DeferredRegister<WandHandle> EM_WAND_HANDLES =
            DeferredRegister.create(EMRegistries.WAND_HANDLES.getRegistryName(), Ethermist.MODID);

    // Default Wand Values
    public static final double DIAMOND_DURABILITY_MULT = 5.0;
    public static final double LAPIS_ENCHANTABILITY_MULT = 2.5;

    // WOODEN (default)
    public static final DeferredHolder<WandHandle, WandHandle> WOODEN =
            EM_WAND_HANDLES.register("wooden", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wooden"),
                            "wooden",
                            List.of(),
                            new float[]{1f, 1f, 1f},
                            () -> Ingredient.of(ItemTags.PLANKS),
                            false,
                            false
                    )
            );

    // EMERALD: +2s lifespan
    public static final DeferredHolder<WandHandle, WandHandle> EMERALD =
            EM_WAND_HANDLES.register("emerald", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "emerald"),
                            "emerald",
                            List.of(
                                    new WandAttributeStateTest.WandAttributeHolder("modify_lifespan", EMAttributes.LIFESPAN, WandItem.LIFESPAN_ID, 2.0f, WandAttributeStateTest.Operation.ADDITION)
                            ),
                            new float[]{0.086f, 0.839f, 0.380f},
                            () -> Ingredient.of(Tags.Items.GEMS_EMERALD),
                            true,
                            false
                    )
            );

    // GOLDEN: +3 damage
    public static final DeferredHolder<WandHandle, WandHandle> GOLDEN =
            EM_WAND_HANDLES.register("golden", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "golden"),
                            "golden",
                            List.of(
                                    new WandAttributeStateTest.WandAttributeHolder("modify_damage", EMAttributes.WAND_DAMAGE, WandItem.BASE_WAND_DAMAGE_ID, 3.0f, WandAttributeStateTest.Operation.ADDITION)
                            ),
                            new float[]{0.992f, 0.961f, 0.373f},
                            () -> Ingredient.of(Tags.Items.INGOTS_GOLD),
                            true,
                            false
                    )
            );

    // DIAMOND: Durability
    public static final DeferredHolder<WandHandle, WandHandle> DIAMOND =
            EM_WAND_HANDLES.register("diamond", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "diamond"),
                            "diamond",
                            List.of(),
                            new float[]{0.318f, 0.929f, 0.859f},
                            () -> Ingredient.of(Tags.Items.GEMS_DIAMOND),
                            true,
                            false,
                            DIAMOND_DURABILITY_MULT,
                            1.0
                    )
            );

    // LAPIS: Enchantability
    public static final DeferredHolder<WandHandle, WandHandle> LAPIS =
            EM_WAND_HANDLES.register("lapis", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "lapis"),
                            "lapis",
                            List.of(),
                            new float[]{0.196f, 0.357f, 0.741f},
                            () -> Ingredient.of(Tags.Items.GEMS_LAPIS),
                            true,
                            false,
                            1.0,
                            LAPIS_ENCHANTABILITY_MULT
                    )
            );

    // QUARTZ: +50% knockback
    public static final DeferredHolder<WandHandle, WandHandle> QUARTZ =
            EM_WAND_HANDLES.register("nether_quartz", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "nether_quartz"),
                            "nether_quartz",
                            List.of(
                                    new WandAttributeStateTest.WandAttributeHolder("modify_knockback", EMAttributes.WAND_KNOCKBACK, WandItem.WAND_KNOCKBACK_ID, 0.5f, WandAttributeStateTest.Operation.PERCENT)
                            ),
                            new float[]{0.847f, 0.847f, 0.847f},
                            () -> Ingredient.of(Tags.Items.GEMS_QUARTZ),
                            true,
                            false
                    )
            );

    // REDSTONE: -2s cooldown
    public static final DeferredHolder<WandHandle, WandHandle> REDSTONE =
            EM_WAND_HANDLES.register("redstone", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "redstone"),
                            "redstone",
                            List.of(
                                    new WandAttributeStateTest.WandAttributeHolder("modify_cooldown", EMAttributes.COOLDOWN, WandItem.COOLDOWN_ID, -2.0f, WandAttributeStateTest.Operation.ADDITION)
                            ),
                            new float[]{0.965f, 0f, 0f},
                            () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE),
                            true,
                            false
                    )
            );

    // GLOWSTONE: +25% projectile speed
    public static final DeferredHolder<WandHandle, WandHandle> GLOWSTONE =
            EM_WAND_HANDLES.register("glowstone", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glowstone"),
                            "glowstone",
                            List.of(
                                    new WandAttributeStateTest.WandAttributeHolder("modify_projectile_speed", EMAttributes.PROJECTILE_SPEED, WandItem.PROJECTILE_SPEED_ID, 0.25f, WandAttributeStateTest.Operation.PERCENT)
                            ),
                            new float[]{1f, 0.737f, 0.369f},
                            () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE),
                            true,
                            false
                    )
            );

    // PRISMARINE: +10% accuracy
    public static final DeferredHolder<WandHandle, WandHandle> PRISMARINE =
            EM_WAND_HANDLES.register("prismarine", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "prismarine"),
                            "prismarine",
                            List.of(
                                    new WandAttributeStateTest.WandAttributeHolder("modify_accuracy", EMAttributes.ACCURACY, WandItem.ACCURACY_ID, 0.1f, WandAttributeStateTest.Operation.PERCENT)
                            ),
                            new float[]{0.706f, 0.847f, 0.792f},
                            () -> Ingredient.of(Tags.Items.GEMS_PRISMARINE),
                            true,
                            false
                    )
            );

    // NETHERITE: Wand Buffs
    public static final DeferredHolder<WandHandle, WandHandle> NETHERITE =
            EM_WAND_HANDLES.register("netherite", () ->
                    new WandHandle(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "netherite"),
                            "netherite",
                            List.of(),
                            new float[]{0.32f, 0.32f, 0.32f},
                            () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE),
                            true,
                            true
                    )
            );

    public static void register (IEventBus bus) {
        EM_WAND_HANDLES.register(bus);
    }

}
