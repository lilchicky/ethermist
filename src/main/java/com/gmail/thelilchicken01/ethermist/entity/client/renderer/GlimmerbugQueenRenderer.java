package com.gmail.thelilchicken01.ethermist.entity.client.renderer;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.GlimmerbugQueenModel;
import com.gmail.thelilchicken01.ethermist.entity.client.model.GloomieModel;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugQueenEntity;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GloomieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GlimmerbugQueenRenderer extends MobRenderer<GlimmerbugQueenEntity, GlimmerbugQueenModel<GlimmerbugQueenEntity>> {

    public GlimmerbugQueenRenderer(EntityRendererProvider.Context context) {
        super(context, new GlimmerbugQueenModel<>(context.bakeLayer(GlimmerbugQueenModel.LAYER_LOCATION)), 0.35f);
    }

    @Override
    public void render(GlimmerbugQueenEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(GlimmerbugQueenEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/glimmerbug_queen/glimmerbug_queen.png");
    }

}
