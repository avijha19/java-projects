package com.thread;

public class ManyNames {

    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.setName("Avinash");
        t2.setName("Abha");
        t3.setName("Aatreya");


        t1.start();
        System.out.println(t1.getState());
//        t2.start();
//        t3.start();

    }

}
