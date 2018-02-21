package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
        int readByte = 0;
        int repeatCount = 0;
        int[] arrayCol = new int[256];

        while (fileIn.available()>0) {
            readByte = fileIn.read();
            arrayCol[readByte] += 1;
            if (repeatCount < arrayCol[readByte]) { repeatCount = arrayCol[readByte];}
        }

        for (int i = 0; i < arrayCol.length ; i++) {
            if (arrayCol[i] == 1){
                System.out.print(i+" ");
            }
        }
        fileIn.close();
        reader.close();
    }
}
