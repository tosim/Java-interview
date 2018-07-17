package com.tosim.interview.designpartten.struction.adapter.instanceadapter;

public class Adapter implements Targetable{

    private Source source;

    public Adapter(Source source){
        this.source = source;
    }

    public void method2() {
        this.source.method1();
        System.out.println("do method2");
    }

    public void method1() {
        this.source.method1();
    }
}
