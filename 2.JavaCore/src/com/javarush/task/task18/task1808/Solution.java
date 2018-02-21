package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1R = reader.readLine();
        String file2R = reader.readLine();
        String file3R = reader.readLine();
        FileInputStream file1 = new FileInputStream(file1R);
        FileOutputStream file2 = new FileOutputStream(file2R);
        FileOutputStream file3 = new FileOutputStream(file3R);

        int count = file1.available();
        while (file1.available()>0){
            if(count%2 ==0) {
                byte[] buffer = new byte[count/2];
                file1.read(buffer);
                file2.write(buffer);
                System.out.println(buffer.length);
                file1.read(buffer);
                file3.write(buffer);
                System.out.println(buffer.length);
            }
            else {
                byte[] buffer = new byte[count/2+1];
                file1.read(buffer);
                file2.write(buffer);
                System.out.println(buffer.length);
                int countBytes = file1.read(buffer);
                file3.write(buffer, 0, countBytes);
                System.out.println(countBytes);
            }

        }
        System.out.println(count);
        System.out.println(count);
        reader.close();
        file1.close();
        file2.close();
        file3.close();

    }
}

