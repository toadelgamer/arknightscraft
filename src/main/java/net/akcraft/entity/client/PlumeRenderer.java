package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.PlumeEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PlumeRenderer extends GeoEntityRenderer<PlumeEntity> {

    public PlumeRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PlumeModel());
    }

    @Override
    public Identifier getTextureLocation(PlumeEntity animatable) {
        return Identifier.of(ArknightsCraft.MOD_ID, "textures/entity/operators/plume.png");
    }

    @Override
    public void render(PlumeEntity entity, float entityYaw, float partialTick,
                       MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
