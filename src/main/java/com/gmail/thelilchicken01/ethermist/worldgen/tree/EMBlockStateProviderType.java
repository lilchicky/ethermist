package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMBlockStateProviderType<P extends BlockStateProvider> {

    public static final DeferredRegister<BlockStateProviderType<?>> EM_BLOCK_STATE_PROVIDER_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCKSTATE_PROVIDER_TYPE, Ethermist.MODID);

    public static final DeferredHolder<BlockStateProviderType<?>, BlockStateProviderType<?>> RANDOMIZED_TRUNK_BLOCK_STATE_PROVIDER = EM_BLOCK_STATE_PROVIDER_TYPES.register(
            "randomized_trunk_block_state_provider",
            () -> new BlockStateProviderType<>(RandomizedBlockStateProvider.CODEC));

    public static void register (IEventBus bus) {
        EM_BLOCK_STATE_PROVIDER_TYPES.register(bus);
    }

}
