package com.company.characters;

import com.company.decorations.Decoration;
import com.company.requisite.Requisite;

import java.util.ListIterator;

public class BadMainCharacters extends Characters implements Unkillable, Humorous {

    public void runTo(Characters enemy){
        System.out.println(this.getName() + "не может догнать главного героя");
        this.setMood(false);
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
