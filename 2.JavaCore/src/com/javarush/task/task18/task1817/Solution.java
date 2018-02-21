package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileThread = args[0];
        FileInputStream fileIn = new FileInputStream(fileThread);
        double countWhitespace = 0;
        double countSymbol = 0;
        int readSymbol;
        while (fileIn.available()>0){
            readSymbol = fileIn.read();
            countSymbol++;
            if (readSymbol == 32) countWhitespace++;
        }
        double attitude = (double)((countWhitespace*100)/countSymbol);
        System.out.printf("%.2f", (countWhitespace*100)/countSymbol);
        fileIn.close();
    }
}
