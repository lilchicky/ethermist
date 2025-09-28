package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.util.EMRegistries;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

import java.util.List;
import java.util.function.Function;

public interface IWandExclusionEffect {

    Codec<IWandExclusionEffect> CODEC = Codec.lazyInitialized(() ->
            EMRegistries.WAND_EXCLUSION_EFFECT.getRegistry().get()
                    .byNameCodec()
                    .dispatch(IWandExclusionEffect::codec, Function.identity())
    );

    MapCodec<? extends IWandExclusionEffect> codec();

    List<Class<?>> getExclusive();

}
