package com.gmail.thelilchicken01.ethermist.entity.client.model;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.animation.GlimmerbugQueenAnimations;
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

public class GlimmerbugQueenModel<T extends GlimmerbugQueenEntity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "glimmerbug_queen"), "main");

    private final ModelPart body;
    private final ModelPart head;

    public GlimmerbugQueenModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));

        PartDefinition abdomen = body.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition backlegsR = abdomen.addOrReplaceChild("backlegsR", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.0F, 1.5F));

        PartDefinition R3 = backlegsR.addOrReplaceChild("R3", CubeListBuilder.create().texOffs(22, 4).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition R4 = backlegsR.addOrReplaceChild("R4", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition backlegsL = abdomen.addOrReplaceChild("backlegsL", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 1.5F));

        PartDefinition L3 = backlegsL.addOrReplaceChild("L3", CubeListBuilder.create().texOffs(8, 24).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition L4 = backlegsL.addOrReplaceChild("L4", CubeListBuilder.create().texOffs(4, 24).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition thorax = body.addOrReplaceChild("thorax", CubeListBuilder.create().texOffs(20, 15).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition frontlegsR = thorax.addOrReplaceChild("frontlegsR", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, -2.5F));

        PartDefinition R1 = frontlegsR.addOrReplaceChild("R1", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition R2 = frontlegsR.addOrReplaceChild("R2", CubeListBuilder.create().texOffs(20, 22).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition frontlegsL = thorax.addOrReplaceChild("frontlegsL", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, -2.5F));

        PartDefinition L1 = frontlegsL.addOrReplaceChild("L1", CubeListBuilder.create().texOffs(16, 24).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition L2 = frontlegsL.addOrReplaceChild("L2", CubeListBuilder.create().texOffs(12, 24).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 15).addBox(-2.5F, -2.5F, -5.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition antennae = head.addOrReplaceChild("antennae", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -3.0F));

        PartDefinition antennaL = antennae.addOrReplaceChild("antennaL", CubeListBuilder.create().texOffs(15, 11).addBox(0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

        PartDefinition antennaR = antennae.addOrReplaceChild("antennaR", CubeListBuilder.create().texOffs(15, 11).addBox(0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

        PartDefinition mandibles = head.addOrReplaceChild("mandibles", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.5F, -4.0F));

        PartDefinition mandibleR = mandibles.addOrReplaceChild("mandibleR", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition mandibleL = mandibles.addOrReplaceChild("mandibleL", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(GlimmerbugQueenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animate(entity.idleStateBase, GlimmerbugQueenAnimations.GLIMMERBUG_QUEEN_IDLE_0, ageInTicks, 1f);
        this.animate(entity.idleStateWiggle, GlimmerbugQueenAnimations.GLIMMERBUG_QUEEN_IDLE_1, ageInTicks, 1f);
        this.animate(entity.idleStateMandibles, GlimmerbugQueenAnimations.GLIMMERBUG_QUEEN_IDLE_2, ageInTicks, 1f);
        this.animate(entity.attackState, GlimmerbugQueenAnimations.GLIMMERBUG_QUEEN_ATTACK, ageInTicks, 1f);

    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
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
