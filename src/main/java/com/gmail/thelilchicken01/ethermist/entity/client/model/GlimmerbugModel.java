package com.gmail.thelilchicken01.ethermist.entity.client.model;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.animation.GlimmerbugQueenAnimations;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugEntity;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GlimmerbugQueenEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GlimmerbugModel<T extends GlimmerbugEntity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glimmerbug"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public GlimmerbugModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -1.0F, 2.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 21.0F, -4.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(2.0F, 3.0F, 6.0F));

        PartDefinition right_legs = legs.addOrReplaceChild("right_legs", CubeListBuilder.create().texOffs(4, 16).addBox(-1.0F, -2.0F, -3.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 13).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 13).addBox(-1.0F, -2.0F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.0F, 0.0F));

        PartDefinition left_legs = legs.addOrReplaceChild("left_legs", CubeListBuilder.create().texOffs(8, 16).addBox(-2.0F, -2.0F, -3.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 13).addBox(-2.0F, -2.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 9).addBox(-2.0F, -2.0F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.25F, 2.25F));

        PartDefinition antennae = head.addOrReplaceChild("antennae", CubeListBuilder.create(), PartPose.offset(2.0F, -1.5F, -2.0F));

        PartDefinition left_antenna_r1 = antennae.addOrReplaceChild("left_antenna_r1", CubeListBuilder.create().texOffs(10, 9).addBox(0.0F, -2.0F, -1.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.2F, 0.7F, 0.0F, 0.0F, 0.1309F));

        PartDefinition right_antenna_r1 = antennae.addOrReplaceChild("right_antenna_r1", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -2.0F, -1.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.2F, 0.7F, 0.0F, 0.0F, -0.1309F));

        PartDefinition mandibles = head.addOrReplaceChild("mandibles", CubeListBuilder.create(), PartPose.offset(3.0F, 0.85F, -1.85F));

        PartDefinition left_mandible_r1 = mandibles.addOrReplaceChild("left_mandible_r1", CubeListBuilder.create().texOffs(12, 16).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -1.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

        PartDefinition right_mandible_r1 = mandibles.addOrReplaceChild("right_mandible_r1", CubeListBuilder.create().texOffs(14, 12).addBox(0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7F, -1.0F, 0.0F, 0.0F, 0.1309F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(GlimmerbugEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -15f, 15f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }

}
