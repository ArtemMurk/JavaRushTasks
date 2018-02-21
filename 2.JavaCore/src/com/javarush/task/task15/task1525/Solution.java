package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) throws IOException{

        System.out.println(lines);
    }
    static {
        try {

            lines = Files.readAllLines(Paths.get(Statics.FILE_NAME));
        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }

}
