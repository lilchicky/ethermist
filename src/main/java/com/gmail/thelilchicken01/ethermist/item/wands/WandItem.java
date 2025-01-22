package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.EMTags;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.*;
import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.EMItems;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandEnchantHandler;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandShotItem;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPortalShape;
import com.google.common.util.concurrent.AtomicDouble;
import net.minecraft.core.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class WandItem extends Item {

    private final SoundEvent SHOOT_SOUND;
    public static final ResourceLocation COOLDOWN_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "cooldown");
    public static final ResourceLocation BASE_WAND_DAMAGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_damage");
    public static final ResourceLocation PROJECTILE_SPEED_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "projectile_speed");
    public static final ResourceLocation WAND_KNOCKBACK_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "knockback");
    public static final ResourceLocation LIFESPAN_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "lifespan");
    public static final ResourceLocation ACCURACY_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "accuracy");

    public WandItem(Properties properties, SoundEvent shootSound) {
        super(properties.stacksTo(1));
        this.SHOOT_SOUND = shootSound;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack wand = player.getItemInHand(usedHand);

        if(!player.getCooldowns().isOnCooldown(this)) {

            WandEnchantHandler.processShot(level, player, wand, this);

            level.playSound(player,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SHOOT_SOUND,
                    SoundSource.PLAYERS,
                    1.0f,
                    level.getRandom().nextFloat() * 0.4f + 0.8f);

            player.awardStat(Stats.ITEM_USED.get(this));

            wand.hurtAndBreak(1, player, wand.getEquipmentSlot());

        }

        return super.use(level, player, usedHand);

    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 5;
    }

    // DEFAULTS
    public int getLifespanSeconds() {
        return 1;
    }
    public int getBonusDamage() {
        return 0;
    }
    public int getSpellDamage() {
        return 2;
    }
    public float getInaccuracy() {
        return 0.0f;
    }
    public float getProjectileSpeed() {
        return 0.25f;
    }
    public boolean getCanIgnite() {
        return false;
    }
    public double getKnockback() {
        return 0.25;
    }
    public int getCooldown() {
        return 20 * 4;
    }
    public WandShotItem getShotItem() {
        return EMItems.GENERIC_SHOT.get();
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {

        var builder = ItemAttributeModifiers.builder();
        AtomicInteger newCD = new AtomicInteger(getCooldown());
        AtomicInteger newDamage = new AtomicInteger(getSpellDamage() + getBonusDamage());
        AtomicInteger newLifespan = new AtomicInteger(getLifespanSeconds());
        AtomicDouble newPSpeed = new AtomicDouble(getProjectileSpeed());
        AtomicDouble newKnockback = new AtomicDouble(getKnockback());
        AtomicDouble newAccuracy = new AtomicDouble(getInaccuracy());

        EnchantmentHelper.runIterationOnItem(stack, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.QUICK_CAST.location())) {
                newCD.set(QuickCastEnchant.modifyCooldown(enchantLevel, newCD.get()));
            }
            if (enchantHolder.is(EMEnchantments.ANCIENT_POWER.location())) {
                newDamage.set(AncientPowerEnchant.modifyDamage(enchantLevel, newDamage.get()));
            }
            if (enchantHolder.is(EMEnchantments.ARCANE_VELOCITY.location())) {
                newPSpeed.set(ArcaneVelocityEnchant.modifyPSpeed(enchantLevel, (float)newPSpeed.get()));
            }
            if (enchantHolder.is(EMEnchantments.RUNIC_FORCE.location())) {
                newKnockback.set(RunicForceEnchant.modifyKnockback(enchantLevel, newKnockback.get()));
            }
            if (enchantHolder.is(EMEnchantments.ENDURING_MAGIC.location())) {
                newLifespan.set(EnduringMagicEnchant.modifyLifespan(enchantLevel, newLifespan.get()));
            }
            if (enchantHolder.is(EMEnchantments.STABLE_ORB.location())) {
                newAccuracy.set(StableOrbEnchant.modifyAccuracy(enchantLevel, newAccuracy.get()));
            }

        });

        builder.add(
                EMAttributes.PROJECTILE_SPEED,
                new AttributeModifier(
                        PROJECTILE_SPEED_ID,
                        newPSpeed.get(),
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                ),
                EquipmentSlotGroup.HAND
        );
        builder.add(
                EMAttributes.WAND_KNOCKBACK,
                new AttributeModifier(
                        WAND_KNOCKBACK_ID,
                        newKnockback.get(),
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                ),
                EquipmentSlotGroup.HAND
        );
        builder.add(
                EMAttributes.COOLDOWN,
                new AttributeModifier(
                        COOLDOWN_ID,
                        newCD.get() / 20.0,
                        AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.HAND
        );
        builder.add(
                EMAttributes.WAND_DAMAGE,
                new AttributeModifier(
                        BASE_WAND_DAMAGE_ID,
                        newDamage.get(),
                        AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.HAND
        );
        builder.add(
                EMAttributes.LIFESPAN,
                new AttributeModifier(
                        LIFESPAN_ID,
                        newLifespan.get(),
                        AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.HAND
        );
        builder.add(
                EMAttributes.ACCURACY,
                new AttributeModifier(
                        ACCURACY_ID,
                        1 - (newAccuracy.get()/100),
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                ),
                EquipmentSlotGroup.HAND
        );
        return builder.build();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, WandEnchantHandler.getHoverText(stack,this, context, tooltipComponents), tooltipFlag);
    }

    /*
    UseOn code courtesy of Undergarden :)
     */

    @Override
    public InteractionResult useOn(UseOnContext context) {

        if (context.getLevel().getBlockState(context.getClickedPos()).is(EMTags.Blocks.PORTAL_FRAME_BLOCKS) &&
                (context.getLevel().dimension() == Level.OVERWORLD || context.getLevel().dimension() == Ethermist.ETHERMIST)) {
            BlockPos framePos = context.getClickedPos().relative(context.getClickedFace());
            Optional<EMPortalShape> optional = findPortalShape(
                    context.getLevel(),
                    framePos,
                    shape -> shape.isValid() && shape.getNumPortalBlocks() == 0,
                    Direction.Axis.X);
            if (optional.isPresent()) {
                optional.get().createPortalBlocks();
                context.getLevel().playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);

                if (!context.getLevel().isClientSide()) {
                    context.getItemInHand().hurtAndBreak(1,
                            context.getPlayer(),
                            context.getItemInHand().getEquipmentSlot());
                }

                return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
            }
        }
        else {
            this.use(context.getLevel(), context.getPlayer(), context.getHand());
            return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
        }
        return InteractionResult.FAIL;
    }

    public static Optional<EMPortalShape> findPortalShape(LevelAccessor accessor, BlockPos pos, Predicate<EMPortalShape> shape, Direction.Axis axis) {
        Optional<EMPortalShape> optional = Optional.of(new EMPortalShape(accessor, pos, axis)).filter(shape);
        if (optional.isPresent()) {
            return optional;
        } else {
            Direction.Axis oppositeAxis = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
            return Optional.of(new EMPortalShape(accessor, pos, oppositeAxis)).filter(shape);
        }
    }

}
