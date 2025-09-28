package com.gmail.thelilchicken01.ethermist.enchantment.augment_enchants;

import com.gmail.thelilchicken01.ethermist.EMAttributes;
import com.gmail.thelilchicken01.ethermist.enchantment.IWandAugmentEffect;
import com.gmail.thelilchicken01.ethermist.item.wands.WandAttributeState;
import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import com.gmail.thelilchicken01.ethermist.item.wands.WandUtil;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandProjectile;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotItem;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.gmail.thelilchicken01.ethermist.item.wands.WandItem.BLOCK_INTERACTION_RANGE_ID;
import static com.gmail.thelilchicken01.ethermist.item.wands.WandItem.ENTITY_INTERACTION_RANGE_ID;
import static com.gmail.thelilchicken01.ethermist.item.wands.wand_projectile.WandShotHandler.setShotInfo;

public record AugmentMeteorEnchant() implements IWandAugmentEffect {

    public static final MapCodec<AugmentMeteorEnchant> CODEC = MapCodec.unit(AugmentMeteorEnchant::new);

    @Override
    public MapCodec<? extends IWandAugmentEffect> codec() {
        return CODEC;
    }

    @Override
    public void attributeChanges(WandAttributeState state, int level) {

        state.damage *= 3.0;
        state.lifespanSeconds *= 5.0;
        state.inaccuracyPercent *= 0.1; // 90% more accurate

    }

    @Override
    public void addSpecialAttributes(ItemAttributeModifiers.Builder builder) {

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

    @Override
    public boolean doesCreateProjectile(Entity shooter, @Nullable List<Entity> target, @Nullable BlockPos pos, @Nullable Entity clickedEntity, int spellLevel) {
        return pos != null || clickedEntity != null;
    }

    @Override
    public boolean shoot(
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
            List<Class<?>> targetType,
            @Nullable BlockPos pos,
            @Nullable Entity clickedEntity,
            List<WandProjectile.SpellEntry> savedSpells,
            int spellLevel) {

        if (pos != null) {

            WandProjectile shot = shotItem.createProjectile(level, shotStack, player, target);

            Vec3 currentPos = player.getEyePosition().add(0.0, 4.0, 0.0);
            Vec3 targetPos = new Vec3(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
            Vec3 targetVector = targetPos.subtract(currentPos).normalize();

            shot.shoot(
                    targetVector.x,
                    targetVector.y + 0.1,
                    targetVector.z,
                    pSpeed,
                    (float)(100 - (WandUtil.getAttribute(player, EMAttributes.ACCURACY)*100)));
            shot.setPos(shot.getX(),
                    shot.getY() + 4.0,
                    shot.getZ());

            level.addFreshEntity(setShotInfo(player, shot, wand, wandItem, lifespan, isHoming, targetType, savedSpells));

            return true;

        }
        else if (clickedEntity != null) {

            WandProjectile shot = shotItem.createProjectile(level, shotStack, player, List.of(clickedEntity));

            Vec3 currentPos = player.getEyePosition().add(0.0, 4.0, 0.0);
            Vec3 targetPos = new Vec3(clickedEntity.getX(), clickedEntity.getY(), clickedEntity.getZ());
            Vec3 targetVector = targetPos.subtract(currentPos).normalize();

            shot.shoot(
                    targetVector.x,
                    targetVector.y + 0.1,
                    targetVector.z,
                    pSpeed,
                    (float)(100 - (WandUtil.getAttribute(player, EMAttributes.ACCURACY)*100)));

            shot.setPos(shot.getX(),
                    shot.getY() + 4.0,
                    shot.getZ());

            level.addFreshEntity(setShotInfo(player, shot, wand, wandItem, lifespan, isHoming, targetType, savedSpells));

            return true;

        }

        return false;

    }
}
