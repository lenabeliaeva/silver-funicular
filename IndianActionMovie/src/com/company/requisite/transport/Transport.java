package com.company.requisite.transport;

import com.company.decorations.Decoration;
import com.company.characters.Characters;
import com.company.requisite.Requisite;

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
