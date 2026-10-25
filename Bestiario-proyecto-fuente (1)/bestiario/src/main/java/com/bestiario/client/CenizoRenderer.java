package com.bestiario.client;

import com.bestiario.Bestiario;
import com.bestiario.entity.Cenizo;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CenizoRenderer extends HumanoidMobRenderer<Cenizo, CenizoModel> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Bestiario.MODID, "textures/entity/cenizo.png");

    public CenizoRenderer(EntityRendererProvider.Context context) {
        super(context, new CenizoModel(context.bakeLayer(ModelLayers.ZOMBIE)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Cenizo entity) {
        return TEXTURE;
    }
}
