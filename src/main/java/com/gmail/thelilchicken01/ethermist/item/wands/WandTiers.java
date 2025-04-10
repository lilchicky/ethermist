package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandUtil;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

import static net.neoforged.neoforge.common.extensions.IAttributeExtension.FORMAT;

public enum WandTiers {

    WOODEN(
            "wooden",
            "no_change",
            0,
            WandUtil.ModifierType.DEFAULT,
            false,
            new float[]{1.0f, 1.0f, 1.0f}
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
            new float[]{0.314f, 0.784f, 0.471f}
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
            new float[]{0.996f, 0.843f, 0.251f}
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
            new float[]{0.529f, 0.847f, 0.984f}
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
            new float[]{0.255f, 0.298f, 0.784f}
    ),
    /*
    KNOCKBACK
     */
    NETHER_QUARTZ(
            "nether_quartz",
            "bonus_knockback",
            0.5,
            WandUtil.ModifierType.PERCENT,
            false,
            new float[]{0.902f, 0.843f, 0.843f}
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
            new float[]{0.722f, 0.000f, 0.000f}
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
            new float[]{0.984f, 0.871f, 0.471f}
    ),
    /*
    ACCURACY
     */
    PRISMARINE(
            "prismarine",
            "bonus_accuracy",
            0.15,
            WandUtil.ModifierType.PERCENT,
            false,
            new float[]{0.400f, 0.796f, 0.733f}
    );

    private final String description;
    private final String modifiedName;
    private final double modifier;
    private final WandUtil.ModifierType modifierType;
    private final boolean isSeconds;
    private final float[] handleColor;


    WandTiers(String description, String modifiedName, double modifier, WandUtil.ModifierType modifierType, boolean isSeconds, float[] handleColor) {

        this.description = description;
        this.modifiedName = modifiedName;
        this.modifier = modifier;
        this.modifierType = modifierType;
        this.isSeconds = isSeconds;
        this.handleColor = handleColor;

    }

    public String getDescription() {
        return description;
    }

    public float[] getHandleColor() {
        return handleColor;
    }

    public double getModifierFor(WandTiers targetTier) {
        int unmodified = this.modifierType == WandUtil.ModifierType.MULT ? 1 : 0;
        return this == targetTier ? this.modifier : unmodified;
    }

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

            case PERCENT -> handleLore.add(base.copy().append(
                    Component.literal(modifier > 0 ? "+" + FORMAT.format(modifier) : FORMAT.format(modifier))
                            .append(Component.literal("%"))).withColor(color)
            );

            case MULT -> {
                String valueStr = "x" + FORMAT.format(modifier);

                handleLore.add(base.copy().append(Component.literal(valueStr)).withColor(color));
            }

            case DEFAULT -> handleLore.add(Component.translatable("item.ethermist.wand_handle.no_change").withColor(color));
        }

        return handleLore;
    }


}
