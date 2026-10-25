#!/usr/bin/env python3
"""Genera las texturas de Bestiario respetando el mapa UV de los modelos vanilla.
Uso:  python3 tools/generate_textures.py   (requiere Pillow)"""
import os, random
from PIL import Image

OUT = os.path.join(os.path.dirname(__file__), "..", "src", "main", "resources",
                   "assets", "bestiario", "textures", "entity")
os.makedirs(OUT, exist_ok=True)


def clamp(v): return max(0, min(255, int(v)))
def mul(c, f): return tuple(clamp(v * f) for v in c[:3])


class Tex:
    def __init__(self, w, h, base, seed):
        self.w, self.h = w, h
        self.rng = random.Random(seed)
        self.img = Image.new("RGBA", (w, h), (0, 0, 0, 0))
        self.px = self.img.load()
        # Relleno de seguridad (opaco) para que nunca haya agujeros por UV desalineado
        self.rect(0, 0, w, h, base, 0.10)

    def put(self, x, y, c, a=255):
        if 0 <= x < self.w and 0 <= y < self.h:
            self.px[x, y] = (*c[:3], a)

    def rect(self, x, y, w, h, c, noise=0.08):
        for yy in range(y, y + h):
            for xx in range(x, x + w):
                self.put(xx, yy, mul(c, 1 + self.rng.uniform(-noise, noise)))

    def clear(self, x, y, w, h):
        for yy in range(y, y + h):
            for xx in range(x, x + w):
                if 0 <= xx < self.w and 0 <= yy < self.h:
                    self.px[xx, yy] = (0, 0, 0, 0)

    def box(self, u, v, w, h, d, c, top=None, bottom=None, noise=0.08):
        """Pinta las 6 caras de un cubo segun el desplegado UV de Minecraft."""
        self.rect(u + d, v, w, d, top or mul(c, 1.15), noise)               # arriba
        self.rect(u + d + w, v, w, d, bottom or mul(c, 0.7), noise)         # abajo
        self.rect(u, v + d, d, h, mul(c, 0.9), noise)                       # derecha
        self.rect(u + d, v + d, w, h, c, noise)                             # frente
        self.rect(u + d + w, v + d, d, h, mul(c, 0.9), noise)               # izquierda
        self.rect(u + 2 * d + w, v + d, w, h, mul(c, 0.8), noise)           # espalda

    def save(self, name):
        self.img.save(os.path.join(OUT, name))
        print("  ->", name)


# =============== JABALI SALVAJE (layout PigModel 64x32) ===============
def jabali():
    t = Tex(64, 32, (88, 62, 42), 1)
    t.box(0, 0, 8, 8, 8, (96, 68, 46), top=(58, 40, 28))           # cabeza
    t.box(16, 16, 4, 3, 1, (156, 116, 100))                         # hocico
    t.box(28, 8, 10, 16, 8, (82, 58, 40), top=(52, 36, 25))        # cuerpo
    t.box(0, 16, 4, 6, 4, (68, 48, 33))                             # patas
    # cerdas oscuras en el lomo
    for _ in range(60):
        t.put(36 + t.rng.randrange(10), 8 + t.rng.randrange(8), (48, 33, 22))
    # cara (frente de la cabeza = 8,8 / 8x8)
    for x, y in [(9, 11), (14, 11)]:
        t.put(x, y, (18, 12, 8))
    for x, y in [(9, 14), (9, 15), (14, 14), (14, 15)]:             # colmillos
        t.put(x, y, (238, 228, 200))
    for x, y in [(18, 18), (19, 18)]:                               # fosas nasales
        t.put(x, y, (48, 28, 28))
    # pezunas (ultima fila de la cara frontal de la pata: 4,20 / 4x6)
    t.rect(4, 25, 4, 1, (28, 20, 16), 0.0)
    t.save("jabali_salvaje.png")


# =============== PAVO SALVAJE (layout ChickenModel 64x32) ===============
def pavo():
    t = Tex(64, 32, (92, 60, 34), 2)
    t.box(0, 0, 4, 6, 3, (120, 148, 178), top=(96, 120, 150))       # cabeza azulada
    t.box(14, 0, 4, 2, 2, (226, 170, 60))                           # pico
    t.box(14, 4, 2, 2, 2, (192, 30, 30))                            # moco rojo
    t.box(0, 9, 6, 8, 6, (98, 62, 36), top=(70, 44, 26))            # cuerpo
    t.box(26, 0, 3, 5, 3, (224, 172, 60))                           # patas
    t.box(24, 13, 1, 4, 6, (70, 46, 28))                            # ala
    # plumaje en franjas bronce
    for y in range(9, 24):
        for x in range(0, 24):
            if t.px[x, y][3] and y % 3 == 0:
                t.put(x, y, mul(t.px[x, y], 0.78))
            elif t.px[x, y][3] and y % 3 == 1 and t.rng.random() < 0.25:
                t.put(x, y, (176, 120, 52))
    # ojos (frente de la cabeza = 3,3 / 4x6)
    t.put(3, 5, (14, 10, 8)); t.put(6, 5, (14, 10, 8))
    t.save("pavo_salvaje.png")


