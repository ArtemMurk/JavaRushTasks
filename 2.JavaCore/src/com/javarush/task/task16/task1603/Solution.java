package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread sp1 = new SpecialThread();
        Thread thread1 = new Thread(sp1);
        list.add(thread1);

        SpecialThread sp2 = new SpecialThread();
        Thread thread2 = new Thread(sp2);
        list.add(thread2);

        SpecialThread sp3 = new SpecialThread();
        Thread thread3 = new Thread(sp3);
        list.add(thread3);

        SpecialThread sp4 = new SpecialThread();
        Thread thread4 = new Thread(sp4);
        list.add(thread4);

        SpecialThread sp5 = new SpecialThread();
        Thread thread5 = new Thread(sp5);
        list.add(thread5);
        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
