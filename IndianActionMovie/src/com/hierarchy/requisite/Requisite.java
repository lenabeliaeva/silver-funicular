package com.hierarchy.requisite;
import com.hierarchy.Film;
import com.hierarchy.characters.Characters;

public abstract class Requisite extends Film {

    private Characters owner;

    public Requisite(Characters owner){
        this.owner = owner;
    }

    public Characters getOwner() {
        return owner;
    }

    public void setOwner(Characters owner) {
        this.owner = owner;
    }

    private Conditions condition;

    public void setCondition(Conditions condition) {
        this.condition = condition;
    }

    public Conditions getCondition(){
        return condition;
    }

    public enum Conditions{
        broken,
        repaired,
        unbroken,
        burnt
    }
}
