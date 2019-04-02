package com.company.characters;

import com.company.decorations.Decoration;
import com.company.Film;
import com.company.requisite.Requisite;

public class Characters extends Film {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Decoration location;    //каждый персонаж находится в какой-то локации

    public void setLocation(Decoration location) {
        this.location = location;
        decoration.add(location);
    }

    public Decoration getLocation() {
        return location;
    }

    private boolean isAlive;

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private boolean isNeedHelp;

    public boolean needsHelp() {
        return isNeedHelp;
    }

    public void setNeedsHelp(boolean needsHelp) {
        isNeedHelp = needsHelp;
    }

    private boolean mood;

    public void setMood(boolean mood) {
        this.mood = mood;
    }

    public void pourLiquidNitrogen(Characters enemy) {
        if (enemy instanceof GoodMainCharacters) {             //главный герой всегда
            ((GoodMainCharacters) enemy).runFrom(this); //спасается
        }
        isActionGood(false);
    }

    public void makeDamageTo(Requisite something) {
        something.setCondition(Requisite.Conditions.broken);
        isActionGood(false);
    }

    public void repair(Requisite something) {
        something.setCondition(Requisite.Conditions.repaired);
        isActionGood(true);
    }

    public Characters isActionGood(boolean karma) {
        if (karma) return new GoodMainCharacters();
        else return new BadMainCharacters();
    }
}
