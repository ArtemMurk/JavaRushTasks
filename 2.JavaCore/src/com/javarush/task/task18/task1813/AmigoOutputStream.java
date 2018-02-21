package com.javarush.task.task18.task1813;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    private FileOutputStream component;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        component = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int i) throws IOException {
        component.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        component.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        component.write(bytes, i, i1);
    }

    public void close() throws IOException {
        component.flush();
        component.write("JavaRush © All rights reserved.".getBytes());
        component.close();
    }
    public void getBytes() {
        System.out.println("JavaRush © All rights reserved.");
    }

    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
