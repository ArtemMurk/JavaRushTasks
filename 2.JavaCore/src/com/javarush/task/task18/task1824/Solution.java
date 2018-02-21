package com.javarush.task.task18.task1824;
///home/artem/primer.txt

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file="null";

        try {
            while (true) {
                file = reader.readLine();

                FileInputStream fileIN2 = new FileInputStream(file);
                fileIN2.close();
            }
        }
        catch (FileNotFoundException e){
            System.out.println(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        reader.close();



    }
}

