package com.bestiario.client;

import com.bestiario.Bestiario;
import com.bestiario.entity.JabaliSalvaje;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JabaliRenderer extends MobRenderer<JabaliSalvaje, PigModel<JabaliSalvaje>> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Bestiario.MODID, "textures/entity/jabali_salvaje.png");

    public JabaliRenderer(EntityRendererProvider.Context context) {
        super(context, new PigModel<>(context.bakeLayer(ModelLayers.PIG)), 0.7F);
    }

    @Override
    protected void scale(JabaliSalvaje entity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(1.1F, 1.1F, 1.1F);
    }

    @Override
    public ResourceLocation getTextureLocation(JabaliSalvaje entity) {
        return TEXTURE;
    }
}
