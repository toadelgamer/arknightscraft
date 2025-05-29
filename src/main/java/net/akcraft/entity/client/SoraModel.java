package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.SoraEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SoraModel<T extends SoraEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer SORA = new EntityModelLayer(Identifier.of(ArknightsCraft.MOD_ID, "sora"), "main");

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    public SoraModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("body");
        this.head = this.body.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(32, 0).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.3F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

        ModelPartData ears = head.addChild("ears", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.5F));

        ModelPartData l3_r1 = ears.addChild("l3_r1", ModelPartBuilder.create().uv(62, 22).mirrored().cuboid(-0.4F, -1.9F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.2F, -7.65F, -1.75F, 0.0175F, 0.0F, -0.3927F));

        ModelPartData l2_r1 = ears.addChild("l2_r1", ModelPartBuilder.create().uv(66, 22).mirrored().cuboid(-0.5F, -3.0F, -0.25F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.05F, -7.55F, -1.75F, 0.0175F, 0.0F, -0.3927F));

        ModelPartData l1_r1 = ears.addChild("l1_r1", ModelPartBuilder.create().uv(58, 60).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.1F, -7.55F, -1.0F, 0.0F, 0.0F, -0.3927F));

        ModelPartData r3_r1 = ears.addChild("r3_r1", ModelPartBuilder.create().uv(62, 22).mirrored().cuboid(-1.0F, -1.8F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.6F, -7.45F, -1.25F, 0.0175F, 0.0F, 0.3927F));

        ModelPartData r2_r1 = ears.addChild("r2_r1", ModelPartBuilder.create().uv(66, 22).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(4.0F, -8.45F, -1.0F, 0.0175F, 0.0F, 0.3927F));

        ModelPartData r1_r1 = ears.addChild("r1_r1", ModelPartBuilder.create().uv(58, 60).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, -7.45F, -1.0F, 0.0F, 0.0F, 0.3927F));

        ModelPartData twintails = head.addChild("twintails", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right = twintails.addChild("right", ModelPartBuilder.create().uv(62, 29).cuboid(-1.0F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -7.0F, 0.0F));

        ModelPartData tr4_r1 = right.addChild("tr4_r1", ModelPartBuilder.create().uv(62, 27).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.35F, 5.0F, 0.0F, 0.0F, 0.0F, 0.4189F));

        ModelPartData tr3_r1 = right.addChild("tr3_r1", ModelPartBuilder.create().uv(58, 52).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.05F, 3.35F, 0.0F, 0.0F, 0.0F, 0.4189F));

        ModelPartData tr2_r1 = right.addChild("tr2_r1", ModelPartBuilder.create().uv(56, 9).cuboid(-1.55F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.2F, 0.35F, 0.0F, 0.0F, 0.0F, 0.5934F));

        ModelPartData rbow2_r1 = right.addChild("rbow2_r1", ModelPartBuilder.create().uv(62, 16).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, 0.0F, -1.0F, 0.0F, 0.3927F, 0.5934F));

        ModelPartData rbow1_r1 = right.addChild("rbow1_r1", ModelPartBuilder.create().uv(62, 16).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, 0.0F, 1.0F, 0.0F, -0.3927F, 0.5934F));

        ModelPartData left = twintails.addChild("left", ModelPartBuilder.create().uv(63, 62).cuboid(0.0F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -7.0F, 0.0F));

        ModelPartData tl4_r1 = left.addChild("tl4_r1", ModelPartBuilder.create().uv(62, 25).cuboid(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.35F, 5.0F, 0.0F, 0.0F, 0.0F, -0.4189F));

        ModelPartData tl3_r1 = left.addChild("tl3_r1", ModelPartBuilder.create().uv(58, 52).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.05F, 3.35F, 0.0F, 0.0F, 0.0F, -0.4189F));

        ModelPartData tl2_r1 = left.addChild("tl2_r1", ModelPartBuilder.create().uv(56, 40).cuboid(-1.45F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.2F, 0.35F, 0.0F, 0.0F, 0.0F, -0.5934F));

        ModelPartData lbow2_r1 = left.addChild("lbow2_r1", ModelPartBuilder.create().uv(62, 16).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.75F, 0.0F, 1.0F, 0.0F, 0.3927F, -0.5934F));

        ModelPartData lbow1_r1 = left.addChild("lbow1_r1", ModelPartBuilder.create().uv(62, 19).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, 0.0F, -1.0F, 0.0F, -0.3927F, -0.5934F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.5F, 0.5F, -0.3927F, 0.0F, 0.0F));

        ModelPartData t5_r1 = tail.addChild("t5_r1", ModelPartBuilder.create().uv(59, 56).cuboid(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 4.55F, 10.0F, -0.3927F, 0.0F, 0.0F));

        ModelPartData t4_r1 = tail.addChild("t4_r1", ModelPartBuilder.create().uv(57, 32).cuboid(-0.5F, -1.7F, 0.0F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 3.0F, 5.75F, -0.3927F, 0.0F, 0.0F));

        ModelPartData t3_r1 = tail.addChild("t3_r1", ModelPartBuilder.create().uv(57, 0).cuboid(-1.0F, -2.0F, 0.0F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 1.05F, 1.75F, -0.3927F, 0.0F, 0.0F));

        ModelPartData t2_r1 = tail.addChild("t2_r1", ModelPartBuilder.create().uv(59, 47).cuboid(-0.5F, -1.3F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, 0.25F, -0.3927F, 0.0F, 0.0F));

        ModelPartData left_arm = root.addChild("left_arm", ModelPartBuilder.create().uv(16, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(30, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));

        ModelPartData right_arm = root.addChild("right_arm", ModelPartBuilder.create().uv(48, 16).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(44, 48).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

        ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(32, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(40, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));

        ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(24, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 64);
    }
    @Override
    public void setAngles(SoraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(SoraAnimations.SORA_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, SoraAnimations.SORA_IDLE, entity.age, 1f);
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
