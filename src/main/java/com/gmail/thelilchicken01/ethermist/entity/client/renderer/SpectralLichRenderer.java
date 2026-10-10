package com.gmail.thelilchicken01.ethermist.entity.client.renderer;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.SpectralLichModel;
import com.gmail.thelilchicken01.ethermist.entity.client.renderer.layers.SpectralLichGlowLayer;
import com.gmail.thelilchicken01.ethermist.entity.mobs.SpectralLichEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SpectralLichRenderer extends MobRenderer<SpectralLichEntity, SpectralLichModel<SpectralLichEntity>> {

    public SpectralLichRenderer(EntityRendererProvider.Context context) {
        super(context, new SpectralLichModel<>(context.bakeLayer(SpectralLichModel.LAYER_LOCATION)), 0.35f);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
        this.addLayer(new SpectralLichGlowLayer(this));
    }

    @Override
    public void render(SpectralLichEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SpectralLichEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/spectral_lich/spectral_lich.png");
    }

}
