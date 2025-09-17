package com.gmail.thelilchicken01.ethermist.item.wands;

import com.gmail.thelilchicken01.ethermist.EMConfig;
import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.component.EMDataComponents;
import com.gmail.thelilchicken01.ethermist.component.WandHandleEntry;
import com.gmail.thelilchicken01.ethermist.component.WandOrbEntry;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.enchantment.*;
import com.gmail.thelilchicken01.ethermist.item.IDyeableWandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects.EMWandOrbs;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectileHandler;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.WandHandle;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_orb_effects.WandOrb;
import com.gmail.thelilchicken01.ethermist.worldgen.portal.EMPortalShape;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
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
import java.util.function.Predicate;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WandItem extends Item implements IDyeableWandItem {

    private final DeferredHolder<WandOrb, WandOrb> WAND_ORB;

    public static final ResourceLocation COOLDOWN_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "cooldown");
    public static final ResourceLocation BASE_WAND_DAMAGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "wand_damage");
    public static final ResourceLocation PROJECTILE_SPEED_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "projectile_speed");
    public static final ResourceLocation WAND_KNOCKBACK_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "knockback");
    public static final ResourceLocation LIFESPAN_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "lifespan");
    public static final ResourceLocation ACCURACY_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "accuracy");
    public static final ResourceLocation BLOCK_INTERACTION_RANGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "block_interaction_range");
    public static final ResourceLocation ENTITY_INTERACTION_RANGE_ID = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "entity_interaction_range");

    public WandItem(DeferredHolder<WandOrb, WandOrb> orb, DeferredHolder<WandHandle, WandHandle> handle) {
        super(new Item.Properties().stacksTo(1)
                .component(DataComponents.DYED_COLOR, new DyedItemColor(Ethermist.WAND_COLOR, false))
                .component(EMDataComponents.WAND_HANDLE, new WandHandleEntry(handle.getId().toString()))
                .component(EMDataComponents.WAND_ORB, new WandOrbEntry(orb.getId().toString()))
                .durability(1));
        this.WAND_ORB = orb;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        // cast as int twice to the math makes sense. I.E. Glass Wand has, by default,
        // 3 durability, but its technically 3.84 durability, so the diamond orb makes it
        // have 19 instead of the expected 15 (3.84x5 vs 3x5). Implemented mostly so durability
        // is a bit more intuitive.
        return Math.max(
                (int) ((int)(128 * WAND_ORB.get().getDurabilityMult()) * getHandle(stack).getDurabilityMult()),
                1
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack wand = player.getItemInHand(usedHand);

        if (!player.getCooldowns().isOnCooldown(this) && usedHand == InteractionHand.MAIN_HAND) {

            WandProjectileHandler.processShot(level, player, wand, this, null, null);

            level.playSound(player,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    WAND_ORB.get().getShootSound(),
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
        return (int)(WAND_ORB.get().getEnchantability() * getHandle(stack).getEnchantabilityMult());
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairItem) {
        return stack.isDamaged() && (WAND_ORB.get().getRepairItem().get().test(repairItem) || getHandle(stack).getRepairItem().get().test(repairItem));
    }

    public WandOrb getOrb() {
        return WAND_ORB.get();
    }

    public SoundEvent getShootSound() {
        return WAND_ORB.get().getShootSound();
    }

    public float[] getTrailColor(ItemStack stack) {
        int color = stack.get(DataComponents.DYED_COLOR).rgb();
        if (color != Ethermist.WAND_COLOR) {
            float r = (color >> 16 & 255) / 255.0f;
            float g = (color >> 8 & 255) / 255.0f;
            float b = (color & 255) / 255.0f;
            return new float[]{r, g, b};
        } else {
            return WAND_ORB.get().getTrailColor();
        }
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {

        var builder = ItemAttributeModifiers.builder();

        // Get base attributes based on wand type (orb)
        WandAttributeState currentAttributeState = new WandAttributeState().seed(
                WAND_ORB.get().getCooldown(),
                WAND_ORB.get().getSpellDamage(),
                WAND_ORB.get().getLifespanSeconds(),
                WAND_ORB.get().getProjectileSpeed(),
                WAND_ORB.get().getKnockback(),
                WAND_ORB.get().getInaccuracy()
        );

        // Apply tier (orb) modifiers to default attributes
        getHandle(stack).apply(currentAttributeState);

        // Order here is implemented base -> augment -> spell, for priority of hard attribute
        // adjustments (such as Focus Augment overriding default accuracy enchantments).
        // This prevents something like damage being set to 1 for balance, then at a later point
        // being changed by a base enchantment to increase damage.

        // Apply base enchantment modifiers (damage, etc.)
        EnchantmentHelper.runIterationOnItem(stack, (enchant, level) -> {

            IWandBaseEffect base = enchant.value().effects().get(EMEnchantComponents.WAND_BASE_EFFECT.get());

            if (base != null) {
                base.attributeChanges(currentAttributeState, level);
                base.addSpecialAttributes(builder);
            }

        });

        // Augment modifiers
        EnchantmentHelper.runIterationOnItem(stack, (enchant, level) -> {

            IWandAugmentEffect augment = enchant.value().effects().get(EMEnchantComponents.WAND_AUGMENT_EFFECT.get());

            if (augment != null) {
                augment.attributeChanges(currentAttributeState, level);
                augment.addSpecialAttributes(builder);
            }

        });

        // Spell modifiers
        EnchantmentHelper.runIterationOnItem(stack, (enchant, level) -> {

            IWandSpellEffect spell = enchant.value().effects().get(EMEnchantComponents.WAND_SPELL_EFFECT.get());

            if (spell != null) {
                spell.attributeChanges(currentAttributeState, level);
                spell.addSpecialAttributes(builder);
            }

        });

        // Clamp final attribute values.
        // This is to prevent numbers that screw up projectile math, like having 0 damage projectiles or
        // negative lifespans.
        currentAttributeState.clamp();

        // Add the final attribute state to this itemstack
        currentAttributeState.addToBuilder(builder, EquipmentSlotGroup.MAINHAND);

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
        lore.add(Component.translatable("item.ethermist." + BuiltInRegistries.ITEM.getKey(this).getPath() + ".desc").withColor(0xAAAAAA));

        if (WAND_ORB.get() == EMWandOrbs.GLIMMERBUG.get()) {
            lore.add(Component.translatable("item.ethermist.glimmerbug_wand.bug_lifespan.desc").withColor(0xAAAAAA));
        }

        lore.add(Component.empty());

        lore.addAll(getHandle(stack).getModifierString());

        if (stack.isEnchanted()) {
            lore.add(Component.empty());
        }

        super.appendHoverText(stack, context, lore, tooltipFlag);
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

            if (!player.getCooldowns().isOnCooldown(this) && context.getHand() == InteractionHand.MAIN_HAND) {

                WandProjectileHandler.processShot(level, player, wand, this, context.getClickedPos(), null);

                level.playSound(player,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        WAND_ORB.get().getShootSound(),
                        SoundSource.PLAYERS,
                        1.0f,
                        level.getRandom().nextFloat() * 0.4f + 0.8f);

                player.awardStat(Stats.ITEM_USED.get(this));

                wand.hurtAndBreak(1, player, wand.getEquipmentSlot());

            }

            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return InteractionResult.FAIL;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {

        ItemStack wand = player.getItemInHand(usedHand);

        Level level = player.level();

        if (!player.getCooldowns().isOnCooldown(this)) {

            WandProjectileHandler.processShot(level, player, wand, this, null, interactionTarget);

            level.playSound(player,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    WAND_ORB.get().getShootSound(),
                    SoundSource.PLAYERS,
                    1.0f,
                    level.getRandom().nextFloat() * 0.4f + 0.8f);

            player.awardStat(Stats.ITEM_USED.get(this));

            wand.hurtAndBreak(1, player, wand.getEquipmentSlot());

        }

        return InteractionResult.sidedSuccess(level.isClientSide());

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
    public Component getName(ItemStack stack) {
        return Component.translatable("item.ethermist.wand_handle." + getHandle(stack).getDescription())
                .append(Component.literal(" "))
                .append(Component.translatable(this.getDescriptionId(stack)));
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

}
