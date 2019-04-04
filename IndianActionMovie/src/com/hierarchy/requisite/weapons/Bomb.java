package com.hierarchy.requisite.weapons;

import com.hierarchy.decorations.Decoration;
import com.hierarchy.characters.BadMainCharacters;

public class Bomb extends Weapon {
    //не придумала как реализовать возможность спасения от взрыва, если бомба установлена, поэтому просто
    // добавляю в реквизит соответсвующей декорации или удаляю
    public Bomb(BadMainCharacters owner){
        super(owner);
    }

    public void setIn(Decoration location){
        location.requisites.add(this);
    }

    public void defuse(Decoration location){
        location.requisites.remove(this);
    }
}
