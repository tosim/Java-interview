package com.tosim.interview.designpartten.creation.factorymethod;

public class RectangleFactory implements ShapeFactory{
    public Shape create() {
        return new Rectangle();
    }
}
