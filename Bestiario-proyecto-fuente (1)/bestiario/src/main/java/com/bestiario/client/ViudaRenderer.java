package com.bestiario.client;

import com.bestiario.Bestiario;
import com.bestiario.entity.ViudaDeLasCuevas;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;

/** Reutiliza el modelo y los ojos rojos brillantes de la arana vanilla. */
public class ViudaRenderer extends SpiderRenderer<ViudaDeLasCuevas> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Bestiario.MODID, "textures/entity/viuda_de_las_cuevas.png");

    public ViudaRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.8F;
    }

    @Override
    protected void scale(ViudaDeLasCuevas entity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(0.85F, 0.85F, 0.85F);
    }

    @Override
    public ResourceLocation getTextureLocation(ViudaDeLasCuevas entity) {
        return TEXTURE;
    }
}
