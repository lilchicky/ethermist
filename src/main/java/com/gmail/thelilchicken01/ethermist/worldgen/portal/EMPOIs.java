package com.gmail.thelilchicken01.ethermist.worldgen.portal;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.block.EMBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collections;
import java.util.List;

public class EMPOIs {

    public static final DeferredRegister<PoiType> EM_POI_TYPES = DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, Ethermist.MODID);

    public static final DeferredHolder<PoiType, PoiType> ETHERMIST_PORTAL = EM_POI_TYPES.register("ethermist_portal",
            () -> new PoiType(
                    ImmutableSet.copyOf(
                            EMBlocks.ETHERMIST_PORTAL.get().getStateDefinition().getPossibleStates()
                    )
                    , 1
                    , 1
            )
    );

    public static void register (IEventBus bus) {
        EM_POI_TYPES.register(bus);
    }

}
