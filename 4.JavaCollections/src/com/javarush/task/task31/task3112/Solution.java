package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://storage.googleapis.com/fiber/share-graphics/city-home/triangle.jpg", Paths.get("/home/artem/test/"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
//        String fileName = urlString.substring(urlString.lastIndexOf("/")+1, urlString.length());
         String fileName = Paths.get(urlString).getFileName().toString();
        InputStream inputStream = url.openStream();
//        Path tmpDir = Files.createTempDirectory("tmpDir");
        Path tmpFile = Files.createTempFile( "tmp1",".tmp");
        Files.copy(inputStream, tmpFile);
        Path finalPath = Files.move(tmpFile,downloadDirectory.resolve(fileName));
        inputStream.close();
       return finalPath; // implement this method
    }
}
