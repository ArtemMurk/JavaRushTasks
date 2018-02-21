package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        byte[] byteBuffer = args[2].getBytes();

        if (randomAccessFile.length()<Long.parseLong(args[1])){
            randomAccessFile.seek(randomAccessFile.length());
        } else randomAccessFile.seek(Integer.parseInt(args[1]));

        randomAccessFile.write(byteBuffer);
        randomAccessFile.close();
    }
}
