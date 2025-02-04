package com.gmail.thelilchicken01.ethermist.worldgen.tree;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMTreeDecorators {

    public static final DeferredRegister<TreeDecoratorType<?>> EM_TREE_DECORATORS = DeferredRegister.create(BuiltInRegistries.TREE_DECORATOR_TYPE, Ethermist.MODID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<IcicleDecorator>> ICICLE_DECORATOR = EM_TREE_DECORATORS.register("icicle_decorator",
            () -> new TreeDecoratorType<>(IcicleDecorator.CODEC));

    public static void register (IEventBus bus) {
        EM_TREE_DECORATORS.register(bus);
    }

}
