package com.bestiario.event;

import com.bestiario.Bestiario;
import com.bestiario.entity.Cenizo;
import com.bestiario.entity.EspectroErrante;
import com.bestiario.entity.JabaliSalvaje;
import com.bestiario.entity.PavoSalvaje;
import com.bestiario.entity.ViudaDeLasCuevas;
import com.bestiario.registry.ModEntities;
import com.bestiario.registry.ModItems;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = Bestiario.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void onAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.JABALI_SALVAJE.get(), JabaliSalvaje.createAttributes().build());
        event.put(ModEntities.PAVO_SALVAJE.get(), PavoSalvaje.createAttributes().build());
        event.put(ModEntities.CENIZO.get(), Cenizo.createAttributes().build());
        event.put(ModEntities.VIUDA_DE_LAS_CUEVAS.get(), ViudaDeLasCuevas.createAttributes().build());
        event.put(ModEntities.ESPECTRO_ERRANTE.get(), EspectroErrante.createAttributes().build());
    }

    @SubscribeEvent
    public static void onSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.JABALI_SALVAJE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.PAVO_SALVAJE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.CENIZO.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        // La Viuda de las Cuevas solo aparece bajo tierra (Y < 50)
        event.register(ModEntities.VIUDA_DE_LAS_CUEVAS.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (type, level, reason, pos, random) ->
                        Monster.checkMonsterSpawnRules(type, level, reason, pos, random) && pos.getY() < 50,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(ModEntities.ESPECTRO_ERRANTE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    @SubscribeEvent
    public static void onCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.JABALI_SALVAJE_SPAWN_EGG.get());
            event.accept(ModItems.PAVO_SALVAJE_SPAWN_EGG.get());
            event.accept(ModItems.CENIZO_SPAWN_EGG.get());
            event.accept(ModItems.VIUDA_DE_LAS_CUEVAS_SPAWN_EGG.get());
            event.accept(ModItems.ESPECTRO_ERRANTE_SPAWN_EGG.get());
        }
    }
}
