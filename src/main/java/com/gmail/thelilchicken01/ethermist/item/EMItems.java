package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.foods.ShroomCluster;
import com.gmail.thelilchicken01.ethermist.item.foods.ToastedShroomCluster;
import com.gmail.thelilchicken01.ethermist.item.wands.*;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects.EMWandOrbs;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.EMWandHandles;
import net.minecraft.world.item.BookItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ethermist.MODID);

    public static final DeferredItem<WandShotItem> GENERIC_SHOT = ITEMS.register("generic_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> FLAME_SHOT = ITEMS.register("flame_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> POISON_SHOT = ITEMS.register("poison_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> LEVITATION_SHOT = ITEMS.register("levitation_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> WITHER_SHOT = ITEMS.register("wither_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> WITCH_SHOT = ITEMS.register("witch_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> HEAVY_SHOT = ITEMS.register("heavy_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> FROZEN_SHOT = ITEMS.register("frozen_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> GLASS_SHOT = ITEMS.register("glass_shot", WandShotItem::new);
    public static final DeferredItem<WandShotItem> GLIMMERBUG_SHOT = ITEMS.register("glimmerbug_shot", WandShotItem::new);

    /*
    ---------- Orbs ----------
     */

    public static final DeferredItem<OrbItem> DULL_ORB = ITEMS.register("dull_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> FLAME_ORB = ITEMS.register("flame_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> POISON_ORB = ITEMS.register("poison_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> LEVITATION_ORB = ITEMS.register("levitation_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> WITHER_ORB = ITEMS.register("wither_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> WITCH_ORB = ITEMS.register("witch_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> FROZEN_ORB = ITEMS.register("frozen_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> GLASS_ORB = ITEMS.register("glass_orb", OrbItem::new);
    public static final DeferredItem<OrbItem> GLIMMERBUG_ORB = ITEMS.register("glimmerbug_orb", OrbItem::new);

    /*
    ---------- Dull Wands ----------
    */
    public static final DeferredItem<WandItem> WOODEN_DULL_WAND = ITEMS.register("wooden_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_DULL_WAND = ITEMS.register("emerald_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_DULL_WAND = ITEMS.register("diamond_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_DULL_WAND = ITEMS.register("golden_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_DULL_WAND = ITEMS.register("lapis_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_DULL_WAND = ITEMS.register("quartz_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_DULL_WAND = ITEMS.register("redstone_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_DULL_WAND = ITEMS.register("glowstone_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_DULL_WAND = ITEMS.register("prismarine_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_DULL_WAND = ITEMS.register("netherite_dull_wand", () -> new WandItem(EMWandOrbs.DULL, EMWandHandles.NETHERITE));

    /*
    ---------- Flame Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_FLAME_WAND = ITEMS.register("wooden_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_FLAME_WAND = ITEMS.register("emerald_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_FLAME_WAND = ITEMS.register("diamond_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_FLAME_WAND = ITEMS.register("golden_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_FLAME_WAND = ITEMS.register("lapis_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_FLAME_WAND = ITEMS.register("quartz_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_FLAME_WAND = ITEMS.register("redstone_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_FLAME_WAND = ITEMS.register("glowstone_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_FLAME_WAND = ITEMS.register("prismarine_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_FLAME_WAND = ITEMS.register("netherite_flame_wand", () -> new WandItem(EMWandOrbs.FLAME, EMWandHandles.NETHERITE));

    /*
    ---------- Poison Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_POISON_WAND = ITEMS.register("wooden_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_POISON_WAND = ITEMS.register("emerald_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_POISON_WAND = ITEMS.register("diamond_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_POISON_WAND = ITEMS.register("golden_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_POISON_WAND = ITEMS.register("lapis_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_POISON_WAND = ITEMS.register("quartz_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_POISON_WAND = ITEMS.register("redstone_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_POISON_WAND = ITEMS.register("glowstone_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_POISON_WAND = ITEMS.register("prismarine_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_POISON_WAND = ITEMS.register("netherite_poison_wand", () -> new WandItem(EMWandOrbs.POISON, EMWandHandles.NETHERITE));

    /*
    ---------- Levitation Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_LEVITATION_WAND = ITEMS.register("wooden_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_LEVITATION_WAND = ITEMS.register("emerald_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_LEVITATION_WAND = ITEMS.register("diamond_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_LEVITATION_WAND = ITEMS.register("golden_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_LEVITATION_WAND = ITEMS.register("lapis_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_LEVITATION_WAND = ITEMS.register("quartz_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_LEVITATION_WAND = ITEMS.register("redstone_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_LEVITATION_WAND = ITEMS.register("glowstone_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_LEVITATION_WAND = ITEMS.register("prismarine_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_LEVITATION_WAND = ITEMS.register("netherite_levitation_wand", () -> new WandItem(EMWandOrbs.LEVITATION, EMWandHandles.NETHERITE));

    /*
    ---------- Wither Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_WITHER_WAND = ITEMS.register("wooden_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_WITHER_WAND = ITEMS.register("emerald_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_WITHER_WAND = ITEMS.register("diamond_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_WITHER_WAND = ITEMS.register("golden_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_WITHER_WAND = ITEMS.register("lapis_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_WITHER_WAND = ITEMS.register("quartz_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_WITHER_WAND = ITEMS.register("redstone_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_WITHER_WAND = ITEMS.register("glowstone_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_WITHER_WAND = ITEMS.register("prismarine_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_WITHER_WAND = ITEMS.register("netherite_wither_wand", () -> new WandItem(EMWandOrbs.WITHER, EMWandHandles.NETHERITE));

    /*
    ---------- Witch Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_WITCH_WAND = ITEMS.register("wooden_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_WITCH_WAND = ITEMS.register("emerald_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_WITCH_WAND = ITEMS.register("diamond_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_WITCH_WAND = ITEMS.register("golden_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_WITCH_WAND = ITEMS.register("lapis_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_WITCH_WAND = ITEMS.register("quartz_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_WITCH_WAND = ITEMS.register("redstone_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_WITCH_WAND = ITEMS.register("glowstone_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_WITCH_WAND = ITEMS.register("prismarine_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_WITCH_WAND = ITEMS.register("netherite_witch_wand", () -> new WandItem(EMWandOrbs.WITCH, EMWandHandles.NETHERITE));

    /*
    ---------- Heavy Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_HEAVY_WAND = ITEMS.register("wooden_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_HEAVY_WAND = ITEMS.register("emerald_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_HEAVY_WAND = ITEMS.register("diamond_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_HEAVY_WAND = ITEMS.register("golden_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_HEAVY_WAND = ITEMS.register("lapis_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_HEAVY_WAND = ITEMS.register("quartz_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_HEAVY_WAND = ITEMS.register("redstone_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_HEAVY_WAND = ITEMS.register("glowstone_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_HEAVY_WAND = ITEMS.register("prismarine_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_HEAVY_WAND = ITEMS.register("netherite_heavy_wand", () -> new MaceWandItem(EMWandOrbs.HEAVY, EMWandHandles.NETHERITE));

    /*
    ---------- Frozen Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_FROZEN_WAND = ITEMS.register("wooden_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_FROZEN_WAND = ITEMS.register("emerald_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_FROZEN_WAND = ITEMS.register("diamond_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_FROZEN_WAND = ITEMS.register("golden_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_FROZEN_WAND = ITEMS.register("lapis_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_FROZEN_WAND = ITEMS.register("quartz_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_FROZEN_WAND = ITEMS.register("redstone_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_FROZEN_WAND = ITEMS.register("glowstone_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_FROZEN_WAND = ITEMS.register("prismarine_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_FROZEN_WAND = ITEMS.register("netherite_frozen_wand", () -> new WandItem(EMWandOrbs.FROZEN, EMWandHandles.NETHERITE));

    /*
    ---------- Glass Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_GLASS_WAND = ITEMS.register("wooden_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_GLASS_WAND = ITEMS.register("emerald_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_GLASS_WAND = ITEMS.register("diamond_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_GLASS_WAND = ITEMS.register("golden_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_GLASS_WAND = ITEMS.register("lapis_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_GLASS_WAND = ITEMS.register("quartz_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_GLASS_WAND = ITEMS.register("redstone_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_GLASS_WAND = ITEMS.register("glowstone_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_GLASS_WAND = ITEMS.register("prismarine_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_GLASS_WAND = ITEMS.register("netherite_glass_wand", () -> new WandItem(EMWandOrbs.GLASS, EMWandHandles.NETHERITE));

    /*
    ---------- Glimmerbug Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_GLIMMERBUG_WAND = ITEMS.register("wooden_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_GLIMMERBUG_WAND = ITEMS.register("emerald_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_GLIMMERBUG_WAND = ITEMS.register("diamond_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_GLIMMERBUG_WAND = ITEMS.register("golden_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_GLIMMERBUG_WAND = ITEMS.register("lapis_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_GLIMMERBUG_WAND = ITEMS.register("quartz_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_GLIMMERBUG_WAND = ITEMS.register("redstone_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_GLIMMERBUG_WAND = ITEMS.register("glowstone_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_GLIMMERBUG_WAND = ITEMS.register("prismarine_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_GLIMMERBUG_WAND = ITEMS.register("netherite_glimmerbug_wand", () -> new WandItem(EMWandOrbs.GLIMMERBUG, EMWandHandles.NETHERITE));
    
     /*
    ---------- Handles ----------
     */

    public static final DeferredItem<Item> WOODEN_WAND_HANDLE = ITEMS.register("wooden_wand_handle", () -> new HandleItem(EMWandHandles.WOODEN));
    public static final DeferredItem<Item> EMERALD_WAND_HANDLE = ITEMS.register("emerald_wand_handle", () -> new HandleItem(EMWandHandles.EMERALD));
    public static final DeferredItem<Item> DIAMOND_WAND_HANDLE = ITEMS.register("diamond_wand_handle", () -> new HandleItem(EMWandHandles.DIAMOND));
    public static final DeferredItem<Item> GOLDEN_WAND_HANDLE = ITEMS.register("golden_wand_handle", () -> new HandleItem(EMWandHandles.GOLDEN));
    public static final DeferredItem<Item> LAPIS_WAND_HANDLE = ITEMS.register("lapis_wand_handle", () -> new HandleItem(EMWandHandles.LAPIS));
    public static final DeferredItem<Item> QUARTZ_WAND_HANDLE = ITEMS.register("quartz_wand_handle", () -> new HandleItem(EMWandHandles.QUARTZ));
    public static final DeferredItem<Item> REDSTONE_WAND_HANDLE = ITEMS.register("redstone_wand_handle", () -> new HandleItem(EMWandHandles.REDSTONE));
    public static final DeferredItem<Item> GLOWSTONE_WAND_HANDLE = ITEMS.register("glowstone_wand_handle", () -> new HandleItem(EMWandHandles.GLOWSTONE));
    public static final DeferredItem<Item> PRISMARINE_WAND_HANDLE = ITEMS.register("prismarine_wand_handle", () -> new HandleItem(EMWandHandles.PRISMARINE));
    public static final DeferredItem<Item> NETHERITE_WAND_HANDLE = ITEMS.register("netherite_wand_handle", () -> new HandleItem(EMWandHandles.NETHERITE));

    /*
    ---------- Tomes ----------
     */

    public static final DeferredItem<BookItem> EXCLUSION_TOME = ITEMS.register("exclusion_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> WAND_TOME = ITEMS.register("wand_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> AUGMENT_TOME = ITEMS.register("augment_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> MAIN_SPELL_TOME = ITEMS.register("main_spell_tome", TomeItem::new);
    public static final DeferredItem<BookItem> BASE_SPELL_TOME = ITEMS.register("base_spell_tome", TomeItem::new);

    /*
    ---------- Foods ----------
     */

    public static final DeferredItem<Item> SHROOM_CLUSTER = ITEMS.register("shroom_cluster", ShroomCluster::new);
    public static final DeferredItem<Item> TOASTED_SHROOM_CLUSTER = ITEMS.register("toasted_shroom_cluster", ToastedShroomCluster::new);

    /*
    ---------- Spawn Eggs ----------
     */

    public static final DeferredItem<Item> GLOOMIE_SPAWN_EGG = ITEMS.register("gloomie_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.GLOOMIE, 0x211b52, 0x804617, new Item.Properties()));
    public static final DeferredItem<Item> GLIMMERBUG_QUEEN_SPAWN_EGG = ITEMS.register("glimmerbug_queen_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.GLIMMERBUG_QUEEN, 0xd47958, 0xc85a32, new Item.Properties()));
    public static final DeferredItem<Item> GLIMMERBUG_SPAWN_EGG = ITEMS.register("glimmerbug_spawn_egg",
            () -> new DeferredSpawnEggItem(EMEntityTypes.GLIMMERBUG, 0xc85a32, 0x276c22, new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}
