package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
            StringBuilder sb = new StringBuilder();
                for (int i = 0; i <thread.getName().length() ; i++) {
                    sb.append("*");
                }
                String s = throwable.getMessage().replaceAll(thread.getName(), sb.toString());
                System.out.println(s);
            }
        };    //init handler here
    }

    public void run() {
        try {
            original.run();
            throw new Error();

        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Solution sol = new Solution(new TimerTask() {
            @Override
            public void run() {
                while (true)
                System.out.println(1);
            }
        });
    }
}