package com.gmail.thelilchicken01.ethermist.enchantment;

import com.gmail.thelilchicken01.ethermist.EMRegistries;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Function;

public interface IWandSpellEffect {

    Codec<IWandSpellEffect> CODEC = Codec.lazyInitialized(() ->
            EMRegistries.WAND_SPELL_EFFECT.getRegistry().get()
                    .byNameCodec()
                    .dispatch(IWandSpellEffect::codec, Function.identity())
    );

    MapCodec<? extends IWandSpellEffect> codec();

    default void attributeChanges(WandAttributeState state, int level) {}
    default void addSpecialAttributes(ItemAttributeModifiers.Builder builder) {}
    default boolean doesCreateProjectile(Entity shooter, @Nullable List<Entity> target, @Nullable BlockPos pos, @Nullable Entity clickedEntity, int spellLevel) { return true; }

    default void onHit(Level level, Entity shooter, @Nullable Entity target, @Nullable BlockPos hitPos, WandProjectile shot, int spellLevel) {}
    default void onTick(WandProjectile shot, int tick, List<? extends Entity> target, int spellLevel) {}
    default boolean onShoot(Level level, Player player) {}

}
