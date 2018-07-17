package com.tosim.interview.designpartten.creation.factorymethod;

public class CircleFactory implements ShapeFactory{
    public Shape create() {
        return new Circle();
    }
}
