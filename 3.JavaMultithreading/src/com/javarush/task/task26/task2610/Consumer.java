package com.javarush.task.task26.task2610;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable{
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                Thread.sleep(350);
                System.out.println(queue.take());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
