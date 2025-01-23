package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.FlameShotItem;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.GenericShotItem;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.item.wands.DullWand;
import com.gmail.thelilchicken01.ethermist.item.wands.FlameWand;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.world.item.BookItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ethermist.MODID);

    public static final DeferredItem<WandShotItem> GENERIC_SHOT = ITEMS.register("generic_shot", GenericShotItem::new);
    public static final DeferredItem<WandShotItem> FLAME_SHOT = ITEMS.register("flame_shot", FlameShotItem::new);

    public static final DeferredItem<WandItem> DULL_WAND = ITEMS.register("dull_wand", DullWand::new);
    public static final DeferredItem<WandItem> FLAME_WAND = ITEMS.register("flame_wand", FlameWand::new);

    public static final DeferredItem<BookItem> FOCUS_TOME = ITEMS.register("focus_tome", TomeItem::new);
    public static final DeferredItem<BookItem> WAND_TOME = ITEMS.register("wand_tome", TomeItem::new);

    public static void register (IEventBus bus) {
        ITEMS.register(bus);
    }

}
