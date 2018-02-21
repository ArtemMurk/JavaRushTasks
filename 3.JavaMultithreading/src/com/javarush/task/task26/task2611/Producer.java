package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 1;
        try {
            while (true) {
                map.put(String.valueOf(i), "Some text for "+i);
                Thread.sleep(300);
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" thread was terminated");
        }
    }
}
