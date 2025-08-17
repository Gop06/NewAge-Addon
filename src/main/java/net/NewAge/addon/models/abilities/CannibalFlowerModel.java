package net.NewAge.addon.models.abilities;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.swing.text.html.parser.Entity;

public class CannibalFlowerModel extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightArm;
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer planr;
	private final ModelRenderer cube_r1;
	private final ModelRenderer spike;
	private final ModelRenderer cube_r2;
	private final ModelRenderer spike2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer planr2;
	private final ModelRenderer cube_r4;
	private final ModelRenderer spike3;
	private final ModelRenderer cube_r5;
	private final ModelRenderer spike4;
	private final ModelRenderer cube_r6;
	private final ModelRenderer planr3;
	private final ModelRenderer head2;
	private final ModelRenderer jaw;
	private final ModelRenderer cube_r7;
	private final ModelRenderer jaw2;
	private final ModelRenderer cube_r8;
	private final ModelRenderer root;
	private final ModelRenderer root2;
	private final ModelRenderer root3;
	private final ModelRenderer root4;
	private final ModelRenderer root5;
	private final ModelRenderer root6;
	private final ModelRenderer root7;
	private final ModelRenderer root8;
	private final ModelRenderer root9;

	public CannibalFlowerModel() {
		texWidth = 128;
		texHeight = 128;

		bone = new ModelRenderer(this);
		bone.setPos(-24.0F, 24.0F, 0.0F);
		

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, -12.0F, 0.0F);
		bone.addChild(LeftLeg);
		LeftLeg.texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		LeftLeg.texOffs(112, 108).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, -12.0F, 0.0F);
		bone.addChild(RightLeg);
		RightLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		RightLeg.texOffs(112, 85).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, -22.0F, 0.0F);
		bone.addChild(LeftArm);
		LeftArm.texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		LeftArm.texOffs(112, 83).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, -22.0F, 0.0F);
		bone.addChild(RightArm);
		RightArm.texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		RightArm.texOffs(112, 86).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, -24.0F, 0.0F);
		bone.addChild(Body);
		Body.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		Body.texOffs(104, 79).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -24.0F, 0.0F);
		bone.addChild(Head);
		Head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.texOffs(96, 70).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		planr = new ModelRenderer(this);
		planr.setPos(0.0F, 24.0F, 0.0F);
		planr.texOffs(0, 40).addBox(-4.0F, -17.0F, -4.0F, 8.0F, 19.0F, 8.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(5.0F, -7.0F, 0.0F);
		planr.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.5672F, 0.0F, 0.0F);
		cube_r1.texOffs(52, 31).addBox(-1.0F, -4.0F, 0.0F, 9.0F, 6.0F, 0.0F, 0.0F, false);

		spike = new ModelRenderer(this);
		spike.setPos(5.0F, -12.0F, 0.0F);
		planr.addChild(spike);
		spike.texOffs(56, 37).addBox(-1.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, -1.0F, 0.0F);
		spike.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.5708F, 0.0F, 0.0F);
		cube_r2.texOffs(56, 37).addBox(-1.0F, -2.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);

		spike2 = new ModelRenderer(this);
		spike2.setPos(-5.0F, -6.0F, 0.0F);
		planr.addChild(spike2);
		setRotationAngle(spike2, 0.0F, 3.1416F, 0.0F);
		spike2.texOffs(56, 37).addBox(-1.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, -1.0F, 0.0F);
		spike2.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.5708F, 0.0F, 0.0F);
		cube_r3.texOffs(56, 37).addBox(-1.0F, -2.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);

		planr2 = new ModelRenderer(this);
		planr2.setPos(0.0F, -16.0F, 0.0F);
		planr.addChild(planr2);
		planr2.texOffs(32, 40).addBox(-3.0F, -19.0F, -3.0F, 6.0F, 19.0F, 6.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-4.0F, -16.0F, 0.0F);
		planr2.addChild(cube_r4);
		setRotationAngle(cube_r4, 2.4435F, 0.0F, 3.1416F);
		cube_r4.texOffs(52, 31).addBox(-1.0F, -4.0F, 0.0F, 9.0F, 6.0F, 0.0F, 0.0F, false);

		spike3 = new ModelRenderer(this);
		spike3.setPos(0.0F, -6.0F, -4.0F);
		planr2.addChild(spike3);
		setRotationAngle(spike3, 0.0F, 1.5708F, 0.0F);
		spike3.texOffs(56, 37).addBox(-1.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, -1.0F, 0.0F);
		spike3.addChild(cube_r5);
		setRotationAngle(cube_r5, -1.5708F, 0.0F, 0.0F);
		cube_r5.texOffs(56, 37).addBox(-1.0F, -2.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);

		spike4 = new ModelRenderer(this);
		spike4.setPos(0.0F, -14.0F, 4.0F);
		planr2.addChild(spike4);
		setRotationAngle(spike4, 0.0F, -1.5708F, 0.0F);
		spike4.texOffs(56, 37).addBox(-1.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, -1.0F, 0.0F);
		spike4.addChild(cube_r6);
		setRotationAngle(cube_r6, -1.5708F, 0.0F, 0.0F);
		cube_r6.texOffs(56, 37).addBox(-1.0F, -2.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, false);

		planr3 = new ModelRenderer(this);
		planr3.setPos(0.0F, -18.0F, 0.0F);
		planr2.addChild(planr3);
		setRotationAngle(planr3, 0.4363F, 0.0F, 0.0F);
		planr3.texOffs(52, 0).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 19.0F, 4.0F, 0.0F, false);

		head2 = new ModelRenderer(this);
		head2.setPos(0.0F, -18.0F, 0.0F);
		planr3.addChild(head2);
		setRotationAngle(head2, 1.5708F, -0.6109F, -1.5708F);
		head2.texOffs(52, 23).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 6.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setPos(-1.0F, -2.0F, 0.0F);
		head2.addChild(jaw);
		jaw.texOffs(0, 0).addBox(-1.0F, -16.0F, -12.0F, 2.0F, 16.0F, 24.0F, 0.0F, false);
		jaw.texOffs(4, 92).addBox(-3.0F, -15.0F, -10.0F, 2.0F, 14.0F, 20.0F, 0.0F, false);
		jaw.texOffs(30, 81).addBox(-5.0F, -14.0F, -8.0F, 2.0F, 12.0F, 16.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.5F, -16.0F, -7.0F);
		jaw.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 0.9599F);
		cube_r7.texOffs(56, 41).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r7.texOffs(56, 41).addBox(0.0F, -4.0F, 4.0F, 0.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r7.texOffs(56, 41).addBox(0.0F, -4.0F, 10.0F, 0.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r7.texOffs(56, 41).addBox(0.0F, -4.0F, 16.0F, 0.0F, 4.0F, 3.0F, 0.0F, false);

		jaw2 = new ModelRenderer(this);
		jaw2.setPos(1.0F, -2.0F, 0.0F);
		head2.addChild(jaw2);
		jaw2.texOffs(30, 81).addBox(3.0F, -14.0F, -8.0F, 2.0F, 12.0F, 16.0F, 0.0F, true);
		jaw2.texOffs(4, 92).addBox(1.0F, -15.0F, -10.0F, 2.0F, 14.0F, 20.0F, 0.0F, true);
		jaw2.texOffs(0, 0).addBox(-1.0F, -16.0F, -12.0F, 2.0F, 16.0F, 24.0F, 0.0F, true);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-0.5F, -16.0F, -10.0F);
		jaw2.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -0.9599F);
		cube_r8.texOffs(56, 41).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 3.0F, 0.0F, true);
		cube_r8.texOffs(56, 41).addBox(0.0F, -4.0F, 4.0F, 0.0F, 4.0F, 3.0F, 0.0F, true);
		cube_r8.texOffs(56, 41).addBox(0.0F, -4.0F, 10.0F, 0.0F, 4.0F, 3.0F, 0.0F, true);
		cube_r8.texOffs(56, 41).addBox(0.0F, -4.0F, 16.0F, 0.0F, 4.0F, 3.0F, 0.0F, true);

		root = new ModelRenderer(this);
		root.setPos(-4.0F, -1.0F, 0.0F);
		planr.addChild(root);
		setRotationAngle(root, 0.0F, -0.3054F, 0.0F);
		root.texOffs(0, 86).addBox(-6.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);

		root2 = new ModelRenderer(this);
		root2.setPos(-6.0F, 0.0F, 0.0F);
		root.addChild(root2);
		root2.texOffs(0, 76).addBox(-6.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		root3 = new ModelRenderer(this);
		root3.setPos(-6.0F, 0.0F, 0.0F);
		root2.addChild(root3);
		root3.texOffs(26, 78).addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		root4 = new ModelRenderer(this);
		root4.setPos(4.0F, -1.0F, -1.0F);
		planr.addChild(root4);
		setRotationAngle(root4, 0.0F, -2.8362F, 0.0F);
		root4.texOffs(0, 86).addBox(-6.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);

		root5 = new ModelRenderer(this);
		root5.setPos(-6.0F, 0.0F, 0.0F);
		root4.addChild(root5);
		root5.texOffs(0, 76).addBox(-6.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		root6 = new ModelRenderer(this);
		root6.setPos(-6.0F, 0.0F, 0.0F);
		root5.addChild(root6);
		root6.texOffs(26, 78).addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		root7 = new ModelRenderer(this);
		root7.setPos(0.0F, -1.0F, 4.0F);
		planr.addChild(root7);
		setRotationAngle(root7, 0.0F, 1.5708F, 0.0F);
		root7.texOffs(0, 86).addBox(-6.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);

		root8 = new ModelRenderer(this);
		root8.setPos(-6.0F, 0.0F, 0.0F);
		root7.addChild(root8);
		root8.texOffs(0, 76).addBox(-6.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		root9 = new ModelRenderer(this);
		root9.setPos(-6.0F, 0.0F, 0.0F);
		root8.addChild(root9);
		root9.texOffs(26, 78).addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		planr.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}