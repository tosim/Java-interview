package com.tosim.interview.designpartten.struction.bridge;

/**
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 */
public class Test {

    public static void main(String[] args) {
        Bridge bridge = new MyBridge();
        bridge.setSource(new SourceSub1());
        bridge.method();

        bridge.setSource(new SourceSub2());
        bridge.method();
    }
}
