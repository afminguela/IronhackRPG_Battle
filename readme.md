[DeepWiki documentation](https://deepwiki.com/afminguela/IronhackRPG_Battle)
# Documentación del Proyecto IronhackRPG_Battle
## Español

### Descripción General
IronhackRPG_Battle es un juego de rol por texto desarrollado como parte de un ejercicio académico para Ironhack. El juego simula batallas entre diferentes tipos de personajes en un entorno de fantasía, donde cada personaje tiene características únicas y habilidades especiales.

### Estructura del Proyecto
El proyecto está estructurado siguiendo el patrón de diseño orientado a objetos, con las siguientes clases principales:

#### Clase Character (Abstracta)
Esta clase abstracta sirve como base para todos los tipos de personajes del juego.

**Atributos:**
- `id` (String): Identificador único generado automáticamente para cada personaje.
- `name` (String): Nombre del personaje.
- `hp` (int): Puntos de vida del personaje. Los guerreros tienen entre 100-200 HP y los magos entre 50-100 HP.
- `isAlive` (boolean): Indica si el personaje está vivo (true) o muerto (false).

**Métodos:**
- `RandomId()`: Genera un identificador único utilizando UUID.
- Getters y Setters para todos los atributos.
- Validaciones específicas para los puntos de vida según el tipo de personaje.

#### Clase Warrior (Guerrero)
Extiende la clase Character e implementa la interfaz Attack.

**Atributos específicos:**
- `stamina` (int): Resistencia del guerrero, afecta su capacidad para realizar ataques continuos.
- `strength` (int): Fuerza del guerrero, determina el daño que puede infligir.

**Métodos:**
- Constructor parametrizado.
- Getters y Setters para los atributos específicos.

#### Clase Wizard (Mago)
Extiende la clase Character e implementa la interfaz Attack.

**Atributos específicos:**
- `mana` (int): Puntos de maná, recurso para lanzar hechizos.
- `intelligence` (int): Inteligencia del mago, afecta el poder de sus hechizos.

**Métodos:**
- Constructor parametrizado.
- Getters y Setters para los atributos específicos.

#### Interfaz Attack
Interfaz que define los métodos de ataque que deben implementar las clases de personajes. Actualmente está vacía, pero se espera que incluya métodos para gestionar los ataques entre personajes.

### Sistema de Combate (Propuesto)
El sistema de combate se implementaría a través de una clase BattleSystem que gestione:
- Ataques entre personajes.
- Cálculo de daño basado en los atributos.
- Gestión de recursos (stamina, mana).
- Determinación del resultado de la batalla.

### Requisitos Técnicos
- Java 8 o superior.
- IDE compatible con Java (como IntelliJ IDEA, Eclipse, etc.).
- JUnit para pruebas unitarias y de integración.

## English

### General Description
IronhackRPG_Battle is a text-based role-playing game developed as part of an academic exercise for Ironhack. The game simulates battles between different types of characters in a fantasy setting, where each character has unique characteristics and special abilities.

### Project Structure
The project is structured following the object-oriented design pattern, with the following main classes:

#### Character Class (Abstract)
This abstract class serves as the base for all character types in the game.

**Attributes:**
- `id` (String): Automatically generated unique identifier for each character.
- `name` (String): Character name.
- `hp` (int): Character's health points. Warriors have between 100-200 HP and wizards between 50-100 HP.
- `isAlive` (boolean): Indicates whether the character is alive (true) or dead (false).

**Methods:**
- `RandomId()`: Generates a unique identifier using UUID.
- Getters and Setters for all attributes.
- Specific validations for health points based on character type.

#### Warrior Class
Extends the Character class and implements the Attack interface.

**Specific Attributes:**
- `stamina` (int): Warrior's endurance, affects their ability to perform continuous attacks.
- `strength` (int): Warrior's strength, determines the damage they can inflict.

**Methods:**
- Parameterized constructor.
- Getters and Setters for the specific attributes.

#### Wizard Class
Extends the Character class and implements the Attack interface.

**Specific Attributes:**
- `mana` (int): Mana points, resource for casting spells.
- `intelligence` (int): Wizard's intelligence, affects the power of their spells.

**Methods:**
- Parameterized constructor.
- Getters and Setters for the specific attributes.

#### Attack Interface
Interface that defines the attack methods that character classes must implement. It is currently empty, but is expected to include methods for managing attacks between characters.

### Combat System (Proposed)
The combat system would be implemented through a BattleSystem class that manages:
- Attacks between characters.
- Damage calculation based on attributes.
- Resource management (stamina, mana).
- Determination of battle outcome.

### Technical Requirements
- Java 8 or higher.
- Java-compatible IDE (such as IntelliJ IDEA, Eclipse, etc.).
- JUnit for unit and integration testing.
