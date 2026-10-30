package com.gmail.thelilchicken01.ethermist.datagen.structure;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.structure.pools.ForgemasterCastlePools;
import com.gmail.thelilchicken01.ethermist.datagen.structure.pools.GlimmerbugCavePools;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.entity.EMEntityTypes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.PillagerOutpostPools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EMStructures {

    public static void bootstrap(BootstrapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

        // Forgemaster Castle
        context.register(
                EMStructureConstants.FORGEMASTER_CASTLE.structureKey(),
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(biomes.getOrThrow(EMTags.Biomes.HAS_FORGEMASTER_CASTLE))
                                .spawnOverrides(
                                        Map.of(
                                                MobCategory.MONSTER,
                                                new StructureSpawnOverride(
                                                        StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                                        WeightedRandomList.create(
                                                                new MobSpawnSettings.SpawnerData(EMEntityTypes.RUNIC_SKELETON.get(), 1, 1, 1)
                                                        )
                                                )
                                        )
                                )
                                .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                                .build(),
                        pools.getOrThrow(ForgemasterCastlePools.START),
                        Optional.empty(),
                        9,
                        ConstantHeight.of(VerticalAnchor.absolute(0)),
                        true,
                        Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
                        96,
                        List.of(),
                        DimensionPadding.ZERO,
                        LiquidSettings.APPLY_WATERLOGGING
                )
        );

        // Glimmerbug Cave
        context.register(
                EMStructureConstants.GLIMMERBUG_CAVE.structureKey(),
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(biomes.getOrThrow(EMTags.Biomes.HAS_GLIMMERBUG_CAVE))
                                .spawnOverrides(
                                        Map.of(
                                                MobCategory.CREATURE,
                                                new StructureSpawnOverride(
                                                        StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                                        WeightedRandomList.create(
                                                                new MobSpawnSettings.SpawnerData(EMEntityTypes.GLIMMERBUG.get(), 1, 3, 5)
                                                        )
                                                )
                                        )
                                )
                                .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                                .terrainAdapation(TerrainAdjustment.NONE)
                                .build(),
                        pools.getOrThrow(GlimmerbugCavePools.START),
                        Optional.empty(),
                        6,
                        ConstantHeight.of(VerticalAnchor.absolute(-32)),
                        true,
                        Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
                        96,
                        List.of(),
                        DimensionPadding.ZERO,
                        LiquidSettings.APPLY_WATERLOGGING
                )
        );
    }

}
