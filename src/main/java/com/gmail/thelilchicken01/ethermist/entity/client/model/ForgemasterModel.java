package com.gmail.thelilchicken01.ethermist.entity.client.model;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.animation.ForgemasterAnimations;
import com.gmail.thelilchicken01.ethermist.entity.mobs.ForgemasterEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ForgemasterModel<T extends ForgemasterEntity> extends HierarchicalModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "forgemaster"), "main");
	private final ModelPart body;
	private final ModelPart head;

	public ForgemasterModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = this.body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 43).addBox(-11.0F, -25.0F, -6.5F, 22.0F, 25.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(32, 25).addBox(-12.0F, -20.0F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 21).addBox(11.0F, -20.0F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 80).addBox(-9.0F, -27.0F, -5.5F, 18.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(47, 28).addBox(-5.0F, -28.0F, -4.5F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(68, 43).addBox(0.0F, -8.0F, -4.0F, 8.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -19.0F, -0.5F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -4.0F, 8.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -19.0F, -0.5F));

		PartDefinition hammer = rightArm.addOrReplaceChild("hammer", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -16.5F, 4.0F, 4.0F, 39.0F, new CubeDeformation(0.0F))
		.texOffs(0, 92).addBox(-4.0F, -10.0F, -24.5F, 8.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 20.0F, -0.5F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(47, 0).addBox(-8.0F, -13.3333F, -5.75F, 16.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(32, 14).addBox(-7.0F, -5.3333F, -6.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 7).addBox(-4.0F, -5.3333F, -6.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-1.0F, -5.3333F, -6.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(2.0F, -5.3333F, -6.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(5.0F, -5.3333F, -6.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.6667F, -0.75F));

		PartDefinition pelvisandlegs = body.addOrReplaceChild("pelvisandlegs", CubeListBuilder.create().texOffs(86, 28).addBox(-3.0F, 0.0F, -4.5F, 6.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(32, 33).addBox(3.0F, 2.0F, -0.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 29).addBox(-4.0F, 2.0F, -0.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition rightLeg = pelvisandlegs.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(88, 81).addBox(-8.0F, -2.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 3.0F, 0.5F));

		PartDefinition leftLeg = pelvisandlegs.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(56, 81).addBox(0.0F, -2.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(ForgemasterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animate(entity.attackState, ForgemasterAnimations.FORGEMASTER_ATTACK, ageInTicks, 1f);
		this.animate(entity.idleState, ForgemasterAnimations.FORGEMASTER_IDLE, ageInTicks, 1f);
		this.animate(entity.walkState, ForgemasterAnimations.FORGEMASTER_WALK, ageInTicks, 1f);
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