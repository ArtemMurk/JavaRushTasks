package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> mapData = new TreeMap<>();
        FileReader fileR = new FileReader(args[0]);
        BufferedReader fileBuff = new BufferedReader(fileR);
        while (fileBuff.ready()){
            String[] data = fileBuff.readLine().split(" ");
            if(mapData.containsKey(data[0])) mapData.put(data[0], mapData.get(data[0])+ Double.parseDouble(data[1]));
            else mapData.put(data[0],  Double.parseDouble(data[1]));
        }
        fileR.close();
        for (Map.Entry<String, Double> sets: mapData.entrySet()) {
            System.out.println(sets.getKey()+" "+sets.getValue());
        }
    }
}
