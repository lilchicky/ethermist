package com.gmail.thelilchicken01.ethermist.entity.client.renderer;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.model.KarakaModel;
import com.gmail.thelilchicken01.ethermist.entity.client.renderer.layers.KarakaGlowLayer;
import com.gmail.thelilchicken01.ethermist.entity.mobs.KarakaEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KarakaRenderer extends MobRenderer<KarakaEntity, KarakaModel<KarakaEntity>> {

    public KarakaRenderer(EntityRendererProvider.Context context) {
        super(context, new KarakaModel<>(context.bakeLayer(KarakaModel.LAYER_LOCATION)), 0.35f);
        this.addLayer(new KarakaGlowLayer(this));
    }

    @Override
    public void render(KarakaEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()) {
            poseStack.scale(0.35f, 0.35f, 0.35f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(KarakaEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/entity/karaka/karaka.png");
    }

}
