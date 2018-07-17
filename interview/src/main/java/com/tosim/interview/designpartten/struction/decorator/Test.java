package com.tosim.interview.designpartten.struction.decorator;

public class Test {

    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        sourceable.method();

        Decorator decorator = new Decorator(sourceable);
        decorator.method();
    }
}
