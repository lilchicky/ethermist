package com.gmail.thelilchicken01.ethermist.entity.client.renderer;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.SiherekModel;
import com.gmail.thelilchicken01.ethermist.entity.client.renderer.layers.SiherekGlowLayer;
import com.gmail.thelilchicken01.ethermist.entity.mobs.SiherekEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SiherekRenderer extends MobRenderer<SiherekEntity, SiherekModel<SiherekEntity>> {

    public SiherekRenderer(EntityRendererProvider.Context context) {
        super(context, new SiherekModel<>(context.bakeLayer(SiherekModel.LAYER_LOCATION)), 0.35f);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
        this.addLayer(new SiherekGlowLayer(this));
    }

    @Override
    public void render(SiherekEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SiherekEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/siherek/siherek.png");
    }

}
