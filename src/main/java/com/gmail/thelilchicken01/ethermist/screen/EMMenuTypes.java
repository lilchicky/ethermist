package com.gmail.thelilchicken01.ethermist.screen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EMMenuTypes {

    public static final DeferredRegister<MenuType<?>> EM_MENU_TYPES =
            DeferredRegister.create(BuiltInRegistries.MENU, Ethermist.MODID);

    public static final Supplier<MenuType<WandforgingTableMenu>> WANDFORGING_TABLE_MENU =
            EM_MENU_TYPES.register("wandforging_table_menu", () -> new MenuType<>(WandforgingTableMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static void register(IEventBus eventBus) {
        EM_MENU_TYPES.register(eventBus);
    }

}
