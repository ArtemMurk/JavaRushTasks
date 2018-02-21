package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {


    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        randomAccessFile.seek(Long.parseLong(args[1]));
        int lengthOfTextInArgs = args[2].length();
        byte[] bufferOfreadTextFromFile  =new byte[lengthOfTextInArgs];

        randomAccessFile.read(bufferOfreadTextFromFile,0,lengthOfTextInArgs);
        String textFromFile = convertByteToString(bufferOfreadTextFromFile);

        randomAccessFile.seek(randomAccessFile.length());
        if (textFromFile.equals(args[2])) randomAccessFile.write("true".getBytes());
        else randomAccessFile.write("false".getBytes());

        randomAccessFile.close();
    }

    private static String convertByteToString(byte readBytes[]) {
        String string = new String(readBytes, StandardCharsets.UTF_8);
        return string;
    }
}
