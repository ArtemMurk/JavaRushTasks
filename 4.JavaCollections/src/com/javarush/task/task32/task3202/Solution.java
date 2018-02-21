package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/home/artem/test/dfile1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is == null) return writer;

        byte[] buffer = new byte[1024];
        int lengthBuffer;
        while ((lengthBuffer = is.read(buffer))>0){
            writer.write(new String(buffer, Charset.defaultCharset()),0,lengthBuffer);
        }
        return writer;
    }
}