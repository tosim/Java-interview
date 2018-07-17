package com.tosim.interview.designpartten.creation.builder;

public class Test {

    public static void main(String[] args){
        HouseDirector houseDirector = new HouseDirector();
        House house = houseDirector.buildHouse(new ConcreteHouseBuilder());
        System.out.println(house.toString());
    }
}
