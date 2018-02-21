package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInput = new FileInputStream(reader.readLine());
        int readElement;

        int maxElement = 0;

        while (fileInput.available()>0){
            readElement = fileInput.read();
            if (readElement > maxElement)
                maxElement = readElement;
        }
        fileInput.close();
        reader.close();
        System.out.println(maxElement);
    }
}
