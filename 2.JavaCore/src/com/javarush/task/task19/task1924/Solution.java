package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            String[] data = line.split(" ");
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i <data.length ; i++) {
                if (data[i].matches("^\\d+$")) {
                    if (Integer.parseInt(data[i])<=12 && Integer.parseInt(data[i])>=0){
                        data[i] = map.get(Integer.parseInt(data[i]));
                    }
                }
                buffer.append(data[i]+" ");
            }

            System.out.println(buffer.toString().trim());

        }
        fileReader.close();
    }
}
