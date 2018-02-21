package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;


public class Cook extends Observable implements Runnable  {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }


    public Cook(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public void update(Observable observable, Object o) {
//        StatisticManager.getInstance().register(new CookedOrderEventDataRow(observable.toString(),name,((Order)o).getTotalCookingTime()*60,((Order)o).getDishes()));
//
//        ConsoleHelper.writeMessage("Start cooking - "+o+", cooking time "+ ((Order)o).getTotalCookingTime()+"min");
//        this.setChanged();
//        this.notifyObservers(o);
//
//    }

    public void startCookingOrder(Order order){
        busy=true;
//        StatisticManager.getInstance().register(new CookedOrderEventDataRow(observable.toString(),name,((Order)o).getTotalCookingTime()*60,((Order)o).getDishes()));
        ConsoleHelper.writeMessage("Start cooking - "+order+", cooking time "+ order.getTotalCookingTime()+"min");

        try {
            Thread.sleep(order.getTotalCookingTime()*10);
        } catch (InterruptedException e) {

        }
        this.setChanged();
        this.notifyObservers(order);
        busy = false;
    }

    @Override
    public void run() {
//        while (true){
//            if (queue.size()>0){
//                Set<Cook> cooks = StatisticManager.getInstance().getCooks();
//                for (Cook cook: cooks) {
//                    if (!cook.isBusy()){
//                        cook.startCookingOrder(queue.poll());
//                        break;
//                    }
//                }
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//
//                }
//            }
//            else {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//
//                }
//            }
//
//        }
        while (true){
            if (queue.size()>0 && !isBusy()) {
                startCookingOrder(queue.poll());
            } else
                    try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }


        }
    }
}
