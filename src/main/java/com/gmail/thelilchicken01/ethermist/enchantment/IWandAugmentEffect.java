package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.EMRegistries;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Function;

public interface IWandAugmentEffect {

    Codec<IWandAugmentEffect> CODEC = Codec.lazyInitialized(() ->
            EMRegistries.WAND_AUGMENT_EFFECT.getRegistry().get()
                    .byNameCodec()
                    .dispatch(IWandAugmentEffect::codec, Function.identity())
    );

    MapCodec<? extends IWandAugmentEffect> codec();

    default void attributeChanges(WandAttributeState state, int level) {}
    default void addSpecialAttributes(ItemAttributeModifiers.Builder builder) {}
    default boolean doesCreateProjectile(Entity shooter, @Nullable List<Entity> target, @Nullable BlockPos pos, @Nullable Entity clickedEntity, int spellLevel) { return true; }

    default boolean doesProjectileHome() { return false; }

    // Not required - ProjectileHandler will shoot a simple, straight projectile if not modified.
    default boolean shoot(
            Level level,
            Player player,
            @Nullable List<? extends Entity> target,
            float pSpeed,
            double lifespan,
            ItemStack shotStack,
            WandItem wand,
            WandShotItem shotItem,
            ItemStack wandItem,
            boolean isHoming,
            List<TagKey<EntityType<?>>> targetType,
            @Nullable BlockPos pos,
            @Nullable Entity clickedEntity,
            List<WandProjectile.SpellEntry> savedSpells,
            int spellLevel) {
        return false;
    }

}
