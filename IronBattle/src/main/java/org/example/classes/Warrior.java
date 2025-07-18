package org.example.classes;
import org.example.classes.Interfaces.Attack;

import java.util.*;
import java.lang.*;


public class  Warrior extends Character implements Attack {

        private int stamina;
        private int strength;

        // Constructor for Warrior class
        public Warrior (String name, int hp, int stamina, int strength) {
            super(name, hp);
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

    @Override
    public void attack (Character enemy){
            Random rand = new Random();
            int damage = 0;
            if (stamina >=5 && rand.nextBoolean()) {
                //Heavy attack
                damage = strenght;
                stamina-= 5;
                System.out.println(getName() + " performs a Heavy Attack for" + damage + "damage!");
            } else if (stamina >=1){
                //Weak attack
                damage = strength/2;
                stamina +=1;
                System.out.println(getName()) + " performs a Weak Attack for"+damage+"damage!");
            } else {
                //No attack, regain stamina
                stamina += 2;
                System.out.println(getName()) + "is too tired and regains 2 stamina");
            }
            enemy.setHp(enemy.getHp()-damage);
    }
}
