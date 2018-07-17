package com.tosim.interview.designpartten.creation.builder;

public class HouseDirector {
    public House buildHouse(HouseBuilder hb){
        hb.buildBase();
        hb.buildWall();
        hb.buildRooft();
        return hb.buildHouse();
    }
}
