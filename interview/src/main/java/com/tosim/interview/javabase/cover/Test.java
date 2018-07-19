package com.tosim.interview.javabase.cover;

public class Test {

    public static void main(String[] args) {
        Integer a = 50;
        Integer b = 50;

        System.out.println(a == b);

        Son son = new Son();
        System.out.println(son.tryCatchFinaly());

    }
}
