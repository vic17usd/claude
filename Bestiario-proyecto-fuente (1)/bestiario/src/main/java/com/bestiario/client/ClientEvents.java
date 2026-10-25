package com.bestiario.client;

import com.bestiario.Bestiario;
import com.bestiario.registry.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Bestiario.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.JABALI_SALVAJE.get(), JabaliRenderer::new);
        event.registerEntityRenderer(ModEntities.PAVO_SALVAJE.get(), PavoRenderer::new);
        event.registerEntityRenderer(ModEntities.CENIZO.get(), CenizoRenderer::new);
        event.registerEntityRenderer(ModEntities.VIUDA_DE_LAS_CUEVAS.get(), ViudaRenderer::new);
        event.registerEntityRenderer(ModEntities.ESPECTRO_ERRANTE.get(), EspectroRenderer::new);
    }
}
