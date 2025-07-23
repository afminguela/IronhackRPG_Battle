package org.example.classes;
import org.example.classes.Interfaces.Attack;

import java.util.*;
import java.lang.*;


public class Warrior extends Character implements Attack {

        private int stamina=-1;
        private int strength=-1;

        // Constructor for Warrior class
        public Warrior (String name, int hp, int stamina, int strength) {
            super(name, hp);
            this.stamina = stamina;
            this.strength = strength;
        }

        public Warrior (String name){
            super(name);
        }


        // getters y setters

    public int getStrength() {
        return strength;
    }

    public int getStamina() {
        return stamina;
    }

   

     public void setStrength(int strength) {

        if (strength == -1) {
            this.strength = new Random().nextInt(1) + 50;
        } else {
            this.strength = strength;
        }

    }
    public void setStamina(int stamina) {

        if (stamina == -1){
            this.stamina = new Random().nextInt(51) + 50;
        }else
            this.stamina = stamina;
    }

 // methods (Attack & Get info)
 public void attack(Character enemy) {
        Random rand = new Random();
        int damage;
        if (getStamina() >= 5 && rand.nextBoolean()) {
            //Heavy attack
            damage = getStrength();
            setStamina(getStamina() -5);
            int q = enemy.getHp();

            System.out.println("\n");
            System.out.println(getName() + " Hostia final que hace" + damage + " de turra!");
            System.out.println("\n");
            enemy.setHp(q - damage, false);
            System.out.println("\n HP del enemigo después del ataque: " + enemy.getHp());
            if (enemy.getHp() <= 0) {
                enemy.setIsAlive(false);
            }
        } else if (getStamina() >= 1) {
            //Weak attack
            damage = getStrength() / 2;
            setStamina(getStamina() +1);
            int q = enemy.getHp();

            System.out.println("\n");
            System.out.println(getName() + " Cachetada suave que  hace" + damage + " de pupita!");
            System.out.println("\n");
            enemy.setHp(q - damage, false);
            System.out.println("\n HP del enemigo después del ataque: " + enemy.getHp());
            if (enemy.getHp() <= 0) {
                enemy.setIsAlive(false);
            }

        } else {
            //No attack, regain stamina

            setStamina(getStamina() +2);

            System.out.println(getName() + "\n Dame un momento, por favor... stamina vuelve");
        }


    }
     
    @Override
    public String getInfo(){
           return  super.getInfo() + " Stamina: " + getStamina() + " Strength: " + getStrength()+ " ";
    }




}
