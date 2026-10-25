package com.bestiario.registry;

import com.bestiario.Bestiario;
import com.bestiario.entity.Cenizo;
import com.bestiario.entity.EspectroErrante;
import com.bestiario.entity.JabaliSalvaje;
import com.bestiario.entity.PavoSalvaje;
import com.bestiario.entity.ViudaDeLasCuevas;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Bestiario.MODID);

    // ---------- Animales ----------
    public static final DeferredHolder<EntityType<?>, EntityType<JabaliSalvaje>> JABALI_SALVAJE =
            ENTITY_TYPES.register("jabali_salvaje", () ->
                    EntityType.Builder.of(JabaliSalvaje::new, MobCategory.CREATURE)
                            .sized(0.95F, 0.9F)
                            .clientTrackingRange(10)
                            .build("jabali_salvaje"));

    public static final DeferredHolder<EntityType<?>, EntityType<PavoSalvaje>> PAVO_SALVAJE =
            ENTITY_TYPES.register("pavo_salvaje", () ->
                    EntityType.Builder.of(PavoSalvaje::new, MobCategory.CREATURE)
                            .sized(0.55F, 0.85F)
                            .clientTrackingRange(10)
                            .build("pavo_salvaje"));

    // ---------- Mobs hostiles ----------
    public static final DeferredHolder<EntityType<?>, EntityType<Cenizo>> CENIZO =
            ENTITY_TYPES.register("cenizo", () ->
                    EntityType.Builder.of(Cenizo::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .fireImmune()
                            .clientTrackingRange(8)
                            .build("cenizo"));

    public static final DeferredHolder<EntityType<?>, EntityType<ViudaDeLasCuevas>> VIUDA_DE_LAS_CUEVAS =
            ENTITY_TYPES.register("viuda_de_las_cuevas", () ->
                    EntityType.Builder.of(ViudaDeLasCuevas::new, MobCategory.MONSTER)
                            .sized(1.2F, 0.8F)
                            .clientTrackingRange(8)
                            .build("viuda_de_las_cuevas"));

    public static final DeferredHolder<EntityType<?>, EntityType<EspectroErrante>> ESPECTRO_ERRANTE =
            ENTITY_TYPES.register("espectro_errante", () ->
                    EntityType.Builder.of(EspectroErrante::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .build("espectro_errante"));
}
