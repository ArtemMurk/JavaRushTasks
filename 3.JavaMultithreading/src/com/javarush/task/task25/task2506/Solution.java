package com.javarush.task.task25.task2506;

import java.io.IOException;

/*
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        Thread.sleep(100);
        target.start();  //NEW
        Thread.sleep(100); //RUNNABLE
        target.join(100);
        Thread.sleep(400);
        target.interrupt(); //TERMINATED
        Thread.sleep(500);
        Thread.sleep(500);
        System.out.println(loggingStateThread.getState());
        Thread.sleep(1000);
    }
}
    class LoggingStateThread extends Thread{
    private Thread thread;
    private State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()) {
        if (state != thread.getState()) {
            state = thread.getState();
            System.out.println(thread.getState());
        }
        if (state == State.TERMINATED){
            this.interrupt();
        }
        }
    }
}
