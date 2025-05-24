package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.SlugEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SlugRenderer extends MobEntityRenderer<SlugEntity, SlugModel<SlugEntity>> {

    public SlugRenderer(EntityRendererFactory.Context context) {
        super(context, new SlugModel<>(context.getPart(SlugModel.ORIGINIUM_SLUG)), 0.25f);
    }

    @Override
    public Identifier getTexture(SlugEntity entity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "textures/entity/originium_slug.png");
    }

    @Override
    public void render(SlugEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(3f, 3f, 3f);
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
