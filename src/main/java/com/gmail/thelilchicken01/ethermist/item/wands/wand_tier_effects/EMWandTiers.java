package com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects;

import com.gmail.thelilchicken01.ethermist.EMRegistries;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;

public final class EMWandTiers {

    // Default Wand Values
    public static final double DIAMOND_DURABILITY_MULT = 5.0;
    public static final double LAPIS_ENCHANTABILITY_MULT = 2.5;

    // WOODEN (default)
    public static final DeferredHolder<WandTier, WandTier> WOODEN =
            EMRegistries.WAND_TIERS.register("wooden", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wooden"),
                            "wooden", "no_change",
                            List.of(),
                            new float[]{1f, 1f, 1f},
                            () -> Ingredient.of(ItemTags.PLANKS),
                            false,
                            WandTier.TooltipStyle.DEFAULT,
                            false
                    )
            );

    // EMERALD: +2s lifespan
    public static final DeferredHolder<WandTier, WandTier> EMERALD =
            EMRegistries.WAND_TIERS.register("emerald", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "emerald"),
                            "emerald", "bonus_lifespan",
                            List.of(new WandAttributeState.AttributeModifierHolder(WandAttributeState.WandAttribute.LIFESPAN_SECONDS, WandAttributeState.Operation.ADDITION, 2.0, true)),
                            new float[]{0.086f, 0.839f, 0.380f},
                            () -> Ingredient.of(Tags.Items.GEMS_EMERALD),
                            true,
                            WandTier.TooltipStyle.ADDITION,
                            false
                    )
            );

    // GOLDEN: +3 damage
    public static final DeferredHolder<WandTier, WandTier> GOLDEN =
            EMRegistries.WAND_TIERS.register("golden", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "golden"),
                            "golden", "bonus_damage",
                            List.of(new WandAttributeState.AttributeModifierHolder(WandAttributeState.WandAttribute.DAMAGE, WandAttributeState.Operation.ADDITION, 3.0, false)),
                            new float[]{0.992f, 0.961f, 0.373f},
                            () -> Ingredient.of(Tags.Items.INGOTS_GOLD),
                            false,
                            WandTier.TooltipStyle.ADDITION,
                            false
                    )
            );

    // DIAMOND: Durability
    public static final DeferredHolder<WandTier, WandTier> DIAMOND =
            EMRegistries.WAND_TIERS.register("diamond", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "diamond"),
                            "diamond", "durability_mult",
                            List.of(),
                            new float[]{0.318f, 0.929f, 0.859f},
                            () -> Ingredient.of(Tags.Items.GEMS_DIAMOND),
                            false,
                            WandTier.TooltipStyle.MULT,
                            false
                    )
            );

    // LAPIS: Enchantability
    public static final DeferredHolder<WandTier, WandTier> LAPIS =
            EMRegistries.WAND_TIERS.register("lapis", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "lapis"),
                            "lapis", "enchant_mult",
                            List.of(),
                            new float[]{0.196f, 0.357f, 0.741f},
                            () -> Ingredient.of(Tags.Items.GEMS_LAPIS),
                            false,
                            WandTier.TooltipStyle.MULT,
                            false
                    )
            );

    // QUARTZ: +50% knockback
    public static final DeferredHolder<WandTier, WandTier> QUARTZ =
            EMRegistries.WAND_TIERS.register("nether_quartz", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "nether_quartz"),
                            "nether_quartz", "bonus_knockback",
                            List.of(new WandAttributeState.AttributeModifierHolder(WandAttributeState.WandAttribute.KNOCKBACK_MULT, WandAttributeState.Operation.ADDITION, 0.5, false)),
                            new float[]{0.847f, 0.847f, 0.847f},
                            () -> Ingredient.of(Tags.Items.GEMS_QUARTZ),
                            false,
                            WandTier.TooltipStyle.PERCENT,
                            false
                    )
            );

    // REDSTONE: -2s cooldown
    public static final DeferredHolder<WandTier, WandTier> REDSTONE =
            EMRegistries.WAND_TIERS.register("redstone", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "redstone"),
                            "redstone", "bonus_cooldown",
                            List.of(new WandAttributeState.AttributeModifierHolder(WandAttributeState.WandAttribute.COOLDOWN_TICKS, WandAttributeState.Operation.ADDITION, -2.0, true)),
                            new float[]{0.965f, 0f, 0f},
                            () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE),
                            true,
                            WandTier.TooltipStyle.ADDITION,
                            false
                    )
            );

    // GLOWSTONE: +25% projectile speed
    public static final DeferredHolder<WandTier, WandTier> GLOWSTONE =
            EMRegistries.WAND_TIERS.register("glowstone", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glowstone"),
                            "glowstone", "bonus_bolt_speed",
                            List.of(new WandAttributeState.AttributeModifierHolder(WandAttributeState.WandAttribute.PROJECTILE_SPEED_MULT, WandAttributeState.Operation.ADDITION, 0.25, false)),
                            new float[]{1f, 0.737f, 0.369f},
                            () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE),
                            false,
                            WandTier.TooltipStyle.PERCENT,
                            false
                    )
            );

    // PRISMARINE: +5% accuracy
    public static final DeferredHolder<WandTier, WandTier> PRISMARINE =
            EMRegistries.WAND_TIERS.register("prismarine", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "prismarine"),
                            "prismarine", "bonus_accuracy",
                            List.of(new WandAttributeState.AttributeModifierHolder(WandAttributeState.WandAttribute.INACCURACY_PERCENT, WandAttributeState.Operation.ADDITION, 5.0, false)),
                            new float[]{0.706f, 0.847f, 0.792f},
                            () -> Ingredient.of(Tags.Items.GEMS_PRISMARINE),
                            false,
                            WandTier.TooltipStyle.PERCENT,
                            false
                    )
            );

    // NETHERITE: Wand Buffs
    public static final DeferredHolder<WandTier, WandTier> NETHERITE =
            EMRegistries.WAND_TIERS.register("netherite", () ->
                    new WandTier(
                            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "netherite"),
                            "netherite", "buff_effect",
                            List.of(),
                            new float[]{0.32f, 0.32f, 0.32f},
                            () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE),
                            false,
                            WandTier.TooltipStyle.BUFF_EFFECT,
                            true
                    )
            );

}
