package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.AncientPowerEnchant;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EMAttributes {

    public static final DeferredRegister<Attribute> EM_ATTRIBUTES =
            DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, Ethermist.MODID);

    public static final DeferredHolder<Attribute, Attribute> WAND_DAMAGE = EM_ATTRIBUTES.register("attribute.ethermist.wand.base_damage", () ->
            new RangedAttribute("attribute.ethermist.wand.base_damage", 1.0F, 0.0F, 1024.0F).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> COOLDOWN = EM_ATTRIBUTES.register("attribute.ethermist.wand.cooldown", () ->
            new RangedAttribute("attribute.ethermist.wand.cooldown", 1.0F, 0.0F, 1024.0F).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> PROJECTILE_SPEED = EM_ATTRIBUTES.register("attribute.ethermist.wand.projectile_speed", () ->
            new RangedAttribute("attribute.ethermist.wand.projectile_speed", 1.0F, 0.0F, 1024.0F).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> WAND_KNOCKBACK = EM_ATTRIBUTES.register("attribute.ethermist.wand.knockback", () ->
            new RangedAttribute("attribute.ethermist.wand.knockback", 1.0F, 0.0F, 1024.0F).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> LIFESPAN = EM_ATTRIBUTES.register("attribute.ethermist.wand.lifespan", () ->
            new RangedAttribute("attribute.ethermist.wand.lifespan", 1.0F, 0.0F, 1024.0F).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> ACCURACY = EM_ATTRIBUTES.register("attribute.ethermist.wand.wand_accuracy", () ->
            new RangedAttribute("attribute.ethermist.wand.wand_accuracy", 1.0F, 0.0F, 1024.0F).setSyncable(true));

    public static void register(IEventBus bus) {
        EM_ATTRIBUTES.register(bus);
    }

}
