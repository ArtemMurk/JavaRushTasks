package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private Order order;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;


    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public Order createOrder(){
        try {
            order = new Order(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
            return null;
        }
        orderCreatePartB();
        return order;
    }

    public void createTestOrder(){
        try {
            order = new TestOrder(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
            return;
        }
        orderCreatePartB();
    }

    private void orderCreatePartB() {
        if (!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
//            this.setChanged();
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            try {
                advertisementManager.processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
//            this.notifyObservers(this.order);
            queue.offer(order);
        }
    }


    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
