package com.gmail.thelilchicken01.ethermist.entity.client.renderer;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.GlimmerbugModel;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GlimmerbugRenderer extends MobRenderer<GlimmerbugEntity, GlimmerbugModel<GlimmerbugEntity>> {

    public GlimmerbugRenderer(EntityRendererProvider.Context context) {
        super(context, new GlimmerbugModel<>(context.bakeLayer(GlimmerbugModel.LAYER_LOCATION)), 0.15f);
    }

    @Override
    public void render(GlimmerbugEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(GlimmerbugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/glimmerbug/glimmerbug.png");
    }

}
