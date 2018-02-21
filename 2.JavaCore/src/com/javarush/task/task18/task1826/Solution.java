package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileIn = new FileInputStream(args[1]);
        FileOutputStream fileOut = new FileOutputStream(args[2]);
        if (args[0].equals("-e")){
            byte[] buffer = new byte[fileIn.available()];
            fileIn.read(buffer);
            for (int i = 0; i < buffer.length-1 ; i++) {
                byte changeByte = buffer[i];
                buffer[i]= buffer[i+1];
                buffer[i+1] = changeByte;
            }
            fileOut.write(buffer);
        }

        if (args[0].equals("-d")){
            byte[] buffer = new byte[fileIn.available()];
            while (fileIn.available()>0){fileIn.read(buffer);}
            for (int i = buffer.length-1; i>0 ; i--) {
                byte changeByte = buffer[i];
                buffer[i]= buffer[i-1];
                buffer[i-1] = changeByte;
                            }
            fileOut.write(buffer);
        }
        fileIn.close();
        fileOut.close();
    }

}
