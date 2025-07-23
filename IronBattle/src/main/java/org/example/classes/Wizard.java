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


//mana = new Random().nextInt(1) + 50;
// intelligence = new Random().nextInt(51) + 50;
//

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

   public void attack(Character enemy) {
        Random rand = new Random();
        int damage = 0;
        if (getMana() >= 5 && rand.nextBoolean()) {
            //Fireball
            damage = getIntelligence();
            setMana(getMana() -5);
            System.out.println(getName() + "  Bola de fuego " + damage + " de turra!");
            int q = enemy.getHp();
            enemy.setHp(q - damage);
            System.out.println(". HP del enemigo después del ataque: " + enemy.getHp());
        } else if (getMana() >= 1) {
            //staff hit
            damage = 2;
            setMana(getMana() + 1);
            System.out.println(getName() + "  Toma palo " + damage + " de pupita!");
            int q = enemy.getHp();
            enemy.setHp(q - damage);
            System.out.println(". HP del enemigo después del ataque: " + enemy.getHp());
        } else {
            //no mana
            setMana(getMana() +2);
            System.out.println(getName() + "  Necesito un café, ahora recargo");

        }

    }


    @Override
    public String getInfo() {
             return   super.getInfo() + " Mana: " + getMana() + " Intelligence: " + getIntelligence() + " ";
    }

}