package com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects;

import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.neoforged.neoforge.common.extensions.IAttributeExtension.FORMAT;

public final class WandHandle implements IWandHandle {

    private final ResourceLocation id;
    private final String descriptionKey;
    private final List<WandAttributeState.AttributeModifierHolder> attributeModifiers;
    private final float[] handleColor;
    private final Supplier<Ingredient> repairItem;
    private final boolean doesModify;
    private final boolean doesBuffSpell;
    private final double durabilityMult;
    private final double enchantMult;

    public WandHandle(ResourceLocation id,
                      String descriptionKey,
                      List<WandAttributeState.AttributeModifierHolder> effects,
                      float[] handleColor,
                      Supplier<Ingredient> repairItem,
                      boolean doesModify,
                      boolean doesBuffSpell) {
        this(id, descriptionKey, effects, handleColor, repairItem, doesModify, doesBuffSpell,
                1.0, 1.0);
    }

    public WandHandle(ResourceLocation id,
                      String descriptionKey,
                      List<WandAttributeState.AttributeModifierHolder> effects,
                      float[] handleColor,
                      Supplier<Ingredient> repairItem,
                      boolean doesModify,
                      boolean doesBuffSpell,
                      double durabilityMult,
                      double enchantabilityMult) {
        this.id = id;
        this.descriptionKey = descriptionKey;
        this.attributeModifiers = effects;
        this.handleColor = handleColor.clone();
        this.repairItem = repairItem;
        this.doesModify = doesModify;
        this.doesBuffSpell = doesBuffSpell;
        this.durabilityMult = durabilityMult;
        this.enchantMult = enchantabilityMult;
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
    public double getDurabilityMult() {return durabilityMult;}

    @Override
    public double getEnchantabilityMult() {return enchantMult;}

    @Override
    public boolean doesBuffSpell() {
        return doesBuffSpell;
    }

    @Override
    public void apply(WandAttributeState state) {
        for (var attribute : attributeModifiers) attribute.apply(state);
    }

    @Override
    public List<Component> getModifierString() {
        final int color = 0xAAAAAA;
        List<Component> lines = new ArrayList<>();

        lines.add(Component.translatable("item.ethermist.wand_handle." + descriptionKey + ".desc").withColor(color));

        if (doesModify) {
            if (!attributeModifiers.isEmpty()) {
                for (var mod : attributeModifiers) {

                    double shownValue = mod.value();

                    Component line = Component.empty();
                    Component base = Component.translatable("item.ethermist.wand_handle." + mod.tooltipId());

                    switch (mod.tooltipStyle()) {
                        case ADDITION -> {
                            String sign = shownValue > 0 ? "+" : "";
                            line = base.copy()
                                    .append(Component.literal(sign + FORMAT.format(shownValue)))
                                    .append(mod.seconds() ? Component.translatable("generic.ethermist.time.seconds") : Component.empty())
                                    .withColor(color);
                        }
                        case PERCENT -> {
                            boolean isAccuracy = mod.attribute().equals(WandAttributeState.WandAttribute.INACCURACY_PERCENT);
                            double pct = isAccuracy ? shownValue : (shownValue * 100.0);
                            String sign = pct > 0 ? "+" : "";
                            line = base.copy()
                                    .append(Component.literal(sign + FORMAT.format(pct)))
                                    .append(Component.literal("%"))
                                    .withColor(color);
                        }
                        case MULT -> {
                            line = base.copy()
                                    .append(Component.literal("x" + FORMAT.format(shownValue)))
                                    .withColor(color);
                        }
                    }

                    lines.add(line);

                }
            }
            if (durabilityMult != 1.0) {
                lines.add(
                        Component.translatable("item.ethermist.wand_handle.durability_mult")
                                .append(Component.literal("x" + FORMAT.format(durabilityMult)))
                                .withColor(color)
                );
            }
            if (enchantMult != 1.0) {
                lines.add(
                        Component.translatable("item.ethermist.wand_handle.enchantability")
                                .append(Component.literal("x" + FORMAT.format(enchantMult)))
                                .withColor(color)
                );
            }
            if (doesBuffSpell) {
                lines.add(Component.translatable("item.ethermist.wand_handle.buff_effect").withColor(color));
            }
        } else {
            lines.add(Component.translatable("item.ethermist.wand_handle.no_change").withColor(color));
        }

        return lines;
    }

}
