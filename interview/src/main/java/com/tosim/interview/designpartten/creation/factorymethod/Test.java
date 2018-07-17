package com.tosim.interview.designpartten.creation.factorymethod;

/**
 * 定义一个用于创建对象的接口，让子类决定将哪一个类实例化。使一个类的实例化延迟到其子类。
 */
public class Test {
    public static void main(String[] args){
        ShapeFactory shapeFactory = new CircleFactory();
        Shape circle = shapeFactory.create();
        circle.draw();
    }
}
