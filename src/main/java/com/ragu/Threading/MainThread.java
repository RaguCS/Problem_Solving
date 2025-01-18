package com.ragu.Threading;
class ThreadClass extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        ThreadClass tc = new ThreadClass();
        tc.start();
        System.out.println(tc.isAlive()+tc.getName());
        Thread.sleep(10000);
        System.out.println(tc.isAlive()+tc.getName());
    }
}
