package com.company.characters;
import com.company.requisite.Requisite;
import com.company.requisite.weapons.Firearm;

import java.util.ListIterator;

public class BadMainCharacters extends Characters implements Unkillable, Humorous {

    Firearm gun = new Firearm(this, 12);

    public void runTo(Characters enemy){
        if (enemy instanceof SideCharacters){
            gun.shootAt(enemy);    //второстепенных героев отрицательный персонаж догнать может
        } else {
            this.setMood(false);    //а главного нет, поэтому он расстраивается
        }
    }

    public void deceive(Characters person){
        person.setMood(false);
    }

    public void takeAway(Requisite item, SideCharacters person){    //отрицательный персонаж может отбирать у второстепенных машины или оружие
        if (this.getLocation() == person.getLocation() && item.getOwner().equals(person)){
            item.setOwner(this);
            person.setMood(false);
        }
    }

    /*отрицательный персонаж не может ничего сделать с главным, но и сам не исчезает*/
    @Override
    public void raise() {
        if (!getAlive())
                this.setAlive(true);
    }

    @Override
    public void joke() {    //отрицательный персонаж шутит плохо
        ListIterator<Characters> i = this.getLocation().people.listIterator();
        while (i.hasNext()){
            i.next().setMood(true);
        }
    }
}
