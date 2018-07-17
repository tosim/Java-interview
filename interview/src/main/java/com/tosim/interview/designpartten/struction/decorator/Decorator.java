package com.tosim.interview.designpartten.struction.decorator;

public class Decorator implements Sourceable {

    private Sourceable sourceable;

    public Decorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    public void method() {
        System.out.println("do something before");
        this.sourceable.method();
    }
}
