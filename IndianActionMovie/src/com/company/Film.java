package com.company;

import com.company.characters.Characters;
import com.company.decorations.Decoration;

import java.util.LinkedList;

public class Film {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Decoration> decoration = new LinkedList<>();

    public LinkedList<Characters> characters = new LinkedList<>();
}
