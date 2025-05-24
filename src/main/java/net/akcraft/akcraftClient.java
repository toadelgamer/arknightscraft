package net.akcraft;

import net.akcraft.entity.ModEntities;
import net.akcraft.entity.client.EurekaModel;
import net.akcraft.entity.client.EurekaRenderer;
import net.akcraft.entity.client.SlugModel;
import net.akcraft.entity.client.SlugRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class akcraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(EurekaModel.U_OFFICIAL, EurekaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.U_OFFICIAL, EurekaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(SlugModel.ORIGINIUM_SLUG, SlugModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ORIGINIUM_SLUG, SlugRenderer::new);
    }
}
