package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.EurekaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EurekaRenderer extends MobEntityRenderer<EurekaEntity, EurekaModel<EurekaEntity>> {

    public EurekaRenderer(EntityRendererFactory.Context context) {
        super(context, new EurekaModel<>(context.getPart(EurekaModel.U_OFFICIAL)), 0.25f);
    }

    @Override
    public Identifier getTexture(EurekaEntity entity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "textures/entity/operators/u_official.png");
    }

    @Override
    public void render(EurekaEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
