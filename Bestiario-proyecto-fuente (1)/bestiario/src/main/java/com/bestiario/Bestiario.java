package com.bestiario;

import com.bestiario.registry.ModEntities;
import com.bestiario.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * Bestiario: 5 nuevas criaturas para Minecraft (NeoForge 1.21).
 */
@Mod(Bestiario.MODID)
public class Bestiario {
    public static final String MODID = "bestiario";

    public Bestiario(IEventBus modEventBus) {
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
    }
}
