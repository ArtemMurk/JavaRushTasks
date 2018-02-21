package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileIn = new FileInputStream(args[0]);
        int fileInput;
        int countByte=0;
        while (fileIn.available()>0){
            fileInput = fileIn.read();
            String f = Character.toString((char) fileInput);

            if (f.matches("[A-Za-z]")){
                countByte++;
            }
        }
        fileIn.close();
        System.out.println(countByte);
    }
}
