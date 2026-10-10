package com.gmail.thelilchicken01.ethermist.entity.client.renderer.layers;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.datagen.tags.EMTags;
import com.gmail.thelilchicken01.ethermist.entity.client.model.SpectralLichModel;
import com.gmail.thelilchicken01.ethermist.entity.mobs.SpectralLichEntity;
import com.gmail.thelilchicken01.ethermist.item.IDyeableWandItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class SpectralLichGlowLayer extends RenderLayer<SpectralLichEntity, SpectralLichModel<SpectralLichEntity>> {
    private static final ResourceLocation GLOW_WHITE = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/spectral_lich/spectral_lich_emmisive_whites.png");
    private static final ResourceLocation GLOW_PURPLE = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/spectral_lich/spectral_lich_emmisive.png");

    public SpectralLichGlowLayer(RenderLayerParent<SpectralLichEntity, SpectralLichModel<SpectralLichEntity>> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, SpectralLichEntity spectralLichEntity, float v, float v1, float v2, float v3, float v4, float v5) {
        ItemStack held = spectralLichEntity.getItemBySlot(EquipmentSlot.MAINHAND);
        float[] wandColor = (!held.isEmpty() && held.getItem() instanceof IDyeableWandItem wand) ? wand.getTrailColor(held) : new float[] {1.0f, 1.0f, 1.0f};

        int finalColor =
                (0xFF << 24)
                | ((int)(wandColor[0] * 255.0F) << 16)
                | ((int)(wandColor[1] * 255.0F) << 8)
                | ((int)(wandColor[2] * 255.0F));

        VertexConsumer vertex = multiBufferSource.getBuffer(
                RenderType.eyes((!held.isEmpty() && held.getItem() instanceof IDyeableWandItem) ? GLOW_WHITE : GLOW_PURPLE)
        );

        getParentModel().renderToBuffer(
                poseStack,
                vertex,
                LightTexture.FULL_BRIGHT,
                OverlayTexture.NO_OVERLAY,
                finalColor
        );
    }
}
