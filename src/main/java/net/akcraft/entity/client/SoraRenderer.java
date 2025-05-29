package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.SkalterEntity;
import net.akcraft.entity.custom.SoraEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SoraRenderer extends MobEntityRenderer<SoraEntity, SoraModel<SoraEntity>> {

    public SoraRenderer(EntityRendererFactory.Context context) {
        super(context, new SoraModel<>(context.getPart(SoraModel.SORA)), 0.25f);
    }

    @Override
    public Identifier getTexture(SoraEntity entity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "textures/entity/operators/sora.png");
    }

    @Override
    public void render(SoraEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
