package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader fileBuffReader = new BufferedReader(fileReader);
        while (fileBuffReader.ready()){
            String[] data = fileBuffReader.readLine().split(" ");
            for (int i = 0; i < data.length ; i++) {
                if (data[i].matches("^.*\\d+.*$")) {
                    System.out.println(data[i]);
                    fileWriter.write(data[i] + " ");
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
