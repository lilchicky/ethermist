package com.gmail.thelilchicken01.ethermist.entity.client.renderer;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.GloomieModel;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GloomieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GloomieRenderer extends MobRenderer<GloomieEntity, GloomieModel<GloomieEntity>> {

    public GloomieRenderer(EntityRendererProvider.Context context) {
        super(context, new GloomieModel<>(context.bakeLayer(GloomieModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public void render(GloomieEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(GloomieEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/gloomie/gloomie.png");
    }

}
