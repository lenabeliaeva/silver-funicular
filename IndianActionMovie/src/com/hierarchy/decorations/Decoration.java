package com.hierarchy.decorations;

import com.hierarchy.Film;
import com.hierarchy.characters.Characters;
import com.hierarchy.requisite.Requisite;

import java.util.ArrayList;

public class Decoration extends Film {

    public ArrayList<Requisite> requisites = new ArrayList<>();  //в декорации есть реквизит, которым можно пользоваться

    public ArrayList<Characters> people = new ArrayList<>();    //в декорации могут находиться персонажи
}
