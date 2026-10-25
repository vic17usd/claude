package com.bestiario.client;

import com.bestiario.Bestiario;
import com.bestiario.entity.EspectroErrante;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

/** Usa la silueta delgada del esqueleto con una textura fantasmal. */
public class EspectroRenderer extends HumanoidMobRenderer<EspectroErrante, HumanoidModel<EspectroErrante>> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Bestiario.MODID, "textures/entity/espectro_errante.png");

    public EspectroRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.SKELETON)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EspectroErrante entity) {
        return TEXTURE;
    }
}
