package com.bestiario.client;

import com.bestiario.entity.Cenizo;
import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelPart;

/** Modelo tipo zombi: brazos extendidos hacia delante cuando esta agresivo. */
public class CenizoModel extends AbstractZombieModel<Cenizo> {

    public CenizoModel(ModelPart root) {
        super(root);
    }

    @Override
    public boolean isAggressive(Cenizo entity) {
        return entity.isAggressive();
    }
}
