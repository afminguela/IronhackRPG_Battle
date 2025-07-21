package org.example.classes;
import org.example.classes.Interfaces.Attack;

import java.util.*;
import java.lang.*;

public class  Wizard extends Character implements Attack {

    private int mana;
    private int intelligence;

    // Constructor for Wizard class

    public Wizard (String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }


//mana = new Random().nextInt(1) + 50;
// intelligence = new Random().nextInt(51) + 50;
//

    // getters y setters
    public int getMana(){
        return mana;
    }

    public int getIntelligence (){
        return intelligence;
    }




    public void setMana(int mana) {

        if (!mana) {
            this.mana = new Random().nextInt(1) + 50;
        } else {
            this.mana = mana;
        }
    }
    public void setIntelligence (int intelligence){

        if (!intelligence){
            this.intelligence = new Random().nextInt(51) + 50;
        }else
            this.intelligence = intelligence;
    }

    @Override
    public void attack (Character enemy) {
        Random rand = new Random();
        int damage= 0;
        if (mana>=5 && rand.nextBoolean()) {
            //Fireball
            damage = intelligence;
            mana -= 5;
            System.out.println (getName()+"cast Fireball"+ damage + "damage!");
        } else if (mana >=1){
            //staff hit
            damage=2;
            mana +=1;
            System.out.println(getName()+"hit with Staff for"+damage+"damage!");
        } else {
            //no mana
            mana +=2;
            System.out.println(getName()+"is out of mana and regains2")
        }
    } enemy.setHp (enemy.getHp()-damage);

}

@Override
    public void getInfo(){
            super.getInfo();
             System.out.println( " Mana: " + getMana() + " Intelligence: " + getIntelligence()+ " ")
    }
