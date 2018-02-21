package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader==null) return "";
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringWriter writer = new StringWriter();
        byte[] bufferedBytes;
        String stringInBufferedReader;
        while ((stringInBufferedReader=bufferedReader.readLine())!=null){
            bufferedBytes = stringInBufferedReader.getBytes();
            for (int i = 0; i < bufferedBytes.length ; i++) {
                if (bufferedBytes[i]== 32||bufferedBytes[i]==10)writer.write(bufferedBytes[i]);
                else writer.write(bufferedBytes[i]+key);
            }
        }
        bufferedReader.close();
        return writer.toString();
    }

}
