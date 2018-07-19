package com.tosim.interview.javabase.cover;

public class Father {

    protected String val = "father val";
    /**
     * final方法不能被子类覆盖，只能重载
     */
    public final void method(){
        System.out.println("father final method");
    }


    public static void staticMethod(){
        System.out.println("father static method");
    }
}
