package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 24; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }

        cache.remove((long)40);
    }


}