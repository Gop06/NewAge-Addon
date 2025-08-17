package net.NewAge.addon.models.abilities;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MosaVineTrapModel extends EntityModel<Entity> {
	private final ModelRenderer bone7;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer vine_base;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer cube_r2;
	private final ModelRenderer bone5;
	private final ModelRenderer bone29;
	private final ModelRenderer bone6;
	private final ModelRenderer vine_base2;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer cube_r3;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer cube_r4;
	private final ModelRenderer bone12;
	private final ModelRenderer bone28;
	private final ModelRenderer bone13;
	private final ModelRenderer vine_base4;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer cube_r5;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer cube_r6;
	private final ModelRenderer bone24;
	private final ModelRenderer bone27;
	private final ModelRenderer bone25;
	private final ModelRenderer vine_base3;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer cube_r7;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer cube_r8;
	private final ModelRenderer bone18;
	private final ModelRenderer bone26;
	private final ModelRenderer bone30;
	private final ModelRenderer bone19;

	public MosaVineTrapModel() {
		texWidth = 64;
		texHeight = 64;

		bone7 = new ModelRenderer(this);
		bone7.setPos(0.0F, 24.0F, 0.0F);


		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -24.0F, 0.0F);
		bone7.addChild(Head);
		Head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, -24.0F, 0.0F);
		bone7.addChild(Body);
		Body.texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, -22.0F, 0.0F);
		bone7.addChild(RightArm);
		RightArm.texOffs(24, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, -22.0F, 0.0F);
		bone7.addChild(LeftArm);
		LeftArm.texOffs(0, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, -12.0F, 0.0F);
		bone7.addChild(RightLeg);
		RightLeg.texOffs(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, -12.0F, 0.0F);
		bone7.addChild(LeftLeg);
		LeftLeg.texOffs(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		vine_base = new ModelRenderer(this);
		vine_base.setPos(-6.5F, 24.0F, 0.5F);
		setRotationAngle(vine_base, 0.5654F, -0.8785F, -0.4544F);


		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 1.0F, 0.0F);
		vine_base.addChild(bone);
		bone.texOffs(44, 27).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(0.0F, -8.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.3914F, -0.7211F, -0.0921F);
		bone2.texOffs(44, 27).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, -6.25F, 1.0F);
		bone2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.2654F, -0.5236F);
		cube_r1.texOffs(44, 38).addBox(-7.0F, -2.75F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, -8.0F, 0.0F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, 0.983F, -0.7688F, -0.6179F);
		bone3.texOffs(44, 43).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setPos(0.0F, -8.0F, 0.0F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, 0.1291F, -0.2448F, 0.3649F);
		bone4.texOffs(32, 46).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-1.0F, -3.25F, 0.0F);
		bone4.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.6545F, 0.0F, 0.5236F);
		cube_r2.texOffs(44, 38).addBox(-7.0F, -2.75F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setPos(0.0F, -8.0F, 0.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 1.2974F, -0.0316F, 0.1227F);
		bone5.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setPos(0.0F, -8.0F, 0.0F);
		bone5.addChild(bone29);
		setRotationAngle(bone29, 1.4625F, -0.4223F, 0.1641F);
		bone29.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setPos(0.0F, -8.0F, 0.0F);
		bone29.addChild(bone6);
		bone6.texOffs(32, 32).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, 0.0F, false);

		vine_base2 = new ModelRenderer(this);
		vine_base2.setPos(-0.5F, 24.0F, 6.5F);
		setRotationAngle(vine_base2, 0.0F, 0.0F, -0.2618F);


		bone8 = new ModelRenderer(this);
		bone8.setPos(0.0F, 1.0F, 0.0F);
		vine_base2.addChild(bone8);
		bone8.texOffs(44, 27).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setPos(0.0F, -8.0F, 0.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.0873F, 0.0F, -0.1309F);
		bone9.texOffs(44, 27).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, -6.25F, 1.0F);
		bone9.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 1.2654F, -0.5236F);
		cube_r3.texOffs(44, 38).addBox(-7.0F, -2.75F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setPos(0.0F, -8.0F, 0.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.1309F, 0.0F, 0.0F);
		bone10.texOffs(44, 43).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setPos(0.0F, -8.0F, 0.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 1.2654F, 0.0F, -0.9163F);
		bone11.texOffs(32, 46).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-1.0F, -3.25F, 0.0F);
		bone11.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.6545F, 0.0F, 0.5236F);
		cube_r4.texOffs(44, 38).addBox(-7.0F, -2.75F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setPos(0.0F, -8.0F, 0.0F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 1.7016F, -0.4971F, 0.1719F);
		bone12.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setPos(0.0F, -8.0F, 0.0F);
		bone12.addChild(bone28);
		setRotationAngle(bone28, 0.2618F, 0.0F, -0.829F);
		bone28.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setPos(0.0F, -7.0F, 0.0F);
		bone28.addChild(bone13);
		setRotationAngle(bone13, -0.6988F, 1.2489F, -1.5752F);
		bone13.texOffs(32, 32).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, 0.0F, false);

		vine_base4 = new ModelRenderer(this);
		vine_base4.setPos(0.5F, 24.0F, -6.5F);
		setRotationAngle(vine_base4, 0.0F, 0.0F, 0.3927F);


		bone20 = new ModelRenderer(this);
		bone20.setPos(0.0F, 1.0F, 0.0F);
		vine_base4.addChild(bone20);
		bone20.texOffs(44, 27).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setPos(0.0F, -8.0F, 0.0F);
		bone20.addChild(bone21);
		setRotationAngle(bone21, -0.303F, 0.0393F, 0.1249F);
		bone21.texOffs(44, 27).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, -6.25F, 1.0F);
		bone21.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 1.2654F, -0.5236F);
		cube_r5.texOffs(44, 38).addBox(-7.0F, -2.75F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setPos(0.0F, -8.0F, 0.0F);
		bone21.addChild(bone22);
		setRotationAngle(bone22, -0.3491F, 0.0F, 0.0F);
		bone22.texOffs(44, 43).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setPos(0.0F, -8.0F, 0.0F);
		bone22.addChild(bone23);
		setRotationAngle(bone23, -0.8432F, -0.4528F, -1.3342F);
		bone23.texOffs(32, 46).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(-1.0F, -3.25F, 0.0F);
		bone23.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.6545F, 0.0F, 0.5236F);
		cube_r6.texOffs(44, 38).addBox(-7.0F, -2.75F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setPos(0.0F, -8.0F, 0.0F);
		bone23.addChild(bone24);
		setRotationAngle(bone24, 1.1663F, -0.1396F, -0.5735F);
		bone24.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setPos(0.0F, -8.0F, 0.0F);
		bone24.addChild(bone27);
		setRotationAngle(bone27, 0.554F, -0.4492F, -0.1297F);
		bone27.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone25 = new ModelRenderer(this);
		bone25.setPos(0.0F, -8.0F, 0.0F);
		bone27.addChild(bone25);
		setRotationAngle(bone25, -3.086F, 1.0912F, 2.0206F);
		bone25.texOffs(32, 32).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, 0.0F, false);

		vine_base3 = new ModelRenderer(this);
		vine_base3.setPos(6.5F, 24.0F, -0.5F);
		setRotationAngle(vine_base3, -0.3491F, 0.0F, 0.0F);


		bone14 = new ModelRenderer(this);
		bone14.setPos(0.0F, 1.0F, 0.0F);
		vine_base3.addChild(bone14);
		bone14.texOffs(44, 27).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setPos(0.0F, -8.0F, 0.0F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, 0.0F, 0.0F, -0.5672F);
		bone15.texOffs(44, 27).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, -6.25F, 1.0F);
		bone15.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 1.2654F, -0.5236F);
		cube_r7.texOffs(44, 38).addBox(-7.0F, -2.75F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setPos(0.0F, -8.0F, 0.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.3011F, 0.0522F, -0.1666F);
		bone16.texOffs(44, 43).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setPos(0.0F, -8.0F, 0.0F);
		bone16.addChild(bone17);
		setRotationAngle(bone17, 0.0873F, 0.0F, 0.2182F);
		bone17.texOffs(32, 46).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-1.0F, -3.25F, 0.0F);
		bone17.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.6545F, 0.0F, 0.5236F);
		cube_r8.texOffs(44, 38).addBox(-7.0F, -2.75F, 0.0F, 7.0F, 5.0F, 0.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setPos(0.0F, -8.0F, 0.0F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 1.7087F, 0.226F, -0.7753F);
		bone18.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setPos(0.0F, -8.0F, 0.0F);
		bone18.addChild(bone26);
		setRotationAngle(bone26, 0.5249F, -1.1166F, 1.0247F);
		bone26.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setPos(0.0F, -8.0F, 0.0F);
		bone26.addChild(bone30);
		setRotationAngle(bone30, 0.2546F, 0.4114F, -0.9938F);
		bone30.texOffs(0, 48).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setPos(0.0F, -8.0F, 0.0F);
		bone30.addChild(bone19);
		setRotationAngle(bone19, 1.5708F, 0.0F, 0.0F);
		bone19.texOffs(32, 32).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone7.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		vine_base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		vine_base2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		vine_base4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		vine_base3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}