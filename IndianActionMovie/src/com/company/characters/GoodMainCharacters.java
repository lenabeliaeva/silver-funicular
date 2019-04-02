package com.company.characters;

import com.company.decorations.Decoration;

import java.util.ListIterator;

public class GoodMainCharacters extends Characters implements Artistic, Humorous{

    private static final boolean alive = true;

    private String aim;

    public void setAim(String aim){
        this.aim = aim;
    }

    private boolean aimIsReached = false;

    public boolean isAimIsReached() {
        return aimIsReached;
    }

    private boolean charm = true;

    public boolean isCharm() {
        return charm;
    }

    public void runFrom(Characters enemy) {
        this.setLocation(new Decoration()); //убегает в другое место
    }

    public void helpTo(Characters somebody){
        if (somebody.needsHelp()) somebody.setNeedsHelp(false);
    }

    public SideCharacters makeFriends(){
        return new SideCharacters(SideCharacters.Types.good);
    }

    @Override
    public void dance() {
        if (aimIsReached)
            System.out.println("Главный герой танцует от счастья");
    }

    @Override
    public void sing() {
        if (this.isCharm())
            System.out.println("Главный хорошо поёт");
    }

    @Override
    public void joke() {    //хорошие шутки этого персонажа поднимают настроение остальным в той же декорации
        ListIterator<Characters> i = this.getLocation().people.listIterator();
        while (i.hasNext()){
            i.next().setMood(true);
        }
    }
}
