package com.tosim.interview.designpartten.struction.adapter.classadapter;

public class Adapter extends Source implements Targetable {

    public void method2() {
        this.method1();
        System.out.println("do method2");
    }
}
