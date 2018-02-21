package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.Console;
import java.util.List;
import java.util.Map;

public class DirectorTablet {
    private StatisticManager manager = StatisticManager.getInstance();
    private StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

    // Вывод статистики прибыли за день по датам
    public void printAdvertisementProfit(){
        Map<String,Long> profitPerDay = manager.getAdvertisementAmount();

        Double totalAmount=0.0;
        for (Map.Entry<String,Long> pair: profitPerDay.entrySet()) {
            Double amountPerDay = ((double)pair.getValue())/100;
            ConsoleHelper.writeMessage(String.format("%s - %.2f",pair.getKey(),amountPerDay));
            totalAmount +=amountPerDay;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f",totalAmount));
    }


    //вывод статистики по работе поваров в минутах за день
    public void printCookWorkloading(){

        Map<String,Map<String, Integer>> mapCookWork = manager.getCookWorkloading();

        for (Map.Entry<String,Map<String, Integer>> dateMap: mapCookWork.entrySet()) {
            ConsoleHelper.writeMessage(dateMap.getKey());
            for (Map.Entry<String, Integer> cookMap: dateMap.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", cookMap.getKey(),cookMap.getValue()));
            }
        }
    }

    public void printActiveVideoSet(){
        List<Advertisement> listActiveAd = statisticAdvertisementManager.getActiveVideoSet();
        listActiveAd.forEach((ad)->{
            ConsoleHelper.writeMessage(String.format("%s - %d", ad.getName(),ad.getHits()));
        });
    }

    public void printArchivedVideoSet(){
        List<Advertisement> listArchivedAd = statisticAdvertisementManager.getArchivedVideoSet();
        listArchivedAd.forEach((ad)->{
            ConsoleHelper.writeMessage(ad.getName());
        });
    }
}
