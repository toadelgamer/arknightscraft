package net.akcraft.entity.client;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.LapplandEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class LapplandModel extends GeoModel<LapplandEntity> {

    @Override
    public Identifier getModelResource(LapplandEntity lapplandEntity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "geo/lappland.geo.json");
    }

    @Override
    public Identifier getTextureResource(LapplandEntity lapplandEntity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "textures/entity/operators/lappland.png");
    }

    @Override
    public Identifier getAnimationResource(LapplandEntity lapplandEntity) {
        return Identifier.of(ArknightsCraft.MOD_ID, "animations/lappland.animation.json");
    }

    @Override
    public void setCustomAnimations(LapplandEntity animatable, long instanceId, AnimationState<LapplandEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
