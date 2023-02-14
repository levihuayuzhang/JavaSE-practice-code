package com.ph1nix.javase;

/**
 * Multi-Thread Creating, method one: inheritance from Class Thread
 * 1. create one class inheritance from Thread
 * 2. Override Thread.run() --> state the operations of this thread
 * 3. create object
 * 4. object.start()
 *
 * Example: ergodic even numbers less than 100
 *
 * @author Huayu Zhang
 * @create 2023-02-12-3:06 PM
 */

class EvenNumber extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class OddNumber extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {

//        EvenNumber thread1 = new EvenNumber();
//        OddNumber thread2 = new OddNumber();
//
////        thread1.run(); // not multi-thread
//
//        thread1.start(); // multi-thread (start thread, then run)
////        thread1.start(); // started thread cannot be executed multi-times
//        thread2.start(); // multi-thread (start thread, then run)


        // Anonymous subclass's anonymous objects
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();


        // main thread test
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
