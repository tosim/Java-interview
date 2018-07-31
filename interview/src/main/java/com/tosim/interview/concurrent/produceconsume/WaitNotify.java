package com.tosim.interview.concurrent.produceconsume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WaitNotify {

    private static class Storage {

        private final int MAX_SIZE = 100;

        private List<Object> list = new LinkedList<Object>();

        public void produce() {
            synchronized(list) {
                while(list.size() == MAX_SIZE) {
                    System.out.println(String.format("库存空位:%d 大于剩余可存放的数量",MAX_SIZE - list.size()));
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                list.add(new Object());

                System.out.println(String.format("%s 生产了1件商品",Thread.currentThread().getName()));
                list.notifyAll();
            }
        }

        public void consume() {
            synchronized (list) {
                while(list.size() == 0) {
                    System.out.println(String.format("库存容量:%d 大于剩余可消费的数量",list.size()));
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                list.remove(0);
                System.out.println(String.format("%s 消费了1件商品",Thread.currentThread().getName()));

                list.notifyAll();
            }
        }
    }

    private static class Producer implements Runnable{

        private Storage storage;

        public Producer(Storage storage) {
            this.storage = storage;
        }

        public void run() {
            this.storage.produce();
        }
    }

    private static class Consumer implements Runnable {

        private Storage storage;

        public Consumer(Storage storage) {
            this.storage = storage;
        }

        public void run() {
            this.storage.consume();
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();

        for(int i = 0;i < 5;i++) {
            new Thread(new Consumer(storage),"consumer-"+i).start();
            new Thread(new Producer(storage),"producer-"+i).start();
        }
    }
}
