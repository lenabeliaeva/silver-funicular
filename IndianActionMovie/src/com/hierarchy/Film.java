package com.hierarchy;

import com.hierarchy.characters.Characters;
import com.hierarchy.decorations.Decoration;

import java.util.LinkedList;

public abstract class Film {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    protected LinkedList<Decoration> decoration = new LinkedList<>();

    public LinkedList<Characters> characters = new LinkedList<>();
}
