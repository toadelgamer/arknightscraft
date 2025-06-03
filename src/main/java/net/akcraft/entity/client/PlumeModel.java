package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.PlumeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PlumeModel extends GeoModel<PlumeEntity> {

    @Override
    public Identifier getModelResource(PlumeEntity plumeEntity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "geo/plume.geo.json");
    }

    @Override
    public Identifier getTextureResource(PlumeEntity plumeEntity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "textures/entity/operators/plume.png");
    }

    @Override
    public Identifier getAnimationResource(PlumeEntity plumeEntity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "animations/plume.animation.json");
    }

    @Override
    public void setCustomAnimations(PlumeEntity animatable, long instanceId, AnimationState<PlumeEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
