# Juego de Memoria en Java

Este proyecto implementa un juego de memoria (también conocido como "Memory" o "Concentration") utilizando Java con interfaz gráfica Swing.

## Descripción

El juego de memoria consiste en encontrar pares de cartas coincidentes en un tablero donde todas las cartas están inicialmente boca abajo. El jugador puede voltear dos cartas por turno, y si coinciden, se mantienen boca arriba. El objetivo es encontrar todos los pares con la menor cantidad de intentos posible.

## Características

- Interfaz gráfica intuitiva con Java Swing
- Diferentes niveles de dificultad (ajustable por número de pares)
- Sistema de puntuación basado en intentos
- Efectos visuales para mejorar la experiencia de usuario
- Cartas con diseño personalizado y visualmente distintivo

## Capturas de Pantalla

*[Agregar capturas de pantalla del juego]*

## Requisitos

- Java 8 o superior
- IDE Java (recomendado: Eclipse, IntelliJ IDEA o NetBeans)

## Instalación

1. Clona este repositorio:
   ```
   git clone https://github.com/tu-usuario/juego-memoria-java.git
   ```
2. Abre el proyecto en tu IDE de preferencia
3. Ejecuta la clase principal `JuegoMemoria.java`

## Estructura del Proyecto

- `src/` - Código fuente
  - `Carta.java` - Clase que representa cada carta del juego
  - `JuegoMemoria.java` - Clase principal con la lógica del juego
  - `Tablero.java` - Clase que gestiona el tablero de juego
  - `Recursos.java` - Clase utilitaria para gestionar recursos (imágenes)
- `resources/` - Recursos del juego
  - `images/` - Imágenes de las cartas y reversos

## Cómo Jugar

1. Inicia el juego ejecutando `JuegoMemoria.java`
2. Selecciona el nivel de dificultad (si aplica)
3. Haz clic en las cartas para voltearlas
4. Encuentra todos los pares de cartas con la menor cantidad de intentos posible
5. El juego termina cuando todos los pares han sido encontrados

## Personalización

Puedes personalizar el juego modificando:
- Las imágenes en la carpeta `resources/images/`
- El tamaño del tablero en `JuegoMemoria.java`
- Las reglas del juego ajustando la lógica en la clase principal
