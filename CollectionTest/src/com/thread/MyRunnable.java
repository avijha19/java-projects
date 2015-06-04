package com.thread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
       System.out.println("Runnable" +Thread.currentThread().getName() + "is running");
       System.out.println("Thread name" + Thread.currentThread().getName());
       System.out.println("Thread state" + Thread.currentThread().getState());
       Thread.currentThread().destroy();

       System.out.println("Thread id" + Thread.currentThread().getId());


    }

}
