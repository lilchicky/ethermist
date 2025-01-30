package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

public class SpellModifiers {

    public enum TargetType {
        MONSTERS(Monster.class),
        ANIMALS(Animal.class),
        PLAYERS(Player.class),
        ALL(LivingEntity.class);

        private final Class<? extends LivingEntity> targetClass;

        TargetType(Class<? extends LivingEntity> targetClass) {
            this.targetClass = targetClass;
        }

        public Class<? extends LivingEntity> getTargetClass() {
            return this.targetClass;
        }
    }

    public enum SpellType {
        GENERIC,
        FIREBALL,
        CHAOS_MAGIC,
        THUNDERSTRIKE,
        VOLATILE_ENERGY
    }

}
