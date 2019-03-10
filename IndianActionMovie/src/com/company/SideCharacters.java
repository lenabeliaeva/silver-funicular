package com.company;

public class SideCharacters extends Character{

    private String type;

    public SideCharacters(String name, String type){
        super(name);
        this.type = type; //второстепенные герои поддерживают или положительного персонажа, или отрицательного
    }

    @Override
    void run(Character enemy) {
        System.out.println(this.getName() + "не может догнать главного героя");
    }

    @Override
    void shootAt(Character enemy) {
        System.out.println(this.getName() + "не может попасть в главного героя");
    }
}
