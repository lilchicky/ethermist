package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import com.gmail.thelilchicken01.ethermist.item.foods.ShroomCluster;
import com.gmail.thelilchicken01.ethermist.item.foods.ToastedShroomCluster;
import com.gmail.thelilchicken01.ethermist.item.wands.*;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.EMWandTiers;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_type_effects.WandTypes;
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
    public static final DeferredItem<WandItem> WOODEN_DULL_WAND = ITEMS.register("wooden_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_DULL_WAND = ITEMS.register("emerald_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_DULL_WAND = ITEMS.register("diamond_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_DULL_WAND = ITEMS.register("golden_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_DULL_WAND = ITEMS.register("lapis_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_DULL_WAND = ITEMS.register("quartz_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_DULL_WAND = ITEMS.register("redstone_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_DULL_WAND = ITEMS.register("glowstone_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_DULL_WAND = ITEMS.register("prismarine_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_DULL_WAND = ITEMS.register("netherite_dull_wand", () -> new WandItem(WandTypes.DULL, EMWandTiers.NETHERITE));

    /*
    ---------- Flame Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_FLAME_WAND = ITEMS.register("wooden_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_FLAME_WAND = ITEMS.register("emerald_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_FLAME_WAND = ITEMS.register("diamond_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_FLAME_WAND = ITEMS.register("golden_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_FLAME_WAND = ITEMS.register("lapis_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_FLAME_WAND = ITEMS.register("quartz_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_FLAME_WAND = ITEMS.register("redstone_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_FLAME_WAND = ITEMS.register("glowstone_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_FLAME_WAND = ITEMS.register("prismarine_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_FLAME_WAND = ITEMS.register("netherite_flame_wand", () -> new WandItem(WandTypes.FLAME, EMWandTiers.NETHERITE));

    /*
    ---------- Poison Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_POISON_WAND = ITEMS.register("wooden_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_POISON_WAND = ITEMS.register("emerald_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_POISON_WAND = ITEMS.register("diamond_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_POISON_WAND = ITEMS.register("golden_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_POISON_WAND = ITEMS.register("lapis_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_POISON_WAND = ITEMS.register("quartz_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_POISON_WAND = ITEMS.register("redstone_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_POISON_WAND = ITEMS.register("glowstone_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_POISON_WAND = ITEMS.register("prismarine_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_POISON_WAND = ITEMS.register("netherite_poison_wand", () -> new WandItem(WandTypes.POISON, EMWandTiers.NETHERITE));

    /*
    ---------- Levitation Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_LEVITATION_WAND = ITEMS.register("wooden_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_LEVITATION_WAND = ITEMS.register("emerald_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_LEVITATION_WAND = ITEMS.register("diamond_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_LEVITATION_WAND = ITEMS.register("golden_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_LEVITATION_WAND = ITEMS.register("lapis_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_LEVITATION_WAND = ITEMS.register("quartz_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_LEVITATION_WAND = ITEMS.register("redstone_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_LEVITATION_WAND = ITEMS.register("glowstone_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_LEVITATION_WAND = ITEMS.register("prismarine_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_LEVITATION_WAND = ITEMS.register("netherite_levitation_wand", () -> new WandItem(WandTypes.LEVITATION, EMWandTiers.NETHERITE));

    /*
    ---------- Wither Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_WITHER_WAND = ITEMS.register("wooden_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_WITHER_WAND = ITEMS.register("emerald_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_WITHER_WAND = ITEMS.register("diamond_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_WITHER_WAND = ITEMS.register("golden_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_WITHER_WAND = ITEMS.register("lapis_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_WITHER_WAND = ITEMS.register("quartz_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_WITHER_WAND = ITEMS.register("redstone_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_WITHER_WAND = ITEMS.register("glowstone_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_WITHER_WAND = ITEMS.register("prismarine_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_WITHER_WAND = ITEMS.register("netherite_wither_wand", () -> new WandItem(WandTypes.WITHER, EMWandTiers.NETHERITE));

    /*
    ---------- Witch Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_WITCH_WAND = ITEMS.register("wooden_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_WITCH_WAND = ITEMS.register("emerald_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_WITCH_WAND = ITEMS.register("diamond_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_WITCH_WAND = ITEMS.register("golden_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_WITCH_WAND = ITEMS.register("lapis_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_WITCH_WAND = ITEMS.register("quartz_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_WITCH_WAND = ITEMS.register("redstone_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_WITCH_WAND = ITEMS.register("glowstone_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_WITCH_WAND = ITEMS.register("prismarine_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_WITCH_WAND = ITEMS.register("netherite_witch_wand", () -> new WandItem(WandTypes.WITCH, EMWandTiers.NETHERITE));

    /*
    ---------- Heavy Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_HEAVY_WAND = ITEMS.register("wooden_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_HEAVY_WAND = ITEMS.register("emerald_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_HEAVY_WAND = ITEMS.register("diamond_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_HEAVY_WAND = ITEMS.register("golden_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_HEAVY_WAND = ITEMS.register("lapis_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_HEAVY_WAND = ITEMS.register("quartz_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_HEAVY_WAND = ITEMS.register("redstone_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_HEAVY_WAND = ITEMS.register("glowstone_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_HEAVY_WAND = ITEMS.register("prismarine_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_HEAVY_WAND = ITEMS.register("netherite_heavy_wand", () -> new MaceWandItem(WandTypes.HEAVY, EMWandTiers.NETHERITE));

    /*
    ---------- Frozen Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_FROZEN_WAND = ITEMS.register("wooden_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_FROZEN_WAND = ITEMS.register("emerald_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_FROZEN_WAND = ITEMS.register("diamond_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_FROZEN_WAND = ITEMS.register("golden_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_FROZEN_WAND = ITEMS.register("lapis_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_FROZEN_WAND = ITEMS.register("quartz_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_FROZEN_WAND = ITEMS.register("redstone_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_FROZEN_WAND = ITEMS.register("glowstone_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_FROZEN_WAND = ITEMS.register("prismarine_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_FROZEN_WAND = ITEMS.register("netherite_frozen_wand", () -> new WandItem(WandTypes.FROZEN, EMWandTiers.NETHERITE));

    /*
    ---------- Glass Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_GLASS_WAND = ITEMS.register("wooden_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_GLASS_WAND = ITEMS.register("emerald_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_GLASS_WAND = ITEMS.register("diamond_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_GLASS_WAND = ITEMS.register("golden_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_GLASS_WAND = ITEMS.register("lapis_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_GLASS_WAND = ITEMS.register("quartz_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_GLASS_WAND = ITEMS.register("redstone_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_GLASS_WAND = ITEMS.register("glowstone_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_GLASS_WAND = ITEMS.register("prismarine_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_GLASS_WAND = ITEMS.register("netherite_glass_wand", () -> new WandItem(WandTypes.GLASS, EMWandTiers.NETHERITE));

    /*
    ---------- Glimmerbug Wands ----------
     */
    public static final DeferredItem<WandItem> WOODEN_GLIMMERBUG_WAND = ITEMS.register("wooden_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.WOODEN));
    public static final DeferredItem<WandItem> EMERALD_GLIMMERBUG_WAND = ITEMS.register("emerald_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.EMERALD));
    public static final DeferredItem<WandItem> DIAMOND_GLIMMERBUG_WAND = ITEMS.register("diamond_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.DIAMOND, EMWandTiers.DIAMOND_DURABILITY_MULT, 1.0));
    public static final DeferredItem<WandItem> GOLDEN_GLIMMERBUG_WAND = ITEMS.register("golden_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.GOLDEN));
    public static final DeferredItem<WandItem> LAPIS_GLIMMERBUG_WAND = ITEMS.register("lapis_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.LAPIS, 1.0, EMWandTiers.LAPIS_ENCHANTABILITY_MULT));
    public static final DeferredItem<WandItem> QUARTZ_GLIMMERBUG_WAND = ITEMS.register("quartz_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.QUARTZ));
    public static final DeferredItem<WandItem> REDSTONE_GLIMMERBUG_WAND = ITEMS.register("redstone_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.REDSTONE));
    public static final DeferredItem<WandItem> GLOWSTONE_GLIMMERBUG_WAND = ITEMS.register("glowstone_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.GLOWSTONE));
    public static final DeferredItem<WandItem> PRISMARINE_GLIMMERBUG_WAND = ITEMS.register("prismarine_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.PRISMARINE));
    public static final DeferredItem<WandItem> NETHERITE_GLIMMERBUG_WAND = ITEMS.register("netherite_glimmerbug_wand", () -> new WandItem(WandTypes.GLIMMERBUG, EMWandTiers.NETHERITE));
    
     /*
    ---------- Handles ----------
     */

    public static final DeferredItem<Item> WOODEN_WAND_HANDLE = ITEMS.register("wooden_wand_handle", () -> new HandleItem(EMWandTiers.WOODEN));
    public static final DeferredItem<Item> EMERALD_WAND_HANDLE = ITEMS.register("emerald_wand_handle", () -> new HandleItem(EMWandTiers.EMERALD));
    public static final DeferredItem<Item> DIAMOND_WAND_HANDLE = ITEMS.register("diamond_wand_handle", () -> new HandleItem(EMWandTiers.DIAMOND));
    public static final DeferredItem<Item> GOLDEN_WAND_HANDLE = ITEMS.register("golden_wand_handle", () -> new HandleItem(EMWandTiers.GOLDEN));
    public static final DeferredItem<Item> LAPIS_WAND_HANDLE = ITEMS.register("lapis_wand_handle", () -> new HandleItem(EMWandTiers.LAPIS));
    public static final DeferredItem<Item> QUARTZ_WAND_HANDLE = ITEMS.register("quartz_wand_handle", () -> new HandleItem(EMWandTiers.QUARTZ));
    public static final DeferredItem<Item> REDSTONE_WAND_HANDLE = ITEMS.register("redstone_wand_handle", () -> new HandleItem(EMWandTiers.REDSTONE));
    public static final DeferredItem<Item> GLOWSTONE_WAND_HANDLE = ITEMS.register("glowstone_wand_handle", () -> new HandleItem(EMWandTiers.GLOWSTONE));
    public static final DeferredItem<Item> PRISMARINE_WAND_HANDLE = ITEMS.register("prismarine_wand_handle", () -> new HandleItem(EMWandTiers.PRISMARINE));
    public static final DeferredItem<Item> NETHERITE_WAND_HANDLE = ITEMS.register("netherite_wand_handle", () -> new HandleItem(EMWandTiers.NETHERITE));

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
