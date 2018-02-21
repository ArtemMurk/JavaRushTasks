package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {

            System.out.println("begin-" + index);
            Thread.yield();

            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new YieldRunnable(1));
        Thread thread2 = new Thread(new YieldRunnable(2));
        Thread thread3 = new Thread(new YieldRunnable(3));
        Thread thread4 = new Thread(new YieldRunnable(4));
        Thread thread5 = new Thread(new YieldRunnable(5));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
