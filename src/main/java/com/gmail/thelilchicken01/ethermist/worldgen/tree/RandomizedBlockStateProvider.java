package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class RandomizedBlockStateProvider extends BlockStateProvider {

    public static final MapCodec<RandomizedBlockStateProvider> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                BlockState.CODEC.fieldOf("mainTrunk").forGetter(provider -> provider.mainTrunk),
                BlockState.CODEC.fieldOf("subTrunk").forGetter(provider -> provider.subTrunk),
                Codec.DOUBLE.fieldOf("mainChance").forGetter(provider -> provider.mainChance)
            ).apply(instance, RandomizedBlockStateProvider::new)
        );
    private final BlockState mainTrunk;
    private final BlockState subTrunk;
    private final double mainChance;

    public RandomizedBlockStateProvider(BlockState mainTrunk, BlockState subTrunk, double mainChance) {
        this.mainTrunk = mainTrunk;
        this.subTrunk = subTrunk;
        this.mainChance = mainChance;
    }

    protected BlockStateProviderType<?> type() {
        return EMBlockStateProviderType.RANDOMIZED_TRUNK_BLOCK_STATE_PROVIDER.get();
    }

    public BlockState getState(RandomSource random, BlockPos pos) {
        return Math.random() < mainChance ? this.mainTrunk : this.subTrunk;
    }

}
