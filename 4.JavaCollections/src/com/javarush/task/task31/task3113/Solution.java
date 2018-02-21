package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private static int countDir = -1;
    private static int countFiles = 0;
    private static long countBytes  = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dir = reader.readLine();
        Path directory = Paths.get(dir);
        if (Files.isDirectory(directory)){
            Solution solution = new Solution();
            Files.walkFileTree(directory, solution);

            System.out.println("Всего папок - "+ countDir );
            System.out.println("Всего файлов - "+ countFiles );
            System.out.println("Общий размер - "+ countBytes );
        }
        else System.out.println(directory+" - не папка");

    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
        countDir++;
        return super.postVisitDirectory(path, e);
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        countFiles++;
        countBytes+= basicFileAttributes.size();
        return super.visitFile(path, basicFileAttributes);
    }
}
