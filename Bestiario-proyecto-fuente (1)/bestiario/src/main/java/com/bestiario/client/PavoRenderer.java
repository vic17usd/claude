package com.bestiario.client;

import com.bestiario.Bestiario;
import com.bestiario.entity.PavoSalvaje;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PavoRenderer extends MobRenderer<PavoSalvaje, ChickenModel<PavoSalvaje>> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Bestiario.MODID, "textures/entity/pavo_salvaje.png");

    public PavoRenderer(EntityRendererProvider.Context context) {
        super(context, new ChickenModel<>(context.bakeLayer(ModelLayers.CHICKEN)), 0.4F);
    }

    @Override
    protected void scale(PavoSalvaje entity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(1.35F, 1.35F, 1.35F);
    }

    /** El modelo de gallina usa este valor para aletear; con 0 las alas quedan quietas. */
    @Override
    protected float getBob(PavoSalvaje entity, float partialTick) {
        return 0.0F;
    }

    @Override
    public ResourceLocation getTextureLocation(PavoSalvaje entity) {
        return TEXTURE;
    }
}
