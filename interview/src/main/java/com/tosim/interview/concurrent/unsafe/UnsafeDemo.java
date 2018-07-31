package com.tosim.interview.concurrent.unsafe;

import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class UnsafeDemo {

    public static void main(String[] args) {

//        Unsafe unsafe = Unsafe.getUnsafe();

//        AtomicInteger integer = new AtomicInteger();
//        integer.getAndAdd(12);
//        integer.set(2);
//        AtomicStampedReference<Integer> integer2 = new AtomicStampedReference<Integer>(new Integer(2),(int)System.currentTimeMillis());
//
//        ReentrantLock a;
//        a.lock();
//        AbstractQueuedSynchronizer
//        Semaphore s;
//        AbstractQueuedSynchronizer aqs;

//       Thread threadA = new Thread(new Runnable() {
//           public void run() {
//               int i = 0;
//               while(i < 5){
//                   System.out.println("thread-A");
//                   try {
//                       Thread.sleep(2000);
//                   } catch (InterruptedException e) {
//                       e.printStackTrace();
//                   }
//                   i++;
//               }
//           }
//       });
//        Thread threadB = new Thread(new Runnable() {
//            public void run() {
//                while(true){
//                    System.out.println("thread-B");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//       threadA.start();
//       threadB.start();
//
//        try {
//            threadA.join();
//            System.out.println("ssss");
//            threadB.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        while(true){
            new Thread(new Runnable() {
                public void run() {
                    while (true) {

                    }
                }
            }).start();
        }
//        ClassLoader

    }
}
