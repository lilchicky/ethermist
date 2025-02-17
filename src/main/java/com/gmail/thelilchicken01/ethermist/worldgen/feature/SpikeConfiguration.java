package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record SpikeConfiguration(
        IntProvider height,
        FloatProvider baseRadius,
        IntProvider tilt,
        BlockStateProvider blockStateProvider) implements FeatureConfiguration {

    // Codec for AmethystSpikeConfig
    public static final Codec<SpikeConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.codec(1, 64).fieldOf("height").forGetter(SpikeConfiguration::height),
            FloatProvider.codec(0.5F, 10.0F).fieldOf("baseRadius").forGetter(SpikeConfiguration::baseRadius),
            IntProvider.codec(-90, 90).fieldOf("tilt").forGetter(SpikeConfiguration::tilt),
            BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(SpikeConfiguration::blockStateProvider)  // Add BlockStateProvider to codec
    ).apply(instance, SpikeConfiguration::new));
}
