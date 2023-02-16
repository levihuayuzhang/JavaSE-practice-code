package com.ph1nix.javase.thread;

/**
 * Multi-Thread Creating, method two: create a class that implement Runnable Interface
 * 1. implement run() of interface
 * 2. create the object of current class
 * 3. pass the object as a parameter to constructor of Thread class
 * 4. create instance of Thread and call start()
 *
 * pro:
 * 1. avoid short of single inheratance
 * 2. (more suitable for task that need to share data) can share attribute of instances (by passing same object into different thread)
 * 3. more readable (separate data and code)
 *
 * (Proxy mode)
 * Thread implement Runnable and take a Runnable as parameter in constructor
 *
 * @author Huayu Zhang
 * @create 2023-02-16-12:31 PM
 */
public class RunnableInterface {
    public static void main(String[] args) {
        EventNumberPrint eventNumberPrint = new EventNumberPrint();
        // thread 0
        new Thread(eventNumberPrint).start();
        // thread 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }).start();
        // main
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class EventNumberPrint implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
