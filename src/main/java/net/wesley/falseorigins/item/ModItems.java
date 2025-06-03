package net.wesley.falseorigins.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.wesley.falseorigins.entity.ModEntities;

import static software.bernie.example.registry.ItemRegistry.registerItem;

public class ModItems {
    public static final Item ANCIENT_KNIGHT_SPAWN_EGG = registerItem("Ancient_Knight_spawn_egg",
            new SpawnEggItem(ModEntities.ANCIENTKNIGHT, 0x96834D, 0x3C291A, new FabricItemSettings()));
}
