package com.company.requisite.weapons;

import com.company.characters.Characters;
import com.company.characters.GoodMainCharacters;

public class Firearm extends Weapon {

    private int loaded;   //должно быть заряжено пулями

    public Firearm(Characters owner, int numberOfBullets){
        super(owner);
        loaded = numberOfBullets;    //заряжаем оружие
    }

    public void shootAt(Characters enemy) {
        if (!(enemy instanceof GoodMainCharacters)){    //главный герой погибнуть не может
            enemy.setAlive(false);      //а остальные могут
            --loaded;   //уменьшаем количество пуль
        }
    }
}
