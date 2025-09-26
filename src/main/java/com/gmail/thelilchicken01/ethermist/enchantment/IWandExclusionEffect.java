package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.EMRegistries;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.component.ItemAttributeModifiers;

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
