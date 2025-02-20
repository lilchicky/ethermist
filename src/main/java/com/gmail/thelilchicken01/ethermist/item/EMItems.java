package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandModifiers;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandTypes;
import net.minecraft.world.item.BookItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ethermist.MODID);

    public static final DeferredItem<WandShotItem> GENERIC_SHOT = ITEMS.register("generic_shot", () -> new WandShotItem(WandModifiers.GENERIC_WAND));
    public static final DeferredItem<WandShotItem> FLAME_SHOT = ITEMS.register("flame_shot", () -> new WandShotItem(WandModifiers.FLAME_WAND));
    public static final DeferredItem<WandShotItem> METEOR_SHOT = ITEMS.register("meteor_shot", () -> new WandShotItem());

    public static final DeferredItem<Item> WAND_HANDLE = ITEMS.register("wand_handle", HandleItem::new);

    public static final DeferredItem<WandItem> DULL_WAND = ITEMS.register("dull_wand", () -> new WandItem(WandTypes.DULL_WAND));

    public static final DeferredItem<WandItem> FLAME_WAND = ITEMS.register("flame_wand", () -> new WandItem(WandTypes.FLAME_WAND));

    public static final DeferredItem<BookItem> EXCLUSION_TOME = ITEMS.register("exclusion_tome", TomeItem::new);
    public static final DeferredItem<BookItem> WAND_TOME = ITEMS.register("wand_tome", TomeItem::new);

    public static final DeferredItem<Item> DULL_ORB = ITEMS.register("dull_orb", OrbItem::new);
    public static final DeferredItem<Item> FLAME_ORB = ITEMS.register("flame_orb", OrbItem::new);

    public static void register (IEventBus bus) {
        ITEMS.register(bus);
    }

}
