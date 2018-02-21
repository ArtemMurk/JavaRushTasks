package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                if (throwable instanceof Error) {System.out.println("Нельзя дальше работать"); return;}
                if (throwable instanceof Exception) {System.out.println("Надо обработать"); return;}
                if (throwable instanceof Throwable) {System.out.println("ХЗ"); return;}
            }
        });
    }

    public static void main(String[] args) {
    }
}
