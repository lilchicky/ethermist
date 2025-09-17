package com.gmail.thelilchicken01.ethermist.enchantment.spell_enchants;

import com.gmail.thelilchicken01.ethermist.EMAttributes;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandSpellEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KineticRushEnchant implements IWandSpellEffect {

    public static final MapCodec<KineticRushEnchant> CODEC = MapCodec.unit(KineticRushEnchant::new);

    @Override
    public MapCodec<? extends IWandSpellEffect> codec() {
        return CODEC;
    }

    @Override
    public boolean doesCreateProjectile(Entity shooter, @Nullable List<Entity> target, @Nullable BlockPos pos, @Nullable Entity clickedEntity, int spellLevel) {
        return false;
    }

    @Override
    public boolean onShoot(Level level, Player player) {

        if (!level.isClientSide()) {
            RandomSource random = RandomSource.create();

            double power = WandUtil.getAttribute(player, EMAttributes.WAND_DAMAGE, WandItem.BASE_WAND_DAMAGE_ID) / 2.0;
            double inaccuracy = 1 - WandUtil.getAttribute(player, EMAttributes.ACCURACY, WandItem.ACCURACY_ID);

            Vec3 launch = player.getViewVector(1.0f);

            double xOff = (random.nextDouble() * 2 - 1) * inaccuracy;
            double yOff = (random.nextDouble() * 2 - 1) * inaccuracy;
            double zOff = (random.nextDouble() * 2 - 1) * inaccuracy;

            Vec3 offsetLaunch = new Vec3(
                    launch.x + xOff,
                    launch.y + yOff,
                    launch.z + zOff
            ).normalize().scale(power);

            player.setDeltaMovement(offsetLaunch);
            player.hurtMarked = true;
        }

        return true;

    }
}
