package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.EurekaEntity;
import net.akcraft.entity.custom.SkalterEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SkalterRenderer extends MobEntityRenderer<SkalterEntity, SkalterModel<SkalterEntity>> {

    public SkalterRenderer(EntityRendererFactory.Context context) {
        super(context, new SkalterModel<>(context.getPart(SkalterModel.SKADI_ALTER)), 0.25f);
    }

    @Override
    public Identifier getTexture(SkalterEntity entity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "textures/entity/operators/skadi_alter.png");
    }

    @Override
    public void render(SkalterEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
