package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.SkalterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SkalterModel<T extends SkalterEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer SKADI_ALTER = new EntityModelLayer(Identifier.of(ArknightsCraft.MOD_ID, "skadi_alter"), "main");

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    public SkalterModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("body");
        this.head = this.body.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(32, 22).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(32, 38).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 11).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 27).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.35F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

        ModelPartData hat = head.addChild("hat", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -8.25F, -3.5F, 10.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, -1.5F));

        ModelPartData up = hat.addChild("up", ModelPartBuilder.create().uv(32, 11).cuboid(-8.5F, -4.0F, -0.5F, 9.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -6.0F, -2.5F));

        ModelPartData u5_r1 = up.addChild("u5_r1", ModelPartBuilder.create().uv(28, 59).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -8.4F, 5.15F, 0.1047F, 0.0F, 0.0F));

        ModelPartData u4_r1 = up.addChild("u4_r1", ModelPartBuilder.create().uv(68, 12).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -6.65F, 4.55F, -0.0175F, 0.0F, 0.0F));

        ModelPartData u3_r1 = up.addChild("u3_r1", ModelPartBuilder.create().uv(64, 61).cuboid(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, -5.65F, 2.55F, -0.3054F, 0.0F, 0.0F));

        ModelPartData u2_r1 = up.addChild("u2_r1", ModelPartBuilder.create().uv(40, 0).cuboid(-6.0F, -2.0F, -1.0F, 7.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -3.9F, 1.3F, -0.0873F, 0.0F, 0.0F));

        ModelPartData left = hat.addChild("left", ModelPartBuilder.create(), ModelTransform.pivot(2.9F, -7.9F, 4.0F));

        ModelPartData left3_r1 = left.addChild("left3_r1", ModelPartBuilder.create().uv(40, 9).cuboid(5.0F, -0.25F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        ModelPartData left2_r1 = left.addChild("left2_r1", ModelPartBuilder.create().uv(68, 5).cuboid(4.0F, -0.25F, -3.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.9F, 0.0F, -1.0F, 0.0F, 0.0F, -0.1047F));

        ModelPartData left_r1 = left.addChild("left_r1", ModelPartBuilder.create().uv(64, 54).cuboid(2.0F, -0.25F, -3.0F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-1.9F, 0.3F, -2.5F, 0.0F, 0.0F, -0.1309F));

        ModelPartData right = hat.addChild("right", ModelPartBuilder.create(), ModelTransform.pivot(-8.75F, -8.15F, 2.0F));

        ModelPartData right3_r1 = right.addChild("right3_r1", ModelPartBuilder.create().uv(40, 9).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        ModelPartData right2_r1 = right.addChild("right2_r1", ModelPartBuilder.create().uv(68, 5).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.95F, 0.35F, -1.0F, 0.0F, 0.0F, 0.1745F));

        ModelPartData right_r1 = right.addChild("right_r1", ModelPartBuilder.create().uv(64, 54).cuboid(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.75F, 0.9F, -2.5F, 0.0F, 0.0F, 0.1745F));

        ModelPartData front = hat.addChild("front", ModelPartBuilder.create(), ModelTransform.of(-2.5F, -8.15F, -4.05F, 0.0873F, 0.0F, 0.0F));

        ModelPartData front3_r1 = front.addChild("front3_r1", ModelPartBuilder.create().uv(40, 9).cuboid(2.0F, -0.25F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4102F, 0.0F, 0.0F));

        ModelPartData front2_r1 = front.addChild("front2_r1", ModelPartBuilder.create().uv(68, 9).cuboid(0.0F, -0.25F, -4.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.3F, 0.8F, -0.4102F, 0.0F, 0.0F));

        ModelPartData front_r1 = front.addChild("front_r1", ModelPartBuilder.create().uv(69, 1).cuboid(-3.0F, -0.25F, -4.0F, 6.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, 0.65F, 1.8F, -0.3927F, 0.0F, 0.0F));

        ModelPartData left_arm = root.addChild("left_arm", ModelPartBuilder.create().uv(56, 22).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 59).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));

        ModelPartData right_arm = root.addChild("right_arm", ModelPartBuilder.create().uv(56, 38).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(14, 59).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

        ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(0, 43).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(32, 54).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));

        ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(16, 43).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(48, 54).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(SkalterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(SkalterAnimations.SKALTER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, SkalterAnimations.SKALTER_IDLE, entity.age, 1f);
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 25.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }
    @Override
    public ModelPart getPart() {
        return root;
    }
}
