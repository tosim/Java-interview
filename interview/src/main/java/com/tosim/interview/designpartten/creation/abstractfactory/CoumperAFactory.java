package com.tosim.interview.designpartten.creation.abstractfactory;

public class CoumperAFactory implements ComputerAbstractFactory{

    public Mouse createMouse() {
        return new MouseA();
    }

    public Keyboard createKeyboard() {
        return new KeyboardA();
    }
}
