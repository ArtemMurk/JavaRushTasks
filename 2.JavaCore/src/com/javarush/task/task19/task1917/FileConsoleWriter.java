package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String var1) throws IOException  {
        fileWriter = new FileWriter(var1);
    }

    public FileConsoleWriter(String var1, boolean var2) throws IOException  {
        fileWriter = new FileWriter(var1, var2);
    }

    public FileConsoleWriter(File var1) throws IOException  {
        fileWriter = new FileWriter(var1);
    }

    public FileConsoleWriter(File var1, boolean var2) throws IOException  {
        fileWriter = new FileWriter(var1, var2);
    }

    public FileConsoleWriter(FileDescriptor var1) throws IOException  {
        fileWriter = new FileWriter(var1);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i <(off+len) ; i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException{
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, len+off));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (int i = 0; i <cbuf.length ; i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void close() throws IOException{
        fileWriter.close();
    }



    public static void main(String[] args) {

    }

}
