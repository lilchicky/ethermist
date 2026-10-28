package com.gmail.thelilchicken01.ethermist.worldgen.biome;

import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DefaultEthermistSpawnSettings {

    public static final MobSpawnSettings.SpawnerData DEFAULT_GLOW_SQUID = new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 10, 4, 6);

    private final MobSpawnSettings.Builder BUILDER;

    public DefaultEthermistSpawnSettings(BootstrapContext<Biome> context) {
        this.BUILDER = new MobSpawnSettings.Builder();
    }

    public MobSpawnSettings.Builder builder() {
        return this.BUILDER;
    }

    public DefaultEthermistSpawnSettings defaultSpawns(boolean hasKaraka) {
        this.defaultAmbient().defaultCreatures(hasKaraka).defaultMonsters();
        return this;
    }

    public DefaultEthermistSpawnSettings defaultAmbient() {
        this.BUILDER.addSpawn(
                MobCategory.AMBIENT,
                new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8)
        );

        return this;
    }

    public DefaultEthermistSpawnSettings defaultCreatures(boolean hasKaraka) {
        this.BUILDER.addSpawn(
                MobCategory.CREATURE,
                new MobSpawnSettings.SpawnerData(EMEntityTypes.GLIMMERBUG.get(), 10, 2, 4)
        ).addSpawn(
                MobCategory.UNDERGROUND_WATER_CREATURE,
                DEFAULT_GLOW_SQUID
        );

        if (hasKaraka) {
            this.BUILDER.addSpawn(
                    MobCategory.CREATURE,
                    new MobSpawnSettings.SpawnerData(EMEntityTypes.KARAKA.get(), 10, 1, 3)
            );
        }

        return this;
    }

    public DefaultEthermistSpawnSettings defaultMonsters() {
        this.BUILDER.addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(EMEntityTypes.RUNIC_SKELETON.get(), 100, 2, 4)
        ).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(EMEntityTypes.SPECTRAL_LICH.get(), 45, 1, 2)
        ).addSpawn(
                MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(EntityType.WITCH, 20, 1, 1)
        );

        return this;
    }

    public DefaultEthermistSpawnSettings defaultWater() {
        this.BUILDER.addSpawn(
                MobCategory.CREATURE,
                new MobSpawnSettings.SpawnerData(EMEntityTypes.GLOOMIE.get(), 100, 2, 4)
        );

        return this;
    }

}
