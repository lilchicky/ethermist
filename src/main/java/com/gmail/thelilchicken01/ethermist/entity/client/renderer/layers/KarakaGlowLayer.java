package com.gmail.thelilchicken01.ethermist.entity.client.renderer.layers;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.KarakaModel;
import com.gmail.thelilchicken01.ethermist.entity.mobs.KarakaEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class KarakaGlowLayer extends RenderLayer<KarakaEntity, KarakaModel<KarakaEntity>> {
    private static final ResourceLocation KARAKA_GLOW = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/karaka/karaka_glow.png");

    public KarakaGlowLayer(RenderLayerParent<KarakaEntity, KarakaModel<KarakaEntity>> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, KarakaEntity spectralLichEntity, float v, float v1, float v2, float v3, float v4, float v5) {
        VertexConsumer vertex = multiBufferSource.getBuffer(
                RenderType.eyes(KARAKA_GLOW)
        );

        getParentModel().renderToBuffer(
                poseStack,
                vertex,
                LightTexture.FULL_BRIGHT,
                OverlayTexture.NO_OVERLAY,
                0xFFFFFF
        );
    }
}
