package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.neoforged.neoforge.common.extensions.IAttributeExtension.FORMAT;

public enum WandTiers implements IWandTiers {

    WOODEN(
            "wooden",
            "no_change",
            0,
            WandUtil.ModifierType.DEFAULT,
            false,
            new float[]{1.0f, 1.0f, 1.0f},
            () -> Ingredient.of(
                    ItemTags.PLANKS
            )
    ),
    /*
    LIFESPAN
     */
    EMERALD(
            "emerald",
            "bonus_lifespan",
            2,
            WandUtil.ModifierType.ADDITION,
            true,
            new float[]{0.086f, 0.839f, 0.380f},
            () -> Ingredient.of(
                    Tags.Items.GEMS_EMERALD
            )
    ),
    /*
    DAMAGE
     */
    GOLDEN(
            "golden",
            "bonus_damage",
            3,
            WandUtil.ModifierType.ADDITION,
            false,
            new float[]{0.992f, 0.961f, 0.373f},
            () -> Ingredient.of(
                    Tags.Items.INGOTS_GOLD
            )
    ),
    /*
    DURABILITY
     */
    DIAMOND(
            "diamond",
            "durability_mult",
            5,
            WandUtil.ModifierType.MULT,
            false,
            new float[]{0.318f, 0.929f, 0.859f},
            () -> Ingredient.of(
                    Tags.Items.GEMS_DIAMOND
            )
    ),
    /*
    ENCHANTABILITY
     */
    LAPIS(
            "lapis",
            "enchant_mult",
            4,
            WandUtil.ModifierType.MULT,
            false,
            new float[]{0.196f, 0.357f, 0.741f},
            () -> Ingredient.of(
                    Tags.Items.GEMS_LAPIS
            )
    ),
    /*
    KNOCKBACK
     */
    QUARTZ(
            "nether_quartz",
            "bonus_knockback",
            0.5,
            WandUtil.ModifierType.PERCENT,
            false,
            new float[]{0.847f, 0.847f, 0.847f},
            () -> Ingredient.of(
                    Tags.Items.GEMS_QUARTZ
            )
    ),
    /*
    COOLDOWN
     */
    REDSTONE(
            "redstone",
            "bonus_cooldown",
            -2,
            WandUtil.ModifierType.ADDITION,
            true,
            new float[]{0.965f, 0.000f, 0.000f},
            () -> Ingredient.of(
                    Tags.Items.DUSTS_REDSTONE
            )
    ),
    /*
    BOLT SPEED
     */
    GLOWSTONE(
            "glowstone",
            "bonus_bolt_speed",
            0.25,
            WandUtil.ModifierType.PERCENT,
            false,
            new float[]{1.000f, 0.737f, 0.369f},
            () -> Ingredient.of(
                    Tags.Items.DUSTS_GLOWSTONE
            )
    ),
    /*
    ACCURACY
     */
    PRISMARINE(
            "prismarine",
            "bonus_accuracy",
            5,
            WandUtil.ModifierType.PERCENT,
            false,
            new float[]{0.706f, 0.847f, 0.792f},
            () -> Ingredient.of(
                    Tags.Items.GEMS_PRISMARINE
            )
    ),
    /*
    BUFF SPELLS
     */
    NETHERITE(
            "netherite",
            "buff_effect",
            0,
            WandUtil.ModifierType.BUFF_EFFECT,
            false,
            new float[]{0.32f, 0.32f, 0.32f},
            () -> Ingredient.of(
                    Tags.Items.INGOTS_NETHERITE
            )
    );

    private final String description;
    private final String modifiedName;
    private final double modifier;
    private final WandUtil.ModifierType modifierType;
    private final boolean isSeconds;
    private final float[] handleColor;
    private final Supplier<Ingredient> repairItem;


    WandTiers(String description, String modifiedName, double modifier,
               WandUtil.ModifierType modifierType, boolean isSeconds, float[] handleColor, Supplier<Ingredient> repairItem) {

        this.description = description;
        this.modifiedName = modifiedName;
        this.modifier = modifier;
        this.modifierType = modifierType;
        this.isSeconds = isSeconds;
        this.handleColor = handleColor;
        this.repairItem = repairItem;

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float[] getHandleColor() {
        return handleColor;
    }

    @Override
    public Supplier<Ingredient> getRepairItem() {
        return repairItem;
    }

    @Override
    public double getModifierFor(IWandTiers targetTier) {
        int unmodified = this.modifierType == WandUtil.ModifierType.MULT ? 1 : 0;
        return this == targetTier ? this.modifier : unmodified;
    }

    @Override
    public List<Component> getModifierString() {

        int color = 0xAAAAAA;

        List<Component> handleLore = new ArrayList<>(List.of(Component.translatable("item.ethermist.wand_handle." + description + ".desc").withColor(color)));

        Component base = Component.translatable("item.ethermist.wand_handle." + modifiedName);

        switch (modifierType) {
            case ADDITION -> handleLore.add(base.copy().append(
                    Component.literal(modifier > 0 ? "+" + FORMAT.format(modifier) : FORMAT.format(modifier))).append(
                    isSeconds ?
                            Component.translatable("generic.ethermist.time.seconds")
                            : Component.empty()).withColor(color));

            case PERCENT -> {
                if (this == PRISMARINE) {
                    handleLore.add(base.copy().append(
                            Component.literal(modifier > 0 ? "+" + FORMAT.format(modifier) : FORMAT.format(modifier))
                                    .append(Component.literal("%"))).withColor(color));
                } else {
                    handleLore.add(base.copy().append(
                            Component.literal(modifier > 0 ? "+" + FORMAT.format(modifier * 100) : FORMAT.format(modifier * 100))
                                    .append(Component.literal("%"))).withColor(color));
                }
            }

            case MULT -> {
                String valueStr = "x" + FORMAT.format(modifier);

                handleLore.add(base.copy().append(Component.literal(valueStr)).withColor(color));
            }

            case DEFAULT ->
                    handleLore.add(Component.translatable("item.ethermist.wand_handle.no_change").withColor(color));

            case BUFF_EFFECT ->
                    handleLore.add(Component.translatable("item.ethermist.wand_handle.buff_effect").withColor(color));
        }

        return handleLore;
    }


}
