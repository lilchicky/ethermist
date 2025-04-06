package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EMAttributes {

    public static final DeferredRegister<Attribute> EM_ATTRIBUTES =
            DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, Ethermist.MODID);

    public static final DeferredHolder<Attribute, Attribute> WAND_DAMAGE = EM_ATTRIBUTES.register("wand.base_damage", () ->
            new WandAttribute("attribute.ethermist.wand.base_damage", 0.0F, 0.0F, 1024.0F).setSyncable(true));

    public static final DeferredHolder<Attribute, Attribute> COOLDOWN = EM_ATTRIBUTES.register("wand.cooldown", () ->
            new WandAttribute("attribute.ethermist.wand.cooldown", 0.0F, 0.0F, 1024.0F).setSyncable(true));

    public static final DeferredHolder<Attribute, Attribute> PROJECTILE_SPEED = EM_ATTRIBUTES.register("wand.projectile_speed", () ->
            new WandAttribute("attribute.ethermist.wand.projectile_speed", 0.0F, 0.0F, 1024.0F).setSyncable(true));

    public static final DeferredHolder<Attribute, Attribute> WAND_KNOCKBACK = EM_ATTRIBUTES.register("wand.knockback", () ->
            new WandAttribute("attribute.ethermist.wand.knockback", 0.0F, 0.0F, 1024.0F).setSyncable(true));

    public static final DeferredHolder<Attribute, Attribute> LIFESPAN = EM_ATTRIBUTES.register("wand.lifespan", () ->
            new WandAttribute("attribute.ethermist.wand.lifespan", 0.0F, 0.0F, 1024.0F).setSyncable(true));

    public static final DeferredHolder<Attribute, Attribute> ACCURACY = EM_ATTRIBUTES.register("wand.wand_accuracy", () ->
            new WandAttribute("attribute.ethermist.wand.wand_accuracy", 0.0F, 0.0F, 1024.0F).setSyncable(true));

    public static void register(IEventBus bus) {
        EM_ATTRIBUTES.register(bus);
    }

}
