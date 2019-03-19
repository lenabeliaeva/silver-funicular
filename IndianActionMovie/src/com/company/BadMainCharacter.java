package com.company;

public class BadMainCharacter extends Character implements Unkillable{

    public BadMainCharacter(String name){
        super(name);
    }

    @Override
    void shootAt(Character enemy){
        System.out.println(this.getName() + "не может попасть в главного героя");
    }

    @Override
    void run(Character enemy){
        System.out.println(this.getName() + "не может догнать главного героя");
    }

    /*отрицательный персонаж не может ничего сделать с главным, но и сам не исчезает*/
    @Override
    public void raise() {
        if (!getAlive())
                this.setAlive(true);
    }
}
