package com.tosim.interview.designpartten.creation.prototype;

/**
 * 用原型实例指定创建对象的种类，并且通过拷贝这个原型来创建新的对象。
 */
public class Test {

    public static void main(String[] args){
        ProtoItem protoItem = new ProtoItem();
        protoItem.setValue("val1");

        ProtoItem copy = protoItem.clone();
        protoItem.setValue("val2");

        System.out.println(copy.getValue());
    }
}
