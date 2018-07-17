package com.tosim.interview.designpartten.creation.abstractfactory;

/**
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 */
public class Test {
    public static void main(String[] args){
        ComputerAbstractFactory computerAFactory = new CoumperAFactory();
        Mouse mouse = computerAFactory.createMouse();
        Keyboard keyboard = computerAFactory.createKeyboard();
        mouse.move();
        keyboard.kick();
    }
}
