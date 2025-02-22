package com.gmail.thelilchicken01.ethermist.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record GroundIcicleConfiguration(IntProvider height, IntProvider spread) implements FeatureConfiguration {

    public static final Codec<GroundIcicleConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.codec(1, 16).fieldOf("height").forGetter(GroundIcicleConfiguration::height),
            IntProvider.codec(1, 16).fieldOf("spread").forGetter(GroundIcicleConfiguration::spread)
    ).apply(instance, GroundIcicleConfiguration::new));
}