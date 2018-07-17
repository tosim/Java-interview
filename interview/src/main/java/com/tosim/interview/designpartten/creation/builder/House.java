package com.tosim.interview.designpartten.creation.builder;

public class House {

    private String rooft;
    private String wall;
    private String base;

    public String getRooft() {
        return rooft;
    }

    public void setRooft(String rooft) {
        this.rooft = rooft;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "House{" +
                "rooft='" + rooft + '\'' +
                ", wall='" + wall + '\'' +
                ", base='" + base + '\'' +
                '}';
    }
}
