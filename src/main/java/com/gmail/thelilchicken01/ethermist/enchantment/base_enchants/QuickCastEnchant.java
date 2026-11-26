package com.gmail.thelilchicken01.ethermist.enchantment.base_enchants;

import com.gmail.thelilchicken01.ethermist.enchantment.IWandBaseEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeStateTest;
import com.gmail.thelilchicken01.ethermist.util.EMAttributes;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import static com.gmail.thelilchicken01.ethermist.item.wands.WandItem.BLOCK_INTERACTION_RANGE_ID;
import static com.gmail.thelilchicken01.ethermist.item.wands.WandItem.ENTITY_INTERACTION_RANGE_ID;

public class QuickCastEnchant implements IWandBaseEffect {

    public static final MapCodec<QuickCastEnchant> CODEC = MapCodec.unit(QuickCastEnchant::new);

    @Override
    public MapCodec<? extends IWandBaseEffect> codec() {
        return CODEC;
    }

    @Override
    public void modifyWandAttributes(WandAttributeStateTest state, int level) {
        state.modifyExistingAttribute(EMAttributes.COOLDOWN, WandAttributeStateTest.Operation.MULT, (float)(1 / Math.pow((level + 1), 0.3f)));
    }

}
