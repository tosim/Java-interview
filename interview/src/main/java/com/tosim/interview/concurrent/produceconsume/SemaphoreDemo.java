package com.tosim.interview.concurrent.produceconsume;

import sun.awt.windows.ThemeReader;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private static class Storage {

        private final int MAX_SIZE = 100;

        private List<Object> list = new LinkedList<Object>();
        private Semaphore mutex = new Semaphore(1);
        private Semaphore empty = new Semaphore(MAX_SIZE);
        private Semaphore full = new Semaphore(0);

        public void produce() {
            try {
                empty.acquire();
                mutex.acquire();
                list.add(new Object());
                mutex.release();
                full.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void consume() {
            try {
                full.acquire();
                mutex.acquire();
                list.remove(0);
                mutex.release();
                empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Storage storage = new Storage();

        Runnable producer = new Runnable() {
            public void run() {
                while(true){
                    storage.produce();
                    try {
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable consumer = new Runnable() {
            public void run() {
                while(true){
                    storage.consume();
                    try {
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(consumer).start();
        new Thread(producer).start();
    }
}
