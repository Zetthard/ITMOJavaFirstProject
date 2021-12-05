package zetthard.lesson12;

import java.util.concurrent.locks.Lock;

public class Threads {

    public static void main(String[] args) throws InterruptedException {

        //12.1 and 12.2 test
        /*for (int i = 0; i <= 10; i++) {
            Thread tempThread = new MyThread1();
            System.out.println(tempThread.getState());
            tempThread.start();
            System.out.println(tempThread.getState());
        }*/

        //12.3 test (works as intended. In my case, synchronization is not needed.)
        /*Counter counter = new Counter();
        for (int i = 0; i < 100; i++) {
            Thread tempThread = new MyThread2();
            tempThread.start();
            for (int j = 0; j < 1000; j++) {
                counter.increment();
            }
        }
        System.out.println(counter.getCount());*/

        //12.4 test
        Thread thread_1 = new MyThread3();
        Thread thread_2 = new MyThread3();
        thread_1.start();
        thread_2.start();

    }


}

//12.1 - 12.2
class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            String name = Thread.currentThread().getName();
            String state = Thread.currentThread().getState().toString();
            System.out.printf("%s, (%s) prints: %d\n", name, state, i);
        }
    }
}

//12.3
class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
    }
}

//12.4
class MyThread3 extends Thread {
    public final static Object lock = new Object();
    static volatile int counter = 0;

    @Override
    public void run() {
        synchronized (lock) {
            while (counter <= 100000) {
                System.out.println(Thread.currentThread().getName() + " prints " + counter);
                counter++;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notifyAll();
        }
    }
}

