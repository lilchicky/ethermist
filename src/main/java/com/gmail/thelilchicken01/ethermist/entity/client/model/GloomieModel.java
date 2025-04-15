package com.gmail.thelilchicken01.ethermist.entity.client.model;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.animation.GloomieAnimations;
import com.gmail.thelilchicken01.ethermist.entity.mobs.GloomieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class GloomieModel<T extends GloomieEntity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "gloomie"), "main");

    private final ModelPart wholeguy;
    private final ModelPart mushrooms;

    public GloomieModel(ModelPart root) {
        this.wholeguy = root.getChild("wholeguy");
        this.mushrooms = this.wholeguy.getChild("bodymass").getChild("mushytop").getChild("mushrooms");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition wholeguy = partdefinition.addOrReplaceChild("wholeguy", CubeListBuilder.create(), PartPose.offset(0.0F, 22.1667F, 0.0F));

        PartDefinition bodymass = wholeguy.addOrReplaceChild("bodymass", CubeListBuilder.create(), PartPose.offset(0.0F, -3.1667F, 0.0F));

        PartDefinition mushytop = bodymass.addOrReplaceChild("mushytop", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, -4.1667F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -2.1667F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.8333F, 0.0F));

        PartDefinition mushrooms = mushytop.addOrReplaceChild("mushrooms", CubeListBuilder.create().texOffs(34, 14).addBox(1.0F, -2.0F, -2.5F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(24, 25).addBox(-1.5F, -3.0F, -2.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition cube_r1 = mushrooms.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 22).addBox(-0.5F, -3.0F, -2.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r2 = mushrooms.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(34, 16).addBox(-2.0F, -2.0F, -0.5F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition body = bodymass.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legs = wholeguy.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 1.8333F, 0.0F));

        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.25F, -2.0F, 0.0F));

        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.25F, -2.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(GloomieEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.idleState, GloomieAnimations.GLOOMIE_IDLE, ageInTicks, 1f);
        this.animate(entity.hideState, GloomieAnimations.GLOOMIE_HIDE, ageInTicks, 1f);
        this.animate(entity.swimState, GloomieAnimations.GLOOMIE_SWIM, ageInTicks, 1f);

        this.mushrooms.visible = !entity.isSheared();

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        wholeguy.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return wholeguy;
    }
}
