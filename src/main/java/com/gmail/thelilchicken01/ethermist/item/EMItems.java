package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.item.wands.*;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
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
    public static final DeferredItem<WandShotItem> WITCH_SHOT = ITEMS.register("witch_shot", () -> new WandShotItem(WandModifiers.WITCH));
    public static final DeferredItem<WandShotItem> HEAVY_SHOT = ITEMS.register("heavy_shot", () -> new WandShotItem(WandModifiers.HEAVY));
    public static final DeferredItem<WandShotItem> FROZEN_SHOT = ITEMS.register("frozen_shot", () -> new WandShotItem(WandModifiers.FROZEN));
    public static final DeferredItem<WandShotItem> GLASS_SHOT = ITEMS.register("glass_shot", () -> new WandShotItem(WandModifiers.GLASS));

    public static final DeferredItem<WandShotItem> METEOR_SHOT = ITEMS.register("meteor_shot", () -> new WandShotItem());

    /*
    ---------- Amethyst Wands ----------
     */

    public static final DeferredItem<WandItem> WOODEN_DULL_WAND = ITEMS.register("wooden_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.WOOD));
    public static final DeferredItem<WandItem> WOODEN_FLAME_WAND = ITEMS.register("wooden_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.WOOD));
    public static final DeferredItem<WandItem> WOODEN_POISON_WAND = ITEMS.register("wooden_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.WOOD));
    public static final DeferredItem<WandItem> WOODEN_LEVITATION_WAND = ITEMS.register("wooden_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.WOOD));
    public static final DeferredItem<WandItem> WOODEN_WITHER_WAND = ITEMS.register("wooden_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.WOOD));
    public static final DeferredItem<WandItem> WOODEN_WITCH_WAND = ITEMS.register("wooden_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.WOOD));
    public static final DeferredItem<WandItem> WOODEN_HEAVY_WAND = ITEMS.register("wooden_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.WOOD));
    public static final DeferredItem<WandItem> WOODEN_FROZEN_WAND = ITEMS.register("wooden_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.WOOD));
    public static final DeferredItem<WandItem> WOODEN_GLASS_WAND = ITEMS.register("wooden_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.WOOD));

    /*
    ---------- Iron Wands ----------
     */

    public static final DeferredItem<WandItem> IRON_DULL_WAND = ITEMS.register("iron_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.IRON));
    public static final DeferredItem<WandItem> IRON_FLAME_WAND = ITEMS.register("iron_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.IRON));
    public static final DeferredItem<WandItem> IRON_POISON_WAND = ITEMS.register("iron_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.IRON));
    public static final DeferredItem<WandItem> IRON_LEVITATION_WAND = ITEMS.register("iron_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.IRON));
    public static final DeferredItem<WandItem> IRON_WITHER_WAND = ITEMS.register("iron_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.IRON));
    public static final DeferredItem<WandItem> IRON_WITCH_WAND = ITEMS.register("iron_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.IRON));
    public static final DeferredItem<WandItem> IRON_HEAVY_WAND = ITEMS.register("iron_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.IRON));
    public static final DeferredItem<WandItem> IRON_FROZEN_WAND = ITEMS.register("iron_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.IRON));
    public static final DeferredItem<WandItem> IRON_GLASS_WAND = ITEMS.register("iron_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.IRON));

    /*
    ---------- Diamond Wands ----------
     */

    public static final DeferredItem<WandItem> DIAMOND_DULL_WAND = ITEMS.register("diamond_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> DIAMOND_FLAME_WAND = ITEMS.register("diamond_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> DIAMOND_POISON_WAND = ITEMS.register("diamond_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> DIAMOND_LEVITATION_WAND = ITEMS.register("diamond_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> DIAMOND_WITHER_WAND = ITEMS.register("diamond_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> DIAMOND_WITCH_WAND = ITEMS.register("diamond_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> DIAMOND_HEAVY_WAND = ITEMS.register("diamond_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> DIAMOND_FROZEN_WAND = ITEMS.register("diamond_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> DIAMOND_GLASS_WAND = ITEMS.register("diamond_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.DIAMOND));

    public static final DeferredItem<Item> WOODEN_WAND_HANDLE = ITEMS.register("wooden_wand_handle", HandleItem::new);
    public static final DeferredItem<Item> IRON_WAND_HANDLE = ITEMS.register("iron_wand_handle", HandleItem::new);
    public static final DeferredItem<Item> DIAMOND_WAND_HANDLE = ITEMS.register("diamond_wand_handle", HandleItem::new);

    /*
    ---------- Tomes ----------
     */

    public static final DeferredItem<BookItem> EXCLUSION_TOME = ITEMS.register("exclusion_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> WAND_TOME = ITEMS.register("wand_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> AUGMENT_TOME = ITEMS.register("augment_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> MAIN_SPELL_TOME = ITEMS.register("main_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> BASE_SPELL_TOME = ITEMS.register("base_spell_tome", TomeItem::new);

    public static final DeferredItem<OrbItem> DULL_ORB = ITEMS.register("dull_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> FLAME_ORB = ITEMS.register("flame_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> POISON_ORB = ITEMS.register("poison_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> LEVITATION_ORB = ITEMS.register("levitation_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> WITHER_ORB = ITEMS.register("wither_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> WITCH_ORB = ITEMS.register("witch_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> FROZEN_ORB = ITEMS.register("frozen_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> GLASS_ORB = ITEMS.register("glass_orb", OrbItem::new);

    public static void register (IEventBus bus) {
        ITEMS.register(bus);
    }

}
