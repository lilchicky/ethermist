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

    public static final DeferredItem<WandShotItem> GENERIC_SHOT = ITEMS.register("generic_shot", () -> new WandShotItem(WandModifiers.GENERIC));
    public static final DeferredItem<WandShotItem> FLAME_SHOT = ITEMS.register("flame_shot", () -> new WandShotItem(WandModifiers.FLAME));
    public static final DeferredItem<WandShotItem> POISON_SHOT = ITEMS.register("poison_shot", () -> new WandShotItem(WandModifiers.POISON));
    public static final DeferredItem<WandShotItem> LEVITATION_SHOT = ITEMS.register("levitation_shot", () -> new WandShotItem(WandModifiers.LEVITATION));
    public static final DeferredItem<WandShotItem> WITHER_SHOT = ITEMS.register("wither_shot", () -> new WandShotItem(WandModifiers.WITHER));

    public static final DeferredItem<WandShotItem> METEOR_SHOT = ITEMS.register("meteor_shot", () -> new WandShotItem());

    public static final DeferredItem<WandItem> DULL_WAND = ITEMS.register("dull_wand", () -> new WandItem(WandTypes.DULL_WAND));
    public static final DeferredItem<WandItem> FLAME_WAND = ITEMS.register("flame_wand", () -> new WandItem(WandTypes.FLAME_WAND));
    public static final DeferredItem<WandItem> POISON_WAND = ITEMS.register("poison_wand", () -> new WandItem(WandTypes.POISON_WAND));
    public static final DeferredItem<WandItem> LEVITATION_WAND = ITEMS.register("levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND));
    public static final DeferredItem<WandItem> WITHER_WAND = ITEMS.register("wither_wand", () -> new WandItem(WandTypes.WITHER_WAND));

    public static final DeferredItem<BookItem> EXCLUSION_TOME = ITEMS.register("exclusion_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> WAND_TOME = ITEMS.register("wand_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> AUGMENT_TOME = ITEMS.register("augment_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> MAIN_SPELL_TOME = ITEMS.register("main_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> BASE_SPELL_TOME = ITEMS.register("base_spell_tome", TomeItem::new);

    public static final DeferredItem<OrbItem> DULL_ORB = ITEMS.register("dull_orb", () -> new OrbItem(DULL_WAND.get()));
    public static final DeferredItem<OrbItem> FLAME_ORB = ITEMS.register("flame_orb", () -> new OrbItem(FLAME_WAND.get()));
    public static final DeferredItem<OrbItem> POISON_ORB = ITEMS.register("poison_orb", () -> new OrbItem(POISON_WAND.get()));
    public static final DeferredItem<OrbItem> LEVITATION_ORB = ITEMS.register("levitation_orb", () -> new OrbItem(LEVITATION_WAND.get()));
    public static final DeferredItem<OrbItem> WITHER_ORB = ITEMS.register("wither_orb", () -> new OrbItem(WITHER_WAND.get()));

    public static final DeferredItem<Item> WAND_HANDLE = ITEMS.register("wand_handle", HandleItem::new);

    public static void register (IEventBus bus) {
        ITEMS.register(bus);
    }

}
