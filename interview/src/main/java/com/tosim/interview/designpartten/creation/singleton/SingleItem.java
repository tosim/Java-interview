package com.tosim.interview.designpartten.creation.singleton;

public class SingleItem {

    private SingleItem(){
    }

    public static SingleItem getInstance(){
        return InstanceHolder.instance;
    }

    private static class InstanceHolder{
        public static SingleItem instance = new SingleItem();
    }
}
