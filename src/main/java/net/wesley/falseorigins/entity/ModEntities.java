package net.wesley.falseorigins.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wesley.falseorigins.FalseOrigins;
import net.wesley.falseorigins.entity.custom.AncientKnightEntity;

public class ModEntities {
    public static final EntityType<AncientKnightEntity> ANCIENTKNIGHT = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FalseOrigins.MOD_ID, "ancient_knight"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AncientKnightEntity::new)
                    .dimensions(EntityDimensions.fixed(2, 5)).build());
}
