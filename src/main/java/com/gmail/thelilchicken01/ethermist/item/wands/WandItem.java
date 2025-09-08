package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.EMConfig;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.enchantment.EMEnchantments;
import com.gmail.thelilchicken01.ethermist.enchantment.custom_enchants.*;
import com.gmail.thelilchicken01.ethermist.item.IDyeableWandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectileHandler;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.IWandTiers;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_tier_effects.WandTier;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_type_effects.IWandTypes;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_type_effects.WandTypes;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPortalShape;
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
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import static com.gmail.thelilchicken01.ethermist.item.wands.WandUtil.getBaseWandName;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WandItem extends Item implements IDyeableWandItem {

    private final SoundEvent SHOOT_SOUND;
    private final IWandTypes TYPE;
    private final DeferredHolder<WandTier, WandTier> TIER;
    private final double ENCHANT_MULT;

    public static final ResourceLocation COOLDOWN_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "cooldown");
    public static final ResourceLocation BASE_WAND_DAMAGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_damage");
    public static final ResourceLocation PROJECTILE_SPEED_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "projectile_speed");
    public static final ResourceLocation WAND_KNOCKBACK_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "knockback");
    public static final ResourceLocation LIFESPAN_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "lifespan");
    public static final ResourceLocation ACCURACY_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "accuracy");
    public static final ResourceLocation BLOCK_INTERACTION_RANGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block_interaction_range");
    public static final ResourceLocation ENTITY_INTERACTION_RANGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "entity_interaction_range");

    public WandItem(IWandTypes type, DeferredHolder<WandTier, WandTier> tier, double durabilityMult, double enchantMult) {
        super(new Item.Properties().stacksTo(1)
                .component(DataComponents.DYED_COLOR, new DyedItemColor(Ethermist.WAND_COLOR, false))
                .durability(Math.max((int) (128 * type.getDurabilityMult() * durabilityMult), 1)));
        this.SHOOT_SOUND = type.getShootSound();
        this.TYPE = type;
        this.TIER = tier;
        this.ENCHANT_MULT = enchantMult;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack wand = player.getItemInHand(usedHand);

        if (!player.getCooldowns().isOnCooldown(this) && !isMeteor(wand).get() && usedHand == InteractionHand.MAIN_HAND) {

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
        return (int)(TYPE.getEnchantability() * ENCHANT_MULT);
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairItem) {
        return stack.isDamaged() && (TYPE.getRepairItem().get().test(repairItem) || TIER.get().getRepairItem().get().test(repairItem));
    }

    public IWandTypes getType() {
        return TYPE;
    }

    public IWandTiers getTier() {
        return TIER.get();
    }

    public SoundEvent getShootSound() {
        return SHOOT_SOUND;
    }

    public float[] getTrailColor(ItemStack stack) {
        int color = stack.get(DataComponents.DYED_COLOR).rgb();
        if (color != Ethermist.WAND_COLOR) {
            float r = (color >> 16 & 255) / 255.0f;
            float g = (color >> 8 & 255) / 255.0f;
            float b = (color & 255) / 255.0f;
            return new float[]{r, g, b};
        } else {
            return TYPE.getTrailColor();
        }
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        // 1) Seed from TYPE
        WandAttributeState currentAttributeState = new WandAttributeState().seed(
                TYPE.getCooldown(),          // ticks
                TYPE.getSpellDamage(),       // flat
                TYPE.getLifespanSeconds(),   // seconds
                TYPE.getProjectileSpeed(),   // mult
                TYPE.getKnockback(),         // mult
                TYPE.getInaccuracy()         // %-points (0 = 100% accurate)
        );

        // 2) Apply the handle/tier (registry-driven)
        // If TIER is fixed per-item class, this is fine. If it can vary per-stack, resolve from NBT/registry here instead.
        TIER.get().apply(currentAttributeState);

        // 3) Enchantments/flags
        AtomicInteger sprayLevel = new AtomicInteger();
        AtomicInteger chaosMagicLevel = new AtomicInteger();
        AtomicInteger focusLevel = new AtomicInteger();

        AtomicBoolean isMeteorLocal = new AtomicBoolean(false);
        AtomicBoolean isSprayLocal = new AtomicBoolean(false);
        AtomicBoolean isChaosMagic = new AtomicBoolean(false);
        AtomicBoolean isThunderstrike = new AtomicBoolean(false);
        AtomicBoolean isVolatileEnergy = new AtomicBoolean(false);
        AtomicBoolean isAugmentFocus = new AtomicBoolean(false);

        EnchantmentHelper.runIterationOnItem(stack, (enchantHolder, enchantLevel) -> {
            if (enchantHolder.is(EMEnchantments.QUICK_CAST.location())) {
                currentAttributeState.cooldownTicks = QuickCastEnchant.modifyCooldown(enchantLevel, currentAttributeState.cooldownTicks);
            }
            if (enchantHolder.is(EMEnchantments.ANCIENT_POWER.location())) {
                currentAttributeState.damage = AncientPowerEnchant.modifyDamage(enchantLevel, currentAttributeState.damage);
            }
            if (enchantHolder.is(EMEnchantments.ARCANE_VELOCITY.location())) {
                currentAttributeState.projectileSpeedMult = ArcaneVelocityEnchant.modifyPSpeed(enchantLevel, (float) currentAttributeState.projectileSpeedMult);
            }
            if (enchantHolder.is(EMEnchantments.RUNIC_FORCE.location())) {
                currentAttributeState.knockbackMult = RunicForceEnchant.modifyKnockback(enchantLevel, currentAttributeState.knockbackMult);
            }
            if (enchantHolder.is(EMEnchantments.ENDURING_MAGIC.location())) {
                currentAttributeState.lifespanSeconds = EnduringMagicEnchant.modifyLifespan(enchantLevel, currentAttributeState.lifespanSeconds);
            }
            if (enchantHolder.is(EMEnchantments.STABLE_ORB.location())) {
                currentAttributeState.inaccuracyPercent = StableOrbEnchant.modifyAccuracy(enchantLevel, currentAttributeState.inaccuracyPercent);
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

        // 4) Augment modifiers (ported 1:1)
        if (isMeteorLocal.get()) {
            currentAttributeState.damage *= 3.0;
            currentAttributeState.lifespanSeconds *= 2.0;
            currentAttributeState.inaccuracyPercent *= 0.1; // 90% more accurate
        }
        if (isSprayLocal.get()) {
            currentAttributeState.damage = currentAttributeState.damage / (1 + (0.81 * (1 / (1.0 + sprayLevel.get())) * Math.sqrt(currentAttributeState.damage)));
            currentAttributeState.lifespanSeconds = Math.max(1.0, currentAttributeState.lifespanSeconds * 0.1);
            currentAttributeState.projectileSpeedMult *= 0.5;
            currentAttributeState.cooldownTicks = 5;
        }
        if (isAugmentFocus.get()) {
            currentAttributeState.damage *= (focusLevel.get() * 1.5);
            currentAttributeState.projectileSpeedMult *= 4.5;
            currentAttributeState.inaccuracyPercent = 0.0;
            currentAttributeState.cooldownTicks *= 4;
        }

        // 5) Spell modifiers (ported 1:1)
        if (isChaosMagic.get()) {
            currentAttributeState.damage *= chaosMagicLevel.get();
        }
        if (isThunderstrike.get()) {
            if (isSprayLocal.get()) {
                currentAttributeState.cooldownTicks = 40;
            } else if (isAugmentFocus.get()) {
                currentAttributeState.cooldownTicks += 40;
            } else {
                currentAttributeState.cooldownTicks *= 3;
            }
        }
        if (isVolatileEnergy.get()) {
            currentAttributeState.damage *= 0.5;
        }

        // 6) Clamp & emit
        currentAttributeState.clamp();

        var builder = ItemAttributeModifiers.builder();
        currentAttributeState.addToBuilder(builder, EquipmentSlotGroup.MAINHAND); // uses your WandItem UUIDs/EMAttributes

        if (isMeteorLocal.get()) {
            builder.add(
                    Attributes.BLOCK_INTERACTION_RANGE,
                    new AttributeModifier(BLOCK_INTERACTION_RANGE_ID, 16, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );
            builder.add(
                    Attributes.ENTITY_INTERACTION_RANGE,
                    new AttributeModifier(ENTITY_INTERACTION_RANGE_ID, 16, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
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
        lore.add(Component.translatable("item.ethermist." + getBaseWandName(this.getDescriptionId()) + ".desc").withColor(0xAAAAAA));

        if (TYPE == WandTypes.GLIMMERBUG) {
            lore.add(Component.translatable("item.ethermist.glimmerbug_wand.bug_lifespan.desc").withColor(0xAAAAAA));
        }

        lore.add(Component.empty());

        lore.addAll(TIER.get().getModifierString());

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
            } else {

                if (!player.getCooldowns().isOnCooldown(this) && context.getHand() == InteractionHand.MAIN_HAND) {

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

            }
            return InteractionResult.sidedSuccess(level.isClientSide());
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
