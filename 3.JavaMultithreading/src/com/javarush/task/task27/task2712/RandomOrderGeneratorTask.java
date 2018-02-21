package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private  List<Tablet> tablets = new ArrayList<>();
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet>tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(interval);
                Tablet randomTablet = tablets.get((int)(Math.random()*(tablets.size())));

                randomTablet.createTestOrder();
            } catch (InterruptedException e) {

            }
        }

    }
}
