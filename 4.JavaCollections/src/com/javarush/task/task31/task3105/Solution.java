package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("/home/artem/test/test.zip"));
//        zip.putNextEntry(new ZipEntry("file.txt"));
//
//        Path path = Paths.get("/home/artem/test/dfile1.txt");
//        Files.copy(path, zip);
//
//        zip.close();

//        Path fileP = Paths.get("null");
//        Path zipArchP = Paths.get(args[1]);
//        ArrayList<ByteArrayOutputStream> bytesQ = new ArrayList<>();
//        ArrayList<String> entriesQ = new ArrayList<>();
//
//        ZipInputStream zip = new ZipInputStream(new FileInputStream(zipArchP.toString()));
//        while (zip.available()>0){
//            ZipEntry zipEntry = zip.getNextEntry();
//            if (zipEntry!= null) {
//                    entriesQ.add(zipEntry.toString());
//
//                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                    int count = 0;
//                    byte[] buffer = new byte[1024];
//                    while ((count = zip.read(buffer)) != -1)
//                    byteArrayOutputStream.write(buffer, 0, count);
//
//
//                    bytesQ.add(byteArrayOutputStream);
//            }
//        }
//        zip.close();
//
//        Path fileP = Paths.get(args[0]);


//        Files.delete(zipArchP);
//        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipArchP.toString()));) {
////            ZipEntry newFilesEntry = new ZipEntry(fileP.getFileName().toString());
//            if (entriesQ.contains(fileP.getFileName().toString())) {
//                int index = entriesQ.indexOf(fileP.getFileName().toString());
//                FileInputStream
//                bytesQ.set(index, Files.readAllBytes(fileP));
//            }
//            else {
//                zipOut.putNextEntry(new ZipEntry(fileP.getFileName().toString()));
//                Files.copy(fileP, zipOut);
//            }
//            for (int i = 0; i < bytesQ.size() ; i++) {
//                zipOut.putNextEntry(new ZipEntry(entriesQ.get(i)));
//                zipOut.write(bytesQ.get(i));
//
//
//            }
//        }

        String zipFileName = args[1];
        Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();
        try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry entry;
            while ((entry = zipReader.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipReader.read(buffer)) != -1)
                    byteArrayOutputStream.write(buffer, 0, count);

                archivedFiles.put(entry.getName(), byteArrayOutputStream);
            }
        }

        String fileP = args[0];


        Files.delete(Paths.get(zipFileName));

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFileName))) {
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//            try(FileInputStream fis = new FileInputStream(fileP);) {
//                byte[] buffer = new byte[1024];
//                int count = 0;
//                while ((count = fis.read(buffer)) != -1)
//                    byteArrayOutputStream.write(buffer, 0, count);
//
//            }

            for (Map.Entry <String,ByteArrayOutputStream> pair: archivedFiles.entrySet()) {
                String name = Paths.get(pair.getKey()).getFileName().toString();
                if (name.equals(Paths.get(fileP).getFileName().toString())) {
                    zipOut.putNextEntry(new ZipEntry(pair.getKey()));
                Files.copy(Paths.get(fileP), zipOut);
                }
                else {
                    zipOut.putNextEntry(new ZipEntry(pair.getKey()));
                    zipOut.write(pair.getValue().toByteArray());
                }
            }

//            if (archivedFiles.containsKey(Paths.get(fileP).getFileName().toString())) {
//                bytesQ.set(index, Files.readAllBytes(fileP));
//            }
//            else {
//                zipOut.putNextEntry(new ZipEntry(fileP.getFileName().toString()));
//                Files.copy(fileP, zipOut);
//            }
//            for (int i = 0; i < bytesQ.size() ; i++) {
//                zipOut.putNextEntry(new ZipEntry(entriesQ.get(i)));
//                zipOut.write(bytesQ.get(i));
//
//
//            }
        }



    }
}
