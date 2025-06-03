package net.wesley.falseorigins.entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.wesley.falseorigins.FalseOrigins;
import net.wesley.falseorigins.entity.custom.AncientKnightEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class AncientKnightModel extends GeoModel<AncientKnightEntity> {
    @Override
    public Identifier getModelResource(AncientKnightEntity ancientKnightEntity) {
        return new Identifier(FalseOrigins.MOD_ID, "geo/ancient_knight.geo.json");
    }

    @Override
    public Identifier getTextureResource(AncientKnightEntity ancientKnightEntity) {
        return new Identifier(FalseOrigins.MOD_ID, "textures/entity/ancient_knight.png");
    }

    @Override
    public Identifier getAnimationResource(AncientKnightEntity ancientKnightEntity) {
        return new Identifier(FalseOrigins.MOD_ID, "animations/ancient_knight.animation.json");
    }

    @Override
    public void setCustomAnimations(AncientKnightEntity animatable, long instanceId, AnimationState<AncientKnightEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("h_head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
