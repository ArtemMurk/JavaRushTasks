package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String num = "12";
        Pattern pattern1 = Pattern.compile("^\\d+$");
        Matcher m = pattern1.matcher(num);
        if (m.matches()){
            System.out.println("good");}


        if (num.matches("[-+]?\\d+")) System.out.println("chislo");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileIn = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName2));
        StringBuffer buffer = new StringBuffer();
        while (fileIn.ready()){
            String lineIn = fileIn.readLine();
            String[] line = lineIn.split(" ");
            for (int i = 0; i < line.length ; i++) {
                if (line[i].matches("[-+]?\\d+")){
                    buffer.append(line[i]+" ");
                }
            }
            fileOut.write(buffer.toString());
        }
        fileIn.close();
        fileOut.close();
    }
}
