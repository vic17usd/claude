#!/usr/bin/env bash
set -e
echo "Compilando Bestiario (necesita Java 21 y conexion a internet)..."
./gradlew build
echo
echo "Si todo salio bien, tu mod esta en: build/libs/bestiario-1.0.0.jar"
