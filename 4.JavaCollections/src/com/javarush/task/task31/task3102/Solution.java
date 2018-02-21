package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        LinkedList<String> files = new LinkedList<>();
        ArrayDeque<File> directorys = new ArrayDeque<>();
        directorys.add(new File(root));

        while (directorys.size()>0){
            for (File file: directorys.getFirst().listFiles()) {
                if (file.isDirectory()) directorys.add(file);
                else files.add(file.getAbsolutePath());
            }
            directorys.remove();
        }
        return files;

    }

    public static void main(String[] args) throws IOException {
        List<String> files = getFileTree("/home/artem/");
        for (String file: files) {
            System.out.println(file);
        }
    }
}
