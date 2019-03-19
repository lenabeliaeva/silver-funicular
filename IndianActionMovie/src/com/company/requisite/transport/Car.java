package com.company.requisite.transport;

import com.company.characters.Characters;

public class Car extends Transport {

    public Car(Characters owner){
        super(owner);
    }

    public void collideWith(Transport another) {    //клише, что при столкновении машины взрываются
        another.setCondition(Conditions.burnt);
        this.setCondition(Conditions.burnt);
    }
}
