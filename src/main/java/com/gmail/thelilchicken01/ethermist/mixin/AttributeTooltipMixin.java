package com.gmail.thelilchicken01.ethermist.mixin;

import com.gmail.thelilchicken01.ethermist.EMAttributes;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.util.AttributeTooltipContext;
import net.neoforged.neoforge.common.util.AttributeUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static net.neoforged.neoforge.common.extensions.IAttributeExtension.FORMAT;

@Mixin(AttributeUtil.class)
public class AttributeTooltipMixin {

    @Inject(method = "applyTextFor", at = @At("HEAD"))
    private static void ethermist$customTooltip(
            ItemStack stack,
            Consumer<Component> tooltip,
            Multimap<Holder<Attribute>, AttributeModifier> modifierMap,
            AttributeTooltipContext ctx,
            CallbackInfo ci
    ) {

        var modifiedAttributes = new java.util.HashSet<Holder<Attribute>>();

        for (var entry : modifierMap.entries()) {
            Holder<Attribute> attribute = entry.getKey();
            AttributeModifier modifier = entry.getValue();

            if (attribute.equals(EMAttributes.WAND_DAMAGE)
                    || attribute.equals(EMAttributes.COOLDOWN)
                    || attribute.equals(EMAttributes.ACCURACY)
                    || attribute.equals(EMAttributes.LIFESPAN)
                    || attribute.equals(EMAttributes.PROJECTILE_SPEED)
                    || attribute.equals(EMAttributes.WAND_KNOCKBACK)) {

                double val = modifier.amount();

                if (attribute.equals(EMAttributes.ACCURACY)) {
                    val = modifier.amount() * 100;
                }
                if (attribute.equals(EMAttributes.WAND_KNOCKBACK) || attribute.equals(EMAttributes.PROJECTILE_SPEED)) {
                    val = (modifier.amount() + 0.75) * 100;
                }

                Component formatted = formatTooltip(attribute, modifier, ctx, val);
                tooltip.accept(formatted);
                modifiedAttributes.add(attribute);

            }

        }

        modifiedAttributes.forEach(modifierMap::removeAll);

    }

    private static Component formatTooltip(Holder<Attribute> attribute, AttributeModifier modifier, AttributeTooltipContext ctx, double val) {
        return Component.translatable(attribute.value().getDescriptionId(), FORMAT.format(val))
                .withStyle(ChatFormatting.BLUE)
                .append(addModdedSuffix(attribute, modifier, ctx));
    }

    // Modified version of the NeoForge debug tooltip, since I am overwriting tooltip display for my tooltips
    private static Component addModdedSuffix(Holder<Attribute> attribute, AttributeModifier modifier, AttributeTooltipContext ctx) {

        if (ctx.flag().isAdvanced()) {
            double entityBase = ctx.player() != null ? ctx.player().getAttributeBaseValue(attribute) : 0.0;

            String baseStr = FORMAT.format(entityBase);
            String itemStr = FORMAT.format(modifier.amount());

            return Component.literal(" ")
                    .append(
                            Component.translatable("neoforge.attribute.debug.base", baseStr, itemStr)
                                    .withStyle(ChatFormatting.GRAY)
                    );
        }
        else {
            return Component.empty();
        }
    }

}
