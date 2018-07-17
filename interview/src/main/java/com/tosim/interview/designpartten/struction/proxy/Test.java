package com.tosim.interview.designpartten.struction.proxy;

/**
 * 为其他对象提供一个代理以控制对这个对象的访问。
 */
public class Test {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(true);
        proxy.doAction();
    }
}
