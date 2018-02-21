package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    TransferQueue<ShareItem> queue;
    public Producer(TransferQueue<ShareItem> queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
            for (int i = 1; i <= 9 ; i++) {
                ShareItem shareItem =new ShareItem("ShareItem-"+i,i);
                System.out.format("Элемент 'ShareItem-%s' добавлен%n",i);
                queue.offer(shareItem);
                    try {
                        Thread.sleep(100);
                        if (queue.hasWaitingConsumer()) {
                            System.out.format("Consumer в ожидании!%n");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

        }
    }
}
