package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.EurekaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;


public class EurekaModel<T extends EurekaEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer U_OFFICIAL = new EntityModelLayer(Identifier.of(ArknightsCraft.MOD_ID, "u_official"), "main");

    private final ModelPart root;
    private final ModelPart head;

    public EurekaModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modeldata = new ModelData();
        ModelPartData modelpartdata = modeldata.getRoot();
        ModelPartData root = modelpartdata.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData headphones = head.addChild("headphones", ModelPartBuilder.create().uv(74, 14).cuboid(-4.5F, -8.0F, -0.75F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(74, 14).mirrored().cuboid(3.5F, -8.0F, -0.75F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(64, 0).cuboid(-4.0F, -8.75F, -0.75F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.5F));

        ModelPartData cube_r1 = headphones.addChild("cube_r1", ModelPartBuilder.create().uv(64, 9).mirrored().cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(64, 9).cuboid(-9.0F, -3.0F, -1.0F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -2.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData hair = head.addChild("hair", ModelPartBuilder.create().uv(75, 10).cuboid(3.75F, -5.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(75, 10).mirrored().cuboid(-5.75F, -5.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r2 = hair.addChild("cube_r2", ModelPartBuilder.create().uv(64, 4).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.75F, -6.25F, 1.5F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube_r3 = hair.addChild("cube_r3", ModelPartBuilder.create().uv(76, 4).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, -0.75F, 2.0F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube_r4 = hair.addChild("cube_r4", ModelPartBuilder.create().uv(76, 4).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -0.75F, 2.0F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube_r5 = hair.addChild("cube_r5", ModelPartBuilder.create().uv(64, 4).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.75F, -6.25F, 1.5F, 0.0F, 0.0F, -0.3927F));

        ModelPartData left_arm = root.addChild("left_arm", ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));

        ModelPartData right_arm = root.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(40, 32).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

        ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));

        ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

        return TexturedModelData.of(modeldata, 128, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public void setAngles(EurekaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);

        this.animateMovement(EurekaAnimations.U_OFFICIAL_WALK, limbAngle, limbDistance, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, EurekaAnimations.U_OFFICIAL_IDLE, entity.age, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 25.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

}
