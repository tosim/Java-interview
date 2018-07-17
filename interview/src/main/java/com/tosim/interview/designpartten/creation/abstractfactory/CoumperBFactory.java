package com.tosim.interview.designpartten.creation.abstractfactory;

public class CoumperBFactory implements ComputerAbstractFactory{

    public Mouse createMouse() {
        return new MouseB();
    }

    public Keyboard createKeyboard() {
        return new KeyboardB();
    }
}
