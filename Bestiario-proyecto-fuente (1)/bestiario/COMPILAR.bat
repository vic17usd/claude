@echo off
echo Compilando Bestiario (necesita Java 21 instalado y conexion a internet)...
call gradlew.bat build
echo.
echo Si todo salio bien, tu mod esta en: build\libs\bestiario-1.0.0.jar
pause
