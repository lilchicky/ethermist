package com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.neoforged.neoforge.common.extensions.IAttributeExtension.FORMAT;

public final class WandTier implements IWandTiers {

    public enum WandAttributeKey {COOLDOWN_TICKS, DAMAGE, LIFESPAN_SECONDS, PROJECTILE_SPEED_MULT, KNOCKBACK_MULT, INACCURACY_PERCENT}
    public enum EffectType {ADDITION, MULT, PERCENT}

    public record Effect(WandAttributeKey key, EffectType type, double value, boolean seconds) {
        public void apply(WandAttributeState state) {
            double v = value;
            if (seconds && key == WandAttributeKey.COOLDOWN_TICKS && type != EffectType.PERCENT) {
                v = value * 20.0;
            }
            state.apply(key, type, v);
        }
    }

    private final ResourceLocation id;
    private final String descriptionKey;
    private final String modifiedNameKey;
    private final List<Effect> effects;
    private final float[] handleColor;
    private final Supplier<Ingredient> repairItem;
    private final boolean showSecondsSuffixInTooltip;
    private final TooltipStyle tooltipStyle;
    private final boolean doesBuffSpell;

    public enum TooltipStyle {DEFAULT, ADDITION, PERCENT, MULT, BUFF_EFFECT}

    public WandTier(ResourceLocation id,
                    String descriptionKey,
                    String modifiedNameKey,
                    List<Effect> effects,
                    float[] handleColor,
                    Supplier<Ingredient> repairItem,
                    boolean showSecondsSuffixInTooltip,
                    TooltipStyle tooltipStyle,
                    boolean doesBuffSpell) {
        this.id = id;
        this.descriptionKey = descriptionKey;
        this.modifiedNameKey = modifiedNameKey;
        this.effects = effects;
        this.handleColor = handleColor.clone();
        this.repairItem = repairItem;
        this.showSecondsSuffixInTooltip = showSecondsSuffixInTooltip;
        this.tooltipStyle = tooltipStyle;
        this.doesBuffSpell = doesBuffSpell;
    }

    @Override
    public ResourceLocation id() {
        return id;
    }

    @Override
    public String getDescription() {
        return descriptionKey;
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
    public boolean doesBuffSpell() {
        return doesBuffSpell;
    }

    @Override
    public void apply(WandAttributeState state) {
        for (var e : effects) e.apply(state);
    }

    @Override
    public List<Component> getModifierString() {

        int color = 0xAAAAAA;
        List<Component> lines = new ArrayList<>();
        lines.add(Component.translatable("item.ethermist.wand_handle." + descriptionKey + ".desc").withColor(color));

        Component base = Component.translatable("item.ethermist.wand_handle." + modifiedNameKey);

        switch (tooltipStyle) {
            case ADDITION -> {
                double modifier = effects.isEmpty() ? 0 : effects.getFirst().value();
                var line = base.copy().append(Component.literal(modifier > 0 ? "+" + FORMAT.format(modifier) : FORMAT.format(modifier)));
                if (showSecondsSuffixInTooltip) line.append(Component.translatable("generic.ethermist.time.seconds"));
                lines.add(line.withColor(color));
            }
            case PERCENT -> {
                double v = effects.isEmpty() ? 0 : effects.getFirst().value();
                double shown = (modifiedNameKey.equals("bonus_accuracy")) ? v : v * 100.0;
                lines.add(base.copy()
                        .append(Component.literal((shown > 0 ? "+" : "") + FORMAT.format(shown)))
                        .append(Component.literal("%"))
                        .withColor(color));
            }
            case MULT -> {
                double v = effects.isEmpty() ? 1 : effects.getFirst().value();
                lines.add(base.copy().append(Component.literal("x" + FORMAT.format(v))).withColor(color));
            }
            case DEFAULT -> lines.add(Component.translatable("item.ethermist.wand_handle.no_change").withColor(color));
            case BUFF_EFFECT ->
                    lines.add(Component.translatable("item.ethermist.wand_handle.buff_effect").withColor(color));
        }
        return lines;
    }
}
