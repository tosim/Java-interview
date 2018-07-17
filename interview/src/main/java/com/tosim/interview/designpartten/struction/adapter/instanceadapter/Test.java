package com.tosim.interview.designpartten.struction.adapter.instanceadapter;

/**
 * 对象的适配器模式
 */
public class Test {

    public static void main(String[] args){
        Source source = new Source();
        Adapter adapter = new Adapter(source);
        adapter.method2();
    }
}
