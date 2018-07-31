package com.tosim.interview.concurrent.produceconsume;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo {

    private static class Storage {

        private final int MAX_SIZE = 100;

        private List<Object> list = new LinkedList<Object>();
        private Lock lock = new ReentrantLock();
        private Condition empty = lock.newCondition();
        private Condition full = lock.newCondition();

        public void produce() {
            lock.lock();
            try {
                while (list.size() == MAX_SIZE) {
                    System.out.println(String.format("库存空位:%d 大于剩余可存放的数量", MAX_SIZE - list.size()));
                    full.await();
                }
                list.add(new Object());
                System.out.println(String.format("%s 生产了1件商品", Thread.currentThread().getName()));
                empty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void consume() {
            lock.lock();
            try {
                while (list.size() == 0) {
                    System.out.println(String.format("库存容量:%d 大于剩余可消费的数量", list.size()));
                    empty.await();
                }
                list.remove(0);
                System.out.println(String.format("%s 消费了1件商品", Thread.currentThread().getName()));
                full.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Producer implements Runnable {

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

        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(storage), "consumer-" + i).start();
            new Thread(new Producer(storage), "producer-" + i).start();
        }
    }
}
