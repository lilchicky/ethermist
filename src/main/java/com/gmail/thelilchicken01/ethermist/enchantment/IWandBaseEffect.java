package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.util.EMRegistries;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.function.Function;

public interface IWandBaseEffect {

    Codec<IWandBaseEffect> CODEC = Codec.lazyInitialized(() ->
            EMRegistries.WAND_BASE_EFFECT.getRegistry().get()
                    .byNameCodec()
                    .dispatch(IWandBaseEffect::codec, Function.identity())
    );

    MapCodec<? extends IWandBaseEffect> codec();

    void attributeChanges(WandAttributeState state, int level);
    default void addSpecialAttributes(ItemAttributeModifiers.Builder builder) {}

}
