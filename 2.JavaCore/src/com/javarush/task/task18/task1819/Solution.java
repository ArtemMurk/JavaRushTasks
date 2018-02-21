package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException,InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream file1r = new FileInputStream(file1);

        byte[] buffer = new byte[file1r.available()];
        while (file1r.available()>0){
            file1r.read(buffer);
        }
        FileOutputStream file1w = new FileOutputStream(file1);
        FileInputStream file2r = new FileInputStream(file2);


        byte[] buffer2 = new byte[file2r.available()];
        while (file2r.available()>0){
            file2r.read(buffer2);
            file1w.write(buffer2);
            Thread.currentThread().yield();
        }

        file1w.write(buffer);


        file1r.close();

        file2r.close();
        file1w.close();

    }
}
