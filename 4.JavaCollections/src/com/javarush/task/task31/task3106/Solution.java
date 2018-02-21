package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFile = args[0];
//        Path file = Paths.get(args[0]);
//        if (Files.exists(file)) Files.delete(file);
//        Path path = Files.createFile(file);

        ArrayList<String> zipArchList = new ArrayList<>();
        for (int i = 1; i < args.length ; i++) {
            zipArchList.add(args[i]);
        }

        zipArchList.sort((String first, String second)-> first.compareTo(second) );

        ArrayList<InputStream> listStreamIn=new ArrayList<>();
        zipArchList.forEach((String s) -> {
            try {
                listStreamIn.add(new FileInputStream(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });


            try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(listStreamIn)));
            FileOutputStream out =new FileOutputStream(resultFile)){
                System.out.println(zipInputStream.getNextEntry().toString());
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipInputStream.read(buffer))>0){
                    out.write(buffer, 0 , count);
                    out.flush();
                }

            }





    }
}
