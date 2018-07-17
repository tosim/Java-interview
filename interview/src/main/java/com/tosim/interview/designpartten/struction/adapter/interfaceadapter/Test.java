package com.tosim.interview.designpartten.struction.adapter.interfaceadapter;

/**
 * 接口的适配
 */
public class Test {

    public static void main(String[] args) {
        Sourceable sourceable1 = new SourceSub1();
        sourceable1.method1();

        Sourceable sourceable2 = new SourceSub2();
        sourceable2.method2();
    }
}
