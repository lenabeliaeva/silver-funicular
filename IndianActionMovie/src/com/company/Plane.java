package com.company;

public class Plane extends Transport {

    public void fly(){
        System.out.println("Самолёт летит");
    }

    @Override
    void repaired() {
        System.out.println("Самолёт починен");
    }

    @Override
    void breaked() {
        System.out.println("Самолёт сломан");
    }
}
