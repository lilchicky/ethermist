package com.gmail.thelilchicken01.ethermist.entity.client.model;
// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.gmail.thelilchicken01.ethermist.Ethermist;
import com.gmail.thelilchicken01.ethermist.entity.client.animation.KarakaAnimations;
import com.gmail.thelilchicken01.ethermist.entity.mobs.KarakaEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class KarakaModel<T extends KarakaEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "karaka"), "main");

	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart necks;
	private final ModelPart horns;

    public KarakaModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		ModelPart torso = this.body.getChild("torso");
		ModelPart top_torso = torso.getChild("top_torso");
		this.necks = top_torso.getChild("necks");
		ModelPart neck = necks.getChild("neck");
		ModelPart neck2 = neck.getChild("neck2");
		this.head = neck2.getChild("head");
		this.horns = this.head.getChild("horns");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, -19.75F, 6.75F));

		PartDefinition top_torso = torso.addOrReplaceChild("top_torso", CubeListBuilder.create().texOffs(0, 21).addBox(-5.0F, -5.2F, -10.5F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.5F, -4.75F, -0.5F, 9.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, -8.75F));

		PartDefinition flower10 = top_torso.addOrReplaceChild("flower10", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -5.2899F, -3.9184F, 3.1416F, -0.3054F, 0.0F));

		PartDefinition flower_r1 = flower10.addOrReplaceChild("flower_r1", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r2 = flower10.addOrReplaceChild("flower_r2", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.01F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r3 = flower10.addOrReplaceChild("flower_r3", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r4 = flower10.addOrReplaceChild("flower_r4", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition flower9 = top_torso.addOrReplaceChild("flower9", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 1.9102F, -10.6184F, -1.5708F, 0.0F, -1.8762F));

		PartDefinition flower_r5 = flower9.addOrReplaceChild("flower_r5", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r6 = flower9.addOrReplaceChild("flower_r6", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r7 = flower9.addOrReplaceChild("flower_r7", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r8 = flower9.addOrReplaceChild("flower_r8", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition flower8 = top_torso.addOrReplaceChild("flower8", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, -3.6898F, -3.4184F, 0.0F, 0.0F, -1.5708F));

		PartDefinition flower_r9 = flower8.addOrReplaceChild("flower_r9", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r10 = flower8.addOrReplaceChild("flower_r10", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r11 = flower8.addOrReplaceChild("flower_r11", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r12 = flower8.addOrReplaceChild("flower_r12", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition necks = top_torso.addOrReplaceChild("necks", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, -2.25F, -6.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition neck = necks.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(42, 0)
				.addBox(-2.5F, -3.0F, -5.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition neck2 = neck.addOrReplaceChild("neck2", CubeListBuilder.create(), PartPose.offset(0.5F, -0.3F, -4.7F));

		PartDefinition neck2_r1 = neck2.addOrReplaceChild("neck2_r1", CubeListBuilder.create().texOffs(44, 52)
				.addBox(-2.5F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition head = neck2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 42)
				.addBox(-3.0F, -2.766F, -5.9053F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -2.9F, -0.3927F, 0.0F, 0.0F));

		PartDefinition horns = head.addOrReplaceChild("horns", CubeListBuilder.create(), PartPose.offset(1.385F, 1.934F, -5.7262F));

		PartDefinition horn_right = horns.addOrReplaceChild("horn_right", CubeListBuilder.create().texOffs(96, 26).mirror()
				.addBox(-0.515F, -0.5F, -2.879F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.7699F, 0.0F, 0.0F, -0.1302F, 0.435F, -0.0233F));

		PartDefinition horns_r1 = horn_right.addOrReplaceChild("horns_r1", CubeListBuilder.create().texOffs(101, 22).mirror()
				.addBox(-2.5F, -0.5F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.8171F, -2.0915F, -9.8568F, -0.3927F, 0.1745F, 0.0F));

		PartDefinition horns_r2 = horn_right.addOrReplaceChild("horns_r2", CubeListBuilder.create().texOffs(104, 30).mirror()
				.addBox(-2.5F, -0.5F, 1.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.8171F, -1.7915F, -10.3568F, -0.3927F, 0.1745F, 0.0F));

		PartDefinition horns_r3 = horn_right.addOrReplaceChild("horns_r3", CubeListBuilder.create().texOffs(101, 16).mirror()
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.3941F, -2.1359F, -9.864F, -0.4932F, 0.6501F, -0.2428F));

		PartDefinition horns_r4 = horn_right.addOrReplaceChild("horns_r4", CubeListBuilder.create().texOffs(105, 1).mirror()
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.6265F, 1.82F, -9.4011F, 0.3938F, -0.1889F, -0.1497F));

		PartDefinition horns_r5 = horn_right.addOrReplaceChild("horns_r5", CubeListBuilder.create().texOffs(98, 3).mirror()
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.9166F, 0.8034F, -6.8579F, 0.3927F, 0.1745F, 0.0F));

		PartDefinition horns_r6 = horn_right.addOrReplaceChild("horns_r6", CubeListBuilder.create().texOffs(93, 3).mirror()
				.addBox(3.5F, 0.5F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0335F, 0.9539F, -7.9032F, -0.951F, 0.4597F, -0.9417F));

		PartDefinition horns_r7 = horn_right.addOrReplaceChild("horns_r7", CubeListBuilder.create().texOffs(110, 6).mirror()
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6167F, -1.714F, -9.7132F, -1.3929F, 1.1779F, -1.3068F));

		PartDefinition horns_r8 = horn_right.addOrReplaceChild("horns_r8", CubeListBuilder.create().texOffs(91, 8).mirror()
				.addBox(0.5F, -0.5F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0663F, -0.7802F, -6.9509F, -0.6266F, 0.8728F, -0.4346F));

		PartDefinition horns_r9 = horn_right.addOrReplaceChild("horns_r9", CubeListBuilder.create().texOffs(109, 15).mirror()
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.9166F, -0.8034F, -6.8579F, -0.3927F, 0.1745F, 0.0F));

		PartDefinition horns_r10 = horn_right.addOrReplaceChild("horns_r10", CubeListBuilder.create().texOffs(92, 27).mirror()
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.4605F, 0.0F, -5.3421F, 0.0F, -0.1745F, 0.0F));

		PartDefinition horns_r11 = horn_right.addOrReplaceChild("horns_r11", CubeListBuilder.create().texOffs(89, 22).mirror()
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.785F, 0.0F, -3.821F, 0.0F, 0.6109F, 0.0F));

		PartDefinition horns_r12 = horn_right.addOrReplaceChild("horns_r12", CubeListBuilder.create().texOffs(93, 19).mirror()
				.addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0597F, 0.0F, -3.238F, 0.0F, 0.5672F, 0.0F));

		PartDefinition horns_r13 = horn_right.addOrReplaceChild("horns_r13", CubeListBuilder.create().texOffs(91, 14).mirror()
				.addBox(-0.5F, -0.5F, -4.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.832F, -0.6585F, -4.1856F, -0.588F, -0.4478F, 0.281F));

		PartDefinition horns_r14 = horn_right.addOrReplaceChild("horns_r14", CubeListBuilder.create().texOffs(100, 11).mirror()
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.015F, -0.683F, -4.2281F, -0.5236F, 0.0F, 0.0F));

		PartDefinition flower7 = horn_right.addOrReplaceChild("flower7", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.515F, -2.7738F, -9.7922F, 2.7327F, 0.0038F, 0.0544F));

		PartDefinition flower_r13 = flower7.addOrReplaceChild("flower_r13", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r14 = flower7.addOrReplaceChild("flower_r14", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r15 = flower7.addOrReplaceChild("flower_r15", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r16 = flower7.addOrReplaceChild("flower_r16", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition flower6 = horn_right.addOrReplaceChild("flower6", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.685F, -1.1738F, -9.9922F, -0.3349F, 0.1611F, 0.0248F));

		PartDefinition flower_r17 = flower6.addOrReplaceChild("flower_r17", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r18 = flower6.addOrReplaceChild("flower_r18", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r19 = flower6.addOrReplaceChild("flower_r19", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r20 = flower6.addOrReplaceChild("flower_r20", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition flower2 = horn_right.addOrReplaceChild("flower2", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.815F, 1.9262F, -7.8922F, 0.4778F, 0.4027F, 0.0744F));

		PartDefinition flower_r21 = flower2.addOrReplaceChild("flower_r21", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r22 = flower2.addOrReplaceChild("flower_r22", CubeListBuilder.create().texOffs(111, 43).mirror().
				addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r23 = flower2.addOrReplaceChild("flower_r23", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r24 = flower2.addOrReplaceChild("flower_r24", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition horn_left = horns.addOrReplaceChild("horn_left", CubeListBuilder.create().texOffs(103, 25)
				.addBox(-0.485F, -0.5F, -2.879F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1302F, -0.435F, 0.0233F));

		PartDefinition horns_r15 = horn_left.addOrReplaceChild("horns_r15", CubeListBuilder.create().texOffs(101, 22)
				.addBox(0.5F, -0.5F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8171F, -2.0915F, -9.8568F, -0.3927F, -0.1745F, 0.0F));

		PartDefinition horns_r16 = horn_left.addOrReplaceChild("horns_r16", CubeListBuilder.create().texOffs(101, 16)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3941F, -2.1359F, -9.864F, -0.4932F, -0.6501F, 0.2428F));

		PartDefinition horns_r17 = horn_left.addOrReplaceChild("horns_r17", CubeListBuilder.create().texOffs(105, 1)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6265F, 1.82F, -9.4011F, 0.3938F, 0.1889F, 0.1497F));

		PartDefinition horns_r18 = horn_left.addOrReplaceChild("horns_r18", CubeListBuilder.create().texOffs(98, 3)
				.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9166F, 0.8034F, -6.8579F, 0.3927F, -0.1745F, 0.0F));

		PartDefinition horns_r19 = horn_left.addOrReplaceChild("horns_r19", CubeListBuilder.create().texOffs(93, 3)
				.addBox(-4.5F, 0.5F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0335F, 0.9539F, -7.9032F, -0.951F, -0.4597F, 0.9417F));

		PartDefinition horns_r20 = horn_left.addOrReplaceChild("horns_r20", CubeListBuilder.create().texOffs(105, 7)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6167F, -1.714F, -9.7132F, -1.3929F, -1.1779F, 1.3068F));

		PartDefinition horns_r21 = horn_left.addOrReplaceChild("horns_r21", CubeListBuilder.create().texOffs(91, 8)
				.addBox(-5.5F, -0.5F, -2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0663F, -0.7802F, -6.9509F, -0.6266F, -0.8728F, 0.4346F));

		PartDefinition horns_r22 = horn_left.addOrReplaceChild("horns_r22", CubeListBuilder.create().texOffs(109, 10)
				.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9166F, -0.8034F, -6.8579F, -0.3927F, -0.1745F, 0.0F));

		PartDefinition horns_r23 = horn_left.addOrReplaceChild("horns_r23", CubeListBuilder.create().texOffs(92, 27)
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4605F, 0.0F, -5.3421F, 0.0F, 0.1745F, 0.0F));

		PartDefinition horns_r24 = horn_left.addOrReplaceChild("horns_r24", CubeListBuilder.create().texOffs(89, 22)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.785F, 0.0F, -3.821F, 0.0F, -0.6109F, 0.0F));

		PartDefinition horns_r25 = horn_left.addOrReplaceChild("horns_r25", CubeListBuilder.create().texOffs(93, 19)
				.addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0597F, 0.0F, -3.238F, 0.0F, -0.5672F, 0.0F));

		PartDefinition horns_r26 = horn_left.addOrReplaceChild("horns_r26", CubeListBuilder.create().texOffs(91, 10)
				.addBox(-0.5F, -0.5F, -4.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.832F, -0.6585F, -4.1856F, -0.588F, 0.4478F, -0.281F));

		PartDefinition horns_r27 = horn_left.addOrReplaceChild("horns_r27", CubeListBuilder.create().texOffs(100, 11)
				.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.015F, -0.683F, -4.2281F, -0.5236F, 0.0F, 0.0F));

		PartDefinition flower5 = horn_left.addOrReplaceChild("flower5", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.015F, -1.6738F, -7.2922F, 2.1632F, 1.0477F, -0.9127F));

		PartDefinition flower_r25 = flower5.addOrReplaceChild("flower_r25", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r26 = flower5.addOrReplaceChild("flower_r26", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r27 = flower5.addOrReplaceChild("flower_r27", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r28 = flower5.addOrReplaceChild("flower_r28", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition flower4 = horn_left.addOrReplaceChild("flower4", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.615F, -1.7738F, -10.4922F, -0.517F, 0.694F, -0.3911F));

		PartDefinition flower_r29 = flower4.addOrReplaceChild("flower_r29", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r30 = flower4.addOrReplaceChild("flower_r30", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r31 = flower4.addOrReplaceChild("flower_r31", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r32 = flower4.addOrReplaceChild("flower_r32", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition flower3 = horn_left.addOrReplaceChild("flower3", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.015F, -0.4738F, -5.0922F, -0.6046F, 0.4047F, -0.2656F));

		PartDefinition flower_r33 = flower3.addOrReplaceChild("flower_r33", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r34 = flower3.addOrReplaceChild("flower_r34", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r35 = flower3.addOrReplaceChild("flower_r35", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r36 = flower3.addOrReplaceChild("flower_r36", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition vine = horn_left.addOrReplaceChild("vine", CubeListBuilder.create(), PartPose.offset(1.8166F, -1.2034F, -6.7579F));

		PartDefinition vine_r1 = vine.addOrReplaceChild("vine_r1", CubeListBuilder.create().texOffs(109, 31)
				.addBox(-4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(112, 29).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7894F, 1.2791F, 4.4236F, -0.0873F, -0.1745F, 0.0F));

		PartDefinition vine_r2 = vine.addOrReplaceChild("vine_r2", CubeListBuilder.create().texOffs(112, 27)
				.addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.103F, 1.0183F, 2.82F, -0.1745F, -0.1745F, 0.0F));

		PartDefinition vine_r3 = vine.addOrReplaceChild("vine_r3", CubeListBuilder.create().texOffs(108, 25)
				.addBox(0.5F, 0.5F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, -0.1745F, 0.0F));

		PartDefinition flower = vine.addOrReplaceChild("flower", CubeListBuilder.create().texOffs(109, 43)
				.addBox(-0.5F, -0.0262F, -0.4868F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9984F, 1.2296F, 2.6656F, -0.1299F, -0.3464F, 0.0443F));

		PartDefinition flower_r37 = flower.addOrReplaceChild("flower_r37", CubeListBuilder.create().texOffs(109, 44)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, 0.6302F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower_r38 = flower.addOrReplaceChild("flower_r38", CubeListBuilder.create().texOffs(111, 43).mirror()
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower_r39 = flower.addOrReplaceChild("flower_r39", CubeListBuilder.create().texOffs(107, 43)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0099F, 0.0132F, 0.0F, 0.0F, -0.2618F));

		PartDefinition flower_r40 = flower.addOrReplaceChild("flower_r40", CubeListBuilder.create().texOffs(109, 42)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.001F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0032F, -0.6698F, 0.2618F, 0.0F, 0.0F));

		PartDefinition eyebrows = head.addOrReplaceChild("eyebrows", CubeListBuilder.create(), PartPose.offset(0.0F, 3.834F, -4.9053F));

		PartDefinition eyebrow_r1 = eyebrows.addOrReplaceChild("eyebrow_r1", CubeListBuilder.create().texOffs(80, 0).mirror()
				.addBox(-3.1F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(60, 0).addBox(1.1F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0175F));

		PartDefinition muzzle = head.addOrReplaceChild("muzzle", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.234F, -3.6553F, 0.2182F, 0.0F, 0.0F));

		PartDefinition muzzle1 = muzzle.addOrReplaceChild("muzzle1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.05F, 1.0F));

		PartDefinition muzzle1_r1 = muzzle1.addOrReplaceChild("muzzle1_r1", CubeListBuilder.create().texOffs(65, 11)
				.addBox(-2.0F, -0.5F, -1.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition nose_r1 = muzzle1.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(57, 15)
				.addBox(-1.0F, 3.5F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, -0.2F, -0.1309F, 0.0F, 0.0F));

		PartDefinition muzzle2 = muzzle.addOrReplaceChild("muzzle2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.25F, 2.5F));

		PartDefinition muzzle2_r1 = muzzle2.addOrReplaceChild("muzzle2_r1", CubeListBuilder.create().texOffs(66, 5)
				.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create(), PartPose.offset(2.0F, 0.234F, -5.6553F));

		PartDefinition ear_right = ears.addOrReplaceChild("ear_right", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0436F));

		PartDefinition ear_right_r1 = ear_right.addOrReplaceChild("ear_right_r1", CubeListBuilder.create().texOffs(54, 61).mirror()
				.addBox(-4.0F, -1.0F, -2.0F, 5.0F, 0.001F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.25F, 1.0F, 0.5F, -0.0456F, -0.1685F, 0.2657F));

		PartDefinition ear_left = ears.addOrReplaceChild("ear_left", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, -0.0436F));

		PartDefinition ear_left_r1 = ear_left.addOrReplaceChild("ear_left_r1", CubeListBuilder.create().texOffs(54, 61)
				.addBox(-1.0F, -1.0F, -2.0F, 5.0F, 0.001F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 1.0F, 0.5F, -0.0456F, 0.1685F, -0.2657F));

		PartDefinition tail = top_torso.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 67)
				.addBox(-2.5F, -1.0865F, 0.2231F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.8382F, 10.6963F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offset(0.0F, -0.0035F, 3.7722F));

		PartDefinition tail2_r1 = tail2.addOrReplaceChild("tail2_r1", CubeListBuilder.create().texOffs(0, 73)
				.addBox(-2.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, 1.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition low_torso = torso.addOrReplaceChild("low_torso", CubeListBuilder.create(), PartPose.offset(0.5F, 14.25F, -6.25F));

		PartDefinition front_legs = low_torso.addOrReplaceChild("front_legs", CubeListBuilder.create(), PartPose.offset(-0.5F, -13.1F, -1.8F));

		PartDefinition leg_front_right = front_legs.addOrReplaceChild("leg_front_right", CubeListBuilder.create().texOffs(42, 26).mirror()
				.addBox(-2.0F, -3.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(-4.25F, 0.25F, -7.5F));

		PartDefinition leg_front_right2 = leg_front_right.addOrReplaceChild("leg_front_right2", CubeListBuilder.create().texOffs(63, 28).mirror()
				.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.15F, 5.0F, 1.75F));

		PartDefinition leg_front_right3 = leg_front_right2.addOrReplaceChild("leg_front_right3", CubeListBuilder.create().texOffs(74, 29)
				.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -3.0F));

		PartDefinition leg_front_right4 = leg_front_right3.addOrReplaceChild("leg_front_right4", CubeListBuilder.create().texOffs(62, 49)
				.addBox(-1.5F, -1.55F, -2.8F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, 1.25F));

		PartDefinition leg_front_left = front_legs.addOrReplaceChild("leg_front_left", CubeListBuilder.create().texOffs(42, 26)
				.addBox(-2.0F, -3.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offset(4.25F, 0.25F, -7.5F));

		PartDefinition leg_front_left2 = leg_front_left.addOrReplaceChild("leg_front_left2", CubeListBuilder.create().texOffs(63, 28)
				.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.15F, 5.0F, 1.75F));

		PartDefinition leg_front_left3 = leg_front_left2.addOrReplaceChild("leg_front_left3", CubeListBuilder.create().texOffs(82, 29).mirror()
				.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, -3.0F));

		PartDefinition leg_front_left4 = leg_front_left3.addOrReplaceChild("leg_front_left4", CubeListBuilder.create().texOffs(62, 49)
				.addBox(-1.5F, -1.55F, -2.8F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, 1.25F));

		PartDefinition back_legs = low_torso.addOrReplaceChild("back_legs", CubeListBuilder.create(), PartPose.offset(-0.5F, -13.25F, 5.2F));

		PartDefinition leg_back_right = back_legs.addOrReplaceChild("leg_back_right", CubeListBuilder.create().texOffs(42, 12).mirror()
				.addBox(-2.0F, -3.0F, -3.25F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition leg_front_right5 = leg_back_right.addOrReplaceChild("leg_front_right5", CubeListBuilder.create().texOffs(63, 19).mirror()
				.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.4F, 5.4F, 0.85F));

		PartDefinition leg_front_right6 = leg_front_right5.addOrReplaceChild("leg_front_right6", CubeListBuilder.create().texOffs(74, 19).mirror()
				.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, -3.0F));

		PartDefinition leg_front_right7 = leg_front_right6.addOrReplaceChild("leg_front_right7", CubeListBuilder.create().texOffs(62, 49).mirror()
				.addBox(-1.5F, -1.55F, -2.8F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 7.5F, 1.25F));

		PartDefinition leg_back_left = back_legs.addOrReplaceChild("leg_back_left", CubeListBuilder.create().texOffs(42, 12)
				.addBox(-2.0F, -3.0F, -3.25F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition leg_front_left5 = leg_back_left.addOrReplaceChild("leg_front_left5", CubeListBuilder.create().texOffs(63, 19)
				.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4F, 5.4F, 0.85F));

		PartDefinition leg_front_left6 = leg_front_left5.addOrReplaceChild("leg_front_left6", CubeListBuilder.create().texOffs(74, 19)
				.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -3.0F));

		PartDefinition leg_front_left7 = leg_front_left6.addOrReplaceChild("leg_front_left7", CubeListBuilder.create().texOffs(62, 49)
				.addBox(-1.5F, -1.55F, -2.8F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.5F, 1.25F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(KarakaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch - 45f);

		this.animate(entity.walkState, KarakaAnimations.WALK, ageInTicks, 1f);
		this.animate(entity.idleState, KarakaAnimations.IDLE, ageInTicks, 1f);
		this.animate(entity.eatState, KarakaAnimations.IDLE_EAT, ageInTicks, 1f);
		this.animate(entity.wagState, KarakaAnimations.IDLE_TAIL, ageInTicks, 1f);

		this.horns.visible = entity.hasAntlers();
	}

	private void applyHeadRotation(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -30f, 30f);
		headPitch = Mth.clamp(headPitch, -92.5f, -22.5f);

		this.necks.yRot = headYaw * ((float) Math.PI / 180f);
		this.necks.xRot = headPitch * ((float) Math.PI / 180f);
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