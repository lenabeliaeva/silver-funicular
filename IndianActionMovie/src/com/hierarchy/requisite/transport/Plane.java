package com.hierarchy.requisite.transport;

import com.hierarchy.decorations.Decoration;
import com.hierarchy.characters.Characters;

public class Plane extends Transport {

    private boolean isFly;

    private Characters[] passengers;

    public Plane(Characters owner){
        super(owner);
    }

    public void takesOff(){
        isFly = true;
    }

    public void lands(Decoration location){
        this.getOwner().setLocation(location);
    }

}
