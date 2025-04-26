package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.foods.ShroomCluster;
import com.gmail.thelilchicken01.ethermist.item.foods.ToastedShroomCluster;
import com.gmail.thelilchicken01.ethermist.item.wands.*;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
import net.minecraft.world.item.BookItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
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
    public static final DeferredItem<WandShotItem> GLIMMERBUG_SHOT = ITEMS.register("glimmerbug_shot", () -> new WandShotItem(WandModifiers.GLIMMERBUG));

    public static final DeferredItem<WandShotItem> METEOR_SHOT = ITEMS.register("meteor_shot", () -> new WandShotItem());

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
    public static final DeferredItem<WandItem> WOODEN_DULL_WAND = ITEMS.register("wooden_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_DULL_WAND = ITEMS.register("emerald_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_DULL_WAND = ITEMS.register("diamond_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_DULL_WAND = ITEMS.register("golden_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_DULL_WAND = ITEMS.register("lapis_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_DULL_WAND = ITEMS.register("quartz_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_DULL_WAND = ITEMS.register("redstone_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_DULL_WAND = ITEMS.register("glowstone_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_DULL_WAND = ITEMS.register("prismarine_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_DULL_WAND = ITEMS.register("netherite_dull_wand", () -> new WandItem(WandTypes.DULL_WAND, WandTiers.NETHERITE));

    /*
    ---------- Flame Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_FLAME_WAND = ITEMS.register("wooden_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_FLAME_WAND = ITEMS.register("emerald_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_FLAME_WAND = ITEMS.register("diamond_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_FLAME_WAND = ITEMS.register("golden_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_FLAME_WAND = ITEMS.register("lapis_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_FLAME_WAND = ITEMS.register("quartz_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_FLAME_WAND = ITEMS.register("redstone_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_FLAME_WAND = ITEMS.register("glowstone_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_FLAME_WAND = ITEMS.register("prismarine_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_FLAME_WAND = ITEMS.register("netherite_flame_wand", () -> new WandItem(WandTypes.FLAME_WAND, WandTiers.NETHERITE));

    /*
    ---------- Poison Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_POISON_WAND = ITEMS.register("wooden_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_POISON_WAND = ITEMS.register("emerald_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_POISON_WAND = ITEMS.register("diamond_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_POISON_WAND = ITEMS.register("golden_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_POISON_WAND = ITEMS.register("lapis_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_POISON_WAND = ITEMS.register("quartz_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_POISON_WAND = ITEMS.register("redstone_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_POISON_WAND = ITEMS.register("glowstone_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_POISON_WAND = ITEMS.register("prismarine_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_POISON_WAND = ITEMS.register("netherite_poison_wand", () -> new WandItem(WandTypes.POISON_WAND, WandTiers.NETHERITE));

    /*
    ---------- Levitation Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_LEVITATION_WAND = ITEMS.register("wooden_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_LEVITATION_WAND = ITEMS.register("emerald_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_LEVITATION_WAND = ITEMS.register("diamond_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_LEVITATION_WAND = ITEMS.register("golden_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_LEVITATION_WAND = ITEMS.register("lapis_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_LEVITATION_WAND = ITEMS.register("quartz_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_LEVITATION_WAND = ITEMS.register("redstone_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_LEVITATION_WAND = ITEMS.register("glowstone_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_LEVITATION_WAND = ITEMS.register("prismarine_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_LEVITATION_WAND = ITEMS.register("netherite_levitation_wand", () -> new WandItem(WandTypes.LEVITATION_WAND, WandTiers.NETHERITE));

    /*
    ---------- Wither Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_WITHER_WAND = ITEMS.register("wooden_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_WITHER_WAND = ITEMS.register("emerald_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_WITHER_WAND = ITEMS.register("diamond_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_WITHER_WAND = ITEMS.register("golden_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_WITHER_WAND = ITEMS.register("lapis_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_WITHER_WAND = ITEMS.register("quartz_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_WITHER_WAND = ITEMS.register("redstone_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_WITHER_WAND = ITEMS.register("glowstone_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_WITHER_WAND = ITEMS.register("prismarine_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_WITHER_WAND = ITEMS.register("netherite_wither_wand", () -> new WandItem(WandTypes.WITHER_WAND, WandTiers.NETHERITE));

    /*
    ---------- Witch Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_WITCH_WAND = ITEMS.register("wooden_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_WITCH_WAND = ITEMS.register("emerald_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_WITCH_WAND = ITEMS.register("diamond_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_WITCH_WAND = ITEMS.register("golden_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_WITCH_WAND = ITEMS.register("lapis_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_WITCH_WAND = ITEMS.register("quartz_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_WITCH_WAND = ITEMS.register("redstone_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_WITCH_WAND = ITEMS.register("glowstone_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_WITCH_WAND = ITEMS.register("prismarine_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_WITCH_WAND = ITEMS.register("netherite_witch_wand", () -> new WandItem(WandTypes.WITCH_WAND, WandTiers.NETHERITE));

    /*
    ---------- Heavy Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_HEAVY_WAND = ITEMS.register("wooden_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_HEAVY_WAND = ITEMS.register("emerald_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_HEAVY_WAND = ITEMS.register("diamond_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_HEAVY_WAND = ITEMS.register("golden_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_HEAVY_WAND = ITEMS.register("lapis_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_HEAVY_WAND = ITEMS.register("quartz_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_HEAVY_WAND = ITEMS.register("redstone_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_HEAVY_WAND = ITEMS.register("glowstone_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_HEAVY_WAND = ITEMS.register("prismarine_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_HEAVY_WAND = ITEMS.register("netherite_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY_WAND, WandTiers.NETHERITE));

    /*
    ---------- Frozen Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_FROZEN_WAND = ITEMS.register("wooden_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_FROZEN_WAND = ITEMS.register("emerald_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_FROZEN_WAND = ITEMS.register("diamond_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_FROZEN_WAND = ITEMS.register("golden_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_FROZEN_WAND = ITEMS.register("lapis_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_FROZEN_WAND = ITEMS.register("quartz_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_FROZEN_WAND = ITEMS.register("redstone_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_FROZEN_WAND = ITEMS.register("glowstone_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_FROZEN_WAND = ITEMS.register("prismarine_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_FROZEN_WAND = ITEMS.register("netherite_frozen_wand", () -> new WandItem(WandTypes.FROZEN_WAND, WandTiers.NETHERITE));

    /*
    ---------- Glass Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_GLASS_WAND = ITEMS.register("wooden_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_GLASS_WAND = ITEMS.register("emerald_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_GLASS_WAND = ITEMS.register("diamond_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_GLASS_WAND = ITEMS.register("golden_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_GLASS_WAND = ITEMS.register("lapis_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_GLASS_WAND = ITEMS.register("quartz_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_GLASS_WAND = ITEMS.register("redstone_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_GLASS_WAND = ITEMS.register("glowstone_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_GLASS_WAND = ITEMS.register("prismarine_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_GLASS_WAND = ITEMS.register("netherite_glass_wand", () -> new WandItem(WandTypes.GLASS_WAND, WandTiers.NETHERITE));

    /*
    ---------- Glimmerbug Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_GLIMMERBUG_WAND = ITEMS.register("wooden_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_GLIMMERBUG_WAND = ITEMS.register("emerald_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_GLIMMERBUG_WAND = ITEMS.register("diamond_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.DIAMOND));
    public static final DeferredItem<WandItem> GOLDEN_GLIMMERBUG_WAND = ITEMS.register("golden_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_GLIMMERBUG_WAND = ITEMS.register("lapis_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.LAPIS));
    public static final DeferredItem<WandItem> QUARTZ_GLIMMERBUG_WAND = ITEMS.register("quartz_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_GLIMMERBUG_WAND = ITEMS.register("redstone_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_GLIMMERBUG_WAND = ITEMS.register("glowstone_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_GLIMMERBUG_WAND = ITEMS.register("prismarine_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_GLIMMERBUG_WAND = ITEMS.register("netherite_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG_WAND, WandTiers.NETHERITE));
    
     /*
    ---------- Handles ----------
     */

    public static final DeferredItem<Item> WOODEN_WAND_HANDLE = ITEMS.register("wooden_wand_handle", () -> new HandleItem(WandTiers.WOODEN));
    public static final DeferredItem<Item> EMERALD_WAND_HANDLE = ITEMS.register("emerald_wand_handle", () -> new HandleItem(WandTiers.EMERALD));
    public static final DeferredItem<Item> DIAMOND_WAND_HANDLE = ITEMS.register("diamond_wand_handle", () -> new HandleItem(WandTiers.DIAMOND));
    public static final DeferredItem<Item> GOLDEN_WAND_HANDLE = ITEMS.register("golden_wand_handle", () -> new HandleItem(WandTiers.GOLDEN));
    public static final DeferredItem<Item> LAPIS_WAND_HANDLE = ITEMS.register("lapis_wand_handle", () -> new HandleItem(WandTiers.LAPIS));
    public static final DeferredItem<Item> QUARTZ_WAND_HANDLE = ITEMS.register("quartz_wand_handle", () -> new HandleItem(WandTiers.QUARTZ));
    public static final DeferredItem<Item> REDSTONE_WAND_HANDLE = ITEMS.register("redstone_wand_handle", () -> new HandleItem(WandTiers.REDSTONE));
    public static final DeferredItem<Item> GLOWSTONE_WAND_HANDLE = ITEMS.register("glowstone_wand_handle", () -> new HandleItem(WandTiers.GLOWSTONE));
    public static final DeferredItem<Item> PRISMARINE_WAND_HANDLE = ITEMS.register("prismarine_wand_handle", () -> new HandleItem(WandTiers.PRISMARINE));
    public static final DeferredItem<Item> NETHERITE_WAND_HANDLE = ITEMS.register("netherite_wand_handle", () -> new HandleItem(WandTiers.NETHERITE));

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
