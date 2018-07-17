package com.tosim.interview.designpartten.creation.builder;

public class ConcreteHouseBuilder implements HouseBuilder {

    private House house;

    public ConcreteHouseBuilder() {
        house = new House();
    }

    public void buildWall() {
        house.setWall("砌墙");
    }

    public void buildBase() {
        house.setBase("造地基");
    }

    public void buildRooft() {
        house.setRooft("建屋顶");
    }

    public House buildHouse() {
        return house;
    }
}
