package org.example.classes;

import java.util.UUID;

abstract class character {
    private String id = RandomId();
    private String name;
    private int hp ; //random between 100-200 to warriors and 50-100 for wizards, representing the health points (Private member)
    private boolean isAlive = true;

    public String RandomId() {
        return this.id = UUID.randomUUID().toString(); // El ID se genera automáticamente al construir el objeto
    }

    public character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getId() {
        return id;
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
        this.hp = hp;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
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