# Bestiario — mod para Minecraft 1.21 (NeoForge 21.0.167)

Añade **5 criaturas nuevas**, con huevos generadores, botín propio y reglas de aparición.

| Criatura | Tipo | Comportamiento | Dónde aparece |
|---|---|---|---|
| **Jabalí Salvaje** | Animal neutral | Embiste si lo atacas (y avisa a su manada). Las crías huyen. Se cría con zanahoria, patata o remolacha. | Bosques, taigas, llanuras |
| **Pavo Salvaje** | Animal pasivo | Huye al ser herido, planea al caer (sin daño), pone huevos. Se cría con semillas. | Bosques, llanuras, prados |
| **Cenizo** | Hostil | Inmune al fuego/lava. Prende fuego a quien golpea. Suelta humo y brasas. El agua y la lluvia lo dañan. Ataca a jugadores y aldeanos. | Badlands, sabanas, desiertos |
| **Viuda de las Cuevas** | Hostil | Araña que trepa paredes. Su picadura envenena (Normal/Difícil) y debilita. Solo bajo tierra (Y < 50). | Cuevas de todo el Overworld |
| **Espectro Errante** | Hostil | Al ser golpeado, a veces se teletransporta DETRÁS de ti. Sus golpes causan Oscuridad. | Pantanos, bosque oscuro, taigas |

Los huevos están en la pestaña creativa **Huevos generadores**:
`/summon bestiario:cenizo` · `/summon bestiario:jabali_salvaje` · etc.

## Compilar

**Opción A – en tu PC** (Java 21 + internet):
- Windows: doble clic en `COMPILAR.bat`
- Linux/Mac: `./compilar.sh`

El .jar queda en `build/libs/bestiario-1.0.0.jar` → cópialo a la carpeta `mods` de tu instancia NeoForge 1.21 (21.0.167).

**Opción B – sin instalar nada:** sube esta carpeta a un repositorio de GitHub. La pestaña *Actions* compila sola y te deja el .jar descargable (artifact `bestiario-jar`).

## Estructura
- `src/main/java/com/bestiario/entity` → la lógica/IA de cada criatura
- `src/main/java/com/bestiario/client` → renderizado
- `src/main/resources/data/bestiario` → botín, hábitats y reglas de aparición
- `tools/generate_textures.py` → regenera las texturas (Pillow)
