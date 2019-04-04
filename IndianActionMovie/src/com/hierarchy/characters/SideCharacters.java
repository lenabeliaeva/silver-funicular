package com.hierarchy.characters;

public class SideCharacters extends Characters {

    private Types type;    //второстепенные герои также могут быть как отрицательные, так и положительные

    public SideCharacters(Types type){
        this.type = type;
    }

    public Types getType(){
        return type;
    }

    public enum Types {
        good,
        bad,
        neutral
    }
}
