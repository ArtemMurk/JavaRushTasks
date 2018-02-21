package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
        int minByte = fileIn.read();
        int readByte;
        while (fileIn.available()> 0) {
            readByte = fileIn.read();
            if (readByte < minByte) {
                minByte = readByte;
            }
        }
        System.out.println(minByte);
        fileIn.close();
        reader.close();
    }
}
