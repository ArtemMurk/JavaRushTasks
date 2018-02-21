package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1W = reader.readLine();
        String file2R = reader.readLine();
        String file3R = reader.readLine();
        FileOutputStream file1 = new FileOutputStream(file1W);
        FileInputStream file2 = new FileInputStream(file2R);
        FileInputStream file3 = new FileInputStream(file3R);
        int readFile;
        byte[] buffer = new byte[file2.available()];

        while(file2.available()>0){
            file2.read(buffer);
            file1.write(buffer);
        }
        buffer = new byte[file3.available()];
        while(file3.available()>0){
            file3.read(buffer);
            file1.write(buffer);
        }

        file1.close();
        file2.close();
        file3.close();
    }
}
