package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()){
            builder.append((char) fileReader.read());
        }

        StringBuilder fileW = new StringBuilder();
        String[] data = builder.toString().replaceAll("\\n", " ").split(" ");
        for (int i = 0; i < data.length ; i++) {
            if (data[i].matches("[.[^ ]]{7,}")){
                fileW.append(data[i]+",");
            }
        }
        fileWriter.write(fileW.substring(0,fileW.length()-1));


        fileReader.close();
        fileWriter.close();
    }
}
