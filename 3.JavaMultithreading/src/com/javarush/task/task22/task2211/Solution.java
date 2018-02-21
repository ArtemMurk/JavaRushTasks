package com.javarush.task.task22.task2211;

import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        try(FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1]);)
        {
            byte[] buffer = new byte[1000];
        while (fis.available()>0){

            Charset utf8 = Charset.forName("UTF-8");
            Charset windows1251 = Charset.forName("Windows-1251");

            fis.read(buffer);
            String s = new String(buffer, windows1251);
            buffer = s.getBytes(utf8);
            fos.write(buffer);



        }


        }

    }
}
