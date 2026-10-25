package com.bestiario.registry;

import com.bestiario.Bestiario;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Bestiario.MODID);

    public static final DeferredItem<Item> JABALI_SALVAJE_SPAWN_EGG = ITEMS.register("jabali_salvaje_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.JABALI_SALVAJE, 0x5A3E2A, 0xE8DCC0, new Item.Properties()));

    public static final DeferredItem<Item> PAVO_SALVAJE_SPAWN_EGG = ITEMS.register("pavo_salvaje_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.PAVO_SALVAJE, 0x603C22, 0xB82020, new Item.Properties()));

    public static final DeferredItem<Item> CENIZO_SPAWN_EGG = ITEMS.register("cenizo_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.CENIZO, 0x2E2A2A, 0xFF7818, new Item.Properties()));

    public static final DeferredItem<Item> VIUDA_DE_LAS_CUEVAS_SPAWN_EGG = ITEMS.register("viuda_de_las_cuevas_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.VIUDA_DE_LAS_CUEVAS, 0x1A1424, 0xC81428, new Item.Properties()));

    public static final DeferredItem<Item> ESPECTRO_ERRANTE_SPAWN_EGG = ITEMS.register("espectro_errante_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.ESPECTRO_ERRANTE, 0x3C465A, 0x78FFFF, new Item.Properties()));
}
