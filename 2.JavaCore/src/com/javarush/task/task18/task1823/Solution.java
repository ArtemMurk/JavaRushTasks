package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String fileName = reader.readLine();
            if (fileName.equals("exit")) break;
            new ReadThread(fileName).start();
        }

        for (Map.Entry<String, Integer> mapte: resultMap.entrySet()) {
            System.out.println(mapte.getKey()+" "+ mapte.getValue());
        }
    }

    public static class ReadThread extends Thread  {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;


            //implement constructor body
        }

        @Override
        public void run()  {
            try {

                FileInputStream fileIn = new FileInputStream(fileName);
                int maxByte=0;
                int readByte;
                int[] bytes = new int[256];

                while (fileIn.available()>0){
                readByte = fileIn.read();
                bytes[readByte]++;
                }

                for (int i = 1; i < bytes.length ; i++) {
                    if (bytes[maxByte] < bytes[i]){
                        maxByte = i;
                    }
                }

                fileIn.close();
                resultMap.put(fileName,maxByte);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
