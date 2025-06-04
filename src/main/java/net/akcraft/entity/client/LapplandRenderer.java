package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.LapplandEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LapplandRenderer extends GeoEntityRenderer<LapplandEntity> {

    public LapplandRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new LapplandModel());
    }

    @Override
    public Identifier getTextureLocation(LapplandEntity animatable) {
        return Identifier.of(ArknightsCraft.MOD_ID, "textures/entity/operators/lappland.png");
    }

    @Override
    public void render(LapplandEntity entity, float entityYaw, float partialTick,
                       MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
