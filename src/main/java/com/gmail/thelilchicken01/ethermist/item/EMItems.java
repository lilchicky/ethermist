package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wands.DullWand;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ethermist.MODID);

    public static final DeferredItem<Item> MIST_GEM = ITEMS.register("mist_gem", MistGem::new);

    public static final DeferredItem<Item> DULL_WAND = ITEMS.register("dull_wand", DullWand::new);

    public static void register (IEventBus bus) {
        ITEMS.register(bus);
    }

}
