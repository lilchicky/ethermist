package com.gmail.thelilchicken01.ethermist;

import com.gmail.thelilchicken01.ethermist.datagen.EMTags;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.util.ObfuscationReflectionHelper;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.spongepowered.asm.mixin.injection.At;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@EventBusSubscriber(modid = Ethermist.MODID, bus = EventBusSubscriber.Bus.GAME)
public class EMCommonEvents {

    @SubscribeEvent
    public static void wandLooting(LivingDropsEvent event) {
        if (event.getSource().getEntity() instanceof Player player && !player.level().isClientSide()) {

            AtomicBoolean isAbundant = new AtomicBoolean(false);
            AtomicInteger spellLevel = new AtomicInteger(0);

            EnchantmentHelper.runIterationOnItem(player.getWeaponItem(), (enchantHolder, enchantLevel) -> {
                if (enchantHolder.is(EMEnchantments.AUGMENT_ABUNDANCE.location())) {
                    isAbundant.set(true);
                    spellLevel.set(enchantLevel);
                }
            });

            if (isAbundant.get()) {
                for (ItemEntity drop : event.getDrops()) {
                    int numDrops = drop.getItem().getCount() + player.level().random.nextInt(spellLevel.get() + 1);
                    drop.getItem().setCount(numDrops);
                }

                Entity entity = event.getEntity();
                int newXP = spellLevel.get() + player.level().random.nextInt(spellLevel.get() + 1);

                ExperienceOrb newOrb = new ExperienceOrb(player.level(), entity.getX(), entity.getY(), entity.getZ(), newXP);
                player.level().addFreshEntity(newOrb);
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockDropsEvent event) {
        Entity entity = event.getBreaker();
        ServerLevel level = event.getLevel();

        if (entity instanceof Player player) {

            ItemStack heldItem = player.getItemInHand(player.getUsedItemHand());

            if (heldItem.is(EMTags.Items.WANDS)) {

                List<ItemStack> drops = Block.getDrops(
                        event.getState(),
                        level,
                        event.getPos(),
                        level.getBlockEntity(event.getPos()),
                        player,
                        heldItem);

                if (event.getState().is(Tags.Blocks.ORES)) {

                    AtomicBoolean hasAbundance = new AtomicBoolean(false);
                    AtomicInteger spellLevel = new AtomicInteger(0);

                    EnchantmentHelper.runIterationOnItem(heldItem, (enchantHolder, enchantLevel) -> {
                        if (enchantHolder.is(EMEnchantments.AUGMENT_ABUNDANCE.location())) {
                            hasAbundance.set(true);
                            spellLevel.set(enchantLevel);
                        }
                    });

                    if (hasAbundance.get()) {
                        event.setCanceled(true);
                        for (ItemStack stack : drops) {
                            stack.setCount(stack.getCount() + level.random.nextInt(spellLevel.get() + 1));
                            Block.popResource(level, event.getPos(), stack);
                            ExperienceOrb.award(level, event.getPos().getCenter(), event.getDroppedExperience() * spellLevel.get());
                        }
                    }

                }

            }
        }
    }

}
