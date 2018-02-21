package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue();

    public static void main(String[] args) {

        

//        Tablet tablet = new Tablet(5);
//        Cook cookPetrucci = new Cook("Petrucci");
//        Waiter waiterDaniel = new Waiter();
//        tablet.addObserver(cookPetrucci);
//        cookPetrucci.addObserver(waiterDaniel);
//
//        tablet.createOrder();
//
//        DirectorTablet directorTablet = new DirectorTablet();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printArchivedVideoSet();
//        directorTablet.printCookWorkloading();

        List<Tablet> listTablet = new ArrayList<>();
        Cook cookPetrucci = new Cook("Petrucci");
        Cook cookFrancesko = new Cook("Francesco");
        cookPetrucci.setQueue(orderQueue);
        cookFrancesko.setQueue(orderQueue);
        Waiter waiterDaniel = new Waiter();
        Waiter waiterOliver = new Waiter();
        cookPetrucci.addObserver(waiterDaniel);
        cookFrancesko.addObserver(waiterOliver);
        Thread franceskoThread =new Thread(cookFrancesko);
        Thread petrucciThread =new Thread(cookPetrucci);
        franceskoThread.setDaemon(true);
        petrucciThread.setDaemon(true);
        franceskoThread.start();
        petrucciThread.start();

        for (int i = 0; i <5 ; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            listTablet.add(tablet);
        }

        Thread threadTablet = new Thread(new RandomOrderGeneratorTask(listTablet, ORDER_CREATING_INTERVAL));
        threadTablet.start();

    }
}
