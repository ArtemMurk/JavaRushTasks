package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    public static StatisticManager getInstance() {
        if  (ourInstance == null)  ourInstance= new StatisticManager();
        return ourInstance;
    }



    private StatisticManager() {
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }



    public Map<String,Long> getAdvertisementAmount(){
        Map<String,Long> map = new TreeMap<>();
        for ( Map.Entry<EventType, List<EventDataRow>> pair: statisticStorage.getStorage().entrySet()) {
            if (pair.getKey() == EventType.SELECTED_VIDEOS) {

                for (EventDataRow dataRow : pair.getValue()) {
                    VideoSelectedEventDataRow dataPerOrder = (VideoSelectedEventDataRow) dataRow;
                    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    String dateFormat = formatter.format(dataRow.getDate());
                    if (map.containsKey(dateFormat)) {
                        long amountCounter = dataPerOrder.getAmount() + map.get(dateFormat);
                        map.put(dateFormat, amountCounter);
                    } else {
                        map.put(dateFormat, dataPerOrder.getAmount());
                    }
                }
            }
        }
        return map;
    }

    public Map<String,Map<String, Integer>> getCookWorkloading(){
        Map<String,Map<String, Integer>> map = new TreeMap<>();
        for ( Map.Entry<EventType, List<EventDataRow>> pair: statisticStorage.getStorage().entrySet()) {
            if (pair.getKey() == EventType.COOKED_ORDER) {

                for (EventDataRow dataRow : pair.getValue()) {
                    CookedOrderEventDataRow dataPerOrder = (CookedOrderEventDataRow) dataRow;
                    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    String dateFormat = formatter.format(dataRow.getDate());
                    if (dataPerOrder.getCookingTimeSeconds()>0){
                        String cookName = dataPerOrder.getCookName();

                        if (map.containsKey(dateFormat)) {
                            if (map.get(dateFormat).containsKey(cookName)){
                                int timeCounter = (dataPerOrder.getCookingTimeSeconds()/60)+map.get(dateFormat).get(cookName);
                                        map.get(dateFormat).put(cookName,timeCounter);
                            }
                            else map.get(dateFormat).put(cookName,(dataPerOrder.getCookingTimeSeconds()/60));
                        } else {
                            map.put(dateFormat, new TreeMap<>());
                            map.get(dateFormat).put(cookName,(dataPerOrder.getCookingTimeSeconds()/60));
                        }

                    }

                }
            }
        }
        return map;
    }


    private class StatisticStorage{
        private  Map<EventType, List<EventDataRow>> storage;

        private StatisticStorage() {
            storage = new HashMap<>();
            EventType[] arrayType = EventType.values();

            for (EventType eventType: arrayType) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            statisticStorage.storage.get(data.getType()).add(data);
        }

        private Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