# =============== CENIZO (layout humanoide 64x64) ===============
def cenizo():
    t = Tex(64, 64, (40, 36, 36), 3)
    skin, shirt, pants = (48, 43, 43), (72, 67, 64), (30, 28, 30)
    t.box(0, 0, 8, 8, 8, skin, top=(34, 30, 30))                    # cabeza
    t.box(16, 16, 8, 12, 4, shirt)                                  # torso
    t.box(40, 16, 4, 12, 4, shirt)                                  # brazo der
    t.box(32, 48, 4, 12, 4, shirt)                                  # brazo izq
    t.box(0, 16, 4, 12, 4, pants)                                   # pierna der
    t.box(16, 48, 4, 12, 4, pants)                                  # pierna izq
    # manos de piel quemada (ultimas filas de brazos)
    for (u, v) in [(40, 16), (32, 48)]:
        t.rect(u + 4, v + 4 + 9, 4, 3, skin, 0.05)
    # grietas de brasa
    for _ in range(230):
        x, y = t.rng.randrange(0, 56), t.rng.randrange(0, 64)
        if t.px[x, y][3] and not (32 <= x and y < 16):
            r = t.rng.random()
            if r < 0.30: t.put(x, y, (255, 122, 30))
            elif r < 0.65: t.put(x, y, (150, 52, 20))
    # cara (frente de la cabeza = 8,8 / 8x8)
    for x, y in [(9, 12), (10, 12), (13, 12), (14, 12)]:
        t.put(x, y, (255, 178, 44))
    for x, y in [(9, 11), (10, 11), (13, 11), (14, 11)]:
        t.put(x, y, (14, 12, 12))
    for x in range(10, 14):
        t.put(x, 14, (120, 30, 14))
    t.clear(32, 0, 32, 16)                                          # capa "sombrero" transparente
    t.save("cenizo.png")


# =============== VIUDA DE LAS CUEVAS (layout SpiderModel 64x32) ===============
def viuda():
    t = Tex(64, 32, (24, 20, 32), 4)
    t.box(32, 4, 8, 8, 8, (30, 24, 40), top=(40, 30, 54))           # cabeza
    t.box(0, 0, 6, 6, 6, (32, 26, 44))                              # cuello
    t.box(0, 12, 10, 8, 12, (22, 18, 30), top=(26, 20, 36))         # abdomen
    t.box(18, 0, 16, 2, 2, (38, 32, 50))                            # patas
    # reflejos morados
    for _ in range(140):
        x, y = t.rng.randrange(0, 64), t.rng.randrange(0, 32)
        if t.px[x, y][3]:
            t.put(x, y, mul((96, 60, 140), t.rng.uniform(0.5, 1.0)))
    # reloj de arena rojo (cara superior del abdomen = 12,12 / 10x12)
    widths = [6, 4, 2, 2, 4, 6]
    for i, wd in enumerate(widths):
        y = 15 + i
        x0 = 17 - wd // 2
        for x in range(x0, x0 + wd):
            t.put(x, y, (210, 18, 42))
    # colmillos (frente de la cabeza = 40,12 / 8x8)
    t.put(43, 19, (232, 226, 214)); t.put(44, 19, (232, 226, 214))
    # bandas moradas en las patas
    for x in range(18, 34, 4):
        for y in range(0, 12):
            if t.px[x, y][3]:
                t.put(x, y, (70, 40, 110))
    t.save("viuda_de_las_cuevas.png")


# =============== ESPECTRO ERRANTE (layout esqueleto 64x32) ===============
def espectro():
    t = Tex(64, 32, (150, 170, 188), 5)
    bone = (176, 196, 210)
    robe = (62, 72, 94)
    t.box(0, 0, 8, 8, 8, bone, top=(210, 226, 236))                 # cabeza
    t.box(16, 16, 8, 12, 4, robe)                                   # tunica
    t.box(40, 16, 2, 12, 2, bone)                                   # brazos
    t.box(0, 16, 2, 12, 2, (120, 136, 160))                         # piernas
    # degradado de la tunica: mas clara arriba, oscura abajo
    for y in range(16, 32):
        for x in range(16, 40):
            p = t.px[x, y]
            if p[3]:
                f = 1.25 - 0.045 * (y - 16)
                t.put(x, y, mul(p, f))
    # jirones: agujeros transparentes en el borde inferior de la tunica
    for y in range(25, 28):
        for x in range(16, 40):
            if t.rng.random() < 0.18 + 0.12 * (y - 25):
                t.clear(x, y, 1, 1)
    # cara (frente de la cabeza = 8,8 / 8x8)
    for (x, y) in [(9, 11), (10, 11), (9, 12), (10, 12), (13, 11), (14, 11), (13, 12), (14, 12)]:
        t.put(x, y, (8, 10, 16))
    t.put(10, 12, (120, 255, 255)); t.put(13, 12, (120, 255, 255))
    for x in range(10, 14):
        t.put(x, 14, (14, 16, 24))
    t.clear(32, 0, 32, 16)                                          # capa "sombrero" transparente
    t.save("espectro_errante.png")


if __name__ == "__main__":
    print("Generando texturas...")
    jabali(); pavo(); cenizo(); viuda(); espectro()
    print("Listo.")
