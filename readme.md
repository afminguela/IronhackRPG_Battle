[DeepWiki documentation](https://deepwiki.com/afminguela/IronhackRPG_Battle)
# Documentación del Proyecto IronhackRPG_Battle

## Español

### Descripción General
IronhackRPG_Battle es un juego de rol por texto desarrollado como parte de un ejercicio académico para Ironhack. El juego permite crear personajes de diferentes clases y hacer que se enfrenten en batallas por turnos. Cada personaje tiene atributos únicos que influyen en sus capacidades de combate.

### Estructura del Proyecto

#### Clase Character (Abstracta)
Clase base para todos los tipos de personajes del juego.

**Atributos:**
- `id` (String): Identificador único generado automáticamente mediante UUID.
- `name` (String): Nombre del personaje.
- `hp` (int): Puntos de vida del personaje. Rango específico según clase (100-200 para guerreros, 50-100 para magos).
- `isAlive` (boolean): Estado vital del personaje (por defecto true).

**Métodos:**
- `RandomId()`: Genera un identificador único.
- `getInfo()`: Devuelve información básica del personaje.
- `attack(Character enemy)`: Método para atacar a otro personaje.
- Getters y Setters con validaciones específicas para cada tipo de personaje.

#### Clase Warrior (Guerrero)
Extiende la clase Character e implementa la interfaz Attack.

**Atributos específicos:**
- `stamina` (int): Resistencia, determina la capacidad de realizar ataques consecutivos.
- `strength` (int): Fuerza, determina el daño base de los ataques.

**Métodos específicos:**
- `attack(Character enemy)`: Implementación específica con dos tipos de ataques:
  - Ataque pesado: Consume 5 de stamina, hace daño igual a la fuerza.
  - Ataque débil: Consume 1 de stamina, hace la mitad del daño.
  - Recuperación: Si no tiene suficiente stamina, recupera 2 puntos.

#### Clase Wizard (Mago)
Extiende la clase Character e implementa la interfaz Attack.

**Atributos específicos:**
- `mana` (int): Recurso mágico para lanzar hechizos.
- `intelligence` (int): Afecta el poder de sus hechizos.

**Métodos específicos:**
- `attack(Character enemy)`: Implementación con:
  - Bola de fuego: Consume 5 de mana, hace daño igual a la inteligencia.
  - Golpe de bastón: Consume 1 de mana, hace daño menor.
  - Recuperación: Si no tiene mana suficiente, recupera 2 puntos.

#### Interfaz Attack
Define el método de ataque que deben implementar todas las clases de personajes:
- `void attack(Character enemy)`: Método para atacar a un personaje enemigo.

### Flujo del Juego

#### GameLauncher
Clase principal que inicia el juego con un menú principal con tres opciones:
1. Crear personajes
2. Ir directamente a combate
3. Salir

#### MenuCreateCharacter
Gestiona la creación de personajes con las opciones:
1. Crear personajes personalizados (con nombre elegido por el usuario)
2. Crear personajes aleatorios
3. Mostrar personajes creados
4. Volver al menú principal

#### MenuFight
Gestiona los combates entre personajes con las opciones:
1. Elegir personajes manualmente para combatir
2. Batalla con personajes aleatorios
3. Mostrar personajes disponibles
4. Volver al menú principal

#### Sistema de Combate
El combate se desarrolla por turnos donde:
- Los personajes atacan alternadamente.
- El daño depende de los atributos del atacante.
- Se consumen recursos (stamina o mana) al atacar.
- El combate continúa hasta que uno de los personajes muere (HP ≤ 0).
- Al finalizar se muestra un mensaje con el ganador y un apodo aleatorio humorístico.

### Requisitos Técnicos
- Java 17 (según el archivo pom.xml)
- Compilación con Maven
- IDE compatible con Java (como IntelliJ IDEA)

## English

### General Description
IronhackRPG_Battle is a text-based role-playing game developed as part of an academic exercise for Ironhack. The game allows players to create characters of different classes and make them battle in turn-based combat. Each character has unique attributes that influence their combat capabilities.

### Project Structure

#### Character Class (Abstract)
Base class for all character types in the game.

**Attributes:**
- `id` (String): Automatically generated unique identifier using UUID.
- `name` (String): Character's name.
- `hp` (int): Health points. Specific range by class (100-200 for warriors, 50-100 for wizards).
- `isAlive` (boolean): Character's vital status (default true).

**Methods:**
- `RandomId()`: Generates a unique identifier.
- `getInfo()`: Returns basic character information.
- `attack(Character enemy)`: Method to attack another character.
- Getters and Setters with specific validations for each character type.

#### Warrior Class
Extends the Character class and implements the Attack interface.

**Specific Attributes:**
- `stamina` (int): Endurance, determines the ability to perform consecutive attacks.
- `strength` (int): Strength, determines the base damage of attacks.

**Specific Methods:**
- `attack(Character enemy)`: Specific implementation with two types of attacks:
  - Heavy attack: Consumes 5 stamina, deals damage equal to strength.
  - Weak attack: Consumes 1 stamina, deals half damage.
  - Recovery: If not enough stamina, recovers 2 points.

#### Wizard Class
Extends the Character class and implements the Attack interface.

**Specific Attributes:**
- `mana` (int): Magical resource for casting spells.
- `intelligence` (int): Affects the power of spells.

**Specific Methods:**
- `attack(Character enemy)`: Implementation with:
  - Fireball: Consumes 5 mana, deals damage equal to intelligence.
  - Staff hit: Consumes 1 mana, deals minor damage.
  - Recovery: If not enough mana, recovers 2 points.

#### Attack Interface
Defines the attack method that all character classes must implement:
- `void attack(Character enemy)`: Method to attack an enemy character.

### Game Flow

#### GameLauncher
Main class that starts the game with a main menu with three options:
1. Create characters
2. Go directly to combat
3. Exit

#### MenuCreateCharacter
Manages character creation with options:
1. Create custom characters (with user-chosen name)
2. Create random characters
3. Show created characters
4. Return to main menu

#### MenuFight
Manages battles between characters with options:
1. Choose characters manually for combat
2. Battle with random characters
3. Show available characters
4. Return to main menu

#### Combat System
Combat develops in turns where:
- Characters attack alternately.
- Damage depends on the attacker's attributes.
- Resources (stamina or mana) are consumed when attacking.
- Combat continues until one character dies (HP ≤ 0).
- At the end, a message is displayed with the winner and a humorous random nickname.

### Technical Requirements
- Java 17 (according to the pom.xml file)
- Maven build
- Java compatible IDE (such as IntelliJ IDEA)