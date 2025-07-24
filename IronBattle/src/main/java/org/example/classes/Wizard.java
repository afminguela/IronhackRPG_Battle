package org.example.classes;
import org.example.classes.Interfaces.Attack;

import java.util.*;
import java.lang.*;

public class  Wizard extends Character implements Attack {

    private int mana = -1;
    private int intelligence = -1;

    // Constructor for Wizard class

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public Wizard(String name) {
        super(name);
    }


    // getters y setters
    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }


    public void setMana(int mana) {

        if (mana==-1) {
            this.mana = new Random().nextInt(1) + 50;
        } else {
            this.mana = mana;
        }
    }

    public void setIntelligence(int intelligence) {

        if (intelligence==-1) {
            this.intelligence = new Random().nextInt(51) + 50;
        } else
            this.intelligence = intelligence;
    }
    // methods (Attack & Get info)
   public void attack(Character enemy) {
        Random rand = new Random();
        int damage;
        if (getMana() >= 5 && rand.nextBoolean()) {
            //Fireball
            damage = getIntelligence();
            setMana(getMana() -5);

            System.out.println(getName() + " ☄️ Lanza Bola de fuego y hace " + damage + " de turra!");
            int q = enemy.getHp();
            enemy.setHp(Math.max( 0, q - damage),false);

            System.out.println(" 🧬 Vida del enemigo después del ataque: " + enemy.getHp());
            if (enemy.getHp() <= 0) {
                enemy.setIsAlive(false);
            }
        } else if (getMana() >= 1) {
            //staff hit
            damage = 2;
            setMana(getMana() + 1);
            int q = enemy.getHp();

            System.out.println(getName() + " 𓋾 arrea con un palo!! solo consigue " + damage + " de pupita!");

            enemy.setHp(Math.max( 0, q - damage),false);
            System.out.println(" 🧬 vida del enemigo después del ataque: " + enemy.getHp());
            if (enemy.getHp() <= 0) {
                enemy.setIsAlive(false);
            }
        } else {
            //no mana
            setMana(getMana() +2);
            System.out.println(getName() + " \n ☕ Necesito un café, ahora recargo");

        }

    }


    @Override
    public String getInfo() {
             return   super.getInfo() + " Mana: " + getMana() + " Intelligence: " + getIntelligence() + " ";
    }

}