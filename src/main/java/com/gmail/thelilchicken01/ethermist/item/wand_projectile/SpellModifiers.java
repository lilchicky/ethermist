package com.gmail.thelilchicken01.ethermist.item.wand_projectile;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

public class SpellModifiers {

    public enum TargetType {
        MONSTERS(Monster.class),
        ANIMALS(Animal.class),
        PLAYERS(Player.class),
        ALL(null);

        private final Class<? extends Entity> targetClass;

        TargetType(Class<? extends Entity> targetClass) {
            this.targetClass = targetClass;
        }

        public Class<? extends Entity> getTargetClass() {
            return this.targetClass;
        }
    }

    public enum SpellType {
        GENERIC,
        FIREBALL,
        CHAOS_MAGIC,
        THUNDERSTRIKE,
        VOLATILE_ENERGY,
        SEISMIC_SURGE
    }

}
