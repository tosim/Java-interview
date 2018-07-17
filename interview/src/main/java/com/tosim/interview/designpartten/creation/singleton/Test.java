package com.tosim.interview.designpartten.creation.singleton;

/**
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 */
public class Test {

    public static void main(String[] args0){
        SingleItem instance = SingleItem.getInstance();
    }
}
