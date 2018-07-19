package com.tosim.interview.javabase.cover;

public class Son extends Father implements Cloneable{

    /**
     *
     * @param s
     * @return
     */
    public String method(String s) {
        System.out.println("son method");
        return "ok";
    }

    public Son clone() {
        Son son = null;
        try{
            son = (Son) super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return son;
    }

    public int tryCatchFinaly(){
        int a = 0;
        try {
            a = 1;
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            a++;
        }
        return a;
    }

}
