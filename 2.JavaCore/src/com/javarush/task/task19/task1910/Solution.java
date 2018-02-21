package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileIn = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName2));

        while (fileIn.ready()) {
            String lineIn = fileIn.readLine();
            fileOut.write(lineIn.replaceAll("\\p{Punct}",""));

        }
        fileIn.close();
        fileOut.close();
    }
}
