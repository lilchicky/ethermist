package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.EMRegistries;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.function.Function;

public interface IWandSpellEffect {

    Codec<IWandSpellEffect> CODEC = Codec.lazyInitialized(() ->
            EMRegistries.WAND_SPELL_EFFECT.getRegistry().get()
                    .byNameCodec()
                    .dispatch(IWandSpellEffect::codec, Function.identity())
    );

    MapCodec<? extends IWandSpellEffect> codec();

    void attributeChanges(WandAttributeState state, int level);
    default void addSpecialAttributes(ItemAttributeModifiers.Builder builder) {}

}
