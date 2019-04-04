package com.hierarchy.requisite.transport;

import com.hierarchy.characters.Characters;

public class Car extends Transport {

    public Car(Characters owner){
        super(owner);
    }

    public void collideWith(Transport another) {    //клише, что при столкновении машины взрываются
        another.setCondition(Conditions.burnt);
        this.setCondition(Conditions.burnt);
    }
}
