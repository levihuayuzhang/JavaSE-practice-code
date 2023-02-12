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

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        thread1.start();
    }
}
