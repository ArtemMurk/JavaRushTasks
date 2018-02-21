package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;


    private Trio<List<Advertisement>, Long, Integer> advertismentListsTrio;

    // Рекурсионное нахождение последовательности рекламных роликов.
    private void recursionForBestAd(List<Advertisement> initialList,List<Advertisement> newList,int timeCook, long totalAmount ){

        for (int i = 0; i < initialList.size() ; i++) {
            Advertisement advertisement = initialList.get(i);

            if ((advertisement.getDuration()+timeCook)<=timeSeconds){

                List<Advertisement> listForRecNew = new ArrayList<>();
                listForRecNew.addAll(newList);
                listForRecNew.add(advertisement);
                List<Advertisement> listForRecInitial = new ArrayList<>();
                listForRecInitial.addAll(initialList);
                listForRecInitial.remove(advertisement);

                recursionForBestAd(listForRecInitial,listForRecNew, timeCook+advertisement.getDuration(), totalAmount+advertisement.getAmountPerOneDisplaying());
            }
            else {
                    if (advertismentListsTrio != null) {
                        if (
                                (totalAmount > advertismentListsTrio.getValue()) ||
                                        (totalAmount == advertismentListsTrio.getValue() && timeCook > advertismentListsTrio.getElementThree()) ||
                                        (totalAmount == advertismentListsTrio.getValue() && timeCook == advertismentListsTrio.getElementThree() && (newList.size() < advertismentListsTrio.getKey().size()))) {
                            advertismentListsTrio = new Trio<>(newList, totalAmount, timeCook);
                        }
                    } else advertismentListsTrio = new Trio<>(newList, totalAmount, timeCook);

            }
        }

        if (advertismentListsTrio != null){
            if (
                    (totalAmount> advertismentListsTrio.getValue())||
                            (totalAmount== advertismentListsTrio.getValue()&& timeCook>advertismentListsTrio.getElementThree())||
                            (totalAmount== advertismentListsTrio.getValue()&& timeCook==advertismentListsTrio.getElementThree() && (newList.size()<advertismentListsTrio.getKey().size())) ){
                advertismentListsTrio = new Trio<>(newList,totalAmount,timeCook);
            }
        }
        else advertismentListsTrio = new Trio<>(newList,totalAmount,timeCook);
    }

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException{
        List<Advertisement> listInitial = storage.list();
        if (listInitial.isEmpty()) throw new NoVideoAvailableException();

        List<Advertisement> list= new ArrayList<>();
        listInitial.forEach((ad)->{if (ad.getHits()>0) list.add(ad);});

        recursionForBestAd(list,new ArrayList<Advertisement>(),0,0);
        Collections.sort(advertismentListsTrio.getKey(),(ad1,ad2)->{return (int)(ad2.getAmountPerOneDisplaying()-ad1.getAmountPerOneDisplaying());});
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advertismentListsTrio.elementKey,advertismentListsTrio.elementValue,advertismentListsTrio.elementThree));
        for (Advertisement advertisement : advertismentListsTrio.getKey()) {
            ConsoleHelper.writeMessage(advertisement.getName()+" is displaying... "+advertisement.getAmountPerOneDisplaying()+", "+(int)(((double)advertisement.getAmountPerOneDisplaying()/(double) advertisement.getDuration())*1000));
            advertisement.revalidate();
        }
    }


    class Trio<K, V,M> {

        private final K elementKey;
        private final V elementValue;
        private final M elementThree;



        public Trio(K elementKey, V elementValue, M elementThree) {
            this.elementKey = elementKey;
            this.elementValue = elementValue;
            this.elementThree = elementThree;
        }

        public K getKey() {
            return elementKey;
        }

        public V getValue() {
            return elementValue;
        }
        public M getElementThree() {
            return elementThree;
        }


    }

}

