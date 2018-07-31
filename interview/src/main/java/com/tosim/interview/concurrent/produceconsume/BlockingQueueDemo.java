package com.tosim.interview.concurrent.produceconsume;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueDemo {

    private static class Storage {

        private BlockingQueue<Object> list = new LinkedBlockingQueue<Object>();

        public void produce() {
            try {
                list.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void consume() {
            try {
                list.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Storage storage = new Storage();

        for(int i = 0;i < 10;i++){
            Thread producer = new Thread(new Runnable() {
                public void run() {
                    storage.produce();
                }
            });

            Thread consumer = new Thread(new Runnable() {
                public void run() {
                    storage.consume();
                }
            });

            consumer.start();
            producer.start();
        }

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
    }
}
