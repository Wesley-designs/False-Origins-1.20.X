package net.wesley.falseorigins;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.wesley.falseorigins.entity.ModEntities;
import net.wesley.falseorigins.entity.custom.AncientKnightEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FalseOrigins implements ModInitializer {
	public static final String MOD_ID = "false-origins";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.ANCIENTKNIGHT, AncientKnightEntity.setAttributes());
	}
}