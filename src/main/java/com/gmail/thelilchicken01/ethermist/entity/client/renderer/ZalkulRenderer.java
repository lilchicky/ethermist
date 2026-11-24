package com.gmail.thelilchicken01.ethermist.entity.client.renderer;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.ZalkulModel;
import com.gmail.thelilchicken01.ethermist.entity.mobs.ZalkulEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ZalkulRenderer extends MobRenderer<ZalkulEntity, ZalkulModel<ZalkulEntity>> {

    public ZalkulRenderer(EntityRendererProvider.Context context) {
        super(context, new ZalkulModel<>(context.bakeLayer(ZalkulModel.LAYER_LOCATION)), 0.35f);
    }

    @Override
    public void render(ZalkulEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ZalkulEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/zalkul/zalkul.png");
    }

}
