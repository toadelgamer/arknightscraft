package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.SlugEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SlugModel<T extends SlugEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer ORIGINIUM_SLUG = new EntityModelLayer(Identifier.of(ArknightsCraft.MOD_ID, "originium_slug"), "main");

    private final ModelPart root;

    public SlugModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 7).cuboid(-1.5F, -1.5F, -2.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -2.0F, -2.5F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 13).cuboid(-1.5F, -2.5F, -2.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(16, 7).cuboid(-0.75F, -3.0F, -1.5F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -0.5F));

        ModelPartData spikes = body.addChild("spikes", ModelPartBuilder.create().uv(16, 16).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.5F));

        ModelPartData cube_r1 = spikes.addChild("cube_r1", ModelPartBuilder.create().uv(0, 19).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.75F, 2.25F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r2 = spikes.addChild("cube_r2", ModelPartBuilder.create().uv(16, 12).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, -1.5F, 0.7854F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(SlugEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.updateAnimation(entity.idleAnimationState, SlugAnimations.SLUG_IDLE, ageInTicks, 1f);
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
