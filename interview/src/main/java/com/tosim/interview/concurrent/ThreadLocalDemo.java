package com.tosim.interview.concurrent;

import java.util.ArrayList;
import java.util.Iterator;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
//                iterator.remove();
                list.remove(integer);
        }
        System.out.println(list.size());
    }
}
