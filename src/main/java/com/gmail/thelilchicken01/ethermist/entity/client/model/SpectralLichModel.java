package com.gmail.thelilchicken01.ethermist.entity.client.model;// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.animation.SpectralLichAnimations;
import com.gmail.thelilchicken01.ethermist.entity.mobs.SpectralLichEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

/**
 * Made with Blockbench 5.2.2
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author Hexodiax
 */
public class SpectralLichModel<T extends SpectralLichEntity> extends HierarchicalModel<T> implements ArmedModel {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "spectral_lich"), "main");
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart robe;
	private final ModelPart robe2;
	private final ModelPart robe3;
	private final ModelPart leg_left;
	private final ModelPart leg_right;
	private final ModelPart arms;
	private final ModelPart arms3;
	private final ModelPart arms2;
	private final ModelPart head;

	public SpectralLichModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.robe = this.body.getChild("robe");
		this.robe2 = this.robe.getChild("robe2");
		this.robe3 = this.robe2.getChild("robe3");
		this.leg_left = this.body.getChild("leg_left");
		this.leg_right = this.body.getChild("leg_right");
		this.arms = this.body.getChild("arms");
		this.arms3 = this.arms.getChild("arms3");
		this.arms2 = this.arms.getChild("arms2");
		this.head = this.body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(32, 6).addBox(1.0F, -10.5F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(22, 18).addBox(0.0F, -4.5F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(12, 16).addBox(0.0F, -7.5F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(0.0F, -10.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(12, 19).addBox(-2.0F, -10.5F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 19).addBox(-2.0F, -10.5F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 16).addBox(-2.0F, -7.5F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-2.0F, -4.5F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(-2.0F, -7.5F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -4.5F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 29).addBox(-2.0F, -10.5F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 26).addBox(-2.0F, -10.5F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 21).addBox(-2.0F, -7.5F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 0).addBox(-2.0F, -7.5F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 19).addBox(-2.0F, -4.5F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 16).addBox(-2.0F, -4.5F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 18).addBox(-1.0F, -11.5F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition robe = body.addOrReplaceChild("robe", CubeListBuilder.create().texOffs(0, 45).addBox(-4.475F, -8.225F, -3.5F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.975F, -2.775F, 0.0F));

		PartDefinition robe2 = robe.addOrReplaceChild("robe2", CubeListBuilder.create().texOffs(19, 40).addBox(-0.95F, -0.95F, -3.5F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.475F, 2.725F, 0.0F));

		PartDefinition robe3 = robe2.addOrReplaceChild("robe3", CubeListBuilder.create().texOffs(29, 34).addBox(0.0F, 0.0F, -3.5F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.05F, 3.05F, 0.0F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(24, 26).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -3.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(16, 26).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 3.0F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 5.0F));

		PartDefinition arms3 = arms.addOrReplaceChild("arms3", CubeListBuilder.create().texOffs(8, 26).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(-1.5F, -0.5F, -2.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -9.0F));

		PartDefinition arms2 = arms.addOrReplaceChild("arms2", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -1.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(28, 46).addBox(-5.5F, -7.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -12.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(SpectralLichEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animate(entity.idleState, SpectralLichAnimations.IDLE, ageInTicks, 1f);
		this.animate(entity.pursueState, SpectralLichAnimations.PURSUE, ageInTicks, 1f);
		this.animate(entity.walkState, SpectralLichAnimations.WALK, ageInTicks, 1f);

	}

	private void applyHeadRotation(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -30f, 30f);
		headPitch = Mth.clamp(headPitch, -25f, 45);

		this.head.yRot = headYaw * ((float) Math.PI / 180f);
		this.head.xRot = headPitch * ((float) Math.PI / 180f);
	}

	@Override
	public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
		body.translateAndRotate(poseStack);
		arms.translateAndRotate(poseStack);

		ModelPart armPart = arm == HumanoidArm.RIGHT ? arms2 : arms3;
		armPart.translateAndRotate(poseStack);
		poseStack.mulPose(Axis.YP.rotationDegrees(90));

		poseStack.translate(0.0f, 0.0f, 0.1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}