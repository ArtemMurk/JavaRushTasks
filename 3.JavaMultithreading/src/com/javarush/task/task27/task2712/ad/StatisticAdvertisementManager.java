package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance;
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();;

    public static StatisticAdvertisementManager getInstance() {
        if (ourInstance==null) ourInstance = new StatisticAdvertisementManager();

        return ourInstance;
    }

    public List<Advertisement> getActiveVideoSet(){
        List<Advertisement> allVideoSet= advertisementStorage.list();

        List<Advertisement> listActiveAd= new ArrayList<>();
        allVideoSet.forEach((ad)->{if (ad.getHits()>0) listActiveAd.add(ad);});
        listActiveAd.sort((ad1, ad2) -> {
            return (int) (ad1.getName().toLowerCase().compareTo(ad2.getName().toLowerCase()) );
        });


        return listActiveAd;
    }

    public List<Advertisement> getArchivedVideoSet(){
        List<Advertisement> allVideoSet= advertisementStorage.list();

        List<Advertisement> listArchivedAd= new ArrayList<>();
        allVideoSet.forEach((ad)->{if (ad.getHits()<1) listArchivedAd.add(ad);});

        listArchivedAd.sort((ad1, ad2) -> {
            return (int) (ad1.getName().toLowerCase().compareTo(ad2.getName().toLowerCase()) );
        });

        return listArchivedAd;
    }

    private StatisticAdvertisementManager() {
    }
}
