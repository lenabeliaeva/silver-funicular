package com.company;

class Car extends Transport {

    public void go() {
        System.out.println("Машина едет");
    }

    @Override
    void breaked() {
        System.out.println("Машина сломалась");
    }

    @Override
    void repaired() {
        System.out.println("Машину починили");
    }
}