package com.hierarchy.requisite.transport;

import com.hierarchy.decorations.Decoration;
import com.hierarchy.characters.Characters;
import com.hierarchy.requisite.Requisite;

public abstract class Transport extends Requisite {

    public Transport(Characters owner)
    {
        super(owner);
        setCondition(Conditions.unbroken);    //сначала транспорт цел
    }

    public void goesTo(Decoration location) {
        if (getCondition() != Conditions.broken) {
            if (getCondition() != Conditions.burnt)
                getOwner().setLocation(location);   //меняет локацию
        } else {
            getOwner().repair(this);
            getOwner().setLocation(location);
        }
    }
}
