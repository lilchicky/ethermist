package com.gmail.thelilchicken01.ethermist.entity.client.model;
// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.animation.ZalkulAnimations;
import com.gmail.thelilchicken01.ethermist.entity.mobs.ZalkulEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

/**
 * Made with Blockbench 5.2.2
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author Hexodiax
 */
public class ZalkulModel<T extends ZalkulEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "zalkul"), "main");

	private final ModelPart root;

	private final ModelPart body;
	private final ModelPart body2;
	private final ModelPart head;
	private final ModelPart horns;
	private final ModelPart horns_r;
	private final ModelPart horns_l;
	//private final ModelPart eyes;
	private final ModelPart arms2;
	private final ModelPart arms_l;
	private final ModelPart arms_r;
	private final ModelPart spine;
	private final ModelPart wing;
	private final ModelPart leg_left;
	private final ModelPart leg_right;
	private final ModelPart arms;

	public ZalkulModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.body2 = this.body.getChild("body2");
		this.head = this.body2.getChild("head");
		this.horns = this.head.getChild("horns");
		this.horns_r = this.horns.getChild("horns_r");
		this.horns_l = this.horns.getChild("horns_l");
		//this.eyes = this.head.getChild("eyes");
		this.arms2 = this.body2.getChild("arms2");
		this.arms_l = this.arms2.getChild("arms_l");
		this.arms_r = this.arms2.getChild("arms_r");
		this.spine = this.body2.getChild("spine");
		this.wing = this.spine.getChild("wing");
		this.leg_left = this.body.getChild("leg_left");
		this.leg_right = this.body.getChild("leg_right");
		this.arms = this.body.getChild("arms");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(32, 18).addBox(-2.5526F, -10.3947F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-1.5526F, -9.3947F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(12, 16).addBox(-1.5526F, -6.3947F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-3.5526F, -3.3947F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 21).addBox(-3.5526F, -6.3947F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 0).addBox(-3.5526F, -6.3947F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 26).addBox(-3.5526F, -9.3947F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 29).addBox(-3.5526F, -9.3947F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 19).addBox(-3.5526F, -9.3947F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 16).addBox(-3.5526F, -6.3947F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 19).addBox(-3.5526F, -3.3947F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(-3.5526F, -6.3947F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 19).addBox(-3.5526F, -9.3947F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 18).addBox(-1.5526F, -3.3947F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5526F, -1.1053F, 0.0F));

		PartDefinition head = body2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5526F, -11.3947F, 0.0F));

		PartDefinition horns = head.addOrReplaceChild("horns", CubeListBuilder.create(), PartPose.offset(0.5562F, -8.3102F, -5.9048F));

		PartDefinition horns_r = horns.addOrReplaceChild("horns_r", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 11.8095F));

		PartDefinition horns_r1 = horns_r.addOrReplaceChild("horns_r1", CubeListBuilder.create().texOffs(42, 6).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4486F, 0.5545F, 0.8303F));

		PartDefinition horns_r2 = horns_r.addOrReplaceChild("horns_r2", CubeListBuilder.create().texOffs(43, 10).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 3.0F, 0.001F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7961F, -0.0256F, 0.6752F, 0.0366F, 0.6973F, 1.6277F));

		PartDefinition horns_r3 = horns_r.addOrReplaceChild("horns_r3", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9562F, 1.3102F, -1.9048F, -0.6677F, 0.2217F, 0.2719F));

		PartDefinition horns_l = horns.addOrReplaceChild("horns_l", CubeListBuilder.create(), PartPose.offset(-0.2218F, 0.219F, 0.8871F));

		PartDefinition horns_r4 = horns_l.addOrReplaceChild("horns_r4", CubeListBuilder.create().texOffs(42, 6).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2218F, -0.219F, -0.8871F, 0.4486F, -0.5545F, 0.8303F));

		PartDefinition horns_r5 = horns_l.addOrReplaceChild("horns_r5", CubeListBuilder.create().texOffs(43, 10).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 3.0F, 0.001F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5744F, -0.2446F, -1.5622F, -0.0366F, -0.6973F, 1.6277F));

		PartDefinition horns_r6 = horns_l.addOrReplaceChild("horns_r6", CubeListBuilder.create().texOffs(41, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7345F, 1.0912F, 1.0177F, 0.6677F, -0.2217F, 0.2719F));

		PartDefinition arms2 = body2.addOrReplaceChild("arms2", CubeListBuilder.create(), PartPose.offset(-1.5526F, 11.6053F, 0.0F));

		PartDefinition arms_l = arms2.addOrReplaceChild("arms_l", CubeListBuilder.create().texOffs(8, 26).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.5F, -4.0F));

		PartDefinition arms_r = arms2.addOrReplaceChild("arms_r", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.5F, 4.0F));

		PartDefinition spine = body2.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(32, 6).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4474F, -4.3947F, 0.0F));

		PartDefinition wing = spine.addOrReplaceChild("wing", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4178F, -2.8135F, 0.8565F, 0.3054F, 0.0F, 0.0F));

		PartDefinition wing_r1 = wing.addOrReplaceChild("wing_r1", CubeListBuilder.create().texOffs(12, 58).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0974F, 0.0215F, 8.0921F, -1.0472F, 0.1309F, 0.0F));

		PartDefinition wing_r2 = wing.addOrReplaceChild("wing_r2", CubeListBuilder.create().texOffs(5, 58).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7256F, -0.1158F, 12.8638F, -0.829F, 0.1309F, 0.0F));

		PartDefinition wing_r3 = wing.addOrReplaceChild("wing_r3", CubeListBuilder.create().texOffs(0, 52).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2419F, -2.4307F, 9.1892F, -0.1309F, 0.1309F, 0.0F));

		PartDefinition wing_r4 = wing.addOrReplaceChild("wing_r4", CubeListBuilder.create().texOffs(0, 58).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8407F, -2.2121F, 6.1425F, 0.9599F, 0.1309F, 0.0F));

		PartDefinition wing_r5 = wing.addOrReplaceChild("wing_r5", CubeListBuilder.create().texOffs(12, 52).addBox(-0.5F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1136F, 0.5321F, -1.1061F, 0.0F, 0.1309F, 0.0F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(24, 26).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -3.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(16, 26).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 3.0F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(ZalkulEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animate(entity.idleState, ZalkulAnimations.IDLE, ageInTicks, 1f);
		this.animate(entity.walkState, ZalkulAnimations.WALK, ageInTicks, 1f);
		this.animate(entity.pursueState, ZalkulAnimations.PURSUE, ageInTicks, 1f);
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
		return this.root;
	}
}