package com.gmail.thelilchicken01.ethermist.entity.client.renderer;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.ForgemasterModel;
import com.gmail.thelilchicken01.ethermist.entity.client.model.RunicSkeletonModel;
import com.gmail.thelilchicken01.ethermist.entity.mobs.ForgemasterEntity;
import com.gmail.thelilchicken01.ethermist.entity.mobs.RunicSkeletonEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RunicSkeletonRenderer extends MobRenderer<RunicSkeletonEntity, RunicSkeletonModel<RunicSkeletonEntity>> {

    public RunicSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new RunicSkeletonModel<>(context.bakeLayer(RunicSkeletonModel.LAYER_LOCATION)), 0.35f);
    }

    @Override
    public void render(RunicSkeletonEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(RunicSkeletonEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/runic_skeleton/runic_skeleton.png");
    }

}
