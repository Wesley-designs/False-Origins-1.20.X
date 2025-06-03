package net.wesley.falseorigins.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.wesley.falseorigins.FalseOrigins;
import net.wesley.falseorigins.entity.custom.AncientKnightEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.IdentityHashMap;

public class AncientKnightRenderer extends GeoEntityRenderer<AncientKnightEntity> {
    public AncientKnightRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new AncientKnightModel());
    }


    @Override
    public Identifier getTextureLocation(AncientKnightEntity animatable) {
        return new Identifier(FalseOrigins.MOD_ID, "textures/entity/ancient_knight.png");
    }
}
