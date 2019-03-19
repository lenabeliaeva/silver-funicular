package com.company.decorations;

import com.company.Film;
import com.company.characters.Characters;
import com.company.requisite.Requisite;

import java.util.ArrayList;

public class Decoration extends Film {

    public ArrayList<Requisite> requisites = new ArrayList<>();  //в декорации есть реквизит, которым можно пользоваться

    public ArrayList<Characters> people = new ArrayList<>();    //в декорации могут находиться персонажи
}
