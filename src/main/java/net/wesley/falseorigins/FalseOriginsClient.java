package net.wesley.falseorigins;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.wesley.falseorigins.entity.ModEntities;
import net.wesley.falseorigins.entity.client.AncientKnightRenderer;

public class FalseOriginsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.ANCIENTKNIGHT, AncientKnightRenderer::new);
    }
}
