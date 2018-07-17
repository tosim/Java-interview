package com.tosim.interview.designpartten.struction.bridge;

public class MyBridge extends Bridge {

    public void method(){
        System.out.println("do my bridge");
        getSource().method();
    }
}
