package com.hierarchy.characters;

import com.hierarchy.decorations.Decoration;
import com.hierarchy.Film;
import com.hierarchy.requisite.Requisite;

public abstract class Characters extends Film {

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

    Decoration getLocation() {
        return location;
    }

    private boolean isAlive;

    boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private boolean isNeedHelp;

    boolean needsHelp() {
        return isNeedHelp;
    }

    void setNeedsHelp(boolean needsHelp) {
        isNeedHelp = needsHelp;
    }

    private boolean mood;

    void setMood(boolean mood) {
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

    private Characters isActionGood(boolean karma) {
        if (karma) return new GoodMainCharacters();
        else return new BadMainCharacters();
    }
}
