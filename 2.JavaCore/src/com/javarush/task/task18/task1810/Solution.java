package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            FileInputStream file1 = new FileInputStream(reader.readLine());
            try {
                if (file1.available()<1000){
                    throw new DownloadException();
                }
            }
            finally {
                file1.close();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
