package org.example.classes;

import java.util.Random;
import java.util.UUID;

public abstract class Character {
    private String id = RandomId();
    private String name;
    private int hp = -1  ; //random between 100-200 to warriors and 50-100 for wizards, representing the health points
    // (Private member)
    private boolean isAlive = true;

    public String RandomId() {
        return this.id = UUID.randomUUID().toString(); // El ID se genera automáticamente al construir el objeto
    }
    public Character(String name) {
        this.name = name;
    }
    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        //primero comprueba si es un warrior o un wizard, y luego si le pasamos valor de hp
        if ( this instanceof Warrior) {
            if (hp == -1) {
                this.hp = new Random().nextInt(10) + 50;
            }this.hp = hp;

            if (hp < 100 || hp > 200) {
                throw new IllegalArgumentException("Warrior HP must be between 100 and 200");
            }
        } else if ( this instanceof Wizard ) {
            if (hp == -1) {
                this.hp = new Random().nextInt(10) + 50;
            }this.hp = hp;
            if (hp < 50 || hp > 100) {
                throw new IllegalArgumentException("Wizard HP must be between 50 and 100");
            }
        }
        this.hp = hp;  // para que pueda haber mas tipos de personaje
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    //methods

    public String getInfo() {
          return "Name: " + getName() + " Health Points: " + getHp();
    }

}



//This class will have:
//
//Variable called id of data type string, auto-generated (Private member)
//Variable called name of data type string (Private member)
//Variable called hp of data type int, random between 100-200 to warriors and 50-100 for wizards, representing the health points (Private member)
//Variable called isAlive of data type boolean defaulted to true (Private member)
//A “parameterized” constructor that takes name and hp (as parameters)
//Public Getter functions to access these variables
//Public Setter functions to change these variables