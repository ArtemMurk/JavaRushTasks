package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance;

    private final List<Advertisement> videos = new ArrayList<>();


    public static AdvertisementStorage getInstance() {
        if (ourInstance == null) ourInstance = new AdvertisementStorage();

        return ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
//        videos.add(new Advertisement(someContent, "1", 100, 10, 3 * 60));
//        videos.add(new Advertisement(someContent, "2", 100, 10, 15 * 60));
//        videos.add(new Advertisement(someContent, "3", 400, 2, 10 * 60));
//        videos.add(new Advertisement(someContent, "4", 400, 2, 20 * 60));
//        videos.add(new Advertisement(someContent, "5", 400, 2, 40 * 60));
//        videos.add(new Advertisement(someContent, "6", 400, 2, 30 * 60));
//        videos.add(new Advertisement(someContent, "7", 50, 10, 1 * 60));
//        videos.add(new Advertisement(someContent, "8", 50, 10, 2 * 60));
//        videos.add(new Advertisement(someContent, "9", 7000, -1, 10 * 60));


//        Object content = new Object();
//        Advertisement a1 = new Advertisement(content, "JJJ1", 101, 2, 25 * 60);
//        Advertisement a2 = new Advertisement(content, "JJJ2", 205, 2, 6 * 60);
//        Advertisement a3 = new Advertisement(content, "JJJ3", 50222, 10, 10 * 60);
//        Advertisement a4 = new Advertisement(content, "JJJ4", 2077, 2, 4 * 60);
//        Advertisement a6 = new Advertisement(content, "JJJ6", 205, 1, 10 * 60 - 1);
//        Advertisement a7 = new Advertisement(content, "JJJ7", 75, -1, 300 * 60);
//        Advertisement a8 = new Advertisement(content, "JJJ8", 12, 1, 3 * 60);
//
//        videos.add(a1);
//        videos.add(a2);
//        videos.add(a3);
//        videos.add(a4);
//        videos.add(a6);
//        videos.add(a7);
//        videos.add(a8);


    }

    public List<Advertisement> list(){
        return videos;
    }



    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }

}
