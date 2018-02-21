package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, byte[]> mapBuffer = new TreeMap<>();
        String fileNew=null;

        while(true){
            String filePart=reader.readLine();
            if (filePart.equals("end")) break;
            String[] split = filePart.split(".part");
            fileNew = split[0];

                    FileInputStream file = new FileInputStream(filePart);
            byte[] buffer = new byte[file.available()];
            while (file.available()>0) {
                file.read(buffer);
            }
            mapBuffer.put(Integer.parseInt(split[1]), buffer);
            file.close();

        }

        new File(fileNew);

        FileOutputStream fileOut= new FileOutputStream(fileNew);
        for (Map.Entry<Integer, byte[]> mapOut: mapBuffer.entrySet()){
            fileOut.write(mapOut.getValue());
        }
        fileOut.close();
        reader.close();
    }

}
