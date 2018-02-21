package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private  FileInputStream component;
    @Override
    public int read() throws IOException {
        return this.component.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return this.component.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return this.component.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return this.component.skip(n);
    }

    @Override
    public int available() throws IOException {
        return this.component.available();
    }

    @Override
    public void close() throws IOException {
        super.close();
        this.component.close();
    }


    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
        super(fileName);


            if(fileName.endsWith(".txt")) {
                this.component = new FileInputStream(fileName);
            }
            else {
                super.close();
                throw new UnsupportedFileNameException();}




    }

    public static void main(String[] args) throws UnsupportedFileNameException, IOException {
        new TxtInputStream("/home/artem/java_error_in_IDEA_3490.log");
    }
}

