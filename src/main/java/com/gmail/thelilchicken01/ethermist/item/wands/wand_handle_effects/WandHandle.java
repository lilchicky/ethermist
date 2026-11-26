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
    private final List<WandAttributeState.WandAttributeHolder> attributeModifiers;
    private final float[] handleColor;
    private final Supplier<Ingredient> repairItem;
    private final boolean doesModify;
    private final boolean doesBuffSpell;
    private final double durabilityMult;
    private final double enchantMult;

    public WandHandle(ResourceLocation id,
                      String descriptionKey,
                      List<WandAttributeState.WandAttributeHolder> effects,
                      float[] handleColor,
                      Supplier<Ingredient> repairItem,
                      boolean doesModify,
                      boolean doesBuffSpell) {
        this(id, descriptionKey, effects, handleColor, repairItem, doesModify, doesBuffSpell,
                1.0, 1.0);
    }

    public WandHandle(ResourceLocation id,
                      String descriptionKey,
                      List<WandAttributeState.WandAttributeHolder> effects,
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
        for (WandAttributeState.WandAttributeHolder holder : attributeModifiers) state.modifyExistingAttribute(holder.getAttribute(), holder.getOperation(), holder.getAmount());
    }

    @Override
    public List<Component> getModifierString() {
        final int color = 0xAAAAAA;
        List<Component> lines = new ArrayList<>();

        lines.add(Component.translatable("item.ethermist.wand_handle." + descriptionKey + ".desc").withColor(color));

        if (doesModify) {
            if (!attributeModifiers.isEmpty()) {
                for (WandAttributeState.WandAttributeHolder holder : attributeModifiers) {
                    lines.add(holder.getAttributeComponent());
                }
            }
            if (durabilityMult != 1.0) {
                lines.add(
                        Component.translatable("item.ethermist.wand_handle.durability_mult", "x" + FORMAT.format(durabilityMult)).withColor(color)
                );
            }
            if (enchantMult != 1.0) {
                lines.add(
                        Component.translatable("item.ethermist.wand_handle.enchantability", "x" + FORMAT.format(enchantMult)).withColor(color)
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
