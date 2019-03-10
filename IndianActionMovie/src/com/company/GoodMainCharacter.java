package com.company;

public class GoodMainCharacter extends Character implements Artistic{

    public GoodMainCharacter(String name){
        super(name);
    }

    private static final boolean alive = true;

    private String aim = "Спасти мир";

    private boolean aimIsReached = false;

    private boolean fallsInLove = false;

    @Override
    void shootAt(Character enemy) {
        System.out.println(this.getName() + "попал в соперника");
    }

    @Override
    void run(Character enemy) {
        System.out.println(this.getName() + "убежал от сопернрика");
    }

    @Override
    public void dance() {
        if (aimIsReached)
            System.out.println("Главный герой танцует от счастья");
    }

    @Override
    public void sing() {
        if (this.fallsInLove)
            System.out.println("Главный герой поёт от любви");
    }
}
