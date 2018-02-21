package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader file1R = new FileReader(file1);
        Scanner files = new Scanner(file1R);
        FileWriter file2W = new FileWriter(file2);

        while (files.hasNextLine()){
            String[] c = files.nextLine().split(" ");
            for (int i = 0; i < c.length ; i++) {
                String v = String.valueOf(Math.round(Double.parseDouble(c[i])))+" ";
                file2W.write(v);
            }
        }
        file1R.close();
        file2W.close();
    }
}
