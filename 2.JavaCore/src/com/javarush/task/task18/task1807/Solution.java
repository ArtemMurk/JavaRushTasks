package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
        int countZ = 0;
        while (fileIn.available()>0) {
            if (fileIn.read() == 44) {countZ++; }
        }
        fileIn.close();
        reader.close();
        System.out.println(countZ);
    }
}
