package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file1 = new FileInputStream(args[0]);
        int[] occurency = new int[256];
        int readByte;
        while (file1.available()>0 ){
            readByte = file1.read();
            occurency[readByte]++;
        }
        for (int i = 0; i < occurency.length ; i++) {
            if (occurency[i]>0){
                System.out.println(((char) i)+" "+occurency[i]);
            }
        }
        file1.close();
    }
}
