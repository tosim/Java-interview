package com.tosim.interview.designpartten.struction.decorator;

/**
 * 动态地给一个对象添加一些额外的职责。就扩展功能而言， 它比生成子类方式更为灵活。
 */
public class Test {

    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        sourceable.method();

        Decorator decorator = new Decorator(sourceable);
        decorator.method();
    }
}
