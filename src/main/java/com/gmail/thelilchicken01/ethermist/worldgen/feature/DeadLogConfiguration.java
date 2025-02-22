package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record DeadLogConfiguration(IntProvider length, BlockStateProvider block) implements FeatureConfiguration {

    public static final Codec<DeadLogConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.codec(1, 16).fieldOf("length").forGetter(DeadLogConfiguration::length),
            BlockStateProvider.CODEC.fieldOf("block").forGetter(DeadLogConfiguration::block)
    ).apply(instance, DeadLogConfiguration::new));
}
