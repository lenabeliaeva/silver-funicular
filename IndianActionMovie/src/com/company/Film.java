package com.company;

import com.company.decorations.Decoration;

public class Film {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Decoration[] decoration = new Decoration[10];

    public Character[] characters = new Character[5];
}
