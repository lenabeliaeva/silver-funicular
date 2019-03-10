package com.company;

abstract class Character extends Film {
    private String name;

    private boolean isAlive;

    public boolean getAlive(){
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void shootAt(Character enemy);

    abstract void run(Character enemy);
}
