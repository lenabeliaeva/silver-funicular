package com.hierarchy;

import com.hierarchy.characters.BadMainCharacters;
import com.hierarchy.characters.Characters;
import com.hierarchy.characters.GoodMainCharacters;
import com.hierarchy.characters.SideCharacters;
import com.hierarchy.decorations.Decoration;
import com.hierarchy.requisite.weapons.Bomb;

public class Main {

    public static void main(String[] args) {
        GoodMainCharacters Jimmy = new GoodMainCharacters();
        BadMainCharacters Taylor = new BadMainCharacters();
        Characters Bob = new SideCharacters(SideCharacters.Types.good);

        Jimmy.setAim("To save the world");
        Bomb bomb = new Bomb(Taylor);
        Decoration world = new Decoration();
        bomb.setIn(world);
    }
}
