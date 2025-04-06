package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.EMConfig;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.*;
import com.gmail.thelilchicken01.ethermist.item.EMAttributes;
import com.gmail.thelilchicken01.ethermist.item.wand_projectile.WandProjectileHandler;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPortalShape;
import com.google.common.util.concurrent.AtomicDouble;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WandItem extends Item {

    public final SoundEvent SHOOT_SOUND;
    public final WandTypes TIER;
    public static final ResourceLocation COOLDOWN_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "cooldown");
    public static final ResourceLocation BASE_WAND_DAMAGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_damage");
    public static final ResourceLocation PROJECTILE_SPEED_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "projectile_speed");
    public static final ResourceLocation WAND_KNOCKBACK_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "knockback");
    public static final ResourceLocation LIFESPAN_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "lifespan");
    public static final ResourceLocation ACCURACY_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "accuracy");
    public static final ResourceLocation BLOCK_INTERACTION_RANGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block_interaction_range");
    public static final ResourceLocation ENTITY_INTERACTION_RANGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "entity_interaction_range");

    public WandItem(WandTypes tier) {
        super(new Item.Properties().stacksTo(1)
                .component(DataComponents.DYED_COLOR, new DyedItemColor(Ethermist.WAND_COLOR, false))
                .durability((int) (128 * tier.getDurabilityMult())));
        this.SHOOT_SOUND = tier.getShootSound();
        this.TIER = tier;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack wand = player.getItemInHand(usedHand);

        if (!player.getCooldowns().isOnCooldown(this) && !isMeteor(wand).get()) {

            WandProjectileHandler.processShot(level, player, wand, this, null, null);

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
        return TIER.getEnchantability();
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairItem) {
        return stack.isDamaged() && TIER.getRepairItem().get().test(repairItem);
    }

    public WandTypes getTier() {
        return TIER;
    }

    public float[] getTrailColor(ItemStack stack) {
        int color = stack.get(DataComponents.DYED_COLOR).rgb();
        if (color != Ethermist.WAND_COLOR) {
            float r = (color >> 16 & 255) / 255.0f;
            float g = (color >> 8 & 255) / 255.0f;
            float b = (color & 255) / 255.0f;
            return new float[]{r, g, b};
        } else {
            return TIER.getTrailColor();
        }
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {

        var builder = ItemAttributeModifiers.builder();
        AtomicInteger newCD = new AtomicInteger(TIER.getCooldown());
        AtomicDouble newDamage = new AtomicDouble(TIER.getSpellDamage());
        AtomicInteger newLifespan = new AtomicInteger(TIER.getLifespanSeconds());
        AtomicDouble newPSpeed = new AtomicDouble(TIER.getProjectileSpeed());
        AtomicDouble newKnockback = new AtomicDouble(TIER.getKnockback());
        AtomicDouble newAccuracy = new AtomicDouble(TIER.getInaccuracy());
        AtomicInteger sprayLevel = new AtomicInteger(0);
        AtomicInteger chaosMagicLevel = new AtomicInteger(0);
        AtomicInteger focusLevel = new AtomicInteger(0);

        AtomicBoolean isMeteorLocal = new AtomicBoolean(false);
        AtomicBoolean isSprayLocal = new AtomicBoolean(false);
        AtomicBoolean isChaosMagic = new AtomicBoolean(false);
        AtomicBoolean isThunderstrike = new AtomicBoolean(false);
        AtomicBoolean isVolatileEnergy = new AtomicBoolean(false);
        AtomicBoolean isAugmentFocus = new AtomicBoolean(false);

        EnchantmentHelper.runIterationOnItem(stack, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.QUICK_CAST.location())) {
                newCD.set(QuickCastEnchant.modifyCooldown(enchantLevel, newCD.get()));
            }
            if (enchantHolder.is(EMEnchantments.ANCIENT_POWER.location())) {
                newDamage.set(AncientPowerEnchant.modifyDamage(enchantLevel, newDamage.get()));
            }
            if (enchantHolder.is(EMEnchantments.ARCANE_VELOCITY.location())) {
                newPSpeed.set(ArcaneVelocityEnchant.modifyPSpeed(enchantLevel, (float) newPSpeed.get()));
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
            if (enchantHolder.is(EMEnchantments.AUGMENT_SPRAY.location())) {
                sprayLevel.set(enchantLevel);
                isSprayLocal.set(true);
            }
            if (enchantHolder.is(EMEnchantments.AUGMENT_METEOR.location())) {
                isMeteorLocal.set(true);
            }
            if (enchantHolder.is(EMEnchantments.CHAOS_MAGIC.location())) {
                isChaosMagic.set(true);
                chaosMagicLevel.set(enchantLevel);
            }
            if (enchantHolder.is(EMEnchantments.THUNDERSTRIKE.location())) {
                isThunderstrike.set(true);
            }
            if (enchantHolder.is(EMEnchantments.VOLATILE_ENERGY.location())) {
                isVolatileEnergy.set(true);
            }
            if (enchantHolder.is(EMEnchantments.AUGMENT_FOCUS.location())) {
                isAugmentFocus.set(true);
                focusLevel.set(enchantLevel);
            }
        });

        // Augment Modifiers
        if (isMeteorLocal.get()) {
            newDamage.set(newDamage.get() * 3);
            newLifespan.set(newLifespan.get() * 2);
            newAccuracy.set(newAccuracy.get() * 0.1);
        }
        if (isSprayLocal.get()) {
            newDamage.set(newDamage.get() / (1 + (0.81 * (1 / (1.0 + sprayLevel.get())) * Math.sqrt(newDamage.get()))));
            newLifespan.set((int) (newLifespan.get() * 0.1));
            if (newLifespan.get() == 0) {
                newLifespan.set(1);
            }
            newPSpeed.set(newPSpeed.get() * 0.5);
            newCD.set(5);
        }
        if (isAugmentFocus.get()) {
            newDamage.set(newDamage.get() * (focusLevel.get() * 1.5));
            newPSpeed.set(newPSpeed.get() * 4.5);
            newAccuracy.set(0.0);
            newCD.set(newCD.get() * 4);
        }

        // Spell Modifiers
        if (isChaosMagic.get()) {
            newDamage.set(newDamage.get() * chaosMagicLevel.get());
        }
        if (isThunderstrike.get()) {
            if (isSprayLocal.get()) {
                newCD.set(40);
            } else if (isAugmentFocus.get()) {
                newCD.set(newCD.get() + 40);
            } else {
                newCD.set(newCD.get() * 3);
            }
        }
        if (isVolatileEnergy.get()) {
            newDamage.set(newDamage.get() * 0.5);
        }

        // Set Attributes
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
                        1 - (newAccuracy.get() / 100),
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                ),
                EquipmentSlotGroup.HAND
        );
        if (isMeteorLocal.get()) {
            builder.add(
                    Attributes.BLOCK_INTERACTION_RANGE,
                    new AttributeModifier(
                            BLOCK_INTERACTION_RANGE_ID,
                            16,
                            AttributeModifier.Operation.ADD_VALUE
                    ),
                    EquipmentSlotGroup.HAND
            );
            builder.add(
                    Attributes.ENTITY_INTERACTION_RANGE,
                    new AttributeModifier(
                            ENTITY_INTERACTION_RANGE_ID,
                            16,
                            AttributeModifier.Operation.ADD_VALUE
                    ),
                    EquipmentSlotGroup.HAND
            );
        }
        if (stack.getItem() instanceof MaceWandItem) {
            builder.add(
                    Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 5.0, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );
            builder.add(
                    Attributes.ATTACK_SPEED,
                    new AttributeModifier(BASE_ATTACK_SPEED_ID, -3.4F, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );
        }
        return builder.build();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lore, TooltipFlag tooltipFlag) {

        // This code is added to make the "Dyeable" text multicolored, without
        // hardcoding it. That lets it dynamically work with different
        // language files, no matter the length of the phrase used here.

        int[] colors = {
                0xFF5555, // red
                0xFFAA00, // orange
                0xFFFF55, // yellow
                0x55FF55, // green
                0x55FFFF, // cyan
                0x5555FF, // blue
                0xAA00FF  // purple
        };

        MutableComponent dyeableText = Component.empty();
        String text = I18n.get("item." + Ethermist.MODID + ".wand.dyeable");

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int color = colors[i % colors.length];

            dyeableText.append(Component.literal(String.valueOf(c)).withColor(color));
        }

        lore.add(dyeableText);
        lore.add(Component.translatable(this.getDescriptionId() + ".desc").withColor(0xAAAAAA));
        if (stack.isEnchanted()) {
            lore.add(Component.empty());
        }

        super.appendHoverText(stack, context, lore, tooltipFlag);
    }

    private AtomicBoolean isMeteor(ItemStack stack) {

        AtomicBoolean isMeteor = new AtomicBoolean(false);
        EnchantmentHelper.runIterationOnItem(stack, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.AUGMENT_METEOR.location())) {
                isMeteor.set(true);
            }
        });
        return isMeteor;
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
        } else if (context.getLevel().getBlockState(context.getClickedPos()).is(Blocks.WATER_CAULDRON)) {
            BlockState cauldron = context.getLevel().getBlockState(context.getClickedPos());
            int fillLevel = cauldron.getValue(LayeredCauldronBlock.LEVEL);
            if (fillLevel > 0) {
                ItemStack wand = context.getItemInHand();
                if (wand.get(DataComponents.DYED_COLOR).rgb() != Ethermist.WAND_COLOR) {
                    wand.set(DataComponents.DYED_COLOR, new DyedItemColor(Ethermist.WAND_COLOR, false));
                    LayeredCauldronBlock.lowerFillLevel(cauldron, context.getLevel(), context.getClickedPos());
                    return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
                }
            }
        } else {
            Player player = context.getPlayer();
            Level level = context.getLevel();

            ItemStack wand = player.getItemInHand(context.getHand());

            if (!isMeteor(wand).get()) {
                this.use(level, player, context.getHand());
                return InteractionResult.sidedSuccess(level.isClientSide());
            } else {

                if (!player.getCooldowns().isOnCooldown(this)) {

                    WandProjectileHandler.processShot(level, player, wand, this, context.getClickedPos(), null);

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

                return InteractionResult.sidedSuccess(level.isClientSide());
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {

        ItemStack wand = player.getItemInHand(usedHand);

        if (isMeteor(wand).get()) {

            Level level = player.level();

            if (!player.getCooldowns().isOnCooldown(this)) {

                WandProjectileHandler.processShot(level, player, wand, this, null, interactionTarget);

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

            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return super.interactLivingEntity(stack, player, interactionTarget, usedHand);
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

    @Override
    public boolean isFoil(ItemStack stack) {
        return !EMConfig.hideGlint && super.isFoil(stack);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

}
