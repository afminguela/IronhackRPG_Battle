package org.example.classes;
import org.example.classes.Interfaces.Attack;

import java.util.*;
import java.lang.*;


public class  Warrior extends Character implements Attack {

        private int stamina;
        private int strength;

        // Constructor for Warrior class
        public Warrior (String name, int hp, int stamina, int strength) {
            super(name , hp);
            this.stamina =stamina;
            this.strength = strength;
        }


        // getters y setters

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
